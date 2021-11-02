package b.a.p0.a.c2.f.p0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.a1.e;
import b.a.p0.a.h0.m.o.a;
import b.a.p0.a.v2.o0;
import b.a.p0.a.v2.q0;
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
    public static final boolean f4393a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f4394a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f4395b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f4396c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4397d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4398e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4399f;

        public a(boolean z, b.a.p0.a.a2.e eVar, d dVar, String str, String str2, String str3) {
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
            this.f4394a = z;
            this.f4395b = eVar;
            this.f4396c = dVar;
            this.f4397d = str;
            this.f4398e = str2;
            this.f4399f = str3;
        }

        @Override // b.a.p0.a.h0.m.o.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.h(this.f4394a, this.f4395b.f3961f, "pkg_retry_fail", String.valueOf(2113));
                this.f4396c.b(2113);
            }
        }

        @Override // b.a.p0.a.h0.m.o.a.b
        public void b(b.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                boolean n = g.n(this.f4395b.f3961f, aVar);
                if (g.f4393a) {
                    String str = "getAppPackage-isNeedGetPkgRetry:" + n + ",isRetry:" + this.f4394a + ",pmsErrorCode:" + aVar;
                }
                if (n) {
                    g.i(this.f4395b.f3961f, aVar);
                    b.a.p0.a.f1.d.b.a.b().a(this.f4395b.f3961f);
                    g.j(this.f4395b, this.f4398e, this.f4397d, this.f4396c, this.f4399f, true);
                    return;
                }
                b.a.p0.a.z1.b.f.e.f(AppRuntime.getAppContext(), b.a.p0.a.h.swanapp_tip_package_unavailable).F();
                g.h(this.f4394a, this.f4395b.f3961f, "pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f4396c.b(2113);
            }
        }

        @Override // b.a.p0.a.h0.m.o.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                g.h(this.f4394a, this.f4395b.f3961f, "pkg_retry_success", "");
                this.f4396c.a(this.f4397d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements b.a.p0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4400a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f4401b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4402c;

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
            this.f4400a = str;
            this.f4401b = dVar;
            this.f4402c = str2;
        }

        @Override // b.a.p0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
                if (i2 != null) {
                    i2.x0(this.f4400a, true);
                }
                this.f4401b.a(this.f4402c);
            }
        }

        @Override // b.a.p0.a.h0.m.b
        public void b(int i2, b.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f4401b.b(i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements b.a.p0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4403a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f4404b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4405c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f4406d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4407e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4408f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4409g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4410h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4411i;

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
            this.f4403a = str;
            this.f4404b = z;
            this.f4405c = str2;
            this.f4406d = dVar;
            this.f4407e = str3;
            this.f4408f = str4;
            this.f4409g = str5;
            this.f4410h = str6;
            this.f4411i = str7;
        }

        @Override // b.a.p0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.a2.d.g().r().x0(this.f4403a, true);
                g.h(this.f4404b, this.f4405c, "sub_pkg_retry_success", "");
                this.f4406d.a(this.f4407e);
            }
        }

        @Override // b.a.p0.a.h0.m.b
        public void b(int i2, b.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                boolean n = g.n(this.f4405c, aVar);
                if (g.f4393a) {
                    String str = "isNeedGetPkgRetry:" + n + ",isRetry:" + this.f4404b + ",pmsErrorCode:" + aVar;
                }
                if (n) {
                    g.i(this.f4408f, aVar);
                    b.a.p0.a.f1.d.b.a.b().a(this.f4405c);
                    g.m(this.f4408f, this.f4409g, this.f4410h, this.f4403a, this.f4411i, this.f4407e, this.f4406d, true);
                    return;
                }
                g.h(this.f4404b, this.f4405c, "sub_pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f4406d.b(i2);
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
        public final d f4412a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f4413b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f4414e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f4415f;

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
                this.f4415f = eVar;
                this.f4414e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f4415f.f4412a.a(this.f4414e);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f4416e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f4417f;

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
                this.f4417f = eVar;
                this.f4416e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f4417f.f4413b) {
                        b.a.p0.a.z1.b.f.e.f(AppRuntime.getAppContext(), b.a.p0.a.h.swanapp_tip_package_unavailable).F();
                    }
                    this.f4417f.f4412a.b(this.f4416e);
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
            this.f4412a = dVar;
            this.f4413b = z;
        }

        @Override // b.a.p0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                q0.b0(new a(this, str));
            }
        }

        @Override // b.a.p0.a.c2.f.p0.g.d
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(778913552, "Lb/a/p0/a/c2/f/p0/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(778913552, "Lb/a/p0/a/c2/f/p0/g;");
                return;
            }
        }
        f4393a = b.a.p0.a.k.f6397a;
    }

    public static void g(b.a.p0.a.a2.e eVar, b.a.p0.a.l1.b bVar, String str, d dVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, eVar, bVar, str, dVar, str2) == null) {
            if (eVar != null) {
                eVar.B().e(eVar.getAppId());
            }
            if (dVar == null) {
                return;
            }
            if (eVar != null && bVar != null && !TextUtils.isEmpty(bVar.f6555e) && !TextUtils.isEmpty(bVar.f6558h)) {
                String str3 = bVar.f6558h;
                String Q = eVar.Q(bVar.f6555e);
                boolean g0 = eVar.g0(str3);
                if (!b.a.p0.a.e0.f.e.e.d() && !b.a.p0.a.u1.a.a.G() && !b.a.p0.a.u1.a.a.C()) {
                    if (b.a.p0.a.t1.b.a.e(bVar.f6555e)) {
                        dVar.a(str);
                        return;
                    }
                    if (g0) {
                        if (b.a.p0.a.a1.e.A(eVar.f3961f, eVar.Y())) {
                            dVar.a(str);
                            return;
                        } else if (eVar.d0()) {
                            j(eVar, str3, str, dVar, str2, false);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(Q)) {
                        dVar.b(2111);
                        return;
                    } else if (eVar.i0(Q)) {
                        dVar.a(str);
                        return;
                    } else if (eVar.k0(Q) && eVar.j0(Q)) {
                        dVar.a(str);
                        eVar.x0(Q, true);
                        return;
                    } else {
                        String F = eVar.F(Q);
                        if (TextUtils.isEmpty(F)) {
                            dVar.b(2112);
                            return;
                        }
                        boolean f0 = eVar.f0(str3);
                        if (!b.a.p0.a.a1.e.A(eVar.f3961f, eVar.Y()) && !f0) {
                            j(eVar, str3, str, dVar, str2, false);
                            return;
                        }
                        HybridUbcFlow q = b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2);
                        q.C(new UbcFlowEvent("na_start_sub_package_download"));
                        q.A("sub_state", "1");
                        l(eVar.f3961f, eVar.Y(), "3", Q, F, str, new e(dVar, true));
                        return;
                    }
                } else if (!g0 && TextUtils.isEmpty(Q)) {
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
            b.a.p0.a.f1.d.b.a.b().g(str);
            b.a.p0.a.j2.k.G(str2, str3);
        }
    }

    public static void i(String str, b.a.p0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, aVar) == null) {
            if ((aVar == null ? 0L : aVar.g()) == 2205) {
                b.a.p0.a.n0.f.c().d().u(b.a.p0.a.v2.z0.a.a(str), true, 12);
            }
        }
    }

    public static void j(b.a.p0.a.a2.e eVar, String str, String str2, d dVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{eVar, str, str2, dVar, str3, Boolean.valueOf(z)}) == null) || dVar == null) {
            return;
        }
        if (eVar == null) {
            dVar.b(2111);
            return;
        }
        HybridUbcFlow q = b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str3);
        q.C(new UbcFlowEvent("na_start_sub_package_download"));
        q.A("sub_state", "1");
        b.a.p0.n.i.m.c cVar = new b.a.p0.n.i.m.c(eVar.f3961f, b.a.p0.a.a2.d.g().l());
        cVar.o(q0.o(eVar.Y()));
        cVar.r(str);
        b.a.p0.n.b.b(cVar, new b.a.p0.a.h0.m.o.a(eVar.f3961f, new a(z, eVar, dVar, str2, str, str3)));
    }

    public static void k(String str, String str2, String str3, String str4, String str5, String str6, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, str2, str3, str4, str5, str6, dVar}) == null) || dVar == null) {
            return;
        }
        b.a.p0.n.i.m.f fVar = new b.a.p0.n.i.m.f(str, str2, str5, 0);
        fVar.d(str3);
        b.a.p0.n.b.f(fVar, new b.a.p0.a.h0.m.q.a(str, str2, new b(str4, dVar, str6)));
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
        String e2 = b.a.p0.a.f1.d.b.a.b().e(str, str4);
        b.a.p0.n.i.m.f fVar = new b.a.p0.n.i.m.f(str, str2, str5, 0);
        fVar.d(str3);
        b.a.p0.n.b.f(fVar, new b.a.p0.a.h0.m.q.a(str, str2, new c(str4, z, e2, dVar, str6, str, str2, str3, str5)));
    }

    public static boolean n(String str, b.a.p0.a.q2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, aVar)) == null) {
            long g2 = aVar == null ? 0L : aVar.g();
            return SwanAppNetworkUtils.i(b.a.p0.a.c1.a.b()) && b.a.p0.a.f1.d.b.a.b().f(str) && (g2 == 2101 || g2 == 2205);
        }
        return invokeLL.booleanValue;
    }

    public static boolean o(b.a.p0.a.f1.e.b bVar, e.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, bVar, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return p(bVar, gVar.f3904b);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(b.a.p0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, bVar, swanAppConfigData)) == null) {
            if (bVar != null && !TextUtils.isEmpty(bVar.d0()) && !b.a.p0.a.e0.f.e.e.d() && !b.a.p0.a.u1.a.a.C()) {
                String f2 = o0.f(bVar.d0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.f44229b != null) {
                    String c2 = j.c(f2, swanAppConfigData);
                    if (swanAppConfigData.f44229b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.f44230c.f44265c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (b.a.p0.n.g.a.h().m(bVar.G(), bVar.s1(), str)) {
                            return !new File(e.C0109e.i(bVar.G(), bVar.s1()), str).exists();
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
