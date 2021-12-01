package c.a.p0.a.f2.f.o0;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.f2.f.o0.g;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.h0.t.a;
import c.a.p0.a.z2.q0;
import c.a.p0.a.z2.w;
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
        public final /* synthetic */ c.a.p0.a.g1.f f5219b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.m1.b f5220c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5221d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5222e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.d2.e f5223f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5224g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.g f5225h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f5226i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ i f5227j;

        public a(i iVar, String str, c.a.p0.a.g1.f fVar, c.a.p0.a.m1.b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar, String str2, c.a.p0.a.h0.g.g gVar, Context context) {
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
            this.f5227j = iVar;
            this.a = str;
            this.f5219b = fVar;
            this.f5220c = bVar;
            this.f5221d = unitedSchemeEntity;
            this.f5222e = callbackHandler;
            this.f5223f = eVar;
            this.f5224g = str2;
            this.f5225h = gVar;
            this.f5226i = context;
        }

        @Override // c.a.p0.a.f2.f.o0.g.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.u1.i.d(this.a);
                c.a.p0.a.e0.d.i("redirect", "check pages success");
                this.f5219b.n();
                a.e f2 = c.a.p0.a.h0.t.a.f(this.f5219b.getActivity(), c.a.p0.a.h0.t.f.a.c(this.f5220c.f6799e));
                c.a.p0.a.f2.f.o0.a.l(this.f5221d, this.f5222e, this.f5223f, f2.a.c(), this.f5220c.f6799e, null, this.f5224g);
                this.f5227j.n(f2, this.f5220c, this.f5225h, this.a);
            }
        }

        @Override // c.a.p0.a.f2.f.o0.g.e
        public void b(int i2, c.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                c.a.p0.a.e0.d.c("redirect", "check pages failed");
                this.f5219b.n();
                if (z.f5296b) {
                    Context context = this.f5226i;
                    c.a.p0.a.c2.b.f.e.g(context, this.f5226i.getString(c.a.p0.a.h.aiapps_open_pages_failed) + i2).G();
                }
                c.a.p0.a.f2.f.o0.a.j(this.f5221d, this.f5222e, this.f5224g);
                c.a.p0.a.n2.i.j(this.f5220c, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5228b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.m1.b f5229c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.g f5230d;

        public b(i iVar, a.e eVar, String str, c.a.p0.a.m1.b bVar, c.a.p0.a.h0.g.g gVar) {
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
            this.f5228b = str;
            this.f5229c = bVar;
            this.f5230d = gVar;
        }

        @Override // c.a.p0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = z.f5296b;
                c.a.p0.a.u1.i.e(this.a, this.f5228b);
                c.a.p0.a.f2.f.o0.a.e(this.a.a, this.f5229c, this.f5228b);
                c.a.p0.a.u.e.j.d.A(this.f5230d, this.f5229c, this.f5228b, false);
                boolean unused2 = z.f5296b;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.p0.a.f2.e eVar) {
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

    @Override // c.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f5296b) {
                r0 = "handle entity: " + unitedSchemeEntity.toString();
            }
            String uuid = UUID.randomUUID().toString();
            c.a.p0.a.u1.i.b(uuid);
            String o = c.a.p0.a.f2.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.p0.a.e0.d.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.a.p0.a.g1.f U = c.a.p0.a.g1.f.U();
            c.a.p0.a.h0.g.g V = U.V();
            if (V == null) {
                c.a.p0.a.e0.d.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.p0.a.m1.b e2 = c.a.p0.a.m1.b.e(o, U.z());
            e2.f6803i = "2";
            e2.f6804j = uuid;
            c.a.p0.a.n2.i.g(e2);
            if (!q0.b(U.r(), e2, false)) {
                c.a.p0.a.e0.d.c("redirect", "page params error : path=" + e2.f6799e + " ; routePath=" + e2.f6802h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.p0.a.n2.i.i(e2);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(e2.f6802h) && c.a.p0.a.d2.e.L() != null) {
                c.a.p0.a.d2.e.L().K0(str, e2.f6802h);
            }
            String n = c.a.p0.a.f2.f.o0.a.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = c.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            boolean z = z.f5296b;
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.p0.a.e0.d.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.p0.a.n2.i.i(e2);
                return false;
            } else if (c.a.p0.a.f2.f.f0.d.b().a(e2)) {
                c.a.p0.a.f2.f.f0.d.b().i("redirectTo", e2);
                c.a.p0.a.e0.d.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.t();
                g.g(eVar, e2, "", new a(this, uuid, U, e2, unitedSchemeEntity, callbackHandler, eVar, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(a.e eVar, c.a.p0.a.m1.b bVar, c.a.p0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f5990b;
            HybridUbcFlow q = c.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (z.f5296b) {
                String str2 = "tryToExecutePageRoute start. isReady : " + z;
            }
            c.a.p0.a.h0.t.a.q(eVar, new b(this, eVar, str, bVar, gVar));
            boolean z2 = z.f5296b;
        }
    }
}
