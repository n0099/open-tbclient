package com.baidu.swan.apps.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
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
import androidx.core.view.InputDeviceCompat;
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
import d.a.o0.a.g;
import d.a.o0.a.k;
import d.a.o0.a.p.e.e;
import d.a.o0.a.v2.f;
import d.a.o0.a.v2.n0;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwanAppWebPopWindow extends PopupWindow implements SwanAppWebPopPullLayout.c, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u0;
    public static CloseStyle v0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity U;
    public final FrameLayout V;
    public View W;
    public SwanAppWebPopPullLayout X;
    public RelativeLayout Y;
    public int Z;
    public FrameLayout a0;
    public e b0;
    public d.a.o0.a.p.e.c c0;
    public final d.a.o0.a.w2.h.c i0;
    public boolean j0;
    public int k0;
    public final String l0;
    public String m0;
    public ImageView n0;
    public boolean o0;
    public boolean p0;
    public float q0;
    public float r0;
    public int s0;
    public int t0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebPopWindow f11620e;

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
            this.f11620e = swanAppWebPopWindow;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && f.d(this.f11620e.U)) {
                SwanAppWebPopWindow.super.r();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SwanAppWebPopPullLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebPopWindow f11621a;

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
            this.f11621a = swanAppWebPopWindow;
        }

        @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.b
        public boolean a(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f11621a.p0 = false;
                    if (this.f11621a.X.d()) {
                        return true;
                    }
                    this.f11621a.r0 = motionEvent.getRawX();
                    this.f11621a.q0 = motionEvent.getRawY();
                } else if (action == 2) {
                    if (this.f11621a.X.d()) {
                        return true;
                    }
                    int scaledTouchSlop = ViewConfiguration.get(this.f11621a.U).getScaledTouchSlop();
                    float rawY = motionEvent.getRawY() - this.f11621a.q0;
                    float rawX = motionEvent.getRawX() - this.f11621a.r0;
                    if (!this.f11621a.p0 && Math.abs(rawY) > scaledTouchSlop) {
                        this.f11621a.p0 = true;
                    }
                    if (this.f11621a.p0) {
                        if (this.f11621a.a0 != null && this.f11621a.a0.getChildAt(0) != null && this.f11621a.a0.getChildAt(0).getTop() == 0 && this.f11621a.c0.getWebViewScrollY() == 0 && motionEvent.getRawY() - this.f11621a.q0 > 0.0f) {
                            return true;
                        }
                        this.f11621a.r0 = motionEvent.getRawX();
                        this.f11621a.q0 = motionEvent.getRawY();
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

    /* loaded from: classes3.dex */
    public class c extends d.a.o0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public boolean f11622c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.j.d f11623d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebPopWindow f11624e;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f11625e;

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
                this.f11625e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f11625e.f11624e.a0.removeAllViews();
                    SwanAppWebPopWindow swanAppWebPopWindow = this.f11625e.f11624e;
                    swanAppWebPopWindow.b0.l(swanAppWebPopWindow.a0, this.f11625e.f11624e.c0.covertToView());
                    SwanAppWebPopWindow swanAppWebPopWindow2 = this.f11625e.f11624e;
                    swanAppWebPopWindow2.b0.loadUrl(swanAppWebPopWindow2.l0);
                }
            }
        }

        public c(SwanAppWebPopWindow swanAppWebPopWindow, d.a.o0.a.h0.j.d dVar) {
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
            this.f11624e = swanAppWebPopWindow;
            this.f11623d = dVar;
            this.f11622c = false;
        }

        @Override // d.a.o0.a.h0.j.a, d.a.o0.a.h0.j.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f11622c = true;
                d.a.o0.a.h0.j.d dVar = this.f11623d;
                if (dVar != null) {
                    dVar.b(i2);
                }
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f11624e.U).inflate(g.aiapps_server_request_error_view, (ViewGroup) null);
                linearLayout.setBackgroundColor(-1);
                linearLayout.findViewById(d.a.o0.a.f.empty_btn_reload).setOnClickListener(new a(this));
                this.f11624e.a0.addView(linearLayout);
            }
        }

        @Override // d.a.o0.a.h0.j.a, d.a.o0.a.h0.j.d
        public void d(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
                this.f11622c = true;
                d.a.o0.a.h0.j.d dVar = this.f11623d;
                if (dVar != null) {
                    dVar.d(i2, str, str2);
                }
            }
        }

        @Override // d.a.o0.a.h0.j.a, d.a.o0.a.h0.j.d
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f11622c) {
                return;
            }
            this.f11622c = false;
            d.a.o0.a.h0.j.d dVar = this.f11623d;
            if (dVar != null) {
                dVar.e(str);
            }
            this.f11624e.s0++;
            if (this.f11624e.o0 || this.f11624e.s0 <= 1 || !this.f11624e.c0.canGoBack()) {
                this.f11624e.n0.setVisibility(8);
            } else {
                this.f11624e.n0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11626a;
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
            f11626a = iArr;
            try {
                iArr[CloseStyle.CLOSE_AT_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11626a[CloseStyle.CLOSE_AT_RIGHT.ordinal()] = 2;
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
        u0 = k.f46335a;
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
        this.j0 = true;
        this.k0 = 0;
        if (u0) {
            Log.d("SwanAppWebPopWindow", "is used");
        }
        this.U = swanAppActivity;
        this.l0 = str;
        this.i0 = new d.a.o0.a.w2.h.c();
        v0 = CloseStyle.CLOSE_AT_RIGHT;
        this.s0 = 0;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.X.setInterceptCallback(new b(this));
        }
    }

    public SwanAppWebPopWindow B0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.U == null) {
                this.U = d.a.o0.a.g1.f.V().getActivity();
            }
            this.m0 = this.U.getString(i2);
            return this;
        }
        return (SwanAppWebPopWindow) invokeI.objValue;
    }

    public SwanAppWebPopWindow C0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.m0 = str;
            return this;
        }
        return (SwanAppWebPopWindow) invokeL.objValue;
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || x()) {
            return;
        }
        if (this.U == null) {
            this.U = d.a.o0.a.g1.f.V().getActivity();
        }
        View decorView = this.U.getWindow().getDecorView();
        m0();
        if (this.j0) {
            I(false);
        }
        Q(decorView, 81, 0, 0);
        if (this.j0) {
            v().setSystemUiVisibility(this.k0 | 1024 | 4096);
            I(true);
            S();
        }
        E0();
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.W.setAlpha(0.0f);
            this.X.setTranslationY(this.Z);
            ObjectAnimator c2 = d.a.o0.a.t.b.c(this.W);
            ObjectAnimator a2 = d.a.o0.a.t.b.a(this.X);
            ArrayList arrayList = new ArrayList();
            arrayList.add(c2);
            arrayList.add(a2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.start();
        }
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && x()) {
            r();
        }
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void d(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.W.getBackground().setAlpha((int) ((1.0f - f2) * 153.0f));
        }
    }

    public void m0() {
        d.a.o0.a.w2.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (cVar = this.i0) == null) {
            return;
        }
        cVar.b(this.Y);
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && x()) {
            ObjectAnimator b2 = d.a.o0.a.t.b.b(this.W);
            ObjectAnimator d2 = d.a.o0.a.t.b.d(this.X, this.Z);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new a(this));
            animatorSet.playTogether(b2, d2);
            animatorSet.start();
        }
    }

    public final e o0(SwanAppActivity swanAppActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, swanAppActivity)) == null) ? d.a.o0.a.h0.u.g.N().X().g(swanAppActivity) : (e) invokeL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            int id = view.getId();
            if (id == d.a.o0.a.f.left_back_view) {
                this.s0--;
                if (this.c0.canGoBack()) {
                    this.c0.goBack();
                    if (this.s0 <= 1) {
                        this.n0.setVisibility(8);
                        return;
                    }
                    return;
                }
                r();
            } else if (id == d.a.o0.a.f.aiapps_half_screen_close_icon) {
                r();
            } else if (id == d.a.o0.a.f.cancel_button) {
                r();
            } else if (id == d.a.o0.a.f.mask) {
                r();
            }
        }
    }

    public final d.a.o0.a.h0.j.d p0(d.a.o0.a.h0.j.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, dVar)) == null) ? new c(this, dVar) : (d.a.o0.a.h0.j.d) invokeL.objValue;
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            n0();
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ImageView imageView = (ImageView) this.V.findViewById(d.a.o0.a.f.left_back_view);
            this.n0 = imageView;
            imageView.setOnClickListener(this);
            ((TextView) this.V.findViewById(d.a.o0.a.f.aiapps_half_screen_title)).setText(this.m0);
            ImageView imageView2 = (ImageView) this.V.findViewById(d.a.o0.a.f.aiapps_half_screen_close_icon);
            imageView2.setOnClickListener(this);
            LinearLayout linearLayout = (LinearLayout) this.V.findViewById(d.a.o0.a.f.btn_close);
            TextView textView = (TextView) this.V.findViewById(d.a.o0.a.f.cancel_button);
            textView.setBackgroundColor(-1);
            textView.setOnClickListener(this);
            int i2 = d.f11626a[v0.ordinal()];
            if (i2 == 1) {
                imageView2.setVisibility(8);
            } else if (i2 != 2) {
            } else {
                linearLayout.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [d.a.o0.a.p.e.c] */
    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int n = n0.n(d.a.o0.a.c1.a.b());
            int i2 = (int) (n * 0.68d);
            this.Z = i2;
            int i3 = this.t0;
            if (i3 > n) {
                this.Z = n;
            } else if (i2 < i3) {
                this.Z = i3;
            }
            this.X = (SwanAppWebPopPullLayout) this.V.findViewById(d.a.o0.a.f.aiapps_half_web_pop_window_body);
            this.Y = (RelativeLayout) this.V.findViewById(d.a.o0.a.f.aiapps_half_web_inner_layout);
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
            FrameLayout frameLayout = (FrameLayout) this.V.findViewById(d.a.o0.a.f.half_screen_container);
            this.a0 = frameLayout;
            frameLayout.setBackgroundColor(-1);
            this.a0.setOverScrollMode(2);
            int dimensionPixelSize = this.Z - this.U.getResources().getDimensionPixelSize(d.a.o0.a.d.swan_half_screen_action_bar_height);
            if (v0 == CloseStyle.CLOSE_AT_BOTTOM || v0 == CloseStyle.CLOSE_AT_BOTH) {
                dimensionPixelSize -= this.U.getResources().getDimensionPixelSize(d.a.o0.a.d.swan_half_screen_bottom_btn_height);
            }
            ViewGroup.LayoutParams layoutParams2 = this.a0.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
            }
            layoutParams2.height = dimensionPixelSize;
            this.a0.setLayoutParams(layoutParams2);
            e o0 = o0(this.U);
            this.b0 = o0;
            o0.Z(p0(new d.a.o0.a.h0.j.a()));
            this.c0 = this.b0.u();
            this.b0.loadUrl(this.l0);
            this.b0.l(this.a0, this.c0.covertToView());
        }
    }

    @SuppressLint({"InflateParams"})
    public SwanAppWebPopWindow u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            View findViewById = this.V.findViewById(d.a.o0.a.f.mask);
            this.W = findViewById;
            findViewById.getBackground().setAlpha(153);
            this.W.setOnClickListener(this);
            t0();
            r0();
            return this;
        }
        return (SwanAppWebPopWindow) invokeV.objValue;
    }

    public SwanAppWebPopWindow w0(CloseStyle closeStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, closeStyle)) == null) {
            v0 = closeStyle;
            return this;
        }
        return (SwanAppWebPopWindow) invokeL.objValue;
    }

    public SwanAppWebPopWindow x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ImageView imageView = (ImageView) this.V.findViewById(d.a.o0.a.f.aiapps_half_screen_icon);
            imageView.setImageDrawable(imageView.getResources().getDrawable(d.a.o0.a.e.swan_app_apply_guarantee_new));
            imageView.setVisibility(0);
            return this;
        }
        return (SwanAppWebPopWindow) invokeV.objValue;
    }

    public SwanAppWebPopWindow z0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            this.t0 = i2;
            return this;
        }
        return (SwanAppWebPopWindow) invokeI.objValue;
    }
}
