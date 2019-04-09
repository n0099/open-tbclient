package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class v extends y {
    public v(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/preloadSwanCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("PreloadSwanCoreAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (!ProcessUtils.isMainProcess()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal process");
            return false;
        }
        com.baidu.swan.apps.core.a.c.aoI = unitedSchemeEntity.getParam(ImageViewerConfig.ABTEST);
        com.baidu.swan.apps.v.a.setInfo(com.baidu.swan.apps.core.a.c.aoI);
        JSONObject c = c(unitedSchemeEntity, "params");
        int optInt = c == null ? 0 : c.optInt("delay", 0);
        if (optInt < 0) {
            optInt = 0;
        }
        if (DEBUG) {
            Log.d("PreloadSwanCoreAction", "delay: " + optInt);
            Log.d("PreloadSwanCoreAction", "abtest: " + com.baidu.swan.apps.core.a.c.aoI);
        }
        com.baidu.swan.apps.an.aa.b(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.v.1
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "5");
                com.baidu.swan.apps.process.messaging.service.c.c(context, bundle);
            }
        }, optInt);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
