package c.a.r0.a.u.e.j;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f2.f.o0.g;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.h0.t.a;
import c.a.r0.a.u1.h;
import c.a.r0.a.u1.i;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
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
public class d extends c.a.r0.a.u.e.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.g1.f f9308e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9309f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.m1.b f9310g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9311h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f9312i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f9313j;

        /* renamed from: c.a.r0.a.u.e.j.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0590a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.r0.a.d2.e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f9314b;

            public C0590a(a aVar, c.a.r0.a.d2.e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9314b = aVar;
                this.a = eVar;
            }

            @Override // c.a.r0.a.f2.f.o0.g.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f9314b.f9311h);
                    c.a.r0.a.e0.d.i("RedirectToApi", "check pages success");
                    this.f9314b.f9308e.o();
                    a.e f2 = c.a.r0.a.h0.t.a.f(this.f9314b.f9308e.getActivity(), c.a.r0.a.h0.t.f.a.c(this.f9314b.f9310g.f7814e));
                    String c2 = f2.a.c();
                    a aVar = this.f9314b;
                    c.a.r0.a.f2.f.o0.a.m(aVar.f9313j, this.a, c2, aVar.f9310g.f7814e, null, aVar.f9309f);
                    a aVar2 = this.f9314b;
                    aVar2.f9313j.C(f2, aVar2.f9310g, aVar2.f9312i, aVar2.f9311h);
                }
            }

            @Override // c.a.r0.a.f2.f.o0.g.e
            public void b(int i2, c.a.r0.a.u2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    c.a.r0.a.e0.d.c("RedirectToApi", "check pages failed");
                    this.f9314b.f9308e.o();
                    a aVar2 = this.f9314b;
                    c.a.r0.a.f2.f.o0.a.k(aVar2.f9313j, aVar2.f9309f);
                    c.a.r0.a.n2.i.j(this.f9314b.f9310g, aVar);
                }
            }
        }

        public a(d dVar, c.a.r0.a.g1.f fVar, String str, c.a.r0.a.m1.b bVar, String str2, c.a.r0.a.h0.g.g gVar) {
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
            this.f9313j = dVar;
            this.f9308e = fVar;
            this.f9309f = str;
            this.f9310g = bVar;
            this.f9311h = str2;
            this.f9312i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f9308e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
                    if (L == null) {
                        this.f9313j.d(this.f9309f, new c.a.r0.a.u.h.b(1001, "swan app is null"));
                        c.a.r0.a.n2.i.i(this.f9310g);
                        return;
                    }
                    this.f9308e.a();
                    c.a.r0.a.f2.f.o0.g.g(L, this.f9310g, "", new C0590a(this, L), this.f9311h);
                    return;
                }
                this.f9313j.d(this.f9309f, new c.a.r0.a.u.h.b(1001, "swan activity is null"));
                c.a.r0.a.n2.i.i(this.f9310g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.e f9315e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.m1.b f9316f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.g.g f9317g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9318h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f9319i;

        public b(d dVar, a.e eVar, c.a.r0.a.m1.b bVar, c.a.r0.a.h0.g.g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, eVar, bVar, gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9319i = dVar;
            this.f9315e = eVar;
            this.f9316f = bVar;
            this.f9317g = gVar;
            this.f9318h = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9319i.B(this.f9315e, this.f9316f, this.f9317g, this.f9318h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9320b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.m1.b f9321c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.g.g f9322d;

        public c(d dVar, a.e eVar, String str, c.a.r0.a.m1.b bVar, c.a.r0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, eVar, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.f9320b = str;
            this.f9321c = bVar;
            this.f9322d = gVar;
        }

        @Override // c.a.r0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.e(this.a, this.f9320b);
                c.a.r0.a.f2.f.o0.a.e(this.a.a, this.f9321c, this.f9320b);
                d.A(this.f9322d, this.f9321c, this.f9320b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull c.a.r0.a.u.c.b bVar) {
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
                super((c.a.r0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(c.a.r0.a.h0.g.g gVar, c.a.r0.a.m1.b bVar, String str, boolean z) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{gVar, bVar, str, Boolean.valueOf(z)}) == null) || z() || (x = c.a.r0.a.d2.d.J().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        i.c(z ? 8 : 2, str);
        c.a.r0.a.h0.g.f.M3(q0.n());
        g.b i2 = gVar.i("redirectTo");
        i2.n(0, 0);
        g.b k = i2.k("normal", bVar);
        k.m(z ? 0 : gVar.k() - 2);
        k.b();
        h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
        i.a(str, bVar);
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            return a0 == null || (x = a0.x()) == null || x.isFinishing() || x.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public final void B(a.e eVar, c.a.r0.a.m1.b bVar, c.a.r0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f7026b;
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            c.a.r0.a.h0.t.a.q(eVar, new c(this, eVar, str, bVar, gVar));
        }
    }

    public final void C(a.e eVar, c.a.r0.a.m1.b bVar, c.a.r0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, bVar, gVar, str) == null) {
            if (q0.O()) {
                B(eVar, bVar, gVar, str);
            } else {
                q0.a0(new b(this, eVar, bVar, gVar, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public c.a.r0.a.u.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = c.a.r0.a.f2.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    c.a.r0.a.e0.d.c("RedirectToApi", "url is null");
                    return new c.a.r0.a.u.h.b(202, "url is null");
                }
                c.a.r0.a.g1.f U = c.a.r0.a.g1.f.U();
                c.a.r0.a.h0.g.g V = U.V();
                if (V == null) {
                    c.a.r0.a.e0.d.c("RedirectToApi", "manager is null");
                    return new c.a.r0.a.u.h.b(1001, "manager is null");
                }
                c.a.r0.a.m1.b e2 = c.a.r0.a.m1.b.e(p, U.z());
                e2.f7818i = "2";
                e2.f7819j = uuid;
                c.a.r0.a.n2.i.g(e2);
                if (!q0.b(U.s(), e2, false)) {
                    String str2 = "page params error : path=" + e2.f7814e + " ; routePath=" + e2.f7817h;
                    c.a.r0.a.e0.d.c("RedirectToApi", str2);
                    c.a.r0.a.n2.i.i(e2);
                    return new c.a.r0.a.u.h.b(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(e2.f7817h) && c.a.r0.a.d2.e.L() != null) {
                    c.a.r0.a.d2.e.L().K0(optString, e2.f7817h);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    c.a.r0.a.e0.d.c("RedirectToApi", "cb is empty");
                    c.a.r0.a.n2.i.i(e2);
                    return new c.a.r0.a.u.h.b(202, "cb is empty");
                } else if (c.a.r0.a.f2.f.f0.d.b().a(e2)) {
                    c.a.r0.a.f2.f.f0.d.b().i("redirectTo", e2);
                    c.a.r0.a.e0.d.c("RedirectToApi", "access to this page is prohibited");
                    return new c.a.r0.a.u.h.b(1003, "access to this page is prohibited");
                } else {
                    q0.a0(new a(this, U, optString3, e2, uuid, V));
                    return c.a.r0.a.u.h.b.f();
                }
            }
            return bVar;
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.r0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }
}
