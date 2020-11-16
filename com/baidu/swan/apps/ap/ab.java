package com.baidu.swan.apps.ap;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes7.dex */
public class ab {
    public static void aLZ() {
        String aMa = aMa();
        if (!TextUtils.isEmpty(aMa)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + aMa);
            }
            WebSettingsGlobalBlink.setRefererPattern(aMa, com.baidu.swan.apps.r.d.avJ());
        }
    }

    public static String aMa() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "getFixedReferer: " + ul("https://smartapps.cn/%s/%s/page-frame.html"));
        }
        return ul("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static boolean uk(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String ul(String str) {
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        return aGM != null ? String.format(str, aGM.getAppKey(), aGM.aHi()) : "";
    }
}
