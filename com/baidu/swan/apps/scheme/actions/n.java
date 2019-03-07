package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.net.URISyntaxException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n extends y {
    public n(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/openApp");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        boolean z;
        if (bVar == null) {
            com.baidu.swan.apps.console.c.i("OpenApp", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, LegoListActivityConfig.PARAMS);
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
            z = ai(context, optString);
        }
        boolean optBoolean = c.optBoolean("isNeedDownload", true);
        if (!z && !optBoolean) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1002);
            return false;
        }
        if (!z) {
            String optString2 = c.optString("download");
            if (!TextUtils.isEmpty(optString2)) {
                try {
                    JSONObject jSONObject = new JSONObject(optString2);
                    if (!TextUtils.isEmpty(jSONObject.optString("url"))) {
                        com.baidu.swan.apps.console.c.i("OpenApp", "params=" + optString2);
                        z = com.baidu.swan.apps.u.a.CI().g(context, jSONObject);
                    }
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        com.baidu.swan.apps.console.c.i("OpenApp", "open app: executeResult=" + z);
        if (z) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }
        return true;
    }

    private boolean ai(Context context, String str) {
        boolean z = true;
        try {
            Intent parseUri = Intent.parseUri(Uri.decode(str), 1);
            parseUri.setFlags(268435456);
            if (parseUri.resolveActivityInfo(context.getPackageManager(), 65536) == null) {
                z = false;
            } else {
                com.baidu.swan.apps.an.b.h(context, parseUri);
            }
            return z;
        } catch (URISyntaxException e) {
            if (!DEBUG) {
                return false;
            }
            Log.w("OpenAppAction", Log.getStackTraceString(e));
            return false;
        }
    }
}
