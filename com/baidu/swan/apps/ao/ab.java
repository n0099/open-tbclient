package com.baidu.swan.apps.ao;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes8.dex */
public class ab {
    public static void aNE() {
        String aNF = aNF();
        if (!TextUtils.isEmpty(aNF)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + aNF);
            }
            WebSettingsGlobalBlink.setRefererPattern(aNF, com.baidu.swan.apps.r.d.awp());
        }
    }

    public static String aNF() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "getFixedReferer: " + tG("https://smartapps.cn/%s/%s/page-frame.html"));
        }
        return tG("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static boolean tF(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String tG(String str) {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        return aIr != null ? String.format(str, aIr.getAppKey(), aIr.aIN()) : "";
    }
}
