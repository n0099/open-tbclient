package c.a.n0.a.v1.f.o0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.w;
import c.a.n0.a.v1.f.o0.g;
import c.a.n0.a.v1.f.z;
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
        public final /* synthetic */ c.a.n0.a.w0.f f6863b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f6864c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6865d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6866e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f6867f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6868g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.g.g f6869h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ i j;

        public a(i iVar, String str, c.a.n0.a.w0.f fVar, c.a.n0.a.c1.b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar, String str2, c.a.n0.a.x.g.g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, fVar, bVar, unitedSchemeEntity, callbackHandler, eVar, str2, gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = iVar;
            this.a = str;
            this.f6863b = fVar;
            this.f6864c = bVar;
            this.f6865d = unitedSchemeEntity;
            this.f6866e = callbackHandler;
            this.f6867f = eVar;
            this.f6868g = str2;
            this.f6869h = gVar;
            this.i = context;
        }

        @Override // c.a.n0.a.v1.f.o0.g.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.n0.a.k1.i.d(this.a);
                c.a.n0.a.u.d.i("redirect", "check pages success");
                this.f6863b.o();
                a.e f2 = c.a.n0.a.x.t.a.f(this.f6863b.getActivity(), c.a.n0.a.x.t.f.a.c(this.f6864c.a));
                c.a.n0.a.v1.f.o0.a.l(this.f6865d, this.f6866e, this.f6867f, f2.a.c(), this.f6864c.a, null, this.f6868g);
                this.j.n(f2, this.f6864c, this.f6869h, this.a);
            }
        }

        @Override // c.a.n0.a.v1.f.o0.g.e
        public void c(int i, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, aVar) == null) {
                c.a.n0.a.u.d.c("redirect", "check pages failed");
                this.f6863b.o();
                if (z.f6924b) {
                    Context context = this.i;
                    c.a.n0.a.s1.b.f.e.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f019d) + i).G();
                }
                c.a.n0.a.v1.f.o0.a.j(this.f6865d, this.f6866e, this.f6868g);
                c.a.n0.a.d2.i.j(this.f6864c, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6870b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f6871c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.g.g f6872d;

        public b(i iVar, a.e eVar, String str, c.a.n0.a.c1.b bVar, c.a.n0.a.x.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, eVar, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.f6870b = str;
            this.f6871c = bVar;
            this.f6872d = gVar;
        }

        @Override // c.a.n0.a.x.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (z.f6924b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                c.a.n0.a.k1.i.e(this.a, this.f6870b);
                c.a.n0.a.v1.f.o0.a.e(this.a.a, this.f6871c, this.f6870b);
                c.a.n0.a.k.e.j.d.A(this.f6872d, this.f6871c, this.f6870b, false);
                if (z.f6924b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/redirectTo");
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
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            c.a.n0.a.k1.i.b(uuid);
            String o = c.a.n0.a.v1.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.n0.a.u.d.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
            c.a.n0.a.x.g.g V = U.V();
            if (V == null) {
                c.a.n0.a.u.d.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.n0.a.c1.b d2 = c.a.n0.a.c1.b.d(o, U.z());
            d2.f3950e = "2";
            d2.f3951f = uuid;
            c.a.n0.a.d2.i.g(d2);
            if (!q0.b(U.s(), d2, false)) {
                c.a.n0.a.u.d.c("redirect", "page params error : path=" + d2.a + " ; routePath=" + d2.f3949d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                c.a.n0.a.d2.i.i(d2);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d2.f3949d) && c.a.n0.a.t1.e.L() != null) {
                c.a.n0.a.t1.e.L().K0(str, d2.f3949d);
            }
            String n = c.a.n0.a.v1.f.o0.a.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = c.a.n0.a.k1.h.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (z.f6924b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.n0.a.u.d.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.n0.a.d2.i.i(d2);
                return false;
            } else if (c.a.n0.a.v1.f.f0.d.b().a(d2)) {
                c.a.n0.a.v1.f.f0.d.b().i("redirectTo", d2);
                c.a.n0.a.u.d.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                g.g(eVar, d2, "", new a(this, uuid, U, d2, unitedSchemeEntity, callbackHandler, eVar, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(a.e eVar, c.a.n0.a.c1.b bVar, c.a.n0.a.x.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, bVar, gVar, str) == null) {
            boolean z = eVar != null && eVar.f7448b;
            HybridUbcFlow q = c.a.n0.a.k1.h.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (z.f6924b) {
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            c.a.n0.a.x.t.a.q(eVar, new b(this, eVar, str, bVar, gVar));
            if (z.f6924b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
