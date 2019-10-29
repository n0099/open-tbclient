package com.baidu.swan.apps.tabbar.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends z {
    public e(j jVar) {
        super(jVar, "/swan/openTabBarRedDot");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("openTabBarRedDot", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        int optInt = optParamsAsJo.optInt("index");
        com.baidu.swan.apps.core.d.e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH == null) {
            com.baidu.swan.apps.console.c.e("openTabBarRedDot", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.core.d.d Fr = AH.Fr();
        if (Fr == null) {
            com.baidu.swan.apps.console.c.e("openTabBarRedDot", "swanAppFragment is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.tabbar.b.a Fd = Fr.Fd();
        if (Fd == null) {
            com.baidu.swan.apps.console.c.e("openTabBarRedDot", "bottomBarViewController is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!Fd.ft(optInt)) {
            com.baidu.swan.apps.console.c.e("openTabBarRedDot", "open red dot fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
