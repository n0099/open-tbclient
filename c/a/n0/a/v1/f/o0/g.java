package c.a.n0.a.v1.f.o0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.n0.a.d2.n;
import c.a.n0.a.p2.o0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.q0.d;
import c.a.n0.a.x.m.r.a;
import c.a.n0.q.i.m.a;
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
import java.io.File;
import java.util.Set;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends c.a.n0.a.x.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f6834h;
        public final /* synthetic */ String i;

        public a(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6834h = eVar;
            this.i = str;
        }

        @Override // c.a.n0.a.x.m.e
        public void R(@NonNull c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (g.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-fail:" + aVar);
                }
                this.f6834h.c(2113, aVar);
            }
        }

        @Override // c.a.n0.a.x.m.e
        public void S() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (g.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-success.");
                }
                this.f6834h.b(this.i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f6835b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f6836c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6837d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6838e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6839f;

        public b(boolean z, c.a.n0.a.t1.e eVar, e eVar2, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), eVar, eVar2, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.f6835b = eVar;
            this.f6836c = eVar2;
            this.f6837d = str;
            this.f6838e = str2;
            this.f6839f = str3;
        }

        @Override // c.a.n0.a.x.m.r.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.h(this.a, this.f6835b.f6344b, "pkg_retry_fail", String.valueOf(2113));
                this.f6836c.c(2113, null);
            }
        }

        @Override // c.a.n0.a.x.m.r.a.b
        public void b(c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                boolean o = g.o(this.f6835b.f6344b, aVar);
                if (g.a) {
                    Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.a + ",pmsErrorCode:" + aVar);
                }
                if (o) {
                    g.i(this.f6835b.f6344b, aVar);
                    c.a.n0.a.v0.d.b.a.b().a(this.f6835b.f6344b);
                    g.k(this.f6835b, this.f6838e, this.f6837d, this.f6836c, this.f6839f, true);
                    return;
                }
                c.a.n0.a.s1.b.f.e.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f12de).G();
                g.h(this.a, this.f6835b.f6344b, "pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f6836c.c(2113, aVar);
            }
        }

        @Override // c.a.n0.a.x.m.r.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                g.h(this.a, this.f6835b.f6344b, "pkg_retry_success", "");
                this.f6836c.b(this.f6837d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.n0.a.x.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f6840b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6841c;

        public c(String str, e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f6840b = eVar;
            this.f6841c = str2;
        }

        @Override // c.a.n0.a.x.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
                if (L != null) {
                    L.N0(this.a, true);
                }
                this.f6840b.b(this.f6841c);
            }
        }

        @Override // c.a.n0.a.x.m.b
        public void b(int i, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, aVar) == null) {
                this.f6840b.c(i, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements c.a.n0.a.x.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6842b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6843c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f6844d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6845e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6846f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6847g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6848h;
        public final /* synthetic */ String i;

        public d(String str, boolean z, String str2, e eVar, String str3, String str4, String str5, String str6, String str7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), str2, eVar, str3, str4, str5, str6, str7};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f6842b = z;
            this.f6843c = str2;
            this.f6844d = eVar;
            this.f6845e = str3;
            this.f6846f = str4;
            this.f6847g = str5;
            this.f6848h = str6;
            this.i = str7;
        }

        @Override // c.a.n0.a.x.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.t1.d.J().r().N0(this.a, true);
                g.h(this.f6842b, this.f6843c, "sub_pkg_retry_success", "");
                this.f6844d.b(this.f6845e);
            }
        }

        @Override // c.a.n0.a.x.m.b
        public void b(int i, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, aVar) == null) {
                boolean o = g.o(this.f6843c, aVar);
                if (g.a) {
                    Log.d("PagesRoute", "isNeedGetPkgRetry:" + o + ",isRetry:" + this.f6842b + ",pmsErrorCode:" + aVar);
                }
                if (o) {
                    g.i(this.f6846f, aVar);
                    c.a.n0.a.v0.d.b.a.b().a(this.f6843c);
                    g.n(this.f6846f, this.f6847g, this.f6848h, this.a, this.i, this.f6845e, this.f6844d, true);
                    return;
                }
                g.h(this.f6842b, this.f6843c, "sub_pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f6844d.c(i, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void b(String str);

        void c(int i, c.a.n0.a.k2.a aVar);
    }

    /* loaded from: classes.dex */
    public static class f implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f6849b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ f f6850b;

            public a(f fVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6850b = fVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f6850b.a.b(this.a);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.k2.a f6851b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ f f6852c;

            public b(f fVar, int i, c.a.n0.a.k2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i), aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6852c = fVar;
                this.a = i;
                this.f6851b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f6852c.f6849b) {
                        c.a.n0.a.s1.b.f.e.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f12de).G();
                    }
                    this.f6852c.a.c(this.a, this.f6851b);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.f6849b = z;
        }

        @Override // c.a.n0.a.v1.f.o0.g.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                q0.e0(new a(this, str));
            }
        }

        @Override // c.a.n0.a.v1.f.o0.g.e
        public void c(int i, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, aVar) == null) {
                q0.e0(new b(this, i, aVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-712920294, "Lc/a/n0/a/v1/f/o0/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-712920294, "Lc/a/n0/a/v1/f/o0/g;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static void g(c.a.n0.a.t1.e eVar, c.a.n0.a.c1.b bVar, String str, e eVar2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, eVar, bVar, str, eVar2, str2) == null) {
            if (eVar != null) {
                eVar.B().H(eVar.getAppId());
            }
            if (eVar2 == null) {
                return;
            }
            if (eVar != null && bVar != null && !TextUtils.isEmpty(bVar.a) && !TextUtils.isEmpty(bVar.f3949d)) {
                String str3 = bVar.f3949d;
                String b0 = eVar.b0(bVar.a);
                boolean q0 = eVar.q0(str3);
                if (!c.a.n0.a.u.f.e.e.d() && !c.a.n0.a.n1.a.a.H() && !c.a.n0.a.n1.a.a.D()) {
                    if (c.a.n0.a.m1.c.a.k(bVar.a)) {
                        eVar2.b(str);
                        return;
                    }
                    boolean z = true;
                    if (q0) {
                        boolean A = c.a.n0.a.q0.d.A(eVar.f6344b, eVar.j0());
                        boolean n0 = eVar.n0();
                        if (A) {
                            if (!n0) {
                                eVar2.b(str);
                                return;
                            }
                            Set<a.C0756a> i = c.a.n0.a.m1.c.a.i(eVar.V().f0());
                            if (i != null && !i.isEmpty()) {
                                z = false;
                            }
                            if (z) {
                                eVar2.b(str);
                                return;
                            } else {
                                j(i, eVar2, str);
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
                        if (!c.a.n0.a.q0.d.A(eVar.f6344b, eVar.j0()) && !p0) {
                            k(eVar, str3, str, eVar2, str2, false);
                            return;
                        }
                        HybridUbcFlow q = c.a.n0.a.k1.h.q("route", str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(eVar.f6344b, eVar.j0(), "3", b0, Q, str, new f(eVar2, true));
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
            c.a.n0.a.v0.d.b.a.b().g(str);
            n.L(str2, str3);
        }
    }

    public static void i(String str, c.a.n0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, aVar) == null) {
            if ((aVar == null ? 0L : aVar.h()) == 2205) {
                c.a.n0.a.d0.f.c().d().u(c.a.n0.a.p2.a1.a.a(str), true, 12);
            }
        }
    }

    public static void j(Set<a.C0756a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            c.a.n0.q.i.m.a aVar = new c.a.n0.q.i.m.a(set);
            aVar.d("3");
            a aVar2 = new a(eVar, str);
            aVar2.M(1);
            c.a.n0.q.b.d(aVar, aVar2);
        }
    }

    public static void k(c.a.n0.a.t1.e eVar, String str, String str2, e eVar2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{eVar, str, str2, eVar2, str3, Boolean.valueOf(z)}) == null) || eVar2 == null) {
            return;
        }
        if (eVar == null) {
            eVar2.c(2111, null);
            return;
        }
        HybridUbcFlow q = c.a.n0.a.k1.h.q("route", str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        c.a.n0.q.i.m.d dVar = new c.a.n0.q.i.m.d(eVar.f6344b, c.a.n0.a.t1.d.J().l());
        dVar.q(q0.o(eVar.j0()));
        dVar.t(str);
        c.a.n0.q.b.c(dVar, new c.a.n0.a.x.m.r.a(eVar.f6344b, new b(z, eVar, eVar2, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) == null) || eVar == null) {
            return;
        }
        c.a.n0.q.i.m.g gVar = new c.a.n0.q.i.m.g(str, str2, str5, 0);
        gVar.d(str3);
        c.a.n0.q.b.h(gVar, new c.a.n0.a.x.m.t.a(str, str2, new c(str4, eVar, str6)));
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
        String e2 = c.a.n0.a.v0.d.b.a.b().e(str, str4);
        c.a.n0.q.i.m.g gVar = new c.a.n0.q.i.m.g(str, str2, str5, 0);
        gVar.d(str3);
        c.a.n0.q.b.h(gVar, new c.a.n0.a.x.m.t.a(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean o(String str, c.a.n0.a.k2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, aVar)) == null) {
            long h2 = aVar == null ? 0L : aVar.h();
            return SwanAppNetworkUtils.i(c.a.n0.a.s0.a.c()) && c.a.n0.a.v0.d.b.a.b().f(str) && (h2 == 2101 || h2 == 2205);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(c.a.n0.a.v0.e.b bVar, d.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, bVar, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(bVar, gVar.f5965b);
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(c.a.n0.a.v0.e.b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, bVar, swanAppConfigData)) == null) {
            if (bVar != null && !TextUtils.isEmpty(bVar.e0()) && !c.a.n0.a.u.f.e.e.d() && !c.a.n0.a.n1.a.a.D()) {
                String f2 = o0.f(bVar.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.f29236b != null) {
                    String c2 = j.c(f2, swanAppConfigData);
                    if (swanAppConfigData.f29236b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.f29237c.f29268c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (c.a.n0.q.f.a.i().n(bVar.H(), bVar.v1(), str)) {
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
