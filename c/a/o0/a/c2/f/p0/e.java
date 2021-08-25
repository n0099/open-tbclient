package c.a.o0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.c2.f.p0.g;
import c.a.o0.a.h0.g.g;
import c.a.o0.a.h0.t.a;
import c.a.o0.a.v2.q0;
import c.a.o0.a.v2.w;
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
public class e extends a0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int f4958d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f4959c;

    /* loaded from: classes.dex */
    public class a implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4960a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f4961b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.g1.f f4962c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.g.g f4963d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4964e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4965f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4966g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.l1.b f4967h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4968i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a.d f4969j;
        public final /* synthetic */ Context k;
        public final /* synthetic */ e l;

        public a(e eVar, String str, c.a.o0.a.a2.e eVar2, c.a.o0.a.g1.f fVar, c.a.o0.a.h0.g.g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, c.a.o0.a.l1.b bVar, String str3, a.d dVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {eVar, str, eVar2, fVar, gVar, unitedSchemeEntity, callbackHandler, str2, bVar, str3, dVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = eVar;
            this.f4960a = str;
            this.f4961b = eVar2;
            this.f4962c = fVar;
            this.f4963d = gVar;
            this.f4964e = unitedSchemeEntity;
            this.f4965f = callbackHandler;
            this.f4966g = str2;
            this.f4967h = bVar;
            this.f4968i = str3;
            this.f4969j = dVar;
            this.k = context;
        }

        @Override // c.a.o0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.o0.a.r1.i.d(this.f4960a);
                c.a.o0.a.e0.d.g("navigateTo", "check pages success");
                c.a.o0.a.j2.k.B(true, this.f4961b.N().T());
                this.f4962c.o();
                c.a.o0.a.c2.f.p0.a.l(this.f4964e, this.f4965f, this.f4961b, this.f4966g, this.f4967h.f7208e, c.a.o0.a.c2.f.p0.a.g(this.f4963d), this.f4968i);
                this.l.p(this.f4969j, this.f4967h, this.f4963d, this.f4960a);
            }
        }

        @Override // c.a.o0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.o0.a.e0.d.b("navigateTo", "check pages failed");
                c.a.o0.a.j2.k.B(false, this.f4961b.N().T());
                this.f4962c.o();
                if (a0.f4738b) {
                    Context context = this.k;
                    c.a.o0.a.z1.b.f.e.g(context, this.k.getString(c.a.o0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                c.a.o0.a.c2.f.p0.a.j(this.f4964e, this.f4965f, this.f4968i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f4970a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4971b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.l1.b f4972c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.g.g f4973d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f4974e;

        public b(e eVar, a.d dVar, String str, c.a.o0.a.l1.b bVar, c.a.o0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, dVar, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4974e = eVar;
            this.f4970a = dVar;
            this.f4971b = str;
            this.f4972c = bVar;
            this.f4973d = gVar;
        }

        @Override // c.a.o0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = a0.f4738b;
                c.a.o0.a.r1.i.e(this.f4970a, this.f4971b);
                this.f4974e.o(this.f4970a.f6409a, this.f4972c, this.f4973d, this.f4971b);
                boolean unused2 = a0.f4738b;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1573110190, "Lc/a/o0/a/c2/f/p0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1573110190, "Lc/a/o0/a/c2/f/p0/e;");
                return;
            }
        }
        f4958d = c.a.o0.a.c1.a.Z().s();
        if (a0.f4738b) {
            String str = "NavigateToAction max count: " + f4958d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.o0.a.c2.e eVar) {
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

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4738b) {
                r0 = "handle entity: " + unitedSchemeEntity.toString();
            }
            this.f4959c = context;
            String uuid = UUID.randomUUID().toString();
            c.a.o0.a.r1.i.b(uuid);
            String o = c.a.o0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.o0.a.e0.d.b("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.a.o0.a.g1.f V = c.a.o0.a.g1.f.V();
            c.a.o0.a.h0.g.g W = V.W();
            if (W == null) {
                c.a.o0.a.e0.d.b("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.o0.a.l1.b g2 = c.a.o0.a.l1.b.g(o, V.A());
            c.a.o0.a.j2.h.f(g2.f7208e, "0");
            if (!q0.b(V.s(), g2, false)) {
                c.a.o0.a.e0.d.b("navigateTo", "page params error : path=" + g2.f7208e + " ; routePath=" + g2.f7211h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String n = c.a.o0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && g2 != null && !TextUtils.isEmpty(g2.f7211h) && c.a.o0.a.a2.e.i() != null) {
                c.a.o0.a.a2.e.i().x0(n, g2.f7211h);
            }
            String n2 = c.a.o0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = c.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.C(ubcFlowEvent);
            }
            boolean z = a0.f4738b;
            a.d f2 = c.a.o0.a.h0.t.a.f(V.getActivity());
            String c2 = f2.f6409a.c();
            if (a0.f4738b) {
                String str = "slave webView id: " + c2;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.o0.a.e0.d.b("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (c.a.o0.a.c2.f.g0.d.b().a(g2)) {
                c.a.o0.a.c2.f.g0.d.b().i("navigateTo", g2);
                c.a.o0.a.e0.d.b("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                V.u();
                g.g(eVar, g2, c2, new a(this, uuid, eVar, V, W, unitedSchemeEntity, callbackHandler, c2, g2, optString, f2, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(c.a.o0.a.p.e.b bVar, c.a.o0.a.l1.b bVar2, c.a.o0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.o0.a.g1.f.V().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.o0.a.c2.f.p0.a.e(bVar, bVar2, str);
        c.a.o0.a.r1.i.c(0, str);
        if (gVar.k() < f4958d) {
            c.a.o0.a.h0.g.f.C3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(c.a.o0.a.h0.g.g.f5900g, c.a.o0.a.h0.g.g.f5902i);
            i2.k("normal", bVar2).b();
            c.a.o0.a.v2.g.c(gVar, this.f4959c);
            c.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            c.a.o0.a.r1.i.a(str, bVar2);
            return;
        }
        c.a.o0.a.u.e.k.c.u(gVar, bVar2, str, true);
    }

    public final void p(a.d dVar, c.a.o0.a.l1.b bVar, c.a.o0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f6410b;
            HybridUbcFlow q = c.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (a0.f4738b) {
                String str2 = "tryToExecutePageRoute start. isReady : " + z;
            }
            c.a.o0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            boolean z2 = a0.f4738b;
        }
    }
}
