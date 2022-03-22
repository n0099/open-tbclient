package c.a.n0.a.k.e.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
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
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends c.a.n0.a.k.e.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.w0.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5176b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f5177c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5178d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f5179e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f5180f;

        /* renamed from: c.a.n0.a.k.e.j.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0347a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.t1.e f5181b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f5182c;

            public C0347a(a aVar, Activity activity, c.a.n0.a.t1.e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5182c = aVar;
                this.a = activity;
                this.f5181b = eVar;
            }

            @Override // c.a.n0.a.v1.f.o0.g.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f5182c.f5178d);
                    c.a.n0.a.u.d.i("RelaunchApi", "check pages success");
                    this.f5182c.a.o();
                    a.e f2 = c.a.n0.a.x.t.a.f(this.a, c.a.n0.a.x.t.f.a.c(this.f5182c.f5177c.a));
                    String c2 = f2.a.c();
                    a aVar = this.f5182c;
                    c.a.n0.a.v1.f.o0.a.m(aVar.f5180f, this.f5181b, c2, aVar.f5177c.a, null, aVar.f5176b);
                    c.a.n0.a.d2.e.t(c2);
                    a aVar2 = this.f5182c;
                    aVar2.f5180f.z(f2, aVar2.f5177c, aVar2.f5179e, aVar2.f5178d);
                }
            }

            @Override // c.a.n0.a.v1.f.o0.g.e
            public void c(int i, c.a.n0.a.k2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, aVar) == null) {
                    c.a.n0.a.u.d.c("RelaunchApi", "check pages failed");
                    this.f5182c.a.o();
                    a aVar2 = this.f5182c;
                    c.a.n0.a.v1.f.o0.a.k(aVar2.f5180f, aVar2.f5176b);
                    c.a.n0.a.d2.i.j(this.f5182c.f5177c, aVar);
                }
            }
        }

        public a(e eVar, c.a.n0.a.w0.f fVar, String str, c.a.n0.a.c1.b bVar, String str2, c.a.n0.a.x.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, fVar, str, bVar, str2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5180f = eVar;
            this.a = fVar;
            this.f5176b = str;
            this.f5177c = bVar;
            this.f5178d = str2;
            this.f5179e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
                    if (L == null) {
                        this.f5180f.d(this.f5176b, new c.a.n0.a.k.h.b(1001, "swan app is null"));
                        c.a.n0.a.d2.i.i(this.f5177c);
                        return;
                    }
                    this.a.a();
                    c.a.n0.a.v1.f.o0.g.g(L, this.f5177c, "", new C0347a(this, activity, L), this.f5178d);
                    return;
                }
                this.f5180f.d(this.f5176b, new c.a.n0.a.k.h.b(1001, "swan activity is null"));
                c.a.n0.a.d2.i.i(this.f5177c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5183b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f5184c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.g.g f5185d;

        public b(e eVar, a.e eVar2, String str, c.a.n0.a.c1.b bVar, c.a.n0.a.x.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, eVar2, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar2;
            this.f5183b = str;
            this.f5184c = bVar;
            this.f5185d = gVar;
        }

        @Override // c.a.n0.a.x.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.e(this.a, this.f5183b);
                c.a.n0.a.v1.f.o0.a.e(this.a.a, this.f5184c, this.f5183b);
                e.y(this.f5185d, this.f5184c, this.f5183b);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.n0.a.x.g.g.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // c.a.n0.a.x.g.g.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof c.a.n0.a.x.g.f)) {
                ((c.a.n0.a.x.g.f) fragment).S0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull c.a.n0.a.k.c.b bVar) {
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

    public static void y(c.a.n0.a.x.g.g gVar, c.a.n0.a.c1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, gVar, bVar, str) == null) {
            if (bVar != null) {
                c.a.n0.a.u.d.i("RelaunchApi", "doReLaunch page=" + bVar.a + " routePage=" + bVar.f3949d);
            }
            SwanAppActivity x = c.a.n0.a.t1.d.J().x();
            if (x == null || x.isFinishing() || x.isDestroyed()) {
                return;
            }
            c cVar = new c();
            i.c(3, str);
            c.a.n0.a.x.g.f.Q3(q0.n());
            gVar.g(cVar);
            g.b i = gVar.i("reLaunch");
            i.n(0, 0);
            i.f();
            i.k("normal", bVar).b();
            gVar.p(cVar);
            h.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            i.a(str, bVar);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public c.a.n0.a.k.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = c.a.n0.a.v1.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    c.a.n0.a.u.d.c("RelaunchApi", "url is null");
                    return new c.a.n0.a.k.h.b(202, "url is null");
                }
                c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
                c.a.n0.a.x.g.g V = U.V();
                if (V == null) {
                    c.a.n0.a.u.d.c("RelaunchApi", "manager is null");
                    return new c.a.n0.a.k.h.b(1001, "manager is null");
                }
                c.a.n0.a.c1.b d2 = c.a.n0.a.c1.b.d(p, U.z());
                d2.f3950e = "3";
                d2.f3951f = uuid;
                c.a.n0.a.d2.i.g(d2);
                if (!q0.b(U.s(), d2, true)) {
                    String str2 = "page params error : path=" + d2.a + " ; routePath=" + d2.f3949d;
                    c.a.n0.a.u.d.c("RelaunchApi", str2);
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
                    c.a.n0.a.u.d.c("RelaunchApi", "cb is null");
                    c.a.n0.a.d2.i.i(d2);
                    return new c.a.n0.a.k.h.b(202, "cb is null");
                } else if (c.a.n0.a.v1.f.f0.d.b().a(d2)) {
                    c.a.n0.a.v1.f.f0.d.b().i("reLaunch", d2);
                    c.a.n0.a.u.d.c("RelaunchApi", "access to this page is prohibited");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    public final void z(a.e eVar, c.a.n0.a.c1.b bVar, c.a.n0.a.x.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f7448b;
            HybridUbcFlow q = h.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            c.a.n0.a.x.t.a.q(eVar, new b(this, eVar, str, bVar, gVar));
        }
    }
}
