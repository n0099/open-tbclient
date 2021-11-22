package b.a.p0.a.f2.f.o0;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.f2.f.o0.g;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.h0.t.a;
import b.a.p0.a.n2.n;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.w;
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
    public static final int f5089d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f5090c;

    /* loaded from: classes.dex */
    public class a implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5091a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f5092b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.g1.f f5093c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f5094d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f5095e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5096f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5097g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5098h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f5099i;
        public final /* synthetic */ e j;

        public a(e eVar, String str, b.a.p0.a.d2.e eVar2, b.a.p0.a.g1.f fVar, b.a.p0.a.m1.b bVar, b.a.p0.a.h0.g.g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
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
            this.j = eVar;
            this.f5091a = str;
            this.f5092b = eVar2;
            this.f5093c = fVar;
            this.f5094d = bVar;
            this.f5095e = gVar;
            this.f5096f = unitedSchemeEntity;
            this.f5097g = callbackHandler;
            this.f5098h = str2;
            this.f5099i = context;
        }

        @Override // b.a.p0.a.f2.f.o0.g.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.u1.i.d(this.f5091a);
                b.a.p0.a.e0.d.i("navigateTo", "check pages success");
                n.F(true, this.f5092b.X().T());
                this.f5093c.n();
                a.e f2 = b.a.p0.a.h0.t.a.f(this.f5093c.getActivity(), b.a.p0.a.h0.t.f.a.c(this.f5094d.f7014e));
                b.a.p0.a.f2.f.o0.a.l(this.f5096f, this.f5097g, this.f5092b, f2.f6108a.c(), this.f5094d.f7014e, b.a.p0.a.f2.f.o0.a.g(this.f5095e), this.f5098h);
                this.j.p(f2, this.f5094d, this.f5095e, this.f5091a);
            }
        }

        @Override // b.a.p0.a.f2.f.o0.g.e
        public void b(int i2, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                b.a.p0.a.e0.d.c("navigateTo", "check pages failed");
                n.F(false, this.f5092b.X().T());
                this.f5093c.n();
                if (z.f5228b) {
                    Context context = this.f5099i;
                    b.a.p0.a.c2.b.f.e.g(context, this.f5099i.getString(b.a.p0.a.h.aiapps_open_pages_failed) + i2).G();
                }
                b.a.p0.a.f2.f.o0.a.j(this.f5096f, this.f5097g, this.f5098h);
                b.a.p0.a.n2.i.j(this.f5094d, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.e f5100a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5101b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f5102c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f5103d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5104e;

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
            this.f5104e = eVar;
            this.f5100a = eVar2;
            this.f5101b = str;
            this.f5102c = bVar;
            this.f5103d = gVar;
        }

        @Override // b.a.p0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = z.f5228b;
                b.a.p0.a.u1.i.e(this.f5100a, this.f5101b);
                this.f5104e.o(this.f5100a.f6108a, this.f5102c, this.f5103d, this.f5101b);
                boolean unused2 = z.f5228b;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(188449454, "Lb/a/p0/a/f2/f/o0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(188449454, "Lb/a/p0/a/f2/f/o0/e;");
                return;
            }
        }
        f5089d = b.a.p0.a.c1.a.g0().r();
        if (z.f5228b) {
            String str = "NavigateToAction max count: " + f5089d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b.a.p0.a.f2.e eVar) {
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

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f5228b) {
                r0 = "handle entity: " + unitedSchemeEntity.toString();
            }
            this.f5090c = context;
            String uuid = UUID.randomUUID().toString();
            b.a.p0.a.u1.i.b(uuid);
            String o = b.a.p0.a.f2.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                b.a.p0.a.e0.d.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            b.a.p0.a.g1.f U = b.a.p0.a.g1.f.U();
            b.a.p0.a.h0.g.g V = U.V();
            if (V == null) {
                b.a.p0.a.e0.d.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            b.a.p0.a.m1.b e2 = b.a.p0.a.m1.b.e(o, U.z());
            e2.f7018i = "0";
            e2.j = uuid;
            b.a.p0.a.n2.i.g(e2);
            if (!q0.b(U.r(), e2, false)) {
                b.a.p0.a.e0.d.c("navigateTo", "page params error : path=" + e2.f7014e + " ; routePath=" + e2.f7017h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                b.a.p0.a.n2.i.i(e2);
                return false;
            }
            String n = b.a.p0.a.f2.f.o0.a.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(e2.f7017h) && b.a.p0.a.d2.e.L() != null) {
                b.a.p0.a.d2.e.L().K0(n, e2.f7017h);
            }
            String n2 = b.a.p0.a.f2.f.o0.a.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = b.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            boolean z = z.f5228b;
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                b.a.p0.a.n2.i.i(e2);
                return false;
            } else if (b.a.p0.a.f2.f.f0.d.b().a(e2)) {
                b.a.p0.a.f2.f.f0.d.b().i("navigateTo", e2);
                b.a.p0.a.e0.d.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.t();
                g.g(eVar, e2, "", new a(this, uuid, eVar, U, e2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(b.a.p0.a.p.e.b bVar, b.a.p0.a.m1.b bVar2, b.a.p0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str) == null) || (activity = b.a.p0.a.g1.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        b.a.p0.a.f2.f.o0.a.e(bVar, bVar2, str);
        b.a.p0.a.u1.i.c(0, str);
        if (gVar.k() < f5089d) {
            b.a.p0.a.h0.g.f.P3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(b.a.p0.a.h0.g.g.f5478g, b.a.p0.a.h0.g.g.f5480i);
            i2.k("normal", bVar2).b();
            b.a.p0.a.z2.g.c(gVar, this.f5090c);
            b.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            b.a.p0.a.u1.i.a(str, bVar2);
            return;
        }
        b.a.p0.a.u.e.j.d.A(gVar, bVar2, str, true);
    }

    public final void p(a.e eVar, b.a.p0.a.m1.b bVar, b.a.p0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f6109b;
            HybridUbcFlow q = b.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (z.f5228b) {
                String str2 = "tryToExecutePageRoute start. isReady : " + z;
            }
            b.a.p0.a.h0.t.a.q(eVar, new b(this, eVar, str, bVar, gVar));
            boolean z2 = z.f5228b;
        }
    }
}
