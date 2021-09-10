package c.a.p0.a.c2.f.f0;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.h;
import c.a.p0.a.k;
import c.a.p0.a.p.d.f0;
import c.a.p0.a.v2.q0;
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

    /* renamed from: c.a.p0.a.c2.f.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0132a implements c.a.p0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f4802a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4803b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4804c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4805d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4806e;

        public C0132a(a aVar, c.a.p0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
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
            this.f4806e = aVar;
            this.f4802a = eVar;
            this.f4803b = callbackHandler;
            this.f4804c = unitedSchemeEntity;
            this.f4805d = str;
        }

        @Override // c.a.p0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4806e.f4808d) {
                    c.a.p0.a.z1.b.f.e f2 = c.a.p0.a.z1.b.f.e.f(this.f4802a.getApplicationContext(), h.swanapp_tip_net_unavailable);
                    f2.l(2);
                    f2.F();
                }
                this.f4806e.n(this.f4804c, this.f4803b, this.f4805d);
            }
        }

        @Override // c.a.p0.a.q0.b.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f4806e.f4808d) {
                    c.a.p0.a.z1.b.f.e f2 = c.a.p0.a.z1.b.f.e.f(this.f4802a.getApplicationContext(), h.aiapps_fav_fail);
                    f2.l(2);
                    f2.F();
                }
                this.f4806e.n(this.f4804c, this.f4803b, this.f4805d);
            }
        }

        @Override // c.a.p0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e2) {
                    if (k.f7077a) {
                        e2.printStackTrace();
                    }
                }
                if (this.f4806e.f4808d) {
                    b.m("1", "btn", "success");
                    c.a.p0.a.j0.b.a.t();
                    if (c.a.p0.a.j1.a.k(this.f4802a.x())) {
                        c.a.p0.a.j1.a.p("addmyswan", q0.n().h());
                    } else {
                        Context applicationContext = this.f4802a.getApplicationContext();
                        c.a.p0.a.z1.b.f.e g2 = c.a.p0.a.z1.b.f.e.g(applicationContext, c.a.p0.a.c1.a.e0().f(applicationContext));
                        g2.l(2);
                        g2.p(2);
                        g2.F();
                    }
                }
                UnitedSchemeUtility.safeCallback(this.f4803b, this.f4804c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f4805d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.c2.e eVar) {
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
                super((c.a.p0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.c2.f.f0.b
    public boolean j(c.a.p0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, unitedSchemeEntity)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                return false;
            }
            try {
                String D = this.f4808d ? eVar.D() : new JSONObject(param).optString("appid");
                this.f4807c = D;
                return !TextUtils.isEmpty(D);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.p0.a.c2.f.f0.b
    public void k(c.a.p0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) {
            PMSAppInfo s = c.a.p0.n.g.a.h().s(this.f4807c);
            if (s != null && !TextUtils.isEmpty(s.appId)) {
                if (this.f4808d) {
                    b.m("1", "btn", "invoke");
                } else {
                    b.m("1", RetrieveTaskManager.KEY, "invoke");
                }
                SwanFavorDataManager.h().b(this.f4807c, new C0132a(this, eVar, callbackHandler, unitedSchemeEntity, str));
                return;
            }
            n(unitedSchemeEntity, callbackHandler, str);
        }
    }

    @Override // c.a.p0.a.c2.f.f0.b
    public void l(c.a.p0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        f0 e0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) && this.f4808d && (e0 = c.a.p0.a.c1.a.e0()) != null) {
            e0.g(eVar);
        }
    }
}
