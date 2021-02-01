package com.baidu.swan.apps.ao;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes9.dex */
public class ab {
    public static void aNX() {
        String aNY = aNY();
        if (!TextUtils.isEmpty(aNY)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + aNY);
            }
            WebSettingsGlobalBlink.setRefererPattern(aNY, com.baidu.swan.apps.r.d.awN());
        }
    }

    public static String aNY() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "getFixedReferer: " + tZ("https://smartapps.cn/%s/%s/page-frame.html"));
        }
        return tZ("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static boolean tY(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String tZ(String str) {
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        return aIK != null ? String.format(str, aIK.getAppKey(), aIK.aJg()) : "";
    }
}
