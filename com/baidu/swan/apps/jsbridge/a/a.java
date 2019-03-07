package com.baidu.swan.apps.jsbridge.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.storage.b.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = c.DEBUG;

    @NonNull
    public static String getEnvVariables() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scheme", SchemeConfig.getSchemeHead());
            ExtensionCore At = com.baidu.swan.apps.core.i.c.Ab().At();
            String str = "";
            if (At != null && !TextUtils.isEmpty(At.avM)) {
                str = At.avM;
            }
            jSONObject.put("sdkExtension", str);
            jSONObject.put("isDebugSdk", DEBUG);
            String string = f.KL().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && com.baidu.swan.apps.ac.a.a.Gi()) {
                jSONObject.put("ctsServerAddress", new JSONObject(string));
            }
            jSONObject.put("platform", "android");
        } catch (JSONException e) {
            if (DEBUG) {
                throw new RuntimeException(e);
            }
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
    }
}
