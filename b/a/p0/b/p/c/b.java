package b.a.p0.b.p.c;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.c2.e;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e0.d;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.v2.o0;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.Domains;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f9459e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9460f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9461g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f9462h;

        public a(b bVar, Context context, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9462h = bVar;
            this.f9459e = context;
            this.f9460f = callbackHandler;
            this.f9461g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f9462h.l(iVar, this.f9459e, this.f9460f, this.f9461g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar) {
        super(eVar, "/swanAPI/getCommonSysInfo");
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                d.g("GetSysInfo", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.g("GetSysInfo", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            eVar.S().g(context, "mapp_i_get_common_sys_info", new a(this, context, callbackHandler, optString));
            d.g("GetSysInfo", "callback success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(Context context, String str, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, callbackHandler) == null) {
            Context appContext = AppRuntime.getAppContext();
            String i2 = b.a.p0.a.c1.a.a0().i(appContext);
            String r = q0.r();
            String D = b.a.p0.b.l.a.D(context);
            String h2 = b.a.p0.a.c1.a.a0().h(appContext);
            String cookie = b.a.p0.a.c1.a.p().a().getCookie(Domains.BAIDU);
            String l = o0.l(cookie, "BAIDUID");
            String l2 = o0.l(cookie, "H_WISE_SIDS");
            String a2 = b.a.p0.u.b.b(AppRuntime.getAppContext()).a();
            if (a0.f4160b) {
                String str2 = "cuid = " + i2 + ", imei = " + r + ", zid = " + D + ", uid = " + h2 + ", baiDuId = " + l + ", sid = " + l2;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cuid", i2);
                jSONObject.put("imei", r);
                jSONObject.put("zid", D);
                jSONObject.put("uid", h2);
                jSONObject.put("baidu_id", l);
                jSONObject.put("sid", l2);
                jSONObject.put("uuid", a2);
                d.g("GetSysInfo", "fetch commonSysInfo success");
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            } catch (JSONException e2) {
                if (a0.f4160b) {
                    e2.printStackTrace();
                }
                d.b("GetSysInfo", "generate data occur exception");
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final void l(i<b.e> iVar, Context context, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, iVar, context, callbackHandler, str) == null) {
            if (!b.a.p0.a.e2.c.d.h(iVar)) {
                b.a.p0.a.e2.c.d.p(iVar, callbackHandler, str);
            } else {
                k(context, str, callbackHandler);
            }
        }
    }
}
