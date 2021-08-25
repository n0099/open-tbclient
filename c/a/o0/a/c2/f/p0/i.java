package c.a.o0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.c2.f.p0.g;
import c.a.o0.a.h0.t.a;
import c.a.o0.a.v2.q0;
import c.a.o0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
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
public class i extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5019a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.g1.f f5020b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5021c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5022d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f5023e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5024f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.l1.b f5025g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5026h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a.d f5027i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.g.g f5028j;
        public final /* synthetic */ Context k;
        public final /* synthetic */ i l;

        public a(i iVar, String str, c.a.o0.a.g1.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, String str2, c.a.o0.a.l1.b bVar, String str3, a.d dVar, c.a.o0.a.h0.g.g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {iVar, str, fVar, unitedSchemeEntity, callbackHandler, eVar, str2, bVar, str3, dVar, gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = iVar;
            this.f5019a = str;
            this.f5020b = fVar;
            this.f5021c = unitedSchemeEntity;
            this.f5022d = callbackHandler;
            this.f5023e = eVar;
            this.f5024f = str2;
            this.f5025g = bVar;
            this.f5026h = str3;
            this.f5027i = dVar;
            this.f5028j = gVar;
            this.k = context;
        }

        @Override // c.a.o0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.o0.a.r1.i.d(this.f5019a);
                c.a.o0.a.e0.d.g("redirect", "check pages success");
                this.f5020b.o();
                c.a.o0.a.c2.f.p0.a.l(this.f5021c, this.f5022d, this.f5023e, this.f5024f, this.f5025g.f7208e, null, this.f5026h);
                this.l.n(this.f5027i, this.f5025g, this.f5028j, this.f5019a);
            }
        }

        @Override // c.a.o0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.o0.a.e0.d.b("redirect", "check pages failed");
                this.f5020b.o();
                if (a0.f4738b) {
                    Context context = this.k;
                    c.a.o0.a.z1.b.f.e.g(context, this.k.getString(c.a.o0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                c.a.o0.a.c2.f.p0.a.j(this.f5021c, this.f5022d, this.f5026h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f5029a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5030b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.l1.b f5031c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.g.g f5032d;

        public b(i iVar, a.d dVar, String str, c.a.o0.a.l1.b bVar, c.a.o0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, dVar, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5029a = dVar;
            this.f5030b = str;
            this.f5031c = bVar;
            this.f5032d = gVar;
        }

        @Override // c.a.o0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = a0.f4738b;
                c.a.o0.a.r1.i.e(this.f5029a, this.f5030b);
                c.a.o0.a.c2.f.p0.a.e(this.f5029a.f6409a, this.f5031c, this.f5030b);
                c.a.o0.a.u.e.k.c.u(this.f5032d, this.f5031c, this.f5030b, false);
                boolean unused2 = a0.f4738b;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/redirectTo");
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
                c.a.o0.a.e0.d.b("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.a.o0.a.g1.f V = c.a.o0.a.g1.f.V();
            c.a.o0.a.h0.g.g W = V.W();
            if (W == null) {
                c.a.o0.a.e0.d.b("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.o0.a.l1.b g2 = c.a.o0.a.l1.b.g(o, V.A());
            c.a.o0.a.j2.h.f(g2.f7208e, "2");
            if (!q0.b(V.s(), g2, false)) {
                c.a.o0.a.e0.d.b("redirect", "page params error : path=" + g2.f7208e + " ; routePath=" + g2.f7211h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && g2 != null && !TextUtils.isEmpty(g2.f7211h) && c.a.o0.a.a2.e.i() != null) {
                c.a.o0.a.a2.e.i().x0(str, g2.f7211h);
            }
            String n = c.a.o0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = c.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.C(ubcFlowEvent);
            }
            boolean z = a0.f4738b;
            a.d f2 = c.a.o0.a.h0.t.a.f(V.getActivity());
            String c2 = f2.f6409a.c();
            if (a0.f4738b) {
                String str2 = "webview id: " + c2;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.o0.a.e0.d.b("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (c.a.o0.a.c2.f.g0.d.b().a(g2)) {
                c.a.o0.a.c2.f.g0.d.b().i("redirectTo", g2);
                c.a.o0.a.e0.d.b("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                V.u();
                g.g(eVar, g2, c2, new a(this, uuid, V, unitedSchemeEntity, callbackHandler, eVar, c2, g2, optString, f2, W, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(a.d dVar, c.a.o0.a.l1.b bVar, c.a.o0.a.h0.g.g gVar, String str) {
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
