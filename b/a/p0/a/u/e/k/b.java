package b.a.p0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
import b.a.p0.a.c2.f.p0.g;
import b.a.p0.a.g1.f;
import b.a.p0.a.h;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.h0.t.a;
import b.a.p0.a.j2.k;
import b.a.p0.a.r1.i;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int f8267d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8268e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8269f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l1.b f8270g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8271h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8272i;
        public final /* synthetic */ b j;

        /* renamed from: b.a.p0.a.u.e.k.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0403a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f8273a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f8274b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f8275c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f8276d;

            public C0403a(a aVar, e eVar, String str, a.d dVar) {
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
                this.f8276d = aVar;
                this.f8273a = eVar;
                this.f8274b = str;
                this.f8275c = dVar;
            }

            @Override // b.a.p0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f8276d.f8271h);
                    b.a.p0.a.e0.d.g("Api-NavigateTo", "check pages success");
                    k.B(true, this.f8273a.M().S());
                    this.f8276d.f8268e.n();
                    List<String> g2 = b.a.p0.a.c2.f.p0.a.g(this.f8276d.f8272i);
                    a aVar = this.f8276d;
                    b.a.p0.a.c2.f.p0.a.m(aVar.j, this.f8273a, this.f8274b, aVar.f8270g.f6555e, g2, aVar.f8269f);
                    a aVar2 = this.f8276d;
                    aVar2.j.v(this.f8275c, aVar2.f8270g, aVar2.f8272i, aVar2.f8271h);
                }
            }

            @Override // b.a.p0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    b.a.p0.a.e0.d.b("Api-NavigateTo", "check pages failed");
                    k.B(false, this.f8273a.M().S());
                    this.f8276d.f8268e.n();
                    if (b.a.p0.a.u.c.d.f8000c) {
                        Context context = this.f8276d.j.getContext();
                        b.a.p0.a.z1.b.f.e.g(context, context.getString(h.aiapps_open_pages_failed) + i2).F();
                    }
                    a aVar = this.f8276d;
                    b.a.p0.a.c2.f.p0.a.k(aVar.j, aVar.f8269f);
                }
            }
        }

        public a(b bVar, f fVar, String str, b.a.p0.a.l1.b bVar2, String str2, b.a.p0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, fVar, str, bVar2, str2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = bVar;
            this.f8268e = fVar;
            this.f8269f = str;
            this.f8270g = bVar2;
            this.f8271h = str2;
            this.f8272i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = b.a.p0.a.u.c.d.f8000c;
                SwanAppActivity activity = this.f8268e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a.d f2 = b.a.p0.a.h0.t.a.f(activity);
                    String b2 = f2.f5778a.b();
                    if (b.a.p0.a.u.c.d.f8000c) {
                        String str = "slave webView id: " + b2;
                    }
                    e i2 = e.i();
                    if (i2 == null) {
                        if (!b.a.p0.a.u.c.d.f8000c) {
                            this.j.d(this.f8269f, new b.a.p0.a.u.h.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    this.f8268e.t();
                    b.a.p0.a.c2.f.p0.g.g(i2, this.f8270g, b2, new C0403a(this, i2, b2, f2), this.f8271h);
                } else if (!b.a.p0.a.u.c.d.f8000c) {
                    this.j.d(this.f8269f, new b.a.p0.a.u.h.b(1001, "swan activity is null"));
                } else {
                    throw new RuntimeException("swan activity is null");
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.u.e.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0404b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f8277a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8278b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l1.b f8279c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f8280d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8281e;

        public C0404b(b bVar, a.d dVar, String str, b.a.p0.a.l1.b bVar2, b.a.p0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, dVar, str, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8281e = bVar;
            this.f8277a = dVar;
            this.f8278b = str;
            this.f8279c = bVar2;
            this.f8280d = gVar;
        }

        @Override // b.a.p0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = b.a.p0.a.u.c.d.f8000c;
                i.e(this.f8277a, this.f8278b);
                this.f8281e.t(this.f8277a.f5778a, this.f8279c, this.f8280d, this.f8278b);
                boolean z2 = b.a.p0.a.u.c.d.f8000c;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229927817, "Lb/a/p0/a/u/e/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-229927817, "Lb/a/p0/a/u/e/k/b;");
                return;
            }
        }
        f8267d = b.a.p0.a.c1.a.Z().s();
        if (b.a.p0.a.u.c.d.f8000c) {
            String str = "NavigateToAction max count: " + f8267d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void t(b.a.p0.a.p.e.b bVar, b.a.p0.a.l1.b bVar2, b.a.p0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, bVar, bVar2, gVar, str) == null) || (activity = f.T().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        b.a.p0.a.c2.f.p0.a.e(bVar, bVar2, str);
        i.c(0, str);
        if (gVar.k() < f8267d) {
            b.a.p0.a.h0.g.f.y3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(b.a.p0.a.h0.g.g.f5280g, b.a.p0.a.h0.g.g.f5282i);
            i2.k("normal", bVar2).b();
            b.a.p0.a.v2.g.c(gVar, getContext());
            b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            i.a(str, bVar2);
            return;
        }
        c.t(gVar, bVar2, str, true);
    }

    public b.a.p0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (b.a.p0.a.u.c.d.f8000c) {
                String str2 = "handle: " + str;
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-NavigateTo", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-NavigateTo", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String p = b.a.p0.a.c2.f.p0.a.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                b.a.p0.a.e0.d.b("Api-NavigateTo", "url is null");
                return new b.a.p0.a.u.h.b(202, "url is null");
            }
            f T = f.T();
            b.a.p0.a.h0.g.g U = T.U();
            if (U == null) {
                b.a.p0.a.e0.d.b("Api-NavigateTo", "manager is null");
                return new b.a.p0.a.u.h.b(1001, "manager is null");
            }
            b.a.p0.a.l1.b e2 = b.a.p0.a.l1.b.e(p, T.z());
            b.a.p0.a.j2.h.f(e2.f6555e, "0");
            if (!q0.b(T.r(), e2, false)) {
                String str3 = "page params error : path=" + e2.f6555e + " ; routePath=" + e2.f6558h;
                b.a.p0.a.e0.d.b("Api-NavigateTo", str3);
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
                b.a.p0.a.e0.d.b("Api-NavigateTo", "cb is null");
                return new b.a.p0.a.u.h.b(202, "cb is null");
            } else if (b.a.p0.a.c2.f.g0.d.b().a(e2)) {
                b.a.p0.a.c2.f.g0.d.b().i("navigateTo", e2);
                b.a.p0.a.e0.d.b("Api-NavigateTo", "access to this page is prohibited");
                return new b.a.p0.a.u.h.b(1003, "access to this page is prohibited");
            } else {
                q0.X(new a(this, T, optString3, e2, uuid, U));
                return new b.a.p0.a.u.h.b(0);
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void v(a.d dVar, b.a.p0.a.l1.b bVar, b.a.p0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f5779b;
            HybridUbcFlow q = b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (b.a.p0.a.u.c.d.f8000c) {
                String str2 = "tryToExecutePageRoute start. isReady : " + z;
            }
            b.a.p0.a.h0.t.a.n(dVar, new C0404b(this, dVar, str, bVar, gVar));
            boolean z2 = b.a.p0.a.u.c.d.f8000c;
        }
    }
}
