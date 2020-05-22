package com.baidu.swan.apps.aq;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes11.dex */
public class z {
    private static int cKf = -1;

    public static void atC() {
        String atD = atD();
        if (!TextUtils.isEmpty(atD)) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + atD);
            }
            WebSettingsGlobalBlink.setRefererPattern(atD, com.baidu.swan.apps.core.turbo.d.abl().aby());
        }
    }

    public static String atD() {
        int atE = atE();
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanAppRefererUtils", "referer switch is " + atE);
        }
        if (atE == 1) {
            return pJ("https://smartapp.baidu.com/%s/%s/page-frame.html");
        }
        if (atE != 2) {
            return null;
        }
        return pJ("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static int atE() {
        if (cKf < 0) {
            cKf = com.baidu.swan.apps.u.a.aeU().RC();
        }
        return cKf;
    }

    public static boolean pI(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static String pJ(String str) {
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        return aoF != null ? String.format(str, aoF.getAppKey(), aoF.apb()) : "";
    }
}
