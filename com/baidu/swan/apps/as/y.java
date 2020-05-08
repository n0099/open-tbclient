package com.baidu.swan.apps.as;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes11.dex */
public class y {
    private static int cxP = -1;

    public static void apb() {
        String apc = apc();
        if (!TextUtils.isEmpty(apc)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + apc);
            }
            WebSettingsGlobalBlink.setRefererPattern(apc, com.baidu.swan.apps.core.k.d.Yn().Yz());
        }
    }

    public static String apc() {
        int apd = apd();
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "referer switch is " + apd);
        }
        if (apd == 1) {
            return oa("https://smartapp.baidu.com/%s/%s/page-frame.html");
        }
        if (apd != 2) {
            return null;
        }
        return oa("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static int apd() {
        if (cxP < 0) {
            cxP = com.baidu.swan.apps.w.a.abQ().Pq();
        }
        return cxP;
    }

    public static boolean nZ(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String oa(String str) {
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        return akM != null ? String.format(str, akM.getAppKey(), akM.alg()) : "";
    }
}
