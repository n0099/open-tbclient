package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends ab {
    public a(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/abTestConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            JSONObject b = b(unitedSchemeEntity, "params");
            if (b == null || context == null) {
                Toast.makeText(context, a.h.swanapp_debug_abtest_config_params_empty, 1).show();
                return false;
            }
            JSONObject optJSONObject = b.optJSONObject("abtest");
            if (optJSONObject != null) {
                Toast.makeText(context, aJ(optJSONObject) ? a.h.swanapp_debug_abtest_config_success : a.h.swanapp_debug_abtest_config_fail, 1).show();
            } else {
                adI();
                Toast.makeText(context, a.h.swanapp_delete_debug_abtest_config, 1).show();
            }
            return true;
        }
        return false;
    }

    private boolean aJ(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String adJ = adJ();
        if (TextUtils.isEmpty(adJ)) {
            return false;
        }
        return com.baidu.swan.apps.v.a.k(adJ, jSONObject.toString(), false);
    }

    private void adI() {
        String adJ = adJ();
        if (!TextUtils.isEmpty(adJ)) {
            File file = new File(adJ);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static String adJ() {
        File agG = com.baidu.swan.apps.as.i.agG();
        if (agG == null) {
            return null;
        }
        String path = agG.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return path + "/debug_abtest_config.json";
    }
}
