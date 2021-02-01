package com.baidu.swan.apps.tabbar.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class i extends a {
    public i(j jVar) {
        super(jVar, "/swanAPI/setTabBarStyle");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("SetTabBarStyleAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (ajZ()) {
            com.baidu.swan.apps.console.c.e("SetTabBarStyleAction", "fail not TabBar page");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fail not TabBar page");
            return false;
        }
        com.baidu.swan.apps.tabbar.b.a ajY = ajY();
        if (ajY == null) {
            com.baidu.swan.apps.console.c.e("setTabBarStyle", "tabBarViewController is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("setTabBarStyle", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!ajY.s(optParamsAsJo.optString("color"), optParamsAsJo.optString("selectedColor"), optParamsAsJo.optString("backgroundColor"), optParamsAsJo.optString("borderStyle"))) {
            com.baidu.swan.apps.console.c.e("setTabBarStyle", "set bottom bar style fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
