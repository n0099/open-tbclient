package c.a.n0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a2.e;
import c.a.n0.a.c2.f.p0.g;
import c.a.n0.a.g1.f;
import c.a.n0.a.h;
import c.a.n0.a.h0.g.g;
import c.a.n0.a.h0.t.a;
import c.a.n0.a.r1.i;
import c.a.n0.a.v2.q0;
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
public class c extends c.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8744e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8745f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.l1.b f8746g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8747h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8748i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f8749j;

        /* renamed from: c.a.n0.a.u.e.k.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0400a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f8750a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f8751b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f8752c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f8753d;

            public C0400a(a aVar, e eVar, String str, a.d dVar) {
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
                this.f8753d = aVar;
                this.f8750a = eVar;
                this.f8751b = str;
                this.f8752c = dVar;
            }

            @Override // c.a.n0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f8753d.f8747h);
                    c.a.n0.a.e0.d.g("Api-RedirectTo", "check pages success");
                    this.f8753d.f8744e.o();
                    a aVar = this.f8753d;
                    c.a.n0.a.c2.f.p0.a.m(aVar.f8749j, this.f8750a, this.f8751b, aVar.f8746g.f6962e, null, aVar.f8745f);
                    a aVar2 = this.f8753d;
                    aVar2.f8749j.v(this.f8752c, aVar2.f8746g, aVar2.f8748i, aVar2.f8747h);
                }
            }

            @Override // c.a.n0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    c.a.n0.a.e0.d.b("Api-RedirectTo", "check pages failed");
                    this.f8753d.f8744e.o();
                    if (c.a.n0.a.u.c.d.f8453c) {
                        Context i3 = this.f8753d.f8749j.i();
                        c.a.n0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                    }
                    a aVar = this.f8753d;
                    c.a.n0.a.c2.f.p0.a.k(aVar.f8749j, aVar.f8745f);
                }
            }
        }

        public a(c cVar, f fVar, String str, c.a.n0.a.l1.b bVar, String str2, c.a.n0.a.h0.g.g gVar) {
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
            this.f8749j = cVar;
            this.f8744e = fVar;
            this.f8745f = str;
            this.f8746g = bVar;
            this.f8747h = str2;
            this.f8748i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = c.a.n0.a.u.c.d.f8453c;
                SwanAppActivity activity = this.f8744e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a.d f2 = c.a.n0.a.h0.t.a.f(activity);
                    String c2 = f2.f6163a.c();
                    if (c.a.n0.a.u.c.d.f8453c) {
                        String str = "webview id: " + c2;
                    }
                    e i2 = e.i();
                    if (i2 == null) {
                        if (!c.a.n0.a.u.c.d.f8453c) {
                            this.f8749j.d(this.f8745f, new c.a.n0.a.u.h.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    this.f8744e.u();
                    c.a.n0.a.c2.f.p0.g.g(i2, this.f8746g, c2, new C0400a(this, i2, c2, f2), this.f8747h);
                } else if (!c.a.n0.a.u.c.d.f8453c) {
                    this.f8749j.d(this.f8745f, new c.a.n0.a.u.h.b(1001, "swan activity is null"));
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
        public final /* synthetic */ a.d f8754a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8755b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.l1.b f8756c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.g.g f8757d;

        public b(c cVar, a.d dVar, String str, c.a.n0.a.l1.b bVar, c.a.n0.a.h0.g.g gVar) {
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
            this.f8754a = dVar;
            this.f8755b = str;
            this.f8756c = bVar;
            this.f8757d = gVar;
        }

        @Override // c.a.n0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = c.a.n0.a.u.c.d.f8453c;
                i.e(this.f8754a, this.f8755b);
                c.a.n0.a.c2.f.p0.a.e(this.f8754a.f6163a, this.f8756c, this.f8755b);
                c.u(this.f8757d, this.f8756c, this.f8755b, false);
                boolean z2 = c.a.n0.a.u.c.d.f8453c;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.n0.a.u.c.b bVar) {
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
                super((c.a.n0.a.u.c.b) newInitContext.callArgs[0]);
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

    public static void u(c.a.n0.a.h0.g.g gVar, c.a.n0.a.l1.b bVar, String str, boolean z) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{gVar, bVar, str, Boolean.valueOf(z)}) == null) || t() || (x = c.a.n0.a.a2.d.g().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        i.c(z ? 8 : 2, str);
        c.a.n0.a.h0.g.f.C3(q0.n());
        g.b i2 = gVar.i("redirectTo");
        i2.n(0, 0);
        g.b k = i2.k("normal", bVar);
        k.m(z ? 0 : gVar.k() - 2);
        k.b();
        c.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
        i.a(str, bVar);
    }

    public final void v(a.d dVar, c.a.n0.a.l1.b bVar, c.a.n0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f6164b;
            HybridUbcFlow q = c.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (c.a.n0.a.u.c.d.f8453c) {
                String str2 = "tryToExecutePageRoute start. isReady : " + z;
            }
            c.a.n0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            boolean z2 = c.a.n0.a.u.c.d.f8453c;
        }
    }

    public c.a.n0.a.u.h.b w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (c.a.n0.a.u.c.d.f8453c) {
                String str2 = "handle: " + str;
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<c.a.n0.a.u.h.b, JSONObject> b2 = c.a.n0.a.u.i.b.b("Api-RedirectTo", str);
            c.a.n0.a.u.h.b bVar = (c.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-RedirectTo", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String p = c.a.n0.a.c2.f.p0.a.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                c.a.n0.a.e0.d.b("Api-RedirectTo", "url is null");
                return new c.a.n0.a.u.h.b(202, "url is null");
            }
            f V = f.V();
            c.a.n0.a.h0.g.g W = V.W();
            if (W == null) {
                c.a.n0.a.e0.d.b("Api-RedirectTo", "manager is null");
                return new c.a.n0.a.u.h.b(1001, "manager is null");
            }
            c.a.n0.a.l1.b g2 = c.a.n0.a.l1.b.g(p, V.A());
            c.a.n0.a.j2.h.f(g2.f6962e, "2");
            if (!q0.b(V.s(), g2, false)) {
                String str3 = "page params error : path=" + g2.f6962e + " ; routePath=" + g2.f6965h;
                c.a.n0.a.e0.d.b("Api-RedirectTo", str3);
                return new c.a.n0.a.u.h.b(202, str3);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && g2 != null && !TextUtils.isEmpty(g2.f6965h) && e.i() != null) {
                e.i().x0(optString, g2.f6965h);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = c.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.C(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                c.a.n0.a.e0.d.b("Api-RedirectTo", "cb is null");
                return new c.a.n0.a.u.h.b(202, "cb is null");
            } else if (c.a.n0.a.c2.f.g0.d.b().a(g2)) {
                c.a.n0.a.c2.f.g0.d.b().i("redirectTo", g2);
                c.a.n0.a.e0.d.b("Api-RedirectTo", "access to this page is prohibited");
                return new c.a.n0.a.u.h.b(1003, "access to this page is prohibited");
            } else {
                q0.X(new a(this, V, optString3, g2, uuid, W));
                return new c.a.n0.a.u.h.b(0);
            }
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }
}
