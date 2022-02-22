package c.a.s0.a.f2.f.o0;

import android.content.Context;
import android.text.TextUtils;
import c.a.s0.a.f2.f.o0.g;
import c.a.s0.a.f2.f.z;
import c.a.s0.a.h0.g.g;
import c.a.s0.a.h0.t.a;
import c.a.s0.a.n2.n;
import c.a.s0.a.z2.q0;
import c.a.s0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
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
    public static final int f6314d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f6315c;

    /* loaded from: classes.dex */
    public class a implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.d2.e f6316b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.g1.f f6317c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.m1.b f6318d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.g.g f6319e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6320f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6321g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6322h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f6323i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f6324j;

        public a(e eVar, String str, c.a.s0.a.d2.e eVar2, c.a.s0.a.g1.f fVar, c.a.s0.a.m1.b bVar, c.a.s0.a.h0.g.g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
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
            this.f6324j = eVar;
            this.a = str;
            this.f6316b = eVar2;
            this.f6317c = fVar;
            this.f6318d = bVar;
            this.f6319e = gVar;
            this.f6320f = unitedSchemeEntity;
            this.f6321g = callbackHandler;
            this.f6322h = str2;
            this.f6323i = context;
        }

        @Override // c.a.s0.a.f2.f.o0.g.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.s0.a.u1.i.d(this.a);
                c.a.s0.a.e0.d.i("navigateTo", "check pages success");
                n.F(true, this.f6316b.X().T());
                this.f6317c.o();
                a.e f2 = c.a.s0.a.h0.t.a.f(this.f6317c.getActivity(), c.a.s0.a.h0.t.f.a.c(this.f6318d.f7914e));
                c.a.s0.a.f2.f.o0.a.l(this.f6320f, this.f6321g, this.f6316b, f2.a.c(), this.f6318d.f7914e, c.a.s0.a.f2.f.o0.a.g(this.f6319e), this.f6322h);
                this.f6324j.p(f2, this.f6318d, this.f6319e, this.a);
            }
        }

        @Override // c.a.s0.a.f2.f.o0.g.e
        public void c(int i2, c.a.s0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                c.a.s0.a.e0.d.c("navigateTo", "check pages failed");
                n.F(false, this.f6316b.X().T());
                this.f6317c.o();
                if (z.f6443b) {
                    Context context = this.f6323i;
                    c.a.s0.a.c2.b.f.e.g(context, this.f6323i.getString(c.a.s0.a.h.aiapps_open_pages_failed) + i2).G();
                }
                c.a.s0.a.f2.f.o0.a.j(this.f6320f, this.f6321g, this.f6322h);
                c.a.s0.a.n2.i.j(this.f6318d, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6325b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.m1.b f6326c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.g.g f6327d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f6328e;

        public b(e eVar, a.e eVar2, String str, c.a.s0.a.m1.b bVar, c.a.s0.a.h0.g.g gVar) {
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
            this.f6328e = eVar;
            this.a = eVar2;
            this.f6325b = str;
            this.f6326c = bVar;
            this.f6327d = gVar;
        }

        @Override // c.a.s0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = z.f6443b;
                c.a.s0.a.u1.i.e(this.a, this.f6325b);
                this.f6328e.o(this.a.a, this.f6326c, this.f6327d, this.f6325b);
                boolean unused2 = z.f6443b;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-428334286, "Lc/a/s0/a/f2/f/o0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-428334286, "Lc/a/s0/a/f2/f/o0/e;");
                return;
            }
        }
        f6314d = c.a.s0.a.c1.a.g0().r();
        if (z.f6443b) {
            String str = "NavigateToAction max count: " + f6314d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.s0.a.f2.e eVar) {
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

    @Override // c.a.s0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f6443b) {
                r0 = "handle entity: " + unitedSchemeEntity.toString();
            }
            this.f6315c = context;
            String uuid = UUID.randomUUID().toString();
            c.a.s0.a.u1.i.b(uuid);
            String o = c.a.s0.a.f2.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.s0.a.e0.d.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.a.s0.a.g1.f U = c.a.s0.a.g1.f.U();
            c.a.s0.a.h0.g.g V = U.V();
            if (V == null) {
                c.a.s0.a.e0.d.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.s0.a.m1.b e2 = c.a.s0.a.m1.b.e(o, U.z());
            e2.f7918i = "0";
            e2.f7919j = uuid;
            c.a.s0.a.n2.i.g(e2);
            if (!q0.b(U.s(), e2, false)) {
                c.a.s0.a.e0.d.c("navigateTo", "page params error : path=" + e2.f7914e + " ; routePath=" + e2.f7917h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.s0.a.n2.i.i(e2);
                return false;
            }
            String n = c.a.s0.a.f2.f.o0.a.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(e2.f7917h) && c.a.s0.a.d2.e.L() != null) {
                c.a.s0.a.d2.e.L().K0(n, e2.f7917h);
            }
            String n2 = c.a.s0.a.f2.f.o0.a.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = c.a.s0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            boolean z = z.f6443b;
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.s0.a.e0.d.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.s0.a.n2.i.i(e2);
                return false;
            } else if (c.a.s0.a.f2.f.f0.d.b().a(e2)) {
                c.a.s0.a.f2.f.f0.d.b().i("navigateTo", e2);
                c.a.s0.a.e0.d.c("NavigateToAction", "access to this page is prohibited");
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

    public final void o(c.a.s0.a.p.e.b bVar, c.a.s0.a.m1.b bVar2, c.a.s0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.s0.a.g1.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.s0.a.f2.f.o0.a.e(bVar, bVar2, str);
        c.a.s0.a.u1.i.c(0, str);
        if (gVar.k() < f6314d) {
            c.a.s0.a.h0.g.f.M3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(c.a.s0.a.h0.g.g.f6641g, c.a.s0.a.h0.g.g.f6643i);
            i2.k("normal", bVar2).b();
            c.a.s0.a.z2.g.c(gVar, this.f6315c);
            c.a.s0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.s0.a.u1.i.a(str, bVar2);
            return;
        }
        c.a.s0.a.u.e.j.d.A(gVar, bVar2, str, true);
    }

    public final void p(a.e eVar, c.a.s0.a.m1.b bVar, c.a.s0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f7126b;
            HybridUbcFlow q = c.a.s0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (z.f6443b) {
                String str2 = "tryToExecutePageRoute start. isReady : " + z;
            }
            c.a.s0.a.h0.t.a.q(eVar, new b(this, eVar, str, bVar, gVar));
            boolean z2 = z.f6443b;
        }
    }
}
