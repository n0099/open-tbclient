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
import com.baidu.poly.a.j.a;
import com.baidu.poly.b;
import com.baidu.poly.widget.PolyFrameLayout;
import com.baidu.poly.widget.c;
import com.baidu.poly.widget.coupon.a;
import java.util.List;
/* loaded from: classes9.dex */
public class l extends FrameLayout {
    private boolean D;
    private View aOB;
    private ListView aOC;
    private PolyFrameLayout aOD;
    private ViewGroup aOE;
    private h aOF;
    private com.baidu.poly.widget.coupon.b aOG;
    private a.C0157a aOH;
    private com.baidu.poly.a.k.c aOI;
    private boolean aOJ;
    private Runnable aOK;
    private List<a.C0157a> mData;

    /* loaded from: classes9.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            l lVar = l.this;
            lVar.aOI = com.baidu.poly.a.k.a.a(lVar.aOD, layoutParams, "加载中", -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.aOF != null) {
                l.this.aOF.c();
            }
        }
    }

    /* loaded from: classes9.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.aOF.c();
        }
    }

    /* loaded from: classes9.dex */
    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((a.C0157a) l.this.mData.get(i)).aOt == 1) {
                return;
            }
            l lVar = l.this;
            lVar.a((a.C0157a) lVar.mData.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class e implements com.baidu.poly.a.j.a {
        final /* synthetic */ a.C0157a aOA;

        /* loaded from: classes9.dex */
        class a implements View.OnClickListener {
            final /* synthetic */ com.baidu.poly.widget.c aOy;

            a(com.baidu.poly.widget.c cVar) {
                this.aOy = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.aOy.dismiss();
            }
        }

        /* loaded from: classes9.dex */
        class b implements c.b {
            b() {
            }

            @Override // com.baidu.poly.widget.c.b
            public void onDismiss() {
                l.this.aOF.b();
            }
        }

        e(a.C0157a c0157a) {
            this.aOA = c0157a;
        }

        @Override // com.baidu.poly.a.j.a
        public void a(a.C0150a c0150a) {
            l.this.aOD.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.aOK);
            com.baidu.poly.a.k.a.a(l.this.aOI);
            l.this.aOI = null;
            if (c0150a != null) {
                int i = c0150a.statusCode;
                if (i == 0) {
                    for (a.C0157a c0157a : l.this.mData) {
                        if (c0157a == this.aOA) {
                            l.this.aOH = c0157a;
                            c0157a.aOt = 1;
                        } else {
                            c0157a.aOt = 0;
                        }
                    }
                    l.this.aOG.notifyDataSetChanged();
                    l.this.aOF.c();
                } else if (i == 1) {
                    View inflate = View.inflate(l.this.getContext(), b.f.default_pop_window, null);
                    com.baidu.poly.widget.c cVar = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                    ((TextView) inflate.findViewById(b.e.pop_tips)).setText(c0150a.message);
                    ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new a(cVar));
                    cVar.a(new b());
                    cVar.showAtLocation(l.this, 0, 0, 0);
                } else {
                    Toast.makeText(l.this.getContext(), l.this.getResources().getString(b.g.coupon_calculate_error), 0).show();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    class f implements Animator.AnimatorListener {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.aOJ = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes9.dex */
    class g implements Animator.AnimatorListener {
        g() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.aOJ = false;
            l.this.detach();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes9.dex */
    public interface h {
        void a(a.C0157a c0157a, com.baidu.poly.a.j.a aVar);

        void b();

        void c();

        void onDetach();
    }

    public l(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detach() {
        if (this.D) {
            this.D = false;
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
            }
            h hVar = this.aOF;
            if (hVar != null) {
                hVar.onDetach();
            }
            com.baidu.poly.util.c.info("CouponListView->detach()");
        }
    }

    public boolean onBackPressed() {
        h hVar;
        if (!this.aOJ && this.D && (hVar = this.aOF) != null) {
            hVar.c();
        }
        return true;
    }

    public void setListener(h hVar) {
        this.aOF = hVar;
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_list, (ViewGroup) this, true);
        this.aOD = (PolyFrameLayout) findViewById(b.e.root_layout);
        this.aOE = (ViewGroup) findViewById(b.e.coupon_layout);
        this.aOC = (ListView) findViewById(b.e.coupon_list_layout);
        this.aOB = findViewById(b.e.back);
        this.aOB.setOnClickListener(new b());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    private void d() {
        if (!this.D) {
            this.D = true;
            if (!(getContext() instanceof Activity)) {
                throw new IllegalStateException("can not attach to context " + getContext());
            }
            View decorView = ((Activity) getContext()).getWindow().getDecorView();
            if (decorView instanceof ViewGroup) {
                ((ViewGroup) decorView).addView(this);
            }
            com.baidu.poly.util.c.info("CouponListView->attach()");
        }
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.D = false;
        this.aOJ = false;
        this.aOK = new a();
        c(context);
    }

    public void b(View view) {
        if (view != null && !this.aOJ && this.D) {
            this.aOJ = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getMeasuredWidth() * (-1), 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aOE, "translationX", 0.0f, view.getMeasuredWidth());
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new g());
        }
    }

    public void a(List<a.C0157a> list) {
        this.mData = list;
        if (this.aOG == null) {
            this.aOG = new com.baidu.poly.widget.coupon.b(getContext());
        }
        this.aOC.setAdapter((ListAdapter) this.aOG);
        this.aOG.b(this.mData);
        List<a.C0157a> list2 = this.mData;
        if (list2 != null && list2.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mData.size()) {
                    break;
                } else if (this.mData.get(i2).aOt == 1) {
                    this.aOH = this.mData.get(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            this.aOC.setOnItemClickListener(new d());
        } else if (this.aOF == null || !this.D) {
        } else {
            postDelayed(new c(), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0157a c0157a) {
        if (this.aOF != null) {
            this.aOD.a(true);
            postDelayed(this.aOK, 500L);
            this.aOF.a(c0157a, new e(c0157a));
        }
    }

    public void a(int i) {
        this.aOD.getLayoutParams().height = i;
        d();
    }

    public void a(View view) {
        if (view != null && !this.aOJ && this.D) {
            this.aOJ = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getMeasuredWidth() * (-1));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aOE, "translationX", view.getMeasuredWidth(), 0.0f);
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new f());
        }
    }
}
