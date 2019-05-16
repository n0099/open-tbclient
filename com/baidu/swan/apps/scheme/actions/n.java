package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n extends z {
    public n(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/openApp");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        boolean z;
        if (bVar == null) {
            com.baidu.swan.apps.console.c.i("OpenApp", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            com.baidu.swan.apps.console.c.i("OpenApp", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
            return false;
        }
        String optString = c.optString("open");
        if (TextUtils.isEmpty(optString)) {
            z = false;
        } else {
            com.baidu.swan.apps.console.c.i("OpenApp", "open app: url=" + optString);
            z = com.baidu.swan.apps.an.ac.Z(context, optString);
        }
        boolean optBoolean = c.optBoolean("isNeedDownload", true);
        if (!z && !optBoolean) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1002);
            return false;
        }
        if (!z) {
            z = com.baidu.swan.apps.an.ac.aa(context, c.optString("download"));
        }
        com.baidu.swan.apps.console.c.i("OpenApp", "open app: executeResult=" + z);
        if (z) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }
        return true;
    }
}
