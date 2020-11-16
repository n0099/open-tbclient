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
    private View cdH;
    private ListView cdI;
    private PolyFrameLayout cdJ;
    private ViewGroup cdK;
    private h cdL;
    private com.baidu.poly.widget.coupon.b cdM;
    private a.C0314a cdN;
    private com.baidu.poly.a.l.c cdO;
    private boolean cdP;
    private Runnable cdQ;
    private List<a.C0314a> mData;

    /* loaded from: classes6.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            l lVar = l.this;
            lVar.cdO = com.baidu.poly.a.l.a.a(lVar.cdJ, layoutParams, "加载中", -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.cdL != null) {
                l.this.cdL.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.cdL.d();
        }
    }

    /* loaded from: classes6.dex */
    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((a.C0314a) l.this.mData.get(i)).cf == 1) {
                return;
            }
            l lVar = l.this;
            lVar.a((a.C0314a) lVar.mData.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements com.baidu.poly.a.k.a {
        final /* synthetic */ a.C0314a cdG;

        /* loaded from: classes6.dex */
        class a implements View.OnClickListener {
            final /* synthetic */ com.baidu.poly.widget.c cdE;

            a(com.baidu.poly.widget.c cVar) {
                this.cdE = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.cdE.dismiss();
            }
        }

        /* loaded from: classes6.dex */
        class b implements c.b {
            b() {
            }

            @Override // com.baidu.poly.widget.c.b
            public void onDismiss() {
                l.this.cdL.b();
            }
        }

        e(a.C0314a c0314a) {
            this.cdG = c0314a;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0307a c0307a) {
            l.this.cdJ.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.cdQ);
            com.baidu.poly.a.l.a.a(l.this.cdO);
            l.this.cdO = null;
            if (c0307a != null) {
                int i = c0307a.statusCode;
                if (i == 0) {
                    for (a.C0314a c0314a : l.this.mData) {
                        if (c0314a == this.cdG) {
                            l.this.cdN = c0314a;
                            c0314a.cf = 1;
                        } else {
                            c0314a.cf = 0;
                        }
                    }
                    l.this.cdM.notifyDataSetChanged();
                    l.this.cdL.d();
                } else if (i == 1) {
                    View inflate = View.inflate(l.this.getContext(), b.f.default_pop_window, null);
                    com.baidu.poly.widget.c cVar = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                    ((TextView) inflate.findViewById(b.e.pop_tips)).setText(c0307a.message);
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
            l.this.cdP = false;
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
            l.this.cdP = false;
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
        void a(a.C0314a c0314a, com.baidu.poly.a.k.a aVar);

        void b();

        void d();

        void onDetach();
    }

    public l(Context context) {
        this(context, null);
    }

    private void aaM() {
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
            h hVar = this.cdL;
            if (hVar != null) {
                hVar.onDetach();
            }
            com.baidu.poly.util.d.info("CouponListView->detach()");
        }
    }

    public boolean onBackPressed() {
        h hVar;
        if (!this.cdP && this.G && (hVar = this.cdL) != null) {
            hVar.d();
        }
        return true;
    }

    public void setListener(h hVar) {
        this.cdL = hVar;
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_list, (ViewGroup) this, true);
        this.cdJ = (PolyFrameLayout) findViewById(b.e.root_layout);
        this.cdK = (ViewGroup) findViewById(b.e.coupon_layout);
        this.cdI = (ListView) findViewById(b.e.coupon_list_layout);
        this.cdH = findViewById(b.e.back);
        this.cdH.setOnClickListener(new b());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.G = false;
        this.cdP = false;
        this.cdQ = new a();
        c(context);
    }

    public void b(View view) {
        if (view != null && !this.cdP && this.G) {
            this.cdP = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getMeasuredWidth() * (-1), 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cdK, "translationX", 0.0f, view.getMeasuredWidth());
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new g());
        }
    }

    public void a(List<a.C0314a> list) {
        this.mData = list;
        if (this.cdM == null) {
            this.cdM = new com.baidu.poly.widget.coupon.b(getContext());
        }
        this.cdI.setAdapter((ListAdapter) this.cdM);
        this.cdM.b(this.mData);
        List<a.C0314a> list2 = this.mData;
        if (list2 != null && list2.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mData.size()) {
                    break;
                } else if (this.mData.get(i2).cf == 1) {
                    this.cdN = this.mData.get(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            this.cdI.setOnItemClickListener(new d());
        } else if (this.cdL == null || !this.G) {
        } else {
            postDelayed(new c(), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0314a c0314a) {
        if (this.cdL != null) {
            this.cdJ.a(true);
            postDelayed(this.cdQ, 500L);
            this.cdL.a(c0314a, new e(c0314a));
        }
    }

    public void a(int i) {
        this.cdJ.getLayoutParams().height = i;
        aaM();
    }

    public void a(View view) {
        if (view != null && !this.cdP && this.G) {
            this.cdP = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getMeasuredWidth() * (-1));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cdK, "translationX", view.getMeasuredWidth(), 0.0f);
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new f());
        }
    }
}
