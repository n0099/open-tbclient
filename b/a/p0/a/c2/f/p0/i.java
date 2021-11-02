package b.a.p0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.c2.f.p0.g;
import b.a.p0.a.h0.t.a;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.w;
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
        public final /* synthetic */ String f4431a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.g1.f f4432b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4433c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4434d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f4435e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4436f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l1.b f4437g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4438h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a.d f4439i;
        public final /* synthetic */ b.a.p0.a.h0.g.g j;
        public final /* synthetic */ Context k;
        public final /* synthetic */ i l;

        public a(i iVar, String str, b.a.p0.a.g1.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, String str2, b.a.p0.a.l1.b bVar, String str3, a.d dVar, b.a.p0.a.h0.g.g gVar, Context context) {
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
            this.f4431a = str;
            this.f4432b = fVar;
            this.f4433c = unitedSchemeEntity;
            this.f4434d = callbackHandler;
            this.f4435e = eVar;
            this.f4436f = str2;
            this.f4437g = bVar;
            this.f4438h = str3;
            this.f4439i = dVar;
            this.j = gVar;
            this.k = context;
        }

        @Override // b.a.p0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.r1.i.d(this.f4431a);
                b.a.p0.a.e0.d.g("redirect", "check pages success");
                this.f4432b.n();
                b.a.p0.a.c2.f.p0.a.l(this.f4433c, this.f4434d, this.f4435e, this.f4436f, this.f4437g.f6555e, null, this.f4438h);
                this.l.n(this.f4439i, this.f4437g, this.j, this.f4431a);
            }
        }

        @Override // b.a.p0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                b.a.p0.a.e0.d.b("redirect", "check pages failed");
                this.f4432b.n();
                if (a0.f4160b) {
                    Context context = this.k;
                    b.a.p0.a.z1.b.f.e.g(context, this.k.getString(b.a.p0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                b.a.p0.a.c2.f.p0.a.j(this.f4433c, this.f4434d, this.f4438h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f4440a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4441b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l1.b f4442c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f4443d;

        public b(i iVar, a.d dVar, String str, b.a.p0.a.l1.b bVar, b.a.p0.a.h0.g.g gVar) {
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
            this.f4440a = dVar;
            this.f4441b = str;
            this.f4442c = bVar;
            this.f4443d = gVar;
        }

        @Override // b.a.p0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = a0.f4160b;
                b.a.p0.a.r1.i.e(this.f4440a, this.f4441b);
                b.a.p0.a.c2.f.p0.a.e(this.f4440a.f5778a, this.f4442c, this.f4441b);
                b.a.p0.a.u.e.k.c.t(this.f4443d, this.f4442c, this.f4441b, false);
                boolean unused2 = a0.f4160b;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(b.a.p0.a.c2.e eVar) {
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
                b.a.p0.a.e0.d.b("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            b.a.p0.a.g1.f T = b.a.p0.a.g1.f.T();
            b.a.p0.a.h0.g.g U = T.U();
            if (U == null) {
                b.a.p0.a.e0.d.b("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            b.a.p0.a.l1.b e2 = b.a.p0.a.l1.b.e(o, T.z());
            b.a.p0.a.j2.h.f(e2.f6555e, "2");
            if (!q0.b(T.r(), e2, false)) {
                b.a.p0.a.e0.d.b("redirect", "page params error : path=" + e2.f6555e + " ; routePath=" + e2.f6558h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && e2 != null && !TextUtils.isEmpty(e2.f6558h) && b.a.p0.a.a2.e.i() != null) {
                b.a.p0.a.a2.e.i().w0(str, e2.f6558h);
            }
            String n = b.a.p0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.C(ubcFlowEvent);
            }
            boolean z = a0.f4160b;
            a.d f2 = b.a.p0.a.h0.t.a.f(T.getActivity());
            String b2 = f2.f5778a.b();
            if (a0.f4160b) {
                String str2 = "webview id: " + b2;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.b("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (b.a.p0.a.c2.f.g0.d.b().a(e2)) {
                b.a.p0.a.c2.f.g0.d.b().i("redirectTo", e2);
                b.a.p0.a.e0.d.b("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                T.t();
                g.g(eVar, e2, b2, new a(this, uuid, T, unitedSchemeEntity, callbackHandler, eVar, b2, e2, optString, f2, U, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(a.d dVar, b.a.p0.a.l1.b bVar, b.a.p0.a.h0.g.g gVar, String str) {
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
