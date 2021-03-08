package com.baidu.poly.widget.coupon;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.poly.a.k.a;
import com.baidu.poly.b;
import com.baidu.poly.widget.PolyFrameLayout;
import com.baidu.poly.widget.c;
import com.baidu.poly.widget.coupon.a;
import java.util.List;
/* loaded from: classes14.dex */
public class l extends FrameLayout {
    private boolean G;
    private boolean csA;
    private Runnable csB;
    private View css;
    private ListView cst;
    private PolyFrameLayout csu;
    private ViewGroup csv;
    private h csw;
    private com.baidu.poly.widget.coupon.b csx;
    private a.C0318a csy;
    private com.baidu.poly.a.l.c csz;
    private List<a.C0318a> mData;

    /* loaded from: classes14.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            l lVar = l.this;
            lVar.csz = com.baidu.poly.a.l.a.a(lVar.csu, layoutParams, "加载中", -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.csw != null) {
                l.this.csw.d();
            }
        }
    }

    /* loaded from: classes14.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.csw.d();
        }
    }

    /* loaded from: classes14.dex */
    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((a.C0318a) l.this.mData.get(i)).csl == 1) {
                return;
            }
            l lVar = l.this;
            lVar.a((a.C0318a) lVar.mData.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class e implements com.baidu.poly.a.k.a {
        final /* synthetic */ a.C0318a csr;

        /* loaded from: classes14.dex */
        class a implements View.OnClickListener {
            final /* synthetic */ com.baidu.poly.widget.c csp;

            a(com.baidu.poly.widget.c cVar) {
                this.csp = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.csp.dismiss();
            }
        }

        /* loaded from: classes14.dex */
        class b implements c.b {
            b() {
            }

            @Override // com.baidu.poly.widget.c.b
            public void onDismiss() {
                l.this.csw.b();
            }
        }

        e(a.C0318a c0318a) {
            this.csr = c0318a;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0311a c0311a) {
            l.this.csu.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.csB);
            com.baidu.poly.a.l.a.a(l.this.csz);
            l.this.csz = null;
            if (c0311a != null) {
                int i = c0311a.statusCode;
                if (i == 0) {
                    for (a.C0318a c0318a : l.this.mData) {
                        if (c0318a == this.csr) {
                            l.this.csy = c0318a;
                            c0318a.csl = 1;
                        } else {
                            c0318a.csl = 0;
                        }
                    }
                    l.this.csx.notifyDataSetChanged();
                    l.this.csw.d();
                } else if (i == 1) {
                    View inflate = View.inflate(l.this.getContext(), b.f.default_pop_window, null);
                    com.baidu.poly.widget.c cVar = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                    ((TextView) inflate.findViewById(b.e.pop_tips)).setText(c0311a.message);
                    ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new a(cVar));
                    cVar.a(new b());
                    cVar.showAtLocation(l.this, 0, 0, 0);
                } else {
                    Toast.makeText(l.this.getContext(), l.this.getResources().getString(b.g.coupon_calculate_error), 0).show();
                }
            }
        }
    }

    /* loaded from: classes14.dex */
    class f implements Animator.AnimatorListener {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.csA = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes14.dex */
    class g implements Animator.AnimatorListener {
        g() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.csA = false;
            l.this.detach();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes14.dex */
    public interface h {
        void a(a.C0318a c0318a, com.baidu.poly.a.k.a aVar);

        void b();

        void d();

        void onDetach();
    }

    public l(Context context) {
        this(context, null);
    }

    private void adN() {
        if (!this.G) {
            this.G = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            View decorView = ((Activity) getContext()).getWindow().getDecorView();
            if (decorView instanceof ViewGroup) {
                ((ViewGroup) decorView).addView(this);
            }
            com.baidu.poly.util.d.info("CouponListView->attach()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detach() {
        if (this.G) {
            this.G = false;
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
            }
            h hVar = this.csw;
            if (hVar != null) {
                hVar.onDetach();
            }
            com.baidu.poly.util.d.info("CouponListView->detach()");
        }
    }

    public boolean onBackPressed() {
        h hVar;
        if (!this.csA && this.G && (hVar = this.csw) != null) {
            hVar.d();
        }
        return true;
    }

    public void setListener(h hVar) {
        this.csw = hVar;
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_list, (ViewGroup) this, true);
        this.csu = (PolyFrameLayout) findViewById(b.e.root_layout);
        this.csv = (ViewGroup) findViewById(b.e.coupon_layout);
        this.cst = (ListView) findViewById(b.e.coupon_list_layout);
        this.css = findViewById(b.e.back);
        this.css.setOnClickListener(new b());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.G = false;
        this.csA = false;
        this.csB = new a();
        c(context);
    }

    public void b(View view) {
        if (view != null && !this.csA && this.G) {
            this.csA = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getMeasuredWidth() * (-1), 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.csv, "translationX", 0.0f, view.getMeasuredWidth());
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new g());
        }
    }

    public void a(List<a.C0318a> list) {
        this.mData = list;
        if (this.csx == null) {
            this.csx = new com.baidu.poly.widget.coupon.b(getContext());
        }
        this.cst.setAdapter((ListAdapter) this.csx);
        this.csx.b(this.mData);
        List<a.C0318a> list2 = this.mData;
        if (list2 != null && list2.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mData.size()) {
                    break;
                } else if (this.mData.get(i2).csl == 1) {
                    this.csy = this.mData.get(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            this.cst.setOnItemClickListener(new d());
        } else if (this.csw == null || !this.G) {
        } else {
            postDelayed(new c(), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0318a c0318a) {
        if (this.csw != null) {
            this.csu.a(true);
            postDelayed(this.csB, 500L);
            this.csw.a(c0318a, new e(c0318a));
        }
    }

    public void a(int i) {
        this.csu.getLayoutParams().height = i;
        adN();
    }

    public void a(View view) {
        if (view != null && !this.csA && this.G) {
            this.csA = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getMeasuredWidth() * (-1));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.csv, "translationX", view.getMeasuredWidth(), 0.0f);
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new f());
        }
    }
}
