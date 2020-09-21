package com.baidu.swan.apps.ap;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes3.dex */
public class ab {
    public static void aFE() {
        String aFF = aFF();
        if (!TextUtils.isEmpty(aFF)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + aFF);
            }
            WebSettingsGlobalBlink.setRefererPattern(aFF, com.baidu.swan.apps.r.d.apl());
        }
    }

    public static String aFF() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "getFixedReferer: " + sX("https://smartapps.cn/%s/%s/page-frame.html"));
        }
        return sX("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static boolean sW(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String sX(String str) {
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        return aAr != null ? String.format(str, aAr.getAppKey(), aAr.aAN()) : "";
    }
}
