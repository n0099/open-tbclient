package com.baidu.swan.apps.as;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes11.dex */
public class y {
    private static int bYB = -1;

    public static void agS() {
        String agT = agT();
        if (!TextUtils.isEmpty(agT)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + agT);
            }
            WebSettingsGlobalBlink.setRefererPattern(agT, com.baidu.swan.apps.core.k.d.Qw().QI());
        }
    }

    public static String agT() {
        int agU = agU();
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "referer switch is " + agU);
        }
        if (agU == 1) {
            return mO("https://smartapp.baidu.com/%s/%s/page-frame.html");
        }
        if (agU != 2) {
            return null;
        }
        return mO("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static int agU() {
        if (bYB < 0) {
            bYB = com.baidu.swan.apps.w.a.TZ().Hz();
        }
        return bYB;
    }

    public static boolean mN(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String mO(String str) {
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        return acF != null ? String.format(str, acF.getAppKey(), acF.acZ()) : "";
    }
}
