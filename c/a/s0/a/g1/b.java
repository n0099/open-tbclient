package c.a.s0.a.g1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.f1.e.b;
import c.a.s0.a.k;
import c.a.s0.a.p.b.a.n;
import c.a.s0.a.z2.f0;
import c.a.s0.a.z2.n0;
import c.a.s0.a.z2.q0;
import c.a.s0.a.z2.y0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class b implements d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f6451j;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.s0.a.p.e.a a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.a.d2.n.b f6452b;

    /* renamed from: c  reason: collision with root package name */
    public String f6453c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public SwanAppActivity f6454d;

    /* renamed from: e  reason: collision with root package name */
    public e f6455e;

    /* renamed from: f  reason: collision with root package name */
    public FullScreenFloatView f6456f;

    /* renamed from: g  reason: collision with root package name */
    public SwanAppPropertyWindow f6457g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6458h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6459i;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f6460e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f6461f;

        public a(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6461f = bVar;
            this.f6460e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity swanAppActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (swanAppActivity = this.f6461f.f6454d) == null) {
                return;
            }
            int taskId = swanAppActivity.getTaskId();
            this.f6461f.f6454d.finish();
            if (this.f6460e) {
                this.f6461f.f6454d.overridePendingTransition(0, c.a.s0.a.a.aiapps_slide_out_to_right_zadjustment_top);
            }
            c.a.s0.a.z2.c.m().l(taskId);
        }
    }

    /* renamed from: c.a.s0.a.g1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0361b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0361b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q().X();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(228572772, "Lc/a/s0/a/g1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(228572772, "Lc/a/s0/a/g1/b;");
                return;
            }
        }
        f6451j = k.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6452b = new c.a.s0.a.d2.n.b();
        c.a.s0.a.h0.u.g.U();
        e eVar = new e();
        this.f6455e = eVar;
        eVar.h(this);
    }

    @Override // c.a.s0.a.g1.d
    public c.a.s0.a.p.e.d A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? c.a.s0.a.h0.u.g.U().e0(str) : (c.a.s0.a.p.e.d) invokeL.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public View B(String str) {
        InterceptResult invokeL;
        c.a.s0.a.p.e.c t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            c.a.s0.a.p.e.d A = A(str);
            if (A == null || (t = A.t()) == null) {
                return null;
            }
            return t.getCurrentWebView();
        }
        return (View) invokeL.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.s0.a.h0.g.f H = H();
            return H != null ? H.n3() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.d
    @Nullable
    public c.a.s0.a.d2.e D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.s0.a.d2.e.L() : (c.a.s0.a.d2.e) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.d
    @CallSuper
    public void E(c.a.s0.a.f1.e.b bVar, c.a.s0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, bVar2) == null) {
            Q();
        }
    }

    @Override // c.a.s0.a.g1.d
    public c.a.s0.a.p.b.a.k F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (c.a.s0.a.p.b.a.k) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.d
    @NonNull
    public final c.a.s0.a.o2.f.d G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.s0.a.d2.e a0 = c.a.s0.a.d2.e.a0();
            if (a0 == null) {
                return new c.a.s0.a.o2.f.b();
            }
            return a0.g0();
        }
        return (c.a.s0.a.o2.f.d) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public c.a.s0.a.h0.g.f H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.s0.a.h0.g.g T = T();
            if (T == null) {
                return null;
            }
            return T.o();
        }
        return (c.a.s0.a.h0.g.f) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public void I() {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && k() && (eVar = this.f6455e) != null) {
            eVar.i();
        }
    }

    @Override // c.a.s0.a.g1.d
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.f6457g == null && (viewGroup = (ViewGroup) activity.findViewById(c.a.s0.a.f.ai_apps_activity_root)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.f6457g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.f6457g);
            }
            return this.f6457g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f6453c = str;
        }
    }

    @Override // c.a.s0.a.g1.d
    public n L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (n) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Q();
            c.a.s0.a.d2.e L = c.a.s0.a.d2.e.L();
            b.a X = L != null ? L.X() : null;
            return X != null && ((f6451j && X.n0()) || c.a.s0.a.v.a.g(X) || c.a.s0.a.v.a.d(X));
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.a.g1.d
    @CallSuper
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f6459i = true;
            e eVar = this.f6455e;
            if (eVar != null) {
                eVar.j();
                this.f6455e = null;
            }
            c.a.s0.a.y1.a.b.b.a.b().d();
            U();
            c.a.s0.a.u1.l.g.a.e().g(c.a.s0.a.d2.d.J().getAppId());
            c.a.s0.a.p2.b.u(true);
            this.f6454d = null;
        }
    }

    @Override // c.a.s0.a.g1.d
    public n P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (n) invokeV.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && getActivity() == null && f6451j) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    public final void R(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.f6454d == null) {
            return;
        }
        q0.e0(new a(this, z));
    }

    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.s0.a.h0.g.f H = H();
            if (H == null) {
                return new Pair<>(0, 0);
            }
            return H.h3();
        }
        return (Pair) invokeV.objValue;
    }

    public c.a.s0.a.h0.g.g T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SwanAppActivity swanAppActivity = this.f6454d;
            if (swanAppActivity == null) {
                return null;
            }
            return swanAppActivity.getSwanAppFragmentManager();
        }
        return (c.a.s0.a.h0.g.g) invokeV.objValue;
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            FullScreenFloatView fullScreenFloatView = this.f6456f;
            if (fullScreenFloatView != null) {
                ViewParent parent = fullScreenFloatView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f6456f);
                }
            }
            c.a.s0.a.p.e.a aVar = this.a;
            if (aVar != null) {
                aVar.F();
            }
            c.a.s0.a.e0.c.e();
        }
    }

    @Override // c.a.s0.a.g1.d
    public void a() {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (x = c.a.s0.a.d2.d.J().x()) == null || x.isFinishing()) {
            return;
        }
        x.showLoadingView();
    }

    @Override // c.a.s0.a.g1.d
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            c.a.s0.a.d2.e a0 = c.a.s0.a.d2.e.a0();
            if (a0 == null || a0.X() == null) {
                return null;
            }
            return c.a.s0.a.f1.e.b.m1(a0.X(), f.U().s());
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f6458h = true;
        }
    }

    @Override // c.a.s0.a.g1.d
    @CallSuper
    public void d(c.a.s0.a.f1.e.b bVar, c.a.s0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, bVar, bVar2) == null) {
            Q();
        }
    }

    @Override // c.a.s0.a.g1.d
    @NonNull
    public c.a.s0.a.d2.n.g e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, str, swanAppConfigData, str2)) == null) {
            if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
                return this.f6452b.b(str2, str, swanAppConfigData.f39599e);
            }
            return f(str);
        }
        return (c.a.s0.a.d2.n.g) invokeLLL.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            R(true);
        }
    }

    @Override // c.a.s0.a.g1.d
    @NonNull
    public c.a.s0.a.d2.n.g f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (f6451j) {
                    String str2 = "#getPageWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception());
                }
                return c.a.s0.a.d2.n.g.d();
            }
            return this.f6452b.b(z(), str, s.f39599e);
        }
        return (c.a.s0.a.d2.n.g) invokeL.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            SwanAppConfigData s = s();
            return s == null ? "" : s.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? c.a.s0.a.d2.d.J().x() : (SwanAppActivity) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.e.b
    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            Q();
            c.a.s0.a.z2.c.m().x(this.f6454d);
            R(false);
        }
    }

    @Override // c.a.s0.a.g1.d
    public c.a.s0.a.p.e.c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            c.a.s0.a.p.e.d A = A(C());
            if (A == null) {
                return null;
            }
            return A.t();
        }
        return (c.a.s0.a.p.e.c) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public c.a.s0.a.d2.n.g j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (f6451j) {
                    String str2 = "#obtainNewWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception());
                }
                return c.a.s0.a.d2.n.g.d();
            }
            return this.f6452b.a(z(), str, s.f39599e);
        }
        return (c.a.s0.a.d2.n.g) invokeL.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, swanAppActivity) == null) {
            this.f6454d = swanAppActivity;
        }
    }

    @Override // c.a.s0.a.g1.d
    public void m(String str, c.a.s0.a.o0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, bVar) == null) {
            c.a.s0.a.h0.u.g.U().V0(str, bVar);
        }
    }

    @Override // c.a.s0.a.g1.d
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.f6456f == null) {
                FullScreenFloatView a2 = c.a.s0.a.c2.a.a.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
                this.f6456f = a2;
                a2.setFloatButtonText(activity.getString(c.a.s0.a.h.aiapps_sconsole));
                this.f6456f.setFloatImageBackground(c.a.s0.a.e.aiapps_float_view_button_shape);
                this.f6456f.setVisibility(8);
                this.f6456f.setDragImageListener(new C0361b(this));
            }
            return this.f6456f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public void o() {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (x = c.a.s0.a.d2.d.J().x()) == null || x.isFinishing()) {
            return;
        }
        x.removeLoadingView();
    }

    @Override // c.a.s0.a.g1.d
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.f6458h = false;
        }
    }

    @Override // c.a.s0.a.g1.d
    @DebugTrace
    public c.a.s0.a.p.e.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            c.a.s0.a.p.e.a b2 = c.a.s0.a.e0.c.b();
            SwanAppActivity swanAppActivity = this.f6454d;
            if (swanAppActivity != null) {
                b2.G((ViewGroup) swanAppActivity.findViewById(c.a.s0.a.f.ai_apps_activity_root));
            }
            return b2;
        }
        return (c.a.s0.a.p.e.a) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            Pair<Integer, Integer> S = S();
            int intValue = ((Integer) S.first).intValue();
            int intValue2 = ((Integer) S.second).intValue();
            if (intValue == 0) {
                intValue = n0.o(AppRuntime.getAppContext());
            }
            if (intValue2 == 0) {
                intValue2 = n0.u(AppRuntime.getAppContext());
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, context) == null) || this.f6455e == null) {
            return;
        }
        Q();
        this.f6455e.c(context);
    }

    @Override // c.a.s0.a.g1.d
    public SwanAppConfigData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            c.a.s0.a.d2.d J = c.a.s0.a.d2.d.J();
            if (J.D()) {
                return J.r().P();
            }
            return null;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.d
    public void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            c.a.s0.a.h0.u.g.U().z0(intent);
        }
    }

    @Override // c.a.s0.a.g1.d
    public void u(c.a.s0.a.o0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bVar) == null) {
            if (!c.a.s0.a.d2.d.J().r().x0()) {
                c.a.s0.a.h0.u.g.U().U0(bVar);
                return;
            }
            c.a.s0.a.h0.u.g.U().V0(c.a.s0.a.b3.b.c().h(), bVar);
        }
    }

    @Override // c.a.s0.a.g1.d
    public void unregisterReceiver(Context context) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, context) == null) || (eVar = this.f6455e) == null) {
            return;
        }
        eVar.f(context);
    }

    @Override // c.a.s0.a.g1.d
    @CallSuper
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            Q();
            String f0 = c.a.s0.a.d2.e.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            this.f6458h = true;
            this.f6455e.j();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", f0);
            bundle.putInt("task_id", getActivity().getTaskId());
            c.a.s0.a.y1.c.a.e().h(new c.a.s0.a.y1.c.c(9, bundle));
            c.a.s0.a.c1.a.H().c(c.a.s0.a.d2.e.a0() == null ? "" : c.a.s0.a.d2.e.a0().N());
        }
    }

    @Override // c.a.s0.a.g1.d
    @CallSuper
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            String f0 = c.a.s0.a.d2.e.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            I();
            c.a.s0.a.d2.e a0 = c.a.s0.a.d2.e.a0();
            if (a0 != null) {
                a0.B().H(a0.getAppId());
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", f0);
            bundle.putInt("task_id", y0.b().a());
            c.a.s0.a.y1.c.a.e().h(new c.a.s0.a.y1.c.c(10, bundle));
            c.a.s0.a.c1.a.H().a(c.a.s0.a.d2.e.a0() == null ? "" : c.a.s0.a.d2.e.a0().N());
            c.a.s0.a.c1.a.d().d(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // c.a.s0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        Window window;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int n = n0.n(appContext);
            int measuredHeight = (c.a.s0.a.d2.d.J().x() == null || (window = c.a.s0.a.d2.d.J().x().getWindow()) == null || (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) == null || !viewGroup.isLaidOut()) ? 0 : viewGroup.getMeasuredHeight();
            if (measuredHeight >= n) {
                return new Pair<>(Integer.valueOf(n0.o(appContext)), Integer.valueOf(measuredHeight));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                n += f0.e(appContext);
            }
            return new Pair<>(Integer.valueOf(n0.o(appContext)), Integer.valueOf(n));
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    @Override // c.a.s0.a.g1.d
    public void y(c.a.s0.a.o0.d.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, eVar, z) == null) {
            c.a.s0.a.u1.g.a("postMessage", "handleNativeMessage start.");
            if (eVar == null) {
                return;
            }
            c.a.s0.a.o0.d.h hVar = new c.a.s0.a.o0.d.h();
            hVar.f8285c = eVar.f8277b;
            hVar.f8286d = z;
            if (f6451j) {
                String str = "handleNativeMessage data: " + eVar.f8277b + " ; needEncode = " + z;
            }
            m(eVar.a, hVar);
            c.a.s0.a.u1.g.a("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // c.a.s0.a.g1.d
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? TextUtils.isEmpty(this.f6453c) ? "" : this.f6453c : (String) invokeV.objValue;
    }
}
