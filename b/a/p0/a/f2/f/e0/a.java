package b.a.p0.a.f2.f.e0;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.h;
import b.a.p0.a.k;
import b.a.p0.a.p.d.f0;
import b.a.p0.a.z2.q0;
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

    /* renamed from: b.a.p0.a.f2.f.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0173a implements b.a.p0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f4875a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4876b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4877c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4878d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4879e;

        public C0173a(a aVar, b.a.p0.a.d2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
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
            this.f4879e = aVar;
            this.f4875a = eVar;
            this.f4876b = callbackHandler;
            this.f4877c = unitedSchemeEntity;
            this.f4878d = str;
        }

        @Override // b.a.p0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4879e.f4881d) {
                    b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(this.f4875a.getApplicationContext(), h.swanapp_tip_net_unavailable);
                    f2.l(2);
                    f2.G();
                }
                this.f4879e.n(this.f4877c, this.f4876b, this.f4878d);
            }
        }

        @Override // b.a.p0.a.q0.b.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (this.f4879e.f4881d && !z) {
                    b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(this.f4875a.getApplicationContext(), h.aiapps_fav_fail);
                    f2.l(2);
                    f2.G();
                }
                this.f4879e.n(this.f4877c, this.f4876b, this.f4878d);
            }
        }

        @Override // b.a.p0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e2) {
                    if (k.f6863a) {
                        e2.printStackTrace();
                    }
                }
                if (this.f4879e.f4881d) {
                    b.m("1", "btn", "success");
                    b.a.p0.a.j0.b.a.t();
                    if (b.a.p0.a.k1.a.k(this.f4875a.x())) {
                        b.a.p0.a.k1.a.p("addmyswan", q0.n().f());
                    } else {
                        Context applicationContext = this.f4875a.getApplicationContext();
                        b.a.p0.a.c2.b.f.e g2 = b.a.p0.a.c2.b.f.e.g(applicationContext, b.a.p0.a.c1.a.l0().f(applicationContext));
                        g2.l(2);
                        g2.q(2);
                        g2.G();
                    }
                }
                UnitedSchemeUtility.safeCallback(this.f4876b, this.f4877c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f4878d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.a.p0.a.f2.e eVar) {
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
                super((b.a.p0.a.f2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.a.f2.f.e0.b
    public boolean j(b.a.p0.a.d2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, unitedSchemeEntity)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                return false;
            }
            try {
                String N = this.f4881d ? eVar.N() : new JSONObject(param).optString("appid");
                this.f4880c = N;
                return !TextUtils.isEmpty(N);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.p0.a.f2.f.e0.b
    public void k(b.a.p0.a.d2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) {
            PMSAppInfo u = b.a.p0.q.g.a.i().u(this.f4880c);
            if (u != null && !TextUtils.isEmpty(u.appId)) {
                if (this.f4881d) {
                    b.m("1", "btn", "invoke");
                } else {
                    b.m("1", RetrieveTaskManager.KEY, "invoke");
                }
                SwanFavorDataManager.h().b(this.f4880c, new C0173a(this, eVar, callbackHandler, unitedSchemeEntity, str));
                return;
            }
            n(unitedSchemeEntity, callbackHandler, str);
        }
    }

    @Override // b.a.p0.a.f2.f.e0.b
    public void l(b.a.p0.a.d2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        f0 l0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) && this.f4881d && (l0 = b.a.p0.a.c1.a.l0()) != null) {
            l0.g(eVar);
        }
    }
}
