package c.a.r0.a.h2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.z2.o0;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.w;
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
public class f extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f7180e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7181f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7182g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f7183h;

        public a(f fVar, Context context, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7183h = fVar;
            this.f7180e = context;
            this.f7181f = callbackHandler;
            this.f7182g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f7183h.l(iVar, this.f7180e, this.f7181f, this.f7182g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.r0.a.f2.e eVar) {
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.r0.a.e0.d.i("GetSysInfo", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.r0.a.e0.d.i("GetSysInfo", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            eVar.d0().g((Activity) context, "mapp_i_get_common_sys_info", new a(this, context, callbackHandler, optString));
            c.a.r0.a.e0.d.i("GetSysInfo", "callback success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(Context context, String str, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, callbackHandler) == null) {
            String i2 = c.a.r0.a.c1.a.h0().i(AppRuntime.getAppContext());
            String r = q0.r();
            String a2 = c.a.r0.a.c1.a.G0().a(context);
            String h2 = c.a.r0.a.c1.a.h0().h(context);
            String cookie = c.a.r0.a.c1.a.q().a().getCookie(Domains.BAIDU);
            String l = o0.l(cookie, "BAIDUID");
            String l2 = o0.l(cookie, "H_WISE_SIDS");
            String a3 = c.a.r0.x.b.b(AppRuntime.getAppContext()).a();
            if (z.f6343b) {
                String str2 = "cuid = " + i2 + ", imei = " + r + ", zid = " + a2 + ", uid = " + h2 + ", baiDuId = " + l + ", sid = " + l2;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cuid", i2);
                jSONObject.put("imei", r);
                jSONObject.put("zid", a2);
                jSONObject.put("uid", h2);
                jSONObject.put("baidu_id", l);
                jSONObject.put("sid", l2);
                jSONObject.put("uuid", a3);
                c.a.r0.a.e0.d.i("GetSysInfo", "fetch commonSysInfo success");
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            } catch (JSONException e2) {
                if (z.f6343b) {
                    e2.printStackTrace();
                }
                c.a.r0.a.e0.d.c("GetSysInfo", "generate data occur exception");
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final void l(c.a.r0.a.h2.c.i<b.e> iVar, Context context, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, iVar, context, callbackHandler, str) == null) {
            if (!c.a.r0.a.h2.c.d.h(iVar)) {
                c.a.r0.a.h2.c.d.q(iVar, callbackHandler, str);
            } else {
                k(context, str, callbackHandler);
            }
        }
    }
}
