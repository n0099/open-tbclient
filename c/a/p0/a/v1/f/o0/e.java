package c.a.p0.a.v1.f.o0;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.d2.n;
import c.a.p0.a.p2.q0;
import c.a.p0.a.p2.w;
import c.a.p0.a.v1.f.o0.g;
import c.a.p0.a.v1.f.z;
import c.a.p0.a.x.g.g;
import c.a.p0.a.x.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.R;
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
    public static final int f8047d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f8048c;

    /* loaded from: classes.dex */
    public class a implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f8049b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.w0.f f8050c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f8051d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.g f8052e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f8053f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8054g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8055h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f8056i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8057j;

        public a(e eVar, String str, c.a.p0.a.t1.e eVar2, c.a.p0.a.w0.f fVar, c.a.p0.a.c1.b bVar, c.a.p0.a.x.g.g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
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
            this.f8057j = eVar;
            this.a = str;
            this.f8049b = eVar2;
            this.f8050c = fVar;
            this.f8051d = bVar;
            this.f8052e = gVar;
            this.f8053f = unitedSchemeEntity;
            this.f8054g = callbackHandler;
            this.f8055h = str2;
            this.f8056i = context;
        }

        @Override // c.a.p0.a.v1.f.o0.g.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.k1.i.d(this.a);
                c.a.p0.a.u.d.i("navigateTo", "check pages success");
                n.F(true, this.f8049b.X().T());
                this.f8050c.o();
                a.e f2 = c.a.p0.a.x.t.a.f(this.f8050c.getActivity(), c.a.p0.a.x.t.f.a.c(this.f8051d.f4642e));
                c.a.p0.a.v1.f.o0.a.l(this.f8053f, this.f8054g, this.f8049b, f2.a.c(), this.f8051d.f4642e, c.a.p0.a.v1.f.o0.a.g(this.f8052e), this.f8055h);
                this.f8057j.p(f2, this.f8051d, this.f8052e, this.a);
            }
        }

        @Override // c.a.p0.a.v1.f.o0.g.e
        public void c(int i2, c.a.p0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                c.a.p0.a.u.d.c("navigateTo", "check pages failed");
                n.F(false, this.f8049b.X().T());
                this.f8050c.o();
                if (z.f8176b) {
                    Context context = this.f8056i;
                    c.a.p0.a.s1.b.f.e.g(context, this.f8056i.getString(R.string.aiapps_open_pages_failed) + i2).G();
                }
                c.a.p0.a.v1.f.o0.a.j(this.f8053f, this.f8054g, this.f8055h);
                c.a.p0.a.d2.i.j(this.f8051d, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8058b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f8059c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.g f8060d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f8061e;

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
            this.f8061e = eVar;
            this.a = eVar2;
            this.f8058b = str;
            this.f8059c = bVar;
            this.f8060d = gVar;
        }

        @Override // c.a.p0.a.x.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = z.f8176b;
                c.a.p0.a.k1.i.e(this.a, this.f8058b);
                this.f8061e.o(this.a.a, this.f8059c, this.f8060d, this.f8058b);
                boolean unused2 = z.f8176b;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1992784034, "Lc/a/p0/a/v1/f/o0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1992784034, "Lc/a/p0/a/v1/f/o0/e;");
                return;
            }
        }
        f8047d = c.a.p0.a.s0.a.g0().r();
        if (z.f8176b) {
            String str = "NavigateToAction max count: " + f8047d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.p0.a.v1.e eVar) {
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

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f8176b) {
                r0 = "handle entity: " + unitedSchemeEntity.toString();
            }
            this.f8048c = context;
            String uuid = UUID.randomUUID().toString();
            c.a.p0.a.k1.i.b(uuid);
            String o = c.a.p0.a.v1.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.p0.a.u.d.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.a.p0.a.w0.f U = c.a.p0.a.w0.f.U();
            c.a.p0.a.x.g.g V = U.V();
            if (V == null) {
                c.a.p0.a.u.d.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.p0.a.c1.b e2 = c.a.p0.a.c1.b.e(o, U.z());
            e2.f4646i = "0";
            e2.f4647j = uuid;
            c.a.p0.a.d2.i.g(e2);
            if (!q0.b(U.s(), e2, false)) {
                c.a.p0.a.u.d.c("navigateTo", "page params error : path=" + e2.f4642e + " ; routePath=" + e2.f4645h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.p0.a.d2.i.i(e2);
                return false;
            }
            String n = c.a.p0.a.v1.f.o0.a.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(e2.f4645h) && c.a.p0.a.t1.e.L() != null) {
                c.a.p0.a.t1.e.L().K0(n, e2.f4645h);
            }
            String n2 = c.a.p0.a.v1.f.o0.a.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            boolean z = z.f8176b;
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.p0.a.u.d.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.p0.a.d2.i.i(e2);
                return false;
            } else if (c.a.p0.a.v1.f.f0.d.b().a(e2)) {
                c.a.p0.a.v1.f.f0.d.b().i("navigateTo", e2);
                c.a.p0.a.u.d.c("NavigateToAction", "access to this page is prohibited");
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

    public final void o(c.a.p0.a.f.e.b bVar, c.a.p0.a.c1.b bVar2, c.a.p0.a.x.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.p0.a.w0.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.p0.a.v1.f.o0.a.e(bVar, bVar2, str);
        c.a.p0.a.k1.i.c(0, str);
        if (gVar.k() < f8047d) {
            c.a.p0.a.x.g.f.M3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(c.a.p0.a.x.g.g.f8374g, c.a.p0.a.x.g.g.f8376i);
            i2.k("normal", bVar2).b();
            c.a.p0.a.p2.g.c(gVar, this.f8048c);
            c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.p0.a.k1.i.a(str, bVar2);
            return;
        }
        c.a.p0.a.k.e.j.d.A(gVar, bVar2, str, true);
    }

    public final void p(a.e eVar, c.a.p0.a.c1.b bVar, c.a.p0.a.x.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f8859b;
            HybridUbcFlow q = c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (z.f8176b) {
                String str2 = "tryToExecutePageRoute start. isReady : " + z;
            }
            c.a.p0.a.x.t.a.q(eVar, new b(this, eVar, str, bVar, gVar));
            boolean z2 = z.f8176b;
        }
    }
}
