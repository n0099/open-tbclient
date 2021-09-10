package c.a.p0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a2.e;
import c.a.p0.a.c2.f.p0.g;
import c.a.p0.a.g1.f;
import c.a.p0.a.h;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.h0.t.a;
import c.a.p0.a.r1.i;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f9018e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9019f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.l1.b f9020g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9021h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f9022i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f9023j;

        /* renamed from: c.a.p0.a.u.e.k.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0410a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f9024a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f9025b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f9026c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f9027d;

            public C0410a(a aVar, e eVar, String str, a.d dVar) {
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
                this.f9027d = aVar;
                this.f9024a = eVar;
                this.f9025b = str;
                this.f9026c = dVar;
            }

            @Override // c.a.p0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f9027d.f9021h);
                    c.a.p0.a.e0.d.g("Api-RedirectTo", "check pages success");
                    this.f9027d.f9018e.o();
                    a aVar = this.f9027d;
                    c.a.p0.a.c2.f.p0.a.m(aVar.f9023j, this.f9024a, this.f9025b, aVar.f9020g.f7236e, null, aVar.f9019f);
                    a aVar2 = this.f9027d;
                    aVar2.f9023j.v(this.f9026c, aVar2.f9020g, aVar2.f9022i, aVar2.f9021h);
                }
            }

            @Override // c.a.p0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    c.a.p0.a.e0.d.b("Api-RedirectTo", "check pages failed");
                    this.f9027d.f9018e.o();
                    if (c.a.p0.a.u.c.d.f8727c) {
                        Context i3 = this.f9027d.f9023j.i();
                        c.a.p0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                    }
                    a aVar = this.f9027d;
                    c.a.p0.a.c2.f.p0.a.k(aVar.f9023j, aVar.f9019f);
                }
            }
        }

        public a(c cVar, f fVar, String str, c.a.p0.a.l1.b bVar, String str2, c.a.p0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar, str, bVar, str2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9023j = cVar;
            this.f9018e = fVar;
            this.f9019f = str;
            this.f9020g = bVar;
            this.f9021h = str2;
            this.f9022i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = c.a.p0.a.u.c.d.f8727c;
                SwanAppActivity activity = this.f9018e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a.d f2 = c.a.p0.a.h0.t.a.f(activity);
                    String c2 = f2.f6437a.c();
                    if (c.a.p0.a.u.c.d.f8727c) {
                        String str = "webview id: " + c2;
                    }
                    e i2 = e.i();
                    if (i2 == null) {
                        if (!c.a.p0.a.u.c.d.f8727c) {
                            this.f9023j.d(this.f9019f, new c.a.p0.a.u.h.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    this.f9018e.u();
                    c.a.p0.a.c2.f.p0.g.g(i2, this.f9020g, c2, new C0410a(this, i2, c2, f2), this.f9021h);
                } else if (!c.a.p0.a.u.c.d.f8727c) {
                    this.f9023j.d(this.f9019f, new c.a.p0.a.u.h.b(1001, "swan activity is null"));
                } else {
                    throw new RuntimeException("swan activity is null");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f9028a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9029b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.l1.b f9030c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.g f9031d;

        public b(c cVar, a.d dVar, String str, c.a.p0.a.l1.b bVar, c.a.p0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9028a = dVar;
            this.f9029b = str;
            this.f9030c = bVar;
            this.f9031d = gVar;
        }

        @Override // c.a.p0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = c.a.p0.a.u.c.d.f8727c;
                i.e(this.f9028a, this.f9029b);
                c.a.p0.a.c2.f.p0.a.e(this.f9028a.f6437a, this.f9030c, this.f9029b);
                c.u(this.f9031d, this.f9030c, this.f9029b, false);
                boolean z2 = c.a.p0.a.u.c.d.f8727c;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean t() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            e Q = e.Q();
            return Q == null || (x = Q.x()) == null || x.isFinishing() || x.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public static void u(c.a.p0.a.h0.g.g gVar, c.a.p0.a.l1.b bVar, String str, boolean z) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{gVar, bVar, str, Boolean.valueOf(z)}) == null) || t() || (x = c.a.p0.a.a2.d.g().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        i.c(z ? 8 : 2, str);
        c.a.p0.a.h0.g.f.C3(q0.n());
        g.b i2 = gVar.i("redirectTo");
        i2.n(0, 0);
        g.b k = i2.k("normal", bVar);
        k.m(z ? 0 : gVar.k() - 2);
        k.b();
        c.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
        i.a(str, bVar);
    }

    public final void v(a.d dVar, c.a.p0.a.l1.b bVar, c.a.p0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f6438b;
            HybridUbcFlow q = c.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (c.a.p0.a.u.c.d.f8727c) {
                String str2 = "tryToExecutePageRoute start. isReady : " + z;
            }
            c.a.p0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            boolean z2 = c.a.p0.a.u.c.d.f8727c;
        }
    }

    public c.a.p0.a.u.h.b w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (c.a.p0.a.u.c.d.f8727c) {
                String str2 = "handle: " + str;
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-RedirectTo", str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.p0.a.u.c.d.f8727c) {
                    c.a.p0.a.e0.d.b("Api-RedirectTo", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String p = c.a.p0.a.c2.f.p0.a.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                c.a.p0.a.e0.d.b("Api-RedirectTo", "url is null");
                return new c.a.p0.a.u.h.b(202, "url is null");
            }
            f V = f.V();
            c.a.p0.a.h0.g.g W = V.W();
            if (W == null) {
                c.a.p0.a.e0.d.b("Api-RedirectTo", "manager is null");
                return new c.a.p0.a.u.h.b(1001, "manager is null");
            }
            c.a.p0.a.l1.b g2 = c.a.p0.a.l1.b.g(p, V.A());
            c.a.p0.a.j2.h.f(g2.f7236e, "2");
            if (!q0.b(V.s(), g2, false)) {
                String str3 = "page params error : path=" + g2.f7236e + " ; routePath=" + g2.f7239h;
                c.a.p0.a.e0.d.b("Api-RedirectTo", str3);
                return new c.a.p0.a.u.h.b(202, str3);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && g2 != null && !TextUtils.isEmpty(g2.f7239h) && e.i() != null) {
                e.i().x0(optString, g2.f7239h);
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
                c.a.p0.a.e0.d.b("Api-RedirectTo", "cb is null");
                return new c.a.p0.a.u.h.b(202, "cb is null");
            } else if (c.a.p0.a.c2.f.g0.d.b().a(g2)) {
                c.a.p0.a.c2.f.g0.d.b().i("redirectTo", g2);
                c.a.p0.a.e0.d.b("Api-RedirectTo", "access to this page is prohibited");
                return new c.a.p0.a.u.h.b(1003, "access to this page is prohibited");
            } else {
                q0.X(new a(this, V, optString3, g2, uuid, W));
                return new c.a.p0.a.u.h.b(0);
            }
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }
}
