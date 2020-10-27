package com.baidu.swan.apps.ap;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes10.dex */
public class ab {
    public static void aKh() {
        String aKi = aKi();
        if (!TextUtils.isEmpty(aKi)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + aKi);
            }
            WebSettingsGlobalBlink.setRefererPattern(aKi, com.baidu.swan.apps.r.d.atR());
        }
    }

    public static String aKi() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "getFixedReferer: " + uc("https://smartapps.cn/%s/%s/page-frame.html"));
        }
        return uc("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static boolean ub(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String uc(String str) {
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        return aEU != null ? String.format(str, aEU.getAppKey(), aEU.aFq()) : "";
    }
}
