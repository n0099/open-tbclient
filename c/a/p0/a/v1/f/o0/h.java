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
public class h extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.w0.f f8087b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f8088c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f8089d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8090e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f8091f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8092g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.g f8093h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f8094i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ h f8095j;

        public a(h hVar, String str, c.a.p0.a.w0.f fVar, c.a.p0.a.c1.b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, String str2, c.a.p0.a.x.g.g gVar, Context context) {
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
            this.f8095j = hVar;
            this.a = str;
            this.f8087b = fVar;
            this.f8088c = bVar;
            this.f8089d = unitedSchemeEntity;
            this.f8090e = callbackHandler;
            this.f8091f = eVar;
            this.f8092g = str2;
            this.f8093h = gVar;
            this.f8094i = context;
        }

        @Override // c.a.p0.a.v1.f.o0.g.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.k1.i.d(this.a);
                c.a.p0.a.u.d.i("relaunch", "check pages success");
                this.f8087b.o();
                a.e f2 = c.a.p0.a.x.t.a.f(this.f8087b.getActivity(), c.a.p0.a.x.t.f.a.c(this.f8088c.f4642e));
                c.a.p0.a.v1.f.o0.a.l(this.f8089d, this.f8090e, this.f8091f, f2.a.c(), this.f8088c.f4642e, null, this.f8092g);
                this.f8095j.p(f2, this.f8088c, this.f8093h, this.a);
            }
        }

        @Override // c.a.p0.a.v1.f.o0.g.e
        public void c(int i2, c.a.p0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                c.a.p0.a.u.d.c("relaunch", "check pages failed");
                this.f8087b.o();
                if (z.f8176b) {
                    Context context = this.f8094i;
                    c.a.p0.a.s1.b.f.e.g(context, this.f8094i.getString(R.string.aiapps_open_pages_failed) + i2).G();
                }
                c.a.p0.a.v1.f.o0.a.j(this.f8089d, this.f8090e, this.f8092g);
                c.a.p0.a.d2.i.j(this.f8088c, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8096b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f8097c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.g f8098d;

        public b(h hVar, a.e eVar, String str, c.a.p0.a.c1.b bVar, c.a.p0.a.x.g.g gVar) {
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
            this.f8096b = str;
            this.f8097c = bVar;
            this.f8098d = gVar;
        }

        @Override // c.a.p0.a.x.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = z.f8176b;
                c.a.p0.a.k1.i.e(this.a, this.f8096b);
                c.a.p0.a.v1.f.o0.a.e(this.a.a, this.f8097c, this.f8096b);
                h.o(this.f8098d, this.f8097c, this.f8096b);
                boolean unused2 = z.f8176b;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c.a.p0.a.v1.e eVar) {
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

    public static void o(c.a.p0.a.x.g.g gVar, c.a.p0.a.c1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, gVar, bVar, str) == null) {
            c.a.p0.a.k.e.j.e.y(gVar, bVar, str);
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
                c.a.p0.a.u.d.c("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.a.p0.a.w0.f U = c.a.p0.a.w0.f.U();
            c.a.p0.a.x.g.g V = U.V();
            if (V == null) {
                c.a.p0.a.u.d.c("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.p0.a.c1.b e2 = c.a.p0.a.c1.b.e(o, U.z());
            e2.f4646i = "3";
            e2.f4647j = uuid;
            c.a.p0.a.d2.i.g(e2);
            if (!q0.b(U.s(), e2, true)) {
                c.a.p0.a.u.d.c("relaunch", "page params error : path=" + e2.f4642e + " ; routePath=" + e2.f4645h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.p0.a.d2.i.i(e2);
                return false;
            }
            String n = c.a.p0.a.v1.f.o0.a.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(e2.f4645h) && c.a.p0.a.t1.e.L() != null) {
                c.a.p0.a.t1.e.L().K0(n, e2.f4645h);
            }
            String n2 = c.a.p0.a.v1.f.o0.a.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.p0.a.u.d.c("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.p0.a.d2.i.i(e2);
                return false;
            } else if (c.a.p0.a.v1.f.f0.d.b().a(e2)) {
                c.a.p0.a.v1.f.f0.d.b().i("reLaunch", e2);
                c.a.p0.a.u.d.c("ReLaunchAction", "access to this page is prohibited");
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

    public final void p(a.e eVar, c.a.p0.a.c1.b bVar, c.a.p0.a.x.g.g gVar, String str) {
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
