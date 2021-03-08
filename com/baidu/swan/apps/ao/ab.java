package com.baidu.swan.apps.ao;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes8.dex */
public class ab {
    public static void aOa() {
        String aOb = aOb();
        if (!TextUtils.isEmpty(aOb)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + aOb);
            }
            WebSettingsGlobalBlink.setRefererPattern(aOb, com.baidu.swan.apps.r.d.awQ());
        }
    }

    public static String aOb() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "getFixedReferer: " + ug("https://smartapps.cn/%s/%s/page-frame.html"));
        }
        return ug("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static boolean uf(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String ug(String str) {
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        return aIN != null ? String.format(str, aIN.getAppKey(), aIN.aJj()) : "";
    }
}
