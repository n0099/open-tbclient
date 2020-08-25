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
    private static String das;

    public static String aEi() {
        return so("swan");
    }

    public static String alj() {
        return so("swangame");
    }

    private static String so(String str) {
        String hostName = com.baidu.swan.apps.t.a.apw().getHostName();
        a aVar = new a();
        aVar.sp(str).sq(c.getVersion()).ss(hostName).st(getVersionName()).su(getOSVersion());
        return aVar.aEj();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.t.a.aoJ();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(das)) {
            return das;
        }
        try {
            das = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return das;
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
        private String amh;
        private String dau;
        private String dav;
        private String daw;
        private String dax;
        private static String daz = "%s/%s";
        private static String daA = "%s-%s/%s";
        private static String daB = "(Baidu; P1 %s)";
        private static String daC = "%s/%s";

        public a sp(String str) {
            this.dau = str;
            return this;
        }

        public a sq(String str) {
            this.dav = str;
            return this;
        }

        public a ss(String str) {
            this.daw = str;
            return this;
        }

        public a st(String str) {
            this.dax = str;
            return this;
        }

        public a su(String str) {
            this.amh = str;
            return this;
        }

        public String aEj() {
            String format = String.format(daz, this.dau, this.dav);
            String format2 = String.format(daA, this.dau, this.daw, this.dax);
            String format3 = String.format(daC, this.daw, this.dax);
            String format4 = String.format(daB, this.amh);
            if (aEk()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aEk() {
            return TextUtils.equals("baiduboxapp", this.daw);
        }
    }
}
