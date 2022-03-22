package c.a.n0.a.v1.f.e0;

import android.content.Context;
import android.text.TextUtils;
import c.a.n0.a.f.d.f0;
import c.a.n0.a.p2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.R;
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

    /* renamed from: c.a.n0.a.v1.f.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0488a implements c.a.n0.a.g0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.t1.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6636b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6637c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6638d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6639e;

        public C0488a(a aVar, c.a.n0.a.t1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6639e = aVar;
            this.a = eVar;
            this.f6636b = callbackHandler;
            this.f6637c = unitedSchemeEntity;
            this.f6638d = str;
        }

        @Override // c.a.n0.a.g0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f6639e.f6641d) {
                    c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f12dd);
                    f2.l(2);
                    f2.G();
                }
                this.f6639e.n(this.f6637c, this.f6636b, this.f6638d);
            }
        }

        @Override // c.a.n0.a.g0.b.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (this.f6639e.f6641d && !z) {
                    c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f0151);
                    f2.l(2);
                    f2.G();
                }
                this.f6639e.n(this.f6637c, this.f6636b, this.f6638d);
            }
        }

        @Override // c.a.n0.a.g0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e2) {
                    if (c.a.n0.a.a.a) {
                        e2.printStackTrace();
                    }
                }
                if (this.f6639e.f6641d) {
                    b.m("1", "btn", "success");
                    c.a.n0.a.z.b.a.t();
                    if (c.a.n0.a.a1.a.k(this.a.x())) {
                        c.a.n0.a.a1.a.p("addmyswan", q0.n().e());
                    } else {
                        Context applicationContext = this.a.getApplicationContext();
                        c.a.n0.a.s1.b.f.e g2 = c.a.n0.a.s1.b.f.e.g(applicationContext, c.a.n0.a.s0.a.l0().f(applicationContext));
                        g2.l(2);
                        g2.q(2);
                        g2.G();
                    }
                }
                UnitedSchemeUtility.safeCallback(this.f6636b, this.f6637c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f6638d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/addFavor");
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
                super((c.a.n0.a.v1.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.v1.f.e0.b
    public boolean j(c.a.n0.a.t1.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, unitedSchemeEntity)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                return false;
            }
            try {
                String N = this.f6641d ? eVar.N() : new JSONObject(param).optString("appid");
                this.f6640c = N;
                return !TextUtils.isEmpty(N);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.n0.a.v1.f.e0.b
    public void k(c.a.n0.a.t1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) {
            PMSAppInfo u = c.a.n0.q.f.a.i().u(this.f6640c);
            if (u != null && !TextUtils.isEmpty(u.appId)) {
                if (this.f6641d) {
                    b.m("1", "btn", "invoke");
                } else {
                    b.m("1", RetrieveTaskManager.KEY, "invoke");
                }
                SwanFavorDataManager.h().b(this.f6640c, new C0488a(this, eVar, callbackHandler, unitedSchemeEntity, str));
                return;
            }
            n(unitedSchemeEntity, callbackHandler, str);
        }
    }

    @Override // c.a.n0.a.v1.f.e0.b
    public void l(c.a.n0.a.t1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        f0 l0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) && this.f6641d && (l0 = c.a.n0.a.s0.a.l0()) != null) {
            l0.g(eVar);
        }
    }
}
