package c.a.p0.j.x;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.k;
import c.a.p0.a.p.b.a.n;
import c.a.p0.a.z2.q0;
import c.a.p0.j.f.h;
import c.a.p0.j.f.i;
import c.a.p0.j.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@Service
/* loaded from: classes5.dex */
public class a extends c.a.p0.a.g1.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: k  reason: collision with root package name */
    public String f10495k;
    public c.a.p0.j.s.b l;
    public Runnable m;
    public c.a.p0.j.y.a n;

    /* renamed from: c.a.p0.j.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0685a implements c.a.p0.a.a1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.a1.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f10496b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f10497c;

        /* renamed from: c.a.p0.j.x.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0686a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.a1.a f10498e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f10499f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C0685a f10500g;

            public RunnableC0686a(C0685a c0685a, c.a.p0.a.a1.a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0685a, aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10500g = c0685a;
                this.f10498e = aVar;
                this.f10499f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10500g.f10497c.f5312i) {
                    return;
                }
                a.c cVar = (a.c) this.f10498e;
                if (this.f10499f != 0 || cVar == null) {
                    return;
                }
                C0685a c0685a = this.f10500g;
                if (c0685a.a == null) {
                    return;
                }
                if (c0685a.f10496b.m0()) {
                    if (!c.a.p0.j.f.d.m().n()) {
                        c.a.p0.a.e0.b.c(false);
                        this.f10500g.f10496b.z0(false);
                    } else {
                        a aVar = this.f10500g.f10497c;
                        aVar.m(aVar.f5307d).setVisibility(0);
                        this.f10500g.f10497c.p().H(this.f10500g.f10497c.f5309f);
                        c.a.p0.a.e0.a.b(true);
                        c.a.p0.a.e0.d.i("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                this.f10500g.f10497c.l.c(cVar, this.f10500g.f10497c.f5307d);
                this.f10500g.f10497c.f10495k = cVar.a;
                this.f10500g.a.a(0, cVar);
                this.f10500g.f10497c.e0(cVar.f10468c);
                c.a.p0.j.j0.a.b().e(cVar.f10468c);
            }
        }

        public C0685a(a aVar, c.a.p0.a.a1.b bVar, c.a.p0.a.f1.e.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10497c = aVar;
            this.a = bVar;
            this.f10496b = bVar2;
        }

        @Override // c.a.p0.a.a1.b
        public void a(int i2, c.a.p0.a.a1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                q0.d0(this.f10497c.m);
                this.f10497c.m = new RunnableC0686a(this, aVar, i2);
                q0.g0(this.f10497c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1100914177, "Lc/a/p0/j/x/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1100914177, "Lc/a/p0/j/x/a;");
                return;
            }
        }
        o = k.a;
    }

    public a() {
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
        this.l = new c.a.p0.j.s.b();
        this.n = new c.a.p0.j.y.a();
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public void E(c.a.p0.a.f1.e.b bVar, c.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, bVar2) == null) {
            super.E(bVar, bVar2);
            if (o) {
                String str = "asyncLoadSwanApp swanCoreVersion: " + bVar.j0();
            }
            c.a.p0.j.t.a.c(bVar, new C0685a(this, bVar2, bVar));
            c.a.p0.j.o.c.m().I(bVar);
            c.a.p0.j.o.c.m().G(bVar);
            boolean z = o;
            c.a.p0.j.o.c.m().z(null);
        }
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public c.a.p0.a.p.b.a.k F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (c.a.p0.a.p.b.a.k) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            if (this.f5310g == null && (viewGroup = (ViewGroup) activity.findViewById(f.ai_apps_activity_root)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.f5310g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.f5310g);
            }
            return this.f5310g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public n L() {
        InterceptResult invokeV;
        c.a.p0.j.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g T = T();
            if (T == null || (aVar = (c.a.p0.j.n.a) T.n(c.a.p0.j.n.a.class)) == null) {
                return null;
            }
            return aVar.z3();
        }
        return (n) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.p0.j.o.c.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.O();
            c.a.p0.j.o.c.C();
            c.a.p0.j.b0.b.a.a().d(new JsObject());
            c.a.p0.w.d.k(c.a.p0.a.r0.n.p() + File.separator + "tmp");
        }
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public n P() {
        InterceptResult invokeV;
        c.a.p0.j.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g T = T();
            if (T == null || (aVar = (c.a.p0.j.n.a) T.n(c.a.p0.j.n.a.class)) == null) {
                return null;
            }
            return aVar.x3();
        }
        return (n) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b
    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? q() : (Pair) invokeV.objValue;
    }

    public final void e0(c.a.p0.j.d0.a.a aVar) {
        c.a.p0.a.d2.e D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || (D = D()) == null) {
            return;
        }
        D.G0(aVar);
    }

    @Override // c.a.p0.a.g1.d
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f5311h : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public FullScreenFloatView m(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, activity)) == null) {
            super.m(activity);
            this.f5309f.setAutoAttachEnable(false);
            return this.f5309f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public c.a.p0.a.p.e.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == null) {
                this.a = new h(AppRuntime.getAppContext());
                i.h(true);
            }
            this.a.G((ViewGroup) this.f5307d.findViewById(16908290));
            return this.a;
        }
        return (c.a.p0.a.p.e.a) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? x() : (Pair) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.v();
            SwanAppActivity swanAppActivity = this.f5307d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                b.a launchInfo = this.f5307d.getLaunchInfo();
                c.a.p0.a.n2.s.f fVar = new c.a.p0.a.n2.s.f();
                fVar.a = c.a.p0.a.n2.n.n(1);
                fVar.f7117f = launchInfo.H();
                fVar.f7114c = launchInfo.T();
                fVar.f7113b = "show";
                fVar.d(launchInfo.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                fVar.b(c.a.p0.a.n2.n.k(launchInfo.W()));
                c.a.p0.a.n2.n.onEvent(fVar);
            }
            c.a.p0.a.j1.b.h(true);
            c.a.p0.j.b0.b.a.a().j();
        }
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            c.a.p0.a.j1.b.h(false);
            c.a.p0.j.b0.b.a.a().f();
        }
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        int i2;
        int i3;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SwanAppActivity swanAppActivity = this.f5307d;
            if (swanAppActivity == null) {
                return super.x();
            }
            Window window = swanAppActivity.getWindow();
            boolean z = false;
            if (window == null || (decorView = window.getDecorView()) == null) {
                i2 = 0;
                i3 = 0;
            } else {
                i3 = decorView.getWidth();
                i2 = decorView.getHeight();
            }
            Display defaultDisplay = this.f5307d.getWindowManager().getDefaultDisplay();
            if (i3 == 0 || i2 == 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                i3 = displayMetrics.widthPixels;
                i2 = displayMetrics.heightPixels;
            }
            if (this.f5307d.isLandScape() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
                int i4 = i3;
                i3 = i2;
                i2 = i4;
            }
            if (o) {
                String str = "getCurScreenSize width:" + i2 + ",height:" + i3;
            }
            return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TextUtils.isEmpty(this.f10495k) ? "" : this.f10495k : (String) invokeV.objValue;
    }
}
