package c.a.o0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.a2.e;
import c.a.o0.a.c2.f.p0.g;
import c.a.o0.a.g1.f;
import c.a.o0.a.h;
import c.a.o0.a.h0.g.g;
import c.a.o0.a.h0.t.a;
import c.a.o0.a.r1.i;
import c.a.o0.a.v2.q0;
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
public class c extends c.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8990e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8991f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.l1.b f8992g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8993h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8994i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f8995j;

        /* renamed from: c.a.o0.a.u.e.k.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0408a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f8996a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f8997b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f8998c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f8999d;

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
                this.f8999d = aVar;
                this.f8996a = eVar;
                this.f8997b = str;
                this.f8998c = dVar;
            }

            @Override // c.a.o0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f8999d.f8993h);
                    c.a.o0.a.e0.d.g("Api-RedirectTo", "check pages success");
                    this.f8999d.f8990e.o();
                    a aVar = this.f8999d;
                    c.a.o0.a.c2.f.p0.a.m(aVar.f8995j, this.f8996a, this.f8997b, aVar.f8992g.f7208e, null, aVar.f8991f);
                    a aVar2 = this.f8999d;
                    aVar2.f8995j.v(this.f8998c, aVar2.f8992g, aVar2.f8994i, aVar2.f8993h);
                }
            }

            @Override // c.a.o0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    c.a.o0.a.e0.d.b("Api-RedirectTo", "check pages failed");
                    this.f8999d.f8990e.o();
                    if (c.a.o0.a.u.c.d.f8699c) {
                        Context i3 = this.f8999d.f8995j.i();
                        c.a.o0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                    }
                    a aVar = this.f8999d;
                    c.a.o0.a.c2.f.p0.a.k(aVar.f8995j, aVar.f8991f);
                }
            }
        }

        public a(c cVar, f fVar, String str, c.a.o0.a.l1.b bVar, String str2, c.a.o0.a.h0.g.g gVar) {
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
            this.f8995j = cVar;
            this.f8990e = fVar;
            this.f8991f = str;
            this.f8992g = bVar;
            this.f8993h = str2;
            this.f8994i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = c.a.o0.a.u.c.d.f8699c;
                SwanAppActivity activity = this.f8990e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a.d f2 = c.a.o0.a.h0.t.a.f(activity);
                    String c2 = f2.f6409a.c();
                    if (c.a.o0.a.u.c.d.f8699c) {
                        String str = "webview id: " + c2;
                    }
                    e i2 = e.i();
                    if (i2 == null) {
                        if (!c.a.o0.a.u.c.d.f8699c) {
                            this.f8995j.d(this.f8991f, new c.a.o0.a.u.h.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    this.f8990e.u();
                    c.a.o0.a.c2.f.p0.g.g(i2, this.f8992g, c2, new C0408a(this, i2, c2, f2), this.f8993h);
                } else if (!c.a.o0.a.u.c.d.f8699c) {
                    this.f8995j.d(this.f8991f, new c.a.o0.a.u.h.b(1001, "swan activity is null"));
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
        public final /* synthetic */ a.d f9000a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9001b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.l1.b f9002c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.g.g f9003d;

        public b(c cVar, a.d dVar, String str, c.a.o0.a.l1.b bVar, c.a.o0.a.h0.g.g gVar) {
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
            this.f9000a = dVar;
            this.f9001b = str;
            this.f9002c = bVar;
            this.f9003d = gVar;
        }

        @Override // c.a.o0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = c.a.o0.a.u.c.d.f8699c;
                i.e(this.f9000a, this.f9001b);
                c.a.o0.a.c2.f.p0.a.e(this.f9000a.f6409a, this.f9002c, this.f9001b);
                c.u(this.f9003d, this.f9002c, this.f9001b, false);
                boolean z2 = c.a.o0.a.u.c.d.f8699c;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.o0.a.u.c.b bVar) {
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
                super((c.a.o0.a.u.c.b) newInitContext.callArgs[0]);
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

    public static void u(c.a.o0.a.h0.g.g gVar, c.a.o0.a.l1.b bVar, String str, boolean z) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{gVar, bVar, str, Boolean.valueOf(z)}) == null) || t() || (x = c.a.o0.a.a2.d.g().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        i.c(z ? 8 : 2, str);
        c.a.o0.a.h0.g.f.C3(q0.n());
        g.b i2 = gVar.i("redirectTo");
        i2.n(0, 0);
        g.b k = i2.k("normal", bVar);
        k.m(z ? 0 : gVar.k() - 2);
        k.b();
        c.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
        i.a(str, bVar);
    }

    public final void v(a.d dVar, c.a.o0.a.l1.b bVar, c.a.o0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f6410b;
            HybridUbcFlow q = c.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (c.a.o0.a.u.c.d.f8699c) {
                String str2 = "tryToExecutePageRoute start. isReady : " + z;
            }
            c.a.o0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            boolean z2 = c.a.o0.a.u.c.d.f8699c;
        }
    }

    public c.a.o0.a.u.h.b w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (c.a.o0.a.u.c.d.f8699c) {
                String str2 = "handle: " + str;
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-RedirectTo", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    c.a.o0.a.e0.d.b("Api-RedirectTo", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String p = c.a.o0.a.c2.f.p0.a.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                c.a.o0.a.e0.d.b("Api-RedirectTo", "url is null");
                return new c.a.o0.a.u.h.b(202, "url is null");
            }
            f V = f.V();
            c.a.o0.a.h0.g.g W = V.W();
            if (W == null) {
                c.a.o0.a.e0.d.b("Api-RedirectTo", "manager is null");
                return new c.a.o0.a.u.h.b(1001, "manager is null");
            }
            c.a.o0.a.l1.b g2 = c.a.o0.a.l1.b.g(p, V.A());
            c.a.o0.a.j2.h.f(g2.f7208e, "2");
            if (!q0.b(V.s(), g2, false)) {
                String str3 = "page params error : path=" + g2.f7208e + " ; routePath=" + g2.f7211h;
                c.a.o0.a.e0.d.b("Api-RedirectTo", str3);
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
                c.a.o0.a.e0.d.b("Api-RedirectTo", "cb is null");
                return new c.a.o0.a.u.h.b(202, "cb is null");
            } else if (c.a.o0.a.c2.f.g0.d.b().a(g2)) {
                c.a.o0.a.c2.f.g0.d.b().i("redirectTo", g2);
                c.a.o0.a.e0.d.b("Api-RedirectTo", "access to this page is prohibited");
                return new c.a.o0.a.u.h.b(1003, "access to this page is prohibited");
            } else {
                q0.X(new a(this, V, optString3, g2, uuid, W));
                return new c.a.o0.a.u.h.b(0);
            }
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }
}
