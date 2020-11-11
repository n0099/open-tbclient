package com.baidu.swan.apps.al.c.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.al.c.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends b {
    public c(j jVar) {
        super(jVar, "/swanAPI/getBatteryInfoSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a(context, eVar, unitedSchemeEntity)) {
            a.C0376a cA = com.baidu.swan.apps.al.c.a.cA(context);
            if (cA == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "sticky broadcast receive error");
                return false;
            }
            if (DEBUG) {
                Log.d("battery", "/swanAPI/getBatteryInfoSync = level: " + cA.level + " ; plugged: " + cA.dBD);
            }
            JSONObject a2 = a(cA);
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Json error");
                if (DEBUG) {
                    Log.d("SwanAppAction", "getBatteryInfoSync --- json error");
                    return false;
                }
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(a2, 0);
            return true;
        }
        return false;
    }
}
