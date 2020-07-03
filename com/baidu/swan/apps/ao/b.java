package com.baidu.swan.apps.ao;

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
    private static String cNW;

    public static String atY() {
        return pD("swan");
    }

    public static String adu() {
        return pD("swangame");
    }

    private static String pD(String str) {
        String hostName = com.baidu.swan.apps.u.a.agH().getHostName();
        a aVar = new a();
        aVar.pE(str).pF(c.getVersion()).pG(hostName).pH(getVersionName()).pI(getOSVersion());
        return aVar.atZ();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.u.a.afX();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(cNW)) {
            return cNW;
        }
        try {
            cNW = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return cNW;
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
        private static String cOb = "%s/%s";
        private static String cOc = "%s-%s/%s";
        private static String cOd = "(Baidu; P1 %s)";
        private static String cOe = "%s/%s";
        private String alm;
        private String cNX;
        private String cNY;
        private String cNZ;
        private String cOa;

        public a pE(String str) {
            this.cNX = str;
            return this;
        }

        public a pF(String str) {
            this.cNY = str;
            return this;
        }

        public a pG(String str) {
            this.cNZ = str;
            return this;
        }

        public a pH(String str) {
            this.cOa = str;
            return this;
        }

        public a pI(String str) {
            this.alm = str;
            return this;
        }

        public String atZ() {
            String format = String.format(cOb, this.cNX, this.cNY);
            String format2 = String.format(cOc, this.cNX, this.cNZ, this.cOa);
            String format3 = String.format(cOe, this.cNZ, this.cOa);
            String format4 = String.format(cOd, this.alm);
            if (aua()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aua() {
            return TextUtils.equals("baiduboxapp", this.cNZ);
        }
    }
}
