package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.as.ai;
/* loaded from: classes9.dex */
public class c extends ab {
    public c(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/applyUpdate");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("applyUpdate", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (!(context instanceof SwanAppActivity)) {
            com.baidu.swan.apps.console.c.e("applyUpdate", "context is not SwanAppActivity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else {
            final SwanAppActivity swanAppActivity = (SwanAppActivity) context;
            Intent intent = swanAppActivity.getIntent();
            if (swanAppActivity.isDestroyed() || intent == null) {
                com.baidu.swan.apps.console.c.e("applyUpdate", "launchScheme is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty launchScheme");
                return false;
            }
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.c.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.utils.a.m(swanAppActivity);
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
