package com.baidu.swan.apps.tabbar.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends z {
    public g(j jVar) {
        super(jVar, "/swan/setTabBarItem");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("SetTabBarItemAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        com.baidu.swan.apps.w.e LE = com.baidu.swan.apps.w.e.LE();
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("setTabBarItem", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.core.d.e AI = LE.AI();
        if (AI == null) {
            com.baidu.swan.apps.console.c.e("setTabBarItem", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.core.d.d Fs = AI.Fs();
        int optInt = optParamsAsJo.optInt("index");
        String optString = optParamsAsJo.optString("text");
        String optString2 = optParamsAsJo.optString("iconPath");
        String optString3 = optParamsAsJo.optString("selectedIconPath");
        if (Fs == null) {
            com.baidu.swan.apps.console.c.e("setTabBarItem", "swanAppFragment is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.tabbar.b.a Fe = Fs.Fe();
        if (Fe == null) {
            com.baidu.swan.apps.console.c.e("setTabBarItem", "bottomBarViewController is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!Fe.c(optInt, optString, optString2, optString3)) {
            com.baidu.swan.apps.console.c.e("setTabBarItem", "set bottom bar time fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
