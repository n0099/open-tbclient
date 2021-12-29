package c.a.r0.a.f2.f.e0;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.a.h;
import c.a.r0.a.k;
import c.a.r0.a.p.d.f0;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.f2.f.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0313a implements c.a.r0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.d2.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6000b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6001c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6002d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6003e;

        public C0313a(a aVar, c.a.r0.a.d2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6003e = aVar;
            this.a = eVar;
            this.f6000b = callbackHandler;
            this.f6001c = unitedSchemeEntity;
            this.f6002d = str;
        }

        @Override // c.a.r0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f6003e.f6005d) {
                    c.a.r0.a.c2.b.f.e f2 = c.a.r0.a.c2.b.f.e.f(this.a.getApplicationContext(), h.swanapp_tip_net_unavailable);
                    f2.l(2);
                    f2.G();
                }
                this.f6003e.n(this.f6001c, this.f6000b, this.f6002d);
            }
        }

        @Override // c.a.r0.a.q0.b.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (this.f6003e.f6005d && !z) {
                    c.a.r0.a.c2.b.f.e f2 = c.a.r0.a.c2.b.f.e.f(this.a.getApplicationContext(), h.aiapps_fav_fail);
                    f2.l(2);
                    f2.G();
                }
                this.f6003e.n(this.f6001c, this.f6000b, this.f6002d);
            }
        }

        @Override // c.a.r0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e2) {
                    if (k.a) {
                        e2.printStackTrace();
                    }
                }
                if (this.f6003e.f6005d) {
                    b.m("1", "btn", "success");
                    c.a.r0.a.j0.b.a.t();
                    if (c.a.r0.a.k1.a.k(this.a.x())) {
                        c.a.r0.a.k1.a.p("addmyswan", q0.n().f());
                    } else {
                        Context applicationContext = this.a.getApplicationContext();
                        c.a.r0.a.c2.b.f.e g2 = c.a.r0.a.c2.b.f.e.g(applicationContext, c.a.r0.a.c1.a.l0().f(applicationContext));
                        g2.l(2);
                        g2.q(2);
                        g2.G();
                    }
                }
                UnitedSchemeUtility.safeCallback(this.f6000b, this.f6001c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f6002d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.r0.a.f2.e eVar) {
        super(eVar, "/swanAPI/addFavor");
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
                super((c.a.r0.a.f2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.a.f2.f.e0.b
    public boolean j(c.a.r0.a.d2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, unitedSchemeEntity)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                return false;
            }
            try {
                String N = this.f6005d ? eVar.N() : new JSONObject(param).optString("appid");
                this.f6004c = N;
                return !TextUtils.isEmpty(N);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.r0.a.f2.f.e0.b
    public void k(c.a.r0.a.d2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) {
            PMSAppInfo u = c.a.r0.q.g.a.i().u(this.f6004c);
            if (u != null && !TextUtils.isEmpty(u.appId)) {
                if (this.f6005d) {
                    b.m("1", "btn", "invoke");
                } else {
                    b.m("1", RetrieveTaskManager.KEY, "invoke");
                }
                SwanFavorDataManager.h().b(this.f6004c, new C0313a(this, eVar, callbackHandler, unitedSchemeEntity, str));
                return;
            }
            n(unitedSchemeEntity, callbackHandler, str);
        }
    }

    @Override // c.a.r0.a.f2.f.e0.b
    public void l(c.a.r0.a.d2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        f0 l0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) && this.f6005d && (l0 = c.a.r0.a.c1.a.l0()) != null) {
            l0.g(eVar);
        }
    }
}
