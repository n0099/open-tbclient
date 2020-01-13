package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class q extends ab {
    public q(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/openStatisticEvent");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("bizId", "-1");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty flowId");
            return false;
        }
        try {
            optParamsAsJo.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
            optParamsAsJo.putOpt("eventType", "0");
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.console.c.i("OpenStatisticEvent", "OpenStat : " + optParamsAsJo);
        com.baidu.swan.ubc.s.k(optString, optParamsAsJo);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
