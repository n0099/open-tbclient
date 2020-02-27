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
    private static String bXW;

    public static String ago() {
        return mB("swan");
    }

    public static String Ru() {
        return mB("swangame");
    }

    private static String mB(String str) {
        String hostName = com.baidu.swan.apps.w.a.UF().getHostName();
        a aVar = new a();
        aVar.mC(str).mD(c.getVersion()).mE(hostName).mF(getVersionName()).mG(getOSVersion());
        return aVar.agp();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.w.a.TU();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(bXW)) {
            return bXW;
        }
        try {
            bXW = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return bXW;
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
        private static String bYb = "%s/%s";
        private static String bYc = "%s-%s/%s";
        private static String bYd = "(Baidu; P1 %s)";
        private static String bYe = "%s/%s";
        private String QF;
        private String bXX;
        private String bXY;
        private String bXZ;
        private String bYa;

        public a mC(String str) {
            this.bXX = str;
            return this;
        }

        public a mD(String str) {
            this.bXY = str;
            return this;
        }

        public a mE(String str) {
            this.bXZ = str;
            return this;
        }

        public a mF(String str) {
            this.bYa = str;
            return this;
        }

        public a mG(String str) {
            this.QF = str;
            return this;
        }

        public String agp() {
            String format = String.format(bYb, this.bXX, this.bXY);
            String format2 = String.format(bYc, this.bXX, this.bXZ, this.bYa);
            String format3 = String.format(bYe, this.bXZ, this.bYa);
            String format4 = String.format(bYd, this.QF);
            if (agq()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean agq() {
            return TextUtils.equals("baiduboxapp", this.bXZ);
        }
    }
}
