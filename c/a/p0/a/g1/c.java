package c.a.p0.a.g1;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a1.e;
import c.a.p0.a.c2.f.p0.g;
import c.a.p0.a.c2.f.p0.j;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.j2.k;
import c.a.p0.a.v2.o0;
import c.a.p0.a.v2.p0;
import c.a.p0.a.v2.q;
import c.a.p0.a.v2.q0;
import c.a.p0.a.v2.x0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
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
public class c extends c.a.p0.a.g1.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f5761e;

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
            this.f5761e = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p0.g(this.f5761e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.a1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5762a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f5763b;

        /* loaded from: classes.dex */
        public class a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f5764a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e.g f5765b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f5766c;

            public a(b bVar, int i2, e.g gVar) {
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
                this.f5766c = bVar;
                this.f5764a = i2;
                this.f5765b = gVar;
            }

            @Override // c.a.p0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    c.a.p0.a.e0.d.g("SwanApp", "download subpackage success");
                    b bVar = this.f5766c;
                    bVar.f5763b.Y(this.f5764a, bVar.f5762a, this.f5765b);
                }
            }

            @Override // c.a.p0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    c.a.p0.a.e0.d.l("SwanApp", "download subpackage fail: " + i2);
                    this.f5766c.f5762a.Q0(null);
                    b bVar = this.f5766c;
                    bVar.f5763b.Y(this.f5764a, bVar.f5762a, this.f5765b);
                    c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
                    aVar.j(5L);
                    aVar.h(38L);
                    aVar.e("download subpackage fail, errcode=" + i2);
                    c.a.p0.a.j2.p.d dVar = new c.a.p0.a.j2.p.d();
                    dVar.q(k.m(this.f5766c.f5762a.G()));
                    dVar.p(aVar);
                    dVar.r(this.f5766c.f5762a);
                    k.L(dVar);
                }
            }
        }

        public b(c cVar, c.a.p0.a.f1.e.b bVar) {
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
            this.f5763b = cVar;
            this.f5762a = bVar;
        }

        @Override // c.a.p0.a.a1.b
        public void a(int i2, c.a.p0.a.a1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                e.g gVar = (e.g) aVar;
                if (c.a.p0.a.c2.f.p0.g.o(this.f5762a, gVar)) {
                    if (c.a.p0.a.a2.e.i() != null && !TextUtils.isEmpty(gVar.f4506a)) {
                        String f2 = o0.f(this.f5762a.e0());
                        if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                            f2 = f2.substring(1);
                        }
                        String str = gVar.f4507b.f46569c.f46605c.get(j.b(f2));
                        c.a.p0.a.c2.f.p0.g.l(this.f5762a.H(), this.f5762a.u1(), "3", str, gVar.f4507b.f46570d.f46609a.get(str), this.f5763b.D(), new a(this, i2, gVar));
                        return;
                    }
                    c.a.p0.a.e0.d.l("SwanApp", "subpackage is invalid");
                }
                this.f5763b.Y(i2, this.f5762a, gVar);
            }
        }
    }

    /* renamed from: c.a.p0.a.g1.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0193c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5767e;

        public RunnableC0193c(c cVar, c.a.p0.a.f1.e.b bVar) {
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
            this.f5767e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.C0114e.c(this.f5767e.H(), this.f5767e.u1());
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5768e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.g f5769f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f5770g;

        public d(c cVar, c.a.p0.a.f1.e.b bVar, e.g gVar) {
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
            this.f5770g = cVar;
            this.f5768e = bVar;
            this.f5769f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5770g.Z(this.f5768e, this.f5769f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5771e;

        public e(c cVar, c.a.p0.a.f1.e.b bVar) {
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
            this.f5771e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.f5771e.n("fromHost");
                String n2 = this.f5771e.n("spuId");
                String n3 = this.f5771e.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !c.a.p0.a.c1.a.j0().a(n, n2, n3)) {
                    return;
                }
                this.f5771e.y("fromHost", null);
                this.f5771e.y("spuId", null);
                this.f5771e.y("contentId", null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(818113318, "Lc/a/p0/a/g1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(818113318, "Lc/a/p0/a/g1/c;");
                return;
            }
        }
        l = c.a.p0.a.k.f7085a;
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

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    @Nullable
    public c.a.p0.a.a2.e F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.p0.a.a2.e.i() : (c.a.p0.a.a2.e) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public void G(c.a.p0.a.f1.e.b bVar, c.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2) == null) {
            super.G(bVar, bVar2);
            if (l) {
                String str = "asyncLoadSwanApp swanCoreVersion: " + bVar.i0();
            }
            c.a.p0.a.a1.e.c(bVar, new b(this, bVar));
            c.a.p0.a.h0.u.g.N().O0(bVar);
            c.a.p0.a.h0.u.g.N().N0(bVar);
            c.a.p0.a.h0.u.g.N().v0(null);
        }
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public SwanCoreVersion N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.p0.a.h0.u.g.N().V() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.P();
            c.a.p0.a.h0.t.a.d();
            c.a.p0.a.h0.u.g.A0(false);
            if (this.f5749a != null) {
                this.f5749a = null;
            }
            c.a.p0.a.v2.j.h();
            c.a.p0.a.i1.b.b();
            c.a.p0.a.i1.f.e.a.y();
            c.a.p0.a.n2.d.a.a.b();
            c.a.p0.a.n2.f.a.n();
            c.a.p0.a.n2.a.a.d();
            c.a.p0.a.n2.i.a.k();
            c.a.p0.a.v0.a.d();
            c.a.p0.a.m1.g.f().q();
            c.a.p0.a.c2.f.i0.a.h();
            c.a.p0.a.n2.b.d.i();
            c.a.p0.a.m1.f.k();
            if (c.a.p0.a.c1.a.E() != null) {
                c.a.p0.a.c1.a.E().d();
            }
            c.a.p0.a.u.e.o.k.e().m();
            c.a.p0.a.z.a.b().f();
            c.a.p0.a.c2.f.g0.d.b().k();
            c.a.p0.a.y0.g.e.d();
            c.a.p0.a.u.f.a.d().h();
            c.a.p0.a.l1.d.d.f().e();
            c.a.p0.a.l0.o.a.m();
            c.a.p0.a.h0.u.b.b();
            if (c.a.p0.a.r1.l.e.g()) {
                c.a.p0.a.f1.c.b.c().a();
                c.a.p0.a.r1.r.a.f().b();
            }
            SwanPrefetchImageRes.b().e();
        }
    }

    public final void Y(int i2, c.a.p0.a.f1.e.b bVar, e.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i2, bVar, gVar) == null) || i2 != 0 || bVar == null || gVar == null) {
            return;
        }
        c.a.p0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_start"));
        q0.a0(this.k);
        d dVar = new d(this, bVar, gVar);
        this.k = dVar;
        q0.d0(dVar);
    }

    public final void Z(c.a.p0.a.f1.e.b bVar, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bVar, gVar) == null) {
            c.a.p0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_end"));
            c.a.p0.a.i2.a.d().i("na_post_to_main_end");
            if (l) {
                String str = "onLoaded loadedInfo: " + gVar;
            }
            if (this.f5757i) {
                if (l) {
                    Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.f4506a + ", baseUrl:" + f.V().A()));
                    return;
                }
                return;
            }
            this.f5751c = gVar.f4506a;
            b0(gVar.f4507b);
            if (bVar.l0()) {
                n(this.f5752d).setVisibility(0);
                c.a.p0.a.e0.a.b(true);
                c.a.p0.a.e0.d.g("AppsControllerImpl", "init sConsole for devHook");
            }
            c.a.p0.a.h0.u.g.N().M0(bVar, gVar);
        }
    }

    public final void a0(c.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || TextUtils.isEmpty(bVar.n("fromHost")) || TextUtils.isEmpty(bVar.n("spuId")) || TextUtils.isEmpty(bVar.n("contentId"))) {
            return;
        }
        q0.Y(new e(this, bVar), 2000L);
    }

    public final void b0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            c.a.p0.a.a2.d g2 = c.a.p0.a.a2.d.g();
            if (g2.C()) {
                g2.r().t0(swanAppConfigData);
            }
        }
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public void c(c.a.p0.a.f1.e.b bVar, c.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, bVar2) == null) {
            super.c(bVar, bVar2);
            if (l) {
                String str = "syncLoadSwanApp swanCoreVersion: " + bVar.i0();
            }
            c.a.p0.a.h0.u.g.N().O0(bVar);
            c.a.p0.a.h0.u.g.N().v0(null);
            SwanAppConfigData F = c.a.p0.a.a2.d.g().r().F();
            if (F != null) {
                e.g gVar = new e.g();
                c.a.p0.a.r1.k.i.c.f().e(new RunnableC0193c(this, bVar), "deleteLowerVersionFolder");
                gVar.f4507b = F;
                gVar.f4506a = e.C0114e.i(bVar.H(), bVar.u1()).getPath() + File.separator;
                c.a.p0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_start"));
                c.a.p0.a.i2.a.d().i("na_post_to_main_start");
                Z(bVar, gVar);
            }
        }
    }

    @Override // c.a.p0.a.g1.d
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long T = f.V().T();
            if (l) {
                String str = "onAppBackground: background alive thread count:" + T;
            }
            return this.f5756h && T <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.w();
            c.a.p0.a.e0.d.g("SwanApp", "onAppForeground");
            String V = c.a.p0.a.a2.e.V();
            if (TextUtils.isEmpty(V)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, V);
            SwanAppActivity swanAppActivity = this.f5752d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                hashMap.put("clkid", this.f5752d.getLaunchInfo().L());
                hashMap.put("scene", this.f5752d.getLaunchInfo().T());
                b.a launchInfo = this.f5752d.getLaunchInfo();
                c.a.p0.a.j2.e.v(launchInfo);
                a0(launchInfo);
            }
            v(new c.a.p0.a.o0.d.c(hashMap));
            c.a.p0.a.e0.d.g("SwanApp", "onAppShow");
            c.a.p0.a.z.a.b().g(false);
            c.a.p0.a.i1.b.h(true);
            c.a.p0.a.i1.f.e.a.r(false);
            c.a.p0.a.m1.g.f().j(false);
            c.a.p0.a.u.e.o.k.e().i();
            c.a.p0.a.m1.f.i();
            if (c.a.p0.a.c1.a.E() != null) {
                c.a.p0.a.c1.a.E().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (c.a.p0.a.r1.l.e.l()) {
                c.a.p0.a.r1.k.i.b.e().f(aVar, "saveSwanAppForeGroundTime");
            } else {
                q.j(aVar, "saveSwanAppForeGroundTime");
            }
            c.a.p0.a.l0.o.a.l();
        }
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.x();
            c.a.p0.a.e0.d.g("SwanApp", "onAppBackground");
            String V = c.a.p0.a.a2.e.V();
            if (TextUtils.isEmpty(V)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, V);
            contentValues.put("hiddenType", Integer.valueOf(x0.b().a()));
            v(new c.a.p0.a.o0.d.c(contentValues));
            c.a.p0.a.e0.d.g("SwanApp", "onAppHide");
            x0.b().d();
            c.a.p0.a.z.a.b().g(true);
            c.a.p0.a.i1.b.h(false);
            c.a.p0.a.i1.f.e.a.r(true);
            c.a.p0.a.m1.g.f().j(true);
            c.a.p0.a.m1.f.j(false);
            if (c.a.p0.a.c1.a.E() != null) {
                c.a.p0.a.c1.a.E().c();
            }
            p0.h();
            c.a.p0.a.k1.a.i();
            c.a.p0.a.l0.o.a.k();
        }
    }
}
