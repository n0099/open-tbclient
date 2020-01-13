package com.baidu.swan.apps.tabbar.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends a {
    public b(j jVar) {
        super(jVar, "/swanAPI/closeTabBar");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("closeTabBar", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (Hx()) {
            com.baidu.swan.apps.console.c.e("CloseTabBarAction", "fail not TabBar page");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fail not TabBar page");
            return false;
        } else {
            com.baidu.swan.apps.tabbar.b.a Hw = Hw();
            if (Hw == null) {
                com.baidu.swan.apps.console.c.e("CloseTabBarAction", "tabBarViewController is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!Hw.dR(optParamsAsJo.optBoolean("animation"))) {
                com.baidu.swan.apps.console.c.e("closeTabBar", "close tab bar fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
    }
}
