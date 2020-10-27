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
        jSONObject.put("sdkExtension", b(d.aph().apE()));
        jSONObject.put("gameSdkExtension", b(com.baidu.swan.games.j.a.aSQ().apE()));
        jSONObject.put("isDebugSdk", DEBUG);
        String string = h.aIs().getString("ctsUrl", "");
        if (!TextUtils.isEmpty(string) && com.baidu.swan.apps.ad.a.a.aCp()) {
            jSONObject.put("ctsJsAddress", new JSONObject(string));
        }
        String aeU = com.baidu.swan.apps.t.a.aum().aeU();
        if (!TextUtils.isEmpty(aeU)) {
            jSONObject.put("hostName", aeU);
        }
        jSONObject.put("platform", "android");
        JSONObject aIx = com.baidu.swan.apps.swancore.a.a.aIx();
        aIx.put("swanswitch_common_sys_info_binding", true);
        aIx.put("swanswitch_ab_sync_auth", true);
        jSONObject.put("abTestSwitch", aIx);
        jSONObject.put("userDataPath", com.baidu.swan.games.i.a.USER_DATA_PATH);
        jSONObject.put("preloadId", d.aph().apJ());
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
