package com.baidu.swan.apps.ap;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes25.dex */
public class ab {
    public static void aPg() {
        String aPh = aPh();
        if (!TextUtils.isEmpty(aPh)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + aPh);
            }
            WebSettingsGlobalBlink.setRefererPattern(aPh, com.baidu.swan.apps.r.d.ayR());
        }
    }

    public static String aPh() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "getFixedReferer: " + uS("https://smartapps.cn/%s/%s/page-frame.html"));
        }
        return uS("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static boolean uR(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String uS(String str) {
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        return aJU != null ? String.format(str, aJU.getAppKey(), aJU.aKq()) : "";
    }
}
