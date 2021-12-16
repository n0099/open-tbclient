package c.a.q0.a.f2.f.o0;

import android.content.Context;
import android.text.TextUtils;
import c.a.q0.a.f2.f.o0.g;
import c.a.q0.a.f2.f.z;
import c.a.q0.a.h0.g.g;
import c.a.q0.a.h0.t.a;
import c.a.q0.a.n2.n;
import c.a.q0.a.z2.q0;
import c.a.q0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
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
import java.util.UUID;
@Deprecated
/* loaded from: classes.dex */
public class e extends z {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int f5476d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f5477c;

    /* loaded from: classes.dex */
    public class a implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.d2.e f5478b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.g1.f f5479c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.m1.b f5480d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.g.g f5481e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5482f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5483g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5484h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f5485i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f5486j;

        public a(e eVar, String str, c.a.q0.a.d2.e eVar2, c.a.q0.a.g1.f fVar, c.a.q0.a.m1.b bVar, c.a.q0.a.h0.g.g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, eVar2, fVar, bVar, gVar, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5486j = eVar;
            this.a = str;
            this.f5478b = eVar2;
            this.f5479c = fVar;
            this.f5480d = bVar;
            this.f5481e = gVar;
            this.f5482f = unitedSchemeEntity;
            this.f5483g = callbackHandler;
            this.f5484h = str2;
            this.f5485i = context;
        }

        @Override // c.a.q0.a.f2.f.o0.g.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.q0.a.u1.i.d(this.a);
                c.a.q0.a.e0.d.i("navigateTo", "check pages success");
                n.F(true, this.f5478b.X().T());
                this.f5479c.o();
                a.e f2 = c.a.q0.a.h0.t.a.f(this.f5479c.getActivity(), c.a.q0.a.h0.t.f.a.c(this.f5480d.f7108e));
                c.a.q0.a.f2.f.o0.a.l(this.f5482f, this.f5483g, this.f5478b, f2.a.c(), this.f5480d.f7108e, c.a.q0.a.f2.f.o0.a.g(this.f5481e), this.f5484h);
                this.f5486j.p(f2, this.f5480d, this.f5481e, this.a);
            }
        }

        @Override // c.a.q0.a.f2.f.o0.g.e
        public void b(int i2, c.a.q0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                c.a.q0.a.e0.d.c("navigateTo", "check pages failed");
                n.F(false, this.f5478b.X().T());
                this.f5479c.o();
                if (z.f5605b) {
                    Context context = this.f5485i;
                    c.a.q0.a.c2.b.f.e.g(context, this.f5485i.getString(c.a.q0.a.h.aiapps_open_pages_failed) + i2).G();
                }
                c.a.q0.a.f2.f.o0.a.j(this.f5482f, this.f5483g, this.f5484h);
                c.a.q0.a.n2.i.j(this.f5480d, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5487b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.m1.b f5488c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.g.g f5489d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5490e;

        public b(e eVar, a.e eVar2, String str, c.a.q0.a.m1.b bVar, c.a.q0.a.h0.g.g gVar) {
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
            this.f5490e = eVar;
            this.a = eVar2;
            this.f5487b = str;
            this.f5488c = bVar;
            this.f5489d = gVar;
        }

        @Override // c.a.q0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = z.f5605b;
                c.a.q0.a.u1.i.e(this.a, this.f5487b);
                this.f5490e.o(this.a.a, this.f5488c, this.f5489d, this.f5487b);
                boolean unused2 = z.f5605b;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(851529392, "Lc/a/q0/a/f2/f/o0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(851529392, "Lc/a/q0/a/f2/f/o0/e;");
                return;
            }
        }
        f5476d = c.a.q0.a.c1.a.g0().r();
        if (z.f5605b) {
            String str = "NavigateToAction max count: " + f5476d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.q0.a.f2.e eVar) {
        super(eVar, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.q0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.q0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f5605b) {
                r0 = "handle entity: " + unitedSchemeEntity.toString();
            }
            this.f5477c = context;
            String uuid = UUID.randomUUID().toString();
            c.a.q0.a.u1.i.b(uuid);
            String o = c.a.q0.a.f2.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.q0.a.e0.d.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.a.q0.a.g1.f U = c.a.q0.a.g1.f.U();
            c.a.q0.a.h0.g.g V = U.V();
            if (V == null) {
                c.a.q0.a.e0.d.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.q0.a.m1.b e2 = c.a.q0.a.m1.b.e(o, U.z());
            e2.f7112i = "0";
            e2.f7113j = uuid;
            c.a.q0.a.n2.i.g(e2);
            if (!q0.b(U.s(), e2, false)) {
                c.a.q0.a.e0.d.c("navigateTo", "page params error : path=" + e2.f7108e + " ; routePath=" + e2.f7111h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.q0.a.n2.i.i(e2);
                return false;
            }
            String n = c.a.q0.a.f2.f.o0.a.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(e2.f7111h) && c.a.q0.a.d2.e.L() != null) {
                c.a.q0.a.d2.e.L().K0(n, e2.f7111h);
            }
            String n2 = c.a.q0.a.f2.f.o0.a.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = c.a.q0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            boolean z = z.f5605b;
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.q0.a.e0.d.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.q0.a.n2.i.i(e2);
                return false;
            } else if (c.a.q0.a.f2.f.f0.d.b().a(e2)) {
                c.a.q0.a.f2.f.f0.d.b().i("navigateTo", e2);
                c.a.q0.a.e0.d.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                g.g(eVar, e2, "", new a(this, uuid, eVar, U, e2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(c.a.q0.a.p.e.b bVar, c.a.q0.a.m1.b bVar2, c.a.q0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.q0.a.g1.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.q0.a.f2.f.o0.a.e(bVar, bVar2, str);
        c.a.q0.a.u1.i.c(0, str);
        if (gVar.k() < f5476d) {
            c.a.q0.a.h0.g.f.T3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(c.a.q0.a.h0.g.g.f5805g, c.a.q0.a.h0.g.g.f5807i);
            i2.k("normal", bVar2).b();
            c.a.q0.a.z2.g.c(gVar, this.f5477c);
            c.a.q0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.q0.a.u1.i.a(str, bVar2);
            return;
        }
        c.a.q0.a.u.e.j.d.A(gVar, bVar2, str, true);
    }

    public final void p(a.e eVar, c.a.q0.a.m1.b bVar, c.a.q0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f6299b;
            HybridUbcFlow q = c.a.q0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (z.f5605b) {
                String str2 = "tryToExecutePageRoute start. isReady : " + z;
            }
            c.a.q0.a.h0.t.a.q(eVar, new b(this, eVar, str, bVar, gVar));
            boolean z2 = z.f5605b;
        }
    }
}
