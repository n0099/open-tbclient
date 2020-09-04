package com.baidu.swan.apps.ap;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes8.dex */
public class ab {
    public static void aEU() {
        String aEV = aEV();
        if (!TextUtils.isEmpty(aEV)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + aEV);
            }
            WebSettingsGlobalBlink.setRefererPattern(aEV, com.baidu.swan.apps.r.d.aoA());
        }
    }

    public static String aEV() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "getFixedReferer: " + sE("https://smartapps.cn/%s/%s/page-frame.html"));
        }
        return sE("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static boolean sD(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String sE(String str) {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        return azI != null ? String.format(str, azI.getAppKey(), azI.aAe()) : "";
    }
}
