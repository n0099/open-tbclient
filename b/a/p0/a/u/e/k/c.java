package b.a.p0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8282e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8283f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l1.b f8284g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8285h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8286i;
        public final /* synthetic */ c j;

        /* renamed from: b.a.p0.a.u.e.k.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0405a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f8287a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f8288b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f8289c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f8290d;

            public C0405a(a aVar, e eVar, String str, a.d dVar) {
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
                this.f8290d = aVar;
                this.f8287a = eVar;
                this.f8288b = str;
                this.f8289c = dVar;
            }

            @Override // b.a.p0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f8290d.f8285h);
                    b.a.p0.a.e0.d.g("Api-RedirectTo", "check pages success");
                    this.f8290d.f8282e.n();
                    a aVar = this.f8290d;
                    b.a.p0.a.c2.f.p0.a.m(aVar.j, this.f8287a, this.f8288b, aVar.f8284g.f6555e, null, aVar.f8283f);
                    a aVar2 = this.f8290d;
                    aVar2.j.u(this.f8289c, aVar2.f8284g, aVar2.f8286i, aVar2.f8285h);
                }
            }

            @Override // b.a.p0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    b.a.p0.a.e0.d.b("Api-RedirectTo", "check pages failed");
                    this.f8290d.f8282e.n();
                    if (b.a.p0.a.u.c.d.f8000c) {
                        Context context = this.f8290d.j.getContext();
                        b.a.p0.a.z1.b.f.e.g(context, context.getString(h.aiapps_open_pages_failed) + i2).F();
                    }
                    a aVar = this.f8290d;
                    b.a.p0.a.c2.f.p0.a.k(aVar.j, aVar.f8283f);
                }
            }
        }

        public a(c cVar, f fVar, String str, b.a.p0.a.l1.b bVar, String str2, b.a.p0.a.h0.g.g gVar) {
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
            this.j = cVar;
            this.f8282e = fVar;
            this.f8283f = str;
            this.f8284g = bVar;
            this.f8285h = str2;
            this.f8286i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = b.a.p0.a.u.c.d.f8000c;
                SwanAppActivity activity = this.f8282e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a.d f2 = b.a.p0.a.h0.t.a.f(activity);
                    String b2 = f2.f5778a.b();
                    if (b.a.p0.a.u.c.d.f8000c) {
                        String str = "webview id: " + b2;
                    }
                    e i2 = e.i();
                    if (i2 == null) {
                        if (!b.a.p0.a.u.c.d.f8000c) {
                            this.j.d(this.f8283f, new b.a.p0.a.u.h.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    this.f8282e.t();
                    b.a.p0.a.c2.f.p0.g.g(i2, this.f8284g, b2, new C0405a(this, i2, b2, f2), this.f8285h);
                } else if (!b.a.p0.a.u.c.d.f8000c) {
                    this.j.d(this.f8283f, new b.a.p0.a.u.h.b(1001, "swan activity is null"));
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
        public final /* synthetic */ a.d f8291a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8292b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l1.b f8293c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f8294d;

        public b(c cVar, a.d dVar, String str, b.a.p0.a.l1.b bVar, b.a.p0.a.h0.g.g gVar) {
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
            this.f8291a = dVar;
            this.f8292b = str;
            this.f8293c = bVar;
            this.f8294d = gVar;
        }

        @Override // b.a.p0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = b.a.p0.a.u.c.d.f8000c;
                i.e(this.f8291a, this.f8292b);
                b.a.p0.a.c2.f.p0.a.e(this.f8291a.f5778a, this.f8293c, this.f8292b);
                c.t(this.f8294d, this.f8293c, this.f8292b, false);
                boolean z2 = b.a.p0.a.u.c.d.f8000c;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public static boolean s() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            e P = e.P();
            return P == null || (x = P.x()) == null || x.isFinishing() || x.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public static void t(b.a.p0.a.h0.g.g gVar, b.a.p0.a.l1.b bVar, String str, boolean z) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{gVar, bVar, str, Boolean.valueOf(z)}) == null) || s() || (x = b.a.p0.a.a2.d.g().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        i.c(z ? 8 : 2, str);
        b.a.p0.a.h0.g.f.y3(q0.n());
        g.b i2 = gVar.i("redirectTo");
        i2.n(0, 0);
        g.b k = i2.k("normal", bVar);
        k.m(z ? 0 : gVar.k() - 2);
        k.b();
        b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
        i.a(str, bVar);
    }

    public final void u(a.d dVar, b.a.p0.a.l1.b bVar, b.a.p0.a.h0.g.g gVar, String str) {
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

    public b.a.p0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (b.a.p0.a.u.c.d.f8000c) {
                String str2 = "handle: " + str;
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-RedirectTo", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-RedirectTo", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String p = b.a.p0.a.c2.f.p0.a.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                b.a.p0.a.e0.d.b("Api-RedirectTo", "url is null");
                return new b.a.p0.a.u.h.b(202, "url is null");
            }
            f T = f.T();
            b.a.p0.a.h0.g.g U = T.U();
            if (U == null) {
                b.a.p0.a.e0.d.b("Api-RedirectTo", "manager is null");
                return new b.a.p0.a.u.h.b(1001, "manager is null");
            }
            b.a.p0.a.l1.b e2 = b.a.p0.a.l1.b.e(p, T.z());
            b.a.p0.a.j2.h.f(e2.f6555e, "2");
            if (!q0.b(T.r(), e2, false)) {
                String str3 = "page params error : path=" + e2.f6555e + " ; routePath=" + e2.f6558h;
                b.a.p0.a.e0.d.b("Api-RedirectTo", str3);
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
                b.a.p0.a.e0.d.b("Api-RedirectTo", "cb is null");
                return new b.a.p0.a.u.h.b(202, "cb is null");
            } else if (b.a.p0.a.c2.f.g0.d.b().a(e2)) {
                b.a.p0.a.c2.f.g0.d.b().i("redirectTo", e2);
                b.a.p0.a.e0.d.b("Api-RedirectTo", "access to this page is prohibited");
                return new b.a.p0.a.u.h.b(1003, "access to this page is prohibited");
            } else {
                q0.X(new a(this, T, optString3, e2, uuid, U));
                return new b.a.p0.a.u.h.b(0);
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
