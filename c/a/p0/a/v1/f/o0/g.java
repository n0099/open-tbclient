package c.a.p0.a.v1.f.o0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.d2.n;
import c.a.p0.a.p2.o0;
import c.a.p0.a.p2.q0;
import c.a.p0.a.q0.d;
import c.a.p0.a.x.m.r.a;
import c.a.p0.q.i.m.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
import java.util.Set;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends c.a.p0.a.x.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e l;
        public final /* synthetic */ String m;

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
            this.l = eVar;
            this.m = str;
        }

        @Override // c.a.p0.a.x.m.e
        public void R(@NonNull c.a.p0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (g.a) {
                    String str = "downloadDependentPackages-fail:" + aVar;
                }
                this.l.c(2113, aVar);
            }
        }

        @Override // c.a.p0.a.x.m.e
        public void S() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean unused = g.a;
                this.l.b(this.m);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f8066b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f8067c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f8068d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8069e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8070f;

        public b(boolean z, c.a.p0.a.t1.e eVar, e eVar2, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), eVar, eVar2, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.f8066b = eVar;
            this.f8067c = eVar2;
            this.f8068d = str;
            this.f8069e = str2;
            this.f8070f = str3;
        }

        @Override // c.a.p0.a.x.m.r.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.h(this.a, this.f8066b.f7512f, "pkg_retry_fail", String.valueOf(2113));
                this.f8067c.c(2113, null);
            }
        }

        @Override // c.a.p0.a.x.m.r.a.b
        public void b(c.a.p0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                boolean o = g.o(this.f8066b.f7512f, aVar);
                if (g.a) {
                    String str = "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.a + ",pmsErrorCode:" + aVar;
                }
                if (o) {
                    g.i(this.f8066b.f7512f, aVar);
                    c.a.p0.a.v0.d.b.a.b().a(this.f8066b.f7512f);
                    g.k(this.f8066b, this.f8069e, this.f8068d, this.f8067c, this.f8070f, true);
                    return;
                }
                c.a.p0.a.s1.b.f.e.f(AppRuntime.getAppContext(), R.string.swanapp_tip_package_unavailable).G();
                g.h(this.a, this.f8066b.f7512f, "pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f8067c.c(2113, aVar);
            }
        }

        @Override // c.a.p0.a.x.m.r.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                g.h(this.a, this.f8066b.f7512f, "pkg_retry_success", "");
                this.f8067c.b(this.f8068d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.p0.a.x.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f8071b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8072c;

        public c(String str, e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f8071b = eVar;
            this.f8072c = str2;
        }

        @Override // c.a.p0.a.x.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.t1.e L = c.a.p0.a.t1.e.L();
                if (L != null) {
                    L.N0(this.a, true);
                }
                this.f8071b.b(this.f8072c);
            }
        }

        @Override // c.a.p0.a.x.m.b
        public void b(int i2, c.a.p0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f8071b.c(i2, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements c.a.p0.a.x.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f8073b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8074c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f8075d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8076e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8077f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8078g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8079h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8080i;

        public d(String str, boolean z, String str2, e eVar, String str3, String str4, String str5, String str6, String str7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), str2, eVar, str3, str4, str5, str6, str7};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f8073b = z;
            this.f8074c = str2;
            this.f8075d = eVar;
            this.f8076e = str3;
            this.f8077f = str4;
            this.f8078g = str5;
            this.f8079h = str6;
            this.f8080i = str7;
        }

        @Override // c.a.p0.a.x.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.t1.d.J().r().N0(this.a, true);
                g.h(this.f8073b, this.f8074c, "sub_pkg_retry_success", "");
                this.f8075d.b(this.f8076e);
            }
        }

        @Override // c.a.p0.a.x.m.b
        public void b(int i2, c.a.p0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                boolean o = g.o(this.f8074c, aVar);
                if (g.a) {
                    String str = "isNeedGetPkgRetry:" + o + ",isRetry:" + this.f8073b + ",pmsErrorCode:" + aVar;
                }
                if (o) {
                    g.i(this.f8077f, aVar);
                    c.a.p0.a.v0.d.b.a.b().a(this.f8074c);
                    g.n(this.f8077f, this.f8078g, this.f8079h, this.a, this.f8080i, this.f8076e, this.f8075d, true);
                    return;
                }
                g.h(this.f8073b, this.f8074c, "sub_pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f8075d.c(i2, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void b(String str);

        void c(int i2, c.a.p0.a.k2.a aVar);
    }

    /* loaded from: classes.dex */
    public static class f implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f8081b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f8082e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f8083f;

            public a(f fVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8083f = fVar;
                this.f8082e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8083f.a.b(this.f8082e);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f8084e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.k2.a f8085f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ f f8086g;

            public b(f fVar, int i2, c.a.p0.a.k2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i2), aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8086g = fVar;
                this.f8084e = i2;
                this.f8085f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f8086g.f8081b) {
                        c.a.p0.a.s1.b.f.e.f(AppRuntime.getAppContext(), R.string.swanapp_tip_package_unavailable).G();
                    }
                    this.f8086g.a.c(this.f8084e, this.f8085f);
                }
            }
        }

        public f(@NonNull e eVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.f8081b = z;
        }

        @Override // c.a.p0.a.v1.f.o0.g.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                q0.e0(new a(this, str));
            }
        }

        @Override // c.a.p0.a.v1.f.o0.g.e
        public void c(int i2, c.a.p0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                q0.e0(new b(this, i2, aVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1992783972, "Lc/a/p0/a/v1/f/o0/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1992783972, "Lc/a/p0/a/v1/f/o0/g;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
    }

    public static void g(c.a.p0.a.t1.e eVar, c.a.p0.a.c1.b bVar, String str, e eVar2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, eVar, bVar, str, eVar2, str2) == null) {
            if (eVar != null) {
                eVar.B().H(eVar.getAppId());
            }
            if (eVar2 == null) {
                return;
            }
            if (eVar != null && bVar != null && !TextUtils.isEmpty(bVar.f4642e) && !TextUtils.isEmpty(bVar.f4645h)) {
                String str3 = bVar.f4645h;
                String b0 = eVar.b0(bVar.f4642e);
                boolean q0 = eVar.q0(str3);
                if (!c.a.p0.a.u.f.e.e.d() && !c.a.p0.a.n1.a.a.H() && !c.a.p0.a.n1.a.a.D()) {
                    if (c.a.p0.a.m1.c.a.k(bVar.f4642e)) {
                        eVar2.b(str);
                        return;
                    }
                    boolean z = true;
                    if (q0) {
                        boolean A = c.a.p0.a.q0.d.A(eVar.f7512f, eVar.j0());
                        boolean n0 = eVar.n0();
                        if (A) {
                            if (!n0) {
                                eVar2.b(str);
                                return;
                            }
                            Set<a.C0761a> i2 = c.a.p0.a.m1.c.a.i(eVar.V().f0());
                            if (i2 != null && !i2.isEmpty()) {
                                z = false;
                            }
                            if (z) {
                                eVar2.b(str);
                                return;
                            } else {
                                j(i2, eVar2, str);
                                return;
                            }
                        } else if (n0) {
                            k(eVar, str3, str, eVar2, str2, false);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(b0)) {
                        eVar2.c(2111, null);
                        return;
                    } else if (eVar.s0(b0)) {
                        eVar2.b(str);
                        return;
                    } else if (eVar.u0(b0) && eVar.t0(b0)) {
                        eVar2.b(str);
                        eVar.N0(b0, true);
                        return;
                    } else {
                        String Q = eVar.Q(b0);
                        if (TextUtils.isEmpty(Q)) {
                            eVar2.c(2112, null);
                            return;
                        }
                        boolean p0 = eVar.p0(str3);
                        if (!c.a.p0.a.q0.d.A(eVar.f7512f, eVar.j0()) && !p0) {
                            k(eVar, str3, str, eVar2, str2, false);
                            return;
                        }
                        HybridUbcFlow q = c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(eVar.f7512f, eVar.j0(), "3", b0, Q, str, new f(eVar2, true));
                        return;
                    }
                } else if (!q0 && TextUtils.isEmpty(b0)) {
                    eVar2.c(2111, null);
                    return;
                } else {
                    eVar2.b(str);
                    return;
                }
            }
            eVar2.c(2110, null);
        }
    }

    public static void h(boolean z, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) && z) {
            c.a.p0.a.v0.d.b.a.b().g(str);
            n.L(str2, str3);
        }
    }

    public static void i(String str, c.a.p0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, aVar) == null) {
            if ((aVar == null ? 0L : aVar.h()) == 2205) {
                c.a.p0.a.d0.f.c().d().u(c.a.p0.a.p2.a1.a.a(str), true, 12);
            }
        }
    }

    public static void j(Set<a.C0761a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            c.a.p0.q.i.m.a aVar = new c.a.p0.q.i.m.a(set);
            aVar.d("3");
            a aVar2 = new a(eVar, str);
            aVar2.M(1);
            c.a.p0.q.b.d(aVar, aVar2);
        }
    }

    public static void k(c.a.p0.a.t1.e eVar, String str, String str2, e eVar2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{eVar, str, str2, eVar2, str3, Boolean.valueOf(z)}) == null) || eVar2 == null) {
            return;
        }
        if (eVar == null) {
            eVar2.c(2111, null);
            return;
        }
        HybridUbcFlow q = c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        c.a.p0.q.i.m.d dVar = new c.a.p0.q.i.m.d(eVar.f7512f, c.a.p0.a.t1.d.J().l());
        dVar.q(q0.o(eVar.j0()));
        dVar.t(str);
        c.a.p0.q.b.c(dVar, new c.a.p0.a.x.m.r.a(eVar.f7512f, new b(z, eVar, eVar2, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) == null) || eVar == null) {
            return;
        }
        c.a.p0.q.i.m.g gVar = new c.a.p0.q.i.m.g(str, str2, str5, 0);
        gVar.d(str3);
        c.a.p0.q.b.h(gVar, new c.a.p0.a.x.m.t.a(str, str2, new c(str4, eVar, str6)));
    }

    public static void m(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) == null) {
            n(str, str2, str3, str4, str5, str6, eVar, false);
        }
    }

    public static void n(String str, String str2, String str3, String str4, String str5, String str6, e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{str, str2, str3, str4, str5, str6, eVar, Boolean.valueOf(z)}) == null) || eVar == null) {
            return;
        }
        String e2 = c.a.p0.a.v0.d.b.a.b().e(str, str4);
        c.a.p0.q.i.m.g gVar = new c.a.p0.q.i.m.g(str, str2, str5, 0);
        gVar.d(str3);
        c.a.p0.q.b.h(gVar, new c.a.p0.a.x.m.t.a(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean o(String str, c.a.p0.a.k2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, aVar)) == null) {
            long h2 = aVar == null ? 0L : aVar.h();
            return SwanAppNetworkUtils.i(c.a.p0.a.s0.a.c()) && c.a.p0.a.v0.d.b.a.b().f(str) && (h2 == 2101 || h2 == 2205);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(c.a.p0.a.v0.e.b bVar, d.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, bVar, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(bVar, gVar.f7117b);
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(c.a.p0.a.v0.e.b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, bVar, swanAppConfigData)) == null) {
            if (bVar != null && !TextUtils.isEmpty(bVar.e0()) && !c.a.p0.a.u.f.e.e.d() && !c.a.p0.a.n1.a.a.D()) {
                String f2 = o0.f(bVar.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.f38000b != null) {
                    String c2 = j.c(f2, swanAppConfigData);
                    if (swanAppConfigData.f38000b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.f38001c.f38034c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (c.a.p0.q.f.a.i().n(bVar.H(), bVar.v1(), str)) {
                            return !new File(d.e.i(bVar.H(), bVar.v1()), str).exists();
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
