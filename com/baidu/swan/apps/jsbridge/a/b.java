package com.baidu.swan.apps.jsbridge.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
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
        jSONObject.put("sdkExtension", b(d.ase().asB()));
        jSONObject.put("gameSdkExtension", b(com.baidu.swan.games.j.a.aWA().asB()));
        jSONObject.put("isDebugSdk", DEBUG);
        String string = h.aMh().getString("ctsUrl", "");
        if (!TextUtils.isEmpty(string) && com.baidu.swan.apps.ad.a.a.aFk()) {
            jSONObject.put("ctsJsAddress", new JSONObject(string));
        }
        String ahH = com.baidu.swan.apps.t.a.axi().ahH();
        if (!TextUtils.isEmpty(ahH)) {
            jSONObject.put("hostName", ahH);
        }
        jSONObject.put("platform", HttpConstants.OS_TYPE_VALUE);
        JSONObject aMm = com.baidu.swan.apps.swancore.a.a.aMm();
        aMm.put("swanswitch_common_sys_info_binding", true);
        aMm.put("swanswitch_ab_sync_auth", true);
        jSONObject.put("abTestSwitch", aMm);
        jSONObject.put("userDataPath", com.baidu.swan.games.i.a.USER_DATA_PATH);
        jSONObject.put("preloadId", d.ase().asG());
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
