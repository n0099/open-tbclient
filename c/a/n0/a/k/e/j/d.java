package c.a.n0.a.k.e.j;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.k1.h;
import c.a.n0.a.k1.i;
import c.a.n0.a.p2.q0;
import c.a.n0.a.v1.f.o0.g;
import c.a.n0.a.x.g.g;
import c.a.n0.a.x.t.a;
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
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c.a.n0.a.k.e.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.w0.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5163b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f5164c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5165d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f5166e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f5167f;

        /* renamed from: c.a.n0.a.k.e.j.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0346a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.t1.e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f5168b;

            public C0346a(a aVar, c.a.n0.a.t1.e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5168b = aVar;
                this.a = eVar;
            }

            @Override // c.a.n0.a.v1.f.o0.g.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f5168b.f5165d);
                    c.a.n0.a.u.d.i("RedirectToApi", "check pages success");
                    this.f5168b.a.o();
                    a.e f2 = c.a.n0.a.x.t.a.f(this.f5168b.a.getActivity(), c.a.n0.a.x.t.f.a.c(this.f5168b.f5164c.a));
                    String c2 = f2.a.c();
                    a aVar = this.f5168b;
                    c.a.n0.a.v1.f.o0.a.m(aVar.f5167f, this.a, c2, aVar.f5164c.a, null, aVar.f5163b);
                    a aVar2 = this.f5168b;
                    aVar2.f5167f.C(f2, aVar2.f5164c, aVar2.f5166e, aVar2.f5165d);
                }
            }

            @Override // c.a.n0.a.v1.f.o0.g.e
            public void c(int i, c.a.n0.a.k2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, aVar) == null) {
                    c.a.n0.a.u.d.c("RedirectToApi", "check pages failed");
                    this.f5168b.a.o();
                    a aVar2 = this.f5168b;
                    c.a.n0.a.v1.f.o0.a.k(aVar2.f5167f, aVar2.f5163b);
                    c.a.n0.a.d2.i.j(this.f5168b.f5164c, aVar);
                }
            }
        }

        public a(d dVar, c.a.n0.a.w0.f fVar, String str, c.a.n0.a.c1.b bVar, String str2, c.a.n0.a.x.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, fVar, str, bVar, str2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5167f = dVar;
            this.a = fVar;
            this.f5163b = str;
            this.f5164c = bVar;
            this.f5165d = str2;
            this.f5166e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
                    if (L == null) {
                        this.f5167f.d(this.f5163b, new c.a.n0.a.k.h.b(1001, "swan app is null"));
                        c.a.n0.a.d2.i.i(this.f5164c);
                        return;
                    }
                    this.a.a();
                    c.a.n0.a.v1.f.o0.g.g(L, this.f5164c, "", new C0346a(this, L), this.f5165d);
                    return;
                }
                this.f5167f.d(this.f5163b, new c.a.n0.a.k.h.b(1001, "swan activity is null"));
                c.a.n0.a.d2.i.i(this.f5164c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f5169b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.g.g f5170c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5171d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5172e;

        public b(d dVar, a.e eVar, c.a.n0.a.c1.b bVar, c.a.n0.a.x.g.g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, eVar, bVar, gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5172e = dVar;
            this.a = eVar;
            this.f5169b = bVar;
            this.f5170c = gVar;
            this.f5171d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5172e.B(this.a, this.f5169b, this.f5170c, this.f5171d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5173b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f5174c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.g.g f5175d;

        public c(d dVar, a.e eVar, String str, c.a.n0.a.c1.b bVar, c.a.n0.a.x.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, eVar, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.f5173b = str;
            this.f5174c = bVar;
            this.f5175d = gVar;
        }

        @Override // c.a.n0.a.x.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.e(this.a, this.f5173b);
                c.a.n0.a.v1.f.o0.a.e(this.a.a, this.f5174c, this.f5173b);
                d.A(this.f5175d, this.f5174c, this.f5173b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(c.a.n0.a.x.g.g gVar, c.a.n0.a.c1.b bVar, String str, boolean z) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{gVar, bVar, str, Boolean.valueOf(z)}) == null) || z() || (x = c.a.n0.a.t1.d.J().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        i.c(z ? 8 : 2, str);
        c.a.n0.a.x.g.f.Q3(q0.n());
        g.b i = gVar.i("redirectTo");
        i.n(0, 0);
        g.b k = i.k("normal", bVar);
        k.m(z ? 0 : gVar.k() - 2);
        k.b();
        h.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
        i.a(str, bVar);
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            return a0 == null || (x = a0.x()) == null || x.isFinishing() || x.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public final void B(a.e eVar, c.a.n0.a.c1.b bVar, c.a.n0.a.x.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f7448b;
            HybridUbcFlow q = h.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            c.a.n0.a.x.t.a.q(eVar, new c(this, eVar, str, bVar, gVar));
        }
    }

    public final void C(a.e eVar, c.a.n0.a.c1.b bVar, c.a.n0.a.x.g.g gVar, String str) {
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
    public c.a.n0.a.k.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = c.a.n0.a.v1.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    c.a.n0.a.u.d.c("RedirectToApi", "url is null");
                    return new c.a.n0.a.k.h.b(202, "url is null");
                }
                c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
                c.a.n0.a.x.g.g V = U.V();
                if (V == null) {
                    c.a.n0.a.u.d.c("RedirectToApi", "manager is null");
                    return new c.a.n0.a.k.h.b(1001, "manager is null");
                }
                c.a.n0.a.c1.b d2 = c.a.n0.a.c1.b.d(p, U.z());
                d2.f3950e = "2";
                d2.f3951f = uuid;
                c.a.n0.a.d2.i.g(d2);
                if (!q0.b(U.s(), d2, false)) {
                    String str2 = "page params error : path=" + d2.a + " ; routePath=" + d2.f3949d;
                    c.a.n0.a.u.d.c("RedirectToApi", str2);
                    c.a.n0.a.d2.i.i(d2);
                    return new c.a.n0.a.k.h.b(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.f3949d) && c.a.n0.a.t1.e.L() != null) {
                    c.a.n0.a.t1.e.L().K0(optString, d2.f3949d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = h.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    c.a.n0.a.u.d.c("RedirectToApi", "cb is empty");
                    c.a.n0.a.d2.i.i(d2);
                    return new c.a.n0.a.k.h.b(202, "cb is empty");
                } else if (c.a.n0.a.v1.f.f0.d.b().a(d2)) {
                    c.a.n0.a.v1.f.f0.d.b().i("redirectTo", d2);
                    c.a.n0.a.u.d.c("RedirectToApi", "access to this page is prohibited");
                    return new c.a.n0.a.k.h.b(1003, "access to this page is prohibited");
                } else {
                    q0.a0(new a(this, U, optString3, d2, uuid, V));
                    return c.a.n0.a.k.h.b.f();
                }
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }
}
