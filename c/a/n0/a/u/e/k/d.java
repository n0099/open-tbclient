package c.a.n0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
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
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8758e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8759f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.l1.b f8760g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8761h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8762i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f8763j;

        /* renamed from: c.a.n0.a.u.e.k.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0401a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f8764a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f8765b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f8766c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f8767d;

            public C0401a(a aVar, e eVar, String str, a.d dVar) {
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
                this.f8767d = aVar;
                this.f8764a = eVar;
                this.f8765b = str;
                this.f8766c = dVar;
            }

            @Override // c.a.n0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f8767d.f8761h);
                    c.a.n0.a.e0.d.g("Api-ReLaunch", "check pages success");
                    this.f8767d.f8758e.o();
                    a aVar = this.f8767d;
                    c.a.n0.a.c2.f.p0.a.m(aVar.f8763j, this.f8764a, this.f8765b, aVar.f8760g.f6962e, null, aVar.f8759f);
                    c.a.n0.a.j2.e.t(this.f8765b);
                    a aVar2 = this.f8767d;
                    aVar2.f8763j.u(this.f8766c, aVar2.f8760g, aVar2.f8762i, aVar2.f8761h);
                }
            }

            @Override // c.a.n0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    c.a.n0.a.e0.d.b("Api-ReLaunch", "check pages failed");
                    this.f8767d.f8758e.o();
                    if (c.a.n0.a.u.c.d.f8453c) {
                        Context i3 = this.f8767d.f8763j.i();
                        c.a.n0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                    }
                    a aVar = this.f8767d;
                    c.a.n0.a.c2.f.p0.a.k(aVar.f8763j, aVar.f8759f);
                }
            }
        }

        public a(d dVar, f fVar, String str, c.a.n0.a.l1.b bVar, String str2, c.a.n0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, fVar, str, bVar, str2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8763j = dVar;
            this.f8758e = fVar;
            this.f8759f = str;
            this.f8760g = bVar;
            this.f8761h = str2;
            this.f8762i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f8758e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a.d g2 = c.a.n0.a.h0.t.a.g(activity, true);
                    String c2 = g2.f6163a.c();
                    if (c.a.n0.a.u.c.d.f8453c) {
                        String str = "webview idx: " + c2;
                    }
                    e i2 = e.i();
                    if (i2 == null) {
                        if (!c.a.n0.a.u.c.d.f8453c) {
                            this.f8763j.d(this.f8759f, new c.a.n0.a.u.h.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    this.f8758e.u();
                    c.a.n0.a.c2.f.p0.g.g(i2, this.f8760g, c2, new C0401a(this, i2, c2, g2), this.f8761h);
                } else if (!c.a.n0.a.u.c.d.f8453c) {
                    this.f8763j.d(this.f8759f, new c.a.n0.a.u.h.b(1001, "swan activity is null"));
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
        public final /* synthetic */ a.d f8768a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8769b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.l1.b f8770c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.g.g f8771d;

        public b(d dVar, a.d dVar2, String str, c.a.n0.a.l1.b bVar, c.a.n0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, dVar2, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8768a = dVar2;
            this.f8769b = str;
            this.f8770c = bVar;
            this.f8771d = gVar;
        }

        @Override // c.a.n0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = c.a.n0.a.u.c.d.f8453c;
                i.e(this.f8768a, this.f8769b);
                c.a.n0.a.c2.f.p0.a.e(this.f8768a.f6163a, this.f8770c, this.f8769b);
                d.t(this.f8771d, this.f8770c, this.f8769b);
                boolean z2 = c.a.n0.a.u.c.d.f8453c;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.n0.a.h0.g.g.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // c.a.n0.a.h0.g.g.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof c.a.n0.a.h0.g.f)) {
                ((c.a.n0.a.h0.g.f) fragment).P0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull c.a.n0.a.u.c.b bVar) {
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

    public static void t(c.a.n0.a.h0.g.g gVar, c.a.n0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, gVar, bVar, str) == null) {
            if (bVar != null) {
                c.a.n0.a.e0.d.g("Api-ReLaunch", "doReLaunch page=" + bVar.f6962e + " routePage=" + bVar.f6965h);
            }
            SwanAppActivity x = c.a.n0.a.a2.d.g().x();
            if (x == null || x.isFinishing() || x.isDestroyed()) {
                return;
            }
            c cVar = new c();
            i.c(3, str);
            c.a.n0.a.h0.g.f.C3(q0.n());
            gVar.g(cVar);
            g.b i2 = gVar.i("reLaunch");
            i2.n(0, 0);
            i2.f();
            i2.k("normal", bVar).b();
            gVar.p(cVar);
            c.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            i.a(str, bVar);
        }
    }

    public final void u(a.d dVar, c.a.n0.a.l1.b bVar, c.a.n0.a.h0.g.g gVar, String str) {
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

    public c.a.n0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (c.a.n0.a.u.c.d.f8453c) {
                String str2 = "handle: " + str;
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<c.a.n0.a.u.h.b, JSONObject> b2 = c.a.n0.a.u.i.b.b("Api-ReLaunch", str);
            c.a.n0.a.u.h.b bVar = (c.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-ReLaunch", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String p = c.a.n0.a.c2.f.p0.a.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                c.a.n0.a.e0.d.b("Api-ReLaunch", "url is null");
                return new c.a.n0.a.u.h.b(202, "url is null");
            }
            f V = f.V();
            c.a.n0.a.h0.g.g W = V.W();
            if (W == null) {
                c.a.n0.a.e0.d.b("Api-ReLaunch", "manager is null");
                return new c.a.n0.a.u.h.b(1001, "manager is null");
            }
            c.a.n0.a.l1.b g2 = c.a.n0.a.l1.b.g(p, V.A());
            c.a.n0.a.j2.h.f(g2.f6962e, "3");
            if (!q0.b(V.s(), g2, true)) {
                String str3 = "page params error : path=" + g2.f6962e + " ; routePath=" + g2.f6965h;
                c.a.n0.a.e0.d.b("Api-ReLaunch", str3);
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
                c.a.n0.a.e0.d.b("Api-ReLaunch", "cb is null");
                return new c.a.n0.a.u.h.b(202, "cb is null");
            } else if (c.a.n0.a.c2.f.g0.d.b().a(g2)) {
                c.a.n0.a.c2.f.g0.d.b().i("reLaunch", g2);
                c.a.n0.a.e0.d.b("Api-ReLaunch", "access to this page is prohibited");
                return new c.a.n0.a.u.h.b(1003, "access to this page is prohibited");
            } else {
                q0.X(new a(this, V, optString3, g2, uuid, W));
                return new c.a.n0.a.u.h.b(0);
            }
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }
}
