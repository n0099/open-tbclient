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
    private ListView bIA;
    private PolyFrameLayout bIB;
    private ViewGroup bIC;
    private h bID;
    private com.baidu.poly.widget.coupon.b bIE;
    private a.C0277a bIF;
    private com.baidu.poly.a.l.c bIG;
    private boolean bIH;
    private Runnable bII;
    private View bIz;
    private List<a.C0277a> mData;

    /* loaded from: classes6.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            l lVar = l.this;
            lVar.bIG = com.baidu.poly.a.l.a.a(lVar.bIB, layoutParams, "加载中", -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.bID != null) {
                l.this.bID.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.bID.d();
        }
    }

    /* loaded from: classes6.dex */
    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((a.C0277a) l.this.mData.get(i)).cf == 1) {
                return;
            }
            l lVar = l.this;
            lVar.a((a.C0277a) lVar.mData.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements com.baidu.poly.a.k.a {
        final /* synthetic */ a.C0277a bIy;

        /* loaded from: classes6.dex */
        class a implements View.OnClickListener {
            final /* synthetic */ com.baidu.poly.widget.c bIw;

            a(com.baidu.poly.widget.c cVar) {
                this.bIw = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.bIw.dismiss();
            }
        }

        /* loaded from: classes6.dex */
        class b implements c.b {
            b() {
            }

            @Override // com.baidu.poly.widget.c.b
            public void onDismiss() {
                l.this.bID.b();
            }
        }

        e(a.C0277a c0277a) {
            this.bIy = c0277a;
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0270a c0270a) {
            l.this.bIB.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.bII);
            com.baidu.poly.a.l.a.a(l.this.bIG);
            l.this.bIG = null;
            if (c0270a != null) {
                int i = c0270a.statusCode;
                if (i == 0) {
                    for (a.C0277a c0277a : l.this.mData) {
                        if (c0277a == this.bIy) {
                            l.this.bIF = c0277a;
                            c0277a.cf = 1;
                        } else {
                            c0277a.cf = 0;
                        }
                    }
                    l.this.bIE.notifyDataSetChanged();
                    l.this.bID.d();
                } else if (i == 1) {
                    View inflate = View.inflate(l.this.getContext(), b.f.default_pop_window, null);
                    com.baidu.poly.widget.c cVar = new com.baidu.poly.widget.c(inflate, -1, -1, true);
                    ((TextView) inflate.findViewById(b.e.pop_tips)).setText(c0270a.message);
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
            l.this.bIH = false;
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
            l.this.bIH = false;
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
        void a(a.C0277a c0277a, com.baidu.poly.a.k.a aVar);

        void b();

        void d();

        void onDetach();
    }

    public l(Context context) {
        this(context, null);
    }

    private void Uw() {
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
            h hVar = this.bID;
            if (hVar != null) {
                hVar.onDetach();
            }
            com.baidu.poly.util.d.info("CouponListView->detach()");
        }
    }

    public boolean onBackPressed() {
        h hVar;
        if (!this.bIH && this.G && (hVar = this.bID) != null) {
            hVar.d();
        }
        return true;
    }

    public void setListener(h hVar) {
        this.bID = hVar;
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_list, (ViewGroup) this, true);
        this.bIB = (PolyFrameLayout) findViewById(b.e.root_layout);
        this.bIC = (ViewGroup) findViewById(b.e.coupon_layout);
        this.bIA = (ListView) findViewById(b.e.coupon_list_layout);
        this.bIz = findViewById(b.e.back);
        this.bIz.setOnClickListener(new b());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.G = false;
        this.bIH = false;
        this.bII = new a();
        c(context);
    }

    public void b(View view) {
        if (view != null && !this.bIH && this.G) {
            this.bIH = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getMeasuredWidth() * (-1), 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bIC, "translationX", 0.0f, view.getMeasuredWidth());
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new g());
        }
    }

    public void a(List<a.C0277a> list) {
        this.mData = list;
        if (this.bIE == null) {
            this.bIE = new com.baidu.poly.widget.coupon.b(getContext());
        }
        this.bIA.setAdapter((ListAdapter) this.bIE);
        this.bIE.b(this.mData);
        List<a.C0277a> list2 = this.mData;
        if (list2 != null && list2.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mData.size()) {
                    break;
                } else if (this.mData.get(i2).cf == 1) {
                    this.bIF = this.mData.get(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            this.bIA.setOnItemClickListener(new d());
        } else if (this.bID == null || !this.G) {
        } else {
            postDelayed(new c(), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0277a c0277a) {
        if (this.bID != null) {
            this.bIB.a(true);
            postDelayed(this.bII, 500L);
            this.bID.a(c0277a, new e(c0277a));
        }
    }

    public void a(int i) {
        this.bIB.getLayoutParams().height = i;
        Uw();
    }

    public void a(View view) {
        if (view != null && !this.bIH && this.G) {
            this.bIH = true;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getMeasuredWidth() * (-1));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bIC, "translationX", view.getMeasuredWidth(), 0.0f);
            animatorSet.setDuration(160L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new f());
        }
    }
}
