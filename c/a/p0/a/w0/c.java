package c.a.p0.a.w0;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.n;
import c.a.p0.a.k.e.n.l;
import c.a.p0.a.p2.o0;
import c.a.p0.a.p2.p0;
import c.a.p0.a.p2.q;
import c.a.p0.a.p2.q0;
import c.a.p0.a.p2.y0;
import c.a.p0.a.q0.d;
import c.a.p0.a.v0.e.b;
import c.a.p0.a.v1.f.o0.g;
import c.a.p0.a.v1.f.o0.j;
import c.a.p0.q.j.i.m;
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
public class c extends c.a.p0.a.w0.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f8195e;

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
            this.f8195e = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p0.g(this.f8195e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.q0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.v0.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f8196b;

        /* loaded from: classes.dex */
        public class a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.g f8197b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f8198c;

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
                this.f8198c = bVar;
                this.a = i2;
                this.f8197b = gVar;
            }

            @Override // c.a.p0.a.v1.f.o0.g.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    c.a.p0.a.u.d.i("SwanApp", "download subpackage success");
                    b bVar = this.f8198c;
                    bVar.f8196b.X(this.a, bVar.a, this.f8197b);
                }
            }

            @Override // c.a.p0.a.v1.f.o0.g.e
            public void c(int i2, c.a.p0.a.k2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    c.a.p0.a.u.d.o("SwanApp", "download subpackage fail: " + i2);
                    this.f8198c.a.R0(null);
                    b bVar = this.f8198c;
                    bVar.f8196b.X(this.a, bVar.a, this.f8197b);
                    c.a.p0.a.k2.a aVar2 = new c.a.p0.a.k2.a();
                    aVar2.k(5L);
                    aVar2.i(38L);
                    aVar2.f("download subpackage fail, errcode=" + i2);
                    c.a.p0.a.d2.s.d dVar = new c.a.p0.a.d2.s.d();
                    dVar.q(n.n(this.f8198c.a.G()));
                    dVar.p(aVar2);
                    dVar.r(this.f8198c.a);
                    n.R(dVar);
                }
            }
        }

        public b(c cVar, c.a.p0.a.v0.e.b bVar) {
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
            this.f8196b = cVar;
            this.a = bVar;
        }

        @Override // c.a.p0.a.q0.b
        public void a(int i2, c.a.p0.a.q0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                d.g gVar = (d.g) aVar;
                if (c.a.p0.a.v1.f.o0.g.p(this.a, gVar)) {
                    if (c.a.p0.a.t1.e.L() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f2 = o0.f(this.a.e0());
                        if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                            f2 = f2.substring(1);
                        }
                        String str = gVar.f7117b.f38001c.f38034c.get(j.b(f2));
                        c.a.p0.a.v1.f.o0.g.m(this.a.H(), this.a.v1(), "3", str, gVar.f7117b.f38002d.a.get(str), this.f8196b.C(), new a(this, i2, gVar));
                        return;
                    }
                    c.a.p0.a.u.d.o("SwanApp", "subpackage is invalid");
                }
                this.f8196b.X(i2, this.a, gVar);
            }
        }
    }

    /* renamed from: c.a.p0.a.w0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0516c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v0.e.b f8199e;

        public RunnableC0516c(c cVar, c.a.p0.a.v0.e.b bVar) {
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
            this.f8199e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.e.c(this.f8199e.H(), this.f8199e.v1());
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v0.e.b f8200e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.g f8201f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f8202g;

        public d(c cVar, c.a.p0.a.v0.e.b bVar, d.g gVar) {
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
            this.f8202g = cVar;
            this.f8200e = bVar;
            this.f8201f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8202g.Y(this.f8200e, this.f8201f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v0.e.b f8203e;

        public e(c cVar, c.a.p0.a.v0.e.b bVar) {
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
            this.f8203e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.f8203e.n("fromHost");
                String n2 = this.f8203e.n("spuId");
                String n3 = this.f8203e.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !c.a.p0.a.s0.a.s0().a(n, n2, n3)) {
                    return;
                }
                this.f8203e.z("fromHost", null);
                this.f8203e.z("spuId", null);
                this.f8203e.z("contentId", null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(832859863, "Lc/a/p0/a/w0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(832859863, "Lc/a/p0/a/w0/c;");
                return;
            }
        }
        l = c.a.p0.a.a.a;
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

    @Override // c.a.p0.a.w0.b, c.a.p0.a.w0.d
    @Nullable
    public c.a.p0.a.t1.e D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.p0.a.t1.e.L() : (c.a.p0.a.t1.e) invokeV.objValue;
    }

    @Override // c.a.p0.a.w0.b, c.a.p0.a.w0.d
    public void E(c.a.p0.a.v0.e.b bVar, c.a.p0.a.q0.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2) == null) {
            super.E(bVar, bVar2);
            if (l) {
                String str = "asyncLoadSwanApp swanCoreVersion: " + bVar.j0();
            }
            c.a.p0.a.q0.d.c(bVar, new b(this, bVar));
            c.a.p0.a.x.u.g.U().d1(bVar);
            c.a.p0.a.x.u.g.U().c1(bVar);
            c.a.p0.a.x.u.g.U().H0(null);
        }
    }

    @Override // c.a.p0.a.w0.b, c.a.p0.a.w0.d
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.p0.a.x.u.g.U().d0() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // c.a.p0.a.w0.b, c.a.p0.a.w0.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            c.a.p0.a.x.t.a.d();
            c.a.p0.a.x.u.g.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            c.a.p0.a.p2.j.j();
            c.a.p0.a.z0.b.b();
            c.a.p0.a.z0.f.e.a.y();
            c.a.p0.a.h2.l.c.d.u();
            PaymentPanelManager.F();
            c.a.p0.a.h2.e.a.n();
            c.a.p0.a.h2.a.a.d();
            c.a.p0.a.h2.h.a.k();
            c.a.p0.a.l0.a.d();
            m.f();
            c.a.p0.a.d1.h.e().o();
            c.a.p0.a.v1.f.h0.a.h();
            c.a.p0.a.h2.b.d.h();
            c.a.p0.a.d1.g.k();
            if (c.a.p0.a.s0.a.I() != null) {
                c.a.p0.a.s0.a.I().e();
            }
            l.e().n();
            c.a.p0.a.p.a.b().f();
            c.a.p0.a.v1.f.f0.d.b().k();
            c.a.p0.a.o0.g.e.d();
            c.a.p0.a.k.f.a.d().h();
            c.a.p0.a.c1.d.d.g().f();
            c.a.p0.a.x.u.b.b();
            c.a.p0.a.v0.c.b.c().a();
            c.a.p0.a.k1.r.a.g().b();
            SwanPrefetchImageRes.b().e();
            c.a.p0.a.x.o.d.g().d();
            c.a.p0.a.u.g.e.c().n();
            c.a.p0.a.r2.b.c().i();
        }
    }

    public final void X(int i2, c.a.p0.a.v0.e.b bVar, d.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i2, bVar, gVar) == null) || i2 != 0 || bVar == null || gVar == null) {
            return;
        }
        c.a.p0.a.k1.h.o().F(new UbcFlowEvent("na_post_to_main_start"));
        q0.d0(this.k);
        d dVar = new d(this, bVar, gVar);
        this.k = dVar;
        q0.g0(dVar);
    }

    public final void Y(c.a.p0.a.v0.e.b bVar, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bVar, gVar) == null) {
            c.a.p0.a.k1.h.o().F(new UbcFlowEvent("na_post_to_main_end"));
            c.a.p0.a.c2.a.d().i("na_post_to_main_end");
            if (l) {
                String str = "onLoaded loadedInfo: " + gVar;
            }
            if (this.f8192i) {
                if (l) {
                    Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + f.U().z()));
                    return;
                }
                return;
            }
            this.f8186c = gVar.a;
            a0(gVar.f7117b);
            if (bVar.m0()) {
                n(this.f8187d).setVisibility(0);
                c.a.p0.a.u.a.b(true);
                c.a.p0.a.u.d.i("AppsControllerImpl", "init sConsole for devHook");
            }
            c.a.p0.a.u.d.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            c.a.p0.a.x.u.g.U().Z0(bVar, gVar);
        }
    }

    public final void Z(c.a.p0.a.v0.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || TextUtils.isEmpty(bVar.n("fromHost")) || TextUtils.isEmpty(bVar.n("spuId")) || TextUtils.isEmpty(bVar.n("contentId"))) {
            return;
        }
        q0.b0(new e(this, bVar), 2000L);
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            c.a.p0.a.t1.d J = c.a.p0.a.t1.d.J();
            if (J.D()) {
                J.r().F0(swanAppConfigData);
            }
        }
    }

    @Override // c.a.p0.a.w0.b, c.a.p0.a.w0.d
    public void d(c.a.p0.a.v0.e.b bVar, c.a.p0.a.q0.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, bVar2) == null) {
            super.d(bVar, bVar2);
            if (l) {
                String str = "syncLoadSwanApp swanCoreVersion: " + bVar.j0();
            }
            c.a.p0.a.x.u.g.U().d1(bVar);
            c.a.p0.a.x.u.g.U().H0(null);
            SwanAppConfigData P = c.a.p0.a.t1.d.J().r().P();
            if (P != null) {
                d.g gVar = new d.g();
                c.a.p0.a.k1.k.i.c.e().d(new RunnableC0516c(this, bVar), "deleteLowerVersionFolder", true);
                gVar.f7117b = P;
                gVar.a = d.e.i(bVar.H(), bVar.v1()).getPath() + File.separator;
                c.a.p0.a.k1.h.o().F(new UbcFlowEvent("na_post_to_main_start"));
                c.a.p0.a.c2.a.d().i("na_post_to_main_start");
                Y(bVar, gVar);
            }
        }
    }

    @Override // c.a.p0.a.w0.d
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = f.U().S();
            if (l) {
                String str = "onAppBackground: background alive thread count:" + S;
            }
            return this.f8191h && S <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.w0.b, c.a.p0.a.w0.d
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            c.a.p0.a.u.d.i("SwanApp", "onAppForeground");
            String f0 = c.a.p0.a.t1.e.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0);
            hashMap.put("launchId", c.a.p0.a.k1.l.d.b());
            SwanAppActivity swanAppActivity = this.f8187d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                hashMap.put("clkid", this.f8187d.getLaunchInfo().L());
                hashMap.put("scene", this.f8187d.getLaunchInfo().T());
                b.a launchInfo = this.f8187d.getLaunchInfo();
                c.a.p0.a.d2.e.v(launchInfo);
                Z(launchInfo);
            }
            u(new c.a.p0.a.e0.d.d(hashMap));
            c.a.p0.a.u.d.i("SwanApp", "onAppShow");
            c.a.p0.a.p.a.b().g(false);
            c.a.p0.a.z0.b.h(true);
            c.a.p0.a.z0.f.e.a.r(false);
            c.a.p0.a.d1.h.e().h(false);
            l.e().j();
            c.a.p0.a.d1.g.i();
            if (c.a.p0.a.s0.a.I() != null) {
                c.a.p0.a.s0.a.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (c.a.p0.a.k1.l.e.h()) {
                c.a.p0.a.k1.k.i.c.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                q.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // c.a.p0.a.w0.b, c.a.p0.a.w0.d
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            c.a.p0.a.u.d.i("SwanApp", "onAppBackground");
            String f0 = c.a.p0.a.t1.e.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0);
            contentValues.put("hiddenType", Integer.valueOf(y0.b().a()));
            u(new c.a.p0.a.e0.d.d(contentValues));
            c.a.p0.a.u.d.i("SwanApp", "onAppHide");
            y0.b().d();
            c.a.p0.a.p.a.b().g(true);
            c.a.p0.a.z0.b.h(false);
            c.a.p0.a.z0.f.e.a.r(true);
            c.a.p0.a.d1.h.e().h(true);
            c.a.p0.a.d1.g.j(false);
            if (c.a.p0.a.s0.a.I() != null) {
                c.a.p0.a.s0.a.I().c();
            }
            p0.h();
            c.a.p0.a.b1.a.i();
        }
    }
}
