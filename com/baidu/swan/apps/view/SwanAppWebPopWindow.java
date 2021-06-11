package com.baidu.swan.apps.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppWebPopPullLayout;
import com.baidu.swan.menu.PopupWindow;
import d.a.l0.a.g;
import d.a.l0.a.k;
import d.a.l0.a.p.e.e;
import d.a.l0.a.v2.f;
import d.a.l0.a.v2.n0;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwanAppWebPopWindow extends PopupWindow implements SwanAppWebPopPullLayout.c, View.OnClickListener {
    public static final boolean p0 = k.f46875a;
    public static CloseStyle q0;
    public SwanAppActivity U;
    public final FrameLayout V;
    public View W;
    public SwanAppWebPopPullLayout X;
    public RelativeLayout Y;
    public int Z;
    public FrameLayout a0;
    public e b0;
    public d.a.l0.a.p.e.c c0;
    public final d.a.l0.a.w2.h.c d0;
    public boolean e0;
    public int f0;
    public final String g0;
    public String h0;
    public ImageView i0;
    public boolean j0;
    public boolean k0;
    public float l0;
    public float m0;
    public int n0;
    public int o0;

    /* loaded from: classes3.dex */
    public enum CloseStyle {
        CLOSE_AT_RIGHT,
        CLOSE_AT_BOTTOM,
        CLOSE_AT_BOTH
    }

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (f.d(SwanAppWebPopWindow.this.U)) {
                SwanAppWebPopWindow.super.r();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SwanAppWebPopPullLayout.b {
        public b() {
        }

        @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.b
        public boolean a(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                SwanAppWebPopWindow.this.k0 = false;
                if (SwanAppWebPopWindow.this.X.d()) {
                    return true;
                }
                SwanAppWebPopWindow.this.m0 = motionEvent.getRawX();
                SwanAppWebPopWindow.this.l0 = motionEvent.getRawY();
            } else if (action == 2) {
                if (SwanAppWebPopWindow.this.X.d()) {
                    return true;
                }
                int scaledTouchSlop = ViewConfiguration.get(SwanAppWebPopWindow.this.U).getScaledTouchSlop();
                float rawY = motionEvent.getRawY() - SwanAppWebPopWindow.this.l0;
                float rawX = motionEvent.getRawX() - SwanAppWebPopWindow.this.m0;
                if (!SwanAppWebPopWindow.this.k0 && Math.abs(rawY) > scaledTouchSlop) {
                    SwanAppWebPopWindow.this.k0 = true;
                }
                if (SwanAppWebPopWindow.this.k0) {
                    if (SwanAppWebPopWindow.this.a0 != null && SwanAppWebPopWindow.this.a0.getChildAt(0) != null && SwanAppWebPopWindow.this.a0.getChildAt(0).getTop() == 0 && SwanAppWebPopWindow.this.c0.getWebViewScrollY() == 0 && motionEvent.getRawY() - SwanAppWebPopWindow.this.l0 > 0.0f) {
                        return true;
                    }
                    SwanAppWebPopWindow.this.m0 = motionEvent.getRawX();
                    SwanAppWebPopWindow.this.l0 = motionEvent.getRawY();
                }
                if (Math.abs(rawX) > Math.abs(rawY)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.l0.a.h0.j.a {

        /* renamed from: c  reason: collision with root package name */
        public boolean f11430c = false;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.j.d f11431d;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppWebPopWindow.this.a0.removeAllViews();
                SwanAppWebPopWindow swanAppWebPopWindow = SwanAppWebPopWindow.this;
                swanAppWebPopWindow.b0.l(swanAppWebPopWindow.a0, SwanAppWebPopWindow.this.c0.covertToView());
                SwanAppWebPopWindow swanAppWebPopWindow2 = SwanAppWebPopWindow.this;
                swanAppWebPopWindow2.b0.loadUrl(swanAppWebPopWindow2.g0);
            }
        }

        public c(d.a.l0.a.h0.j.d dVar) {
            this.f11431d = dVar;
        }

        @Override // d.a.l0.a.h0.j.a, d.a.l0.a.h0.j.d
        public void b(int i2) {
            this.f11430c = true;
            d.a.l0.a.h0.j.d dVar = this.f11431d;
            if (dVar != null) {
                dVar.b(i2);
            }
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(SwanAppWebPopWindow.this.U).inflate(g.aiapps_server_request_error_view, (ViewGroup) null);
            linearLayout.setBackgroundColor(-1);
            linearLayout.findViewById(d.a.l0.a.f.empty_btn_reload).setOnClickListener(new a());
            SwanAppWebPopWindow.this.a0.addView(linearLayout);
        }

        @Override // d.a.l0.a.h0.j.a, d.a.l0.a.h0.j.d
        public void d(int i2, String str, String str2) {
            this.f11430c = true;
            d.a.l0.a.h0.j.d dVar = this.f11431d;
            if (dVar != null) {
                dVar.d(i2, str, str2);
            }
        }

        @Override // d.a.l0.a.h0.j.a, d.a.l0.a.h0.j.d
        public void e(String str) {
            if (this.f11430c) {
                return;
            }
            this.f11430c = false;
            d.a.l0.a.h0.j.d dVar = this.f11431d;
            if (dVar != null) {
                dVar.e(str);
            }
            SwanAppWebPopWindow.this.n0++;
            if (SwanAppWebPopWindow.this.j0 || SwanAppWebPopWindow.this.n0 <= 1 || !SwanAppWebPopWindow.this.c0.canGoBack()) {
                SwanAppWebPopWindow.this.i0.setVisibility(8);
            } else {
                SwanAppWebPopWindow.this.i0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11434a;

        static {
            int[] iArr = new int[CloseStyle.values().length];
            f11434a = iArr;
            try {
                iArr[CloseStyle.CLOSE_AT_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11434a[CloseStyle.CLOSE_AT_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SwanAppWebPopWindow(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity);
        this.Z = 0;
        this.e0 = true;
        this.f0 = 0;
        if (p0) {
            Log.d("SwanAppWebPopWindow", "is used");
        }
        this.U = swanAppActivity;
        this.g0 = str;
        this.d0 = new d.a.l0.a.w2.h.c();
        q0 = CloseStyle.CLOSE_AT_RIGHT;
        this.n0 = 0;
        G(false);
        I(true);
        M(true);
        F(new ColorDrawable(0));
        O(-1);
        J(-1);
        if (Build.VERSION.SDK_INT > 29) {
            K(true);
        }
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.U).inflate(g.aiapps_half_web_pop_window, (ViewGroup) null);
        this.V = frameLayout;
        frameLayout.measure(0, 0);
        H(this.V);
    }

    public final void A0() {
        this.X.setInterceptCallback(new b());
    }

    public SwanAppWebPopWindow B0(int i2) {
        if (this.U == null) {
            this.U = d.a.l0.a.g1.f.V().getActivity();
        }
        this.h0 = this.U.getString(i2);
        return this;
    }

    public SwanAppWebPopWindow C0(String str) {
        this.h0 = str;
        return this;
    }

    public void D0() {
        if (x()) {
            return;
        }
        if (this.U == null) {
            this.U = d.a.l0.a.g1.f.V().getActivity();
        }
        View decorView = this.U.getWindow().getDecorView();
        m0();
        if (this.e0) {
            I(false);
        }
        Q(decorView, 81, 0, 0);
        if (this.e0) {
            v().setSystemUiVisibility(this.f0 | 1024 | 4096);
            I(true);
            S();
        }
        E0();
    }

    public final void E0() {
        this.W.setAlpha(0.0f);
        this.X.setTranslationY(this.Z);
        ObjectAnimator c2 = d.a.l0.a.t.b.c(this.W);
        ObjectAnimator a2 = d.a.l0.a.t.b.a(this.X);
        ArrayList arrayList = new ArrayList();
        arrayList.add(c2);
        arrayList.add(a2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void a() {
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void b() {
        if (x()) {
            r();
        }
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void c() {
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void d(float f2) {
        this.W.getBackground().setAlpha((int) ((1.0f - f2) * 153.0f));
    }

    public void m0() {
        d.a.l0.a.w2.h.c cVar = this.d0;
        if (cVar != null) {
            cVar.b(this.Y);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.a.l0.a.f.left_back_view) {
            this.n0--;
            if (this.c0.canGoBack()) {
                this.c0.goBack();
                if (this.n0 <= 1) {
                    this.i0.setVisibility(8);
                    return;
                }
                return;
            }
            r();
        } else if (id == d.a.l0.a.f.aiapps_half_screen_close_icon) {
            r();
        } else if (id == d.a.l0.a.f.cancel_button) {
            r();
        } else if (id == d.a.l0.a.f.mask) {
            r();
        }
    }

    public final void p0() {
        if (x()) {
            ObjectAnimator b2 = d.a.l0.a.t.b.b(this.W);
            ObjectAnimator d2 = d.a.l0.a.t.b.d(this.X, this.Z);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new a());
            animatorSet.playTogether(b2, d2);
            animatorSet.start();
        }
    }

    public final e q0(SwanAppActivity swanAppActivity) {
        return d.a.l0.a.h0.u.g.N().X().g(swanAppActivity);
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void r() {
        p0();
    }

    public final d.a.l0.a.h0.j.d s0(d.a.l0.a.h0.j.d dVar) {
        return new c(dVar);
    }

    public final void t0() {
        ImageView imageView = (ImageView) this.V.findViewById(d.a.l0.a.f.left_back_view);
        this.i0 = imageView;
        imageView.setOnClickListener(this);
        ((TextView) this.V.findViewById(d.a.l0.a.f.aiapps_half_screen_title)).setText(this.h0);
        ImageView imageView2 = (ImageView) this.V.findViewById(d.a.l0.a.f.aiapps_half_screen_close_icon);
        imageView2.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.V.findViewById(d.a.l0.a.f.btn_close);
        TextView textView = (TextView) this.V.findViewById(d.a.l0.a.f.cancel_button);
        textView.setBackgroundColor(-1);
        textView.setOnClickListener(this);
        int i2 = d.f11434a[q0.ordinal()];
        if (i2 == 1) {
            imageView2.setVisibility(8);
        } else if (i2 != 2) {
        } else {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX WARN: Type inference failed for: r0v26, types: [d.a.l0.a.p.e.c] */
    public final void v0() {
        int n = n0.n(d.a.l0.a.c1.a.b());
        int i2 = (int) (n * 0.68d);
        this.Z = i2;
        int i3 = this.o0;
        if (i3 > n) {
            this.Z = n;
        } else if (i2 < i3) {
            this.Z = i3;
        }
        this.X = (SwanAppWebPopPullLayout) this.V.findViewById(d.a.l0.a.f.aiapps_half_web_pop_window_body);
        this.Y = (RelativeLayout) this.V.findViewById(d.a.l0.a.f.aiapps_half_web_inner_layout);
        this.X.setFitsSystemWindows(true);
        this.X.setOnClickListener(this);
        ViewGroup.LayoutParams layoutParams = this.X.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        layoutParams.height = this.Z;
        this.X.setLayoutParams(layoutParams);
        this.X.setCallback(this);
        A0();
        FrameLayout frameLayout = (FrameLayout) this.V.findViewById(d.a.l0.a.f.half_screen_container);
        this.a0 = frameLayout;
        frameLayout.setBackgroundColor(-1);
        this.a0.setOverScrollMode(2);
        int dimensionPixelSize = this.Z - this.U.getResources().getDimensionPixelSize(d.a.l0.a.d.swan_half_screen_action_bar_height);
        if (q0 == CloseStyle.CLOSE_AT_BOTTOM || q0 == CloseStyle.CLOSE_AT_BOTH) {
            dimensionPixelSize -= this.U.getResources().getDimensionPixelSize(d.a.l0.a.d.swan_half_screen_bottom_btn_height);
        }
        ViewGroup.LayoutParams layoutParams2 = this.a0.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        }
        layoutParams2.height = dimensionPixelSize;
        this.a0.setLayoutParams(layoutParams2);
        e q02 = q0(this.U);
        this.b0 = q02;
        q02.Z(s0(new d.a.l0.a.h0.j.a()));
        this.c0 = this.b0.u();
        this.b0.loadUrl(this.g0);
        this.b0.l(this.a0, this.c0.covertToView());
    }

    @SuppressLint({"InflateParams"})
    public SwanAppWebPopWindow w0() {
        View findViewById = this.V.findViewById(d.a.l0.a.f.mask);
        this.W = findViewById;
        findViewById.getBackground().setAlpha(153);
        this.W.setOnClickListener(this);
        v0();
        t0();
        return this;
    }

    public SwanAppWebPopWindow x0(CloseStyle closeStyle) {
        q0 = closeStyle;
        return this;
    }

    public SwanAppWebPopWindow y0() {
        ImageView imageView = (ImageView) this.V.findViewById(d.a.l0.a.f.aiapps_half_screen_icon);
        imageView.setImageDrawable(imageView.getResources().getDrawable(d.a.l0.a.e.swan_app_apply_guarantee_new));
        imageView.setVisibility(0);
        return this;
    }

    public SwanAppWebPopWindow z0(int i2) {
        this.o0 = i2;
        return this;
    }
}
