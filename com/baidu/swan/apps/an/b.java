package com.baidu.swan.apps.an;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.c;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dax;

    public static String aEi() {
        return sp("swan");
    }

    public static String alj() {
        return sp("swangame");
    }

    private static String sp(String str) {
        String hostName = com.baidu.swan.apps.t.a.apw().getHostName();
        a aVar = new a();
        aVar.sq(str).ss(c.getVersion()).st(hostName).su(getVersionName()).sv(getOSVersion());
        return aVar.aEj();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.t.a.aoJ();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(dax)) {
            return dax;
        }
        try {
            dax = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return dax;
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
        private static String daD = "%s/%s";
        private static String daE = "%s-%s/%s";
        private static String daF = "(Baidu; P1 %s)";
        private static String daG = "%s/%s";
        private String amj;
        private String daA;
        private String daB;
        private String daC;
        private String daz;

        public a sq(String str) {
            this.daz = str;
            return this;
        }

        public a ss(String str) {
            this.daA = str;
            return this;
        }

        public a st(String str) {
            this.daB = str;
            return this;
        }

        public a su(String str) {
            this.daC = str;
            return this;
        }

        public a sv(String str) {
            this.amj = str;
            return this;
        }

        public String aEj() {
            String format = String.format(daD, this.daz, this.daA);
            String format2 = String.format(daE, this.daz, this.daB, this.daC);
            String format3 = String.format(daG, this.daB, this.daC);
            String format4 = String.format(daF, this.amj);
            if (aEk()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aEk() {
            return TextUtils.equals("baiduboxapp", this.daB);
        }
    }
}
