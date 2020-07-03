package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends aa {
    public b(j jVar) {
        super(jVar, "/swanAPI/checkSession");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            com.baidu.swan.games.v.c.h(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return false;
        }
        String appKey = eVar.getAppKey();
        if (TextUtils.isEmpty(appKey)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key");
            com.baidu.swan.games.v.c.h(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            com.baidu.swan.games.v.c.h(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            com.baidu.swan.games.v.c.h(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return false;
        } else if (!eVar.apZ().isLogin(context)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in");
            com.baidu.swan.games.v.c.h(callbackHandler, unitedSchemeEntity.result.toString());
            return true;
        } else {
            com.baidu.swan.apps.runtime.d.apI().apK().Se().TF().c((Activity) context, appKey).q(new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(com.baidu.swan.apps.setting.oauth.h<JSONObject> hVar) {
                    JSONObject wrapCallbackParams;
                    if (hVar.isOk() && com.baidu.swan.apps.api.module.a.a.an(hVar.mData)) {
                        JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                        if (optJSONObject.optBoolean("result")) {
                            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                        } else {
                            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                        }
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(hVar.getErrorCode());
                        com.baidu.swan.games.v.c.h(callbackHandler, wrapCallbackParams.toString());
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, wrapCallbackParams.toString());
                }
            }).ary();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
