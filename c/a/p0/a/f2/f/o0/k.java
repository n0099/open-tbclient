package c.a.p0.a.f2.f.o0;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.f2.f.o0.g;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.h0.g.g;
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
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.g1.f f5231b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.g f5232c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.m1.b f5233d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5235f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f5236g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5237h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ k f5238i;

        /* renamed from: c.a.p0.a.f2.f.o0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0241a implements a.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a.e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f5239b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f5240c;

            public C0241a(a aVar, a.e eVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, eVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5240c = aVar;
                this.a = eVar;
                this.f5239b = jSONObject;
            }

            @Override // c.a.p0.a.h0.t.a.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.a.u1.i.e(this.a, this.f5240c.a);
                    c.a.p0.a.p.e.b bVar = this.a.a;
                    a aVar = this.f5240c;
                    c.a.p0.a.f2.f.o0.a.e(bVar, aVar.f5233d, aVar.a);
                    c.a.p0.a.u1.i.c(5, this.f5240c.a);
                    a aVar2 = this.f5240c;
                    aVar2.f5238i.n(aVar2.f5232c, aVar2.f5233d, aVar2.a);
                    a aVar3 = this.f5240c;
                    UnitedSchemeUtility.callCallback(aVar3.f5234e, aVar3.f5235f, UnitedSchemeUtility.wrapCallbackParams(this.f5239b, 0));
                }
            }
        }

        public a(k kVar, String str, c.a.p0.a.g1.f fVar, c.a.p0.a.h0.g.g gVar, c.a.p0.a.m1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
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
            this.f5238i = kVar;
            this.a = str;
            this.f5231b = fVar;
            this.f5232c = gVar;
            this.f5233d = bVar;
            this.f5234e = callbackHandler;
            this.f5235f = unitedSchemeEntity;
            this.f5236g = context;
            this.f5237h = str2;
        }

        @Override // c.a.p0.a.f2.f.o0.g.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.u1.i.d(this.a);
                this.f5231b.n();
                c.a.p0.a.h0.g.f l = this.f5232c.l();
                if (l != null && !TextUtils.isEmpty(l.x3(this.f5233d.f6802h))) {
                    JSONObject c2 = c.a.p0.a.f2.f.o0.a.c(l.x3(this.f5233d.f6802h));
                    c.a.p0.a.u1.i.c(4, this.a);
                    this.f5238i.n(this.f5232c, this.f5233d, this.a);
                    UnitedSchemeUtility.callCallback(this.f5234e, this.f5235f, UnitedSchemeUtility.wrapCallbackParams(c2, 0));
                    return;
                }
                a.e f2 = c.a.p0.a.h0.t.a.f(this.f5231b.getActivity(), c.a.p0.a.h0.t.f.a.c(this.f5233d.f6802h));
                JSONObject c3 = c.a.p0.a.f2.f.o0.a.c(str);
                HybridUbcFlow q = c.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f2.f5990b ? "1" : "0");
                c.a.p0.a.h0.t.a.q(f2, new C0241a(this, f2, c3));
            }
        }

        @Override // c.a.p0.a.f2.f.o0.g.e
        public void b(int i2, c.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f5231b.n();
                if (z.f5296b) {
                    Context context = this.f5236g;
                    c.a.p0.a.c2.b.f.e.g(context, this.f5236g.getString(c.a.p0.a.h.aiapps_open_pages_failed) + i2).G();
                }
                if (!TextUtils.isEmpty(this.f5237h)) {
                    c.a.p0.a.f2.f.o0.a.j(this.f5235f, this.f5234e, this.f5237h);
                }
                c.a.p0.a.n2.i.j(this.f5233d, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.g f5241e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.m1.b f5242f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5243g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ k f5244h;

        public b(k kVar, c.a.p0.a.h0.g.g gVar, c.a.p0.a.m1.b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, gVar, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5244h = kVar;
            this.f5241e = gVar;
            this.f5242f = bVar;
            this.f5243g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5244h.m(this.f5241e, this.f5242f, this.f5243g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c.a.p0.a.f2.e eVar) {
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

    @Override // c.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f5296b) {
                String str = "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString();
            }
            String uuid = UUID.randomUUID().toString();
            c.a.p0.a.u1.i.b(uuid);
            String o = c.a.p0.a.f2.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.p0.a.e0.d.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            c.a.p0.a.g1.f U = c.a.p0.a.g1.f.U();
            c.a.p0.a.h0.g.g V = U.V();
            if (V == null) {
                c.a.p0.a.e0.d.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.p0.a.m1.b e2 = c.a.p0.a.m1.b.e(o, U.z());
            e2.f6803i = "4";
            e2.f6804j = uuid;
            c.a.p0.a.n2.i.g(e2);
            if (!q0.c(U.r(), e2)) {
                c.a.p0.a.e0.d.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.p0.a.n2.i.i(e2);
                return false;
            }
            String n = c.a.p0.a.f2.f.o0.a.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = c.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            U.t();
            g.g(eVar, e2, "", new a(this, uuid, U, V, e2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            c.a.p0.a.e0.d.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(c.a.p0.a.h0.g.g gVar, c.a.p0.a.m1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, bVar, str) == null) {
            c.a.p0.a.h0.g.f.T3(q0.n());
            g.b i2 = gVar.i("switchTab");
            i2.n(0, 0);
            i2.i();
            i2.q(bVar).b();
            c.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.p0.a.u1.i.a(str, bVar);
        }
    }

    public final void n(c.a.p0.a.h0.g.g gVar, c.a.p0.a.m1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, gVar, bVar, str) == null) {
            if (q0.O()) {
                m(gVar, bVar, str);
            } else {
                q0.a0(new b(this, gVar, bVar, str));
            }
        }
    }
}
