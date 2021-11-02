package b.a.p0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.c2.f.p0.g;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.h0.t.a;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.w;
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
    public static final int f4372d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f4373c;

    /* loaded from: classes.dex */
    public class a implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4374a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f4375b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.g1.f f4376c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f4377d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4378e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4379f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4380g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l1.b f4381h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4382i;
        public final /* synthetic */ a.d j;
        public final /* synthetic */ Context k;
        public final /* synthetic */ e l;

        public a(e eVar, String str, b.a.p0.a.a2.e eVar2, b.a.p0.a.g1.f fVar, b.a.p0.a.h0.g.g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, b.a.p0.a.l1.b bVar, String str3, a.d dVar, Context context) {
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
            this.f4374a = str;
            this.f4375b = eVar2;
            this.f4376c = fVar;
            this.f4377d = gVar;
            this.f4378e = unitedSchemeEntity;
            this.f4379f = callbackHandler;
            this.f4380g = str2;
            this.f4381h = bVar;
            this.f4382i = str3;
            this.j = dVar;
            this.k = context;
        }

        @Override // b.a.p0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.r1.i.d(this.f4374a);
                b.a.p0.a.e0.d.g("navigateTo", "check pages success");
                b.a.p0.a.j2.k.B(true, this.f4375b.M().S());
                this.f4376c.n();
                b.a.p0.a.c2.f.p0.a.l(this.f4378e, this.f4379f, this.f4375b, this.f4380g, this.f4381h.f6555e, b.a.p0.a.c2.f.p0.a.g(this.f4377d), this.f4382i);
                this.l.p(this.j, this.f4381h, this.f4377d, this.f4374a);
            }
        }

        @Override // b.a.p0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                b.a.p0.a.e0.d.b("navigateTo", "check pages failed");
                b.a.p0.a.j2.k.B(false, this.f4375b.M().S());
                this.f4376c.n();
                if (a0.f4160b) {
                    Context context = this.k;
                    b.a.p0.a.z1.b.f.e.g(context, this.k.getString(b.a.p0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                b.a.p0.a.c2.f.p0.a.j(this.f4378e, this.f4379f, this.f4382i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f4383a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4384b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l1.b f4385c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f4386d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f4387e;

        public b(e eVar, a.d dVar, String str, b.a.p0.a.l1.b bVar, b.a.p0.a.h0.g.g gVar) {
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
            this.f4387e = eVar;
            this.f4383a = dVar;
            this.f4384b = str;
            this.f4385c = bVar;
            this.f4386d = gVar;
        }

        @Override // b.a.p0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = a0.f4160b;
                b.a.p0.a.r1.i.e(this.f4383a, this.f4384b);
                this.f4387e.o(this.f4383a.f5778a, this.f4385c, this.f4386d, this.f4384b);
                boolean unused2 = a0.f4160b;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(778913490, "Lb/a/p0/a/c2/f/p0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(778913490, "Lb/a/p0/a/c2/f/p0/e;");
                return;
            }
        }
        f4372d = b.a.p0.a.c1.a.Z().s();
        if (a0.f4160b) {
            String str = "NavigateToAction max count: " + f4372d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b.a.p0.a.c2.e eVar) {
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4160b) {
                r0 = "handle entity: " + unitedSchemeEntity.toString();
            }
            this.f4373c = context;
            String uuid = UUID.randomUUID().toString();
            b.a.p0.a.r1.i.b(uuid);
            String o = b.a.p0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                b.a.p0.a.e0.d.b("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            b.a.p0.a.g1.f T = b.a.p0.a.g1.f.T();
            b.a.p0.a.h0.g.g U = T.U();
            if (U == null) {
                b.a.p0.a.e0.d.b("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            b.a.p0.a.l1.b e2 = b.a.p0.a.l1.b.e(o, T.z());
            b.a.p0.a.j2.h.f(e2.f6555e, "0");
            if (!q0.b(T.r(), e2, false)) {
                b.a.p0.a.e0.d.b("navigateTo", "page params error : path=" + e2.f6555e + " ; routePath=" + e2.f6558h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String n = b.a.p0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && e2 != null && !TextUtils.isEmpty(e2.f6558h) && b.a.p0.a.a2.e.i() != null) {
                b.a.p0.a.a2.e.i().w0(n, e2.f6558h);
            }
            String n2 = b.a.p0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.C(ubcFlowEvent);
            }
            boolean z = a0.f4160b;
            a.d f2 = b.a.p0.a.h0.t.a.f(T.getActivity());
            String b2 = f2.f5778a.b();
            if (a0.f4160b) {
                String str = "slave webView id: " + b2;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.b("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (b.a.p0.a.c2.f.g0.d.b().a(e2)) {
                b.a.p0.a.c2.f.g0.d.b().i("navigateTo", e2);
                b.a.p0.a.e0.d.b("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                T.t();
                g.g(eVar, e2, b2, new a(this, uuid, eVar, T, U, unitedSchemeEntity, callbackHandler, b2, e2, optString, f2, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(b.a.p0.a.p.e.b bVar, b.a.p0.a.l1.b bVar2, b.a.p0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str) == null) || (activity = b.a.p0.a.g1.f.T().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        b.a.p0.a.c2.f.p0.a.e(bVar, bVar2, str);
        b.a.p0.a.r1.i.c(0, str);
        if (gVar.k() < f4372d) {
            b.a.p0.a.h0.g.f.y3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(b.a.p0.a.h0.g.g.f5280g, b.a.p0.a.h0.g.g.f5282i);
            i2.k("normal", bVar2).b();
            b.a.p0.a.v2.g.c(gVar, this.f4373c);
            b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            b.a.p0.a.r1.i.a(str, bVar2);
            return;
        }
        b.a.p0.a.u.e.k.c.t(gVar, bVar2, str, true);
    }

    public final void p(a.d dVar, b.a.p0.a.l1.b bVar, b.a.p0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f5779b;
            HybridUbcFlow q = b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (a0.f4160b) {
                String str2 = "tryToExecutePageRoute start. isReady : " + z;
            }
            b.a.p0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            boolean z2 = a0.f4160b;
        }
    }
}
