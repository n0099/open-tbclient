package b.a.p0.a.g1;

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
import b.a.p0.a.f1.e.b;
import b.a.p0.a.k;
import b.a.p0.a.p.b.a.n;
import b.a.p0.a.z2.f0;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.y0;
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
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.p.e.a f5242a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.d2.n.b f5243b;

    /* renamed from: c  reason: collision with root package name */
    public String f5244c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public SwanAppActivity f5245d;

    /* renamed from: e  reason: collision with root package name */
    public e f5246e;

    /* renamed from: f  reason: collision with root package name */
    public FullScreenFloatView f5247f;

    /* renamed from: g  reason: collision with root package name */
    public SwanAppPropertyWindow f5248g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5249h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5250i;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f5251e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f5252f;

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
            this.f5252f = bVar;
            this.f5251e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity swanAppActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (swanAppActivity = this.f5252f.f5245d) == null) {
                return;
            }
            int taskId = swanAppActivity.getTaskId();
            this.f5252f.f5245d.finish();
            if (this.f5251e) {
                this.f5252f.f5245d.overridePendingTransition(0, b.a.p0.a.a.aiapps_slide_out_to_right_zadjustment_top);
            }
            b.a.p0.a.z2.c.m().l(taskId);
        }
    }

    /* renamed from: b.a.p0.a.g1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0192b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f5253a;

        public C0192b(b bVar) {
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
            this.f5253a = bVar;
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
                this.f5253a.p().X();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1323671912, "Lb/a/p0/a/g1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1323671912, "Lb/a/p0/a/g1/b;");
                return;
            }
        }
        j = k.f6863a;
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
        this.f5243b = new b.a.p0.a.d2.n.b();
        b.a.p0.a.h0.u.g.U();
        e eVar = new e();
        this.f5246e = eVar;
        eVar.h(this);
    }

    @Override // b.a.p0.a.g1.d
    public b.a.p0.a.p.e.d A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? b.a.p0.a.h0.u.g.U().e0(str) : (b.a.p0.a.p.e.d) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public View B(String str) {
        InterceptResult invokeL;
        b.a.p0.a.p.e.c t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            b.a.p0.a.p.e.d A = A(str);
            if (A == null || (t = A.t()) == null) {
                return null;
            }
            return t.getCurrentWebView();
        }
        return (View) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.p0.a.h0.g.f H = H();
            return H != null ? H.q3() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    @Nullable
    public b.a.p0.a.d2.e D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b.a.p0.a.d2.e.L() : (b.a.p0.a.d2.e) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    @CallSuper
    public void E(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, bVar2) == null) {
            Q();
        }
    }

    @Override // b.a.p0.a.g1.d
    public b.a.p0.a.p.b.a.k F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (b.a.p0.a.p.b.a.k) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    @NonNull
    public final b.a.p0.a.o2.f.d G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                return new b.a.p0.a.o2.f.b();
            }
            return a0.g0();
        }
        return (b.a.p0.a.o2.f.d) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public b.a.p0.a.h0.g.f H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b.a.p0.a.h0.g.g T = T();
            if (T == null) {
                return null;
            }
            return T.o();
        }
        return (b.a.p0.a.h0.g.f) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public void I() {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && j() && (eVar = this.f5246e) != null) {
            eVar.i();
        }
    }

    @Override // b.a.p0.a.g1.d
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.f5248g == null && (viewGroup = (ViewGroup) activity.findViewById(b.a.p0.a.f.ai_apps_activity_root)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.f5248g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.f5248g);
            }
            return this.f5248g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f5244c = str;
        }
    }

    @Override // b.a.p0.a.g1.d
    public n L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (n) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Q();
            b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
            b.a X = L != null ? L.X() : null;
            return X != null && ((j && X.n0()) || b.a.p0.a.v.a.g(X) || b.a.p0.a.v.a.d(X));
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.g1.d
    @CallSuper
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f5250i = true;
            e eVar = this.f5246e;
            if (eVar != null) {
                eVar.j();
                this.f5246e = null;
            }
            b.a.p0.a.y1.a.b.b.a.b().d();
            U();
            b.a.p0.a.u1.l.g.a.e().g(b.a.p0.a.d2.d.J().getAppId());
            b.a.p0.a.p2.b.u(true);
            this.f5245d = null;
        }
    }

    @Override // b.a.p0.a.g1.d
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
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && getActivity() == null && j) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    public final void R(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.f5245d == null) {
            return;
        }
        q0.e0(new a(this, z));
    }

    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.a.p0.a.h0.g.f H = H();
            if (H == null) {
                return new Pair<>(0, 0);
            }
            return H.k3();
        }
        return (Pair) invokeV.objValue;
    }

    public b.a.p0.a.h0.g.g T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SwanAppActivity swanAppActivity = this.f5245d;
            if (swanAppActivity == null) {
                return null;
            }
            return swanAppActivity.getSwanAppFragmentManager();
        }
        return (b.a.p0.a.h0.g.g) invokeV.objValue;
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            FullScreenFloatView fullScreenFloatView = this.f5247f;
            if (fullScreenFloatView != null) {
                ViewParent parent = fullScreenFloatView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f5247f);
                }
            }
            b.a.p0.a.p.e.a aVar = this.f5242a;
            if (aVar != null) {
                aVar.F();
            }
            b.a.p0.a.e0.c.e();
        }
    }

    @Override // b.a.p0.a.g1.d
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null || a0.X() == null) {
                return null;
            }
            return b.a.p0.a.f1.e.b.m1(a0.X(), f.U().r());
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f5249h = true;
        }
    }

    @Override // b.a.p0.a.g1.d
    @CallSuper
    public void c(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, bVar, bVar2) == null) {
            Q();
        }
    }

    @Override // b.a.p0.a.g1.d
    @NonNull
    public b.a.p0.a.d2.n.g d(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, str, swanAppConfigData, str2)) == null) {
            if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
                return this.f5243b.b(str2, str, swanAppConfigData.f45030e);
            }
            return e(str);
        }
        return (b.a.p0.a.d2.n.g) invokeLLL.objValue;
    }

    @Override // b.a.p0.a.g1.d
    @NonNull
    public b.a.p0.a.d2.n.g e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            SwanAppConfigData r = r();
            if (r == null) {
                if (j) {
                    String str2 = "#getPageWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception());
                }
                return b.a.p0.a.d2.n.g.d();
            }
            return this.f5243b.b(z(), str, r.f45030e);
        }
        return (b.a.p0.a.d2.n.g) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            R(true);
        }
    }

    @Override // b.a.p0.a.g1.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            SwanAppConfigData r = r();
            return r == null ? "" : r.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.e.b
    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            Q();
            b.a.p0.a.z2.c.m().x(this.f5245d);
            R(false);
        }
    }

    @Override // b.a.p0.a.g1.d
    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? b.a.p0.a.d2.d.J().x() : (SwanAppActivity) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public b.a.p0.a.p.e.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            b.a.p0.a.p.e.d A = A(C());
            if (A == null) {
                return null;
            }
            return A.t();
        }
        return (b.a.p0.a.p.e.c) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public b.a.p0.a.d2.n.g i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            SwanAppConfigData r = r();
            if (r == null) {
                if (j) {
                    String str2 = "#obtainNewWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception());
                }
                return b.a.p0.a.d2.n.g.d();
            }
            return this.f5243b.a(z(), str, r.f45030e);
        }
        return (b.a.p0.a.d2.n.g) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public void k(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, swanAppActivity) == null) {
            this.f5245d = swanAppActivity;
        }
    }

    @Override // b.a.p0.a.g1.d
    public void l(String str, b.a.p0.a.o0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, bVar) == null) {
            b.a.p0.a.h0.u.g.U().V0(str, bVar);
        }
    }

    @Override // b.a.p0.a.g1.d
    public FullScreenFloatView m(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.f5247f == null) {
                FullScreenFloatView a2 = b.a.p0.a.c2.a.a.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
                this.f5247f = a2;
                a2.setFloatButtonText(activity.getString(b.a.p0.a.h.aiapps_sconsole));
                this.f5247f.setFloatImageBackground(b.a.p0.a.e.aiapps_float_view_button_shape);
                this.f5247f.setVisibility(8);
                this.f5247f.setDragImageListener(new C0192b(this));
            }
            return this.f5247f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public void n() {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (x = b.a.p0.a.d2.d.J().x()) == null || x.isFinishing()) {
            return;
        }
        x.removeLoadingView();
    }

    @Override // b.a.p0.a.g1.d
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.f5249h = false;
        }
    }

    @Override // b.a.p0.a.g1.d
    @DebugTrace
    public b.a.p0.a.p.e.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            b.a.p0.a.p.e.a b2 = b.a.p0.a.e0.c.b();
            SwanAppActivity swanAppActivity = this.f5245d;
            if (swanAppActivity != null) {
                b2.G((ViewGroup) swanAppActivity.findViewById(b.a.p0.a.f.ai_apps_activity_root));
            }
            return b2;
        }
        return (b.a.p0.a.p.e.a) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
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

    @Override // b.a.p0.a.g1.d
    public SwanAppConfigData r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            b.a.p0.a.d2.d J = b.a.p0.a.d2.d.J();
            if (J.D()) {
                return J.r().P();
            }
            return null;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, context) == null) || this.f5246e == null) {
            return;
        }
        Q();
        this.f5246e.c(context);
    }

    @Override // b.a.p0.a.g1.d
    public void s(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, intent) == null) {
            b.a.p0.a.h0.u.g.U().z0(intent);
        }
    }

    @Override // b.a.p0.a.g1.d
    public void t() {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (x = b.a.p0.a.d2.d.J().x()) == null || x.isFinishing()) {
            return;
        }
        x.showLoadingView();
    }

    @Override // b.a.p0.a.g1.d
    public void u(b.a.p0.a.o0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bVar) == null) {
            if (!b.a.p0.a.d2.d.J().r().x0()) {
                b.a.p0.a.h0.u.g.U().U0(bVar);
                return;
            }
            b.a.p0.a.h0.u.g.U().V0(b.a.p0.a.b3.b.c().h(), bVar);
        }
    }

    @Override // b.a.p0.a.g1.d
    public void unregisterReceiver(Context context) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, context) == null) || (eVar = this.f5246e) == null) {
            return;
        }
        eVar.f(context);
    }

    @Override // b.a.p0.a.g1.d
    @CallSuper
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            Q();
            String f0 = b.a.p0.a.d2.e.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            this.f5249h = true;
            this.f5246e.j();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", f0);
            bundle.putInt("task_id", getActivity().getTaskId());
            b.a.p0.a.y1.c.a.e().h(new b.a.p0.a.y1.c.c(9, bundle));
            b.a.p0.a.c1.a.H().c(b.a.p0.a.d2.e.a0() == null ? "" : b.a.p0.a.d2.e.a0().N());
        }
    }

    @Override // b.a.p0.a.g1.d
    @CallSuper
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            String f0 = b.a.p0.a.d2.e.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            I();
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 != null) {
                a0.B().H(a0.getAppId());
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", f0);
            bundle.putInt("task_id", y0.b().a());
            b.a.p0.a.y1.c.a.e().h(new b.a.p0.a.y1.c.c(10, bundle));
            b.a.p0.a.c1.a.H().a(b.a.p0.a.d2.e.a0() == null ? "" : b.a.p0.a.d2.e.a0().N());
            b.a.p0.a.c1.a.d().d(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // b.a.p0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        Window window;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int n = n0.n(appContext);
            int measuredHeight = (b.a.p0.a.d2.d.J().x() == null || (window = b.a.p0.a.d2.d.J().x().getWindow()) == null || (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) == null || !viewGroup.isLaidOut()) ? 0 : viewGroup.getMeasuredHeight();
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
    @Override // b.a.p0.a.g1.d
    public void y(b.a.p0.a.o0.d.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, eVar, z) == null) {
            b.a.p0.a.u1.g.a("postMessage", "handleNativeMessage start.");
            if (eVar == null) {
                return;
            }
            b.a.p0.a.o0.d.h hVar = new b.a.p0.a.o0.d.h();
            hVar.f7457c = eVar.f7449b;
            hVar.f7458d = z;
            if (j) {
                String str = "handleNativeMessage data: " + eVar.f7449b + " ; needEncode = " + z;
            }
            l(eVar.f7448a, hVar);
            b.a.p0.a.u1.g.a("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // b.a.p0.a.g1.d
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? TextUtils.isEmpty(this.f5244c) ? "" : this.f5244c : (String) invokeV.objValue;
    }
}
