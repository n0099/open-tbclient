package com.baidu.swan.apps.aq;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.c;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bXY;

    public static String agq() {
        return mB("swan");
    }

    public static String Rw() {
        return mB("swangame");
    }

    private static String mB(String str) {
        String hostName = com.baidu.swan.apps.w.a.UH().getHostName();
        a aVar = new a();
        aVar.mC(str).mD(c.getVersion()).mE(hostName).mF(getVersionName()).mG(getOSVersion());
        return aVar.agr();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.w.a.TW();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(bXY)) {
            return bXY;
        }
        try {
            bXY = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return bXY;
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

    /* loaded from: classes11.dex */
    public static class a {
        private static String bYd = "%s/%s";
        private static String bYe = "%s-%s/%s";
        private static String bYf = "(Baidu; P1 %s)";
        private static String bYg = "%s/%s";
        private String QF;
        private String bXZ;
        private String bYa;
        private String bYb;
        private String bYc;

        public a mC(String str) {
            this.bXZ = str;
            return this;
        }

        public a mD(String str) {
            this.bYa = str;
            return this;
        }

        public a mE(String str) {
            this.bYb = str;
            return this;
        }

        public a mF(String str) {
            this.bYc = str;
            return this;
        }

        public a mG(String str) {
            this.QF = str;
            return this;
        }

        public String agr() {
            String format = String.format(bYd, this.bXZ, this.bYa);
            String format2 = String.format(bYe, this.bXZ, this.bYb, this.bYc);
            String format3 = String.format(bYg, this.bYb, this.bYc);
            String format4 = String.format(bYf, this.QF);
            if (ags()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean ags() {
            return TextUtils.equals("baiduboxapp", this.bYb);
        }
    }
}
