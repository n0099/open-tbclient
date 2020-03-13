package com.baidu.swan.apps.ao.c.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.c.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends b {
    public a(j jVar) {
        super(jVar, "/swanAPI/getBatteryInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a(context, eVar, unitedSchemeEntity)) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                if (DEBUG) {
                    Log.d("SwanAppAction", "getBatteryInfo --- params is empty");
                }
                com.baidu.swan.apps.console.c.e("battery", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (DEBUG) {
                    Log.d("SwanAppAction", "getBatteryInfo --- cb is empty");
                }
                com.baidu.swan.apps.console.c.e("battery", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            a.C0205a cy = com.baidu.swan.apps.ao.c.a.cy(context);
            if (cy == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "sticky broadcast receive error");
                return false;
            }
            if (DEBUG) {
                Log.d("battery", "/swanAPI/getBatteryInfo = level: " + cy.level + " ; plugged: " + cy.bWF);
            }
            JSONObject a = a(cy);
            if (a == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Json error");
                if (DEBUG) {
                    Log.d("SwanAppAction", "getBatteryInfoSync --- json error");
                    return false;
                }
                return false;
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a, 0).toString(), optString);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return false;
    }
}
