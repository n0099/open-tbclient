package c.a.p0.a.k.e.j;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k1.h;
import c.a.p0.a.k1.i;
import c.a.p0.a.p2.q0;
import c.a.p0.a.v1.f.o0.g;
import c.a.p0.a.x.g.g;
import c.a.p0.a.x.t.a;
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
public class d extends c.a.p0.a.k.e.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.w0.f f6136e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6137f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f6138g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6139h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f6140i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f6141j;

        /* renamed from: c.a.p0.a.k.e.j.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0358a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.p0.a.t1.e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f6142b;

            public C0358a(a aVar, c.a.p0.a.t1.e eVar) {
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
                this.f6142b = aVar;
                this.a = eVar;
            }

            @Override // c.a.p0.a.v1.f.o0.g.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f6142b.f6139h);
                    c.a.p0.a.u.d.i("RedirectToApi", "check pages success");
                    this.f6142b.f6136e.o();
                    a.e f2 = c.a.p0.a.x.t.a.f(this.f6142b.f6136e.getActivity(), c.a.p0.a.x.t.f.a.c(this.f6142b.f6138g.f4642e));
                    String c2 = f2.a.c();
                    a aVar = this.f6142b;
                    c.a.p0.a.v1.f.o0.a.m(aVar.f6141j, this.a, c2, aVar.f6138g.f4642e, null, aVar.f6137f);
                    a aVar2 = this.f6142b;
                    aVar2.f6141j.C(f2, aVar2.f6138g, aVar2.f6140i, aVar2.f6139h);
                }
            }

            @Override // c.a.p0.a.v1.f.o0.g.e
            public void c(int i2, c.a.p0.a.k2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    c.a.p0.a.u.d.c("RedirectToApi", "check pages failed");
                    this.f6142b.f6136e.o();
                    a aVar2 = this.f6142b;
                    c.a.p0.a.v1.f.o0.a.k(aVar2.f6141j, aVar2.f6137f);
                    c.a.p0.a.d2.i.j(this.f6142b.f6138g, aVar);
                }
            }
        }

        public a(d dVar, c.a.p0.a.w0.f fVar, String str, c.a.p0.a.c1.b bVar, String str2, c.a.p0.a.x.g.g gVar) {
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
            this.f6141j = dVar;
            this.f6136e = fVar;
            this.f6137f = str;
            this.f6138g = bVar;
            this.f6139h = str2;
            this.f6140i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f6136e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    c.a.p0.a.t1.e L = c.a.p0.a.t1.e.L();
                    if (L == null) {
                        this.f6141j.d(this.f6137f, new c.a.p0.a.k.h.b(1001, "swan app is null"));
                        c.a.p0.a.d2.i.i(this.f6138g);
                        return;
                    }
                    this.f6136e.a();
                    c.a.p0.a.v1.f.o0.g.g(L, this.f6138g, "", new C0358a(this, L), this.f6139h);
                    return;
                }
                this.f6141j.d(this.f6137f, new c.a.p0.a.k.h.b(1001, "swan activity is null"));
                c.a.p0.a.d2.i.i(this.f6138g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.e f6143e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f6144f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.g f6145g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6146h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f6147i;

        public b(d dVar, a.e eVar, c.a.p0.a.c1.b bVar, c.a.p0.a.x.g.g gVar, String str) {
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
            this.f6147i = dVar;
            this.f6143e = eVar;
            this.f6144f = bVar;
            this.f6145g = gVar;
            this.f6146h = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6147i.B(this.f6143e, this.f6144f, this.f6145g, this.f6146h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6148b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f6149c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.g f6150d;

        public c(d dVar, a.e eVar, String str, c.a.p0.a.c1.b bVar, c.a.p0.a.x.g.g gVar) {
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
            this.f6148b = str;
            this.f6149c = bVar;
            this.f6150d = gVar;
        }

        @Override // c.a.p0.a.x.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.e(this.a, this.f6148b);
                c.a.p0.a.v1.f.o0.a.e(this.a.a, this.f6149c, this.f6148b);
                d.A(this.f6150d, this.f6149c, this.f6148b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull c.a.p0.a.k.c.b bVar) {
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
                super((c.a.p0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(c.a.p0.a.x.g.g gVar, c.a.p0.a.c1.b bVar, String str, boolean z) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{gVar, bVar, str, Boolean.valueOf(z)}) == null) || z() || (x = c.a.p0.a.t1.d.J().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        i.c(z ? 8 : 2, str);
        c.a.p0.a.x.g.f.M3(q0.n());
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
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            return a0 == null || (x = a0.x()) == null || x.isFinishing() || x.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public final void B(a.e eVar, c.a.p0.a.c1.b bVar, c.a.p0.a.x.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f8859b;
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            c.a.p0.a.x.t.a.q(eVar, new c(this, eVar, str, bVar, gVar));
        }
    }

    public final void C(a.e eVar, c.a.p0.a.c1.b bVar, c.a.p0.a.x.g.g gVar, String str) {
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
    public c.a.p0.a.k.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<c.a.p0.a.k.h.b, JSONObject> s = s(str);
            c.a.p0.a.k.h.b bVar = (c.a.p0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = c.a.p0.a.v1.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    c.a.p0.a.u.d.c("RedirectToApi", "url is null");
                    return new c.a.p0.a.k.h.b(202, "url is null");
                }
                c.a.p0.a.w0.f U = c.a.p0.a.w0.f.U();
                c.a.p0.a.x.g.g V = U.V();
                if (V == null) {
                    c.a.p0.a.u.d.c("RedirectToApi", "manager is null");
                    return new c.a.p0.a.k.h.b(1001, "manager is null");
                }
                c.a.p0.a.c1.b e2 = c.a.p0.a.c1.b.e(p, U.z());
                e2.f4646i = "2";
                e2.f4647j = uuid;
                c.a.p0.a.d2.i.g(e2);
                if (!q0.b(U.s(), e2, false)) {
                    String str2 = "page params error : path=" + e2.f4642e + " ; routePath=" + e2.f4645h;
                    c.a.p0.a.u.d.c("RedirectToApi", str2);
                    c.a.p0.a.d2.i.i(e2);
                    return new c.a.p0.a.k.h.b(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(e2.f4645h) && c.a.p0.a.t1.e.L() != null) {
                    c.a.p0.a.t1.e.L().K0(optString, e2.f4645h);
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
                    c.a.p0.a.u.d.c("RedirectToApi", "cb is empty");
                    c.a.p0.a.d2.i.i(e2);
                    return new c.a.p0.a.k.h.b(202, "cb is empty");
                } else if (c.a.p0.a.v1.f.f0.d.b().a(e2)) {
                    c.a.p0.a.v1.f.f0.d.b().i("redirectTo", e2);
                    c.a.p0.a.u.d.c("RedirectToApi", "access to this page is prohibited");
                    return new c.a.p0.a.k.h.b(1003, "access to this page is prohibited");
                } else {
                    q0.a0(new a(this, U, optString3, e2, uuid, V));
                    return c.a.p0.a.k.h.b.f();
                }
            }
            return bVar;
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }
}
