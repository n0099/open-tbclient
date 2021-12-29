package com.baidu.swan.apps.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
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
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.g;
import c.a.r0.a.k;
import c.a.r0.a.p.e.e;
import c.a.r0.a.z2.f;
import c.a.r0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppWebPopPullLayout;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class SwanAppWebPopWindow extends PopupWindow implements SwanAppWebPopPullLayout.c, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v0;
    public static CloseStyle w0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity U;
    public final FrameLayout V;
    public View W;
    public SwanAppWebPopPullLayout X;
    public RelativeLayout Y;
    public int Z;
    public FrameLayout a0;
    public e b0;
    public c.a.r0.a.p.e.c c0;
    public final c.a.r0.a.a3.h.c d0;
    public boolean e0;
    public int f0;
    public final String g0;
    public String h0;
    public ImageView i0;
    public boolean k0;
    public boolean q0;
    public float r0;
    public float s0;
    public int t0;
    public int u0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class CloseStyle {
        public static final /* synthetic */ CloseStyle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CloseStyle CLOSE_AT_BOTH;
        public static final CloseStyle CLOSE_AT_BOTTOM;
        public static final CloseStyle CLOSE_AT_RIGHT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(90774430, "Lcom/baidu/swan/apps/view/SwanAppWebPopWindow$CloseStyle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(90774430, "Lcom/baidu/swan/apps/view/SwanAppWebPopWindow$CloseStyle;");
                    return;
                }
            }
            CLOSE_AT_RIGHT = new CloseStyle("CLOSE_AT_RIGHT", 0);
            CLOSE_AT_BOTTOM = new CloseStyle("CLOSE_AT_BOTTOM", 1);
            CloseStyle closeStyle = new CloseStyle("CLOSE_AT_BOTH", 2);
            CLOSE_AT_BOTH = closeStyle;
            $VALUES = new CloseStyle[]{CLOSE_AT_RIGHT, CLOSE_AT_BOTTOM, closeStyle};
        }

        public CloseStyle(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CloseStyle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CloseStyle) Enum.valueOf(CloseStyle.class, str) : (CloseStyle) invokeL.objValue;
        }

        public static CloseStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CloseStyle[]) $VALUES.clone() : (CloseStyle[]) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebPopWindow f40831e;

        public a(SwanAppWebPopWindow swanAppWebPopWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebPopWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40831e = swanAppWebPopWindow;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && f.d(this.f40831e.U)) {
                SwanAppWebPopWindow.super.r();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements SwanAppWebPopPullLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebPopWindow a;

        public b(SwanAppWebPopWindow swanAppWebPopWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebPopWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppWebPopWindow;
        }

        @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.b
        public boolean a(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.a.q0 = false;
                    if (this.a.X.isChildDragged()) {
                        return true;
                    }
                    this.a.s0 = motionEvent.getRawX();
                    this.a.r0 = motionEvent.getRawY();
                } else if (action == 2) {
                    if (this.a.X.isChildDragged()) {
                        return true;
                    }
                    int scaledTouchSlop = ViewConfiguration.get(this.a.U).getScaledTouchSlop();
                    float rawY = motionEvent.getRawY() - this.a.r0;
                    float rawX = motionEvent.getRawX() - this.a.s0;
                    if (!this.a.q0 && Math.abs(rawY) > scaledTouchSlop) {
                        this.a.q0 = true;
                    }
                    if (this.a.q0) {
                        if (this.a.a0 != null && this.a.a0.getChildAt(0) != null && this.a.a0.getChildAt(0).getTop() == 0 && this.a.c0.getWebViewScrollY() == 0 && motionEvent.getRawY() - this.a.r0 > 0.0f) {
                            return true;
                        }
                        this.a.s0 = motionEvent.getRawX();
                        this.a.r0 = motionEvent.getRawY();
                    }
                    if (Math.abs(rawX) > Math.abs(rawY)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class c extends c.a.r0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public boolean f40832c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.j.d f40833d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebPopWindow f40834e;

        /* loaded from: classes11.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f40835e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f40835e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f40835e.f40834e.a0.removeAllViews();
                    SwanAppWebPopWindow swanAppWebPopWindow = this.f40835e.f40834e;
                    swanAppWebPopWindow.b0.k(swanAppWebPopWindow.a0, this.f40835e.f40834e.c0.covertToView());
                    SwanAppWebPopWindow swanAppWebPopWindow2 = this.f40835e.f40834e;
                    swanAppWebPopWindow2.b0.loadUrl(swanAppWebPopWindow2.g0);
                }
            }
        }

        public c(SwanAppWebPopWindow swanAppWebPopWindow, c.a.r0.a.h0.j.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebPopWindow, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40834e = swanAppWebPopWindow;
            this.f40833d = dVar;
            this.f40832c = false;
        }

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f40832c = true;
                c.a.r0.a.h0.j.d dVar = this.f40833d;
                if (dVar != null) {
                    dVar.b(i2);
                }
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f40834e.U).inflate(g.aiapps_server_request_error_view, (ViewGroup) null);
                linearLayout.setBackgroundColor(-1);
                linearLayout.findViewById(c.a.r0.a.f.empty_btn_reload).setOnClickListener(new a(this));
                this.f40834e.a0.addView(linearLayout);
            }
        }

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
        public void d(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
                this.f40832c = true;
                c.a.r0.a.h0.j.d dVar = this.f40833d;
                if (dVar != null) {
                    dVar.d(i2, str, str2);
                }
            }
        }

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f40832c) {
                return;
            }
            this.f40832c = false;
            c.a.r0.a.h0.j.d dVar = this.f40833d;
            if (dVar != null) {
                dVar.e(str);
            }
            this.f40834e.t0++;
            if (this.f40834e.k0 || this.f40834e.t0 <= 1 || !this.f40834e.c0.canGoBack()) {
                this.f40834e.i0.setVisibility(8);
            } else {
                this.f40834e.i0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1957434843, "Lcom/baidu/swan/apps/view/SwanAppWebPopWindow$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1957434843, "Lcom/baidu/swan/apps/view/SwanAppWebPopWindow$d;");
                    return;
                }
            }
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-328688997, "Lcom/baidu/swan/apps/view/SwanAppWebPopWindow;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-328688997, "Lcom/baidu/swan/apps/view/SwanAppWebPopWindow;");
                return;
            }
        }
        v0 = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppWebPopWindow(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.Z = 0;
        this.e0 = true;
        this.f0 = 0;
        boolean z = v0;
        this.U = swanAppActivity;
        this.g0 = str;
        this.d0 = new c.a.r0.a.a3.h.c();
        w0 = CloseStyle.CLOSE_AT_RIGHT;
        this.t0 = 0;
        D(false);
        F(true);
        J(true);
        C(new ColorDrawable(0));
        L(-1);
        G(-1);
        if (Build.VERSION.SDK_INT > 29) {
            H(true);
        }
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.U).inflate(g.aiapps_half_web_pop_window, (ViewGroup) null);
        this.V = frameLayout;
        frameLayout.measure(0, 0);
        E(this.V);
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && x()) {
            r();
        }
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void d(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            this.W.getBackground().setAlpha((int) ((1.0f - f2) * 153.0f));
        }
    }

    public void f0() {
        c.a.r0.a.a3.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.d0) == null) {
            return;
        }
        cVar.b(this.Y);
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && x()) {
            ObjectAnimator b2 = c.a.r0.a.t.b.b(this.W);
            ObjectAnimator d2 = c.a.r0.a.t.b.d(this.X, this.Z);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new a(this));
            animatorSet.playTogether(b2, d2);
            animatorSet.start();
        }
    }

    public final e h0(SwanAppActivity swanAppActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, swanAppActivity)) == null) ? c.a.r0.a.h0.u.g.U().f0().i(swanAppActivity) : (e) invokeL.objValue;
    }

    public final c.a.r0.a.h0.j.d i0(c.a.r0.a.h0.j.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, dVar)) == null) ? new c(this, dVar) : (c.a.r0.a.h0.j.d) invokeL.objValue;
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ImageView imageView = (ImageView) this.V.findViewById(c.a.r0.a.f.left_back_view);
            this.i0 = imageView;
            imageView.setOnClickListener(this);
            ((TextView) this.V.findViewById(c.a.r0.a.f.aiapps_half_screen_title)).setText(this.h0);
            ImageView imageView2 = (ImageView) this.V.findViewById(c.a.r0.a.f.aiapps_half_screen_close_icon);
            imageView2.setOnClickListener(this);
            LinearLayout linearLayout = (LinearLayout) this.V.findViewById(c.a.r0.a.f.btn_close);
            TextView textView = (TextView) this.V.findViewById(c.a.r0.a.f.cancel_button);
            textView.setBackgroundColor(-1);
            textView.setOnClickListener(this);
            int i2 = d.a[w0.ordinal()];
            if (i2 == 1) {
                imageView2.setVisibility(8);
            } else if (i2 != 2) {
            } else {
                linearLayout.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [c.a.r0.a.p.e.c] */
    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int n = n0.n(c.a.r0.a.c1.a.c());
            int i2 = (int) (n * 0.68d);
            this.Z = i2;
            int i3 = this.u0;
            if (i3 > n) {
                this.Z = n;
            } else if (i2 < i3) {
                this.Z = i3;
            }
            this.X = (SwanAppWebPopPullLayout) this.V.findViewById(c.a.r0.a.f.aiapps_half_web_pop_window_body);
            this.Y = (RelativeLayout) this.V.findViewById(c.a.r0.a.f.aiapps_half_web_inner_layout);
            this.X.setFitsSystemWindows(true);
            this.X.setOnClickListener(this);
            ViewGroup.LayoutParams layoutParams = this.X.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            layoutParams.height = this.Z;
            this.X.setLayoutParams(layoutParams);
            this.X.setCallback(this);
            p0();
            FrameLayout frameLayout = (FrameLayout) this.V.findViewById(c.a.r0.a.f.half_screen_container);
            this.a0 = frameLayout;
            frameLayout.setBackgroundColor(-1);
            this.a0.setOverScrollMode(2);
            int dimensionPixelSize = this.Z - this.U.getResources().getDimensionPixelSize(c.a.r0.a.d.swan_half_screen_action_bar_height);
            if (w0 == CloseStyle.CLOSE_AT_BOTTOM || w0 == CloseStyle.CLOSE_AT_BOTH) {
                dimensionPixelSize -= this.U.getResources().getDimensionPixelSize(c.a.r0.a.d.swan_half_screen_bottom_btn_height);
            }
            ViewGroup.LayoutParams layoutParams2 = this.a0.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
            }
            layoutParams2.height = dimensionPixelSize;
            this.a0.setLayoutParams(layoutParams2);
            e h0 = h0(this.U);
            this.b0 = h0;
            h0.a0(i0(new c.a.r0.a.h0.j.a()));
            this.c0 = this.b0.t();
            this.b0.loadUrl(this.g0);
            this.b0.k(this.a0, this.c0.covertToView());
        }
    }

    @SuppressLint({"InflateParams"})
    public SwanAppWebPopWindow l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            View findViewById = this.V.findViewById(c.a.r0.a.f.mask);
            this.W = findViewById;
            findViewById.getBackground().setAlpha(153);
            this.W.setOnClickListener(this);
            k0();
            j0();
            return this;
        }
        return (SwanAppWebPopWindow) invokeV.objValue;
    }

    public SwanAppWebPopWindow m0(CloseStyle closeStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, closeStyle)) == null) {
            w0 = closeStyle;
            return this;
        }
        return (SwanAppWebPopWindow) invokeL.objValue;
    }

    public SwanAppWebPopWindow n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ImageView imageView = (ImageView) this.V.findViewById(c.a.r0.a.f.aiapps_half_screen_icon);
            imageView.setImageDrawable(imageView.getResources().getDrawable(c.a.r0.a.e.swan_app_apply_guarantee_new));
            imageView.setVisibility(0);
            return this;
        }
        return (SwanAppWebPopWindow) invokeV.objValue;
    }

    public SwanAppWebPopWindow o0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.u0 = i2;
            return this;
        }
        return (SwanAppWebPopWindow) invokeI.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            int id = view.getId();
            if (id == c.a.r0.a.f.left_back_view) {
                this.t0--;
                if (this.c0.canGoBack()) {
                    this.c0.goBack();
                    if (this.t0 <= 1) {
                        this.i0.setVisibility(8);
                        return;
                    }
                    return;
                }
                r();
            } else if (id == c.a.r0.a.f.aiapps_half_screen_close_icon) {
                r();
            } else if (id == c.a.r0.a.f.cancel_button) {
                r();
            } else if (id == c.a.r0.a.f.mask) {
                r();
            }
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.X.setInterceptCallback(new b(this));
        }
    }

    public SwanAppWebPopWindow q0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (this.U == null) {
                this.U = c.a.r0.a.g1.f.U().getActivity();
            }
            this.h0 = this.U.getString(i2);
            return this;
        }
        return (SwanAppWebPopWindow) invokeI.objValue;
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            g0();
        }
    }

    public SwanAppWebPopWindow r0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.h0 = str;
            return this;
        }
        return (SwanAppWebPopWindow) invokeL.objValue;
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || x()) {
            return;
        }
        if (this.U == null) {
            this.U = c.a.r0.a.g1.f.U().getActivity();
        }
        View decorView = this.U.getWindow().getDecorView();
        f0();
        if (this.e0) {
            F(false);
        }
        N(decorView, 81, 0, 0);
        if (this.e0) {
            v().setSystemUiVisibility(this.f0 | 1024 | 4096);
            F(true);
            update();
        }
        t0();
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.W.setAlpha(0.0f);
            this.X.setTranslationY(this.Z);
            ObjectAnimator c2 = c.a.r0.a.t.b.c(this.W);
            ObjectAnimator a2 = c.a.r0.a.t.b.a(this.X);
            ArrayList arrayList = new ArrayList();
            arrayList.add(c2);
            arrayList.add(a2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.start();
        }
    }
}
