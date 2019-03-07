package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class s extends y {
    public s(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/performancePanel");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
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
                com.baidu.swan.apps.performance.c.d.FZ().d(optString, optString2, optLong);
            }
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
