package c.a.s0.a.g1;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.a1.d;
import c.a.s0.a.f1.e.b;
import c.a.s0.a.f2.f.o0.g;
import c.a.s0.a.f2.f.o0.j;
import c.a.s0.a.k;
import c.a.s0.a.n2.n;
import c.a.s0.a.u.e.n.l;
import c.a.s0.a.z2.o0;
import c.a.s0.a.z2.p0;
import c.a.s0.a.z2.q;
import c.a.s0.a.z2.q0;
import c.a.s0.a.z2.y0;
import c.a.s0.q.k.i.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c extends c.a.s0.a.g1.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f6462e;

        public a(c cVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6462e = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p0.g(this.f6462e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.s0.a.a1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.s0.a.f1.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f6463b;

        /* loaded from: classes.dex */
        public class a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.g f6464b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f6465c;

            public a(b bVar, int i2, d.g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i2), gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6465c = bVar;
                this.a = i2;
                this.f6464b = gVar;
            }

            @Override // c.a.s0.a.f2.f.o0.g.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    c.a.s0.a.e0.d.i("SwanApp", "download subpackage success");
                    b bVar = this.f6465c;
                    bVar.f6463b.X(this.a, bVar.a, this.f6464b);
                }
            }

            @Override // c.a.s0.a.f2.f.o0.g.e
            public void c(int i2, c.a.s0.a.u2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    c.a.s0.a.e0.d.o("SwanApp", "download subpackage fail: " + i2);
                    this.f6465c.a.R0(null);
                    b bVar = this.f6465c;
                    bVar.f6463b.X(this.a, bVar.a, this.f6464b);
                    c.a.s0.a.u2.a aVar2 = new c.a.s0.a.u2.a();
                    aVar2.k(5L);
                    aVar2.i(38L);
                    aVar2.f("download subpackage fail, errcode=" + i2);
                    c.a.s0.a.n2.s.d dVar = new c.a.s0.a.n2.s.d();
                    dVar.q(n.n(this.f6465c.a.G()));
                    dVar.p(aVar2);
                    dVar.r(this.f6465c.a);
                    n.R(dVar);
                }
            }
        }

        public b(c cVar, c.a.s0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6463b = cVar;
            this.a = bVar;
        }

        @Override // c.a.s0.a.a1.b
        public void a(int i2, c.a.s0.a.a1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                d.g gVar = (d.g) aVar;
                if (c.a.s0.a.f2.f.o0.g.p(this.a, gVar)) {
                    if (c.a.s0.a.d2.e.L() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f2 = o0.f(this.a.e0());
                        if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                            f2 = f2.substring(1);
                        }
                        String str = gVar.f5384b.f39597c.f39630c.get(j.b(f2));
                        c.a.s0.a.f2.f.o0.g.m(this.a.H(), this.a.v1(), "3", str, gVar.f5384b.f39598d.a.get(str), this.f6463b.C(), new a(this, i2, gVar));
                        return;
                    }
                    c.a.s0.a.e0.d.o("SwanApp", "subpackage is invalid");
                }
                this.f6463b.X(i2, this.a, gVar);
            }
        }
    }

    /* renamed from: c.a.s0.a.g1.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0362c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.f1.e.b f6466e;

        public RunnableC0362c(c cVar, c.a.s0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6466e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.e.c(this.f6466e.H(), this.f6466e.v1());
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.f1.e.b f6467e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.g f6468f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f6469g;

        public d(c cVar, c.a.s0.a.f1.e.b bVar, d.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6469g = cVar;
            this.f6467e = bVar;
            this.f6468f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6469g.Y(this.f6467e, this.f6468f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.f1.e.b f6470e;

        public e(c cVar, c.a.s0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6470e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.f6470e.n("fromHost");
                String n2 = this.f6470e.n("spuId");
                String n3 = this.f6470e.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !c.a.s0.a.c1.a.s0().a(n, n2, n3)) {
                    return;
                }
                this.f6470e.z("fromHost", null);
                this.f6470e.z("spuId", null);
                this.f6470e.z("contentId", null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(228572803, "Lc/a/s0/a/g1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(228572803, "Lc/a/s0/a/g1/c;");
                return;
            }
        }
        l = k.a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    @Nullable
    public c.a.s0.a.d2.e D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.s0.a.d2.e.L() : (c.a.s0.a.d2.e) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public void E(c.a.s0.a.f1.e.b bVar, c.a.s0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2) == null) {
            super.E(bVar, bVar2);
            if (l) {
                String str = "asyncLoadSwanApp swanCoreVersion: " + bVar.j0();
            }
            c.a.s0.a.a1.d.c(bVar, new b(this, bVar));
            c.a.s0.a.h0.u.g.U().d1(bVar);
            c.a.s0.a.h0.u.g.U().c1(bVar);
            c.a.s0.a.h0.u.g.U().H0(null);
        }
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.s0.a.h0.u.g.U().d0() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            c.a.s0.a.h0.t.a.d();
            c.a.s0.a.h0.u.g.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            c.a.s0.a.z2.j.j();
            c.a.s0.a.j1.b.b();
            c.a.s0.a.j1.f.e.a.y();
            c.a.s0.a.r2.l.c.d.u();
            PaymentPanelManager.F();
            c.a.s0.a.r2.e.a.n();
            c.a.s0.a.r2.a.a.d();
            c.a.s0.a.r2.h.a.k();
            c.a.s0.a.v0.a.d();
            m.f();
            c.a.s0.a.n1.h.e().o();
            c.a.s0.a.f2.f.h0.a.h();
            c.a.s0.a.r2.b.d.h();
            c.a.s0.a.n1.g.k();
            if (c.a.s0.a.c1.a.I() != null) {
                c.a.s0.a.c1.a.I().e();
            }
            l.e().n();
            c.a.s0.a.z.a.b().f();
            c.a.s0.a.f2.f.f0.d.b().k();
            c.a.s0.a.y0.g.e.d();
            c.a.s0.a.u.f.a.d().h();
            c.a.s0.a.m1.d.d.g().f();
            c.a.s0.a.h0.u.b.b();
            c.a.s0.a.f1.c.b.c().a();
            c.a.s0.a.u1.r.a.g().b();
            SwanPrefetchImageRes.b().e();
            c.a.s0.a.h0.o.d.g().d();
            c.a.s0.a.e0.g.e.c().n();
            c.a.s0.a.b3.b.c().i();
        }
    }

    public final void X(int i2, c.a.s0.a.f1.e.b bVar, d.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i2, bVar, gVar) == null) || i2 != 0 || bVar == null || gVar == null) {
            return;
        }
        c.a.s0.a.u1.h.o().F(new UbcFlowEvent("na_post_to_main_start"));
        q0.d0(this.k);
        d dVar = new d(this, bVar, gVar);
        this.k = dVar;
        q0.g0(dVar);
    }

    public final void Y(c.a.s0.a.f1.e.b bVar, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bVar, gVar) == null) {
            c.a.s0.a.u1.h.o().F(new UbcFlowEvent("na_post_to_main_end"));
            c.a.s0.a.m2.a.d().i("na_post_to_main_end");
            if (l) {
                String str = "onLoaded loadedInfo: " + gVar;
            }
            if (this.f6459i) {
                if (l) {
                    Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + f.U().z()));
                    return;
                }
                return;
            }
            this.f6453c = gVar.a;
            a0(gVar.f5384b);
            if (bVar.m0()) {
                n(this.f6454d).setVisibility(0);
                c.a.s0.a.e0.a.b(true);
                c.a.s0.a.e0.d.i("AppsControllerImpl", "init sConsole for devHook");
            }
            c.a.s0.a.e0.d.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            c.a.s0.a.h0.u.g.U().Z0(bVar, gVar);
        }
    }

    public final void Z(c.a.s0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || TextUtils.isEmpty(bVar.n("fromHost")) || TextUtils.isEmpty(bVar.n("spuId")) || TextUtils.isEmpty(bVar.n("contentId"))) {
            return;
        }
        q0.b0(new e(this, bVar), 2000L);
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            c.a.s0.a.d2.d J = c.a.s0.a.d2.d.J();
            if (J.D()) {
                J.r().F0(swanAppConfigData);
            }
        }
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public void d(c.a.s0.a.f1.e.b bVar, c.a.s0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, bVar2) == null) {
            super.d(bVar, bVar2);
            if (l) {
                String str = "syncLoadSwanApp swanCoreVersion: " + bVar.j0();
            }
            c.a.s0.a.h0.u.g.U().d1(bVar);
            c.a.s0.a.h0.u.g.U().H0(null);
            SwanAppConfigData P = c.a.s0.a.d2.d.J().r().P();
            if (P != null) {
                d.g gVar = new d.g();
                c.a.s0.a.u1.k.i.c.e().d(new RunnableC0362c(this, bVar), "deleteLowerVersionFolder", true);
                gVar.f5384b = P;
                gVar.a = d.e.i(bVar.H(), bVar.v1()).getPath() + File.separator;
                c.a.s0.a.u1.h.o().F(new UbcFlowEvent("na_post_to_main_start"));
                c.a.s0.a.m2.a.d().i("na_post_to_main_start");
                Y(bVar, gVar);
            }
        }
    }

    @Override // c.a.s0.a.g1.d
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = f.U().S();
            if (l) {
                String str = "onAppBackground: background alive thread count:" + S;
            }
            return this.f6458h && S <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            c.a.s0.a.e0.d.i("SwanApp", "onAppForeground");
            String f0 = c.a.s0.a.d2.e.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0);
            hashMap.put("launchId", c.a.s0.a.u1.l.d.b());
            SwanAppActivity swanAppActivity = this.f6454d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                hashMap.put("clkid", this.f6454d.getLaunchInfo().L());
                hashMap.put("scene", this.f6454d.getLaunchInfo().T());
                b.a launchInfo = this.f6454d.getLaunchInfo();
                c.a.s0.a.n2.e.v(launchInfo);
                Z(launchInfo);
            }
            u(new c.a.s0.a.o0.d.d(hashMap));
            c.a.s0.a.e0.d.i("SwanApp", "onAppShow");
            c.a.s0.a.z.a.b().g(false);
            c.a.s0.a.j1.b.h(true);
            c.a.s0.a.j1.f.e.a.r(false);
            c.a.s0.a.n1.h.e().h(false);
            l.e().j();
            c.a.s0.a.n1.g.i();
            if (c.a.s0.a.c1.a.I() != null) {
                c.a.s0.a.c1.a.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (c.a.s0.a.u1.l.e.h()) {
                c.a.s0.a.u1.k.i.c.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                q.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            c.a.s0.a.e0.d.i("SwanApp", "onAppBackground");
            String f0 = c.a.s0.a.d2.e.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0);
            contentValues.put("hiddenType", Integer.valueOf(y0.b().a()));
            u(new c.a.s0.a.o0.d.d(contentValues));
            c.a.s0.a.e0.d.i("SwanApp", "onAppHide");
            y0.b().d();
            c.a.s0.a.z.a.b().g(true);
            c.a.s0.a.j1.b.h(false);
            c.a.s0.a.j1.f.e.a.r(true);
            c.a.s0.a.n1.h.e().h(true);
            c.a.s0.a.n1.g.j(false);
            if (c.a.s0.a.c1.a.I() != null) {
                c.a.s0.a.c1.a.I().c();
            }
            p0.h();
            c.a.s0.a.l1.a.i();
        }
    }
}
