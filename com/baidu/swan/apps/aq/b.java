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
    private static String bXX;

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
        if (!TextUtils.isEmpty(bXX)) {
            return bXX;
        }
        try {
            bXX = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return bXX;
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
        private static String bYc = "%s/%s";
        private static String bYd = "%s-%s/%s";
        private static String bYe = "(Baidu; P1 %s)";
        private static String bYf = "%s/%s";
        private String QF;
        private String bXY;
        private String bXZ;
        private String bYa;
        private String bYb;

        public a mC(String str) {
            this.bXY = str;
            return this;
        }

        public a mD(String str) {
            this.bXZ = str;
            return this;
        }

        public a mE(String str) {
            this.bYa = str;
            return this;
        }

        public a mF(String str) {
            this.bYb = str;
            return this;
        }

        public a mG(String str) {
            this.QF = str;
            return this;
        }

        public String agr() {
            String format = String.format(bYc, this.bXY, this.bXZ);
            String format2 = String.format(bYd, this.bXY, this.bYa, this.bYb);
            String format3 = String.format(bYf, this.bYa, this.bYb);
            String format4 = String.format(bYe, this.QF);
            if (ags()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean ags() {
            return TextUtils.equals("baiduboxapp", this.bYa);
        }
    }
}
