package c.a.n0.a.v1.f.o0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.d2.n;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.w;
import c.a.n0.a.v1.f.o0.g;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x.g.g;
import c.a.n0.a.x.t.a;
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
import java.util.UUID;
@Deprecated
/* loaded from: classes.dex */
public class e extends z {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int f6817d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f6818c;

    /* loaded from: classes.dex */
    public class a implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f6819b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.w0.f f6820c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f6821d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.g.g f6822e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6823f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6824g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6825h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ e j;

        public a(e eVar, String str, c.a.n0.a.t1.e eVar2, c.a.n0.a.w0.f fVar, c.a.n0.a.c1.b bVar, c.a.n0.a.x.g.g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, eVar2, fVar, bVar, gVar, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = eVar;
            this.a = str;
            this.f6819b = eVar2;
            this.f6820c = fVar;
            this.f6821d = bVar;
            this.f6822e = gVar;
            this.f6823f = unitedSchemeEntity;
            this.f6824g = callbackHandler;
            this.f6825h = str2;
            this.i = context;
        }

        @Override // c.a.n0.a.v1.f.o0.g.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.n0.a.k1.i.d(this.a);
                c.a.n0.a.u.d.i("navigateTo", "check pages success");
                n.F(true, this.f6819b.X().T());
                this.f6820c.o();
                a.e f2 = c.a.n0.a.x.t.a.f(this.f6820c.getActivity(), c.a.n0.a.x.t.f.a.c(this.f6821d.a));
                c.a.n0.a.v1.f.o0.a.l(this.f6823f, this.f6824g, this.f6819b, f2.a.c(), this.f6821d.a, c.a.n0.a.v1.f.o0.a.g(this.f6822e), this.f6825h);
                this.j.p(f2, this.f6821d, this.f6822e, this.a);
            }
        }

        @Override // c.a.n0.a.v1.f.o0.g.e
        public void c(int i, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, aVar) == null) {
                c.a.n0.a.u.d.c("navigateTo", "check pages failed");
                n.F(false, this.f6819b.X().T());
                this.f6820c.o();
                if (z.f6924b) {
                    Context context = this.i;
                    c.a.n0.a.s1.b.f.e.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f019d) + i).G();
                }
                c.a.n0.a.v1.f.o0.a.j(this.f6823f, this.f6824g, this.f6825h);
                c.a.n0.a.d2.i.j(this.f6821d, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6826b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f6827c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.g.g f6828d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f6829e;

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
            this.f6829e = eVar;
            this.a = eVar2;
            this.f6826b = str;
            this.f6827c = bVar;
            this.f6828d = gVar;
        }

        @Override // c.a.n0.a.x.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (z.f6924b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                c.a.n0.a.k1.i.e(this.a, this.f6826b);
                this.f6829e.o(this.a.a, this.f6827c, this.f6828d, this.f6826b);
                if (z.f6924b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-712920356, "Lc/a/n0/a/v1/f/o0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-712920356, "Lc/a/n0/a/v1/f/o0/e;");
                return;
            }
        }
        f6817d = c.a.n0.a.s0.a.g0().r();
        if (z.f6924b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + f6817d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f6924b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.f6818c = context;
            String uuid = UUID.randomUUID().toString();
            c.a.n0.a.k1.i.b(uuid);
            String o = c.a.n0.a.v1.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.n0.a.u.d.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
            c.a.n0.a.x.g.g V = U.V();
            if (V == null) {
                c.a.n0.a.u.d.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.n0.a.c1.b d2 = c.a.n0.a.c1.b.d(o, U.z());
            d2.f3950e = "0";
            d2.f3951f = uuid;
            c.a.n0.a.d2.i.g(d2);
            if (!q0.b(U.s(), d2, false)) {
                c.a.n0.a.u.d.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.f3949d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.n0.a.d2.i.i(d2);
                return false;
            }
            String n = c.a.n0.a.v1.f.o0.a.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.f3949d) && c.a.n0.a.t1.e.L() != null) {
                c.a.n0.a.t1.e.L().K0(n, d2.f3949d);
            }
            String n2 = c.a.n0.a.v1.f.o0.a.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = c.a.n0.a.k1.h.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (z.f6924b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.n0.a.u.d.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.n0.a.d2.i.i(d2);
                return false;
            } else if (c.a.n0.a.v1.f.f0.d.b().a(d2)) {
                c.a.n0.a.v1.f.f0.d.b().i("navigateTo", d2);
                c.a.n0.a.u.d.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                g.g(eVar, d2, "", new a(this, uuid, eVar, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(c.a.n0.a.f.e.b bVar, c.a.n0.a.c1.b bVar2, c.a.n0.a.x.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.n0.a.w0.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.n0.a.v1.f.o0.a.e(bVar, bVar2, str);
        c.a.n0.a.k1.i.c(0, str);
        if (gVar.k() < f6817d) {
            c.a.n0.a.x.g.f.Q3(q0.n());
            g.b i = gVar.i("navigateTo");
            i.n(c.a.n0.a.x.g.g.f7048g, c.a.n0.a.x.g.g.i);
            i.k("normal", bVar2).b();
            c.a.n0.a.p2.g.c(gVar, this.f6818c);
            c.a.n0.a.k1.h.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.n0.a.k1.i.a(str, bVar2);
            return;
        }
        c.a.n0.a.k.e.j.d.A(gVar, bVar2, str, true);
    }

    public final void p(a.e eVar, c.a.n0.a.c1.b bVar, c.a.n0.a.x.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f7448b;
            HybridUbcFlow q = c.a.n0.a.k1.h.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (z.f6924b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            c.a.n0.a.x.t.a.q(eVar, new b(this, eVar, str, bVar, gVar));
            if (z.f6924b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
