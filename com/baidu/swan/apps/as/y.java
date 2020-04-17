package com.baidu.swan.apps.as;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes11.dex */
public class y {
    private static int cxJ = -1;

    public static void apc() {
        String apd = apd();
        if (!TextUtils.isEmpty(apd)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + apd);
            }
            WebSettingsGlobalBlink.setRefererPattern(apd, com.baidu.swan.apps.core.k.d.Yo().YA());
        }
    }

    public static String apd() {
        int ape = ape();
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "referer switch is " + ape);
        }
        if (ape == 1) {
            return oa("https://smartapp.baidu.com/%s/%s/page-frame.html");
        }
        if (ape != 2) {
            return null;
        }
        return oa("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static int ape() {
        if (cxJ < 0) {
            cxJ = com.baidu.swan.apps.w.a.abR().Pr();
        }
        return cxJ;
    }

    public static boolean nZ(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String oa(String str) {
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        return akN != null ? String.format(str, akN.getAppKey(), akN.alh()) : "";
    }
}
