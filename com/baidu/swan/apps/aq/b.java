package com.baidu.swan.apps.aq;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.c;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bTG;

    public static String adH() {
        return mj("swan");
    }

    public static String OK() {
        return mj("swangame");
    }

    private static String mj(String str) {
        String hostName = com.baidu.swan.apps.w.a.RV().getHostName();
        a aVar = new a();
        aVar.mk(str).ml(c.getVersion()).mm(hostName).mn(getVersionName()).mo(getOSVersion());
        return aVar.adI();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.w.a.Rk();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(bTG)) {
            return bTG;
        }
        try {
            bTG = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return bTG;
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
        private static String bTL = "%s/%s";
        private static String bTM = "%s-%s/%s";
        private static String bTN = "(Baidu; P1 %s)";
        private static String bTO = "%s/%s";
        private String OR;
        private String bTH;
        private String bTI;
        private String bTJ;
        private String bTK;

        public a mk(String str) {
            this.bTH = str;
            return this;
        }

        public a ml(String str) {
            this.bTI = str;
            return this;
        }

        public a mm(String str) {
            this.bTJ = str;
            return this;
        }

        public a mn(String str) {
            this.bTK = str;
            return this;
        }

        public a mo(String str) {
            this.OR = str;
            return this;
        }

        public String adI() {
            String format = String.format(bTL, this.bTH, this.bTI);
            String format2 = String.format(bTM, this.bTH, this.bTJ, this.bTK);
            String format3 = String.format(bTO, this.bTJ, this.bTK);
            String format4 = String.format(bTN, this.OR);
            if (adJ()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean adJ() {
            return TextUtils.equals("baiduboxapp", this.bTJ);
        }
    }
}
