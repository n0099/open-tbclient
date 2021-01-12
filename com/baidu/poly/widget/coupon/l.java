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
/* loaded from: classes3.dex */
public class l extends FrameLayout {
    private boolean G;
    private ListView cmA;
    private PolyFrameLayout cmB;
    private ViewGroup cmC;
    private h cmD;
    private com.baidu.poly.widget.coupon.b cmE;
    private a.C0308a cmF;
    private com.baidu.poly.a.l.c cmG;
    private boolean cmH;
    private Runnable cmI;
    private View cmz;
    private List<a.C0308a> mData;

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            l lVar = l.this;
            lVar.cmG = com.baidu.poly.a.l.a.a(lVar.cmB, layoutParams, "加载中", -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.cmD != null) {
                l.this.cmD.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.cmD.d();
        }
    }

    /* loaded from: classes3.dex */
    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((a.C0308a) l.this.mData.get(i)).cms == 1) {
                return;
            }
            l lVar = l.this;
            lVar.a((a.C0308a) lVar.mData.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements com.baidu.poly.a.k.a {
        final /* synthetic */ a.C0308a cmy;

        /* loaded from: classes3.dex */
        class a implements View.OnClickListener {
            final /* synthetic */ com.baidu.poly.widget.c cmw;

            a(com.baidu.poly.widget.c cVar) {
                this.cmw = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.cmw.dismiss();
            }
        }

        /* loaded from: classes3.dex */
        class b implements c.b {
            b() {
            }

            @Override // com.baidu.poly.widget.c.b
            public void onDismiss() {
                l.this.cmD.b();
            }
        }

        e(a.C0308a c0308a) {
            this.cmy = c0308a;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0301a c0301a) {
            l.this.cmB.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.cmI);
            com.baidu.poly.a.l.a.a(l.this.cmG);
            l.this.cmG = null;
            if (c0301a != null) {
                int i = c0301a.statusCode;
                if (i == 0) {
                    for (a.C0308a c0308a : l.this.mData) {
                        if (c0308a == this.cmy) {
                            l.this.cmF = c0308a;
                            c0308a.cms = 1;
                        } else {
                            c0308a.cms = 0;
                        }
                    }
                    l.this.cmE.notifyDataSetChanged();
                    l.this.cmD.d();
                } else if (i == 1) {
                    View inflate = View.inflate(l.this.getContext(), b.f.default_pop_window, null);
                    com.baidu.poly.widget.c cVar = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                    ((TextView) inflate.findViewById(b.e.pop_tips)).setText(c0301a.message);
                    ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new a(cVar));
                    cVar.a(new b());
                    cVar.showAtLocation(l.this, 0, 0, 0);
                } else {
                    Toast.makeText(l.this.getContext(), l.this.getResources().getString(b.g.coupon_calculate_error), 0).show();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class f implements Animator.AnimatorListener {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.cmH = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    class g implements Animator.AnimatorListener {
        g() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.cmH = false;
            l.this.detach();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a(a.C0308a c0308a, com.baidu.poly.a.k.a aVar);

        void b();

        void d();

        void onDetach();
    }

    public l(Context context) {
        this(context, null);
    }

    private void abW() {
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
            h hVar = this.cmD;
            if (hVar != null) {
                hVar.onDetach();
            }
            com.baidu.poly.util.d.info("CouponListView->detach()");
        }
    }

    public boolean onBackPressed() {
        h hVar;
        if (!this.cmH && this.G && (hVar = this.cmD) != null) {
            hVar.d();
        }
        return true;
    }

    public void setListener(h hVar) {
        this.cmD = hVar;
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_list, (ViewGroup) this, true);
        this.cmB = (PolyFrameLayout) findViewById(b.e.root_layout);
        this.cmC = (ViewGroup) findViewById(b.e.coupon_layout);
        this.cmA = (ListView) findViewById(b.e.coupon_list_layout);
        this.cmz = findViewById(b.e.back);
        this.cmz.setOnClickListener(new b());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.G = false;
        this.cmH = false;
        this.cmI = new a();
        c(context);
    }

    public void b(View view) {
        if (view != null && !this.cmH && this.G) {
            this.cmH = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getMeasuredWidth() * (-1), 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cmC, "translationX", 0.0f, view.getMeasuredWidth());
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new g());
        }
    }

    public void a(List<a.C0308a> list) {
        this.mData = list;
        if (this.cmE == null) {
            this.cmE = new com.baidu.poly.widget.coupon.b(getContext());
        }
        this.cmA.setAdapter((ListAdapter) this.cmE);
        this.cmE.b(this.mData);
        List<a.C0308a> list2 = this.mData;
        if (list2 != null && list2.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mData.size()) {
                    break;
                } else if (this.mData.get(i2).cms == 1) {
                    this.cmF = this.mData.get(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            this.cmA.setOnItemClickListener(new d());
        } else if (this.cmD == null || !this.G) {
        } else {
            postDelayed(new c(), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0308a c0308a) {
        if (this.cmD != null) {
            this.cmB.a(true);
            postDelayed(this.cmI, 500L);
            this.cmD.a(c0308a, new e(c0308a));
        }
    }

    public void a(int i) {
        this.cmB.getLayoutParams().height = i;
        abW();
    }

    public void a(View view) {
        if (view != null && !this.cmH && this.G) {
            this.cmH = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getMeasuredWidth() * (-1));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cmC, "translationX", view.getMeasuredWidth(), 0.0f);
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new f());
        }
    }
}
