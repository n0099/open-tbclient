package com.baidu.swan.apps.scheme.actions.h;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends aa {
    public b(j jVar) {
        super(jVar, "/swanAPI/setNavigationBarColor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("BarColorAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt == null) {
            com.baidu.swan.apps.console.c.e("navigationColor", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("navigationColor", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            String optString = optParamsAsJo.optString("frontColor");
            String optString2 = optParamsAsJo.optString("backgroundColor");
            JSONObject optJSONObject = optParamsAsJo.optJSONObject("animation");
            com.baidu.swan.apps.core.d.c asU = ajt.asU();
            if (asU == null) {
                com.baidu.swan.apps.console.c.e("navigationColor", "slave container exception");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!asU.R(optString, true)) {
                com.baidu.swan.apps.console.c.e("navigationColor", "set title color fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!asU.x(SwanAppConfigData.sF(optString2), true)) {
                com.baidu.swan.apps.console.c.e("navigationColor", "set title background fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (optJSONObject != null) {
                    asU.ak(optJSONObject.optInt("duration"), optJSONObject.optString("timingFunc"));
                    com.baidu.swan.apps.console.c.i("navigationColor", "set action bar animator");
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
    }
}
