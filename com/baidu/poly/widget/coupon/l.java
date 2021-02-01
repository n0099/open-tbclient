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
/* loaded from: classes4.dex */
public class l extends FrameLayout {
    private boolean G;
    private View cqR;
    private ListView cqS;
    private PolyFrameLayout cqT;
    private ViewGroup cqU;
    private h cqV;
    private com.baidu.poly.widget.coupon.b cqW;
    private a.C0312a cqX;
    private com.baidu.poly.a.l.c cqY;
    private boolean cqZ;
    private Runnable cra;
    private List<a.C0312a> mData;

    /* loaded from: classes4.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            l lVar = l.this;
            lVar.cqY = com.baidu.poly.a.l.a.a(lVar.cqT, layoutParams, "加载中", -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.cqV != null) {
                l.this.cqV.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.cqV.d();
        }
    }

    /* loaded from: classes4.dex */
    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((a.C0312a) l.this.mData.get(i)).cqK == 1) {
                return;
            }
            l lVar = l.this;
            lVar.a((a.C0312a) lVar.mData.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements com.baidu.poly.a.k.a {
        final /* synthetic */ a.C0312a cqQ;

        /* loaded from: classes4.dex */
        class a implements View.OnClickListener {
            final /* synthetic */ com.baidu.poly.widget.c cqO;

            a(com.baidu.poly.widget.c cVar) {
                this.cqO = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.cqO.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        class b implements c.b {
            b() {
            }

            @Override // com.baidu.poly.widget.c.b
            public void onDismiss() {
                l.this.cqV.b();
            }
        }

        e(a.C0312a c0312a) {
            this.cqQ = c0312a;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0305a c0305a) {
            l.this.cqT.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.cra);
            com.baidu.poly.a.l.a.a(l.this.cqY);
            l.this.cqY = null;
            if (c0305a != null) {
                int i = c0305a.statusCode;
                if (i == 0) {
                    for (a.C0312a c0312a : l.this.mData) {
                        if (c0312a == this.cqQ) {
                            l.this.cqX = c0312a;
                            c0312a.cqK = 1;
                        } else {
                            c0312a.cqK = 0;
                        }
                    }
                    l.this.cqW.notifyDataSetChanged();
                    l.this.cqV.d();
                } else if (i == 1) {
                    View inflate = View.inflate(l.this.getContext(), b.f.default_pop_window, null);
                    com.baidu.poly.widget.c cVar = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                    ((TextView) inflate.findViewById(b.e.pop_tips)).setText(c0305a.message);
                    ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new a(cVar));
                    cVar.a(new b());
                    cVar.showAtLocation(l.this, 0, 0, 0);
                } else {
                    Toast.makeText(l.this.getContext(), l.this.getResources().getString(b.g.coupon_calculate_error), 0).show();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    class f implements Animator.AnimatorListener {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.cqZ = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    class g implements Animator.AnimatorListener {
        g() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.cqZ = false;
            l.this.detach();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a(a.C0312a c0312a, com.baidu.poly.a.k.a aVar);

        void b();

        void d();

        void onDetach();
    }

    public l(Context context) {
        this(context, null);
    }

    private void adK() {
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
            h hVar = this.cqV;
            if (hVar != null) {
                hVar.onDetach();
            }
            com.baidu.poly.util.d.info("CouponListView->detach()");
        }
    }

    public boolean onBackPressed() {
        h hVar;
        if (!this.cqZ && this.G && (hVar = this.cqV) != null) {
            hVar.d();
        }
        return true;
    }

    public void setListener(h hVar) {
        this.cqV = hVar;
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_list, (ViewGroup) this, true);
        this.cqT = (PolyFrameLayout) findViewById(b.e.root_layout);
        this.cqU = (ViewGroup) findViewById(b.e.coupon_layout);
        this.cqS = (ListView) findViewById(b.e.coupon_list_layout);
        this.cqR = findViewById(b.e.back);
        this.cqR.setOnClickListener(new b());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.G = false;
        this.cqZ = false;
        this.cra = new a();
        c(context);
    }

    public void b(View view) {
        if (view != null && !this.cqZ && this.G) {
            this.cqZ = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getMeasuredWidth() * (-1), 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cqU, "translationX", 0.0f, view.getMeasuredWidth());
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new g());
        }
    }

    public void a(List<a.C0312a> list) {
        this.mData = list;
        if (this.cqW == null) {
            this.cqW = new com.baidu.poly.widget.coupon.b(getContext());
        }
        this.cqS.setAdapter((ListAdapter) this.cqW);
        this.cqW.b(this.mData);
        List<a.C0312a> list2 = this.mData;
        if (list2 != null && list2.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mData.size()) {
                    break;
                } else if (this.mData.get(i2).cqK == 1) {
                    this.cqX = this.mData.get(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            this.cqS.setOnItemClickListener(new d());
        } else if (this.cqV == null || !this.G) {
        } else {
            postDelayed(new c(), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0312a c0312a) {
        if (this.cqV != null) {
            this.cqT.a(true);
            postDelayed(this.cra, 500L);
            this.cqV.a(c0312a, new e(c0312a));
        }
    }

    public void a(int i) {
        this.cqT.getLayoutParams().height = i;
        adK();
    }

    public void a(View view) {
        if (view != null && !this.cqZ && this.G) {
            this.cqZ = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getMeasuredWidth() * (-1));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cqU, "translationX", view.getMeasuredWidth(), 0.0f);
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new f());
        }
    }
}
