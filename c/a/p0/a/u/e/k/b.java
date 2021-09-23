package c.a.p0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.a2.e;
import c.a.p0.a.c2.f.p0.g;
import c.a.p0.a.g1.f;
import c.a.p0.a.h;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.h0.t.a;
import c.a.p0.a.j2.k;
import c.a.p0.a.r1.i;
import c.a.p0.a.v2.q0;
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
public class b extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int f9010d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f9011e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9012f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.l1.b f9013g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9014h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f9015i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f9016j;

        /* renamed from: c.a.p0.a.u.e.k.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0408a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f9017a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f9018b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f9019c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f9020d;

            public C0408a(a aVar, e eVar, String str, a.d dVar) {
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
                this.f9020d = aVar;
                this.f9017a = eVar;
                this.f9018b = str;
                this.f9019c = dVar;
            }

            @Override // c.a.p0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f9020d.f9014h);
                    c.a.p0.a.e0.d.g("Api-NavigateTo", "check pages success");
                    k.B(true, this.f9017a.N().T());
                    this.f9020d.f9011e.o();
                    List<String> g2 = c.a.p0.a.c2.f.p0.a.g(this.f9020d.f9015i);
                    a aVar = this.f9020d;
                    c.a.p0.a.c2.f.p0.a.m(aVar.f9016j, this.f9017a, this.f9018b, aVar.f9013g.f7244e, g2, aVar.f9012f);
                    a aVar2 = this.f9020d;
                    aVar2.f9016j.w(this.f9019c, aVar2.f9013g, aVar2.f9015i, aVar2.f9014h);
                }
            }

            @Override // c.a.p0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    c.a.p0.a.e0.d.b("Api-NavigateTo", "check pages failed");
                    k.B(false, this.f9017a.N().T());
                    this.f9020d.f9011e.o();
                    if (c.a.p0.a.u.c.d.f8735c) {
                        Context i3 = this.f9020d.f9016j.i();
                        c.a.p0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                    }
                    a aVar = this.f9020d;
                    c.a.p0.a.c2.f.p0.a.k(aVar.f9016j, aVar.f9012f);
                }
            }
        }

        public a(b bVar, f fVar, String str, c.a.p0.a.l1.b bVar2, String str2, c.a.p0.a.h0.g.g gVar) {
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
            this.f9016j = bVar;
            this.f9011e = fVar;
            this.f9012f = str;
            this.f9013g = bVar2;
            this.f9014h = str2;
            this.f9015i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = c.a.p0.a.u.c.d.f8735c;
                SwanAppActivity activity = this.f9011e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a.d f2 = c.a.p0.a.h0.t.a.f(activity);
                    String c2 = f2.f6445a.c();
                    if (c.a.p0.a.u.c.d.f8735c) {
                        String str = "slave webView id: " + c2;
                    }
                    e i2 = e.i();
                    if (i2 == null) {
                        if (!c.a.p0.a.u.c.d.f8735c) {
                            this.f9016j.d(this.f9012f, new c.a.p0.a.u.h.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    this.f9011e.u();
                    c.a.p0.a.c2.f.p0.g.g(i2, this.f9013g, c2, new C0408a(this, i2, c2, f2), this.f9014h);
                } else if (!c.a.p0.a.u.c.d.f8735c) {
                    this.f9016j.d(this.f9012f, new c.a.p0.a.u.h.b(1001, "swan activity is null"));
                } else {
                    throw new RuntimeException("swan activity is null");
                }
            }
        }
    }

    /* renamed from: c.a.p0.a.u.e.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0409b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f9021a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9022b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.l1.b f9023c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.g f9024d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9025e;

        public C0409b(b bVar, a.d dVar, String str, c.a.p0.a.l1.b bVar2, c.a.p0.a.h0.g.g gVar) {
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
            this.f9025e = bVar;
            this.f9021a = dVar;
            this.f9022b = str;
            this.f9023c = bVar2;
            this.f9024d = gVar;
        }

        @Override // c.a.p0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = c.a.p0.a.u.c.d.f8735c;
                i.e(this.f9021a, this.f9022b);
                this.f9025e.u(this.f9021a.f6445a, this.f9023c, this.f9024d, this.f9022b);
                boolean z2 = c.a.p0.a.u.c.d.f8735c;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1123381880, "Lc/a/p0/a/u/e/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1123381880, "Lc/a/p0/a/u/e/k/b;");
                return;
            }
        }
        f9010d = c.a.p0.a.c1.a.Z().s();
        if (c.a.p0.a.u.c.d.f8735c) {
            String str = "NavigateToAction max count: " + f9010d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.p0.a.u.c.b bVar) {
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
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void u(c.a.p0.a.p.e.b bVar, c.a.p0.a.l1.b bVar2, c.a.p0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, bVar, bVar2, gVar, str) == null) || (activity = f.V().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.p0.a.c2.f.p0.a.e(bVar, bVar2, str);
        i.c(0, str);
        if (gVar.k() < f9010d) {
            c.a.p0.a.h0.g.f.C3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(c.a.p0.a.h0.g.g.f5936g, c.a.p0.a.h0.g.g.f5938i);
            i2.k("normal", bVar2).b();
            c.a.p0.a.v2.g.c(gVar, i());
            c.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            i.a(str, bVar2);
            return;
        }
        c.u(gVar, bVar2, str, true);
    }

    public c.a.p0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (c.a.p0.a.u.c.d.f8735c) {
                String str2 = "handle: " + str;
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-NavigateTo", str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.p0.a.u.c.d.f8735c) {
                    c.a.p0.a.e0.d.b("Api-NavigateTo", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String p = c.a.p0.a.c2.f.p0.a.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                c.a.p0.a.e0.d.b("Api-NavigateTo", "url is null");
                return new c.a.p0.a.u.h.b(202, "url is null");
            }
            f V = f.V();
            c.a.p0.a.h0.g.g W = V.W();
            if (W == null) {
                c.a.p0.a.e0.d.b("Api-NavigateTo", "manager is null");
                return new c.a.p0.a.u.h.b(1001, "manager is null");
            }
            c.a.p0.a.l1.b g2 = c.a.p0.a.l1.b.g(p, V.A());
            c.a.p0.a.j2.h.f(g2.f7244e, "0");
            if (!q0.b(V.s(), g2, false)) {
                String str3 = "page params error : path=" + g2.f7244e + " ; routePath=" + g2.f7247h;
                c.a.p0.a.e0.d.b("Api-NavigateTo", str3);
                return new c.a.p0.a.u.h.b(202, str3);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && g2 != null && !TextUtils.isEmpty(g2.f7247h) && e.i() != null) {
                e.i().x0(optString, g2.f7247h);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = c.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.C(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                c.a.p0.a.e0.d.b("Api-NavigateTo", "cb is null");
                return new c.a.p0.a.u.h.b(202, "cb is null");
            } else if (c.a.p0.a.c2.f.g0.d.b().a(g2)) {
                c.a.p0.a.c2.f.g0.d.b().i("navigateTo", g2);
                c.a.p0.a.e0.d.b("Api-NavigateTo", "access to this page is prohibited");
                return new c.a.p0.a.u.h.b(1003, "access to this page is prohibited");
            } else {
                q0.X(new a(this, V, optString3, g2, uuid, W));
                return new c.a.p0.a.u.h.b(0);
            }
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void w(a.d dVar, c.a.p0.a.l1.b bVar, c.a.p0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f6446b;
            HybridUbcFlow q = c.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (c.a.p0.a.u.c.d.f8735c) {
                String str2 = "tryToExecutePageRoute start. isReady : " + z;
            }
            c.a.p0.a.h0.t.a.n(dVar, new C0409b(this, dVar, str, bVar, gVar));
            boolean z2 = c.a.p0.a.u.c.d.f8735c;
        }
    }
}
