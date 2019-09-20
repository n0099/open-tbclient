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
public class h extends z {
    public h(j jVar) {
        super(jVar, "/swan/setTabBarStyle");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("SetTabBarStyleAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        com.baidu.swan.apps.w.e GJ = com.baidu.swan.apps.w.e.GJ();
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("setTabBarStyle", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.core.d.e vN = GJ.vN();
        if (vN == null) {
            com.baidu.swan.apps.console.c.e("setTabBarStyle", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.core.d.d Aw = vN.Aw();
        String optString = optParamsAsJo.optString("color");
        String optString2 = optParamsAsJo.optString("selectedColor");
        String optString3 = optParamsAsJo.optString("backgroundColor");
        String optString4 = optParamsAsJo.optString("borderStyle");
        if (Aw == null) {
            com.baidu.swan.apps.console.c.e("setTabBarStyle", "swanAppFragment is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.tabbar.b.a Ai = Aw.Ai();
        if (Ai == null) {
            com.baidu.swan.apps.console.c.e("setTabBarStyle", "bottomBarViewController is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!Ai.k(optString, optString2, optString3, optString4)) {
            com.baidu.swan.apps.console.c.e("setTabBarStyle", "set bottom bar style fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
