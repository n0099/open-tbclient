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
import com.baidu.tieba.R;
import com.baidu.tieba.cs1;
import com.baidu.tieba.mn2;
import com.baidu.tieba.mq1;
import com.baidu.tieba.og3;
import com.baidu.tieba.oq1;
import com.baidu.tieba.pj3;
import com.baidu.tieba.pk1;
import com.baidu.tieba.q52;
import com.baidu.tieba.sp2;
import com.baidu.tieba.t52;
import com.baidu.tieba.wh3;
import com.baidu.tieba.za2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
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
    public oq1 X;
    public mq1 Y;
    public final pj3 Z;
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
    public int q0;

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class c extends q52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean c;
        public final /* synthetic */ t52 d;
        public final /* synthetic */ SwanAppWebPopWindow e;

        /* loaded from: classes3.dex */
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
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.e.W.removeAllViews();
                    SwanAppWebPopWindow swanAppWebPopWindow = this.a.e;
                    swanAppWebPopWindow.X.j(swanAppWebPopWindow.W, this.a.e.Y.covertToView());
                    SwanAppWebPopWindow swanAppWebPopWindow2 = this.a.e;
                    swanAppWebPopWindow2.X.loadUrl(swanAppWebPopWindow2.c0);
                }
            }
        }

        public c(SwanAppWebPopWindow swanAppWebPopWindow, t52 t52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebPopWindow, t52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = swanAppWebPopWindow;
            this.d = t52Var;
            this.c = false;
        }

        @Override // com.baidu.tieba.q52, com.baidu.tieba.t52
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.c = true;
                t52 t52Var = this.d;
                if (t52Var != null) {
                    t52Var.a(i);
                }
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.e.Q).inflate(R.layout.obfuscated_res_0x7f0d00d0, (ViewGroup) null);
                linearLayout.setBackgroundColor(-1);
                linearLayout.findViewById(R.id.obfuscated_res_0x7f0908fa).setOnClickListener(new a(this));
                this.e.W.addView(linearLayout);
            }
        }

        @Override // com.baidu.tieba.q52, com.baidu.tieba.t52
        public void e(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || this.c) {
                return;
            }
            this.c = false;
            t52 t52Var = this.d;
            if (t52Var != null) {
                t52Var.e(str);
            }
            this.e.j0++;
            if (!this.e.f0 && this.e.j0 > 1 && this.e.Y.canGoBack()) {
                this.e.e0.setVisibility(0);
            } else {
                this.e.e0.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.q52, com.baidu.tieba.t52
        public void c(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2) == null) {
                this.c = true;
                t52 t52Var = this.d;
                if (t52Var != null) {
                    t52Var.c(i, str, str2);
                }
            }
        }
    }

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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (CloseStyle) Enum.valueOf(CloseStyle.class, str);
            }
            return (CloseStyle) invokeL.objValue;
        }

        public static CloseStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (CloseStyle[]) $VALUES.clone();
            }
            return (CloseStyle[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, animator) != null) || !og3.d(this.a.Q)) {
                return;
            }
            SwanAppWebPopWindow.super.r();
        }
    }

    /* loaded from: classes3.dex */
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
                if (action != 0) {
                    if (action == 2) {
                        if (this.a.T.d()) {
                            return true;
                        }
                        int scaledTouchSlop = ViewConfiguration.get(this.a.Q).getScaledTouchSlop();
                        float rawY = motionEvent.getRawY() - this.a.h0;
                        float rawX = motionEvent.getRawX() - this.a.i0;
                        if (!this.a.g0 && Math.abs(rawY) > scaledTouchSlop) {
                            this.a.g0 = true;
                        }
                        if (this.a.g0) {
                            if (this.a.W != null && this.a.W.getChildAt(0) != null && this.a.W.getChildAt(0).getTop() == 0 && this.a.Y.getWebViewScrollY() == 0 && motionEvent.getRawY() - this.a.h0 > 0.0f) {
                                return true;
                            }
                            this.a.i0 = motionEvent.getRawX();
                            this.a.h0 = motionEvent.getRawY();
                        }
                        if (Math.abs(rawX) > Math.abs(rawY)) {
                            return true;
                        }
                    }
                } else {
                    this.a.g0 = false;
                    if (this.a.T.d()) {
                        return true;
                    }
                    this.a.i0 = motionEvent.getRawX();
                    this.a.h0 = motionEvent.getRawY();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
        r0 = pk1.a;
    }

    @Override // com.baidu.swan.apps.view.SwanAppWebPopPullLayout.c
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !x()) {
            return;
        }
        r();
    }

    public void g0() {
        pj3 pj3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (pj3Var = this.Z) != null) {
            pj3Var.b(this.U);
        }
    }

    public SwanAppWebPopWindow o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ImageView imageView = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f0901a0);
            imageView.setImageDrawable(imageView.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08117a));
            imageView.setVisibility(0);
            return this;
        }
        return (SwanAppWebPopWindow) invokeV.objValue;
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.T.setInterceptCallback(new b(this));
        }
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            h0();
        }
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
        this.a0 = true;
        this.b0 = 0;
        if (r0) {
            Log.d("SwanAppWebPopWindow", "is used");
        }
        this.Q = swanAppActivity;
        this.c0 = str;
        this.Z = new pj3();
        s0 = CloseStyle.CLOSE_AT_RIGHT;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            this.S.getBackground().setAlpha((int) ((1.0f - f) * 153.0f));
        }
    }

    public final oq1 i0(SwanAppActivity swanAppActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, swanAppActivity)) == null) {
            return za2.U().f0().i(swanAppActivity);
        }
        return (oq1) invokeL.objValue;
    }

    public final t52 j0(t52 t52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t52Var)) == null) {
            return new c(this, t52Var);
        }
        return (t52) invokeL.objValue;
    }

    public SwanAppWebPopWindow n0(CloseStyle closeStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, closeStyle)) == null) {
            s0 = closeStyle;
            return this;
        }
        return (SwanAppWebPopWindow) invokeL.objValue;
    }

    public SwanAppWebPopWindow p0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            this.q0 = i;
            return this;
        }
        return (SwanAppWebPopWindow) invokeI.objValue;
    }

    public SwanAppWebPopWindow r0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            if (this.Q == null) {
                this.Q = sp2.U().getActivity();
            }
            this.d0 = this.Q.getString(i);
            return this;
        }
        return (SwanAppWebPopWindow) invokeI.objValue;
    }

    public SwanAppWebPopWindow s0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.d0 = str;
            return this;
        }
        return (SwanAppWebPopWindow) invokeL.objValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !x()) {
            return;
        }
        ObjectAnimator b2 = cs1.b(this.S);
        ObjectAnimator d2 = cs1.d(this.T, this.V);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new a(this));
        animatorSet.playTogether(b2, d2);
        animatorSet.start();
    }

    @SuppressLint({"InflateParams"})
    public SwanAppWebPopWindow m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            View findViewById = this.R.findViewById(R.id.obfuscated_res_0x7f0914fa);
            this.S = findViewById;
            findViewById.getBackground().setAlpha(153);
            this.S.setOnClickListener(this);
            l0();
            k0();
            return this;
        }
        return (SwanAppWebPopWindow) invokeV.objValue;
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.S.setAlpha(0.0f);
            this.T.setTranslationY(this.V);
            ObjectAnimator c2 = cs1.c(this.S);
            ObjectAnimator a2 = cs1.a(this.T);
            ArrayList arrayList = new ArrayList();
            arrayList.add(c2);
            arrayList.add(a2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.start();
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ImageView imageView = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f0912ff);
            this.e0 = imageView;
            imageView.setOnClickListener(this);
            ((TextView) this.R.findViewById(R.id.obfuscated_res_0x7f0901a1)).setText(this.d0);
            ImageView imageView2 = (ImageView) this.R.findViewById(R.id.obfuscated_res_0x7f09019f);
            imageView2.setOnClickListener(this);
            LinearLayout linearLayout = (LinearLayout) this.R.findViewById(R.id.obfuscated_res_0x7f090446);
            TextView textView = (TextView) this.R.findViewById(R.id.obfuscated_res_0x7f0904b0);
            textView.setBackgroundColor(-1);
            textView.setOnClickListener(this);
            int i = d.a[s0.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            imageView2.setVisibility(8);
        }
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [com.baidu.tieba.mq1] */
    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int n = wh3.n(mn2.c());
            int i = (int) (n * 0.68d);
            this.V = i;
            int i2 = this.q0;
            if (i2 > n) {
                this.V = n;
            } else if (i < i2) {
                this.V = i2;
            }
            this.T = (SwanAppWebPopPullLayout) this.R.findViewById(R.id.obfuscated_res_0x7f0901a4);
            this.U = (RelativeLayout) this.R.findViewById(R.id.obfuscated_res_0x7f0901a2);
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
            FrameLayout frameLayout = (FrameLayout) this.R.findViewById(R.id.obfuscated_res_0x7f090d4d);
            this.W = frameLayout;
            frameLayout.setBackgroundColor(-1);
            this.W.setOverScrollMode(2);
            int dimensionPixelSize = this.V - this.Q.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070682);
            if (s0 == CloseStyle.CLOSE_AT_BOTTOM || s0 == CloseStyle.CLOSE_AT_BOTH) {
                dimensionPixelSize -= this.Q.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070683);
            }
            ViewGroup.LayoutParams layoutParams2 = this.W.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
            }
            layoutParams2.height = dimensionPixelSize;
            this.W.setLayoutParams(layoutParams2);
            oq1 i0 = i0(this.Q);
            this.X = i0;
            i0.Y(j0(new q52()));
            this.Y = this.X.r();
            this.X.loadUrl(this.c0);
            this.X.j(this.W, this.Y.covertToView());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0912ff) {
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
            } else if (id == R.id.obfuscated_res_0x7f09019f) {
                r();
            } else if (id == R.id.obfuscated_res_0x7f0904b0) {
                r();
            } else if (id == R.id.obfuscated_res_0x7f0914fa) {
                r();
            }
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || x()) {
            return;
        }
        if (this.Q == null) {
            this.Q = sp2.U().getActivity();
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
