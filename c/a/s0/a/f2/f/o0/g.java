package c.a.s0.a.f2.f.o0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.s0.a.a1.d;
import c.a.s0.a.h0.m.r.a;
import c.a.s0.a.n2.n;
import c.a.s0.a.z2.o0;
import c.a.s0.a.z2.q0;
import c.a.s0.q.j.m.a;
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
import java.util.Set;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends c.a.s0.a.h0.m.e {
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

        @Override // c.a.s0.a.h0.m.e
        public void R(@NonNull c.a.s0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (g.a) {
                    String str = "downloadDependentPackages-fail:" + aVar;
                }
                this.l.c(2113, aVar);
            }
        }

        @Override // c.a.s0.a.h0.m.e
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
        public final /* synthetic */ c.a.s0.a.d2.e f6333b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f6334c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6335d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6336e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6337f;

        public b(boolean z, c.a.s0.a.d2.e eVar, e eVar2, String str, String str2, String str3) {
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
            this.f6333b = eVar;
            this.f6334c = eVar2;
            this.f6335d = str;
            this.f6336e = str2;
            this.f6337f = str3;
        }

        @Override // c.a.s0.a.h0.m.r.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.h(this.a, this.f6333b.f5779f, "pkg_retry_fail", String.valueOf(2113));
                this.f6334c.c(2113, null);
            }
        }

        @Override // c.a.s0.a.h0.m.r.a.b
        public void b(c.a.s0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                boolean o = g.o(this.f6333b.f5779f, aVar);
                if (g.a) {
                    String str = "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.a + ",pmsErrorCode:" + aVar;
                }
                if (o) {
                    g.i(this.f6333b.f5779f, aVar);
                    c.a.s0.a.f1.d.b.a.b().a(this.f6333b.f5779f);
                    g.k(this.f6333b, this.f6336e, this.f6335d, this.f6334c, this.f6337f, true);
                    return;
                }
                c.a.s0.a.c2.b.f.e.f(AppRuntime.getAppContext(), c.a.s0.a.h.swanapp_tip_package_unavailable).G();
                g.h(this.a, this.f6333b.f5779f, "pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f6334c.c(2113, aVar);
            }
        }

        @Override // c.a.s0.a.h0.m.r.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                g.h(this.a, this.f6333b.f5779f, "pkg_retry_success", "");
                this.f6334c.b(this.f6335d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.s0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f6338b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6339c;

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
            this.f6338b = eVar;
            this.f6339c = str2;
        }

        @Override // c.a.s0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.d2.e L = c.a.s0.a.d2.e.L();
                if (L != null) {
                    L.N0(this.a, true);
                }
                this.f6338b.b(this.f6339c);
            }
        }

        @Override // c.a.s0.a.h0.m.b
        public void b(int i2, c.a.s0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f6338b.c(i2, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements c.a.s0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6340b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6341c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f6342d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6343e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6344f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6345g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6346h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6347i;

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
            this.f6340b = z;
            this.f6341c = str2;
            this.f6342d = eVar;
            this.f6343e = str3;
            this.f6344f = str4;
            this.f6345g = str5;
            this.f6346h = str6;
            this.f6347i = str7;
        }

        @Override // c.a.s0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.d2.d.J().r().N0(this.a, true);
                g.h(this.f6340b, this.f6341c, "sub_pkg_retry_success", "");
                this.f6342d.b(this.f6343e);
            }
        }

        @Override // c.a.s0.a.h0.m.b
        public void b(int i2, c.a.s0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                boolean o = g.o(this.f6341c, aVar);
                if (g.a) {
                    String str = "isNeedGetPkgRetry:" + o + ",isRetry:" + this.f6340b + ",pmsErrorCode:" + aVar;
                }
                if (o) {
                    g.i(this.f6344f, aVar);
                    c.a.s0.a.f1.d.b.a.b().a(this.f6341c);
                    g.n(this.f6344f, this.f6345g, this.f6346h, this.a, this.f6347i, this.f6343e, this.f6342d, true);
                    return;
                }
                g.h(this.f6340b, this.f6341c, "sub_pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f6342d.c(i2, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void b(String str);

        void c(int i2, c.a.s0.a.u2.a aVar);
    }

    /* loaded from: classes.dex */
    public static class f implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f6348b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f6349e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f6350f;

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
                this.f6350f = fVar;
                this.f6349e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f6350f.a.b(this.f6349e);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f6351e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.u2.a f6352f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ f f6353g;

            public b(f fVar, int i2, c.a.s0.a.u2.a aVar) {
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
                this.f6353g = fVar;
                this.f6351e = i2;
                this.f6352f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f6353g.f6348b) {
                        c.a.s0.a.c2.b.f.e.f(AppRuntime.getAppContext(), c.a.s0.a.h.swanapp_tip_package_unavailable).G();
                    }
                    this.f6353g.a.c(this.f6351e, this.f6352f);
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
            this.f6348b = z;
        }

        @Override // c.a.s0.a.f2.f.o0.g.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                q0.e0(new a(this, str));
            }
        }

        @Override // c.a.s0.a.f2.f.o0.g.e
        public void c(int i2, c.a.s0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                q0.e0(new b(this, i2, aVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-428334224, "Lc/a/s0/a/f2/f/o0/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-428334224, "Lc/a/s0/a/f2/f/o0/g;");
                return;
            }
        }
        a = c.a.s0.a.k.a;
    }

    public static void g(c.a.s0.a.d2.e eVar, c.a.s0.a.m1.b bVar, String str, e eVar2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, eVar, bVar, str, eVar2, str2) == null) {
            if (eVar != null) {
                eVar.B().H(eVar.getAppId());
            }
            if (eVar2 == null) {
                return;
            }
            if (eVar != null && bVar != null && !TextUtils.isEmpty(bVar.f7914e) && !TextUtils.isEmpty(bVar.f7917h)) {
                String str3 = bVar.f7917h;
                String b0 = eVar.b0(bVar.f7914e);
                boolean q0 = eVar.q0(str3);
                if (!c.a.s0.a.e0.f.e.e.d() && !c.a.s0.a.x1.a.a.H() && !c.a.s0.a.x1.a.a.D()) {
                    if (c.a.s0.a.w1.c.a.k(bVar.f7914e)) {
                        eVar2.b(str);
                        return;
                    }
                    boolean z = true;
                    if (q0) {
                        boolean A = c.a.s0.a.a1.d.A(eVar.f5779f, eVar.j0());
                        boolean n0 = eVar.n0();
                        if (A) {
                            if (!n0) {
                                eVar2.b(str);
                                return;
                            }
                            Set<a.C0816a> i2 = c.a.s0.a.w1.c.a.i(eVar.V().f0());
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
                        if (!c.a.s0.a.a1.d.A(eVar.f5779f, eVar.j0()) && !p0) {
                            k(eVar, str3, str, eVar2, str2, false);
                            return;
                        }
                        HybridUbcFlow q = c.a.s0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(eVar.f5779f, eVar.j0(), "3", b0, Q, str, new f(eVar2, true));
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
            c.a.s0.a.f1.d.b.a.b().g(str);
            n.L(str2, str3);
        }
    }

    public static void i(String str, c.a.s0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, aVar) == null) {
            if ((aVar == null ? 0L : aVar.h()) == 2205) {
                c.a.s0.a.n0.f.c().d().u(c.a.s0.a.z2.a1.a.a(str), true, 12);
            }
        }
    }

    public static void j(Set<a.C0816a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            c.a.s0.q.j.m.a aVar = new c.a.s0.q.j.m.a(set);
            aVar.d("3");
            a aVar2 = new a(eVar, str);
            aVar2.M(1);
            c.a.s0.q.b.d(aVar, aVar2);
        }
    }

    public static void k(c.a.s0.a.d2.e eVar, String str, String str2, e eVar2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{eVar, str, str2, eVar2, str3, Boolean.valueOf(z)}) == null) || eVar2 == null) {
            return;
        }
        if (eVar == null) {
            eVar2.c(2111, null);
            return;
        }
        HybridUbcFlow q = c.a.s0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        c.a.s0.q.j.m.d dVar = new c.a.s0.q.j.m.d(eVar.f5779f, c.a.s0.a.d2.d.J().l());
        dVar.q(q0.o(eVar.j0()));
        dVar.t(str);
        c.a.s0.q.b.c(dVar, new c.a.s0.a.h0.m.r.a(eVar.f5779f, new b(z, eVar, eVar2, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) == null) || eVar == null) {
            return;
        }
        c.a.s0.q.j.m.g gVar = new c.a.s0.q.j.m.g(str, str2, str5, 0);
        gVar.d(str3);
        c.a.s0.q.b.h(gVar, new c.a.s0.a.h0.m.t.a(str, str2, new c(str4, eVar, str6)));
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
        String e2 = c.a.s0.a.f1.d.b.a.b().e(str, str4);
        c.a.s0.q.j.m.g gVar = new c.a.s0.q.j.m.g(str, str2, str5, 0);
        gVar.d(str3);
        c.a.s0.q.b.h(gVar, new c.a.s0.a.h0.m.t.a(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean o(String str, c.a.s0.a.u2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, aVar)) == null) {
            long h2 = aVar == null ? 0L : aVar.h();
            return SwanAppNetworkUtils.i(c.a.s0.a.c1.a.c()) && c.a.s0.a.f1.d.b.a.b().f(str) && (h2 == 2101 || h2 == 2205);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(c.a.s0.a.f1.e.b bVar, d.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, bVar, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(bVar, gVar.f5384b);
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(c.a.s0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, bVar, swanAppConfigData)) == null) {
            if (bVar != null && !TextUtils.isEmpty(bVar.e0()) && !c.a.s0.a.e0.f.e.e.d() && !c.a.s0.a.x1.a.a.D()) {
                String f2 = o0.f(bVar.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.f39596b != null) {
                    String c2 = j.c(f2, swanAppConfigData);
                    if (swanAppConfigData.f39596b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.f39597c.f39630c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (c.a.s0.q.g.a.i().n(bVar.H(), bVar.v1(), str)) {
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
