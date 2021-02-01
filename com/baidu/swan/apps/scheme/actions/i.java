package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes9.dex */
public class i extends aa {
    public i(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/getAppInfoSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("GetAppInfoSyncAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("appInfo", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONObject a2 = com.baidu.swan.apps.api.module.h.a.a(eVar, context);
            if (DEBUG && a2 != null) {
                Log.d("GetAppInfoSyncAction", "data: " + a2.toString());
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(a2, 0);
            return true;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("GetAppInfoSyncAction", Log.getStackTraceString(e));
            }
            com.baidu.swan.apps.console.c.e("appInfo", Log.getStackTraceString(e));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }
}
