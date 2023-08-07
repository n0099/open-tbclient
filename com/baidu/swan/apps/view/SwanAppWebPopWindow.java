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
import com.baidu.tieba.fu2;
import com.baidu.tieba.fx1;
import com.baidu.tieba.hn3;
import com.baidu.tieba.hx1;
import com.baidu.tieba.iq3;
import com.baidu.tieba.ir1;
import com.baidu.tieba.jc2;
import com.baidu.tieba.lw2;
import com.baidu.tieba.mc2;
import com.baidu.tieba.po3;
import com.baidu.tieba.sh2;
import com.baidu.tieba.vy1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppWebPopWindow extends PopupWindow implements SwanAppWebPopPullLayout.c, View.OnClickListener {
    public static final boolean s0 = ir1.a;
    public static CloseStyle t0;
    public SwanAppActivity Q;
    public final FrameLayout R;
    public View S;

    /* renamed from: T  reason: collision with root package name */
    public SwanAppWebPopPullLayout f1075T;
    public RelativeLayout U;
    public int V;
    public FrameLayout W;
    public hx1 X;
    public fx1 Y;
    public final iq3 Z;
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
    public class c extends jc2 {
        public boolean c = false;
        public final /* synthetic */ mc2 d;

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

        public c(mc2 mc2Var) {
            this.d = mc2Var;
        }

        @Override // com.baidu.tieba.jc2, com.baidu.tieba.mc2
        public void b(int i) {
            this.c = true;
            mc2 mc2Var = this.d;
            if (mc2Var != null) {
                mc2Var.b(i);
            }
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(SwanAppWebPopWindow.this.Q).inflate(R.layout.obfuscated_res_0x7f0d00d3, (ViewGroup) null);
            linearLayout.setBackgroundColor(-1);
            linearLayout.findViewById(R.id.empty_btn_reload).setOnClickListener(new a());
            SwanAppWebPopWindow.this.W.addView(linearLayout);
        }

        @Override // com.baidu.tieba.jc2, com.baidu.tieba.mc2
        public void c(int i, String str, String str2) {
            this.c = true;
            mc2 mc2Var = this.d;
            if (mc2Var != null) {
                mc2Var.c(i, str, str2);
            }
        }

        @Override // com.baidu.tieba.jc2, com.baidu.tieba.mc2
        public void e(String str) {
            if (this.c) {
                return;
            }
            this.c = false;
            mc2 mc2Var = this.d;
            if (mc2Var != null) {
                mc2Var.e(str);
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
            if (!hn3.d(SwanAppWebPopWindow.this.Q)) {
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
                    if (SwanAppWebPopWindow.this.f1075T.d()) {
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
                if (SwanAppWebPopWindow.this.f1075T.d()) {
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
        iq3 iq3Var = this.Z;
        if (iq3Var != null) {
            iq3Var.b(this.U);
        }
    }

    public final void i0() {
        if (!y()) {
            return;
        }
        ObjectAnimator b2 = vy1.b(this.S);
        ObjectAnimator d2 = vy1.d(this.f1075T, this.V);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new a());
        animatorSet.playTogether(b2, d2);
        animatorSet.start();
    }

    @SuppressLint({"InflateParams"})
    public SwanAppWebPopWindow n0() {
        View findViewById = this.R.findViewById(R.id.obfuscated_res_0x7f0916e6);
        this.S = findViewById;
        findViewById.getBackground().setAlpha(153);
        this.S.setOnClickListener(this);
        m0();
        l0();
        return this;
    }

    public SwanAppWebPopWindow p0() {
        ImageView imageView = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f0901a8);
        imageView.setImageDrawable(imageView.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0813ee));
        imageView.setVisibility(0);
        return this;
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void q() {
        i0();
    }

    public final void r0() {
        this.f1075T.setInterceptCallback(new b());
    }

    public final void v0() {
        this.S.setAlpha(0.0f);
        this.f1075T.setTranslationY(this.V);
        ObjectAnimator c2 = vy1.c(this.S);
        ObjectAnimator a2 = vy1.a(this.f1075T);
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
        this.Z = new iq3();
        t0 = CloseStyle.CLOSE_AT_RIGHT;
        this.j0 = 0;
        E(false);
        G(true);
        K(true);
        D(new ColorDrawable(0));
        N(-1);
        H(-1);
        if (Build.VERSION.SDK_INT > 29) {
            I(true);
        }
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.Q).inflate(R.layout.obfuscated_res_0x7f0d00b3, (ViewGroup) null);
        this.R = frameLayout;
        frameLayout.measure(0, 0);
        F(this.R);
    }

    public final hx1 j0(SwanAppActivity swanAppActivity) {
        return sh2.U().f0().i(swanAppActivity);
    }

    public final mc2 k0(mc2 mc2Var) {
        return new c(mc2Var);
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
            this.Q = lw2.T().getActivity();
        }
        this.d0 = this.Q.getString(i);
        return this;
    }

    public SwanAppWebPopWindow t0(String str) {
        this.d0 = str;
        return this;
    }

    public final void l0() {
        ImageView imageView = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f0914d3);
        this.e0 = imageView;
        imageView.setOnClickListener(this);
        ((TextView) this.R.findViewById(R.id.obfuscated_res_0x7f0901a9)).setText(this.d0);
        ImageView imageView2 = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f0901a7);
        imageView2.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.R.findViewById(R.id.obfuscated_res_0x7f0904b8);
        TextView textView = (TextView) this.R.findViewById(R.id.obfuscated_res_0x7f09053b);
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

    /* JADX WARN: Type inference failed for: r0v26, types: [com.baidu.tieba.fx1] */
    public final void m0() {
        int n = po3.n(fu2.c());
        int i = (int) (n * 0.68d);
        this.V = i;
        int i2 = this.r0;
        if (i2 > n) {
            this.V = n;
        } else if (i < i2) {
            this.V = i2;
        }
        this.f1075T = (SwanAppWebPopPullLayout) this.R.findViewById(R.id.obfuscated_res_0x7f0901ac);
        this.U = (RelativeLayout) this.R.findViewById(R.id.obfuscated_res_0x7f0901aa);
        this.f1075T.setFitsSystemWindows(true);
        this.f1075T.setOnClickListener(this);
        ViewGroup.LayoutParams layoutParams = this.f1075T.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        layoutParams.height = this.V;
        this.f1075T.setLayoutParams(layoutParams);
        this.f1075T.setCallback(this);
        r0();
        FrameLayout frameLayout = (FrameLayout) this.R.findViewById(R.id.obfuscated_res_0x7f090ee3);
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
        hx1 j0 = j0(this.Q);
        this.X = j0;
        j0.W(k0(new jc2()));
        this.Y = this.X.r();
        this.X.loadUrl(this.c0);
        this.X.i(this.W, this.Y.covertToView());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f0914d3) {
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
        } else if (id == R.id.obfuscated_res_0x7f0901a7) {
            q();
        } else if (id == R.id.obfuscated_res_0x7f09053b) {
            q();
        } else if (id == R.id.obfuscated_res_0x7f0916e6) {
            q();
        }
    }

    public void u0() {
        if (y()) {
            return;
        }
        if (this.Q == null) {
            this.Q = lw2.T().getActivity();
        }
        View decorView = this.Q.getWindow().getDecorView();
        h0();
        if (this.a0) {
            G(false);
        }
        P(decorView, 81, 0, 0);
        if (this.a0) {
            u().setSystemUiVisibility(this.b0 | 1024 | 4096);
            G(true);
            update();
        }
        v0();
    }
}
