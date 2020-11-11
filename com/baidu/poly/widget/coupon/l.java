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
/* loaded from: classes6.dex */
public class l extends FrameLayout {
    private boolean G;
    private boolean cfA;
    private Runnable cfB;
    private View cfs;
    private ListView cft;
    private PolyFrameLayout cfu;
    private ViewGroup cfv;
    private h cfw;
    private com.baidu.poly.widget.coupon.b cfx;
    private a.C0316a cfy;
    private com.baidu.poly.a.l.c cfz;
    private List<a.C0316a> mData;

    /* loaded from: classes6.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            l lVar = l.this;
            lVar.cfz = com.baidu.poly.a.l.a.a(lVar.cfu, layoutParams, "加载中", -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.cfw != null) {
                l.this.cfw.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.cfw.d();
        }
    }

    /* loaded from: classes6.dex */
    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((a.C0316a) l.this.mData.get(i)).cf == 1) {
                return;
            }
            l lVar = l.this;
            lVar.a((a.C0316a) lVar.mData.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements com.baidu.poly.a.k.a {
        final /* synthetic */ a.C0316a cfr;

        /* loaded from: classes6.dex */
        class a implements View.OnClickListener {
            final /* synthetic */ com.baidu.poly.widget.c cfp;

            a(com.baidu.poly.widget.c cVar) {
                this.cfp = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.cfp.dismiss();
            }
        }

        /* loaded from: classes6.dex */
        class b implements c.b {
            b() {
            }

            @Override // com.baidu.poly.widget.c.b
            public void onDismiss() {
                l.this.cfw.b();
            }
        }

        e(a.C0316a c0316a) {
            this.cfr = c0316a;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0309a c0309a) {
            l.this.cfu.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.cfB);
            com.baidu.poly.a.l.a.a(l.this.cfz);
            l.this.cfz = null;
            if (c0309a != null) {
                int i = c0309a.statusCode;
                if (i == 0) {
                    for (a.C0316a c0316a : l.this.mData) {
                        if (c0316a == this.cfr) {
                            l.this.cfy = c0316a;
                            c0316a.cf = 1;
                        } else {
                            c0316a.cf = 0;
                        }
                    }
                    l.this.cfx.notifyDataSetChanged();
                    l.this.cfw.d();
                } else if (i == 1) {
                    View inflate = View.inflate(l.this.getContext(), b.f.default_pop_window, null);
                    com.baidu.poly.widget.c cVar = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                    ((TextView) inflate.findViewById(b.e.pop_tips)).setText(c0309a.message);
                    ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new a(cVar));
                    cVar.a(new b());
                    cVar.showAtLocation(l.this, 0, 0, 0);
                } else {
                    Toast.makeText(l.this.getContext(), l.this.getResources().getString(b.g.coupon_calculate_error), 0).show();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    class f implements Animator.AnimatorListener {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.cfA = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes6.dex */
    class g implements Animator.AnimatorListener {
        g() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.cfA = false;
            l.this.detach();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes6.dex */
    public interface h {
        void a(a.C0316a c0316a, com.baidu.poly.a.k.a aVar);

        void b();

        void d();

        void onDetach();
    }

    public l(Context context) {
        this(context, null);
    }

    private void abv() {
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
            h hVar = this.cfw;
            if (hVar != null) {
                hVar.onDetach();
            }
            com.baidu.poly.util.d.info("CouponListView->detach()");
        }
    }

    public boolean onBackPressed() {
        h hVar;
        if (!this.cfA && this.G && (hVar = this.cfw) != null) {
            hVar.d();
        }
        return true;
    }

    public void setListener(h hVar) {
        this.cfw = hVar;
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_list, (ViewGroup) this, true);
        this.cfu = (PolyFrameLayout) findViewById(b.e.root_layout);
        this.cfv = (ViewGroup) findViewById(b.e.coupon_layout);
        this.cft = (ListView) findViewById(b.e.coupon_list_layout);
        this.cfs = findViewById(b.e.back);
        this.cfs.setOnClickListener(new b());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.G = false;
        this.cfA = false;
        this.cfB = new a();
        c(context);
    }

    public void b(View view) {
        if (view != null && !this.cfA && this.G) {
            this.cfA = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getMeasuredWidth() * (-1), 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cfv, "translationX", 0.0f, view.getMeasuredWidth());
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new g());
        }
    }

    public void a(List<a.C0316a> list) {
        this.mData = list;
        if (this.cfx == null) {
            this.cfx = new com.baidu.poly.widget.coupon.b(getContext());
        }
        this.cft.setAdapter((ListAdapter) this.cfx);
        this.cfx.b(this.mData);
        List<a.C0316a> list2 = this.mData;
        if (list2 != null && list2.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mData.size()) {
                    break;
                } else if (this.mData.get(i2).cf == 1) {
                    this.cfy = this.mData.get(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            this.cft.setOnItemClickListener(new d());
        } else if (this.cfw == null || !this.G) {
        } else {
            postDelayed(new c(), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0316a c0316a) {
        if (this.cfw != null) {
            this.cfu.a(true);
            postDelayed(this.cfB, 500L);
            this.cfw.a(c0316a, new e(c0316a));
        }
    }

    public void a(int i) {
        this.cfu.getLayoutParams().height = i;
        abv();
    }

    public void a(View view) {
        if (view != null && !this.cfA && this.G) {
            this.cfA = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getMeasuredWidth() * (-1));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cfv, "translationX", view.getMeasuredWidth(), 0.0f);
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new f());
        }
    }
}
