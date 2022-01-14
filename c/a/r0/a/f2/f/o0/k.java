package c.a.r0.a.f2.f.o0;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.a.f2.f.o0.g;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.h0.t.a;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.w;
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
        public final /* synthetic */ c.a.r0.a.g1.f f6136b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.g.g f6137c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.m1.b f6138d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6139e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6140f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f6141g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6142h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ k f6143i;

        /* renamed from: c.a.r0.a.f2.f.o0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0334a implements a.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a.e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f6144b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f6145c;

            public C0334a(a aVar, a.e eVar, JSONObject jSONObject) {
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
                this.f6145c = aVar;
                this.a = eVar;
                this.f6144b = jSONObject;
            }

            @Override // c.a.r0.a.h0.t.a.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.a.u1.i.e(this.a, this.f6145c.a);
                    c.a.r0.a.p.e.b bVar = this.a.a;
                    a aVar = this.f6145c;
                    c.a.r0.a.f2.f.o0.a.e(bVar, aVar.f6138d, aVar.a);
                    c.a.r0.a.u1.i.c(5, this.f6145c.a);
                    a aVar2 = this.f6145c;
                    aVar2.f6143i.n(aVar2.f6137c, aVar2.f6138d, aVar2.a);
                    a aVar3 = this.f6145c;
                    UnitedSchemeUtility.callCallback(aVar3.f6139e, aVar3.f6140f, UnitedSchemeUtility.wrapCallbackParams(this.f6144b, 0));
                }
            }
        }

        public a(k kVar, String str, c.a.r0.a.g1.f fVar, c.a.r0.a.h0.g.g gVar, c.a.r0.a.m1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
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
            this.f6143i = kVar;
            this.a = str;
            this.f6136b = fVar;
            this.f6137c = gVar;
            this.f6138d = bVar;
            this.f6139e = callbackHandler;
            this.f6140f = unitedSchemeEntity;
            this.f6141g = context;
            this.f6142h = str2;
        }

        @Override // c.a.r0.a.f2.f.o0.g.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.r0.a.u1.i.d(this.a);
                this.f6136b.o();
                c.a.r0.a.h0.g.f l = this.f6137c.l();
                if (l != null && !TextUtils.isEmpty(l.q3(this.f6138d.f7675h))) {
                    JSONObject c2 = c.a.r0.a.f2.f.o0.a.c(l.q3(this.f6138d.f7675h));
                    c.a.r0.a.u1.i.c(4, this.a);
                    this.f6143i.n(this.f6137c, this.f6138d, this.a);
                    UnitedSchemeUtility.callCallback(this.f6139e, this.f6140f, UnitedSchemeUtility.wrapCallbackParams(c2, 0));
                    return;
                }
                a.e f2 = c.a.r0.a.h0.t.a.f(this.f6136b.getActivity(), c.a.r0.a.h0.t.f.a.c(this.f6138d.f7675h));
                JSONObject c3 = c.a.r0.a.f2.f.o0.a.c(str);
                HybridUbcFlow q = c.a.r0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f2.f6884b ? "1" : "0");
                c.a.r0.a.h0.t.a.q(f2, new C0334a(this, f2, c3));
            }
        }

        @Override // c.a.r0.a.f2.f.o0.g.e
        public void b(int i2, c.a.r0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f6136b.o();
                if (z.f6201b) {
                    Context context = this.f6141g;
                    c.a.r0.a.c2.b.f.e.g(context, this.f6141g.getString(c.a.r0.a.h.aiapps_open_pages_failed) + i2).G();
                }
                if (!TextUtils.isEmpty(this.f6142h)) {
                    c.a.r0.a.f2.f.o0.a.j(this.f6140f, this.f6139e, this.f6142h);
                }
                c.a.r0.a.n2.i.j(this.f6138d, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.g.g f6146e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.m1.b f6147f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6148g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ k f6149h;

        public b(k kVar, c.a.r0.a.h0.g.g gVar, c.a.r0.a.m1.b bVar, String str) {
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
            this.f6149h = kVar;
            this.f6146e = gVar;
            this.f6147f = bVar;
            this.f6148g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6149h.m(this.f6146e, this.f6147f, this.f6148g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c.a.r0.a.f2.e eVar) {
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f6201b) {
                String str = "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString();
            }
            String uuid = UUID.randomUUID().toString();
            c.a.r0.a.u1.i.b(uuid);
            String o = c.a.r0.a.f2.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.r0.a.e0.d.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            c.a.r0.a.g1.f U = c.a.r0.a.g1.f.U();
            c.a.r0.a.h0.g.g V = U.V();
            if (V == null) {
                c.a.r0.a.e0.d.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.r0.a.m1.b e2 = c.a.r0.a.m1.b.e(o, U.z());
            e2.f7676i = "4";
            e2.f7677j = uuid;
            c.a.r0.a.n2.i.g(e2);
            if (!q0.c(U.s(), e2)) {
                c.a.r0.a.e0.d.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.r0.a.n2.i.i(e2);
                return false;
            }
            String n = c.a.r0.a.f2.f.o0.a.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = c.a.r0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            U.a();
            g.g(eVar, e2, "", new a(this, uuid, U, V, e2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            c.a.r0.a.e0.d.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(c.a.r0.a.h0.g.g gVar, c.a.r0.a.m1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, bVar, str) == null) {
            c.a.r0.a.h0.g.f.M3(q0.n());
            g.b i2 = gVar.i("switchTab");
            i2.n(0, 0);
            i2.i();
            i2.q(bVar).b();
            c.a.r0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.r0.a.u1.i.a(str, bVar);
        }
    }

    public final void n(c.a.r0.a.h0.g.g gVar, c.a.r0.a.m1.b bVar, String str) {
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
