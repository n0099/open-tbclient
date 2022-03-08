package c.a.p0.a.v1.f.o0;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.p2.q0;
import c.a.p0.a.p2.w;
import c.a.p0.a.v1.f.o0.g;
import c.a.p0.a.v1.f.z;
import c.a.p0.a.x.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.R;
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
        public final /* synthetic */ c.a.p0.a.w0.f f8099b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f8100c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f8101d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8102e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f8103f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8104g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.g f8105h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f8106i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ i f8107j;

        public a(i iVar, String str, c.a.p0.a.w0.f fVar, c.a.p0.a.c1.b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, String str2, c.a.p0.a.x.g.g gVar, Context context) {
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
            this.f8107j = iVar;
            this.a = str;
            this.f8099b = fVar;
            this.f8100c = bVar;
            this.f8101d = unitedSchemeEntity;
            this.f8102e = callbackHandler;
            this.f8103f = eVar;
            this.f8104g = str2;
            this.f8105h = gVar;
            this.f8106i = context;
        }

        @Override // c.a.p0.a.v1.f.o0.g.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.k1.i.d(this.a);
                c.a.p0.a.u.d.i("redirect", "check pages success");
                this.f8099b.o();
                a.e f2 = c.a.p0.a.x.t.a.f(this.f8099b.getActivity(), c.a.p0.a.x.t.f.a.c(this.f8100c.f4642e));
                c.a.p0.a.v1.f.o0.a.l(this.f8101d, this.f8102e, this.f8103f, f2.a.c(), this.f8100c.f4642e, null, this.f8104g);
                this.f8107j.n(f2, this.f8100c, this.f8105h, this.a);
            }
        }

        @Override // c.a.p0.a.v1.f.o0.g.e
        public void c(int i2, c.a.p0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                c.a.p0.a.u.d.c("redirect", "check pages failed");
                this.f8099b.o();
                if (z.f8176b) {
                    Context context = this.f8106i;
                    c.a.p0.a.s1.b.f.e.g(context, this.f8106i.getString(R.string.aiapps_open_pages_failed) + i2).G();
                }
                c.a.p0.a.v1.f.o0.a.j(this.f8101d, this.f8102e, this.f8104g);
                c.a.p0.a.d2.i.j(this.f8100c, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8108b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f8109c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.g f8110d;

        public b(i iVar, a.e eVar, String str, c.a.p0.a.c1.b bVar, c.a.p0.a.x.g.g gVar) {
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
            this.f8108b = str;
            this.f8109c = bVar;
            this.f8110d = gVar;
        }

        @Override // c.a.p0.a.x.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = z.f8176b;
                c.a.p0.a.k1.i.e(this.a, this.f8108b);
                c.a.p0.a.v1.f.o0.a.e(this.a.a, this.f8109c, this.f8108b);
                c.a.p0.a.k.e.j.d.A(this.f8110d, this.f8109c, this.f8108b, false);
                boolean unused2 = z.f8176b;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.p0.a.v1.e eVar) {
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

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f8176b) {
                r0 = "handle entity: " + unitedSchemeEntity.toString();
            }
            String uuid = UUID.randomUUID().toString();
            c.a.p0.a.k1.i.b(uuid);
            String o = c.a.p0.a.v1.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.p0.a.u.d.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.a.p0.a.w0.f U = c.a.p0.a.w0.f.U();
            c.a.p0.a.x.g.g V = U.V();
            if (V == null) {
                c.a.p0.a.u.d.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.p0.a.c1.b e2 = c.a.p0.a.c1.b.e(o, U.z());
            e2.f4646i = "2";
            e2.f4647j = uuid;
            c.a.p0.a.d2.i.g(e2);
            if (!q0.b(U.s(), e2, false)) {
                c.a.p0.a.u.d.c("redirect", "page params error : path=" + e2.f4642e + " ; routePath=" + e2.f4645h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.p0.a.d2.i.i(e2);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(e2.f4645h) && c.a.p0.a.t1.e.L() != null) {
                c.a.p0.a.t1.e.L().K0(str, e2.f4645h);
            }
            String n = c.a.p0.a.v1.f.o0.a.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            boolean z = z.f8176b;
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.p0.a.u.d.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.p0.a.d2.i.i(e2);
                return false;
            } else if (c.a.p0.a.v1.f.f0.d.b().a(e2)) {
                c.a.p0.a.v1.f.f0.d.b().i("redirectTo", e2);
                c.a.p0.a.u.d.c("redirectTo", "access to this page is prohibited");
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

    public final void n(a.e eVar, c.a.p0.a.c1.b bVar, c.a.p0.a.x.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, bVar, gVar, str) == null) {
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
