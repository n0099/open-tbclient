package com.baidu.swan.apps.am;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.c;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dPP;

    public static String aNo() {
        return tQ(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public static String atA() {
        return tQ("swangame");
    }

    private static String tQ(String str) {
        String hostName = com.baidu.swan.apps.t.a.axL().getHostName();
        a aVar = new a();
        aVar.tR(str).tS(c.getVersion()).tT(hostName).tU(getVersionName()).tV(getOSVersion());
        return aVar.aNp();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.t.a.awZ();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(dPP)) {
            return dPP;
        }
        try {
            dPP = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return dPP;
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

    /* loaded from: classes8.dex */
    public static class a {
        private static String dPU = "%s/%s";
        private static String dPV = "%s-%s/%s";
        private static String dPW = "(Baidu; P1 %s)";
        private static String dPX = "%s/%s";
        private String dPQ;
        private String dPR;
        private String dPS;
        private String dPT;
        private String mOSVersion;

        public a tR(String str) {
            this.dPQ = str;
            return this;
        }

        public a tS(String str) {
            this.dPR = str;
            return this;
        }

        public a tT(String str) {
            this.dPS = str;
            return this;
        }

        public a tU(String str) {
            this.dPT = str;
            return this;
        }

        public a tV(String str) {
            this.mOSVersion = str;
            return this;
        }

        public String aNp() {
            String format = String.format(dPU, this.dPQ, this.dPR);
            String format2 = String.format(dPV, this.dPQ, this.dPS, this.dPT);
            String format3 = String.format(dPX, this.dPS, this.dPT);
            String format4 = String.format(dPW, this.mOSVersion);
            if (aNq()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aNq() {
            return TextUtils.equals("baiduboxapp", this.dPS);
        }
    }
}
