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
    private static String dMk;

    public static String aMS() {
        return tq(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public static String asZ() {
        return tq("swangame");
    }

    private static String tq(String str) {
        String hostName = com.baidu.swan.apps.t.a.axk().getHostName();
        a aVar = new a();
        aVar.tr(str).ts(c.getVersion()).tt(hostName).tu(getVersionName()).tv(getOSVersion());
        return aVar.aMT();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.t.a.awy();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(dMk)) {
            return dMk;
        }
        try {
            dMk = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return dMk;
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
        private static String dMp = "%s/%s";
        private static String dMq = "%s-%s/%s";
        private static String dMr = "(Baidu; P1 %s)";
        private static String dMs = "%s/%s";
        private String dMl;
        private String dMm;
        private String dMn;
        private String dMo;
        private String mOSVersion;

        public a tr(String str) {
            this.dMl = str;
            return this;
        }

        public a ts(String str) {
            this.dMm = str;
            return this;
        }

        public a tt(String str) {
            this.dMn = str;
            return this;
        }

        public a tu(String str) {
            this.dMo = str;
            return this;
        }

        public a tv(String str) {
            this.mOSVersion = str;
            return this;
        }

        public String aMT() {
            String format = String.format(dMp, this.dMl, this.dMm);
            String format2 = String.format(dMq, this.dMl, this.dMn, this.dMo);
            String format3 = String.format(dMs, this.dMn, this.dMo);
            String format4 = String.format(dMr, this.mOSVersion);
            if (aMU()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aMU() {
            return TextUtils.equals("baiduboxapp", this.dMn);
        }
    }
}
