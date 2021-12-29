package c.a.r0.a.u.e.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.r0.a.f2.f.o0.g;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.h0.t.a;
import c.a.r0.a.u1.h;
import c.a.r0.a.u1.i;
import c.a.r0.a.z2.q0;
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
public class e extends c.a.r0.a.u.e.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.g1.f f9386e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9387f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.m1.b f9388g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9389h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f9390i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f9391j;

        /* renamed from: c.a.r0.a.u.e.j.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0573a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.d2.e f9392b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f9393c;

            public C0573a(a aVar, Activity activity, c.a.r0.a.d2.e eVar) {
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
                this.f9393c = aVar;
                this.a = activity;
                this.f9392b = eVar;
            }

            @Override // c.a.r0.a.f2.f.o0.g.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f9393c.f9389h);
                    c.a.r0.a.e0.d.i("RelaunchApi", "check pages success");
                    this.f9393c.f9386e.o();
                    a.e f2 = c.a.r0.a.h0.t.a.f(this.a, c.a.r0.a.h0.t.f.a.c(this.f9393c.f9388g.f7843e));
                    String c2 = f2.a.c();
                    a aVar = this.f9393c;
                    c.a.r0.a.f2.f.o0.a.m(aVar.f9391j, this.f9392b, c2, aVar.f9388g.f7843e, null, aVar.f9387f);
                    c.a.r0.a.n2.e.t(c2);
                    a aVar2 = this.f9393c;
                    aVar2.f9391j.z(f2, aVar2.f9388g, aVar2.f9390i, aVar2.f9389h);
                }
            }

            @Override // c.a.r0.a.f2.f.o0.g.e
            public void b(int i2, c.a.r0.a.u2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    c.a.r0.a.e0.d.c("RelaunchApi", "check pages failed");
                    this.f9393c.f9386e.o();
                    a aVar2 = this.f9393c;
                    c.a.r0.a.f2.f.o0.a.k(aVar2.f9391j, aVar2.f9387f);
                    c.a.r0.a.n2.i.j(this.f9393c.f9388g, aVar);
                }
            }
        }

        public a(e eVar, c.a.r0.a.g1.f fVar, String str, c.a.r0.a.m1.b bVar, String str2, c.a.r0.a.h0.g.g gVar) {
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
            this.f9391j = eVar;
            this.f9386e = fVar;
            this.f9387f = str;
            this.f9388g = bVar;
            this.f9389h = str2;
            this.f9390i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f9386e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
                    if (L == null) {
                        this.f9391j.d(this.f9387f, new c.a.r0.a.u.h.b(1001, "swan app is null"));
                        c.a.r0.a.n2.i.i(this.f9388g);
                        return;
                    }
                    this.f9386e.a();
                    c.a.r0.a.f2.f.o0.g.g(L, this.f9388g, "", new C0573a(this, activity, L), this.f9389h);
                    return;
                }
                this.f9391j.d(this.f9387f, new c.a.r0.a.u.h.b(1001, "swan activity is null"));
                c.a.r0.a.n2.i.i(this.f9388g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9394b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.m1.b f9395c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.g.g f9396d;

        public b(e eVar, a.e eVar2, String str, c.a.r0.a.m1.b bVar, c.a.r0.a.h0.g.g gVar) {
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
            this.f9394b = str;
            this.f9395c = bVar;
            this.f9396d = gVar;
        }

        @Override // c.a.r0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.e(this.a, this.f9394b);
                c.a.r0.a.f2.f.o0.a.e(this.a.a, this.f9395c, this.f9394b);
                e.y(this.f9396d, this.f9395c, this.f9394b);
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

        @Override // c.a.r0.a.h0.g.g.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // c.a.r0.a.h0.g.g.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof c.a.r0.a.h0.g.f)) {
                ((c.a.r0.a.h0.g.f) fragment).W0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull c.a.r0.a.u.c.b bVar) {
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

    public static void y(c.a.r0.a.h0.g.g gVar, c.a.r0.a.m1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, gVar, bVar, str) == null) {
            if (bVar != null) {
                c.a.r0.a.e0.d.i("RelaunchApi", "doReLaunch page=" + bVar.f7843e + " routePage=" + bVar.f7846h);
            }
            SwanAppActivity x = c.a.r0.a.d2.d.J().x();
            if (x == null || x.isFinishing() || x.isDestroyed()) {
                return;
            }
            c cVar = new c();
            i.c(3, str);
            c.a.r0.a.h0.g.f.M3(q0.n());
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
    public c.a.r0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = c.a.r0.a.f2.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    c.a.r0.a.e0.d.c("RelaunchApi", "url is null");
                    return new c.a.r0.a.u.h.b(202, "url is null");
                }
                c.a.r0.a.g1.f U = c.a.r0.a.g1.f.U();
                c.a.r0.a.h0.g.g V = U.V();
                if (V == null) {
                    c.a.r0.a.e0.d.c("RelaunchApi", "manager is null");
                    return new c.a.r0.a.u.h.b(1001, "manager is null");
                }
                c.a.r0.a.m1.b e2 = c.a.r0.a.m1.b.e(p, U.z());
                e2.f7847i = "3";
                e2.f7848j = uuid;
                c.a.r0.a.n2.i.g(e2);
                if (!q0.b(U.s(), e2, true)) {
                    String str2 = "page params error : path=" + e2.f7843e + " ; routePath=" + e2.f7846h;
                    c.a.r0.a.e0.d.c("RelaunchApi", str2);
                    c.a.r0.a.n2.i.i(e2);
                    return new c.a.r0.a.u.h.b(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(e2.f7846h) && c.a.r0.a.d2.e.L() != null) {
                    c.a.r0.a.d2.e.L().K0(optString, e2.f7846h);
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
                    c.a.r0.a.e0.d.c("RelaunchApi", "cb is null");
                    c.a.r0.a.n2.i.i(e2);
                    return new c.a.r0.a.u.h.b(202, "cb is null");
                } else if (c.a.r0.a.f2.f.f0.d.b().a(e2)) {
                    c.a.r0.a.f2.f.f0.d.b().i("reLaunch", e2);
                    c.a.r0.a.e0.d.c("RelaunchApi", "access to this page is prohibited");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    public final void z(a.e eVar, c.a.r0.a.m1.b bVar, c.a.r0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f7034b;
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            c.a.r0.a.h0.t.a.q(eVar, new b(this, eVar, str, bVar, gVar));
        }
    }
}
