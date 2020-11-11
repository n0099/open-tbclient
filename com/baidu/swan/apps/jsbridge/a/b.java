package com.baidu.swan.apps.jsbridge.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @NonNull
    public static String f(com.baidu.swan.apps.core.container.a aVar) {
        JSONObject jSONObject = new JSONObject();
        if (aVar != null) {
            try {
                jSONObject.put("containerId", aVar.getContainerId());
            } catch (JSONException e) {
                if (DEBUG) {
                    throw new RuntimeException(e);
                }
                e.printStackTrace();
            }
        }
        jSONObject.put("scheme", SchemeConfig.getSchemeHead());
        jSONObject.put("sdkExtension", b(d.arI().ase()));
        jSONObject.put("gameSdkExtension", b(com.baidu.swan.games.j.a.aVq().ase()));
        jSONObject.put("isDebugSdk", DEBUG);
        String string = h.aKS().getString("ctsUrl", "");
        if (!TextUtils.isEmpty(string) && com.baidu.swan.apps.ad.a.a.aEP()) {
            jSONObject.put("ctsJsAddress", new JSONObject(string));
        }
        String ahu = com.baidu.swan.apps.t.a.awM().ahu();
        if (!TextUtils.isEmpty(ahu)) {
            jSONObject.put("hostName", ahu);
        }
        jSONObject.put("platform", "android");
        JSONObject aKX = com.baidu.swan.apps.swancore.a.a.aKX();
        aKX.put("swanswitch_common_sys_info_binding", true);
        aKX.put("swanswitch_ab_sync_auth", true);
        jSONObject.put("abTestSwitch", aKX);
        jSONObject.put("userDataPath", com.baidu.swan.games.i.a.USER_DATA_PATH);
        jSONObject.put("preloadId", d.arI().asj());
        String jSONObject2 = jSONObject.toString();
        return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
    }

    private static String b(ExtensionCore extensionCore) {
        if (extensionCore == null || TextUtils.isEmpty(extensionCore.extensionCorePath)) {
            return "";
        }
        return extensionCore.extensionCorePath;
    }
}
