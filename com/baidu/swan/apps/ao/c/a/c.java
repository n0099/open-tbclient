package com.baidu.swan.apps.ao.c.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.c.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends b {
    public c(j jVar) {
        super(jVar, "/swanAPI/getBatteryInfoSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a(context, eVar, unitedSchemeEntity)) {
            a.C0205a cy = com.baidu.swan.apps.ao.c.a.cy(context);
            if (cy == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "sticky broadcast receive error");
                return false;
            }
            if (DEBUG) {
                Log.d("battery", "/swanAPI/getBatteryInfoSync = level: " + cy.level + " ; plugged: " + cy.bWD);
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
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(a, 0);
            return true;
        }
        return false;
    }
}
