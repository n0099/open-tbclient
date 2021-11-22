package b.a.p0.a.f2.f.o0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.a1.d;
import b.a.p0.a.h0.m.r.a;
import b.a.p0.a.n2.n;
import b.a.p0.a.z2.o0;
import b.a.p0.a.z2.q0;
import b.a.p0.q.j.m.a;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5110a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends b.a.p0.a.h0.m.e {
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

        @Override // b.a.p0.a.h0.m.e
        public void Q(@NonNull b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (g.f5110a) {
                    String str = "downloadDependentPackages-fail:" + aVar;
                }
                this.l.b(2113, aVar);
            }
        }

        @Override // b.a.p0.a.h0.m.e
        public void R() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean unused = g.f5110a;
                this.l.a(this.m);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f5111a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f5112b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f5113c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5114d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5115e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5116f;

        public b(boolean z, b.a.p0.a.d2.e eVar, e eVar2, String str, String str2, String str3) {
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
            this.f5111a = z;
            this.f5112b = eVar;
            this.f5113c = eVar2;
            this.f5114d = str;
            this.f5115e = str2;
            this.f5116f = str3;
        }

        @Override // b.a.p0.a.h0.m.r.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.h(this.f5111a, this.f5112b.f4474f, "pkg_retry_fail", String.valueOf(2113));
                this.f5113c.b(2113, null);
            }
        }

        @Override // b.a.p0.a.h0.m.r.a.b
        public void b(b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                boolean o = g.o(this.f5112b.f4474f, aVar);
                if (g.f5110a) {
                    String str = "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.f5111a + ",pmsErrorCode:" + aVar;
                }
                if (o) {
                    g.i(this.f5112b.f4474f, aVar);
                    b.a.p0.a.f1.d.b.a.b().a(this.f5112b.f4474f);
                    g.k(this.f5112b, this.f5115e, this.f5114d, this.f5113c, this.f5116f, true);
                    return;
                }
                b.a.p0.a.c2.b.f.e.f(AppRuntime.getAppContext(), b.a.p0.a.h.swanapp_tip_package_unavailable).G();
                g.h(this.f5111a, this.f5112b.f4474f, "pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f5113c.b(2113, aVar);
            }
        }

        @Override // b.a.p0.a.h0.m.r.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                g.h(this.f5111a, this.f5112b.f4474f, "pkg_retry_success", "");
                this.f5113c.a(this.f5114d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements b.a.p0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5117a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f5118b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5119c;

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
            this.f5117a = str;
            this.f5118b = eVar;
            this.f5119c = str2;
        }

        @Override // b.a.p0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
                if (L != null) {
                    L.N0(this.f5117a, true);
                }
                this.f5118b.a(this.f5119c);
            }
        }

        @Override // b.a.p0.a.h0.m.b
        public void b(int i2, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f5118b.b(i2, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements b.a.p0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5120a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f5121b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5122c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f5123d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5124e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5125f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5126g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5127h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f5128i;

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
            this.f5120a = str;
            this.f5121b = z;
            this.f5122c = str2;
            this.f5123d = eVar;
            this.f5124e = str3;
            this.f5125f = str4;
            this.f5126g = str5;
            this.f5127h = str6;
            this.f5128i = str7;
        }

        @Override // b.a.p0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.d2.d.J().r().N0(this.f5120a, true);
                g.h(this.f5121b, this.f5122c, "sub_pkg_retry_success", "");
                this.f5123d.a(this.f5124e);
            }
        }

        @Override // b.a.p0.a.h0.m.b
        public void b(int i2, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                boolean o = g.o(this.f5122c, aVar);
                if (g.f5110a) {
                    String str = "isNeedGetPkgRetry:" + o + ",isRetry:" + this.f5121b + ",pmsErrorCode:" + aVar;
                }
                if (o) {
                    g.i(this.f5125f, aVar);
                    b.a.p0.a.f1.d.b.a.b().a(this.f5122c);
                    g.n(this.f5125f, this.f5126g, this.f5127h, this.f5120a, this.f5128i, this.f5124e, this.f5123d, true);
                    return;
                }
                g.h(this.f5121b, this.f5122c, "sub_pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f5123d.b(i2, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(String str);

        void b(int i2, b.a.p0.a.u2.a aVar);
    }

    /* loaded from: classes.dex */
    public static class f implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e f5129a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f5130b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f5131e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f5132f;

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
                this.f5132f = fVar;
                this.f5131e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5132f.f5129a.a(this.f5131e);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f5133e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.u2.a f5134f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ f f5135g;

            public b(f fVar, int i2, b.a.p0.a.u2.a aVar) {
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
                this.f5135g = fVar;
                this.f5133e = i2;
                this.f5134f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f5135g.f5130b) {
                        b.a.p0.a.c2.b.f.e.f(AppRuntime.getAppContext(), b.a.p0.a.h.swanapp_tip_package_unavailable).G();
                    }
                    this.f5135g.f5129a.b(this.f5133e, this.f5134f);
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
            this.f5129a = eVar;
            this.f5130b = z;
        }

        @Override // b.a.p0.a.f2.f.o0.g.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                q0.e0(new a(this, str));
            }
        }

        @Override // b.a.p0.a.f2.f.o0.g.e
        public void b(int i2, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                q0.e0(new b(this, i2, aVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(188449516, "Lb/a/p0/a/f2/f/o0/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(188449516, "Lb/a/p0/a/f2/f/o0/g;");
                return;
            }
        }
        f5110a = b.a.p0.a.k.f6863a;
    }

    public static void g(b.a.p0.a.d2.e eVar, b.a.p0.a.m1.b bVar, String str, e eVar2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, eVar, bVar, str, eVar2, str2) == null) {
            if (eVar != null) {
                eVar.B().H(eVar.getAppId());
            }
            if (eVar2 == null) {
                return;
            }
            if (eVar != null && bVar != null && !TextUtils.isEmpty(bVar.f7014e) && !TextUtils.isEmpty(bVar.f7017h)) {
                String str3 = bVar.f7017h;
                String b0 = eVar.b0(bVar.f7014e);
                boolean q0 = eVar.q0(str3);
                if (!b.a.p0.a.e0.f.e.e.d() && !b.a.p0.a.x1.a.a.H() && !b.a.p0.a.x1.a.a.D()) {
                    if (b.a.p0.a.w1.c.a.k(bVar.f7014e)) {
                        eVar2.a(str);
                        return;
                    }
                    boolean z = true;
                    if (q0) {
                        boolean A = b.a.p0.a.a1.d.A(eVar.f4474f, eVar.j0());
                        boolean n0 = eVar.n0();
                        if (A) {
                            if (!n0) {
                                eVar2.a(str);
                                return;
                            }
                            Set<a.C0647a> i2 = b.a.p0.a.w1.c.a.i(eVar.V().f0());
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
                        if (!b.a.p0.a.a1.d.A(eVar.f4474f, eVar.j0()) && !p0) {
                            k(eVar, str3, str, eVar2, str2, false);
                            return;
                        }
                        HybridUbcFlow q = b.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(eVar.f4474f, eVar.j0(), "3", b0, Q, str, new f(eVar2, true));
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
            b.a.p0.a.f1.d.b.a.b().g(str);
            n.L(str2, str3);
        }
    }

    public static void i(String str, b.a.p0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, aVar) == null) {
            if ((aVar == null ? 0L : aVar.h()) == 2205) {
                b.a.p0.a.n0.f.c().d().u(b.a.p0.a.z2.a1.a.a(str), true, 12);
            }
        }
    }

    public static void j(Set<a.C0647a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            b.a.p0.q.j.m.a aVar = new b.a.p0.q.j.m.a(set);
            aVar.d("3");
            a aVar2 = new a(eVar, str);
            aVar2.L(1);
            b.a.p0.q.b.d(aVar, aVar2);
        }
    }

    public static void k(b.a.p0.a.d2.e eVar, String str, String str2, e eVar2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{eVar, str, str2, eVar2, str3, Boolean.valueOf(z)}) == null) || eVar2 == null) {
            return;
        }
        if (eVar == null) {
            eVar2.b(2111, null);
            return;
        }
        HybridUbcFlow q = b.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        b.a.p0.q.j.m.d dVar = new b.a.p0.q.j.m.d(eVar.f4474f, b.a.p0.a.d2.d.J().l());
        dVar.q(q0.o(eVar.j0()));
        dVar.t(str);
        b.a.p0.q.b.c(dVar, new b.a.p0.a.h0.m.r.a(eVar.f4474f, new b(z, eVar, eVar2, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) == null) || eVar == null) {
            return;
        }
        b.a.p0.q.j.m.g gVar = new b.a.p0.q.j.m.g(str, str2, str5, 0);
        gVar.d(str3);
        b.a.p0.q.b.h(gVar, new b.a.p0.a.h0.m.t.a(str, str2, new c(str4, eVar, str6)));
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
        String e2 = b.a.p0.a.f1.d.b.a.b().e(str, str4);
        b.a.p0.q.j.m.g gVar = new b.a.p0.q.j.m.g(str, str2, str5, 0);
        gVar.d(str3);
        b.a.p0.q.b.h(gVar, new b.a.p0.a.h0.m.t.a(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean o(String str, b.a.p0.a.u2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, aVar)) == null) {
            long h2 = aVar == null ? 0L : aVar.h();
            return SwanAppNetworkUtils.i(b.a.p0.a.c1.a.c()) && b.a.p0.a.f1.d.b.a.b().f(str) && (h2 == 2101 || h2 == 2205);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(b.a.p0.a.f1.e.b bVar, d.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, bVar, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(bVar, gVar.f3997b);
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(b.a.p0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, bVar, swanAppConfigData)) == null) {
            if (bVar != null && !TextUtils.isEmpty(bVar.e0()) && !b.a.p0.a.e0.f.e.e.d() && !b.a.p0.a.x1.a.a.D()) {
                String f2 = o0.f(bVar.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.f45027b != null) {
                    String c2 = j.c(f2, swanAppConfigData);
                    if (swanAppConfigData.f45027b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.f45028c.f45070c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (b.a.p0.q.g.a.i().n(bVar.H(), bVar.v1(), str)) {
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
