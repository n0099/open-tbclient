package b.a.p0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.c2.f.p0.g;
import b.a.p0.a.h0.g.g;
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
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4444a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.g1.f f4445b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f4446c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l1.b f4447d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4448e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4449f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f4450g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4451h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ k f4452i;

        /* renamed from: b.a.p0.a.c2.f.p0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0136a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.d f4453a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f4454b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f4455c;

            public C0136a(a aVar, a.d dVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, dVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4455c = aVar;
                this.f4453a = dVar;
                this.f4454b = jSONObject;
            }

            @Override // b.a.p0.a.h0.t.a.e
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.a.r1.i.e(this.f4453a, this.f4455c.f4444a);
                    b.a.p0.a.p.e.b bVar = this.f4453a.f5778a;
                    a aVar = this.f4455c;
                    b.a.p0.a.c2.f.p0.a.e(bVar, aVar.f4447d, aVar.f4444a);
                    b.a.p0.a.r1.i.c(5, this.f4455c.f4444a);
                    a aVar2 = this.f4455c;
                    aVar2.f4452i.l(aVar2.f4446c, aVar2.f4447d, aVar2.f4444a);
                    a aVar3 = this.f4455c;
                    UnitedSchemeUtility.callCallback(aVar3.f4448e, aVar3.f4449f, UnitedSchemeUtility.wrapCallbackParams(this.f4454b, 0));
                }
            }
        }

        public a(k kVar, String str, b.a.p0.a.g1.f fVar, b.a.p0.a.h0.g.g gVar, b.a.p0.a.l1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, str, fVar, gVar, bVar, callbackHandler, unitedSchemeEntity, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4452i = kVar;
            this.f4444a = str;
            this.f4445b = fVar;
            this.f4446c = gVar;
            this.f4447d = bVar;
            this.f4448e = callbackHandler;
            this.f4449f = unitedSchemeEntity;
            this.f4450g = context;
            this.f4451h = str2;
        }

        @Override // b.a.p0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.r1.i.d(this.f4444a);
                this.f4445b.n();
                b.a.p0.a.h0.g.f l = this.f4446c.l();
                if (l != null && !TextUtils.isEmpty(l.d3(this.f4447d.f6558h))) {
                    JSONObject c2 = b.a.p0.a.c2.f.p0.a.c(l.d3(this.f4447d.f6558h));
                    b.a.p0.a.r1.i.c(4, this.f4444a);
                    this.f4452i.l(this.f4446c, this.f4447d, this.f4444a);
                    UnitedSchemeUtility.callCallback(this.f4448e, this.f4449f, UnitedSchemeUtility.wrapCallbackParams(c2, 0));
                    return;
                }
                a.d f2 = b.a.p0.a.h0.t.a.f(this.f4445b.getActivity());
                JSONObject c3 = b.a.p0.a.c2.f.p0.a.c(f2.f5778a.b());
                HybridUbcFlow q = b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.f4444a);
                q.C(new UbcFlowEvent("na_pre_load_slave_check"));
                q.A("preload", f2.f5779b ? "1" : "0");
                b.a.p0.a.h0.t.a.n(f2, new C0136a(this, f2, c3));
            }
        }

        @Override // b.a.p0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f4445b.n();
                if (a0.f4160b) {
                    Context context = this.f4450g;
                    b.a.p0.a.z1.b.f.e.g(context, this.f4450g.getString(b.a.p0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                if (TextUtils.isEmpty(this.f4451h)) {
                    return;
                }
                b.a.p0.a.c2.f.p0.a.j(this.f4449f, this.f4448e, this.f4451h);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/switchTab");
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
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            String uuid = UUID.randomUUID().toString();
            b.a.p0.a.r1.i.b(uuid);
            String o = b.a.p0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                b.a.p0.a.e0.d.b("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            b.a.p0.a.g1.f T = b.a.p0.a.g1.f.T();
            b.a.p0.a.h0.g.g U = T.U();
            if (U == null) {
                b.a.p0.a.e0.d.b("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            b.a.p0.a.l1.b e2 = b.a.p0.a.l1.b.e(o, T.z());
            b.a.p0.a.j2.h.f(e2.f6555e, "4");
            if (!q0.c(T.r(), e2)) {
                b.a.p0.a.e0.d.b("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String n = b.a.p0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.C(ubcFlowEvent);
            }
            T.t();
            g.g(eVar, e2, "", new a(this, uuid, T, U, e2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            b.a.p0.a.e0.d.g("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(b.a.p0.a.h0.g.g gVar, b.a.p0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, bVar, str) == null) {
            b.a.p0.a.h0.g.f.y3(q0.n());
            g.b i2 = gVar.i("switchTab");
            i2.n(0, 0);
            i2.i();
            i2.p(bVar).b();
            b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            b.a.p0.a.r1.i.a(str, bVar);
        }
    }
}
