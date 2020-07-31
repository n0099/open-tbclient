package com.baidu.swan.apps.aq;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes7.dex */
public class aa {
    private static int cSm = -1;

    public static void awK() {
        String awL = awL();
        if (!TextUtils.isEmpty(awL)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + awL);
            }
            WebSettingsGlobalBlink.setRefererPattern(awL, com.baidu.swan.apps.r.d.aha());
        }
    }

    public static String awL() {
        int awM = awM();
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "referer switch is " + awM);
        }
        if (awM == 1) {
            return qC("https://smartapp.baidu.com/%s/%s/page-frame.html");
        }
        if (awM != 2) {
            return null;
        }
        return qC("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static int awM() {
        if (cSm < 0) {
            cSm = com.baidu.swan.apps.t.a.ahm().SY();
        }
        return cSm;
    }

    public static boolean qB(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String qC(String str) {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        return arv != null ? String.format(str, arv.getAppKey(), arv.arR()) : "";
    }
}
