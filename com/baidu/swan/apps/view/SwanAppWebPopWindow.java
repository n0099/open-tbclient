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
import c.a.n0.a.f.e.e;
import c.a.n0.a.p2.f;
import c.a.n0.a.p2.n0;
import c.a.n0.a.x.u.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppWebPopPullLayout;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppWebPopWindow extends PopupWindow implements SwanAppWebPopPullLayout.c, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r0;
    public static CloseStyle s0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity Q;
    public final FrameLayout R;
    public View S;
    public SwanAppWebPopPullLayout T;
    public RelativeLayout U;
    public int V;
    public FrameLayout W;
    public e X;
    public c.a.n0.a.f.e.c Y;
    public final c.a.n0.a.q2.h.c Z;
    public boolean g0;
    public int h0;
    public final String i0;
    public String j0;
    public ImageView k0;
    public boolean l0;
    public boolean m0;
    public float n0;
    public float o0;
    public int p0;
    public int q0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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

        public CloseStyle(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebPopWindow a;

        public a(SwanAppWebPopWindow swanAppWebPopWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebPopWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppWebPopWindow;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && f.d(this.a.Q)) {
                SwanAppWebPopWindow.super.r();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    this.a.m0 = false;
                    if (this.a.T.d()) {
                        return true;
                    }
                    this.a.o0 = motionEvent.getRawX();
                    this.a.n0 = motionEvent.getRawY();
                } else if (action == 2) {
                    if (this.a.T.d()) {
                        return true;
                    }
                    int scaledTouchSlop = ViewConfiguration.get(this.a.Q).getScaledTouchSlop();
                    float rawY = motionEvent.getRawY() - this.a.n0;
                    float rawX = motionEvent.getRawX() - this.a.o0;
                    if (!this.a.m0 && Math.abs(rawY) > scaledTouchSlop) {
                        this.a.m0 = true;
                    }
                    if (this.a.m0) {
                        if (this.a.W != null && this.a.W.getChildAt(0) != null && this.a.W.getChildAt(0).getTop() == 0 && this.a.Y.getWebViewScrollY() == 0 && motionEvent.getRawY() - this.a.n0 > 0.0f) {
                            return true;
                        }
                        this.a.o0 = motionEvent.getRawX();
                        this.a.n0 = motionEvent.getRawY();
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

    /* loaded from: classes4.dex */
    public class c extends c.a.n0.a.x.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public boolean f29347c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.j.d f29348d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebPopWindow f29349e;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.a.f29349e.W.removeAllViews();
                    SwanAppWebPopWindow swanAppWebPopWindow = this.a.f29349e;
                    swanAppWebPopWindow.X.l(swanAppWebPopWindow.W, this.a.f29349e.Y.covertToView());
                    SwanAppWebPopWindow swanAppWebPopWindow2 = this.a.f29349e;
                    swanAppWebPopWindow2.X.loadUrl(swanAppWebPopWindow2.i0);
                }
            }
        }

        public c(SwanAppWebPopWindow swanAppWebPopWindow, c.a.n0.a.x.j.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebPopWindow, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29349e = swanAppWebPopWindow;
            this.f29348d = dVar;
            this.f29347c = false;
        }

        @Override // c.a.n0.a.x.j.a, c.a.n0.a.x.j.d
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.f29347c = true;
                c.a.n0.a.x.j.d dVar = this.f29348d;
                if (dVar != null) {
                    dVar.b(i);
                }
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f29349e.Q).inflate(R.layout.obfuscated_res_0x7f0d00d3, (ViewGroup) null);
                linearLayout.setBackgroundColor(-1);
                linearLayout.findViewById(R.id.obfuscated_res_0x7f0908bb).setOnClickListener(new a(this));
                this.f29349e.W.addView(linearLayout);
            }
        }

        @Override // c.a.n0.a.x.j.a, c.a.n0.a.x.j.d
        public void d(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2) == null) {
                this.f29347c = true;
                c.a.n0.a.x.j.d dVar = this.f29348d;
                if (dVar != null) {
                    dVar.d(i, str, str2);
                }
            }
        }

        @Override // c.a.n0.a.x.j.a, c.a.n0.a.x.j.d
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f29347c) {
                return;
            }
            this.f29347c = false;
            c.a.n0.a.x.j.d dVar = this.f29348d;
            if (dVar != null) {
                dVar.e(str);
            }
            this.f29349e.p0++;
            if (this.f29349e.l0 || this.f29349e.p0 <= 1 || !this.f29349e.Y.canGoBack()) {
                this.f29349e.k0.setVisibility(8);
            } else {
                this.f29349e.k0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        r0 = c.a.n0.a.a.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.V = 0;
        this.g0 = true;
        this.h0 = 0;
        if (r0) {
            Log.d("SwanAppWebPopWindow", "is used");
        }
        this.Q = swanAppActivity;
        this.i0 = str;
        this.Z = new c.a.n0.a.q2.h.c();
        s0 = CloseStyle.CLOSE_AT_RIGHT;
        this.p0 = 0;
        D(false);
        F(true);
        J(true);
        C(new ColorDrawable(0));
        L(-1);
        G(-1);
        if (Build.VERSION.SDK_INT > 29) {
            H(true);
        }
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.Q).inflate(R.layout.obfuscated_res_0x7f0d00b3, (ViewGroup) null);
        this.R = frameLayout;
        frameLayout.measure(0, 0);
        E(this.R);
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
            this.S.getBackground().setAlpha((int) ((1.0f - f2) * 153.0f));
        }
    }

    public void f0() {
        c.a.n0.a.q2.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.Z) == null) {
            return;
        }
        cVar.b(this.U);
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && x()) {
            ObjectAnimator b2 = c.a.n0.a.j.b.b(this.S);
            ObjectAnimator d2 = c.a.n0.a.j.b.d(this.T, this.V);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new a(this));
            animatorSet.playTogether(b2, d2);
            animatorSet.start();
        }
    }

    public final e h0(SwanAppActivity swanAppActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, swanAppActivity)) == null) ? g.U().f0().i(swanAppActivity) : (e) invokeL.objValue;
    }

    public final c.a.n0.a.x.j.d i0(c.a.n0.a.x.j.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, dVar)) == null) ? new c(this, dVar) : (c.a.n0.a.x.j.d) invokeL.objValue;
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ImageView imageView = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f09121a);
            this.k0 = imageView;
            imageView.setOnClickListener(this);
            ((TextView) this.R.findViewById(R.id.obfuscated_res_0x7f090196)).setText(this.j0);
            ImageView imageView2 = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f090194);
            imageView2.setOnClickListener(this);
            LinearLayout linearLayout = (LinearLayout) this.R.findViewById(R.id.obfuscated_res_0x7f09040d);
            TextView textView = (TextView) this.R.findViewById(R.id.obfuscated_res_0x7f09048f);
            textView.setBackgroundColor(-1);
            textView.setOnClickListener(this);
            int i = d.a[s0.ordinal()];
            if (i == 1) {
                imageView2.setVisibility(8);
            } else if (i != 2) {
            } else {
                linearLayout.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [c.a.n0.a.f.e.c] */
    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int n = n0.n(c.a.n0.a.s0.a.c());
            int i = (int) (n * 0.68d);
            this.V = i;
            int i2 = this.q0;
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
            p0();
            FrameLayout frameLayout = (FrameLayout) this.R.findViewById(R.id.obfuscated_res_0x7f090d14);
            this.W = frameLayout;
            frameLayout.setBackgroundColor(-1);
            this.W.setOverScrollMode(2);
            int dimensionPixelSize = this.V - this.Q.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070626);
            if (s0 == CloseStyle.CLOSE_AT_BOTTOM || s0 == CloseStyle.CLOSE_AT_BOTH) {
                dimensionPixelSize -= this.Q.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070627);
            }
            ViewGroup.LayoutParams layoutParams2 = this.W.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
            }
            layoutParams2.height = dimensionPixelSize;
            this.W.setLayoutParams(layoutParams2);
            e h0 = h0(this.Q);
            this.X = h0;
            h0.c0(i0(new c.a.n0.a.x.j.a()));
            this.Y = this.X.u();
            this.X.loadUrl(this.i0);
            this.X.l(this.W, this.Y.covertToView());
        }
    }

    @SuppressLint({"InflateParams"})
    public SwanAppWebPopWindow l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            View findViewById = this.R.findViewById(R.id.obfuscated_res_0x7f0913b0);
            this.S = findViewById;
            findViewById.getBackground().setAlpha(153);
            this.S.setOnClickListener(this);
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
            s0 = closeStyle;
            return this;
        }
        return (SwanAppWebPopWindow) invokeL.objValue;
    }

    public SwanAppWebPopWindow n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ImageView imageView = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f090195);
            imageView.setImageDrawable(imageView.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810fe));
            imageView.setVisibility(0);
            return this;
        }
        return (SwanAppWebPopWindow) invokeV.objValue;
    }

    public SwanAppWebPopWindow o0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.q0 = i;
            return this;
        }
        return (SwanAppWebPopWindow) invokeI.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            int id = view.getId();
            if (id == R.id.obfuscated_res_0x7f09121a) {
                this.p0--;
                if (this.Y.canGoBack()) {
                    this.Y.goBack();
                    if (this.p0 <= 1) {
                        this.k0.setVisibility(8);
                        return;
                    }
                    return;
                }
                r();
            } else if (id == R.id.obfuscated_res_0x7f090194) {
                r();
            } else if (id == R.id.obfuscated_res_0x7f09048f) {
                r();
            } else if (id == R.id.obfuscated_res_0x7f0913b0) {
                r();
            }
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.T.setInterceptCallback(new b(this));
        }
    }

    public SwanAppWebPopWindow q0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if (this.Q == null) {
                this.Q = c.a.n0.a.w0.f.U().getActivity();
            }
            this.j0 = this.Q.getString(i);
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
            this.j0 = str;
            return this;
        }
        return (SwanAppWebPopWindow) invokeL.objValue;
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || x()) {
            return;
        }
        if (this.Q == null) {
            this.Q = c.a.n0.a.w0.f.U().getActivity();
        }
        View decorView = this.Q.getWindow().getDecorView();
        f0();
        if (this.g0) {
            F(false);
        }
        N(decorView, 81, 0, 0);
        if (this.g0) {
            v().setSystemUiVisibility(this.h0 | 1024 | 4096);
            F(true);
            update();
        }
        t0();
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.S.setAlpha(0.0f);
            this.T.setTranslationY(this.V);
            ObjectAnimator c2 = c.a.n0.a.j.b.c(this.S);
            ObjectAnimator a2 = c.a.n0.a.j.b.a(this.T);
            ArrayList arrayList = new ArrayList();
            arrayList.add(c2);
            arrayList.add(a2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.start();
        }
    }
}
