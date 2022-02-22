package c.a.s0.a.f2.f.o0;

import android.content.Context;
import android.text.TextUtils;
import c.a.s0.a.f2.f.o0.g;
import c.a.s0.a.f2.f.z;
import c.a.s0.a.h0.g.g;
import c.a.s0.a.h0.t.a;
import c.a.s0.a.z2.q0;
import c.a.s0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
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
        public final /* synthetic */ c.a.s0.a.g1.f f6378b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.g.g f6379c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.m1.b f6380d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6381e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6382f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f6383g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6384h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ k f6385i;

        /* renamed from: c.a.s0.a.f2.f.o0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0354a implements a.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a.e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f6386b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f6387c;

            public C0354a(a aVar, a.e eVar, JSONObject jSONObject) {
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
                this.f6387c = aVar;
                this.a = eVar;
                this.f6386b = jSONObject;
            }

            @Override // c.a.s0.a.h0.t.a.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.s0.a.u1.i.e(this.a, this.f6387c.a);
                    c.a.s0.a.p.e.b bVar = this.a.a;
                    a aVar = this.f6387c;
                    c.a.s0.a.f2.f.o0.a.e(bVar, aVar.f6380d, aVar.a);
                    c.a.s0.a.u1.i.c(5, this.f6387c.a);
                    a aVar2 = this.f6387c;
                    aVar2.f6385i.n(aVar2.f6379c, aVar2.f6380d, aVar2.a);
                    a aVar3 = this.f6387c;
                    UnitedSchemeUtility.callCallback(aVar3.f6381e, aVar3.f6382f, UnitedSchemeUtility.wrapCallbackParams(this.f6386b, 0));
                }
            }
        }

        public a(k kVar, String str, c.a.s0.a.g1.f fVar, c.a.s0.a.h0.g.g gVar, c.a.s0.a.m1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
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
            this.f6385i = kVar;
            this.a = str;
            this.f6378b = fVar;
            this.f6379c = gVar;
            this.f6380d = bVar;
            this.f6381e = callbackHandler;
            this.f6382f = unitedSchemeEntity;
            this.f6383g = context;
            this.f6384h = str2;
        }

        @Override // c.a.s0.a.f2.f.o0.g.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.s0.a.u1.i.d(this.a);
                this.f6378b.o();
                c.a.s0.a.h0.g.f l = this.f6379c.l();
                if (l != null && !TextUtils.isEmpty(l.q3(this.f6380d.f7917h))) {
                    JSONObject c2 = c.a.s0.a.f2.f.o0.a.c(l.q3(this.f6380d.f7917h));
                    c.a.s0.a.u1.i.c(4, this.a);
                    this.f6385i.n(this.f6379c, this.f6380d, this.a);
                    UnitedSchemeUtility.callCallback(this.f6381e, this.f6382f, UnitedSchemeUtility.wrapCallbackParams(c2, 0));
                    return;
                }
                a.e f2 = c.a.s0.a.h0.t.a.f(this.f6378b.getActivity(), c.a.s0.a.h0.t.f.a.c(this.f6380d.f7917h));
                JSONObject c3 = c.a.s0.a.f2.f.o0.a.c(str);
                HybridUbcFlow q = c.a.s0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f2.f7126b ? "1" : "0");
                c.a.s0.a.h0.t.a.q(f2, new C0354a(this, f2, c3));
            }
        }

        @Override // c.a.s0.a.f2.f.o0.g.e
        public void c(int i2, c.a.s0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f6378b.o();
                if (z.f6443b) {
                    Context context = this.f6383g;
                    c.a.s0.a.c2.b.f.e.g(context, this.f6383g.getString(c.a.s0.a.h.aiapps_open_pages_failed) + i2).G();
                }
                if (!TextUtils.isEmpty(this.f6384h)) {
                    c.a.s0.a.f2.f.o0.a.j(this.f6382f, this.f6381e, this.f6384h);
                }
                c.a.s0.a.n2.i.j(this.f6380d, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.g.g f6388e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.m1.b f6389f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6390g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ k f6391h;

        public b(k kVar, c.a.s0.a.h0.g.g gVar, c.a.s0.a.m1.b bVar, String str) {
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
            this.f6391h = kVar;
            this.f6388e = gVar;
            this.f6389f = bVar;
            this.f6390g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6391h.m(this.f6388e, this.f6389f, this.f6390g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c.a.s0.a.f2.e eVar) {
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

    @Override // c.a.s0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f6443b) {
                String str = "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString();
            }
            String uuid = UUID.randomUUID().toString();
            c.a.s0.a.u1.i.b(uuid);
            String o = c.a.s0.a.f2.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.s0.a.e0.d.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            c.a.s0.a.g1.f U = c.a.s0.a.g1.f.U();
            c.a.s0.a.h0.g.g V = U.V();
            if (V == null) {
                c.a.s0.a.e0.d.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.s0.a.m1.b e2 = c.a.s0.a.m1.b.e(o, U.z());
            e2.f7918i = "4";
            e2.f7919j = uuid;
            c.a.s0.a.n2.i.g(e2);
            if (!q0.c(U.s(), e2)) {
                c.a.s0.a.e0.d.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.s0.a.n2.i.i(e2);
                return false;
            }
            String n = c.a.s0.a.f2.f.o0.a.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = c.a.s0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            U.a();
            g.g(eVar, e2, "", new a(this, uuid, U, V, e2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            c.a.s0.a.e0.d.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(c.a.s0.a.h0.g.g gVar, c.a.s0.a.m1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, bVar, str) == null) {
            c.a.s0.a.h0.g.f.M3(q0.n());
            g.b i2 = gVar.i("switchTab");
            i2.n(0, 0);
            i2.i();
            i2.q(bVar).b();
            c.a.s0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.s0.a.u1.i.a(str, bVar);
        }
    }

    public final void n(c.a.s0.a.h0.g.g gVar, c.a.s0.a.m1.b bVar, String str) {
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
