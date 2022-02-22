package c.a.s0.a.u.e.j;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.f2.f.o0.g;
import c.a.s0.a.h0.g.g;
import c.a.s0.a.h0.t.a;
import c.a.s0.a.u1.h;
import c.a.s0.a.u1.i;
import c.a.s0.a.z2.q0;
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
public class d extends c.a.s0.a.u.e.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.g1.f f9408e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9409f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.m1.b f9410g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9411h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f9412i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f9413j;

        /* renamed from: c.a.s0.a.u.e.j.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0601a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.s0.a.d2.e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f9414b;

            public C0601a(a aVar, c.a.s0.a.d2.e eVar) {
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
                this.f9414b = aVar;
                this.a = eVar;
            }

            @Override // c.a.s0.a.f2.f.o0.g.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f9414b.f9411h);
                    c.a.s0.a.e0.d.i("RedirectToApi", "check pages success");
                    this.f9414b.f9408e.o();
                    a.e f2 = c.a.s0.a.h0.t.a.f(this.f9414b.f9408e.getActivity(), c.a.s0.a.h0.t.f.a.c(this.f9414b.f9410g.f7914e));
                    String c2 = f2.a.c();
                    a aVar = this.f9414b;
                    c.a.s0.a.f2.f.o0.a.m(aVar.f9413j, this.a, c2, aVar.f9410g.f7914e, null, aVar.f9409f);
                    a aVar2 = this.f9414b;
                    aVar2.f9413j.C(f2, aVar2.f9410g, aVar2.f9412i, aVar2.f9411h);
                }
            }

            @Override // c.a.s0.a.f2.f.o0.g.e
            public void c(int i2, c.a.s0.a.u2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    c.a.s0.a.e0.d.c("RedirectToApi", "check pages failed");
                    this.f9414b.f9408e.o();
                    a aVar2 = this.f9414b;
                    c.a.s0.a.f2.f.o0.a.k(aVar2.f9413j, aVar2.f9409f);
                    c.a.s0.a.n2.i.j(this.f9414b.f9410g, aVar);
                }
            }
        }

        public a(d dVar, c.a.s0.a.g1.f fVar, String str, c.a.s0.a.m1.b bVar, String str2, c.a.s0.a.h0.g.g gVar) {
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
            this.f9413j = dVar;
            this.f9408e = fVar;
            this.f9409f = str;
            this.f9410g = bVar;
            this.f9411h = str2;
            this.f9412i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f9408e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    c.a.s0.a.d2.e L = c.a.s0.a.d2.e.L();
                    if (L == null) {
                        this.f9413j.d(this.f9409f, new c.a.s0.a.u.h.b(1001, "swan app is null"));
                        c.a.s0.a.n2.i.i(this.f9410g);
                        return;
                    }
                    this.f9408e.a();
                    c.a.s0.a.f2.f.o0.g.g(L, this.f9410g, "", new C0601a(this, L), this.f9411h);
                    return;
                }
                this.f9413j.d(this.f9409f, new c.a.s0.a.u.h.b(1001, "swan activity is null"));
                c.a.s0.a.n2.i.i(this.f9410g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.e f9415e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.m1.b f9416f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.g.g f9417g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9418h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f9419i;

        public b(d dVar, a.e eVar, c.a.s0.a.m1.b bVar, c.a.s0.a.h0.g.g gVar, String str) {
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
            this.f9419i = dVar;
            this.f9415e = eVar;
            this.f9416f = bVar;
            this.f9417g = gVar;
            this.f9418h = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9419i.B(this.f9415e, this.f9416f, this.f9417g, this.f9418h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9420b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.m1.b f9421c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.g.g f9422d;

        public c(d dVar, a.e eVar, String str, c.a.s0.a.m1.b bVar, c.a.s0.a.h0.g.g gVar) {
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
            this.f9420b = str;
            this.f9421c = bVar;
            this.f9422d = gVar;
        }

        @Override // c.a.s0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.e(this.a, this.f9420b);
                c.a.s0.a.f2.f.o0.a.e(this.a.a, this.f9421c, this.f9420b);
                d.A(this.f9422d, this.f9421c, this.f9420b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull c.a.s0.a.u.c.b bVar) {
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
                super((c.a.s0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(c.a.s0.a.h0.g.g gVar, c.a.s0.a.m1.b bVar, String str, boolean z) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{gVar, bVar, str, Boolean.valueOf(z)}) == null) || z() || (x = c.a.s0.a.d2.d.J().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        i.c(z ? 8 : 2, str);
        c.a.s0.a.h0.g.f.M3(q0.n());
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
            c.a.s0.a.d2.e a0 = c.a.s0.a.d2.e.a0();
            return a0 == null || (x = a0.x()) == null || x.isFinishing() || x.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public final void B(a.e eVar, c.a.s0.a.m1.b bVar, c.a.s0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f7126b;
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            c.a.s0.a.h0.t.a.q(eVar, new c(this, eVar, str, bVar, gVar));
        }
    }

    public final void C(a.e eVar, c.a.s0.a.m1.b bVar, c.a.s0.a.h0.g.g gVar, String str) {
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
    public c.a.s0.a.u.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<c.a.s0.a.u.h.b, JSONObject> s = s(str);
            c.a.s0.a.u.h.b bVar = (c.a.s0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = c.a.s0.a.f2.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    c.a.s0.a.e0.d.c("RedirectToApi", "url is null");
                    return new c.a.s0.a.u.h.b(202, "url is null");
                }
                c.a.s0.a.g1.f U = c.a.s0.a.g1.f.U();
                c.a.s0.a.h0.g.g V = U.V();
                if (V == null) {
                    c.a.s0.a.e0.d.c("RedirectToApi", "manager is null");
                    return new c.a.s0.a.u.h.b(1001, "manager is null");
                }
                c.a.s0.a.m1.b e2 = c.a.s0.a.m1.b.e(p, U.z());
                e2.f7918i = "2";
                e2.f7919j = uuid;
                c.a.s0.a.n2.i.g(e2);
                if (!q0.b(U.s(), e2, false)) {
                    String str2 = "page params error : path=" + e2.f7914e + " ; routePath=" + e2.f7917h;
                    c.a.s0.a.e0.d.c("RedirectToApi", str2);
                    c.a.s0.a.n2.i.i(e2);
                    return new c.a.s0.a.u.h.b(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(e2.f7917h) && c.a.s0.a.d2.e.L() != null) {
                    c.a.s0.a.d2.e.L().K0(optString, e2.f7917h);
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
                    c.a.s0.a.e0.d.c("RedirectToApi", "cb is empty");
                    c.a.s0.a.n2.i.i(e2);
                    return new c.a.s0.a.u.h.b(202, "cb is empty");
                } else if (c.a.s0.a.f2.f.f0.d.b().a(e2)) {
                    c.a.s0.a.f2.f.f0.d.b().i("redirectTo", e2);
                    c.a.s0.a.e0.d.c("RedirectToApi", "access to this page is prohibited");
                    return new c.a.s0.a.u.h.b(1003, "access to this page is prohibited");
                } else {
                    q0.a0(new a(this, U, optString3, e2, uuid, V));
                    return c.a.s0.a.u.h.b.f();
                }
            }
            return bVar;
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.s0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }
}
