package b.a.p0.a.c2.f.f0;

import android.text.TextUtils;
import b.a.p0.a.h;
import b.a.p0.a.k;
import b.a.p0.a.p.d.f0;
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
    public class a implements b.a.p0.a.q0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f4207a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4208b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4209c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4210d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f4211e;

        public a(d dVar, b.a.p0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
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
            this.f4211e = dVar;
            this.f4207a = eVar;
            this.f4208b = callbackHandler;
            this.f4209c = unitedSchemeEntity;
            this.f4210d = str;
        }

        @Override // b.a.p0.a.q0.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4211e.f4201d) {
                    b.a.p0.a.z1.b.f.e f2 = b.a.p0.a.z1.b.f.e.f(this.f4207a.getApplicationContext(), h.swanapp_tip_net_unavailable);
                    f2.l(2);
                    f2.F();
                }
                this.f4211e.n(this.f4209c, this.f4208b, this.f4210d);
            }
        }

        @Override // b.a.p0.a.q0.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f4211e.f4201d) {
                    b.a.p0.a.z1.b.f.e f2 = b.a.p0.a.z1.b.f.e.f(this.f4207a.getApplicationContext(), h.aiapps_cancel_fav_fail);
                    f2.l(2);
                    f2.F();
                }
                this.f4211e.n(this.f4209c, this.f4208b, this.f4210d);
            }
        }

        @Override // b.a.p0.a.q0.b.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e2) {
                    if (k.f6397a) {
                        e2.printStackTrace();
                    }
                }
                if (this.f4211e.f4201d) {
                    b.m("0", "btn", "success");
                    b.a.p0.a.z1.b.f.e f2 = b.a.p0.a.z1.b.f.e.f(this.f4207a.getApplicationContext(), h.aiapps_cancel_fav_success);
                    f2.l(2);
                    f2.F();
                }
                UnitedSchemeUtility.safeCallback(this.f4208b, this.f4209c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f4210d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b.a.p0.a.c2.e eVar) {
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
                super((b.a.p0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.a.c2.f.f0.b
    public boolean j(b.a.p0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, unitedSchemeEntity)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                return false;
            }
            try {
                String k = this.f4201d ? eVar.k() : new JSONObject(param).optString("appid");
                this.f4200c = k;
                return !TextUtils.isEmpty(k);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.p0.a.c2.f.f0.b
    public void k(b.a.p0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) {
            if (this.f4201d) {
                b.m("0", "btn", "invoke");
            } else {
                b.m("0", RetrieveTaskManager.KEY, "invoke");
            }
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            String str2 = this.f4200c;
            a aVar = new a(this, eVar, callbackHandler, unitedSchemeEntity, str);
            b.a.p0.a.n0.l.c l = b.a.p0.a.n0.l.c.l();
            l.n(3);
            h2.c(str2, aVar, l.k());
        }
    }

    @Override // b.a.p0.a.c2.f.f0.b
    public void l(b.a.p0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        f0 e0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) && this.f4201d && (e0 = b.a.p0.a.c1.a.e0()) != null) {
            e0.e(eVar);
        }
    }
}
