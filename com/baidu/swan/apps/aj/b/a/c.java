package com.baidu.swan.apps.aj.b.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aj.b.a;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends b {
    public c(j jVar) {
        super(jVar, "/swan/getBatteryInfoSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (a(context, bVar, unitedSchemeEntity)) {
            a.C0156a bF = com.baidu.swan.apps.aj.b.a.bF(context);
            if (bF == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "sticky broadcast receive error");
                return false;
            }
            if (DEBUG) {
                Log.d("battery", "/swan/getBatteryInfoSync = level: " + bF.level + " ; plugged: " + bF.bqu);
            }
            JSONObject a = a(bF);
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
