package c.a.n0.a.c2.f.f0;

import android.text.TextUtils;
import c.a.n0.a.h;
import c.a.n0.a.k;
import c.a.n0.a.p.d.f0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.q0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.a2.e f4540a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4541b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4542c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4543d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f4544e;

        public a(d dVar, c.a.n0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, eVar, callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4544e = dVar;
            this.f4540a = eVar;
            this.f4541b = callbackHandler;
            this.f4542c = unitedSchemeEntity;
            this.f4543d = str;
        }

        @Override // c.a.n0.a.q0.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4544e.f4534d) {
                    c.a.n0.a.z1.b.f.e f2 = c.a.n0.a.z1.b.f.e.f(this.f4540a.getApplicationContext(), h.swanapp_tip_net_unavailable);
                    f2.l(2);
                    f2.F();
                }
                this.f4544e.n(this.f4542c, this.f4541b, this.f4543d);
            }
        }

        @Override // c.a.n0.a.q0.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f4544e.f4534d) {
                    c.a.n0.a.z1.b.f.e f2 = c.a.n0.a.z1.b.f.e.f(this.f4540a.getApplicationContext(), h.aiapps_cancel_fav_fail);
                    f2.l(2);
                    f2.F();
                }
                this.f4544e.n(this.f4542c, this.f4541b, this.f4543d);
            }
        }

        @Override // c.a.n0.a.q0.b.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e2) {
                    if (k.f6803a) {
                        e2.printStackTrace();
                    }
                }
                if (this.f4544e.f4534d) {
                    b.m("0", "btn", "success");
                    c.a.n0.a.z1.b.f.e f2 = c.a.n0.a.z1.b.f.e.f(this.f4540a.getApplicationContext(), h.aiapps_cancel_fav_success);
                    f2.l(2);
                    f2.F();
                }
                UnitedSchemeUtility.safeCallback(this.f4541b, this.f4542c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f4543d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/deleteFavor");
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
                super((c.a.n0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.c2.f.f0.b
    public boolean j(c.a.n0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, unitedSchemeEntity)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                return false;
            }
            try {
                String D = this.f4534d ? eVar.D() : new JSONObject(param).optString("appid");
                this.f4533c = D;
                return !TextUtils.isEmpty(D);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.n0.a.c2.f.f0.b
    public void k(c.a.n0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) {
            if (this.f4534d) {
                b.m("0", "btn", "invoke");
            } else {
                b.m("0", RetrieveTaskManager.KEY, "invoke");
            }
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            String str2 = this.f4533c;
            a aVar = new a(this, eVar, callbackHandler, unitedSchemeEntity, str);
            c.a.n0.a.n0.l.c l = c.a.n0.a.n0.l.c.l();
            l.n(3);
            h2.c(str2, aVar, l.k());
        }
    }

    @Override // c.a.n0.a.c2.f.f0.b
    public void l(c.a.n0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        f0 e0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) && this.f4534d && (e0 = c.a.n0.a.c1.a.e0()) != null) {
            e0.e(eVar);
        }
    }
}
