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
/* loaded from: classes19.dex */
public class l extends FrameLayout {
    private boolean G;
    private View ckm;
    private ListView ckn;
    private PolyFrameLayout cko;
    private ViewGroup ckp;
    private h ckq;
    private com.baidu.poly.widget.coupon.b ckr;
    private a.C0325a cks;
    private com.baidu.poly.a.l.c ckt;
    private boolean cku;
    private Runnable ckv;
    private List<a.C0325a> mData;

    /* loaded from: classes19.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            l lVar = l.this;
            lVar.ckt = com.baidu.poly.a.l.a.a(lVar.cko, layoutParams, "加载中", -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.ckq != null) {
                l.this.ckq.d();
            }
        }
    }

    /* loaded from: classes19.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.ckq.d();
        }
    }

    /* loaded from: classes19.dex */
    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((a.C0325a) l.this.mData.get(i)).cke == 1) {
                return;
            }
            l lVar = l.this;
            lVar.a((a.C0325a) lVar.mData.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class e implements com.baidu.poly.a.k.a {
        final /* synthetic */ a.C0325a ckl;

        /* loaded from: classes19.dex */
        class a implements View.OnClickListener {
            final /* synthetic */ com.baidu.poly.widget.c ckj;

            a(com.baidu.poly.widget.c cVar) {
                this.ckj = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.ckj.dismiss();
            }
        }

        /* loaded from: classes19.dex */
        class b implements c.b {
            b() {
            }

            @Override // com.baidu.poly.widget.c.b
            public void onDismiss() {
                l.this.ckq.b();
            }
        }

        e(a.C0325a c0325a) {
            this.ckl = c0325a;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0318a c0318a) {
            l.this.cko.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.ckv);
            com.baidu.poly.a.l.a.a(l.this.ckt);
            l.this.ckt = null;
            if (c0318a != null) {
                int i = c0318a.statusCode;
                if (i == 0) {
                    for (a.C0325a c0325a : l.this.mData) {
                        if (c0325a == this.ckl) {
                            l.this.cks = c0325a;
                            c0325a.cke = 1;
                        } else {
                            c0325a.cke = 0;
                        }
                    }
                    l.this.ckr.notifyDataSetChanged();
                    l.this.ckq.d();
                } else if (i == 1) {
                    View inflate = View.inflate(l.this.getContext(), b.f.default_pop_window, null);
                    com.baidu.poly.widget.c cVar = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                    ((TextView) inflate.findViewById(b.e.pop_tips)).setText(c0318a.message);
                    ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new a(cVar));
                    cVar.a(new b());
                    cVar.showAtLocation(l.this, 0, 0, 0);
                } else {
                    Toast.makeText(l.this.getContext(), l.this.getResources().getString(b.g.coupon_calculate_error), 0).show();
                }
            }
        }
    }

    /* loaded from: classes19.dex */
    class f implements Animator.AnimatorListener {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.cku = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes19.dex */
    class g implements Animator.AnimatorListener {
        g() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.cku = false;
            l.this.detach();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes19.dex */
    public interface h {
        void a(a.C0325a c0325a, com.baidu.poly.a.k.a aVar);

        void b();

        void d();

        void onDetach();
    }

    public l(Context context) {
        this(context, null);
    }

    private void adU() {
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
            h hVar = this.ckq;
            if (hVar != null) {
                hVar.onDetach();
            }
            com.baidu.poly.util.d.info("CouponListView->detach()");
        }
    }

    public boolean onBackPressed() {
        h hVar;
        if (!this.cku && this.G && (hVar = this.ckq) != null) {
            hVar.d();
        }
        return true;
    }

    public void setListener(h hVar) {
        this.ckq = hVar;
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_list, (ViewGroup) this, true);
        this.cko = (PolyFrameLayout) findViewById(b.e.root_layout);
        this.ckp = (ViewGroup) findViewById(b.e.coupon_layout);
        this.ckn = (ListView) findViewById(b.e.coupon_list_layout);
        this.ckm = findViewById(b.e.back);
        this.ckm.setOnClickListener(new b());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.G = false;
        this.cku = false;
        this.ckv = new a();
        c(context);
    }

    public void b(View view) {
        if (view != null && !this.cku && this.G) {
            this.cku = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getMeasuredWidth() * (-1), 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ckp, "translationX", 0.0f, view.getMeasuredWidth());
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new g());
        }
    }

    public void a(List<a.C0325a> list) {
        this.mData = list;
        if (this.ckr == null) {
            this.ckr = new com.baidu.poly.widget.coupon.b(getContext());
        }
        this.ckn.setAdapter((ListAdapter) this.ckr);
        this.ckr.b(this.mData);
        List<a.C0325a> list2 = this.mData;
        if (list2 != null && list2.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mData.size()) {
                    break;
                } else if (this.mData.get(i2).cke == 1) {
                    this.cks = this.mData.get(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            this.ckn.setOnItemClickListener(new d());
        } else if (this.ckq == null || !this.G) {
        } else {
            postDelayed(new c(), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0325a c0325a) {
        if (this.ckq != null) {
            this.cko.a(true);
            postDelayed(this.ckv, 500L);
            this.ckq.a(c0325a, new e(c0325a));
        }
    }

    public void a(int i) {
        this.cko.getLayoutParams().height = i;
        adU();
    }

    public void a(View view) {
        if (view != null && !this.cku && this.G) {
            this.cku = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getMeasuredWidth() * (-1));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ckp, "translationX", view.getMeasuredWidth(), 0.0f);
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new f());
        }
    }
}
