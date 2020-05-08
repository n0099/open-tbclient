package com.baidu.swan.bdprivate.c.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends ab {
    public b(j jVar) {
        super(jVar, "/swanAPI/getCommonSysInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.i("GetSysInfo", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        final String optString = s.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.i("GetSysInfo", "cb is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        eVar.akW().b(context, "mapp_i_get_common_sys_info", new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.bdprivate.c.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void F(h<b.d> hVar) {
                b.this.a(hVar, context, callbackHandler, optString);
            }
        });
        c.i("GetSysInfo", "callback success");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h<b.d> hVar, Context context, CallbackHandler callbackHandler, String str) {
        if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
            com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, str);
        } else {
            a(context, str, callbackHandler);
        }
    }

    private void a(Context context, String str, CallbackHandler callbackHandler) {
        Context appContext = AppRuntime.getAppContext();
        String aS = com.baidu.swan.apps.w.a.abS().aS(appContext);
        String apr = ai.apr();
        String bG = com.baidu.swan.bdprivate.a.a.bG(context);
        String aR = com.baidu.swan.apps.w.a.abS().aR(appContext);
        String cookie = com.baidu.swan.apps.w.a.acl().Qi().getCookie(".baidu.com");
        String cookieValue = ag.getCookieValue(cookie, "BAIDUID");
        String cookieValue2 = ag.getCookieValue(cookie, "H_WISE_SIDS");
        if (DEBUG) {
            Log.d("GetSysInfoAction", "cuid = " + aS + ", imei = " + apr + ", zid = " + bG + ", uid = " + aR + ", baiDuId = " + cookieValue + ", sid = " + cookieValue2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cuid", aS);
            jSONObject.put("imei", apr);
            jSONObject.put("zid", bG);
            jSONObject.put("uid", aR);
            jSONObject.put("baidu_id", cookieValue);
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SID, cookieValue2);
            c.i("GetSysInfo", "fetch commonSysInfo success");
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            c.e("GetSysInfo", "generate data occur exception");
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }
}
