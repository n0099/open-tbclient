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
    private static String dOo;

    public static String aNl() {
        return tJ(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public static String atx() {
        return tJ("swangame");
    }

    private static String tJ(String str) {
        String hostName = com.baidu.swan.apps.t.a.axI().getHostName();
        a aVar = new a();
        aVar.tK(str).tL(c.getVersion()).tM(hostName).tN(getVersionName()).tO(getOSVersion());
        return aVar.aNm();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.t.a.awW();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(dOo)) {
            return dOo;
        }
        try {
            dOo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return dOo;
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
        private static String dOt = "%s/%s";
        private static String dOu = "%s-%s/%s";
        private static String dOv = "(Baidu; P1 %s)";
        private static String dOw = "%s/%s";
        private String dOp;
        private String dOq;
        private String dOr;
        private String dOs;
        private String mOSVersion;

        public a tK(String str) {
            this.dOp = str;
            return this;
        }

        public a tL(String str) {
            this.dOq = str;
            return this;
        }

        public a tM(String str) {
            this.dOr = str;
            return this;
        }

        public a tN(String str) {
            this.dOs = str;
            return this;
        }

        public a tO(String str) {
            this.mOSVersion = str;
            return this;
        }

        public String aNm() {
            String format = String.format(dOt, this.dOp, this.dOq);
            String format2 = String.format(dOu, this.dOp, this.dOr, this.dOs);
            String format3 = String.format(dOw, this.dOr, this.dOs);
            String format4 = String.format(dOv, this.mOSVersion);
            if (aNn()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aNn() {
            return TextUtils.equals("baiduboxapp", this.dOr);
        }
    }
}
