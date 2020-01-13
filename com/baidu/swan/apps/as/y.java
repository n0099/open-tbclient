package com.baidu.swan.apps.as;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes10.dex */
public class y {
    private static int bUw = -1;

    public static void aeC() {
        String aeD = aeD();
        if (!TextUtils.isEmpty(aeD)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + aeD);
            }
            WebSettingsGlobalBlink.setRefererPattern(aeD, com.baidu.swan.apps.core.k.d.Og().Os());
        }
    }

    public static String aeD() {
        int aeE = aeE();
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "referer switch is " + aeE);
        }
        if (aeE == 1) {
            return mz("https://smartapp.baidu.com/%s/%s/page-frame.html");
        }
        if (aeE != 2) {
            return null;
        }
        return mz("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static int aeE() {
        if (bUw < 0) {
            bUw = com.baidu.swan.apps.w.a.RJ().Fi();
        }
        return bUw;
    }

    public static boolean my(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String mz(String str) {
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        return aap != null ? String.format(str, aap.getAppKey(), aap.aaJ()) : "";
    }
}
