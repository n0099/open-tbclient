package com.baidu.swan.apps.as;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes11.dex */
public class y {
    private static int bYN = -1;

    public static void agV() {
        String agW = agW();
        if (!TextUtils.isEmpty(agW)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + agW);
            }
            WebSettingsGlobalBlink.setRefererPattern(agW, com.baidu.swan.apps.core.k.d.Qz().QL());
        }
    }

    public static String agW() {
        int agX = agX();
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "referer switch is " + agX);
        }
        if (agX == 1) {
            return mN("https://smartapp.baidu.com/%s/%s/page-frame.html");
        }
        if (agX != 2) {
            return null;
        }
        return mN("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static int agX() {
        if (bYN < 0) {
            bYN = com.baidu.swan.apps.w.a.Uc().HE();
        }
        return bYN;
    }

    public static boolean mM(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String mN(String str) {
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        return acI != null ? String.format(str, acI.getAppKey(), acI.adc()) : "";
    }
}
