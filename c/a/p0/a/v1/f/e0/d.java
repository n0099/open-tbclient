package c.a.p0.a.v1.f.e0;

import android.text.TextUtils;
import c.a.p0.a.f.d.f0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.tieba.R;
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
    public class a implements c.a.p0.a.g0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.t1.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7855b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7856c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f7857d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f7858e;

        public a(d dVar, c.a.p0.a.t1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
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
            this.f7858e = dVar;
            this.a = eVar;
            this.f7855b = callbackHandler;
            this.f7856c = unitedSchemeEntity;
            this.f7857d = str;
        }

        @Override // c.a.p0.a.g0.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f7858e.f7849d) {
                    c.a.p0.a.s1.b.f.e f2 = c.a.p0.a.s1.b.f.e.f(this.a.getApplicationContext(), R.string.swanapp_tip_net_unavailable);
                    f2.l(2);
                    f2.G();
                }
                this.f7858e.n(this.f7856c, this.f7855b, this.f7857d);
            }
        }

        @Override // c.a.p0.a.g0.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e2) {
                    if (c.a.p0.a.a.a) {
                        e2.printStackTrace();
                    }
                }
                if (this.f7858e.f7849d) {
                    b.m("0", "btn", "success");
                    c.a.p0.a.s1.b.f.e f2 = c.a.p0.a.s1.b.f.e.f(this.a.getApplicationContext(), R.string.aiapps_cancel_fav_success);
                    f2.l(2);
                    f2.G();
                }
                UnitedSchemeUtility.safeCallback(this.f7855b, this.f7856c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f7857d);
            }
        }

        @Override // c.a.p0.a.g0.b.b
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (this.f7858e.f7849d && !z) {
                    c.a.p0.a.s1.b.f.e f2 = c.a.p0.a.s1.b.f.e.f(this.a.getApplicationContext(), R.string.aiapps_cancel_fav_fail);
                    f2.l(2);
                    f2.G();
                }
                this.f7858e.n(this.f7856c, this.f7855b, this.f7857d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c.a.p0.a.v1.e eVar) {
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
                super((c.a.p0.a.v1.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.v1.f.e0.b
    public boolean j(c.a.p0.a.t1.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, unitedSchemeEntity)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                return false;
            }
            try {
                String N = this.f7849d ? eVar.N() : new JSONObject(param).optString("appid");
                this.f7848c = N;
                return !TextUtils.isEmpty(N);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.p0.a.v1.f.e0.b
    public void k(c.a.p0.a.t1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) {
            if (this.f7849d) {
                b.m("0", "btn", "invoke");
            } else {
                b.m("0", RetrieveTaskManager.KEY, "invoke");
            }
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            String str2 = this.f7848c;
            a aVar = new a(this, eVar, callbackHandler, unitedSchemeEntity, str);
            c.a.p0.a.d0.l.c l = c.a.p0.a.d0.l.c.l();
            l.n(3);
            h2.c(str2, aVar, l.k());
        }
    }

    @Override // c.a.p0.a.v1.f.e0.b
    public void l(c.a.p0.a.t1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        f0 l0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) && this.f7849d && (l0 = c.a.p0.a.s0.a.l0()) != null) {
            l0.e(eVar);
        }
    }
}
