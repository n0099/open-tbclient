package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t extends aa {
    public t(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/performancePanel");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (!com.baidu.swan.apps.v.f.azg().ayK() && !DEBUG) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not debug app model");
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            JSONArray optJSONArray = optParamsAsJo.optJSONArray("data");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty data");
                return false;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("slaveId");
                    String optString2 = optJSONObject.optString("actionName");
                    long optLong = optJSONObject.optLong("timestamp", -1L);
                    if (DEBUG) {
                        Log.i("performancePanel", "slaveId: " + optString + ", actionName: " + optString2 + ", timestamp: " + optLong);
                    }
                    com.baidu.swan.apps.performance.e.d.aDG().d(optString, optString2, optLong);
                }
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
