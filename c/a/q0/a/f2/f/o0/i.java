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
public class i extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.g1.f f5528b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.m1.b f5529c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5530d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5531e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.d2.e f5532f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5533g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.g.g f5534h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f5535i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ i f5536j;

        public a(i iVar, String str, c.a.q0.a.g1.f fVar, c.a.q0.a.m1.b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.q0.a.d2.e eVar, String str2, c.a.q0.a.h0.g.g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, fVar, bVar, unitedSchemeEntity, callbackHandler, eVar, str2, gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5536j = iVar;
            this.a = str;
            this.f5528b = fVar;
            this.f5529c = bVar;
            this.f5530d = unitedSchemeEntity;
            this.f5531e = callbackHandler;
            this.f5532f = eVar;
            this.f5533g = str2;
            this.f5534h = gVar;
            this.f5535i = context;
        }

        @Override // c.a.q0.a.f2.f.o0.g.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.q0.a.u1.i.d(this.a);
                c.a.q0.a.e0.d.i("redirect", "check pages success");
                this.f5528b.o();
                a.e f2 = c.a.q0.a.h0.t.a.f(this.f5528b.getActivity(), c.a.q0.a.h0.t.f.a.c(this.f5529c.f7108e));
                c.a.q0.a.f2.f.o0.a.l(this.f5530d, this.f5531e, this.f5532f, f2.a.c(), this.f5529c.f7108e, null, this.f5533g);
                this.f5536j.n(f2, this.f5529c, this.f5534h, this.a);
            }
        }

        @Override // c.a.q0.a.f2.f.o0.g.e
        public void b(int i2, c.a.q0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                c.a.q0.a.e0.d.c("redirect", "check pages failed");
                this.f5528b.o();
                if (z.f5605b) {
                    Context context = this.f5535i;
                    c.a.q0.a.c2.b.f.e.g(context, this.f5535i.getString(c.a.q0.a.h.aiapps_open_pages_failed) + i2).G();
                }
                c.a.q0.a.f2.f.o0.a.j(this.f5530d, this.f5531e, this.f5533g);
                c.a.q0.a.n2.i.j(this.f5529c, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5537b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.m1.b f5538c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.g.g f5539d;

        public b(i iVar, a.e eVar, String str, c.a.q0.a.m1.b bVar, c.a.q0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, eVar, str, bVar, gVar};
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
            this.f5537b = str;
            this.f5538c = bVar;
            this.f5539d = gVar;
        }

        @Override // c.a.q0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = z.f5605b;
                c.a.q0.a.u1.i.e(this.a, this.f5537b);
                c.a.q0.a.f2.f.o0.a.e(this.a.a, this.f5538c, this.f5537b);
                c.a.q0.a.u.e.j.d.A(this.f5539d, this.f5538c, this.f5537b, false);
                boolean unused2 = z.f5605b;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.q0.a.f2.e eVar) {
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
                c.a.q0.a.e0.d.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.a.q0.a.g1.f U = c.a.q0.a.g1.f.U();
            c.a.q0.a.h0.g.g V = U.V();
            if (V == null) {
                c.a.q0.a.e0.d.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.q0.a.m1.b e2 = c.a.q0.a.m1.b.e(o, U.z());
            e2.f7112i = "2";
            e2.f7113j = uuid;
            c.a.q0.a.n2.i.g(e2);
            if (!q0.b(U.s(), e2, false)) {
                c.a.q0.a.e0.d.c("redirect", "page params error : path=" + e2.f7108e + " ; routePath=" + e2.f7111h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.q0.a.n2.i.i(e2);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(e2.f7111h) && c.a.q0.a.d2.e.L() != null) {
                c.a.q0.a.d2.e.L().K0(str, e2.f7111h);
            }
            String n = c.a.q0.a.f2.f.o0.a.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = c.a.q0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            boolean z = z.f5605b;
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.q0.a.e0.d.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.q0.a.n2.i.i(e2);
                return false;
            } else if (c.a.q0.a.f2.f.f0.d.b().a(e2)) {
                c.a.q0.a.f2.f.f0.d.b().i("redirectTo", e2);
                c.a.q0.a.e0.d.c("redirectTo", "access to this page is prohibited");
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

    public final void n(a.e eVar, c.a.q0.a.m1.b bVar, c.a.q0.a.h0.g.g gVar, String str) {
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
