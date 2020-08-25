package com.baidu.swan.apps.al.e.a;

import android.content.Context;
import android.util.Log;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes8.dex */
public class b extends aa {
    public b(j jVar) {
        super(jVar, "/swanAPI/stopCompass");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.e(MapController.COMPASS_LAYER_TAG, "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.d("SwanAppAction", "stopCompass --- illegal swanApp");
                return false;
            }
            return false;
        } else if (context == null) {
            c.e(MapController.COMPASS_LAYER_TAG, "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (DEBUG) {
                Log.d("SwanAppAction", "stopCompass --- illegal context");
                return false;
            }
            return false;
        } else {
            c.i(MapController.COMPASS_LAYER_TAG, "stop listen compass");
            com.baidu.swan.apps.al.e.a.aDE().aDG();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
