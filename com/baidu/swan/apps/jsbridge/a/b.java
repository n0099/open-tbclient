package com.baidu.swan.apps.jsbridge.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
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
        jSONObject.put(SuspensionBallEntity.KEY_SCHEME, SchemeConfig.getSchemeHead());
        jSONObject.put("sdkExtension", b(d.ajS().ako()));
        jSONObject.put("gameSdkExtension", b(com.baidu.swan.games.j.a.aNC().ako()));
        jSONObject.put("isDebugSdk", DEBUG);
        String string = h.aDf().getString("ctsUrl", "");
        if (!TextUtils.isEmpty(string) && com.baidu.swan.apps.ad.a.a.axb()) {
            jSONObject.put("ctsJsAddress", new JSONObject(string));
        }
        String ZF = com.baidu.swan.apps.t.a.aoV().ZF();
        if (!TextUtils.isEmpty(ZF)) {
            jSONObject.put("hostName", ZF);
        }
        jSONObject.put("platform", "android");
        JSONObject aDk = com.baidu.swan.apps.swancore.a.a.aDk();
        aDk.put("swanswitch_common_sys_info_binding", true);
        aDk.put("swanswitch_ab_sync_auth", true);
        jSONObject.put("abTestSwitch", aDk);
        jSONObject.put("userDataPath", com.baidu.swan.games.i.a.USER_DATA_PATH);
        jSONObject.put("preloadId", d.ajS().akt());
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
