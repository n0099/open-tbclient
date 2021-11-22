package b.a.p0.a.u.e.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
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
public class e extends b.a.p0.a.u.e.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.g1.f f8789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8790f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f8791g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8792h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8793i;
        public final /* synthetic */ e j;

        /* renamed from: b.a.p0.a.u.e.j.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0433a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Activity f8794a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.d2.e f8795b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f8796c;

            public C0433a(a aVar, Activity activity, b.a.p0.a.d2.e eVar) {
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
                this.f8796c = aVar;
                this.f8794a = activity;
                this.f8795b = eVar;
            }

            @Override // b.a.p0.a.f2.f.o0.g.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f8796c.f8792h);
                    b.a.p0.a.e0.d.i("RelaunchApi", "check pages success");
                    this.f8796c.f8789e.n();
                    a.e f2 = b.a.p0.a.h0.t.a.f(this.f8794a, b.a.p0.a.h0.t.f.a.c(this.f8796c.f8791g.f7014e));
                    String c2 = f2.f6108a.c();
                    a aVar = this.f8796c;
                    b.a.p0.a.f2.f.o0.a.m(aVar.j, this.f8795b, c2, aVar.f8791g.f7014e, null, aVar.f8790f);
                    b.a.p0.a.n2.e.t(c2);
                    a aVar2 = this.f8796c;
                    aVar2.j.z(f2, aVar2.f8791g, aVar2.f8793i, aVar2.f8792h);
                }
            }

            @Override // b.a.p0.a.f2.f.o0.g.e
            public void b(int i2, b.a.p0.a.u2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    b.a.p0.a.e0.d.c("RelaunchApi", "check pages failed");
                    this.f8796c.f8789e.n();
                    a aVar2 = this.f8796c;
                    b.a.p0.a.f2.f.o0.a.k(aVar2.j, aVar2.f8790f);
                    b.a.p0.a.n2.i.j(this.f8796c.f8791g, aVar);
                }
            }
        }

        public a(e eVar, b.a.p0.a.g1.f fVar, String str, b.a.p0.a.m1.b bVar, String str2, b.a.p0.a.h0.g.g gVar) {
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
            this.j = eVar;
            this.f8789e = fVar;
            this.f8790f = str;
            this.f8791g = bVar;
            this.f8792h = str2;
            this.f8793i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f8789e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
                    if (L == null) {
                        this.j.d(this.f8790f, new b.a.p0.a.u.h.b(1001, "swan app is null"));
                        b.a.p0.a.n2.i.i(this.f8791g);
                        return;
                    }
                    this.f8789e.t();
                    b.a.p0.a.f2.f.o0.g.g(L, this.f8791g, "", new C0433a(this, activity, L), this.f8792h);
                    return;
                }
                this.j.d(this.f8790f, new b.a.p0.a.u.h.b(1001, "swan activity is null"));
                b.a.p0.a.n2.i.i(this.f8791g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.e f8797a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8798b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f8799c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f8800d;

        public b(e eVar, a.e eVar2, String str, b.a.p0.a.m1.b bVar, b.a.p0.a.h0.g.g gVar) {
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
            this.f8797a = eVar2;
            this.f8798b = str;
            this.f8799c = bVar;
            this.f8800d = gVar;
        }

        @Override // b.a.p0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.e(this.f8797a, this.f8798b);
                b.a.p0.a.f2.f.o0.a.e(this.f8797a.f6108a, this.f8799c, this.f8798b);
                e.y(this.f8800d, this.f8799c, this.f8798b);
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
                ((b.a.p0.a.h0.g.f) fragment).V0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public static void y(b.a.p0.a.h0.g.g gVar, b.a.p0.a.m1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, gVar, bVar, str) == null) {
            if (bVar != null) {
                b.a.p0.a.e0.d.i("RelaunchApi", "doReLaunch page=" + bVar.f7014e + " routePage=" + bVar.f7017h);
            }
            SwanAppActivity x = b.a.p0.a.d2.d.J().x();
            if (x == null || x.isFinishing() || x.isDestroyed()) {
                return;
            }
            c cVar = new c();
            i.c(3, str);
            b.a.p0.a.h0.g.f.P3(q0.n());
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
    public b.a.p0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = b.a.p0.a.f2.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    b.a.p0.a.e0.d.c("RelaunchApi", "url is null");
                    return new b.a.p0.a.u.h.b(202, "url is null");
                }
                b.a.p0.a.g1.f U = b.a.p0.a.g1.f.U();
                b.a.p0.a.h0.g.g V = U.V();
                if (V == null) {
                    b.a.p0.a.e0.d.c("RelaunchApi", "manager is null");
                    return new b.a.p0.a.u.h.b(1001, "manager is null");
                }
                b.a.p0.a.m1.b e2 = b.a.p0.a.m1.b.e(p, U.z());
                e2.f7018i = "3";
                e2.j = uuid;
                b.a.p0.a.n2.i.g(e2);
                if (!q0.b(U.r(), e2, true)) {
                    String str2 = "page params error : path=" + e2.f7014e + " ; routePath=" + e2.f7017h;
                    b.a.p0.a.e0.d.c("RelaunchApi", str2);
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
                    b.a.p0.a.e0.d.c("RelaunchApi", "cb is null");
                    b.a.p0.a.n2.i.i(e2);
                    return new b.a.p0.a.u.h.b(202, "cb is null");
                } else if (b.a.p0.a.f2.f.f0.d.b().a(e2)) {
                    b.a.p0.a.f2.f.f0.d.b().i("reLaunch", e2);
                    b.a.p0.a.e0.d.c("RelaunchApi", "access to this page is prohibited");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    public final void z(a.e eVar, b.a.p0.a.m1.b bVar, b.a.p0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f6109b;
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            b.a.p0.a.h0.t.a.q(eVar, new b(this, eVar, str, bVar, gVar));
        }
    }
}
