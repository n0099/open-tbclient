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
/* loaded from: classes9.dex */
public class l extends FrameLayout {
    private boolean F;
    private View bCV;
    private ListView bCW;
    private PolyFrameLayout bCX;
    private ViewGroup bCY;
    private h bCZ;
    private com.baidu.poly.widget.coupon.b bDa;
    private a.C0256a bDb;
    private com.baidu.poly.a.l.c bDc;
    private boolean bDd;
    private Runnable bDe;
    private List<a.C0256a> mData;

    /* loaded from: classes9.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            l lVar = l.this;
            lVar.bDc = com.baidu.poly.a.l.a.a(lVar.bCX, layoutParams, "加载中", -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.bCZ != null) {
                l.this.bCZ.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.bCZ.d();
        }
    }

    /* loaded from: classes9.dex */
    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((a.C0256a) l.this.mData.get(i)).bCN == 1) {
                return;
            }
            l lVar = l.this;
            lVar.a((a.C0256a) lVar.mData.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class e implements com.baidu.poly.a.k.a {
        final /* synthetic */ a.C0256a bCU;

        /* loaded from: classes9.dex */
        class a implements View.OnClickListener {
            final /* synthetic */ com.baidu.poly.widget.c bCS;

            a(com.baidu.poly.widget.c cVar) {
                this.bCS = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.bCS.dismiss();
            }
        }

        /* loaded from: classes9.dex */
        class b implements c.b {
            b() {
            }

            @Override // com.baidu.poly.widget.c.b
            public void onDismiss() {
                l.this.bCZ.b();
            }
        }

        e(a.C0256a c0256a) {
            this.bCU = c0256a;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0249a c0249a) {
            l.this.bCX.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.bDe);
            com.baidu.poly.a.l.a.a(l.this.bDc);
            l.this.bDc = null;
            if (c0249a != null) {
                int i = c0249a.statusCode;
                if (i == 0) {
                    for (a.C0256a c0256a : l.this.mData) {
                        if (c0256a == this.bCU) {
                            l.this.bDb = c0256a;
                            c0256a.bCN = 1;
                        } else {
                            c0256a.bCN = 0;
                        }
                    }
                    l.this.bDa.notifyDataSetChanged();
                    l.this.bCZ.d();
                } else if (i == 1) {
                    View inflate = View.inflate(l.this.getContext(), b.f.default_pop_window, null);
                    com.baidu.poly.widget.c cVar = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                    ((TextView) inflate.findViewById(b.e.pop_tips)).setText(c0249a.message);
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
            l.this.bDd = false;
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
            l.this.bDd = false;
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
        void a(a.C0256a c0256a, com.baidu.poly.a.k.a aVar);

        void b();

        void d();

        void onDetach();
    }

    public l(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detach() {
        if (this.F) {
            this.F = false;
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
            }
            h hVar = this.bCZ;
            if (hVar != null) {
                hVar.onDetach();
            }
            com.baidu.poly.util.d.info("CouponListView->detach()");
        }
    }

    public boolean onBackPressed() {
        h hVar;
        if (!this.bDd && this.F && (hVar = this.bCZ) != null) {
            hVar.d();
        }
        return true;
    }

    public void setListener(h hVar) {
        this.bCZ = hVar;
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_list, (ViewGroup) this, true);
        this.bCX = (PolyFrameLayout) findViewById(b.e.root_layout);
        this.bCY = (ViewGroup) findViewById(b.e.coupon_layout);
        this.bCW = (ListView) findViewById(b.e.coupon_list_layout);
        this.bCV = findViewById(b.e.back);
        this.bCV.setOnClickListener(new b());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    private void e() {
        if (!this.F) {
            this.F = true;
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

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = false;
        this.bDd = false;
        this.bDe = new a();
        c(context);
    }

    public void b(View view) {
        if (view != null && !this.bDd && this.F) {
            this.bDd = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getMeasuredWidth() * (-1), 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bCY, "translationX", 0.0f, view.getMeasuredWidth());
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new g());
        }
    }

    public void a(List<a.C0256a> list) {
        this.mData = list;
        if (this.bDa == null) {
            this.bDa = new com.baidu.poly.widget.coupon.b(getContext());
        }
        this.bCW.setAdapter((ListAdapter) this.bDa);
        this.bDa.b(this.mData);
        List<a.C0256a> list2 = this.mData;
        if (list2 != null && list2.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mData.size()) {
                    break;
                } else if (this.mData.get(i2).bCN == 1) {
                    this.bDb = this.mData.get(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            this.bCW.setOnItemClickListener(new d());
        } else if (this.bCZ == null || !this.F) {
        } else {
            postDelayed(new c(), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0256a c0256a) {
        if (this.bCZ != null) {
            this.bCX.a(true);
            postDelayed(this.bDe, 500L);
            this.bCZ.a(c0256a, new e(c0256a));
        }
    }

    public void a(int i) {
        this.bCX.getLayoutParams().height = i;
        e();
    }

    public void a(View view) {
        if (view != null && !this.bDd && this.F) {
            this.bDd = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getMeasuredWidth() * (-1));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bCY, "translationX", view.getMeasuredWidth(), 0.0f);
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new f());
        }
    }
}
