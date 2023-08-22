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
import com.baidu.tieba.az1;
import com.baidu.tieba.ku2;
import com.baidu.tieba.kx1;
import com.baidu.tieba.mn3;
import com.baidu.tieba.mx1;
import com.baidu.tieba.nq3;
import com.baidu.tieba.nr1;
import com.baidu.tieba.oc2;
import com.baidu.tieba.qw2;
import com.baidu.tieba.rc2;
import com.baidu.tieba.uo3;
import com.baidu.tieba.xh2;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppWebPopWindow extends PopupWindow implements SwanAppWebPopPullLayout.c, View.OnClickListener {
    public static final boolean s0 = nr1.a;
    public static CloseStyle t0;
    public SwanAppActivity Q;
    public final FrameLayout R;
    public View S;

    /* renamed from: T  reason: collision with root package name */
    public SwanAppWebPopPullLayout f1076T;
    public RelativeLayout U;
    public int V;
    public FrameLayout W;
    public mx1 X;
    public kx1 Y;
    public final nq3 Z;
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
    public class c extends oc2 {
        public boolean c = false;
        public final /* synthetic */ rc2 d;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SwanAppWebPopWindow.this.W.removeAllViews();
                SwanAppWebPopWindow swanAppWebPopWindow = SwanAppWebPopWindow.this;
                swanAppWebPopWindow.X.i(swanAppWebPopWindow.W, SwanAppWebPopWindow.this.Y.covertToView());
                SwanAppWebPopWindow swanAppWebPopWindow2 = SwanAppWebPopWindow.this;
                swanAppWebPopWindow2.X.loadUrl(swanAppWebPopWindow2.c0);
            }
        }

        public c(rc2 rc2Var) {
            this.d = rc2Var;
        }

        @Override // com.baidu.tieba.oc2, com.baidu.tieba.rc2
        public void b(int i) {
            this.c = true;
            rc2 rc2Var = this.d;
            if (rc2Var != null) {
                rc2Var.b(i);
            }
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(SwanAppWebPopWindow.this.Q).inflate(R.layout.obfuscated_res_0x7f0d00d5, (ViewGroup) null);
            linearLayout.setBackgroundColor(-1);
            linearLayout.findViewById(R.id.empty_btn_reload).setOnClickListener(new a());
            SwanAppWebPopWindow.this.W.addView(linearLayout);
        }

        @Override // com.baidu.tieba.oc2, com.baidu.tieba.rc2
        public void c(int i, String str, String str2) {
            this.c = true;
            rc2 rc2Var = this.d;
            if (rc2Var != null) {
                rc2Var.c(i, str, str2);
            }
        }

        @Override // com.baidu.tieba.oc2, com.baidu.tieba.rc2
        public void e(String str) {
            if (this.c) {
                return;
            }
            this.c = false;
            rc2 rc2Var = this.d;
            if (rc2Var != null) {
                rc2Var.e(str);
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
            if (!mn3.d(SwanAppWebPopWindow.this.Q)) {
                return;
            }
            SwanAppWebPopWindow.super.q();
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
                    if (SwanAppWebPopWindow.this.f1076T.d()) {
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
                if (SwanAppWebPopWindow.this.f1076T.d()) {
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
        if (!y()) {
            return;
        }
        q();
    }

    public void h0() {
        nq3 nq3Var = this.Z;
        if (nq3Var != null) {
            nq3Var.b(this.U);
        }
    }

    public final void i0() {
        if (!y()) {
            return;
        }
        ObjectAnimator b2 = az1.b(this.S);
        ObjectAnimator d2 = az1.d(this.f1076T, this.V);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new a());
        animatorSet.playTogether(b2, d2);
        animatorSet.start();
    }

    @SuppressLint({"InflateParams"})
    public SwanAppWebPopWindow n0() {
        View findViewById = this.R.findViewById(R.id.obfuscated_res_0x7f0916fd);
        this.S = findViewById;
        findViewById.getBackground().setAlpha(153);
        this.S.setOnClickListener(this);
        m0();
        l0();
        return this;
    }

    public SwanAppWebPopWindow p0() {
        ImageView imageView = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f0901aa);
        imageView.setImageDrawable(imageView.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081407));
        imageView.setVisibility(0);
        return this;
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void q() {
        i0();
    }

    public final void r0() {
        this.f1076T.setInterceptCallback(new b());
    }

    public final void v0() {
        this.S.setAlpha(0.0f);
        this.f1076T.setTranslationY(this.V);
        ObjectAnimator c2 = az1.c(this.S);
        ObjectAnimator a2 = az1.a(this.f1076T);
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
        this.Z = new nq3();
        t0 = CloseStyle.CLOSE_AT_RIGHT;
        this.j0 = 0;
        E(false);
        G(true);
        K(true);
        D(new ColorDrawable(0));
        M(-1);
        H(-1);
        if (Build.VERSION.SDK_INT > 29) {
            I(true);
        }
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.Q).inflate(R.layout.obfuscated_res_0x7f0d00b5, (ViewGroup) null);
        this.R = frameLayout;
        frameLayout.measure(0, 0);
        F(this.R);
    }

    public final mx1 j0(SwanAppActivity swanAppActivity) {
        return xh2.U().f0().i(swanAppActivity);
    }

    public final rc2 k0(rc2 rc2Var) {
        return new c(rc2Var);
    }

    public SwanAppWebPopWindow o0(CloseStyle closeStyle) {
        t0 = closeStyle;
        return this;
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void onPull(float f) {
        this.S.getBackground().setAlpha((int) ((1.0f - f) * 153.0f));
    }

    public SwanAppWebPopWindow q0(int i) {
        this.r0 = i;
        return this;
    }

    public SwanAppWebPopWindow s0(int i) {
        if (this.Q == null) {
            this.Q = qw2.T().getActivity();
        }
        this.d0 = this.Q.getString(i);
        return this;
    }

    public SwanAppWebPopWindow t0(String str) {
        this.d0 = str;
        return this;
    }

    public final void l0() {
        ImageView imageView = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f0914ea);
        this.e0 = imageView;
        imageView.setOnClickListener(this);
        ((TextView) this.R.findViewById(R.id.obfuscated_res_0x7f0901ab)).setText(this.d0);
        ImageView imageView2 = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f0901a9);
        imageView2.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.R.findViewById(R.id.obfuscated_res_0x7f0904bb);
        TextView textView = (TextView) this.R.findViewById(R.id.obfuscated_res_0x7f09053e);
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

    /* JADX WARN: Type inference failed for: r0v26, types: [com.baidu.tieba.kx1] */
    public final void m0() {
        int n = uo3.n(ku2.c());
        int i = (int) (n * 0.68d);
        this.V = i;
        int i2 = this.r0;
        if (i2 > n) {
            this.V = n;
        } else if (i < i2) {
            this.V = i2;
        }
        this.f1076T = (SwanAppWebPopPullLayout) this.R.findViewById(R.id.obfuscated_res_0x7f0901ae);
        this.U = (RelativeLayout) this.R.findViewById(R.id.obfuscated_res_0x7f0901ac);
        this.f1076T.setFitsSystemWindows(true);
        this.f1076T.setOnClickListener(this);
        ViewGroup.LayoutParams layoutParams = this.f1076T.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        layoutParams.height = this.V;
        this.f1076T.setLayoutParams(layoutParams);
        this.f1076T.setCallback(this);
        r0();
        FrameLayout frameLayout = (FrameLayout) this.R.findViewById(R.id.obfuscated_res_0x7f090ef0);
        this.W = frameLayout;
        frameLayout.setBackgroundColor(-1);
        this.W.setOverScrollMode(2);
        int dimensionPixelSize = this.V - this.Q.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07080e);
        if (t0 == CloseStyle.CLOSE_AT_BOTTOM || t0 == CloseStyle.CLOSE_AT_BOTH) {
            dimensionPixelSize -= this.Q.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07080f);
        }
        ViewGroup.LayoutParams layoutParams2 = this.W.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        }
        layoutParams2.height = dimensionPixelSize;
        this.W.setLayoutParams(layoutParams2);
        mx1 j0 = j0(this.Q);
        this.X = j0;
        j0.X(k0(new oc2()));
        this.Y = this.X.r();
        this.X.loadUrl(this.c0);
        this.X.i(this.W, this.Y.covertToView());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f0914ea) {
            this.j0--;
            if (this.Y.canGoBack()) {
                this.Y.goBack();
                if (this.j0 <= 1) {
                    this.e0.setVisibility(8);
                    return;
                }
                return;
            }
            q();
        } else if (id == R.id.obfuscated_res_0x7f0901a9) {
            q();
        } else if (id == R.id.obfuscated_res_0x7f09053e) {
            q();
        } else if (id == R.id.obfuscated_res_0x7f0916fd) {
            q();
        }
    }

    public void u0() {
        if (y()) {
            return;
        }
        if (this.Q == null) {
            this.Q = qw2.T().getActivity();
        }
        View decorView = this.Q.getWindow().getDecorView();
        h0();
        if (this.a0) {
            G(false);
        }
        O(decorView, 81, 0, 0);
        if (this.a0) {
            u().setSystemUiVisibility(this.b0 | 1024 | 4096);
            G(true);
            update();
        }
        v0();
    }
}
