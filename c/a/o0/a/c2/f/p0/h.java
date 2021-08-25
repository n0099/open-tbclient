package c.a.o0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.c2.f.p0.g;
import c.a.o0.a.h0.t.a;
import c.a.o0.a.v2.q0;
import c.a.o0.a.v2.w;
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
        public final /* synthetic */ String f5005a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.g1.f f5006b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5007c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5008d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f5009e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5010f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.l1.b f5011g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5012h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a.d f5013i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.g.g f5014j;
        public final /* synthetic */ Context k;
        public final /* synthetic */ h l;

        public a(h hVar, String str, c.a.o0.a.g1.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, String str2, c.a.o0.a.l1.b bVar, String str3, a.d dVar, c.a.o0.a.h0.g.g gVar, Context context) {
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
            this.f5005a = str;
            this.f5006b = fVar;
            this.f5007c = unitedSchemeEntity;
            this.f5008d = callbackHandler;
            this.f5009e = eVar;
            this.f5010f = str2;
            this.f5011g = bVar;
            this.f5012h = str3;
            this.f5013i = dVar;
            this.f5014j = gVar;
            this.k = context;
        }

        @Override // c.a.o0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.o0.a.r1.i.d(this.f5005a);
                c.a.o0.a.e0.d.g("relaunch", "check pages success");
                this.f5006b.o();
                c.a.o0.a.c2.f.p0.a.l(this.f5007c, this.f5008d, this.f5009e, this.f5010f, this.f5011g.f7208e, null, this.f5012h);
                this.l.p(this.f5013i, this.f5011g, this.f5014j, this.f5005a);
            }
        }

        @Override // c.a.o0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.o0.a.e0.d.b("relaunch", "check pages failed");
                this.f5006b.o();
                if (a0.f4738b) {
                    Context context = this.k;
                    c.a.o0.a.z1.b.f.e.g(context, this.k.getString(c.a.o0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                c.a.o0.a.c2.f.p0.a.j(this.f5007c, this.f5008d, this.f5012h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f5015a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5016b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.l1.b f5017c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.g.g f5018d;

        public b(h hVar, a.d dVar, String str, c.a.o0.a.l1.b bVar, c.a.o0.a.h0.g.g gVar) {
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
            this.f5015a = dVar;
            this.f5016b = str;
            this.f5017c = bVar;
            this.f5018d = gVar;
        }

        @Override // c.a.o0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = a0.f4738b;
                c.a.o0.a.r1.i.e(this.f5015a, this.f5016b);
                c.a.o0.a.c2.f.p0.a.e(this.f5015a.f6409a, this.f5017c, this.f5016b);
                h.o(this.f5018d, this.f5017c, this.f5016b);
                boolean unused2 = a0.f4738b;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c.a.o0.a.c2.e eVar) {
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

    public static void o(c.a.o0.a.h0.g.g gVar, c.a.o0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, gVar, bVar, str) == null) {
            c.a.o0.a.u.e.k.d.t(gVar, bVar, str);
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
            String uuid = UUID.randomUUID().toString();
            c.a.o0.a.r1.i.b(uuid);
            String o = c.a.o0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.o0.a.e0.d.b("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.a.o0.a.g1.f V = c.a.o0.a.g1.f.V();
            c.a.o0.a.h0.g.g W = V.W();
            if (W == null) {
                c.a.o0.a.e0.d.b("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.o0.a.l1.b g2 = c.a.o0.a.l1.b.g(o, V.A());
            c.a.o0.a.j2.h.f(g2.f7208e, "3");
            if (!q0.b(V.s(), g2, true)) {
                c.a.o0.a.e0.d.b("relaunch", "page params error : path=" + g2.f7208e + " ; routePath=" + g2.f7211h);
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
            a.d g3 = c.a.o0.a.h0.t.a.g(V.getActivity(), true);
            String c2 = g3.f6409a.c();
            if (a0.f4738b) {
                String str = "webview idx: " + c2;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.o0.a.e0.d.b("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (c.a.o0.a.c2.f.g0.d.b().a(g2)) {
                c.a.o0.a.c2.f.g0.d.b().i("reLaunch", g2);
                c.a.o0.a.e0.d.b("ReLaunchAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                V.u();
                g.g(eVar, g2, c2, new a(this, uuid, V, unitedSchemeEntity, callbackHandler, eVar, c2, g2, optString, g3, W, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(a.d dVar, c.a.o0.a.l1.b bVar, c.a.o0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, bVar, gVar, str) == null) {
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
