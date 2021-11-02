package b.a.p0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.c2.f.p0.g;
import b.a.p0.a.h0.t.a;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes.dex */
public class h extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4418a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.g1.f f4419b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4420c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4421d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f4422e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4423f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l1.b f4424g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4425h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a.d f4426i;
        public final /* synthetic */ b.a.p0.a.h0.g.g j;
        public final /* synthetic */ Context k;
        public final /* synthetic */ h l;

        public a(h hVar, String str, b.a.p0.a.g1.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, String str2, b.a.p0.a.l1.b bVar, String str3, a.d dVar, b.a.p0.a.h0.g.g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {hVar, str, fVar, unitedSchemeEntity, callbackHandler, eVar, str2, bVar, str3, dVar, gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = hVar;
            this.f4418a = str;
            this.f4419b = fVar;
            this.f4420c = unitedSchemeEntity;
            this.f4421d = callbackHandler;
            this.f4422e = eVar;
            this.f4423f = str2;
            this.f4424g = bVar;
            this.f4425h = str3;
            this.f4426i = dVar;
            this.j = gVar;
            this.k = context;
        }

        @Override // b.a.p0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.r1.i.d(this.f4418a);
                b.a.p0.a.e0.d.g("relaunch", "check pages success");
                this.f4419b.n();
                b.a.p0.a.c2.f.p0.a.l(this.f4420c, this.f4421d, this.f4422e, this.f4423f, this.f4424g.f6555e, null, this.f4425h);
                this.l.p(this.f4426i, this.f4424g, this.j, this.f4418a);
            }
        }

        @Override // b.a.p0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                b.a.p0.a.e0.d.b("relaunch", "check pages failed");
                this.f4419b.n();
                if (a0.f4160b) {
                    Context context = this.k;
                    b.a.p0.a.z1.b.f.e.g(context, this.k.getString(b.a.p0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                b.a.p0.a.c2.f.p0.a.j(this.f4420c, this.f4421d, this.f4425h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f4427a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4428b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l1.b f4429c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f4430d;

        public b(h hVar, a.d dVar, String str, b.a.p0.a.l1.b bVar, b.a.p0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, dVar, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4427a = dVar;
            this.f4428b = str;
            this.f4429c = bVar;
            this.f4430d = gVar;
        }

        @Override // b.a.p0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = a0.f4160b;
                b.a.p0.a.r1.i.e(this.f4427a, this.f4428b);
                b.a.p0.a.c2.f.p0.a.e(this.f4427a.f5778a, this.f4429c, this.f4428b);
                h.o(this.f4430d, this.f4429c, this.f4428b);
                boolean unused2 = a0.f4160b;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/reLaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void o(b.a.p0.a.h0.g.g gVar, b.a.p0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, gVar, bVar, str) == null) {
            b.a.p0.a.u.e.k.d.s(gVar, bVar, str);
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
            String uuid = UUID.randomUUID().toString();
            b.a.p0.a.r1.i.b(uuid);
            String o = b.a.p0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                b.a.p0.a.e0.d.b("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            b.a.p0.a.g1.f T = b.a.p0.a.g1.f.T();
            b.a.p0.a.h0.g.g U = T.U();
            if (U == null) {
                b.a.p0.a.e0.d.b("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            b.a.p0.a.l1.b e2 = b.a.p0.a.l1.b.e(o, T.z());
            b.a.p0.a.j2.h.f(e2.f6555e, "3");
            if (!q0.b(T.r(), e2, true)) {
                b.a.p0.a.e0.d.b("relaunch", "page params error : path=" + e2.f6555e + " ; routePath=" + e2.f6558h);
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
            a.d g2 = b.a.p0.a.h0.t.a.g(T.getActivity(), true);
            String b2 = g2.f5778a.b();
            if (a0.f4160b) {
                String str = "webview idx: " + b2;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.b("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (b.a.p0.a.c2.f.g0.d.b().a(e2)) {
                b.a.p0.a.c2.f.g0.d.b().i("reLaunch", e2);
                b.a.p0.a.e0.d.b("ReLaunchAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                T.t();
                g.g(eVar, e2, b2, new a(this, uuid, T, unitedSchemeEntity, callbackHandler, eVar, b2, e2, optString, g2, U, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(a.d dVar, b.a.p0.a.l1.b bVar, b.a.p0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, bVar, gVar, str) == null) {
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
