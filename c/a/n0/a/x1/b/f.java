package c.a.n0.a.x1.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.p2.o0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.w;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x1.c.j.b;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7573b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7574c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f7575d;

        public a(f fVar, Context context, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7575d = fVar;
            this.a = context;
            this.f7573b = callbackHandler;
            this.f7574c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f7575d.l(iVar, this.a, this.f7573b, this.f7574c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/getCommonSysInfo");
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
            if (eVar == null) {
                c.a.n0.a.u.d.i("GetSysInfo", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.n0.a.u.d.i("GetSysInfo", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            eVar.d0().g((Activity) context, "mapp_i_get_common_sys_info", new a(this, context, callbackHandler, optString));
            c.a.n0.a.u.d.i("GetSysInfo", "callback success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(Context context, String str, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, callbackHandler) == null) {
            String i = c.a.n0.a.s0.a.h0().i(AppRuntime.getAppContext());
            String r = q0.r();
            String a2 = c.a.n0.a.s0.a.G0().a(context);
            String h2 = c.a.n0.a.s0.a.h0().h(context);
            String cookie = c.a.n0.a.s0.a.q().a().getCookie(".baidu.com");
            String l = o0.l(cookie, "BAIDUID");
            String l2 = o0.l(cookie, "H_WISE_SIDS");
            String a3 = c.a.n0.x.b.b(AppRuntime.getAppContext()).a();
            if (z.f6924b) {
                Log.d("GetSysInfoAction", "cuid = " + i + ", imei = " + r + ", zid = " + a2 + ", uid = " + h2 + ", baiDuId = " + l + ", sid = " + l2);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cuid", i);
                jSONObject.put("imei", r);
                jSONObject.put("zid", a2);
                jSONObject.put("uid", h2);
                jSONObject.put("baidu_id", l);
                jSONObject.put("sid", l2);
                jSONObject.put("uuid", a3);
                c.a.n0.a.u.d.i("GetSysInfo", "fetch commonSysInfo success");
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            } catch (JSONException e2) {
                if (z.f6924b) {
                    e2.printStackTrace();
                }
                c.a.n0.a.u.d.c("GetSysInfo", "generate data occur exception");
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final void l(c.a.n0.a.x1.c.i<b.e> iVar, Context context, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, iVar, context, callbackHandler, str) == null) {
            if (!c.a.n0.a.x1.c.d.h(iVar)) {
                c.a.n0.a.x1.c.d.q(iVar, callbackHandler, str);
            } else {
                k(context, str, callbackHandler);
            }
        }
    }
}
