package c.a.o0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.o0.a.a2.e;
import c.a.o0.a.c2.f.p0.g;
import c.a.o0.a.g1.f;
import c.a.o0.a.h;
import c.a.o0.a.h0.g.g;
import c.a.o0.a.h0.t.a;
import c.a.o0.a.j2.k;
import c.a.o0.a.r1.i;
import c.a.o0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int f8974d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8975e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8976f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.l1.b f8977g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8978h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8979i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f8980j;

        /* renamed from: c.a.o0.a.u.e.k.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0406a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f8981a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f8982b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f8983c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f8984d;

            public C0406a(a aVar, e eVar, String str, a.d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, eVar, str, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8984d = aVar;
                this.f8981a = eVar;
                this.f8982b = str;
                this.f8983c = dVar;
            }

            @Override // c.a.o0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f8984d.f8978h);
                    c.a.o0.a.e0.d.g("Api-NavigateTo", "check pages success");
                    k.B(true, this.f8981a.N().T());
                    this.f8984d.f8975e.o();
                    List<String> g2 = c.a.o0.a.c2.f.p0.a.g(this.f8984d.f8979i);
                    a aVar = this.f8984d;
                    c.a.o0.a.c2.f.p0.a.m(aVar.f8980j, this.f8981a, this.f8982b, aVar.f8977g.f7208e, g2, aVar.f8976f);
                    a aVar2 = this.f8984d;
                    aVar2.f8980j.w(this.f8983c, aVar2.f8977g, aVar2.f8979i, aVar2.f8978h);
                }
            }

            @Override // c.a.o0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    c.a.o0.a.e0.d.b("Api-NavigateTo", "check pages failed");
                    k.B(false, this.f8981a.N().T());
                    this.f8984d.f8975e.o();
                    if (c.a.o0.a.u.c.d.f8699c) {
                        Context i3 = this.f8984d.f8980j.i();
                        c.a.o0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                    }
                    a aVar = this.f8984d;
                    c.a.o0.a.c2.f.p0.a.k(aVar.f8980j, aVar.f8976f);
                }
            }
        }

        public a(b bVar, f fVar, String str, c.a.o0.a.l1.b bVar2, String str2, c.a.o0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, fVar, str, bVar2, str2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8980j = bVar;
            this.f8975e = fVar;
            this.f8976f = str;
            this.f8977g = bVar2;
            this.f8978h = str2;
            this.f8979i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = c.a.o0.a.u.c.d.f8699c;
                SwanAppActivity activity = this.f8975e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a.d f2 = c.a.o0.a.h0.t.a.f(activity);
                    String c2 = f2.f6409a.c();
                    if (c.a.o0.a.u.c.d.f8699c) {
                        String str = "slave webView id: " + c2;
                    }
                    e i2 = e.i();
                    if (i2 == null) {
                        if (!c.a.o0.a.u.c.d.f8699c) {
                            this.f8980j.d(this.f8976f, new c.a.o0.a.u.h.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    this.f8975e.u();
                    c.a.o0.a.c2.f.p0.g.g(i2, this.f8977g, c2, new C0406a(this, i2, c2, f2), this.f8978h);
                } else if (!c.a.o0.a.u.c.d.f8699c) {
                    this.f8980j.d(this.f8976f, new c.a.o0.a.u.h.b(1001, "swan activity is null"));
                } else {
                    throw new RuntimeException("swan activity is null");
                }
            }
        }
    }

    /* renamed from: c.a.o0.a.u.e.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0407b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f8985a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8986b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.l1.b f8987c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.g.g f8988d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8989e;

        public C0407b(b bVar, a.d dVar, String str, c.a.o0.a.l1.b bVar2, c.a.o0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, dVar, str, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8989e = bVar;
            this.f8985a = dVar;
            this.f8986b = str;
            this.f8987c = bVar2;
            this.f8988d = gVar;
        }

        @Override // c.a.o0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = c.a.o0.a.u.c.d.f8699c;
                i.e(this.f8985a, this.f8986b);
                this.f8989e.u(this.f8985a.f6409a, this.f8987c, this.f8988d, this.f8986b);
                boolean z2 = c.a.o0.a.u.c.d.f8699c;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1416784887, "Lc/a/o0/a/u/e/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1416784887, "Lc/a/o0/a/u/e/k/b;");
                return;
            }
        }
        f8974d = c.a.o0.a.c1.a.Z().s();
        if (c.a.o0.a.u.c.d.f8699c) {
            String str = "NavigateToAction max count: " + f8974d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.o0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void u(c.a.o0.a.p.e.b bVar, c.a.o0.a.l1.b bVar2, c.a.o0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, bVar, bVar2, gVar, str) == null) || (activity = f.V().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.o0.a.c2.f.p0.a.e(bVar, bVar2, str);
        i.c(0, str);
        if (gVar.k() < f8974d) {
            c.a.o0.a.h0.g.f.C3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(c.a.o0.a.h0.g.g.f5900g, c.a.o0.a.h0.g.g.f5902i);
            i2.k("normal", bVar2).b();
            c.a.o0.a.v2.g.c(gVar, i());
            c.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            i.a(str, bVar2);
            return;
        }
        c.u(gVar, bVar2, str, true);
    }

    public c.a.o0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (c.a.o0.a.u.c.d.f8699c) {
                String str2 = "handle: " + str;
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-NavigateTo", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    c.a.o0.a.e0.d.b("Api-NavigateTo", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String p = c.a.o0.a.c2.f.p0.a.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                c.a.o0.a.e0.d.b("Api-NavigateTo", "url is null");
                return new c.a.o0.a.u.h.b(202, "url is null");
            }
            f V = f.V();
            c.a.o0.a.h0.g.g W = V.W();
            if (W == null) {
                c.a.o0.a.e0.d.b("Api-NavigateTo", "manager is null");
                return new c.a.o0.a.u.h.b(1001, "manager is null");
            }
            c.a.o0.a.l1.b g2 = c.a.o0.a.l1.b.g(p, V.A());
            c.a.o0.a.j2.h.f(g2.f7208e, "0");
            if (!q0.b(V.s(), g2, false)) {
                String str3 = "page params error : path=" + g2.f7208e + " ; routePath=" + g2.f7211h;
                c.a.o0.a.e0.d.b("Api-NavigateTo", str3);
                return new c.a.o0.a.u.h.b(202, str3);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && g2 != null && !TextUtils.isEmpty(g2.f7211h) && e.i() != null) {
                e.i().x0(optString, g2.f7211h);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = c.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.C(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                c.a.o0.a.e0.d.b("Api-NavigateTo", "cb is null");
                return new c.a.o0.a.u.h.b(202, "cb is null");
            } else if (c.a.o0.a.c2.f.g0.d.b().a(g2)) {
                c.a.o0.a.c2.f.g0.d.b().i("navigateTo", g2);
                c.a.o0.a.e0.d.b("Api-NavigateTo", "access to this page is prohibited");
                return new c.a.o0.a.u.h.b(1003, "access to this page is prohibited");
            } else {
                q0.X(new a(this, V, optString3, g2, uuid, W));
                return new c.a.o0.a.u.h.b(0);
            }
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final void w(a.d dVar, c.a.o0.a.l1.b bVar, c.a.o0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f6410b;
            HybridUbcFlow q = c.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (c.a.o0.a.u.c.d.f8699c) {
                String str2 = "tryToExecutePageRoute start. isReady : " + z;
            }
            c.a.o0.a.h0.t.a.n(dVar, new C0407b(this, dVar, str, bVar, gVar));
            boolean z2 = c.a.o0.a.u.c.d.f8699c;
        }
    }
}
