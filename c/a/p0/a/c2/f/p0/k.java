package c.a.p0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.c2.f.a0;
import c.a.p0.a.c2.f.p0.g;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.h0.t.a;
import c.a.p0.a.v2.q0;
import c.a.p0.a.v2.w;
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
        public final /* synthetic */ String f5061a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.g1.f f5062b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.g f5063c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.l1.b f5064d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5065e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5066f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f5067g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5068h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ k f5069i;

        /* renamed from: c.a.p0.a.c2.f.p0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0141a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.d f5070a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f5071b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f5072c;

            public C0141a(a aVar, a.d dVar, JSONObject jSONObject) {
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
                this.f5072c = aVar;
                this.f5070a = dVar;
                this.f5071b = jSONObject;
            }

            @Override // c.a.p0.a.h0.t.a.e
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.a.r1.i.e(this.f5070a, this.f5072c.f5061a);
                    c.a.p0.a.p.e.b bVar = this.f5070a.f6437a;
                    a aVar = this.f5072c;
                    c.a.p0.a.c2.f.p0.a.e(bVar, aVar.f5064d, aVar.f5061a);
                    c.a.p0.a.r1.i.c(5, this.f5072c.f5061a);
                    a aVar2 = this.f5072c;
                    aVar2.f5069i.l(aVar2.f5063c, aVar2.f5064d, aVar2.f5061a);
                    a aVar3 = this.f5072c;
                    UnitedSchemeUtility.callCallback(aVar3.f5065e, aVar3.f5066f, UnitedSchemeUtility.wrapCallbackParams(this.f5071b, 0));
                }
            }
        }

        public a(k kVar, String str, c.a.p0.a.g1.f fVar, c.a.p0.a.h0.g.g gVar, c.a.p0.a.l1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
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
            this.f5069i = kVar;
            this.f5061a = str;
            this.f5062b = fVar;
            this.f5063c = gVar;
            this.f5064d = bVar;
            this.f5065e = callbackHandler;
            this.f5066f = unitedSchemeEntity;
            this.f5067g = context;
            this.f5068h = str2;
        }

        @Override // c.a.p0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.r1.i.d(this.f5061a);
                this.f5062b.o();
                c.a.p0.a.h0.g.f l = this.f5063c.l();
                if (l != null && !TextUtils.isEmpty(l.h3(this.f5064d.f7239h))) {
                    JSONObject c2 = c.a.p0.a.c2.f.p0.a.c(l.h3(this.f5064d.f7239h));
                    c.a.p0.a.r1.i.c(4, this.f5061a);
                    this.f5069i.l(this.f5063c, this.f5064d, this.f5061a);
                    UnitedSchemeUtility.callCallback(this.f5065e, this.f5066f, UnitedSchemeUtility.wrapCallbackParams(c2, 0));
                    return;
                }
                a.d f2 = c.a.p0.a.h0.t.a.f(this.f5062b.getActivity());
                JSONObject c3 = c.a.p0.a.c2.f.p0.a.c(f2.f6437a.c());
                HybridUbcFlow q = c.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.f5061a);
                q.C(new UbcFlowEvent("na_pre_load_slave_check"));
                q.A("preload", f2.f6438b ? "1" : "0");
                c.a.p0.a.h0.t.a.n(f2, new C0141a(this, f2, c3));
            }
        }

        @Override // c.a.p0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f5062b.o();
                if (a0.f4766b) {
                    Context context = this.f5067g;
                    c.a.p0.a.z1.b.f.e.g(context, this.f5067g.getString(c.a.p0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                if (TextUtils.isEmpty(this.f5068h)) {
                    return;
                }
                c.a.p0.a.c2.f.p0.a.j(this.f5066f, this.f5065e, this.f5068h);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c.a.p0.a.c2.e eVar) {
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

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4766b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            String uuid = UUID.randomUUID().toString();
            c.a.p0.a.r1.i.b(uuid);
            String o = c.a.p0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.p0.a.e0.d.b("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            c.a.p0.a.g1.f V = c.a.p0.a.g1.f.V();
            c.a.p0.a.h0.g.g W = V.W();
            if (W == null) {
                c.a.p0.a.e0.d.b("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.p0.a.l1.b g2 = c.a.p0.a.l1.b.g(o, V.A());
            c.a.p0.a.j2.h.f(g2.f7236e, "4");
            if (!q0.c(V.s(), g2)) {
                c.a.p0.a.e0.d.b("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String n = c.a.p0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = c.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.C(ubcFlowEvent);
            }
            V.u();
            g.g(eVar, g2, "", new a(this, uuid, V, W, g2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            c.a.p0.a.e0.d.g("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(c.a.p0.a.h0.g.g gVar, c.a.p0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, bVar, str) == null) {
            c.a.p0.a.h0.g.f.C3(q0.n());
            g.b i2 = gVar.i("switchTab");
            i2.n(0, 0);
            i2.i();
            i2.p(bVar).b();
            c.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            c.a.p0.a.r1.i.a(str, bVar);
        }
    }
}
