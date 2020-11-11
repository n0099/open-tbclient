package com.baidu.swan.apps.ap;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes10.dex */
public class ab {
    public static void aMH() {
        String aMI = aMI();
        if (!TextUtils.isEmpty(aMI)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + aMI);
            }
            WebSettingsGlobalBlink.setRefererPattern(aMI, com.baidu.swan.apps.r.d.awr());
        }
    }

    public static String aMI() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "getFixedReferer: " + uq("https://smartapps.cn/%s/%s/page-frame.html"));
        }
        return uq("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static boolean up(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String uq(String str) {
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        return aHu != null ? String.format(str, aHu.getAppKey(), aHu.aHQ()) : "";
    }
}
