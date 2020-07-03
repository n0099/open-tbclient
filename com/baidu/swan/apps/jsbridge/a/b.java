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
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @NonNull
    public static String getEnvVariables() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, SchemeConfig.getSchemeHead());
            jSONObject.put("sdkExtension", b(d.acr().acN()));
            jSONObject.put("gameSdkExtension", b(com.baidu.swan.games.j.a.aBj().acN()));
            jSONObject.put("isDebugSdk", DEBUG);
            String string = h.asV().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && com.baidu.swan.apps.af.a.a.anv()) {
                jSONObject.put("ctsJsAddress", new JSONObject(string));
            }
            if (com.baidu.swan.apps.u.a.agj() != null) {
                String Tk = com.baidu.swan.apps.u.a.agj().Tk();
                if (!TextUtils.isEmpty(Tk)) {
                    jSONObject.put("hostName", Tk);
                }
            }
            jSONObject.put("platform", "android");
            jSONObject.put("abTestSwitch", com.baidu.swan.apps.swancore.a.a.ata());
            jSONObject.put("userDataPath", com.baidu.swan.games.i.a.USER_DATA_PATH);
        } catch (JSONException e) {
            if (DEBUG) {
                throw new RuntimeException(e);
            }
            e.printStackTrace();
        }
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
