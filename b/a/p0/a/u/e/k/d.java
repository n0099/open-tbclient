package b.a.p0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
import b.a.p0.a.c2.f.p0.g;
import b.a.p0.a.g1.f;
import b.a.p0.a.h;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.h0.t.a;
import b.a.p0.a.r1.i;
import b.a.p0.a.v2.q0;
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
public class d extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8295e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8296f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l1.b f8297g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8298h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8299i;
        public final /* synthetic */ d j;

        /* renamed from: b.a.p0.a.u.e.k.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0406a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f8300a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f8301b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f8302c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f8303d;

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
                this.f8303d = aVar;
                this.f8300a = eVar;
                this.f8301b = str;
                this.f8302c = dVar;
            }

            @Override // b.a.p0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f8303d.f8298h);
                    b.a.p0.a.e0.d.g("Api-ReLaunch", "check pages success");
                    this.f8303d.f8295e.n();
                    a aVar = this.f8303d;
                    b.a.p0.a.c2.f.p0.a.m(aVar.j, this.f8300a, this.f8301b, aVar.f8297g.f6555e, null, aVar.f8296f);
                    b.a.p0.a.j2.e.t(this.f8301b);
                    a aVar2 = this.f8303d;
                    aVar2.j.t(this.f8302c, aVar2.f8297g, aVar2.f8299i, aVar2.f8298h);
                }
            }

            @Override // b.a.p0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    b.a.p0.a.e0.d.b("Api-ReLaunch", "check pages failed");
                    this.f8303d.f8295e.n();
                    if (b.a.p0.a.u.c.d.f8000c) {
                        Context context = this.f8303d.j.getContext();
                        b.a.p0.a.z1.b.f.e.g(context, context.getString(h.aiapps_open_pages_failed) + i2).F();
                    }
                    a aVar = this.f8303d;
                    b.a.p0.a.c2.f.p0.a.k(aVar.j, aVar.f8296f);
                }
            }
        }

        public a(d dVar, f fVar, String str, b.a.p0.a.l1.b bVar, String str2, b.a.p0.a.h0.g.g gVar) {
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
            this.j = dVar;
            this.f8295e = fVar;
            this.f8296f = str;
            this.f8297g = bVar;
            this.f8298h = str2;
            this.f8299i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f8295e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a.d g2 = b.a.p0.a.h0.t.a.g(activity, true);
                    String b2 = g2.f5778a.b();
                    if (b.a.p0.a.u.c.d.f8000c) {
                        String str = "webview idx: " + b2;
                    }
                    e i2 = e.i();
                    if (i2 == null) {
                        if (!b.a.p0.a.u.c.d.f8000c) {
                            this.j.d(this.f8296f, new b.a.p0.a.u.h.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    this.f8295e.t();
                    b.a.p0.a.c2.f.p0.g.g(i2, this.f8297g, b2, new C0406a(this, i2, b2, g2), this.f8298h);
                } else if (!b.a.p0.a.u.c.d.f8000c) {
                    this.j.d(this.f8296f, new b.a.p0.a.u.h.b(1001, "swan activity is null"));
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
        public final /* synthetic */ a.d f8304a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8305b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l1.b f8306c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f8307d;

        public b(d dVar, a.d dVar2, String str, b.a.p0.a.l1.b bVar, b.a.p0.a.h0.g.g gVar) {
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
            this.f8304a = dVar2;
            this.f8305b = str;
            this.f8306c = bVar;
            this.f8307d = gVar;
        }

        @Override // b.a.p0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = b.a.p0.a.u.c.d.f8000c;
                i.e(this.f8304a, this.f8305b);
                b.a.p0.a.c2.f.p0.a.e(this.f8304a.f5778a, this.f8306c, this.f8305b);
                d.s(this.f8307d, this.f8306c, this.f8305b);
                boolean z2 = b.a.p0.a.u.c.d.f8000c;
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

        @Override // b.a.p0.a.h0.g.g.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // b.a.p0.a.h0.g.g.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof b.a.p0.a.h0.g.f)) {
                ((b.a.p0.a.h0.g.f) fragment).P0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void s(b.a.p0.a.h0.g.g gVar, b.a.p0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, gVar, bVar, str) == null) {
            if (bVar != null) {
                b.a.p0.a.e0.d.g("Api-ReLaunch", "doReLaunch page=" + bVar.f6555e + " routePage=" + bVar.f6558h);
            }
            SwanAppActivity x = b.a.p0.a.a2.d.g().x();
            if (x == null || x.isFinishing() || x.isDestroyed()) {
                return;
            }
            c cVar = new c();
            i.c(3, str);
            b.a.p0.a.h0.g.f.y3(q0.n());
            gVar.g(cVar);
            g.b i2 = gVar.i("reLaunch");
            i2.n(0, 0);
            i2.f();
            i2.k("normal", bVar).b();
            gVar.p(cVar);
            b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            i.a(str, bVar);
        }
    }

    public final void t(a.d dVar, b.a.p0.a.l1.b bVar, b.a.p0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f5779b;
            HybridUbcFlow q = b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (b.a.p0.a.u.c.d.f8000c) {
                String str2 = "tryToExecutePageRoute start. isReady : " + z;
            }
            b.a.p0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            boolean z2 = b.a.p0.a.u.c.d.f8000c;
        }
    }

    public b.a.p0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (b.a.p0.a.u.c.d.f8000c) {
                String str2 = "handle: " + str;
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-ReLaunch", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-ReLaunch", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String p = b.a.p0.a.c2.f.p0.a.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                b.a.p0.a.e0.d.b("Api-ReLaunch", "url is null");
                return new b.a.p0.a.u.h.b(202, "url is null");
            }
            f T = f.T();
            b.a.p0.a.h0.g.g U = T.U();
            if (U == null) {
                b.a.p0.a.e0.d.b("Api-ReLaunch", "manager is null");
                return new b.a.p0.a.u.h.b(1001, "manager is null");
            }
            b.a.p0.a.l1.b e2 = b.a.p0.a.l1.b.e(p, T.z());
            b.a.p0.a.j2.h.f(e2.f6555e, "3");
            if (!q0.b(T.r(), e2, true)) {
                String str3 = "page params error : path=" + e2.f6555e + " ; routePath=" + e2.f6558h;
                b.a.p0.a.e0.d.b("Api-ReLaunch", str3);
                return new b.a.p0.a.u.h.b(202, str3);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && e2 != null && !TextUtils.isEmpty(e2.f6558h) && e.i() != null) {
                e.i().w0(optString, e2.f6558h);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.C(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                b.a.p0.a.e0.d.b("Api-ReLaunch", "cb is null");
                return new b.a.p0.a.u.h.b(202, "cb is null");
            } else if (b.a.p0.a.c2.f.g0.d.b().a(e2)) {
                b.a.p0.a.c2.f.g0.d.b().i("reLaunch", e2);
                b.a.p0.a.e0.d.b("Api-ReLaunch", "access to this page is prohibited");
                return new b.a.p0.a.u.h.b(1003, "access to this page is prohibited");
            } else {
                q0.X(new a(this, T, optString3, e2, uuid, U));
                return new b.a.p0.a.u.h.b(0);
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
