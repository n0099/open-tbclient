package com.baidu.swan.apps.an;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.c;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dcz;

    public static String aES() {
        return sJ("swan");
    }

    public static String alT() {
        return sJ("swangame");
    }

    private static String sJ(String str) {
        String hostName = com.baidu.swan.apps.t.a.aqg().getHostName();
        a aVar = new a();
        aVar.sK(str).sL(c.getVersion()).sM(hostName).sN(getVersionName()).sO(getOSVersion());
        return aVar.aET();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.t.a.apu();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(dcz)) {
            return dcz;
        }
        try {
            dcz = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return dcz;
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

    /* loaded from: classes3.dex */
    public static class a {
        private static String dcE = "%s/%s";
        private static String dcF = "%s-%s/%s";
        private static String dcG = "(Baidu; P1 %s)";
        private static String dcH = "%s/%s";
        private String amL;
        private String dcA;
        private String dcB;
        private String dcC;
        private String dcD;

        public a sK(String str) {
            this.dcA = str;
            return this;
        }

        public a sL(String str) {
            this.dcB = str;
            return this;
        }

        public a sM(String str) {
            this.dcC = str;
            return this;
        }

        public a sN(String str) {
            this.dcD = str;
            return this;
        }

        public a sO(String str) {
            this.amL = str;
            return this;
        }

        public String aET() {
            String format = String.format(dcE, this.dcA, this.dcB);
            String format2 = String.format(dcF, this.dcA, this.dcC, this.dcD);
            String format3 = String.format(dcH, this.dcC, this.dcD);
            String format4 = String.format(dcG, this.amL);
            if (aEU()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aEU() {
            return TextUtils.equals("baiduboxapp", this.dcC);
        }
    }
}
