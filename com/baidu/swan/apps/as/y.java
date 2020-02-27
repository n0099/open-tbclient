package com.baidu.swan.apps.as;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes11.dex */
public class y {
    private static int bYA = -1;

    public static void agQ() {
        String agR = agR();
        if (!TextUtils.isEmpty(agR)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + agR);
            }
            WebSettingsGlobalBlink.setRefererPattern(agR, com.baidu.swan.apps.core.k.d.Qu().QG());
        }
    }

    public static String agR() {
        int agS = agS();
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "referer switch is " + agS);
        }
        if (agS == 1) {
            return mO("https://smartapp.baidu.com/%s/%s/page-frame.html");
        }
        if (agS != 2) {
            return null;
        }
        return mO("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static int agS() {
        if (bYA < 0) {
            bYA = com.baidu.swan.apps.w.a.TX().Hx();
        }
        return bYA;
    }

    public static boolean mN(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String mO(String str) {
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        return acD != null ? String.format(str, acD.getAppKey(), acD.acX()) : "";
    }
}
