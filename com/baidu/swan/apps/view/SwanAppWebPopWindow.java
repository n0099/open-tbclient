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
import com.baidu.tieba.ab2;
import com.baidu.tieba.dn3;
import com.baidu.tieba.gg2;
import com.baidu.tieba.jx1;
import com.baidu.tieba.ts2;
import com.baidu.tieba.tv1;
import com.baidu.tieba.vl3;
import com.baidu.tieba.vv1;
import com.baidu.tieba.wo3;
import com.baidu.tieba.wp1;
import com.baidu.tieba.xa2;
import com.baidu.tieba.zu2;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwanAppWebPopWindow extends PopupWindow implements SwanAppWebPopPullLayout.c, View.OnClickListener {
    public static final boolean s0 = wp1.a;
    public static CloseStyle t0;
    public SwanAppActivity Q;
    public final FrameLayout R;
    public View S;
    public SwanAppWebPopPullLayout T;
    public RelativeLayout U;
    public int V;
    public FrameLayout W;
    public vv1 X;
    public tv1 Y;
    public final wo3 Z;
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class c extends xa2 {
        public boolean c = false;
        public final /* synthetic */ ab2 d;

        /* loaded from: classes3.dex */
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

        public c(ab2 ab2Var) {
            this.d = ab2Var;
        }

        @Override // com.baidu.tieba.xa2, com.baidu.tieba.ab2
        public void b(int i) {
            this.c = true;
            ab2 ab2Var = this.d;
            if (ab2Var != null) {
                ab2Var.b(i);
            }
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(SwanAppWebPopWindow.this.Q).inflate(R.layout.obfuscated_res_0x7f0d00d0, (ViewGroup) null);
            linearLayout.setBackgroundColor(-1);
            linearLayout.findViewById(R.id.obfuscated_res_0x7f090975).setOnClickListener(new a());
            SwanAppWebPopWindow.this.W.addView(linearLayout);
        }

        @Override // com.baidu.tieba.xa2, com.baidu.tieba.ab2
        public void c(int i, String str, String str2) {
            this.c = true;
            ab2 ab2Var = this.d;
            if (ab2Var != null) {
                ab2Var.c(i, str, str2);
            }
        }

        @Override // com.baidu.tieba.xa2, com.baidu.tieba.ab2
        public void e(String str) {
            if (this.c) {
                return;
            }
            this.c = false;
            ab2 ab2Var = this.d;
            if (ab2Var != null) {
                ab2Var.e(str);
            }
            SwanAppWebPopWindow.this.j0++;
            if (!SwanAppWebPopWindow.this.f0 && SwanAppWebPopWindow.this.j0 > 1 && SwanAppWebPopWindow.this.Y.canGoBack()) {
                SwanAppWebPopWindow.this.e0.setVisibility(0);
            } else {
                SwanAppWebPopWindow.this.e0.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!vl3.d(SwanAppWebPopWindow.this.Q)) {
                return;
            }
            SwanAppWebPopWindow.super.r();
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
        if (!x()) {
            return;
        }
        r();
    }

    public void g0() {
        wo3 wo3Var = this.Z;
        if (wo3Var != null) {
            wo3Var.b(this.U);
        }
    }

    public final void h0() {
        if (!x()) {
            return;
        }
        ObjectAnimator b2 = jx1.b(this.S);
        ObjectAnimator d2 = jx1.d(this.T, this.V);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new a());
        animatorSet.playTogether(b2, d2);
        animatorSet.start();
    }

    @SuppressLint({"InflateParams"})
    public SwanAppWebPopWindow m0() {
        View findViewById = this.R.findViewById(R.id.obfuscated_res_0x7f091601);
        this.S = findViewById;
        findViewById.getBackground().setAlpha(153);
        this.S.setOnClickListener(this);
        l0();
        k0();
        return this;
    }

    public SwanAppWebPopWindow o0() {
        ImageView imageView = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f090195);
        imageView.setImageDrawable(imageView.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0811cb));
        imageView.setVisibility(0);
        return this;
    }

    public final void q0() {
        this.T.setInterceptCallback(new b());
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void r() {
        h0();
    }

    public final void u0() {
        this.S.setAlpha(0.0f);
        this.T.setTranslationY(this.V);
        ObjectAnimator c2 = jx1.c(this.S);
        ObjectAnimator a2 = jx1.a(this.T);
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
        this.Z = new wo3();
        t0 = CloseStyle.CLOSE_AT_RIGHT;
        this.j0 = 0;
        D(false);
        F(true);
        K(true);
        C(new ColorDrawable(0));
        M(-1);
        G(-1);
        if (Build.VERSION.SDK_INT > 29) {
            H(true);
        }
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.Q).inflate(R.layout.obfuscated_res_0x7f0d00b0, (ViewGroup) null);
        this.R = frameLayout;
        frameLayout.measure(0, 0);
        E(this.R);
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void d(float f) {
        this.S.getBackground().setAlpha((int) ((1.0f - f) * 153.0f));
    }

    public final vv1 i0(SwanAppActivity swanAppActivity) {
        return gg2.U().f0().i(swanAppActivity);
    }

    public final ab2 j0(ab2 ab2Var) {
        return new c(ab2Var);
    }

    public SwanAppWebPopWindow n0(CloseStyle closeStyle) {
        t0 = closeStyle;
        return this;
    }

    public SwanAppWebPopWindow p0(int i) {
        this.r0 = i;
        return this;
    }

    public SwanAppWebPopWindow r0(int i) {
        if (this.Q == null) {
            this.Q = zu2.U().getActivity();
        }
        this.d0 = this.Q.getString(i);
        return this;
    }

    public SwanAppWebPopWindow s0(String str) {
        this.d0 = str;
        return this;
    }

    public final void k0() {
        ImageView imageView = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f091401);
        this.e0 = imageView;
        imageView.setOnClickListener(this);
        ((TextView) this.R.findViewById(R.id.obfuscated_res_0x7f090196)).setText(this.d0);
        ImageView imageView2 = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f090194);
        imageView2.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.R.findViewById(R.id.btn_close);
        TextView textView = (TextView) this.R.findViewById(R.id.obfuscated_res_0x7f0904f8);
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

    /* JADX WARN: Type inference failed for: r0v26, types: [com.baidu.tieba.tv1] */
    public final void l0() {
        int n = dn3.n(ts2.c());
        int i = (int) (n * 0.68d);
        this.V = i;
        int i2 = this.r0;
        if (i2 > n) {
            this.V = n;
        } else if (i < i2) {
            this.V = i2;
        }
        this.T = (SwanAppWebPopPullLayout) this.R.findViewById(R.id.obfuscated_res_0x7f090199);
        this.U = (RelativeLayout) this.R.findViewById(R.id.obfuscated_res_0x7f090197);
        this.T.setFitsSystemWindows(true);
        this.T.setOnClickListener(this);
        ViewGroup.LayoutParams layoutParams = this.T.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        layoutParams.height = this.V;
        this.T.setLayoutParams(layoutParams);
        this.T.setCallback(this);
        q0();
        FrameLayout frameLayout = (FrameLayout) this.R.findViewById(R.id.obfuscated_res_0x7f090e3b);
        this.W = frameLayout;
        frameLayout.setBackgroundColor(-1);
        this.W.setOverScrollMode(2);
        int dimensionPixelSize = this.V - this.Q.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070693);
        if (t0 == CloseStyle.CLOSE_AT_BOTTOM || t0 == CloseStyle.CLOSE_AT_BOTH) {
            dimensionPixelSize -= this.Q.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070694);
        }
        ViewGroup.LayoutParams layoutParams2 = this.W.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        }
        layoutParams2.height = dimensionPixelSize;
        this.W.setLayoutParams(layoutParams2);
        vv1 i0 = i0(this.Q);
        this.X = i0;
        i0.Y(j0(new xa2()));
        this.Y = this.X.r();
        this.X.loadUrl(this.c0);
        this.X.j(this.W, this.Y.covertToView());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091401) {
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
        } else if (id == R.id.obfuscated_res_0x7f090194) {
            r();
        } else if (id == R.id.obfuscated_res_0x7f0904f8) {
            r();
        } else if (id == R.id.obfuscated_res_0x7f091601) {
            r();
        }
    }

    public void t0() {
        if (x()) {
            return;
        }
        if (this.Q == null) {
            this.Q = zu2.U().getActivity();
        }
        View decorView = this.Q.getWindow().getDecorView();
        g0();
        if (this.a0) {
            F(false);
        }
        O(decorView, 81, 0, 0);
        if (this.a0) {
            v().setSystemUiVisibility(this.b0 | 1024 | 4096);
            F(true);
            update();
        }
        u0();
    }
}
