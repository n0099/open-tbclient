package com.baidu.swan.apps.aq;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes11.dex */
public class z {
    private static int cOP = -1;

    public static void auI() {
        String auJ = auJ();
        if (!TextUtils.isEmpty(auJ)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + auJ);
            }
            WebSettingsGlobalBlink.setRefererPattern(auJ, com.baidu.swan.apps.core.turbo.d.acr().acE());
        }
    }

    public static String auJ() {
        int auK = auK();
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "referer switch is " + auK);
        }
        if (auK == 1) {
            return pR("https://smartapp.baidu.com/%s/%s/page-frame.html");
        }
        if (auK != 2) {
            return null;
        }
        return pR("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static int auK() {
        if (cOP < 0) {
            cOP = com.baidu.swan.apps.u.a.aga().SI();
        }
        return cOP;
    }

    public static boolean pQ(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String pR(String str) {
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        return apM != null ? String.format(str, apM.getAppKey(), apM.aqi()) : "";
    }
}
