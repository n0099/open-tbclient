package com.baidu.swan.apps.storage.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes9.dex */
public class f extends aa {
    public f(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/getStorage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("SwanAppAction", "start get storage");
        }
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String aX = com.baidu.swan.apps.api.module.i.a.aX(optParamsAsJo);
        if (aX == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String string = eVar.aMv().aPr().getString(aX, null);
        if (string == null && com.baidu.swan.apps.storage.c.dOx) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, "data not found");
            return false;
        }
        JSONObject lY = com.baidu.swan.apps.api.module.i.a.lY(string);
        if (lY == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "JSONException");
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(lY, 0));
        return true;
    }
}
