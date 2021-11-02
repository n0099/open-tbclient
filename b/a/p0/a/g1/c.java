package b.a.p0.a.g1;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.c2.f.p0.g;
import b.a.p0.a.c2.f.p0.j;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.j2.k;
import b.a.p0.a.v2.o0;
import b.a.p0.a.v2.p0;
import b.a.p0.a.v2.q;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.x0;
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
        public final /* synthetic */ long f5111e;

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
            this.f5111e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p0.g(this.f5111e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.a1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5112a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f5113b;

        /* loaded from: classes.dex */
        public class a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f5114a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e.g f5115b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f5116c;

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
                this.f5116c = bVar;
                this.f5114a = i2;
                this.f5115b = gVar;
            }

            @Override // b.a.p0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b.a.p0.a.e0.d.g("SwanApp", "download subpackage success");
                    b bVar = this.f5116c;
                    bVar.f5113b.W(this.f5114a, bVar.f5112a, this.f5115b);
                }
            }

            @Override // b.a.p0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    b.a.p0.a.e0.d.l("SwanApp", "download subpackage fail: " + i2);
                    this.f5116c.f5112a.P0(null);
                    b bVar = this.f5116c;
                    bVar.f5113b.W(this.f5114a, bVar.f5112a, this.f5115b);
                    b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
                    aVar.j(5L);
                    aVar.h(38L);
                    aVar.e("download subpackage fail, errcode=" + i2);
                    b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
                    dVar.q(k.m(this.f5116c.f5112a.F()));
                    dVar.p(aVar);
                    dVar.r(this.f5116c.f5112a);
                    k.L(dVar);
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
            this.f5113b = cVar;
            this.f5112a = bVar;
        }

        @Override // b.a.p0.a.a1.b
        public void a(int i2, b.a.p0.a.a1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                e.g gVar = (e.g) aVar;
                if (b.a.p0.a.c2.f.p0.g.o(this.f5112a, gVar)) {
                    if (b.a.p0.a.a2.e.i() != null && !TextUtils.isEmpty(gVar.f3903a)) {
                        String f2 = o0.f(this.f5112a.d0());
                        if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                            f2 = f2.substring(1);
                        }
                        String str = gVar.f3904b.f44230c.f44265c.get(j.b(f2));
                        b.a.p0.a.c2.f.p0.g.l(this.f5112a.G(), this.f5112a.s1(), "3", str, gVar.f3904b.f44231d.f44269a.get(str), this.f5113b.C(), new a(this, i2, gVar));
                        return;
                    }
                    b.a.p0.a.e0.d.l("SwanApp", "subpackage is invalid");
                }
                this.f5113b.W(i2, this.f5112a, gVar);
            }
        }
    }

    /* renamed from: b.a.p0.a.g1.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0188c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5117e;

        public RunnableC0188c(c cVar, b.a.p0.a.f1.e.b bVar) {
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
            this.f5117e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.C0109e.c(this.f5117e.G(), this.f5117e.s1());
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5118e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.g f5119f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f5120g;

        public d(c cVar, b.a.p0.a.f1.e.b bVar, e.g gVar) {
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
            this.f5120g = cVar;
            this.f5118e = bVar;
            this.f5119f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5120g.X(this.f5118e, this.f5119f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5121e;

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
            this.f5121e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.f5121e.n("fromHost");
                String n2 = this.f5121e.n("spuId");
                String n3 = this.f5121e.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !b.a.p0.a.c1.a.j0().a(n, n2, n3)) {
                    return;
                }
                this.f5121e.y("fromHost", null);
                this.f5121e.y("spuId", null);
                this.f5121e.y("contentId", null);
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
        l = b.a.p0.a.k.f6397a;
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
    public b.a.p0.a.a2.e D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.a.p0.a.a2.e.i() : (b.a.p0.a.a2.e) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void E(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2) == null) {
            super.E(bVar, bVar2);
            if (l) {
                String str = "asyncLoadSwanApp swanCoreVersion: " + bVar.h0();
            }
            b.a.p0.a.a1.e.c(bVar, new b(this, bVar));
            b.a.p0.a.h0.u.g.M().N0(bVar);
            b.a.p0.a.h0.u.g.M().M0(bVar);
            b.a.p0.a.h0.u.g.M().u0(null);
        }
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public SwanCoreVersion L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b.a.p0.a.h0.u.g.M().U() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.N();
            b.a.p0.a.h0.t.a.d();
            b.a.p0.a.h0.u.g.z0(false);
            if (this.f5099a != null) {
                this.f5099a = null;
            }
            b.a.p0.a.v2.j.h();
            b.a.p0.a.i1.b.b();
            b.a.p0.a.i1.f.e.a.y();
            b.a.p0.a.n2.d.a.a.b();
            b.a.p0.a.n2.f.a.n();
            b.a.p0.a.n2.a.a.d();
            b.a.p0.a.n2.i.a.k();
            b.a.p0.a.v0.a.d();
            b.a.p0.a.m1.g.f().q();
            b.a.p0.a.c2.f.i0.a.h();
            b.a.p0.a.n2.b.d.h();
            b.a.p0.a.m1.f.k();
            if (b.a.p0.a.c1.a.E() != null) {
                b.a.p0.a.c1.a.E().d();
            }
            b.a.p0.a.u.e.o.k.e().m();
            b.a.p0.a.z.a.b().f();
            b.a.p0.a.c2.f.g0.d.b().k();
            b.a.p0.a.y0.g.e.d();
            b.a.p0.a.u.f.a.d().h();
            b.a.p0.a.l1.d.d.f().e();
            b.a.p0.a.l0.o.a.m();
            b.a.p0.a.h0.u.b.b();
            if (b.a.p0.a.r1.l.e.g()) {
                b.a.p0.a.f1.c.b.c().a();
                b.a.p0.a.r1.r.a.f().b();
            }
            SwanPrefetchImageRes.b().e();
        }
    }

    public final void W(int i2, b.a.p0.a.f1.e.b bVar, e.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i2, bVar, gVar) == null) || i2 != 0 || bVar == null || gVar == null) {
            return;
        }
        b.a.p0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_start"));
        q0.a0(this.k);
        d dVar = new d(this, bVar, gVar);
        this.k = dVar;
        q0.d0(dVar);
    }

    public final void X(b.a.p0.a.f1.e.b bVar, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bVar, gVar) == null) {
            b.a.p0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_end"));
            b.a.p0.a.i2.a.d().i("na_post_to_main_end");
            if (l) {
                String str = "onLoaded loadedInfo: " + gVar;
            }
            if (this.f5107i) {
                if (l) {
                    Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.f3903a + ", baseUrl:" + f.T().z()));
                    return;
                }
                return;
            }
            this.f5101c = gVar.f3903a;
            Z(gVar.f3904b);
            if (bVar.k0()) {
                m(this.f5102d).setVisibility(0);
                b.a.p0.a.e0.a.b(true);
                b.a.p0.a.e0.d.g("AppsControllerImpl", "init sConsole for devHook");
            }
            b.a.p0.a.h0.u.g.M().L0(bVar, gVar);
        }
    }

    public final void Y(b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || TextUtils.isEmpty(bVar.n("fromHost")) || TextUtils.isEmpty(bVar.n("spuId")) || TextUtils.isEmpty(bVar.n("contentId"))) {
            return;
        }
        q0.Y(new e(this, bVar), 2000L);
    }

    public final void Z(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            b.a.p0.a.a2.d g2 = b.a.p0.a.a2.d.g();
            if (g2.C()) {
                g2.r().s0(swanAppConfigData);
            }
        }
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void c(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, bVar2) == null) {
            super.c(bVar, bVar2);
            if (l) {
                String str = "syncLoadSwanApp swanCoreVersion: " + bVar.h0();
            }
            b.a.p0.a.h0.u.g.M().N0(bVar);
            b.a.p0.a.h0.u.g.M().u0(null);
            SwanAppConfigData E = b.a.p0.a.a2.d.g().r().E();
            if (E != null) {
                e.g gVar = new e.g();
                b.a.p0.a.r1.k.i.c.f().e(new RunnableC0188c(this, bVar), "deleteLowerVersionFolder");
                gVar.f3904b = E;
                gVar.f3903a = e.C0109e.i(bVar.G(), bVar.s1()).getPath() + File.separator;
                b.a.p0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_start"));
                b.a.p0.a.i2.a.d().i("na_post_to_main_start");
                X(bVar, gVar);
            }
        }
    }

    @Override // b.a.p0.a.g1.d
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long R = f.T().R();
            if (l) {
                String str = "onAppBackground: background alive thread count:" + R;
            }
            return this.f5106h && R <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            b.a.p0.a.e0.d.g("SwanApp", "onAppForeground");
            String U = b.a.p0.a.a2.e.U();
            if (TextUtils.isEmpty(U)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, U);
            SwanAppActivity swanAppActivity = this.f5102d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                hashMap.put("clkid", this.f5102d.getLaunchInfo().K());
                hashMap.put("scene", this.f5102d.getLaunchInfo().S());
                b.a launchInfo = this.f5102d.getLaunchInfo();
                b.a.p0.a.j2.e.v(launchInfo);
                Y(launchInfo);
            }
            u(new b.a.p0.a.o0.d.c(hashMap));
            b.a.p0.a.e0.d.g("SwanApp", "onAppShow");
            b.a.p0.a.z.a.b().g(false);
            b.a.p0.a.i1.b.h(true);
            b.a.p0.a.i1.f.e.a.r(false);
            b.a.p0.a.m1.g.f().j(false);
            b.a.p0.a.u.e.o.k.e().i();
            b.a.p0.a.m1.f.i();
            if (b.a.p0.a.c1.a.E() != null) {
                b.a.p0.a.c1.a.E().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (b.a.p0.a.r1.l.e.l()) {
                b.a.p0.a.r1.k.i.b.e().f(aVar, "saveSwanAppForeGroundTime");
            } else {
                q.j(aVar, "saveSwanAppForeGroundTime");
            }
            b.a.p0.a.l0.o.a.l();
        }
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            b.a.p0.a.e0.d.g("SwanApp", "onAppBackground");
            String U = b.a.p0.a.a2.e.U();
            if (TextUtils.isEmpty(U)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, U);
            contentValues.put("hiddenType", Integer.valueOf(x0.b().a()));
            u(new b.a.p0.a.o0.d.c(contentValues));
            b.a.p0.a.e0.d.g("SwanApp", "onAppHide");
            x0.b().d();
            b.a.p0.a.z.a.b().g(true);
            b.a.p0.a.i1.b.h(false);
            b.a.p0.a.i1.f.e.a.r(true);
            b.a.p0.a.m1.g.f().j(true);
            b.a.p0.a.m1.f.j(false);
            if (b.a.p0.a.c1.a.E() != null) {
                b.a.p0.a.c1.a.E().c();
            }
            p0.h();
            b.a.p0.a.k1.a.i();
            b.a.p0.a.l0.o.a.k();
        }
    }
}
