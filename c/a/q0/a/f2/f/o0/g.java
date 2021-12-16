package c.a.q0.a.f2.f.o0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.q0.a.a1.d;
import c.a.q0.a.h0.m.r.a;
import c.a.q0.a.n2.n;
import c.a.q0.a.z2.o0;
import c.a.q0.a.z2.q0;
import c.a.q0.q.j.m.a;
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
    public static class a extends c.a.q0.a.h0.m.e {
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

        @Override // c.a.q0.a.h0.m.e
        public void R(@NonNull c.a.q0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (g.a) {
                    String str = "downloadDependentPackages-fail:" + aVar;
                }
                this.l.b(2113, aVar);
            }
        }

        @Override // c.a.q0.a.h0.m.e
        public void S() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean unused = g.a;
                this.l.a(this.m);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.d2.e f5495b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f5496c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5497d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5498e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5499f;

        public b(boolean z, c.a.q0.a.d2.e eVar, e eVar2, String str, String str2, String str3) {
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
            this.f5495b = eVar;
            this.f5496c = eVar2;
            this.f5497d = str;
            this.f5498e = str2;
            this.f5499f = str3;
        }

        @Override // c.a.q0.a.h0.m.r.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.h(this.a, this.f5495b.f4925f, "pkg_retry_fail", String.valueOf(2113));
                this.f5496c.b(2113, null);
            }
        }

        @Override // c.a.q0.a.h0.m.r.a.b
        public void b(c.a.q0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                boolean o = g.o(this.f5495b.f4925f, aVar);
                if (g.a) {
                    String str = "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.a + ",pmsErrorCode:" + aVar;
                }
                if (o) {
                    g.i(this.f5495b.f4925f, aVar);
                    c.a.q0.a.f1.d.b.a.b().a(this.f5495b.f4925f);
                    g.k(this.f5495b, this.f5498e, this.f5497d, this.f5496c, this.f5499f, true);
                    return;
                }
                c.a.q0.a.c2.b.f.e.f(AppRuntime.getAppContext(), c.a.q0.a.h.swanapp_tip_package_unavailable).G();
                g.h(this.a, this.f5495b.f4925f, "pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f5496c.b(2113, aVar);
            }
        }

        @Override // c.a.q0.a.h0.m.r.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                g.h(this.a, this.f5495b.f4925f, "pkg_retry_success", "");
                this.f5496c.a(this.f5497d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.q0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f5500b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5501c;

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
            this.f5500b = eVar;
            this.f5501c = str2;
        }

        @Override // c.a.q0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.d2.e L = c.a.q0.a.d2.e.L();
                if (L != null) {
                    L.N0(this.a, true);
                }
                this.f5500b.a(this.f5501c);
            }
        }

        @Override // c.a.q0.a.h0.m.b
        public void b(int i2, c.a.q0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f5500b.b(i2, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements c.a.q0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f5502b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5503c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f5504d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5505e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5506f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5507g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5508h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f5509i;

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
            this.f5502b = z;
            this.f5503c = str2;
            this.f5504d = eVar;
            this.f5505e = str3;
            this.f5506f = str4;
            this.f5507g = str5;
            this.f5508h = str6;
            this.f5509i = str7;
        }

        @Override // c.a.q0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.d2.d.J().r().N0(this.a, true);
                g.h(this.f5502b, this.f5503c, "sub_pkg_retry_success", "");
                this.f5504d.a(this.f5505e);
            }
        }

        @Override // c.a.q0.a.h0.m.b
        public void b(int i2, c.a.q0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                boolean o = g.o(this.f5503c, aVar);
                if (g.a) {
                    String str = "isNeedGetPkgRetry:" + o + ",isRetry:" + this.f5502b + ",pmsErrorCode:" + aVar;
                }
                if (o) {
                    g.i(this.f5506f, aVar);
                    c.a.q0.a.f1.d.b.a.b().a(this.f5503c);
                    g.n(this.f5506f, this.f5507g, this.f5508h, this.a, this.f5509i, this.f5505e, this.f5504d, true);
                    return;
                }
                g.h(this.f5502b, this.f5503c, "sub_pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f5504d.b(i2, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(String str);

        void b(int i2, c.a.q0.a.u2.a aVar);
    }

    /* loaded from: classes.dex */
    public static class f implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f5510b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f5511e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f5512f;

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
                this.f5512f = fVar;
                this.f5511e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5512f.a.a(this.f5511e);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f5513e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.u2.a f5514f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ f f5515g;

            public b(f fVar, int i2, c.a.q0.a.u2.a aVar) {
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
                this.f5515g = fVar;
                this.f5513e = i2;
                this.f5514f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f5515g.f5510b) {
                        c.a.q0.a.c2.b.f.e.f(AppRuntime.getAppContext(), c.a.q0.a.h.swanapp_tip_package_unavailable).G();
                    }
                    this.f5515g.a.b(this.f5513e, this.f5514f);
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
            this.f5510b = z;
        }

        @Override // c.a.q0.a.f2.f.o0.g.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                q0.e0(new a(this, str));
            }
        }

        @Override // c.a.q0.a.f2.f.o0.g.e
        public void b(int i2, c.a.q0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                q0.e0(new b(this, i2, aVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(851529454, "Lc/a/q0/a/f2/f/o0/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(851529454, "Lc/a/q0/a/f2/f/o0/g;");
                return;
            }
        }
        a = c.a.q0.a.k.a;
    }

    public static void g(c.a.q0.a.d2.e eVar, c.a.q0.a.m1.b bVar, String str, e eVar2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, eVar, bVar, str, eVar2, str2) == null) {
            if (eVar != null) {
                eVar.B().H(eVar.getAppId());
            }
            if (eVar2 == null) {
                return;
            }
            if (eVar != null && bVar != null && !TextUtils.isEmpty(bVar.f7108e) && !TextUtils.isEmpty(bVar.f7111h)) {
                String str3 = bVar.f7111h;
                String b0 = eVar.b0(bVar.f7108e);
                boolean q0 = eVar.q0(str3);
                if (!c.a.q0.a.e0.f.e.e.d() && !c.a.q0.a.x1.a.a.H() && !c.a.q0.a.x1.a.a.D()) {
                    if (c.a.q0.a.w1.c.a.k(bVar.f7108e)) {
                        eVar2.a(str);
                        return;
                    }
                    boolean z = true;
                    if (q0) {
                        boolean A = c.a.q0.a.a1.d.A(eVar.f4925f, eVar.j0());
                        boolean n0 = eVar.n0();
                        if (A) {
                            if (!n0) {
                                eVar2.a(str);
                                return;
                            }
                            Set<a.C0737a> i2 = c.a.q0.a.w1.c.a.i(eVar.V().f0());
                            if (i2 != null && !i2.isEmpty()) {
                                z = false;
                            }
                            if (z) {
                                eVar2.a(str);
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
                        eVar2.b(2111, null);
                        return;
                    } else if (eVar.s0(b0)) {
                        eVar2.a(str);
                        return;
                    } else if (eVar.u0(b0) && eVar.t0(b0)) {
                        eVar2.a(str);
                        eVar.N0(b0, true);
                        return;
                    } else {
                        String Q = eVar.Q(b0);
                        if (TextUtils.isEmpty(Q)) {
                            eVar2.b(2112, null);
                            return;
                        }
                        boolean p0 = eVar.p0(str3);
                        if (!c.a.q0.a.a1.d.A(eVar.f4925f, eVar.j0()) && !p0) {
                            k(eVar, str3, str, eVar2, str2, false);
                            return;
                        }
                        HybridUbcFlow q = c.a.q0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(eVar.f4925f, eVar.j0(), "3", b0, Q, str, new f(eVar2, true));
                        return;
                    }
                } else if (!q0 && TextUtils.isEmpty(b0)) {
                    eVar2.b(2111, null);
                    return;
                } else {
                    eVar2.a(str);
                    return;
                }
            }
            eVar2.b(2110, null);
        }
    }

    public static void h(boolean z, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) && z) {
            c.a.q0.a.f1.d.b.a.b().g(str);
            n.L(str2, str3);
        }
    }

    public static void i(String str, c.a.q0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, aVar) == null) {
            if ((aVar == null ? 0L : aVar.h()) == 2205) {
                c.a.q0.a.n0.f.c().d().u(c.a.q0.a.z2.a1.a.a(str), true, 12);
            }
        }
    }

    public static void j(Set<a.C0737a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            c.a.q0.q.j.m.a aVar = new c.a.q0.q.j.m.a(set);
            aVar.d("3");
            a aVar2 = new a(eVar, str);
            aVar2.M(1);
            c.a.q0.q.b.d(aVar, aVar2);
        }
    }

    public static void k(c.a.q0.a.d2.e eVar, String str, String str2, e eVar2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{eVar, str, str2, eVar2, str3, Boolean.valueOf(z)}) == null) || eVar2 == null) {
            return;
        }
        if (eVar == null) {
            eVar2.b(2111, null);
            return;
        }
        HybridUbcFlow q = c.a.q0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        c.a.q0.q.j.m.d dVar = new c.a.q0.q.j.m.d(eVar.f4925f, c.a.q0.a.d2.d.J().l());
        dVar.q(q0.o(eVar.j0()));
        dVar.t(str);
        c.a.q0.q.b.c(dVar, new c.a.q0.a.h0.m.r.a(eVar.f4925f, new b(z, eVar, eVar2, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) == null) || eVar == null) {
            return;
        }
        c.a.q0.q.j.m.g gVar = new c.a.q0.q.j.m.g(str, str2, str5, 0);
        gVar.d(str3);
        c.a.q0.q.b.h(gVar, new c.a.q0.a.h0.m.t.a(str, str2, new c(str4, eVar, str6)));
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
        String e2 = c.a.q0.a.f1.d.b.a.b().e(str, str4);
        c.a.q0.q.j.m.g gVar = new c.a.q0.q.j.m.g(str, str2, str5, 0);
        gVar.d(str3);
        c.a.q0.q.b.h(gVar, new c.a.q0.a.h0.m.t.a(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean o(String str, c.a.q0.a.u2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, aVar)) == null) {
            long h2 = aVar == null ? 0L : aVar.h();
            return SwanAppNetworkUtils.i(c.a.q0.a.c1.a.c()) && c.a.q0.a.f1.d.b.a.b().f(str) && (h2 == 2101 || h2 == 2205);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(c.a.q0.a.f1.e.b bVar, d.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, bVar, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(bVar, gVar.f4516b);
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(c.a.q0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, bVar, swanAppConfigData)) == null) {
            if (bVar != null && !TextUtils.isEmpty(bVar.e0()) && !c.a.q0.a.e0.f.e.e.d() && !c.a.q0.a.x1.a.a.D()) {
                String f2 = o0.f(bVar.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.f40547b != null) {
                    String c2 = j.c(f2, swanAppConfigData);
                    if (swanAppConfigData.f40547b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.f40548c.f40582c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (c.a.q0.q.g.a.i().n(bVar.H(), bVar.v1(), str)) {
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
