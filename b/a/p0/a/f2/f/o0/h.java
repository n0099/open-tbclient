package b.a.p0.a.f2.f.o0;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.f2.f.o0.g;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.h0.t.a;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.w;
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
public class h extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5136a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.g1.f f5137b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f5138c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5139d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5140e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f5141f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5142g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f5143h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f5144i;
        public final /* synthetic */ h j;

        public a(h hVar, String str, b.a.p0.a.g1.f fVar, b.a.p0.a.m1.b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar, String str2, b.a.p0.a.h0.g.g gVar, Context context) {
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
            this.j = hVar;
            this.f5136a = str;
            this.f5137b = fVar;
            this.f5138c = bVar;
            this.f5139d = unitedSchemeEntity;
            this.f5140e = callbackHandler;
            this.f5141f = eVar;
            this.f5142g = str2;
            this.f5143h = gVar;
            this.f5144i = context;
        }

        @Override // b.a.p0.a.f2.f.o0.g.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.u1.i.d(this.f5136a);
                b.a.p0.a.e0.d.i("relaunch", "check pages success");
                this.f5137b.n();
                a.e f2 = b.a.p0.a.h0.t.a.f(this.f5137b.getActivity(), b.a.p0.a.h0.t.f.a.c(this.f5138c.f7014e));
                b.a.p0.a.f2.f.o0.a.l(this.f5139d, this.f5140e, this.f5141f, f2.f6108a.c(), this.f5138c.f7014e, null, this.f5142g);
                this.j.p(f2, this.f5138c, this.f5143h, this.f5136a);
            }
        }

        @Override // b.a.p0.a.f2.f.o0.g.e
        public void b(int i2, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                b.a.p0.a.e0.d.c("relaunch", "check pages failed");
                this.f5137b.n();
                if (z.f5228b) {
                    Context context = this.f5144i;
                    b.a.p0.a.c2.b.f.e.g(context, this.f5144i.getString(b.a.p0.a.h.aiapps_open_pages_failed) + i2).G();
                }
                b.a.p0.a.f2.f.o0.a.j(this.f5139d, this.f5140e, this.f5142g);
                b.a.p0.a.n2.i.j(this.f5138c, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.e f5145a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5146b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f5147c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f5148d;

        public b(h hVar, a.e eVar, String str, b.a.p0.a.m1.b bVar, b.a.p0.a.h0.g.g gVar) {
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
            this.f5145a = eVar;
            this.f5146b = str;
            this.f5147c = bVar;
            this.f5148d = gVar;
        }

        @Override // b.a.p0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = z.f5228b;
                b.a.p0.a.u1.i.e(this.f5145a, this.f5146b);
                b.a.p0.a.f2.f.o0.a.e(this.f5145a.f6108a, this.f5147c, this.f5146b);
                h.o(this.f5148d, this.f5147c, this.f5146b);
                boolean unused2 = z.f5228b;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(b.a.p0.a.f2.e eVar) {
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

    public static void o(b.a.p0.a.h0.g.g gVar, b.a.p0.a.m1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, gVar, bVar, str) == null) {
            b.a.p0.a.u.e.j.e.y(gVar, bVar, str);
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
            String uuid = UUID.randomUUID().toString();
            b.a.p0.a.u1.i.b(uuid);
            String o = b.a.p0.a.f2.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                b.a.p0.a.e0.d.c("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            b.a.p0.a.g1.f U = b.a.p0.a.g1.f.U();
            b.a.p0.a.h0.g.g V = U.V();
            if (V == null) {
                b.a.p0.a.e0.d.c("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            b.a.p0.a.m1.b e2 = b.a.p0.a.m1.b.e(o, U.z());
            e2.f7018i = "3";
            e2.j = uuid;
            b.a.p0.a.n2.i.g(e2);
            if (!q0.b(U.r(), e2, true)) {
                b.a.p0.a.e0.d.c("relaunch", "page params error : path=" + e2.f7014e + " ; routePath=" + e2.f7017h);
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
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.c("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                b.a.p0.a.n2.i.i(e2);
                return false;
            } else if (b.a.p0.a.f2.f.f0.d.b().a(e2)) {
                b.a.p0.a.f2.f.f0.d.b().i("reLaunch", e2);
                b.a.p0.a.e0.d.c("ReLaunchAction", "access to this page is prohibited");
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

    public final void p(a.e eVar, b.a.p0.a.m1.b bVar, b.a.p0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, bVar, gVar, str) == null) {
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
