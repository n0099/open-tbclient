package c.a.q0.a.f2.f.o0;

import android.content.Context;
import android.text.TextUtils;
import c.a.q0.a.f2.f.o0.g;
import c.a.q0.a.f2.f.z;
import c.a.q0.a.h0.t.a;
import c.a.q0.a.z2.q0;
import c.a.q0.a.z2.w;
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
public class h extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.g1.f f5516b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.m1.b f5517c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5518d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5519e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.d2.e f5520f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5521g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.g.g f5522h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f5523i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ h f5524j;

        public a(h hVar, String str, c.a.q0.a.g1.f fVar, c.a.q0.a.m1.b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.q0.a.d2.e eVar, String str2, c.a.q0.a.h0.g.g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, fVar, bVar, unitedSchemeEntity, callbackHandler, eVar, str2, gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5524j = hVar;
            this.a = str;
            this.f5516b = fVar;
            this.f5517c = bVar;
            this.f5518d = unitedSchemeEntity;
            this.f5519e = callbackHandler;
            this.f5520f = eVar;
            this.f5521g = str2;
            this.f5522h = gVar;
            this.f5523i = context;
        }

        @Override // c.a.q0.a.f2.f.o0.g.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.q0.a.u1.i.d(this.a);
                c.a.q0.a.e0.d.i("relaunch", "check pages success");
                this.f5516b.o();
                a.e f2 = c.a.q0.a.h0.t.a.f(this.f5516b.getActivity(), c.a.q0.a.h0.t.f.a.c(this.f5517c.f7108e));
                c.a.q0.a.f2.f.o0.a.l(this.f5518d, this.f5519e, this.f5520f, f2.a.c(), this.f5517c.f7108e, null, this.f5521g);
                this.f5524j.p(f2, this.f5517c, this.f5522h, this.a);
            }
        }

        @Override // c.a.q0.a.f2.f.o0.g.e
        public void b(int i2, c.a.q0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                c.a.q0.a.e0.d.c("relaunch", "check pages failed");
                this.f5516b.o();
                if (z.f5605b) {
                    Context context = this.f5523i;
                    c.a.q0.a.c2.b.f.e.g(context, this.f5523i.getString(c.a.q0.a.h.aiapps_open_pages_failed) + i2).G();
                }
                c.a.q0.a.f2.f.o0.a.j(this.f5518d, this.f5519e, this.f5521g);
                c.a.q0.a.n2.i.j(this.f5517c, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5525b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.m1.b f5526c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.g.g f5527d;

        public b(h hVar, a.e eVar, String str, c.a.q0.a.m1.b bVar, c.a.q0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, eVar, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.f5525b = str;
            this.f5526c = bVar;
            this.f5527d = gVar;
        }

        @Override // c.a.q0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = z.f5605b;
                c.a.q0.a.u1.i.e(this.a, this.f5525b);
                c.a.q0.a.f2.f.o0.a.e(this.a.a, this.f5526c, this.f5525b);
                h.o(this.f5527d, this.f5526c, this.f5525b);
                boolean unused2 = z.f5605b;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c.a.q0.a.f2.e eVar) {
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

    public static void o(c.a.q0.a.h0.g.g gVar, c.a.q0.a.m1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, gVar, bVar, str) == null) {
            c.a.q0.a.u.e.j.e.y(gVar, bVar, str);
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
            String uuid = UUID.randomUUID().toString();
            c.a.q0.a.u1.i.b(uuid);
            String o = c.a.q0.a.f2.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.q0.a.e0.d.c("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.a.q0.a.g1.f U = c.a.q0.a.g1.f.U();
            c.a.q0.a.h0.g.g V = U.V();
            if (V == null) {
                c.a.q0.a.e0.d.c("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.q0.a.m1.b e2 = c.a.q0.a.m1.b.e(o, U.z());
            e2.f7112i = "3";
            e2.f7113j = uuid;
            c.a.q0.a.n2.i.g(e2);
            if (!q0.b(U.s(), e2, true)) {
                c.a.q0.a.e0.d.c("relaunch", "page params error : path=" + e2.f7108e + " ; routePath=" + e2.f7111h);
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
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.q0.a.e0.d.c("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.q0.a.n2.i.i(e2);
                return false;
            } else if (c.a.q0.a.f2.f.f0.d.b().a(e2)) {
                c.a.q0.a.f2.f.f0.d.b().i("reLaunch", e2);
                c.a.q0.a.e0.d.c("ReLaunchAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                g.g(eVar, e2, "", new a(this, uuid, U, e2, unitedSchemeEntity, callbackHandler, eVar, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(a.e eVar, c.a.q0.a.m1.b bVar, c.a.q0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, bVar, gVar, str) == null) {
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
