package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends aa {
    public a(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/abTestConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            JSONObject b = b(unitedSchemeEntity, "params");
            if (b == null || context == null) {
                Toast.makeText(context, a.h.swanapp_debug_abtest_config_params_empty, 1).show();
                return false;
            }
            JSONObject optJSONObject = b.optJSONObject("abtest");
            if (optJSONObject != null) {
                Toast.makeText(context, bw(optJSONObject) ? a.h.swanapp_debug_abtest_config_success : a.h.swanapp_debug_abtest_config_fail, 1).show();
            } else {
                aAQ();
                Toast.makeText(context, a.h.swanapp_delete_debug_abtest_config, 1).show();
            }
            return true;
        }
        return false;
    }

    private boolean bw(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String aAR = aAR();
        if (TextUtils.isEmpty(aAR)) {
            return false;
        }
        return com.baidu.swan.apps.s.a.l(aAR, jSONObject.toString(), false);
    }

    private void aAQ() {
        String aAR = aAR();
        if (!TextUtils.isEmpty(aAR)) {
            File file = new File(aAR);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static String aAR() {
        File aEJ = com.baidu.swan.apps.ap.k.aEJ();
        if (aEJ == null) {
            return null;
        }
        String path = aEJ.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return path + "/debug_abtest_config.json";
    }
}
