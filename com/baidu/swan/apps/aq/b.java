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
    private static String cxh;

    public static String aox() {
        return nN("swan");
    }

    public static String Zn() {
        return nN("swangame");
    }

    private static String nN(String str) {
        String hostName = com.baidu.swan.apps.w.a.acy().getHostName();
        a aVar = new a();
        aVar.nO(str).nP(c.getVersion()).nQ(hostName).nR(getVersionName()).nS(getOSVersion());
        return aVar.aoy();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.w.a.abN();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(cxh)) {
            return cxh;
        }
        try {
            cxh = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return cxh;
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
        private static String cxm = "%s/%s";
        private static String cxn = "%s-%s/%s";
        private static String cxo = "(Baidu; P1 %s)";
        private static String cxp = "%s/%s";
        private String ajl;
        private String cxi;
        private String cxj;
        private String cxk;
        private String cxl;

        public a nO(String str) {
            this.cxi = str;
            return this;
        }

        public a nP(String str) {
            this.cxj = str;
            return this;
        }

        public a nQ(String str) {
            this.cxk = str;
            return this;
        }

        public a nR(String str) {
            this.cxl = str;
            return this;
        }

        public a nS(String str) {
            this.ajl = str;
            return this;
        }

        public String aoy() {
            String format = String.format(cxm, this.cxi, this.cxj);
            String format2 = String.format(cxn, this.cxi, this.cxk, this.cxl);
            String format3 = String.format(cxp, this.cxk, this.cxl);
            String format4 = String.format(cxo, this.ajl);
            if (aoz()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aoz() {
            return TextUtils.equals("baiduboxapp", this.cxk);
        }
    }
}
