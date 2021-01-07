package com.baidu.swan.apps.ao;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes9.dex */
public class ab {
    public static void aRy() {
        String aRz = aRz();
        if (!TextUtils.isEmpty(aRz)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + aRz);
            }
            WebSettingsGlobalBlink.setRefererPattern(aRz, com.baidu.swan.apps.r.d.aAj());
        }
    }

    public static String aRz() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "getFixedReferer: " + uR("https://smartapps.cn/%s/%s/page-frame.html"));
        }
        return uR("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static boolean uQ(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String uR(String str) {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        return aMl != null ? String.format(str, aMl.getAppKey(), aMl.aMH()) : "";
    }
}
