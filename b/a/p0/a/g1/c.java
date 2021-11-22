package b.a.p0.a.g1;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.d;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.f2.f.o0.g;
import b.a.p0.a.f2.f.o0.j;
import b.a.p0.a.k;
import b.a.p0.a.n2.n;
import b.a.p0.a.u.e.n.l;
import b.a.p0.a.z2.o0;
import b.a.p0.a.z2.p0;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.y0;
import b.a.p0.q.k.i.m;
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
public class c extends b.a.p0.a.g1.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f5254e;

        public a(c cVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5254e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p0.g(this.f5254e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.a1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5255a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f5256b;

        /* loaded from: classes.dex */
        public class a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f5257a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.g f5258b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f5259c;

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
                this.f5259c = bVar;
                this.f5257a = i2;
                this.f5258b = gVar;
            }

            @Override // b.a.p0.a.f2.f.o0.g.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b.a.p0.a.e0.d.i("SwanApp", "download subpackage success");
                    b bVar = this.f5259c;
                    bVar.f5256b.X(this.f5257a, bVar.f5255a, this.f5258b);
                }
            }

            @Override // b.a.p0.a.f2.f.o0.g.e
            public void b(int i2, b.a.p0.a.u2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    b.a.p0.a.e0.d.o("SwanApp", "download subpackage fail: " + i2);
                    this.f5259c.f5255a.R0(null);
                    b bVar = this.f5259c;
                    bVar.f5256b.X(this.f5257a, bVar.f5255a, this.f5258b);
                    b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
                    aVar2.k(5L);
                    aVar2.i(38L);
                    aVar2.f("download subpackage fail, errcode=" + i2);
                    b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
                    dVar.q(n.n(this.f5259c.f5255a.G()));
                    dVar.p(aVar2);
                    dVar.r(this.f5259c.f5255a);
                    n.R(dVar);
                }
            }
        }

        public b(c cVar, b.a.p0.a.f1.e.b bVar) {
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
            this.f5256b = cVar;
            this.f5255a = bVar;
        }

        @Override // b.a.p0.a.a1.b
        public void a(int i2, b.a.p0.a.a1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                d.g gVar = (d.g) aVar;
                if (b.a.p0.a.f2.f.o0.g.p(this.f5255a, gVar)) {
                    if (b.a.p0.a.d2.e.L() != null && !TextUtils.isEmpty(gVar.f3996a)) {
                        String f2 = o0.f(this.f5255a.e0());
                        if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                            f2 = f2.substring(1);
                        }
                        String str = gVar.f3997b.f45028c.f45070c.get(j.b(f2));
                        b.a.p0.a.f2.f.o0.g.m(this.f5255a.H(), this.f5255a.v1(), "3", str, gVar.f3997b.f45029d.f45074a.get(str), this.f5256b.C(), new a(this, i2, gVar));
                        return;
                    }
                    b.a.p0.a.e0.d.o("SwanApp", "subpackage is invalid");
                }
                this.f5256b.X(i2, this.f5255a, gVar);
            }
        }
    }

    /* renamed from: b.a.p0.a.g1.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0193c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5260e;

        public RunnableC0193c(c cVar, b.a.p0.a.f1.e.b bVar) {
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
            this.f5260e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.e.c(this.f5260e.H(), this.f5260e.v1());
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5261e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.g f5262f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f5263g;

        public d(c cVar, b.a.p0.a.f1.e.b bVar, d.g gVar) {
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
            this.f5263g = cVar;
            this.f5261e = bVar;
            this.f5262f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5263g.Y(this.f5261e, this.f5262f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5264e;

        public e(c cVar, b.a.p0.a.f1.e.b bVar) {
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
            this.f5264e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.f5264e.n("fromHost");
                String n2 = this.f5264e.n("spuId");
                String n3 = this.f5264e.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !b.a.p0.a.c1.a.s0().a(n, n2, n3)) {
                    return;
                }
                this.f5264e.z("fromHost", null);
                this.f5264e.z("spuId", null);
                this.f5264e.z("contentId", null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1323671943, "Lb/a/p0/a/g1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1323671943, "Lb/a/p0/a/g1/c;");
                return;
            }
        }
        l = k.f6863a;
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

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    @Nullable
    public b.a.p0.a.d2.e D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.a.p0.a.d2.e.L() : (b.a.p0.a.d2.e) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void E(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2) == null) {
            super.E(bVar, bVar2);
            if (l) {
                String str = "asyncLoadSwanApp swanCoreVersion: " + bVar.j0();
            }
            b.a.p0.a.a1.d.c(bVar, new b(this, bVar));
            b.a.p0.a.h0.u.g.U().d1(bVar);
            b.a.p0.a.h0.u.g.U().c1(bVar);
            b.a.p0.a.h0.u.g.U().H0(null);
        }
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b.a.p0.a.h0.u.g.U().d0() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            b.a.p0.a.h0.t.a.d();
            b.a.p0.a.h0.u.g.N0(false);
            if (this.f5242a != null) {
                this.f5242a = null;
            }
            b.a.p0.a.z2.j.j();
            b.a.p0.a.j1.b.b();
            b.a.p0.a.j1.f.e.a.y();
            b.a.p0.a.r2.l.c.d.u();
            PaymentPanelManager.F();
            b.a.p0.a.r2.e.a.n();
            b.a.p0.a.r2.a.a.d();
            b.a.p0.a.r2.h.a.k();
            b.a.p0.a.v0.a.d();
            m.f();
            b.a.p0.a.n1.h.e().o();
            b.a.p0.a.f2.f.h0.a.h();
            b.a.p0.a.r2.b.d.h();
            b.a.p0.a.n1.g.k();
            if (b.a.p0.a.c1.a.I() != null) {
                b.a.p0.a.c1.a.I().e();
            }
            l.e().n();
            b.a.p0.a.z.a.b().f();
            b.a.p0.a.f2.f.f0.d.b().k();
            b.a.p0.a.y0.g.e.d();
            b.a.p0.a.u.f.a.d().h();
            b.a.p0.a.m1.d.d.g().f();
            b.a.p0.a.h0.u.b.b();
            b.a.p0.a.f1.c.b.c().a();
            b.a.p0.a.u1.r.a.g().b();
            SwanPrefetchImageRes.b().e();
            b.a.p0.a.h0.o.d.g().d();
            b.a.p0.a.e0.g.e.c().n();
            b.a.p0.a.b3.b.c().i();
        }
    }

    public final void X(int i2, b.a.p0.a.f1.e.b bVar, d.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i2, bVar, gVar) == null) || i2 != 0 || bVar == null || gVar == null) {
            return;
        }
        b.a.p0.a.u1.h.o().F(new UbcFlowEvent("na_post_to_main_start"));
        q0.d0(this.k);
        d dVar = new d(this, bVar, gVar);
        this.k = dVar;
        q0.g0(dVar);
    }

    public final void Y(b.a.p0.a.f1.e.b bVar, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bVar, gVar) == null) {
            b.a.p0.a.u1.h.o().F(new UbcFlowEvent("na_post_to_main_end"));
            b.a.p0.a.m2.a.d().i("na_post_to_main_end");
            if (l) {
                String str = "onLoaded loadedInfo: " + gVar;
            }
            if (this.f5250i) {
                if (l) {
                    Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.f3996a + ", baseUrl:" + f.U().z()));
                    return;
                }
                return;
            }
            this.f5244c = gVar.f3996a;
            a0(gVar.f3997b);
            if (bVar.m0()) {
                m(this.f5245d).setVisibility(0);
                b.a.p0.a.e0.a.b(true);
                b.a.p0.a.e0.d.i("AppsControllerImpl", "init sConsole for devHook");
            }
            b.a.p0.a.e0.d.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            b.a.p0.a.h0.u.g.U().Z0(bVar, gVar);
        }
    }

    public final void Z(b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || TextUtils.isEmpty(bVar.n("fromHost")) || TextUtils.isEmpty(bVar.n("spuId")) || TextUtils.isEmpty(bVar.n("contentId"))) {
            return;
        }
        q0.b0(new e(this, bVar), 2000L);
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            b.a.p0.a.d2.d J = b.a.p0.a.d2.d.J();
            if (J.D()) {
                J.r().F0(swanAppConfigData);
            }
        }
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void c(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, bVar2) == null) {
            super.c(bVar, bVar2);
            if (l) {
                String str = "syncLoadSwanApp swanCoreVersion: " + bVar.j0();
            }
            b.a.p0.a.h0.u.g.U().d1(bVar);
            b.a.p0.a.h0.u.g.U().H0(null);
            SwanAppConfigData P = b.a.p0.a.d2.d.J().r().P();
            if (P != null) {
                d.g gVar = new d.g();
                b.a.p0.a.u1.k.i.c.e().d(new RunnableC0193c(this, bVar), "deleteLowerVersionFolder", true);
                gVar.f3997b = P;
                gVar.f3996a = d.e.i(bVar.H(), bVar.v1()).getPath() + File.separator;
                b.a.p0.a.u1.h.o().F(new UbcFlowEvent("na_post_to_main_start"));
                b.a.p0.a.m2.a.d().i("na_post_to_main_start");
                Y(bVar, gVar);
            }
        }
    }

    @Override // b.a.p0.a.g1.d
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = f.U().S();
            if (l) {
                String str = "onAppBackground: background alive thread count:" + S;
            }
            return this.f5249h && S <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            b.a.p0.a.e0.d.i("SwanApp", "onAppForeground");
            String f0 = b.a.p0.a.d2.e.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0);
            hashMap.put("launchId", b.a.p0.a.u1.l.d.b());
            SwanAppActivity swanAppActivity = this.f5245d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                hashMap.put("clkid", this.f5245d.getLaunchInfo().L());
                hashMap.put("scene", this.f5245d.getLaunchInfo().T());
                b.a launchInfo = this.f5245d.getLaunchInfo();
                b.a.p0.a.n2.e.v(launchInfo);
                Z(launchInfo);
            }
            u(new b.a.p0.a.o0.d.d(hashMap));
            b.a.p0.a.e0.d.i("SwanApp", "onAppShow");
            b.a.p0.a.z.a.b().g(false);
            b.a.p0.a.j1.b.h(true);
            b.a.p0.a.j1.f.e.a.r(false);
            b.a.p0.a.n1.h.e().h(false);
            l.e().j();
            b.a.p0.a.n1.g.i();
            if (b.a.p0.a.c1.a.I() != null) {
                b.a.p0.a.c1.a.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (b.a.p0.a.u1.l.e.h()) {
                b.a.p0.a.u1.k.i.c.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                q.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            b.a.p0.a.e0.d.i("SwanApp", "onAppBackground");
            String f0 = b.a.p0.a.d2.e.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0);
            contentValues.put("hiddenType", Integer.valueOf(y0.b().a()));
            u(new b.a.p0.a.o0.d.d(contentValues));
            b.a.p0.a.e0.d.i("SwanApp", "onAppHide");
            y0.b().d();
            b.a.p0.a.z.a.b().g(true);
            b.a.p0.a.j1.b.h(false);
            b.a.p0.a.j1.f.e.a.r(true);
            b.a.p0.a.n1.h.e().h(true);
            b.a.p0.a.n1.g.j(false);
            if (b.a.p0.a.c1.a.I() != null) {
                b.a.p0.a.c1.a.I().c();
            }
            p0.h();
            b.a.p0.a.l1.a.i();
        }
    }
}
