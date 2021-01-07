package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends aa {
    public a(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/abTestConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            JSONObject b2 = b(unitedSchemeEntity, "params");
            if (b2 == null || context == null) {
                Toast.makeText(context, a.h.swanapp_debug_abtest_config_params_empty, 1).show();
                return false;
            }
            JSONObject optJSONObject = b2.optJSONObject("abtest");
            if (optJSONObject != null) {
                Toast.makeText(context, bT(optJSONObject) ? a.h.swanapp_debug_abtest_config_success : a.h.swanapp_debug_abtest_config_fail, 1).show();
            } else {
                aNt();
                Toast.makeText(context, a.h.swanapp_delete_debug_abtest_config, 1).show();
            }
            return true;
        }
        return false;
    }

    private boolean bT(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String aNu = aNu();
        if (TextUtils.isEmpty(aNu)) {
            return false;
        }
        return com.baidu.swan.apps.s.a.p(aNu, jSONObject.toString(), false);
    }

    private void aNt() {
        String aNu = aNu();
        if (!TextUtils.isEmpty(aNu)) {
            File file = new File(aNu);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static String aNu() {
        File aRn = com.baidu.swan.apps.ao.k.aRn();
        if (aRn == null) {
            return null;
        }
        String path = aRn.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return path + "/debug_abtest_config.json";
    }
}
