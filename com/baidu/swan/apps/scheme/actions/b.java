package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes2.dex */
public class b extends z {
    public b(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/applyUpdate");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            com.baidu.swan.apps.console.c.e("applyUpdate", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (!(context instanceof SwanAppActivity)) {
            com.baidu.swan.apps.console.c.e("applyUpdate", "context is not SwanAppActivity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else {
            SwanAppActivity swanAppActivity = (SwanAppActivity) context;
            String FH = swanAppActivity.vL().FH();
            if (TextUtils.isEmpty(FH)) {
                com.baidu.swan.apps.console.c.e("applyUpdate", "launchScheme is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty launchScheme");
                return false;
            }
            swanAppActivity.vK();
            SchemeRouter.invoke(swanAppActivity, FH);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
