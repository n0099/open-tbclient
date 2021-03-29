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
import com.baidu.poly.widget.PolyFrameLayout;
import d.b.c0.k.j.a;
import d.b.c0.p.a.a;
import d.b.c0.p.c;
import java.util.List;
/* loaded from: classes2.dex */
public class l extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f10457e;

    /* renamed from: f  reason: collision with root package name */
    public ListView f10458f;

    /* renamed from: g  reason: collision with root package name */
    public PolyFrameLayout f10459g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f10460h;
    public boolean i;
    public h j;
    public d.b.c0.p.a.b k;
    public List<a.C0573a> l;
    public a.C0573a m;
    public com.baidu.poly.a.l.c n;
    public boolean o;
    public Runnable p;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            l lVar = l.this;
            lVar.n = d.b.c0.k.k.a.a(lVar.f10459g, layoutParams, "加载中", -1L);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.j != null) {
                l.this.j.d();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.j.d();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((a.C0573a) l.this.l.get(i)).f42692g == 1) {
                return;
            }
            l lVar = l.this;
            lVar.e((a.C0573a) lVar.l.get(i));
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.c0.k.j.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C0573a f10465a;

        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.c0.p.c f10467e;

            public a(e eVar, d.b.c0.p.c cVar) {
                this.f10467e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f10467e.q();
            }
        }

        /* loaded from: classes2.dex */
        public class b implements c.b {
            public b() {
            }

            @Override // d.b.c0.p.c.b
            public void onDismiss() {
                l.this.j.b();
            }
        }

        public e(a.C0573a c0573a) {
            this.f10465a = c0573a;
        }

        @Override // d.b.c0.k.j.a
        public void a(a.C0570a c0570a) {
            l.this.f10459g.a(false);
            l lVar = l.this;
            lVar.removeCallbacks(lVar.p);
            d.b.c0.k.k.a.c(l.this.n);
            l.this.n = null;
            if (c0570a == null) {
                return;
            }
            int i = c0570a.f42666a;
            if (i == 0) {
                for (a.C0573a c0573a : l.this.l) {
                    if (c0573a == this.f10465a) {
                        l.this.m = c0573a;
                        c0573a.f42692g = 1;
                    } else {
                        c0573a.f42692g = 0;
                    }
                }
                l.this.k.notifyDataSetChanged();
                l.this.j.d();
            } else if (i == 1) {
                View inflate = View.inflate(l.this.getContext(), d.b.c0.g.default_pop_window, null);
                d.b.c0.p.c cVar = new d.b.c0.p.c(inflate, -1, -1, true);
                ((TextView) inflate.findViewById(d.b.c0.f.pop_tips)).setText(c0570a.f42667b);
                ((TextView) inflate.findViewById(d.b.c0.f.pop_button)).setOnClickListener(new a(this, cVar));
                cVar.h(new b());
                cVar.E(l.this, 0, 0, 0);
            } else {
                Toast.makeText(l.this.getContext(), l.this.getResources().getString(d.b.c0.h.coupon_calculate_error), 0).show();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Animator.AnimatorListener {
        public f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.o = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Animator.AnimatorListener {
        public g() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.o = false;
            l.this.o();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes2.dex */
    public interface h {
        void a(a.C0573a c0573a, d.b.c0.k.j.a aVar);

        void b();

        void d();

        void onDetach();
    }

    public l(Context context) {
        this(context, null);
    }

    public void c(int i) {
        this.f10459g.getLayoutParams().height = i;
        s();
    }

    public void d(View view) {
        if (view == null || this.o || !this.i) {
            return;
        }
        this.o = true;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getMeasuredWidth() * (-1));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f10460h, "translationX", view.getMeasuredWidth(), 0.0f);
        animatorSet.setDuration(160L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new f());
    }

    public final void e(a.C0573a c0573a) {
        if (this.j == null) {
            return;
        }
        this.f10459g.a(true);
        postDelayed(this.p, 500L);
        this.j.a(c0573a, new e(c0573a));
    }

    public void g(List<a.C0573a> list) {
        this.l = list;
        if (this.k == null) {
            this.k = new d.b.c0.p.a.b(getContext());
        }
        this.f10458f.setAdapter((ListAdapter) this.k);
        this.k.a(this.l);
        List<a.C0573a> list2 = this.l;
        if (list2 != null && list2.size() > 0) {
            int i = 0;
            while (true) {
                if (i >= this.l.size()) {
                    break;
                } else if (this.l.get(i).f42692g == 1) {
                    this.l.get(i);
                    break;
                } else {
                    i++;
                }
            }
            this.f10458f.setOnItemClickListener(new d());
        } else if (this.j == null || !this.i) {
        } else {
            postDelayed(new c(), 100L);
        }
    }

    public void k(View view) {
        if (view == null || this.o || !this.i) {
            return;
        }
        this.o = true;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getMeasuredWidth() * (-1), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f10460h, "translationX", 0.0f, view.getMeasuredWidth());
        animatorSet.setDuration(160L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new g());
    }

    public final void m(Context context) {
        LayoutInflater.from(context).inflate(d.b.c0.g.coupon_list, (ViewGroup) this, true);
        this.f10459g = (PolyFrameLayout) findViewById(d.b.c0.f.root_layout);
        this.f10460h = (ViewGroup) findViewById(d.b.c0.f.coupon_layout);
        this.f10458f = (ListView) findViewById(d.b.c0.f.coupon_list_layout);
        View findViewById = findViewById(d.b.c0.f.back);
        this.f10457e = findViewById;
        findViewById.setOnClickListener(new b());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public final void o() {
        if (this.i) {
            this.i = false;
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
            }
            h hVar = this.j;
            if (hVar != null) {
                hVar.onDetach();
            }
            d.b.c0.n.d.e("CouponListView->detach()");
        }
    }

    public final void s() {
        if (this.i) {
            return;
        }
        this.i = true;
        if (getContext() instanceof Activity) {
            View decorView = ((Activity) getContext()).getWindow().getDecorView();
            if (decorView instanceof ViewGroup) {
                ((ViewGroup) decorView).addView(this);
            }
            d.b.c0.n.d.e("CouponListView->attach()");
            return;
        }
        throw new IllegalStateException("can not attach to context " + getContext());
    }

    public void setListener(h hVar) {
        this.j = hVar;
    }

    public boolean t() {
        h hVar;
        if (!this.o && this.i && (hVar = this.j) != null) {
            hVar.d();
        }
        return true;
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = false;
        this.o = false;
        this.p = new a();
        m(context);
    }
}
