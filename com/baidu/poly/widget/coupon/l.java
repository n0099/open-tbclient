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
/* loaded from: classes11.dex */
public class l extends FrameLayout {
    private boolean D;
    private View bCD;
    private ListView bCE;
    private PolyFrameLayout bCF;
    private ViewGroup bCG;
    private h bCH;
    private com.baidu.poly.widget.coupon.b bCI;
    private a.C0253a bCJ;
    private com.baidu.poly.a.k.c bCK;
    private boolean bCL;
    private Runnable bCM;
    private List<a.C0253a> mData;

    /* loaded from: classes11.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            l lVar = l.this;
            lVar.bCK = com.baidu.poly.a.k.a.a(lVar.bCF, layoutParams, "加载中", -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.bCH != null) {
                l.this.bCH.d();
            }
        }
    }

    /* loaded from: classes11.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.bCH.d();
        }
    }

    /* loaded from: classes11.dex */
    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((a.C0253a) l.this.mData.get(i)).bCw == 1) {
                return;
            }
            l lVar = l.this;
            lVar.a((a.C0253a) lVar.mData.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class e implements com.baidu.poly.a.j.a {
        final /* synthetic */ a.C0253a bCC;

        /* loaded from: classes11.dex */
        class a implements View.OnClickListener {
            final /* synthetic */ com.baidu.poly.widget.c bCA;

            a(com.baidu.poly.widget.c cVar) {
                this.bCA = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.bCA.dismiss();
            }
        }

        /* loaded from: classes11.dex */
        class b implements c.b {
            b() {
            }

            @Override // com.baidu.poly.widget.c.b
            public void onDismiss() {
                l.this.bCH.b();
            }
        }

        e(a.C0253a c0253a) {
            this.bCC = c0253a;
        }

        @Override // com.baidu.poly.a.j.a
        public void a(a.C0246a c0246a) {
            l.this.bCF.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.bCM);
            com.baidu.poly.a.k.a.a(l.this.bCK);
            l.this.bCK = null;
            if (c0246a != null) {
                int i = c0246a.statusCode;
                if (i == 0) {
                    for (a.C0253a c0253a : l.this.mData) {
                        if (c0253a == this.bCC) {
                            l.this.bCJ = c0253a;
                            c0253a.bCw = 1;
                        } else {
                            c0253a.bCw = 0;
                        }
                    }
                    l.this.bCI.notifyDataSetChanged();
                    l.this.bCH.d();
                } else if (i == 1) {
                    View inflate = View.inflate(l.this.getContext(), b.f.default_pop_window, null);
                    com.baidu.poly.widget.c cVar = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                    ((TextView) inflate.findViewById(b.e.pop_tips)).setText(c0246a.message);
                    ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new a(cVar));
                    cVar.a(new b());
                    cVar.showAtLocation(l.this, 0, 0, 0);
                } else {
                    Toast.makeText(l.this.getContext(), l.this.getResources().getString(b.g.coupon_calculate_error), 0).show();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    class f implements Animator.AnimatorListener {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.bCL = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes11.dex */
    class g implements Animator.AnimatorListener {
        g() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.bCL = false;
            l.this.detach();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes11.dex */
    public interface h {
        void a(a.C0253a c0253a, com.baidu.poly.a.j.a aVar);

        void b();

        void d();

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
            h hVar = this.bCH;
            if (hVar != null) {
                hVar.onDetach();
            }
            com.baidu.poly.util.d.info("CouponListView->detach()");
        }
    }

    public boolean onBackPressed() {
        h hVar;
        if (!this.bCL && this.D && (hVar = this.bCH) != null) {
            hVar.d();
        }
        return true;
    }

    public void setListener(h hVar) {
        this.bCH = hVar;
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_list, (ViewGroup) this, true);
        this.bCF = (PolyFrameLayout) findViewById(b.e.root_layout);
        this.bCG = (ViewGroup) findViewById(b.e.coupon_layout);
        this.bCE = (ListView) findViewById(b.e.coupon_list_layout);
        this.bCD = findViewById(b.e.back);
        this.bCD.setOnClickListener(new b());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    private void e() {
        if (!this.D) {
            this.D = true;
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
        this.D = false;
        this.bCL = false;
        this.bCM = new a();
        c(context);
    }

    public void b(View view) {
        if (view != null && !this.bCL && this.D) {
            this.bCL = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getMeasuredWidth() * (-1), 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bCG, "translationX", 0.0f, view.getMeasuredWidth());
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new g());
        }
    }

    public void a(List<a.C0253a> list) {
        this.mData = list;
        if (this.bCI == null) {
            this.bCI = new com.baidu.poly.widget.coupon.b(getContext());
        }
        this.bCE.setAdapter((ListAdapter) this.bCI);
        this.bCI.b(this.mData);
        List<a.C0253a> list2 = this.mData;
        if (list2 != null && list2.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mData.size()) {
                    break;
                } else if (this.mData.get(i2).bCw == 1) {
                    this.bCJ = this.mData.get(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            this.bCE.setOnItemClickListener(new d());
        } else if (this.bCH == null || !this.D) {
        } else {
            postDelayed(new c(), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0253a c0253a) {
        if (this.bCH != null) {
            this.bCF.a(true);
            postDelayed(this.bCM, 500L);
            this.bCH.a(c0253a, new e(c0253a));
        }
    }

    public void a(int i) {
        this.bCF.getLayoutParams().height = i;
        e();
    }

    public void a(View view) {
        if (view != null && !this.bCL && this.D) {
            this.bCL = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getMeasuredWidth() * (-1));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bCG, "translationX", view.getMeasuredWidth(), 0.0f);
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new f());
        }
    }
}
