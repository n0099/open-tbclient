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
    private View bZG;
    private ListView bZH;
    private PolyFrameLayout bZI;
    private ViewGroup bZJ;
    private h bZK;
    private com.baidu.poly.widget.coupon.b bZL;
    private a.C0304a bZM;
    private com.baidu.poly.a.l.c bZN;
    private boolean bZO;
    private Runnable bZP;
    private List<a.C0304a> mData;

    /* loaded from: classes6.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            l lVar = l.this;
            lVar.bZN = com.baidu.poly.a.l.a.a(lVar.bZI, layoutParams, "加载中", -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.bZK != null) {
                l.this.bZK.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.bZK.d();
        }
    }

    /* loaded from: classes6.dex */
    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((a.C0304a) l.this.mData.get(i)).cf == 1) {
                return;
            }
            l lVar = l.this;
            lVar.a((a.C0304a) lVar.mData.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements com.baidu.poly.a.k.a {
        final /* synthetic */ a.C0304a bZF;

        /* loaded from: classes6.dex */
        class a implements View.OnClickListener {
            final /* synthetic */ com.baidu.poly.widget.c bZD;

            a(com.baidu.poly.widget.c cVar) {
                this.bZD = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.bZD.dismiss();
            }
        }

        /* loaded from: classes6.dex */
        class b implements c.b {
            b() {
            }

            @Override // com.baidu.poly.widget.c.b
            public void onDismiss() {
                l.this.bZK.b();
            }
        }

        e(a.C0304a c0304a) {
            this.bZF = c0304a;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0297a c0297a) {
            l.this.bZI.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.bZP);
            com.baidu.poly.a.l.a.a(l.this.bZN);
            l.this.bZN = null;
            if (c0297a != null) {
                int i = c0297a.statusCode;
                if (i == 0) {
                    for (a.C0304a c0304a : l.this.mData) {
                        if (c0304a == this.bZF) {
                            l.this.bZM = c0304a;
                            c0304a.cf = 1;
                        } else {
                            c0304a.cf = 0;
                        }
                    }
                    l.this.bZL.notifyDataSetChanged();
                    l.this.bZK.d();
                } else if (i == 1) {
                    View inflate = View.inflate(l.this.getContext(), b.f.default_pop_window, null);
                    com.baidu.poly.widget.c cVar = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                    ((TextView) inflate.findViewById(b.e.pop_tips)).setText(c0297a.message);
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
            l.this.bZO = false;
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
            l.this.bZO = false;
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
        void a(a.C0304a c0304a, com.baidu.poly.a.k.a aVar);

        void b();

        void d();

        void onDetach();
    }

    public l(Context context) {
        this(context, null);
    }

    private void YW() {
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
            h hVar = this.bZK;
            if (hVar != null) {
                hVar.onDetach();
            }
            com.baidu.poly.util.d.info("CouponListView->detach()");
        }
    }

    public boolean onBackPressed() {
        h hVar;
        if (!this.bZO && this.G && (hVar = this.bZK) != null) {
            hVar.d();
        }
        return true;
    }

    public void setListener(h hVar) {
        this.bZK = hVar;
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_list, (ViewGroup) this, true);
        this.bZI = (PolyFrameLayout) findViewById(b.e.root_layout);
        this.bZJ = (ViewGroup) findViewById(b.e.coupon_layout);
        this.bZH = (ListView) findViewById(b.e.coupon_list_layout);
        this.bZG = findViewById(b.e.back);
        this.bZG.setOnClickListener(new b());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.G = false;
        this.bZO = false;
        this.bZP = new a();
        c(context);
    }

    public void b(View view) {
        if (view != null && !this.bZO && this.G) {
            this.bZO = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getMeasuredWidth() * (-1), 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bZJ, "translationX", 0.0f, view.getMeasuredWidth());
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new g());
        }
    }

    public void a(List<a.C0304a> list) {
        this.mData = list;
        if (this.bZL == null) {
            this.bZL = new com.baidu.poly.widget.coupon.b(getContext());
        }
        this.bZH.setAdapter((ListAdapter) this.bZL);
        this.bZL.b(this.mData);
        List<a.C0304a> list2 = this.mData;
        if (list2 != null && list2.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mData.size()) {
                    break;
                } else if (this.mData.get(i2).cf == 1) {
                    this.bZM = this.mData.get(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            this.bZH.setOnItemClickListener(new d());
        } else if (this.bZK == null || !this.G) {
        } else {
            postDelayed(new c(), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0304a c0304a) {
        if (this.bZK != null) {
            this.bZI.a(true);
            postDelayed(this.bZP, 500L);
            this.bZK.a(c0304a, new e(c0304a));
        }
    }

    public void a(int i) {
        this.bZI.getLayoutParams().height = i;
        YW();
    }

    public void a(View view) {
        if (view != null && !this.bZO && this.G) {
            this.bZO = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getMeasuredWidth() * (-1));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bZJ, "translationX", view.getMeasuredWidth(), 0.0f);
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new f());
        }
    }
}
