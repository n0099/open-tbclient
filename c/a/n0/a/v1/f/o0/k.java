package c.a.n0.a.v1.f.o0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.w;
import c.a.n0.a.v1.f.o0.g;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x.g.g;
import c.a.n0.a.x.t.a;
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
        public final /* synthetic */ c.a.n0.a.w0.f f6873b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.g.g f6874c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f6875d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6876e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6877f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f6878g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6879h;
        public final /* synthetic */ k i;

        /* renamed from: c.a.n0.a.v1.f.o0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0500a implements a.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a.e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f6880b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f6881c;

            public C0500a(a aVar, a.e eVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, eVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6881c = aVar;
                this.a = eVar;
                this.f6880b = jSONObject;
            }

            @Override // c.a.n0.a.x.t.a.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.n0.a.k1.i.e(this.a, this.f6881c.a);
                    c.a.n0.a.f.e.b bVar = this.a.a;
                    a aVar = this.f6881c;
                    c.a.n0.a.v1.f.o0.a.e(bVar, aVar.f6875d, aVar.a);
                    c.a.n0.a.k1.i.c(5, this.f6881c.a);
                    a aVar2 = this.f6881c;
                    aVar2.i.n(aVar2.f6874c, aVar2.f6875d, aVar2.a);
                    a aVar3 = this.f6881c;
                    UnitedSchemeUtility.callCallback(aVar3.f6876e, aVar3.f6877f, UnitedSchemeUtility.wrapCallbackParams(this.f6880b, 0));
                }
            }
        }

        public a(k kVar, String str, c.a.n0.a.w0.f fVar, c.a.n0.a.x.g.g gVar, c.a.n0.a.c1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, str, fVar, gVar, bVar, callbackHandler, unitedSchemeEntity, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = kVar;
            this.a = str;
            this.f6873b = fVar;
            this.f6874c = gVar;
            this.f6875d = bVar;
            this.f6876e = callbackHandler;
            this.f6877f = unitedSchemeEntity;
            this.f6878g = context;
            this.f6879h = str2;
        }

        @Override // c.a.n0.a.v1.f.o0.g.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.n0.a.k1.i.d(this.a);
                this.f6873b.o();
                c.a.n0.a.x.g.f l = this.f6874c.l();
                if (l != null && !TextUtils.isEmpty(l.u3(this.f6875d.f3949d))) {
                    JSONObject c2 = c.a.n0.a.v1.f.o0.a.c(l.u3(this.f6875d.f3949d));
                    c.a.n0.a.k1.i.c(4, this.a);
                    this.i.n(this.f6874c, this.f6875d, this.a);
                    UnitedSchemeUtility.callCallback(this.f6876e, this.f6877f, UnitedSchemeUtility.wrapCallbackParams(c2, 0));
                    return;
                }
                a.e f2 = c.a.n0.a.x.t.a.f(this.f6873b.getActivity(), c.a.n0.a.x.t.f.a.c(this.f6875d.f3949d));
                JSONObject c3 = c.a.n0.a.v1.f.o0.a.c(str);
                HybridUbcFlow q = c.a.n0.a.k1.h.q("route", this.a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f2.f7448b ? "1" : "0");
                c.a.n0.a.x.t.a.q(f2, new C0500a(this, f2, c3));
            }
        }

        @Override // c.a.n0.a.v1.f.o0.g.e
        public void c(int i, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, aVar) == null) {
                this.f6873b.o();
                if (z.f6924b) {
                    Context context = this.f6878g;
                    c.a.n0.a.s1.b.f.e.g(context, this.f6878g.getString(R.string.obfuscated_res_0x7f0f019d) + i).G();
                }
                if (!TextUtils.isEmpty(this.f6879h)) {
                    c.a.n0.a.v1.f.o0.a.j(this.f6877f, this.f6876e, this.f6879h);
                }
                c.a.n0.a.d2.i.j(this.f6875d, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.x.g.g a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f6882b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6883c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ k f6884d;

        public b(k kVar, c.a.n0.a.x.g.g gVar, c.a.n0.a.c1.b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, gVar, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6884d = kVar;
            this.a = gVar;
            this.f6882b = bVar;
            this.f6883c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6884d.m(this.a, this.f6882b, this.f6883c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/switchTab");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f6924b) {
                Log.d("SwitchTabAction", "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            c.a.n0.a.k1.i.b(uuid);
            String o = c.a.n0.a.v1.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.n0.a.u.d.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
            c.a.n0.a.x.g.g V = U.V();
            if (V == null) {
                c.a.n0.a.u.d.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.n0.a.c1.b d2 = c.a.n0.a.c1.b.d(o, U.z());
            d2.f3950e = "4";
            d2.f3951f = uuid;
            c.a.n0.a.d2.i.g(d2);
            if (!q0.c(U.s(), d2)) {
                c.a.n0.a.u.d.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.n0.a.d2.i.i(d2);
                return false;
            }
            String n = c.a.n0.a.v1.f.o0.a.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = c.a.n0.a.k1.h.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            U.a();
            g.g(eVar, d2, "", new a(this, uuid, U, V, d2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            c.a.n0.a.u.d.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(c.a.n0.a.x.g.g gVar, c.a.n0.a.c1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, bVar, str) == null) {
            c.a.n0.a.x.g.f.Q3(q0.n());
            g.b i = gVar.i("switchTab");
            i.n(0, 0);
            i.i();
            i.q(bVar).b();
            c.a.n0.a.k1.h.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.n0.a.k1.i.a(str, bVar);
        }
    }

    public final void n(c.a.n0.a.x.g.g gVar, c.a.n0.a.c1.b bVar, String str) {
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
