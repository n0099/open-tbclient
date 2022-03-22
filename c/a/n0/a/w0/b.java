package c.a.n0.a.w0;

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
import c.a.n0.a.f.b.a.k;
import c.a.n0.a.f.b.a.n;
import c.a.n0.a.p2.f0;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.y0;
import c.a.n0.a.v0.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.tieba.R;
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
    public c.a.n0.a.f.e.a a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.a.t1.n.b f6932b;

    /* renamed from: c  reason: collision with root package name */
    public String f6933c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public SwanAppActivity f6934d;

    /* renamed from: e  reason: collision with root package name */
    public e f6935e;

    /* renamed from: f  reason: collision with root package name */
    public FullScreenFloatView f6936f;

    /* renamed from: g  reason: collision with root package name */
    public SwanAppPropertyWindow f6937g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6938h;
    public boolean i;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f6939b;

        public a(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6939b = bVar;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity swanAppActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (swanAppActivity = this.f6939b.f6934d) == null) {
                return;
            }
            int taskId = swanAppActivity.getTaskId();
            this.f6939b.f6934d.finish();
            if (this.a) {
                this.f6939b.f6934d.overridePendingTransition(0, R.anim.obfuscated_res_0x7f010026);
            }
            c.a.n0.a.p2.c.m().l(taskId);
        }
    }

    /* renamed from: c.a.n0.a.w0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0507b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0507b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.q().Y();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1225886842, "Lc/a/n0/a/w0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1225886842, "Lc/a/n0/a/w0/b;");
                return;
            }
        }
        j = c.a.n0.a.a.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6932b = new c.a.n0.a.t1.n.b();
        c.a.n0.a.x.u.g.U();
        e eVar = new e();
        this.f6935e = eVar;
        eVar.h(this);
    }

    @Override // c.a.n0.a.w0.d
    public c.a.n0.a.f.e.d A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? c.a.n0.a.x.u.g.U().e0(str) : (c.a.n0.a.f.e.d) invokeL.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public View B(String str) {
        InterceptResult invokeL;
        c.a.n0.a.f.e.c u;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            c.a.n0.a.f.e.d A = A(str);
            if (A == null || (u = A.u()) == null) {
                return null;
            }
            return u.getCurrentWebView();
        }
        return (View) invokeL.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.n0.a.x.g.f H = H();
            return H != null ? H.r3() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.d
    @Nullable
    public c.a.n0.a.t1.e D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.n0.a.t1.e.L() : (c.a.n0.a.t1.e) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.d
    @CallSuper
    public void E(c.a.n0.a.v0.e.b bVar, c.a.n0.a.q0.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, bVar2) == null) {
            Q();
        }
    }

    @Override // c.a.n0.a.w0.d
    public k F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (k) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.d
    @NonNull
    public final c.a.n0.a.e2.f.d G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                return new c.a.n0.a.e2.f.b();
            }
            return a0.g0();
        }
        return (c.a.n0.a.e2.f.d) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public c.a.n0.a.x.g.f H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.n0.a.x.g.g T = T();
            if (T == null) {
                return null;
            }
            return T.o();
        }
        return (c.a.n0.a.x.g.f) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public void I() {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && k() && (eVar = this.f6935e) != null) {
            eVar.i();
        }
    }

    @Override // c.a.n0.a.w0.d
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.f6937g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f09016f)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.f6937g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.f6937g);
            }
            return this.f6937g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f6933c = str;
        }
    }

    @Override // c.a.n0.a.w0.d
    public n L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (n) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Q();
            c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
            b.a X = L != null ? L.X() : null;
            return X != null && ((j && X.n0()) || c.a.n0.a.l.a.g(X) || c.a.n0.a.l.a.d(X));
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.w0.d
    @CallSuper
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i = true;
            e eVar = this.f6935e;
            if (eVar != null) {
                eVar.j();
                this.f6935e = null;
            }
            c.a.n0.a.o1.a.b.b.a.b().d();
            U();
            c.a.n0.a.k1.l.g.a.e().g(c.a.n0.a.t1.d.J().getAppId());
            c.a.n0.a.f2.b.u(true);
            this.f6934d = null;
        }
    }

    @Override // c.a.n0.a.w0.d
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
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.f6934d == null) {
            return;
        }
        q0.e0(new a(this, z));
    }

    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.n0.a.x.g.f H = H();
            if (H == null) {
                return new Pair<>(0, 0);
            }
            return H.l3();
        }
        return (Pair) invokeV.objValue;
    }

    public c.a.n0.a.x.g.g T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SwanAppActivity swanAppActivity = this.f6934d;
            if (swanAppActivity == null) {
                return null;
            }
            return swanAppActivity.getSwanAppFragmentManager();
        }
        return (c.a.n0.a.x.g.g) invokeV.objValue;
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            FullScreenFloatView fullScreenFloatView = this.f6936f;
            if (fullScreenFloatView != null) {
                ViewParent parent = fullScreenFloatView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f6936f);
                }
            }
            c.a.n0.a.f.e.a aVar = this.a;
            if (aVar != null) {
                aVar.G();
            }
            c.a.n0.a.u.c.e();
        }
    }

    @Override // c.a.n0.a.w0.d
    public void a() {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (x = c.a.n0.a.t1.d.J().x()) == null || x.isFinishing()) {
            return;
        }
        x.showLoadingView();
    }

    @Override // c.a.n0.a.w0.d
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null || a0.X() == null) {
                return null;
            }
            return c.a.n0.a.v0.e.b.m1(a0.X(), f.U().s());
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f6938h = true;
        }
    }

    @Override // c.a.n0.a.w0.d
    @CallSuper
    public void d(c.a.n0.a.v0.e.b bVar, c.a.n0.a.q0.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, bVar, bVar2) == null) {
            Q();
        }
    }

    @Override // c.a.n0.a.w0.d
    @NonNull
    public c.a.n0.a.t1.n.g e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, str, swanAppConfigData, str2)) == null) {
            if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
                return this.f6932b.b(str2, str, swanAppConfigData.f29239e);
            }
            return f(str);
        }
        return (c.a.n0.a.t1.n.g) invokeLLL.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            R(true);
        }
    }

    @Override // c.a.n0.a.w0.d
    @NonNull
    public c.a.n0.a.t1.n.g f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#getPageWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return c.a.n0.a.t1.n.g.d();
            }
            return this.f6932b.b(z(), str, s.f29239e);
        }
        return (c.a.n0.a.t1.n.g) invokeL.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            SwanAppConfigData s = s();
            return s == null ? "" : s.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? c.a.n0.a.t1.d.J().x() : (SwanAppActivity) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.e.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            Q();
            c.a.n0.a.p2.c.m().x(this.f6934d);
            R(false);
        }
    }

    @Override // c.a.n0.a.w0.d
    public c.a.n0.a.f.e.c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            c.a.n0.a.f.e.d A = A(C());
            if (A == null) {
                return null;
            }
            return A.u();
        }
        return (c.a.n0.a.f.e.c) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public c.a.n0.a.t1.n.g j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#obtainNewWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return c.a.n0.a.t1.n.g.d();
            }
            return this.f6932b.a(z(), str, s.f29239e);
        }
        return (c.a.n0.a.t1.n.g) invokeL.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, swanAppActivity) == null) {
            this.f6934d = swanAppActivity;
        }
    }

    @Override // c.a.n0.a.w0.d
    public void m(String str, c.a.n0.a.e0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, bVar) == null) {
            c.a.n0.a.x.u.g.U().V0(str, bVar);
        }
    }

    @Override // c.a.n0.a.w0.d
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.f6936f == null) {
                FullScreenFloatView a2 = c.a.n0.a.s1.a.a.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
                this.f6936f = a2;
                a2.setFloatButtonText(activity.getString(R.string.obfuscated_res_0x7f0f01b2));
                this.f6936f.setFloatImageBackground(R.drawable.obfuscated_res_0x7f08015d);
                this.f6936f.setVisibility(8);
                this.f6936f.setDragImageListener(new C0507b(this));
            }
            return this.f6936f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public void o() {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (x = c.a.n0.a.t1.d.J().x()) == null || x.isFinishing()) {
            return;
        }
        x.removeLoadingView();
    }

    @Override // c.a.n0.a.w0.d
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.f6938h = false;
        }
    }

    @Override // c.a.n0.a.w0.d
    @DebugTrace
    public c.a.n0.a.f.e.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            c.a.n0.a.f.e.a b2 = c.a.n0.a.u.c.b();
            SwanAppActivity swanAppActivity = this.f6934d;
            if (swanAppActivity != null) {
                b2.H((ViewGroup) swanAppActivity.findViewById(R.id.obfuscated_res_0x7f09016f));
            }
            return b2;
        }
        return (c.a.n0.a.f.e.a) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.d
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

    @Override // c.a.n0.a.w0.d
    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, context) == null) || this.f6935e == null) {
            return;
        }
        Q();
        this.f6935e.c(context);
    }

    @Override // c.a.n0.a.w0.d
    public SwanAppConfigData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            c.a.n0.a.t1.d J = c.a.n0.a.t1.d.J();
            if (J.D()) {
                return J.r().P();
            }
            return null;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.d
    public void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            c.a.n0.a.x.u.g.U().z0(intent);
        }
    }

    @Override // c.a.n0.a.w0.d
    public void u(c.a.n0.a.e0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bVar) == null) {
            if (!c.a.n0.a.t1.d.J().r().x0()) {
                c.a.n0.a.x.u.g.U().U0(bVar);
                return;
            }
            c.a.n0.a.x.u.g.U().V0(c.a.n0.a.r2.b.c().h(), bVar);
        }
    }

    @Override // c.a.n0.a.w0.d
    public void unregisterReceiver(Context context) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, context) == null) || (eVar = this.f6935e) == null) {
            return;
        }
        eVar.f(context);
    }

    @Override // c.a.n0.a.w0.d
    @CallSuper
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            Q();
            String f0 = c.a.n0.a.t1.e.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            this.f6938h = true;
            this.f6935e.j();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", f0);
            bundle.putInt("task_id", getActivity().getTaskId());
            c.a.n0.a.o1.c.a.e().h(new c.a.n0.a.o1.c.c(9, bundle));
            c.a.n0.a.s0.a.H().c(c.a.n0.a.t1.e.a0() == null ? "" : c.a.n0.a.t1.e.a0().N());
        }
    }

    @Override // c.a.n0.a.w0.d
    @CallSuper
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            String f0 = c.a.n0.a.t1.e.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            I();
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 != null) {
                a0.B().H(a0.getAppId());
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", f0);
            bundle.putInt("task_id", y0.b().a());
            c.a.n0.a.o1.c.a.e().h(new c.a.n0.a.o1.c.c(10, bundle));
            c.a.n0.a.s0.a.H().a(c.a.n0.a.t1.e.a0() == null ? "" : c.a.n0.a.t1.e.a0().N());
            c.a.n0.a.s0.a.d().d(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // c.a.n0.a.w0.d
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        Window window;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int n = n0.n(appContext);
            int measuredHeight = (c.a.n0.a.t1.d.J().x() == null || (window = c.a.n0.a.t1.d.J().x().getWindow()) == null || (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) == null || !viewGroup.isLaidOut()) ? 0 : viewGroup.getMeasuredHeight();
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
    @Override // c.a.n0.a.w0.d
    public void y(c.a.n0.a.e0.d.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, eVar, z) == null) {
            c.a.n0.a.k1.g.a("postMessage", "handleNativeMessage start.");
            if (eVar == null) {
                return;
            }
            c.a.n0.a.e0.d.h hVar = new c.a.n0.a.e0.d.h();
            hVar.f4243c = eVar.f4235b;
            hVar.f4244d = z;
            if (j) {
                Log.d("AiBaseController", "handleNativeMessage data: " + eVar.f4235b + " ; needEncode = " + z);
            }
            m(eVar.a, hVar);
            c.a.n0.a.k1.g.a("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // c.a.n0.a.w0.d
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? TextUtils.isEmpty(this.f6933c) ? "" : this.f6933c : (String) invokeV.objValue;
    }
}
