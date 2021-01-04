package com.baidu.swan.apps.ao;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes9.dex */
public class ab {
    public static void aRx() {
        String aRy = aRy();
        if (!TextUtils.isEmpty(aRy)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + aRy);
            }
            WebSettingsGlobalBlink.setRefererPattern(aRy, com.baidu.swan.apps.r.d.aAi());
        }
    }

    public static String aRy() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "getFixedReferer: " + uR("https://smartapps.cn/%s/%s/page-frame.html"));
        }
        return uR("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static boolean uQ(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String uR(String str) {
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        return aMk != null ? String.format(str, aMk.getAppKey(), aMk.aMG()) : "";
    }
}
