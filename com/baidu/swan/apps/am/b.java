package com.baidu.swan.apps.am;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.c;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dQW;

    public static String aQL() {
        return uB(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public static String awS() {
        return uB("swangame");
    }

    private static String uB(String str) {
        String hostName = com.baidu.swan.apps.t.a.aBd().getHostName();
        a aVar = new a();
        aVar.uC(str).uD(c.getVersion()).uE(hostName).uF(getVersionName()).uG(getOSVersion());
        return aVar.aQM();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.t.a.aAr();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(dQW)) {
            return dQW;
        }
        try {
            dQW = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return dQW;
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return "0.8";
        }
    }

    public static String getOSVersion() {
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            return "0.0";
        }
        return str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    /* loaded from: classes9.dex */
    public static class a {
        private static String dRb = "%s/%s";
        private static String dRc = "%s-%s/%s";
        private static String dRd = "(Baidu; P1 %s)";
        private static String dRe = "%s/%s";
        private String dQX;
        private String dQY;
        private String dQZ;
        private String dRa;
        private String mOSVersion;

        public a uC(String str) {
            this.dQX = str;
            return this;
        }

        public a uD(String str) {
            this.dQY = str;
            return this;
        }

        public a uE(String str) {
            this.dQZ = str;
            return this;
        }

        public a uF(String str) {
            this.dRa = str;
            return this;
        }

        public a uG(String str) {
            this.mOSVersion = str;
            return this;
        }

        public String aQM() {
            String format = String.format(dRb, this.dQX, this.dQY);
            String format2 = String.format(dRc, this.dQX, this.dQZ, this.dRa);
            String format3 = String.format(dRe, this.dQZ, this.dRa);
            String format4 = String.format(dRd, this.mOSVersion);
            if (aQN()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aQN() {
            return TextUtils.equals("baiduboxapp", this.dQZ);
        }
    }
}
