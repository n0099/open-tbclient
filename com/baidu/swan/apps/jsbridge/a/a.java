package com.baidu.swan.apps.jsbridge.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.i.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.storage.b.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    @NonNull
    public static String getEnvVariables() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scheme", SchemeConfig.getSchemeHead());
            ExtensionCore As = c.Aa().As();
            String str = "";
            if (As != null && !TextUtils.isEmpty(As.avQ)) {
                str = As.avQ;
            }
            jSONObject.put("sdkExtension", str);
            jSONObject.put("isDebugSdk", DEBUG);
            String string = f.KJ().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && com.baidu.swan.apps.ac.a.a.Gg()) {
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
