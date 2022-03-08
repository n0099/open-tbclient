package c.a.p0.a.k.e.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
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
public class e extends c.a.p0.a.k.e.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.w0.f f6151e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6152f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f6153g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6154h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f6155i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f6156j;

        /* renamed from: c.a.p0.a.k.e.j.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0359a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.t1.e f6157b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f6158c;

            public C0359a(a aVar, Activity activity, c.a.p0.a.t1.e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6158c = aVar;
                this.a = activity;
                this.f6157b = eVar;
            }

            @Override // c.a.p0.a.v1.f.o0.g.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f6158c.f6154h);
                    c.a.p0.a.u.d.i("RelaunchApi", "check pages success");
                    this.f6158c.f6151e.o();
                    a.e f2 = c.a.p0.a.x.t.a.f(this.a, c.a.p0.a.x.t.f.a.c(this.f6158c.f6153g.f4642e));
                    String c2 = f2.a.c();
                    a aVar = this.f6158c;
                    c.a.p0.a.v1.f.o0.a.m(aVar.f6156j, this.f6157b, c2, aVar.f6153g.f4642e, null, aVar.f6152f);
                    c.a.p0.a.d2.e.t(c2);
                    a aVar2 = this.f6158c;
                    aVar2.f6156j.z(f2, aVar2.f6153g, aVar2.f6155i, aVar2.f6154h);
                }
            }

            @Override // c.a.p0.a.v1.f.o0.g.e
            public void c(int i2, c.a.p0.a.k2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    c.a.p0.a.u.d.c("RelaunchApi", "check pages failed");
                    this.f6158c.f6151e.o();
                    a aVar2 = this.f6158c;
                    c.a.p0.a.v1.f.o0.a.k(aVar2.f6156j, aVar2.f6152f);
                    c.a.p0.a.d2.i.j(this.f6158c.f6153g, aVar);
                }
            }
        }

        public a(e eVar, c.a.p0.a.w0.f fVar, String str, c.a.p0.a.c1.b bVar, String str2, c.a.p0.a.x.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, fVar, str, bVar, str2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6156j = eVar;
            this.f6151e = fVar;
            this.f6152f = str;
            this.f6153g = bVar;
            this.f6154h = str2;
            this.f6155i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f6151e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    c.a.p0.a.t1.e L = c.a.p0.a.t1.e.L();
                    if (L == null) {
                        this.f6156j.d(this.f6152f, new c.a.p0.a.k.h.b(1001, "swan app is null"));
                        c.a.p0.a.d2.i.i(this.f6153g);
                        return;
                    }
                    this.f6151e.a();
                    c.a.p0.a.v1.f.o0.g.g(L, this.f6153g, "", new C0359a(this, activity, L), this.f6154h);
                    return;
                }
                this.f6156j.d(this.f6152f, new c.a.p0.a.k.h.b(1001, "swan activity is null"));
                c.a.p0.a.d2.i.i(this.f6153g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6159b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f6160c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.g f6161d;

        public b(e eVar, a.e eVar2, String str, c.a.p0.a.c1.b bVar, c.a.p0.a.x.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, eVar2, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar2;
            this.f6159b = str;
            this.f6160c = bVar;
            this.f6161d = gVar;
        }

        @Override // c.a.p0.a.x.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.e(this.a, this.f6159b);
                c.a.p0.a.v1.f.o0.a.e(this.a.a, this.f6160c, this.f6159b);
                e.y(this.f6161d, this.f6160c, this.f6159b);
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

        @Override // c.a.p0.a.x.g.g.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // c.a.p0.a.x.g.g.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof c.a.p0.a.x.g.f)) {
                ((c.a.p0.a.x.g.f) fragment).W0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull c.a.p0.a.k.c.b bVar) {
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

    public static void y(c.a.p0.a.x.g.g gVar, c.a.p0.a.c1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, gVar, bVar, str) == null) {
            if (bVar != null) {
                c.a.p0.a.u.d.i("RelaunchApi", "doReLaunch page=" + bVar.f4642e + " routePage=" + bVar.f4645h);
            }
            SwanAppActivity x = c.a.p0.a.t1.d.J().x();
            if (x == null || x.isFinishing() || x.isDestroyed()) {
                return;
            }
            c cVar = new c();
            i.c(3, str);
            c.a.p0.a.x.g.f.M3(q0.n());
            gVar.g(cVar);
            g.b i2 = gVar.i("reLaunch");
            i2.n(0, 0);
            i2.f();
            i2.k("normal", bVar).b();
            gVar.p(cVar);
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            i.a(str, bVar);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public c.a.p0.a.k.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<c.a.p0.a.k.h.b, JSONObject> s = s(str);
            c.a.p0.a.k.h.b bVar = (c.a.p0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = c.a.p0.a.v1.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    c.a.p0.a.u.d.c("RelaunchApi", "url is null");
                    return new c.a.p0.a.k.h.b(202, "url is null");
                }
                c.a.p0.a.w0.f U = c.a.p0.a.w0.f.U();
                c.a.p0.a.x.g.g V = U.V();
                if (V == null) {
                    c.a.p0.a.u.d.c("RelaunchApi", "manager is null");
                    return new c.a.p0.a.k.h.b(1001, "manager is null");
                }
                c.a.p0.a.c1.b e2 = c.a.p0.a.c1.b.e(p, U.z());
                e2.f4646i = "3";
                e2.f4647j = uuid;
                c.a.p0.a.d2.i.g(e2);
                if (!q0.b(U.s(), e2, true)) {
                    String str2 = "page params error : path=" + e2.f4642e + " ; routePath=" + e2.f4645h;
                    c.a.p0.a.u.d.c("RelaunchApi", str2);
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
                    c.a.p0.a.u.d.c("RelaunchApi", "cb is null");
                    c.a.p0.a.d2.i.i(e2);
                    return new c.a.p0.a.k.h.b(202, "cb is null");
                } else if (c.a.p0.a.v1.f.f0.d.b().a(e2)) {
                    c.a.p0.a.v1.f.f0.d.b().i("reLaunch", e2);
                    c.a.p0.a.u.d.c("RelaunchApi", "access to this page is prohibited");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    public final void z(a.e eVar, c.a.p0.a.c1.b bVar, c.a.p0.a.x.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f8859b;
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            c.a.p0.a.x.t.a.q(eVar, new b(this, eVar, str, bVar, gVar));
        }
    }
}
