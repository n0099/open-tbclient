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
import com.baidu.tieba.R;
import com.baidu.tieba.ag2;
import com.baidu.tieba.dx1;
import com.baidu.tieba.ns2;
import com.baidu.tieba.nv1;
import com.baidu.tieba.pl3;
import com.baidu.tieba.pv1;
import com.baidu.tieba.qo3;
import com.baidu.tieba.qp1;
import com.baidu.tieba.ra2;
import com.baidu.tieba.tu2;
import com.baidu.tieba.ua2;
import com.baidu.tieba.xm3;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppWebPopWindow extends PopupWindow implements SwanAppWebPopPullLayout.c, View.OnClickListener {
    public static final boolean s0 = qp1.a;
    public static CloseStyle t0;
    public SwanAppActivity Q;
    public final FrameLayout R;
    public View S;
    public SwanAppWebPopPullLayout T;
    public RelativeLayout U;
    public int V;
    public FrameLayout W;
    public pv1 X;
    public nv1 Y;
    public final qo3 Z;
    public boolean a0;
    public int b0;
    public final String c0;
    public String d0;
    public ImageView e0;
    public boolean f0;
    public boolean g0;
    public float h0;
    public float i0;
    public int j0;
    public int r0;

    /* loaded from: classes4.dex */
    public enum CloseStyle {
        CLOSE_AT_RIGHT,
        CLOSE_AT_BOTTOM,
        CLOSE_AT_BOTH
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void a() {
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void c() {
    }

    /* loaded from: classes4.dex */
    public class c extends ra2 {
        public boolean c = false;
        public final /* synthetic */ ua2 d;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SwanAppWebPopWindow.this.W.removeAllViews();
                SwanAppWebPopWindow swanAppWebPopWindow = SwanAppWebPopWindow.this;
                swanAppWebPopWindow.X.j(swanAppWebPopWindow.W, SwanAppWebPopWindow.this.Y.covertToView());
                SwanAppWebPopWindow swanAppWebPopWindow2 = SwanAppWebPopWindow.this;
                swanAppWebPopWindow2.X.loadUrl(swanAppWebPopWindow2.c0);
            }
        }

        public c(ua2 ua2Var) {
            this.d = ua2Var;
        }

        @Override // com.baidu.tieba.ra2, com.baidu.tieba.ua2
        public void b(int i) {
            this.c = true;
            ua2 ua2Var = this.d;
            if (ua2Var != null) {
                ua2Var.b(i);
            }
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(SwanAppWebPopWindow.this.Q).inflate(R.layout.obfuscated_res_0x7f0d00d4, (ViewGroup) null);
            linearLayout.setBackgroundColor(-1);
            linearLayout.findViewById(R.id.obfuscated_res_0x7f0909c5).setOnClickListener(new a());
            SwanAppWebPopWindow.this.W.addView(linearLayout);
        }

        @Override // com.baidu.tieba.ra2, com.baidu.tieba.ua2
        public void c(int i, String str, String str2) {
            this.c = true;
            ua2 ua2Var = this.d;
            if (ua2Var != null) {
                ua2Var.c(i, str, str2);
            }
        }

        @Override // com.baidu.tieba.ra2, com.baidu.tieba.ua2
        public void e(String str) {
            if (this.c) {
                return;
            }
            this.c = false;
            ua2 ua2Var = this.d;
            if (ua2Var != null) {
                ua2Var.e(str);
            }
            SwanAppWebPopWindow.this.j0++;
            if (!SwanAppWebPopWindow.this.f0 && SwanAppWebPopWindow.this.j0 > 1 && SwanAppWebPopWindow.this.Y.canGoBack()) {
                SwanAppWebPopWindow.this.e0.setVisibility(0);
            } else {
                SwanAppWebPopWindow.this.e0.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!pl3.d(SwanAppWebPopWindow.this.Q)) {
                return;
            }
            SwanAppWebPopWindow.super.r();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SwanAppWebPopPullLayout.b {
        public b() {
        }

        @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.b
        public boolean a(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    if (SwanAppWebPopWindow.this.T.d()) {
                        return true;
                    }
                    int scaledTouchSlop = ViewConfiguration.get(SwanAppWebPopWindow.this.Q).getScaledTouchSlop();
                    float rawY = motionEvent.getRawY() - SwanAppWebPopWindow.this.h0;
                    float rawX = motionEvent.getRawX() - SwanAppWebPopWindow.this.i0;
                    if (!SwanAppWebPopWindow.this.g0 && Math.abs(rawY) > scaledTouchSlop) {
                        SwanAppWebPopWindow.this.g0 = true;
                    }
                    if (SwanAppWebPopWindow.this.g0) {
                        if (SwanAppWebPopWindow.this.W != null && SwanAppWebPopWindow.this.W.getChildAt(0) != null && SwanAppWebPopWindow.this.W.getChildAt(0).getTop() == 0 && SwanAppWebPopWindow.this.Y.getWebViewScrollY() == 0 && motionEvent.getRawY() - SwanAppWebPopWindow.this.h0 > 0.0f) {
                            return true;
                        }
                        SwanAppWebPopWindow.this.i0 = motionEvent.getRawX();
                        SwanAppWebPopWindow.this.h0 = motionEvent.getRawY();
                    }
                    if (Math.abs(rawX) > Math.abs(rawY)) {
                        return true;
                    }
                }
            } else {
                SwanAppWebPopWindow.this.g0 = false;
                if (SwanAppWebPopWindow.this.T.d()) {
                    return true;
                }
                SwanAppWebPopWindow.this.i0 = motionEvent.getRawX();
                SwanAppWebPopWindow.this.h0 = motionEvent.getRawY();
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CloseStyle.values().length];
            a = iArr;
            try {
                iArr[CloseStyle.CLOSE_AT_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CloseStyle.CLOSE_AT_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void b() {
        if (!z()) {
            return;
        }
        r();
    }

    public void i0() {
        qo3 qo3Var = this.Z;
        if (qo3Var != null) {
            qo3Var.b(this.U);
        }
    }

    public final void j0() {
        if (!z()) {
            return;
        }
        ObjectAnimator b2 = dx1.b(this.S);
        ObjectAnimator d2 = dx1.d(this.T, this.V);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new a());
        animatorSet.playTogether(b2, d2);
        animatorSet.start();
    }

    @SuppressLint({"InflateParams"})
    public SwanAppWebPopWindow o0() {
        View findViewById = this.R.findViewById(R.id.obfuscated_res_0x7f091686);
        this.S = findViewById;
        findViewById.getBackground().setAlpha(153);
        this.S.setOnClickListener(this);
        n0();
        m0();
        return this;
    }

    public SwanAppWebPopWindow q0() {
        ImageView imageView = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f0901a6);
        imageView.setImageDrawable(imageView.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08136d));
        imageView.setVisibility(0);
        return this;
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void r() {
        j0();
    }

    public final void s0() {
        this.T.setInterceptCallback(new b());
    }

    public final void w0() {
        this.S.setAlpha(0.0f);
        this.T.setTranslationY(this.V);
        ObjectAnimator c2 = dx1.c(this.S);
        ObjectAnimator a2 = dx1.a(this.T);
        ArrayList arrayList = new ArrayList();
        arrayList.add(c2);
        arrayList.add(a2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public SwanAppWebPopWindow(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity);
        this.V = 0;
        this.a0 = true;
        this.b0 = 0;
        if (s0) {
            Log.d("SwanAppWebPopWindow", "is used");
        }
        this.Q = swanAppActivity;
        this.c0 = str;
        this.Z = new qo3();
        t0 = CloseStyle.CLOSE_AT_RIGHT;
        this.j0 = 0;
        F(false);
        H(true);
        M(true);
        E(new ColorDrawable(0));
        O(-1);
        I(-1);
        if (Build.VERSION.SDK_INT > 29) {
            J(true);
        }
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.Q).inflate(R.layout.obfuscated_res_0x7f0d00b4, (ViewGroup) null);
        this.R = frameLayout;
        frameLayout.measure(0, 0);
        G(this.R);
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void d(float f) {
        this.S.getBackground().setAlpha((int) ((1.0f - f) * 153.0f));
    }

    public final pv1 k0(SwanAppActivity swanAppActivity) {
        return ag2.U().f0().i(swanAppActivity);
    }

    public final ua2 l0(ua2 ua2Var) {
        return new c(ua2Var);
    }

    public SwanAppWebPopWindow p0(CloseStyle closeStyle) {
        t0 = closeStyle;
        return this;
    }

    public SwanAppWebPopWindow r0(int i) {
        this.r0 = i;
        return this;
    }

    public SwanAppWebPopWindow t0(int i) {
        if (this.Q == null) {
            this.Q = tu2.U().getActivity();
        }
        this.d0 = this.Q.getString(i);
        return this;
    }

    public SwanAppWebPopWindow u0(String str) {
        this.d0 = str;
        return this;
    }

    public final void m0() {
        ImageView imageView = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f09147f);
        this.e0 = imageView;
        imageView.setOnClickListener(this);
        ((TextView) this.R.findViewById(R.id.obfuscated_res_0x7f0901a7)).setText(this.d0);
        ImageView imageView2 = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f0901a5);
        imageView2.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.R.findViewById(R.id.obfuscated_res_0x7f0904a6);
        TextView textView = (TextView) this.R.findViewById(R.id.obfuscated_res_0x7f090527);
        textView.setBackgroundColor(-1);
        textView.setOnClickListener(this);
        int i = d.a[t0.ordinal()];
        if (i != 1) {
            if (i == 2) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        imageView2.setVisibility(8);
    }

    /* JADX WARN: Type inference failed for: r0v26, types: [com.baidu.tieba.nv1] */
    public final void n0() {
        int n = xm3.n(ns2.c());
        int i = (int) (n * 0.68d);
        this.V = i;
        int i2 = this.r0;
        if (i2 > n) {
            this.V = n;
        } else if (i < i2) {
            this.V = i2;
        }
        this.T = (SwanAppWebPopPullLayout) this.R.findViewById(R.id.obfuscated_res_0x7f0901aa);
        this.U = (RelativeLayout) this.R.findViewById(R.id.obfuscated_res_0x7f0901a8);
        this.T.setFitsSystemWindows(true);
        this.T.setOnClickListener(this);
        ViewGroup.LayoutParams layoutParams = this.T.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        layoutParams.height = this.V;
        this.T.setLayoutParams(layoutParams);
        this.T.setCallback(this);
        s0();
        FrameLayout frameLayout = (FrameLayout) this.R.findViewById(R.id.obfuscated_res_0x7f090ea8);
        this.W = frameLayout;
        frameLayout.setBackgroundColor(-1);
        this.W.setOverScrollMode(2);
        int dimensionPixelSize = this.V - this.Q.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0707e5);
        if (t0 == CloseStyle.CLOSE_AT_BOTTOM || t0 == CloseStyle.CLOSE_AT_BOTH) {
            dimensionPixelSize -= this.Q.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0707e6);
        }
        ViewGroup.LayoutParams layoutParams2 = this.W.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        }
        layoutParams2.height = dimensionPixelSize;
        this.W.setLayoutParams(layoutParams2);
        pv1 k0 = k0(this.Q);
        this.X = k0;
        k0.Y(l0(new ra2()));
        this.Y = this.X.r();
        this.X.loadUrl(this.c0);
        this.X.j(this.W, this.Y.covertToView());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f09147f) {
            this.j0--;
            if (this.Y.canGoBack()) {
                this.Y.goBack();
                if (this.j0 <= 1) {
                    this.e0.setVisibility(8);
                    return;
                }
                return;
            }
            r();
        } else if (id == R.id.obfuscated_res_0x7f0901a5) {
            r();
        } else if (id == R.id.obfuscated_res_0x7f090527) {
            r();
        } else if (id == R.id.obfuscated_res_0x7f091686) {
            r();
        }
    }

    public void v0() {
        if (z()) {
            return;
        }
        if (this.Q == null) {
            this.Q = tu2.U().getActivity();
        }
        View decorView = this.Q.getWindow().getDecorView();
        i0();
        if (this.a0) {
            H(false);
        }
        Q(decorView, 81, 0, 0);
        if (this.a0) {
            x().setSystemUiVisibility(this.b0 | 1024 | 4096);
            H(true);
            update();
        }
        w0();
    }
}
