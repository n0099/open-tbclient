package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.ai;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class w extends ab {
    public w(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/preloadSwanCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("PreloadSwanCoreAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (!ProcessUtils.isMainProcess()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal process");
            return false;
        }
        JSONObject b = b(unitedSchemeEntity, "params");
        int optInt = b == null ? 0 : b.optInt("delay", 0);
        if (optInt < 0) {
            optInt = 0;
        }
        if (DEBUG) {
            Log.d("PreloadSwanCoreAction", "delay: " + optInt);
        }
        ai.b(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.w.1
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "5");
                com.baidu.swan.apps.process.messaging.service.b.b(context, bundle);
            }
        }, optInt);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
