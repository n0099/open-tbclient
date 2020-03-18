package com.baidu.swan.apps.tabbar.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends a {
    public f(j jVar) {
        super(jVar, "/swanAPI/openTabBarRedDot");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("openTabBarRedDot", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        int optInt = optParamsAsJo.optInt("index");
        if (JR()) {
            com.baidu.swan.apps.console.c.e("OpenTabBarRedDotAction", "fail not TabBar page");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fail not TabBar page");
            return false;
        }
        com.baidu.swan.apps.tabbar.b.a JQ = JQ();
        if (JQ == null) {
            com.baidu.swan.apps.console.c.e("OpenTabBarRedDotAction", "tabBarViewController is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!JQ.ha(optInt)) {
            com.baidu.swan.apps.console.c.e("openTabBarRedDot", "open red dot fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
