package b.a.p0.a.u.e.j;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f2.f.o0.g;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.h0.t.a;
import b.a.p0.a.u1.h;
import b.a.p0.a.u1.i;
import b.a.p0.a.z2.q0;
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
public class d extends b.a.p0.a.u.e.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.g1.f f8773e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8774f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f8775g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8776h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8777i;
        public final /* synthetic */ d j;

        /* renamed from: b.a.p0.a.u.e.j.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0432a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.d2.e f8778a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f8779b;

            public C0432a(a aVar, b.a.p0.a.d2.e eVar) {
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
                this.f8779b = aVar;
                this.f8778a = eVar;
            }

            @Override // b.a.p0.a.f2.f.o0.g.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f8779b.f8776h);
                    b.a.p0.a.e0.d.i("RedirectToApi", "check pages success");
                    this.f8779b.f8773e.n();
                    a.e f2 = b.a.p0.a.h0.t.a.f(this.f8779b.f8773e.getActivity(), b.a.p0.a.h0.t.f.a.c(this.f8779b.f8775g.f7014e));
                    String c2 = f2.f6108a.c();
                    a aVar = this.f8779b;
                    b.a.p0.a.f2.f.o0.a.m(aVar.j, this.f8778a, c2, aVar.f8775g.f7014e, null, aVar.f8774f);
                    a aVar2 = this.f8779b;
                    aVar2.j.C(f2, aVar2.f8775g, aVar2.f8777i, aVar2.f8776h);
                }
            }

            @Override // b.a.p0.a.f2.f.o0.g.e
            public void b(int i2, b.a.p0.a.u2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    b.a.p0.a.e0.d.c("RedirectToApi", "check pages failed");
                    this.f8779b.f8773e.n();
                    a aVar2 = this.f8779b;
                    b.a.p0.a.f2.f.o0.a.k(aVar2.j, aVar2.f8774f);
                    b.a.p0.a.n2.i.j(this.f8779b.f8775g, aVar);
                }
            }
        }

        public a(d dVar, b.a.p0.a.g1.f fVar, String str, b.a.p0.a.m1.b bVar, String str2, b.a.p0.a.h0.g.g gVar) {
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
            this.f8773e = fVar;
            this.f8774f = str;
            this.f8775g = bVar;
            this.f8776h = str2;
            this.f8777i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f8773e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
                    if (L == null) {
                        this.j.d(this.f8774f, new b.a.p0.a.u.h.b(1001, "swan app is null"));
                        b.a.p0.a.n2.i.i(this.f8775g);
                        return;
                    }
                    this.f8773e.t();
                    b.a.p0.a.f2.f.o0.g.g(L, this.f8775g, "", new C0432a(this, L), this.f8776h);
                    return;
                }
                this.j.d(this.f8774f, new b.a.p0.a.u.h.b(1001, "swan activity is null"));
                b.a.p0.a.n2.i.i(this.f8775g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.e f8780e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f8781f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f8782g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8783h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f8784i;

        public b(d dVar, a.e eVar, b.a.p0.a.m1.b bVar, b.a.p0.a.h0.g.g gVar, String str) {
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
            this.f8784i = dVar;
            this.f8780e = eVar;
            this.f8781f = bVar;
            this.f8782g = gVar;
            this.f8783h = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8784i.B(this.f8780e, this.f8781f, this.f8782g, this.f8783h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.e f8785a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8786b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f8787c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f8788d;

        public c(d dVar, a.e eVar, String str, b.a.p0.a.m1.b bVar, b.a.p0.a.h0.g.g gVar) {
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
            this.f8785a = eVar;
            this.f8786b = str;
            this.f8787c = bVar;
            this.f8788d = gVar;
        }

        @Override // b.a.p0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.e(this.f8785a, this.f8786b);
                b.a.p0.a.f2.f.o0.a.e(this.f8785a.f6108a, this.f8787c, this.f8786b);
                d.A(this.f8788d, this.f8787c, this.f8786b, false);
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

    public static void A(b.a.p0.a.h0.g.g gVar, b.a.p0.a.m1.b bVar, String str, boolean z) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{gVar, bVar, str, Boolean.valueOf(z)}) == null) || z() || (x = b.a.p0.a.d2.d.J().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        i.c(z ? 8 : 2, str);
        b.a.p0.a.h0.g.f.P3(q0.n());
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
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            return a0 == null || (x = a0.x()) == null || x.isFinishing() || x.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public final void B(a.e eVar, b.a.p0.a.m1.b bVar, b.a.p0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f6109b;
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            b.a.p0.a.h0.t.a.q(eVar, new c(this, eVar, str, bVar, gVar));
        }
    }

    public final void C(a.e eVar, b.a.p0.a.m1.b bVar, b.a.p0.a.h0.g.g gVar, String str) {
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
    public b.a.p0.a.u.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = b.a.p0.a.f2.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    b.a.p0.a.e0.d.c("RedirectToApi", "url is null");
                    return new b.a.p0.a.u.h.b(202, "url is null");
                }
                b.a.p0.a.g1.f U = b.a.p0.a.g1.f.U();
                b.a.p0.a.h0.g.g V = U.V();
                if (V == null) {
                    b.a.p0.a.e0.d.c("RedirectToApi", "manager is null");
                    return new b.a.p0.a.u.h.b(1001, "manager is null");
                }
                b.a.p0.a.m1.b e2 = b.a.p0.a.m1.b.e(p, U.z());
                e2.f7018i = "2";
                e2.j = uuid;
                b.a.p0.a.n2.i.g(e2);
                if (!q0.b(U.r(), e2, false)) {
                    String str2 = "page params error : path=" + e2.f7014e + " ; routePath=" + e2.f7017h;
                    b.a.p0.a.e0.d.c("RedirectToApi", str2);
                    b.a.p0.a.n2.i.i(e2);
                    return new b.a.p0.a.u.h.b(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(e2.f7017h) && b.a.p0.a.d2.e.L() != null) {
                    b.a.p0.a.d2.e.L().K0(optString, e2.f7017h);
                }
                String optString2 = jSONObject.optString("startTime");
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    b.a.p0.a.e0.d.c("RedirectToApi", "cb is empty");
                    b.a.p0.a.n2.i.i(e2);
                    return new b.a.p0.a.u.h.b(202, "cb is empty");
                } else if (b.a.p0.a.f2.f.f0.d.b().a(e2)) {
                    b.a.p0.a.f2.f.f0.d.b().i("redirectTo", e2);
                    b.a.p0.a.e0.d.c("RedirectToApi", "access to this page is prohibited");
                    return new b.a.p0.a.u.h.b(1003, "access to this page is prohibited");
                } else {
                    q0.a0(new a(this, U, optString3, e2, uuid, V));
                    return b.a.p0.a.u.h.b.f();
                }
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }
}
