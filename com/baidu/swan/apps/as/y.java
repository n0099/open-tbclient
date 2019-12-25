package com.baidu.swan.apps.as;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes9.dex */
public class y {
    private static int bUk = -1;

    public static void aej() {
        String aek = aek();
        if (!TextUtils.isEmpty(aek)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + aek);
            }
            WebSettingsGlobalBlink.setRefererPattern(aek, com.baidu.swan.apps.core.k.d.NK().NW());
        }
    }

    public static String aek() {
        int ael = ael();
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "referer switch is " + ael);
        }
        if (ael == 1) {
            return mw("https://smartapp.baidu.com/%s/%s/page-frame.html");
        }
        if (ael != 2) {
            return null;
        }
        return mw("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static int ael() {
        if (bUk < 0) {
            bUk = com.baidu.swan.apps.w.a.Rn().EM();
        }
        return bUk;
    }

    public static boolean mv(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String mw(String str) {
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        return ZS != null ? String.format(str, ZS.getAppKey(), ZS.aam()) : "";
    }
}
