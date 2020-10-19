package com.baidu.swan.apps.ap;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes10.dex */
public class ab {
    public static void aIn() {
        String aIo = aIo();
        if (!TextUtils.isEmpty(aIo)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + aIo);
            }
            WebSettingsGlobalBlink.setRefererPattern(aIo, com.baidu.swan.apps.r.d.arW());
        }
    }

    public static String aIo() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "getFixedReferer: " + tJ("https://smartapps.cn/%s/%s/page-frame.html"));
        }
        return tJ("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static boolean tI(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String tJ(String str) {
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        return aDa != null ? String.format(str, aDa.getAppKey(), aDa.aDw()) : "";
    }
}
