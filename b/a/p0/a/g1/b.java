package b.a.p0.a.g1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AbsoluteLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.k;
import b.a.p0.a.p.b.a.n;
import b.a.p0.a.v2.f0;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.x0;
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
    public b.a.p0.a.p.e.a f5099a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.a2.n.b f5100b;

    /* renamed from: c  reason: collision with root package name */
    public String f5101c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public SwanAppActivity f5102d;

    /* renamed from: e  reason: collision with root package name */
    public e f5103e;

    /* renamed from: f  reason: collision with root package name */
    public FullScreenFloatView f5104f;

    /* renamed from: g  reason: collision with root package name */
    public SwanAppPropertyWindow f5105g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5106h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5107i;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f5108e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f5109f;

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
            this.f5109f = bVar;
            this.f5108e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity swanAppActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (swanAppActivity = this.f5109f.f5102d) == null) {
                return;
            }
            int taskId = swanAppActivity.getTaskId();
            this.f5109f.f5102d.finish();
            if (this.f5108e) {
                this.f5109f.f5102d.overridePendingTransition(0, b.a.p0.a.a.aiapps_slide_out_to_right_zadjustment_top);
            }
            b.a.p0.a.v2.c.m().l(taskId);
        }
    }

    /* renamed from: b.a.p0.a.g1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0187b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f5110a;

        public C0187b(b bVar) {
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
            this.f5110a = bVar;
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
                this.f5110a.p().U();
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
        j = k.f6397a;
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
        this.f5100b = new b.a.p0.a.a2.n.b();
        b.a.p0.a.h0.u.g.M();
        e eVar = new e();
        this.f5103e = eVar;
        eVar.h(this);
    }

    @Override // b.a.p0.a.g1.d
    public b.a.p0.a.p.e.d A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? b.a.p0.a.h0.u.g.M().V(str) : (b.a.p0.a.p.e.d) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public AbsoluteLayout B(String str) {
        InterceptResult invokeL;
        b.a.p0.a.p.e.c s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            b.a.p0.a.p.e.d A = A(str);
            if (A == null || (s = A.s()) == null) {
                return null;
            }
            return s.getCurrentWebView();
        }
        return (AbsoluteLayout) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.p0.a.h0.g.f H = H();
            return H != null ? H.a3() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    @Nullable
    public b.a.p0.a.a2.e D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b.a.p0.a.a2.e.i() : (b.a.p0.a.a2.e) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    @CallSuper
    public void E(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, bVar2) == null) {
            P();
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
    public final b.a.p0.a.k2.f.d G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null) {
                return new b.a.p0.a.k2.f.b();
            }
            return P.V();
        }
        return (b.a.p0.a.k2.f.d) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public b.a.p0.a.h0.g.f H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b.a.p0.a.h0.g.g S = S();
            if (S == null) {
                return null;
            }
            return S.o();
        }
        return (b.a.p0.a.h0.g.f) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public void I() {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && j() && (eVar = this.f5103e) != null) {
            eVar.i();
        }
    }

    @Override // b.a.p0.a.g1.d
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, activity)) == null) {
            P();
            if (activity == null) {
                return null;
            }
            if (this.f5105g == null && (viewGroup = (ViewGroup) activity.findViewById(b.a.p0.a.f.ai_apps_activity_root)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.f5105g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.f5105g);
            }
            return this.f5105g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public n K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (n) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public SwanCoreVersion L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            P();
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            b.a M = i2 != null ? i2.M() : null;
            return M != null && ((j && M.l0()) || b.a.p0.a.v.a.g(M) || b.a.p0.a.v.a.d(M));
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.g1.d
    @CallSuper
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f5107i = true;
            e eVar = this.f5103e;
            if (eVar != null) {
                eVar.j();
                this.f5103e = null;
            }
            b.a.p0.a.v1.a.b.b.a.b().d();
            T();
            if (!b.a.p0.a.r1.l.e.g()) {
                b.a.p0.a.f1.c.b.c().a();
                b.a.p0.a.r1.r.a.f().b();
            }
            if (b.a.p0.a.r1.l.e.j()) {
                b.a.p0.a.r1.l.f.a.e().g(b.a.p0.a.a2.d.g().getAppId());
            } else {
                b.a.p0.a.r1.l.f.a.e().f();
                b.a.p0.a.n1.q.c.a.o();
            }
            b.a.p0.a.l2.b.u(true);
            this.f5102d = null;
        }
    }

    @Override // b.a.p0.a.g1.d
    public n O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (n) invokeV.objValue;
    }

    public void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && getActivity() == null && j) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    public final void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.f5102d == null) {
            return;
        }
        q0.b0(new a(this, z));
    }

    @NonNull
    public Pair<Integer, Integer> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            b.a.p0.a.h0.g.f H = H();
            if (H == null) {
                return new Pair<>(0, 0);
            }
            return H.U2();
        }
        return (Pair) invokeV.objValue;
    }

    public b.a.p0.a.h0.g.g S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            SwanAppActivity swanAppActivity = this.f5102d;
            if (swanAppActivity == null) {
                return null;
            }
            return swanAppActivity.getSwanAppFragmentManager();
        }
        return (b.a.p0.a.h0.g.g) invokeV.objValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            FullScreenFloatView fullScreenFloatView = this.f5104f;
            if (fullScreenFloatView != null) {
                ViewParent parent = fullScreenFloatView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f5104f);
                }
            }
            b.a.p0.a.p.e.a aVar = this.f5099a;
            if (aVar != null) {
                aVar.E();
            }
            b.a.p0.a.e0.c.e();
        }
    }

    @Override // b.a.p0.a.g1.d
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null || P.M() == null) {
                return null;
            }
            return b.a.p0.a.f1.e.b.j1(P.M(), f.T().r());
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f5106h = true;
        }
    }

    @Override // b.a.p0.a.g1.d
    @CallSuper
    public void c(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, bVar, bVar2) == null) {
            P();
        }
    }

    @Override // b.a.p0.a.g1.d
    @NonNull
    public b.a.p0.a.a2.n.g d(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, str, swanAppConfigData, str2)) == null) {
            if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
                return this.f5100b.b(str2, str, swanAppConfigData.f44232e);
            }
            return e(str);
        }
        return (b.a.p0.a.a2.n.g) invokeLLL.objValue;
    }

    @Override // b.a.p0.a.g1.d
    @NonNull
    public b.a.p0.a.a2.n.g e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            SwanAppConfigData r = r();
            if (r == null) {
                if (j) {
                    String str2 = "mConfigData is null." + Log.getStackTraceString(new Exception());
                }
                return b.a.p0.a.a2.n.g.d();
            }
            return this.f5100b.b(z(), str, r.f44232e);
        }
        return (b.a.p0.a.a2.n.g) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            Q(true);
        }
    }

    @Override // b.a.p0.a.g1.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            SwanAppConfigData r = r();
            return r == null ? "" : r.e();
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.e.b
    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            P();
            b.a.p0.a.v2.c.m().x(this.f5102d);
            Q(false);
        }
    }

    @Override // b.a.p0.a.g1.d
    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? b.a.p0.a.a2.d.g().x() : (SwanAppActivity) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public b.a.p0.a.p.e.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            b.a.p0.a.p.e.d A = A(C());
            if (A == null) {
                return null;
            }
            return A.s();
        }
        return (b.a.p0.a.p.e.c) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public b.a.p0.a.a2.n.g i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            SwanAppConfigData r = r();
            if (r == null) {
                if (j) {
                    String str2 = "mConfigData is null." + Log.getStackTraceString(new Exception());
                }
                return b.a.p0.a.a2.n.g.d();
            }
            return this.f5100b.a(z(), str, r.f44232e);
        }
        return (b.a.p0.a.a2.n.g) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public void k(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, swanAppActivity) == null) {
            this.f5102d = swanAppActivity;
        }
    }

    @Override // b.a.p0.a.g1.d
    public void l(String str, b.a.p0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, str, aVar) == null) {
            b.a.p0.a.h0.u.g.M().H0(str, aVar);
        }
    }

    @Override // b.a.p0.a.g1.d
    public FullScreenFloatView m(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, activity)) == null) {
            P();
            if (activity == null) {
                return null;
            }
            if (this.f5104f == null) {
                FullScreenFloatView a2 = b.a.p0.a.z1.a.a.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
                this.f5104f = a2;
                a2.setFloatButtonText(activity.getString(b.a.p0.a.h.aiapps_sconsole));
                this.f5104f.setFloatImageBackground(b.a.p0.a.e.aiapps_float_view_button_shape);
                this.f5104f.setVisibility(8);
                this.f5104f.setDragImageListener(new C0187b(this));
            }
            return this.f5104f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public void n() {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (x = b.a.p0.a.a2.d.g().x()) == null || x.isFinishing()) {
            return;
        }
        x.removeLoadingView();
    }

    @Override // b.a.p0.a.g1.d
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.f5106h = false;
        }
    }

    @Override // b.a.p0.a.g1.d
    @DebugTrace
    public b.a.p0.a.p.e.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            b.a.p0.a.p.e.a b2 = b.a.p0.a.e0.c.b();
            SwanAppActivity swanAppActivity = this.f5102d;
            if (swanAppActivity != null) {
                b2.F((ViewGroup) swanAppActivity.findViewById(b.a.p0.a.f.ai_apps_activity_root));
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            Pair<Integer, Integer> R = R();
            int intValue = ((Integer) R.first).intValue();
            int intValue2 = ((Integer) R.second).intValue();
            if (intValue == 0) {
                intValue = n0.o(AppRuntime.getAppContext());
            }
            if (intValue2 == 0) {
                intValue2 = n0.v(AppRuntime.getAppContext());
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public SwanAppConfigData r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            b.a.p0.a.a2.d g2 = b.a.p0.a.a2.d.g();
            if (g2.C()) {
                return g2.r().E();
            }
            return null;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.d
    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, context) == null) || this.f5103e == null) {
            return;
        }
        P();
        this.f5103e.c(context);
    }

    @Override // b.a.p0.a.g1.d
    public void s(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, intent) == null) {
            b.a.p0.a.h0.u.g.M().o0(intent);
        }
    }

    @Override // b.a.p0.a.g1.d
    public void t() {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (x = b.a.p0.a.a2.d.g().x()) == null || x.isFinishing()) {
            return;
        }
        x.showLoadingView();
    }

    @Override // b.a.p0.a.g1.d
    public void u(b.a.p0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, aVar) == null) {
            b.a.p0.a.h0.u.g.M().G0(aVar);
        }
    }

    @Override // b.a.p0.a.g1.d
    public void unregisterReceiver(Context context) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, context) == null) || (eVar = this.f5103e) == null) {
            return;
        }
        eVar.f(context);
    }

    @Override // b.a.p0.a.g1.d
    @CallSuper
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            P();
            String U = b.a.p0.a.a2.e.U();
            if (TextUtils.isEmpty(U)) {
                return;
            }
            this.f5106h = true;
            this.f5103e.j();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", U);
            bundle.putInt("task_id", getActivity().getTaskId());
            b.a.p0.a.v1.c.a.e().h(new b.a.p0.a.v1.c.c(9, bundle));
            b.a.p0.a.c1.a.D().c(b.a.p0.a.a2.e.P() == null ? "" : b.a.p0.a.a2.e.P().k());
        }
    }

    @Override // b.a.p0.a.g1.d
    @CallSuper
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            String U = b.a.p0.a.a2.e.U();
            if (TextUtils.isEmpty(U)) {
                return;
            }
            I();
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P != null) {
                P.B().e(P.getAppId());
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", U);
            bundle.putInt("task_id", x0.b().a());
            b.a.p0.a.v1.c.a.e().h(new b.a.p0.a.v1.c.c(10, bundle));
            b.a.p0.a.c1.a.D().a(b.a.p0.a.a2.e.P() == null ? "" : b.a.p0.a.a2.e.P().k());
            b.a.p0.a.c1.a.c().b(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // b.a.p0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        Window window;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int n = n0.n(appContext);
            int measuredHeight = (b.a.p0.a.a2.d.g().x() == null || (window = b.a.p0.a.a2.d.g().x().getWindow()) == null || (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) == null || !viewGroup.isLaidOut()) ? 0 : viewGroup.getMeasuredHeight();
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
    public void y(b.a.p0.a.o0.d.d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048623, this, dVar, z) == null) {
            b.a.p0.a.r1.g.a("postMessage", "handleNativeMessage start.");
            if (dVar == null) {
                return;
            }
            b.a.p0.a.o0.d.g gVar = new b.a.p0.a.o0.d.g();
            gVar.f7118c = dVar.f7110b;
            gVar.f7119d = z;
            if (j) {
                String str = "handleNativeMessage data: " + dVar.f7110b + " ; needEncode = " + z;
            }
            l(dVar.f7109a, gVar);
            b.a.p0.a.r1.g.a("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // b.a.p0.a.g1.d
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? TextUtils.isEmpty(this.f5101c) ? "" : this.f5101c : (String) invokeV.objValue;
    }
}
