package c.a.p0.a.c2.f.p0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.a1.e;
import c.a.p0.a.h0.m.o.a;
import c.a.p0.a.v2.o0;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5016a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f5017a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f5018b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f5019c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5020d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5021e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5022f;

        public a(boolean z, c.a.p0.a.a2.e eVar, d dVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), eVar, dVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5017a = z;
            this.f5018b = eVar;
            this.f5019c = dVar;
            this.f5020d = str;
            this.f5021e = str2;
            this.f5022f = str3;
        }

        @Override // c.a.p0.a.h0.m.o.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.h(this.f5017a, this.f5018b.f4566f, "pkg_retry_fail", String.valueOf(2113));
                this.f5019c.b(2113);
            }
        }

        @Override // c.a.p0.a.h0.m.o.a.b
        public void b(c.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                boolean n = g.n(this.f5018b.f4566f, aVar);
                if (g.f5016a) {
                    String str = "getAppPackage-isNeedGetPkgRetry:" + n + ",isRetry:" + this.f5017a + ",pmsErrorCode:" + aVar;
                }
                if (n) {
                    g.i(this.f5018b.f4566f, aVar);
                    c.a.p0.a.f1.d.b.a.b().a(this.f5018b.f4566f);
                    g.j(this.f5018b, this.f5021e, this.f5020d, this.f5019c, this.f5022f, true);
                    return;
                }
                c.a.p0.a.z1.b.f.e.f(AppRuntime.getAppContext(), c.a.p0.a.h.swanapp_tip_package_unavailable).F();
                g.h(this.f5017a, this.f5018b.f4566f, "pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f5019c.b(2113);
            }
        }

        @Override // c.a.p0.a.h0.m.o.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                g.h(this.f5017a, this.f5018b.f4566f, "pkg_retry_success", "");
                this.f5019c.a(this.f5020d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c.a.p0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5023a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f5024b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5025c;

        public b(String str, d dVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, dVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5023a = str;
            this.f5024b = dVar;
            this.f5025c = str2;
        }

        @Override // c.a.p0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.a2.e i2 = c.a.p0.a.a2.e.i();
                if (i2 != null) {
                    i2.y0(this.f5023a, true);
                }
                this.f5024b.a(this.f5025c);
            }
        }

        @Override // c.a.p0.a.h0.m.b
        public void b(int i2, c.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f5024b.b(i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.p0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5026a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f5027b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5028c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f5029d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5030e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5031f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5032g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5033h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f5034i;

        public c(String str, boolean z, String str2, d dVar, String str3, String str4, String str5, String str6, String str7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), str2, dVar, str3, str4, str5, str6, str7};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5026a = str;
            this.f5027b = z;
            this.f5028c = str2;
            this.f5029d = dVar;
            this.f5030e = str3;
            this.f5031f = str4;
            this.f5032g = str5;
            this.f5033h = str6;
            this.f5034i = str7;
        }

        @Override // c.a.p0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.a2.d.g().r().y0(this.f5026a, true);
                g.h(this.f5027b, this.f5028c, "sub_pkg_retry_success", "");
                this.f5029d.a(this.f5030e);
            }
        }

        @Override // c.a.p0.a.h0.m.b
        public void b(int i2, c.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                boolean n = g.n(this.f5028c, aVar);
                if (g.f5016a) {
                    String str = "isNeedGetPkgRetry:" + n + ",isRetry:" + this.f5027b + ",pmsErrorCode:" + aVar;
                }
                if (n) {
                    g.i(this.f5031f, aVar);
                    c.a.p0.a.f1.d.b.a.b().a(this.f5028c);
                    g.m(this.f5031f, this.f5032g, this.f5033h, this.f5026a, this.f5034i, this.f5030e, this.f5029d, true);
                    return;
                }
                g.h(this.f5027b, this.f5028c, "sub_pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f5029d.b(i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(String str);

        void b(int i2);
    }

    /* loaded from: classes.dex */
    public static class e implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d f5035a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f5036b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f5037e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f5038f;

            public a(e eVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5038f = eVar;
                this.f5037e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5038f.f5035a.a(this.f5037e);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f5039e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f5040f;

            public b(e eVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5040f = eVar;
                this.f5039e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f5040f.f5036b) {
                        c.a.p0.a.z1.b.f.e.f(AppRuntime.getAppContext(), c.a.p0.a.h.swanapp_tip_package_unavailable).F();
                    }
                    this.f5040f.f5035a.b(this.f5039e);
                }
            }
        }

        public e(@NonNull d dVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5035a = dVar;
            this.f5036b = z;
        }

        @Override // c.a.p0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                q0.b0(new a(this, str));
            }
        }

        @Override // c.a.p0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                q0.b0(new b(this, i2));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-65558319, "Lc/a/p0/a/c2/f/p0/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-65558319, "Lc/a/p0/a/c2/f/p0/g;");
                return;
            }
        }
        f5016a = c.a.p0.a.k.f7085a;
    }

    public static void g(c.a.p0.a.a2.e eVar, c.a.p0.a.l1.b bVar, String str, d dVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, eVar, bVar, str, dVar, str2) == null) {
            if (eVar != null) {
                eVar.B().e(eVar.getAppId());
            }
            if (dVar == null) {
                return;
            }
            if (eVar != null && bVar != null && !TextUtils.isEmpty(bVar.f7244e) && !TextUtils.isEmpty(bVar.f7247h)) {
                String str3 = bVar.f7247h;
                String R = eVar.R(bVar.f7244e);
                boolean h0 = eVar.h0(str3);
                if (!c.a.p0.a.e0.f.e.e.d() && !c.a.p0.a.u1.a.a.G() && !c.a.p0.a.u1.a.a.C()) {
                    if (c.a.p0.a.t1.b.a.e(bVar.f7244e)) {
                        dVar.a(str);
                        return;
                    }
                    if (h0) {
                        if (c.a.p0.a.a1.e.A(eVar.f4566f, eVar.Z())) {
                            dVar.a(str);
                            return;
                        } else if (eVar.e0()) {
                            j(eVar, str3, str, dVar, str2, false);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(R)) {
                        dVar.b(2111);
                        return;
                    } else if (eVar.j0(R)) {
                        dVar.a(str);
                        return;
                    } else if (eVar.l0(R) && eVar.k0(R)) {
                        dVar.a(str);
                        eVar.y0(R, true);
                        return;
                    } else {
                        String G = eVar.G(R);
                        if (TextUtils.isEmpty(G)) {
                            dVar.b(2112);
                            return;
                        }
                        boolean g0 = eVar.g0(str3);
                        if (!c.a.p0.a.a1.e.A(eVar.f4566f, eVar.Z()) && !g0) {
                            j(eVar, str3, str, dVar, str2, false);
                            return;
                        }
                        HybridUbcFlow q = c.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2);
                        q.C(new UbcFlowEvent("na_start_sub_package_download"));
                        q.A("sub_state", "1");
                        l(eVar.f4566f, eVar.Z(), "3", R, G, str, new e(dVar, true));
                        return;
                    }
                } else if (!h0 && TextUtils.isEmpty(R)) {
                    dVar.b(2111);
                    return;
                } else {
                    dVar.a(str);
                    return;
                }
            }
            dVar.b(2110);
        }
    }

    public static void h(boolean z, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) && z) {
            c.a.p0.a.f1.d.b.a.b().g(str);
            c.a.p0.a.j2.k.G(str2, str3);
        }
    }

    public static void i(String str, c.a.p0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, aVar) == null) {
            if ((aVar == null ? 0L : aVar.g()) == 2205) {
                c.a.p0.a.n0.f.c().d().u(c.a.p0.a.v2.z0.a.a(str), true, 12);
            }
        }
    }

    public static void j(c.a.p0.a.a2.e eVar, String str, String str2, d dVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{eVar, str, str2, dVar, str3, Boolean.valueOf(z)}) == null) || dVar == null) {
            return;
        }
        if (eVar == null) {
            dVar.b(2111);
            return;
        }
        HybridUbcFlow q = c.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str3);
        q.C(new UbcFlowEvent("na_start_sub_package_download"));
        q.A("sub_state", "1");
        c.a.p0.n.i.m.c cVar = new c.a.p0.n.i.m.c(eVar.f4566f, c.a.p0.a.a2.d.g().l());
        cVar.o(q0.o(eVar.Z()));
        cVar.r(str);
        c.a.p0.n.b.b(cVar, new c.a.p0.a.h0.m.o.a(eVar.f4566f, new a(z, eVar, dVar, str2, str, str3)));
    }

    public static void k(String str, String str2, String str3, String str4, String str5, String str6, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, str2, str3, str4, str5, str6, dVar}) == null) || dVar == null) {
            return;
        }
        c.a.p0.n.i.m.f fVar = new c.a.p0.n.i.m.f(str, str2, str5, 0);
        fVar.d(str3);
        c.a.p0.n.b.f(fVar, new c.a.p0.a.h0.m.q.a(str, str2, new b(str4, dVar, str6)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, dVar}) == null) {
            m(str, str2, str3, str4, str5, str6, dVar, false);
        }
    }

    public static void m(String str, String str2, String str3, String str4, String str5, String str6, d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{str, str2, str3, str4, str5, str6, dVar, Boolean.valueOf(z)}) == null) || dVar == null) {
            return;
        }
        String e2 = c.a.p0.a.f1.d.b.a.b().e(str, str4);
        c.a.p0.n.i.m.f fVar = new c.a.p0.n.i.m.f(str, str2, str5, 0);
        fVar.d(str3);
        c.a.p0.n.b.f(fVar, new c.a.p0.a.h0.m.q.a(str, str2, new c(str4, z, e2, dVar, str6, str, str2, str3, str5)));
    }

    public static boolean n(String str, c.a.p0.a.q2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, aVar)) == null) {
            long g2 = aVar == null ? 0L : aVar.g();
            return SwanAppNetworkUtils.i(c.a.p0.a.c1.a.b()) && c.a.p0.a.f1.d.b.a.b().f(str) && (g2 == 2101 || g2 == 2205);
        }
        return invokeLL.booleanValue;
    }

    public static boolean o(c.a.p0.a.f1.e.b bVar, e.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, bVar, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return p(bVar, gVar.f4507b);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(c.a.p0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, bVar, swanAppConfigData)) == null) {
            if (bVar != null && !TextUtils.isEmpty(bVar.e0()) && !c.a.p0.a.e0.f.e.e.d() && !c.a.p0.a.u1.a.a.C()) {
                String f2 = o0.f(bVar.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.f46568b != null) {
                    String c2 = j.c(f2, swanAppConfigData);
                    if (swanAppConfigData.f46568b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.f46569c.f46605c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (c.a.p0.n.g.a.h().m(bVar.H(), bVar.u1(), str)) {
                            return !new File(e.C0114e.i(bVar.H(), bVar.u1()), str).exists();
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
