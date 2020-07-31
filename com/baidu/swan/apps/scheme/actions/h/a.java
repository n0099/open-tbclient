package com.baidu.swan.apps.scheme.actions.h;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes7.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/hideNavigationBarLoading");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("SwanAppAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc == null) {
            com.baidu.swan.apps.console.c.e("navigationLoading", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.core.d.c aaZ = Sc.aaZ();
        if (aaZ == null) {
            com.baidu.swan.apps.console.c.e("navigationLoading", "swanAppFragment is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!aaZ.aay()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("navigationLoading", "hide navigation loading progressbar fail");
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
