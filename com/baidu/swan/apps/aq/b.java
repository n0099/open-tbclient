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
    private static String cxb;

    public static String aoy() {
        return nN("swan");
    }

    public static String Zo() {
        return nN("swangame");
    }

    private static String nN(String str) {
        String hostName = com.baidu.swan.apps.w.a.acz().getHostName();
        a aVar = new a();
        aVar.nO(str).nP(c.getVersion()).nQ(hostName).nR(getVersionName()).nS(getOSVersion());
        return aVar.aoz();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.w.a.abO();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(cxb)) {
            return cxb;
        }
        try {
            cxb = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return cxb;
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
        private static String cxg = "%s/%s";
        private static String cxh = "%s-%s/%s";
        private static String cxi = "(Baidu; P1 %s)";
        private static String cxj = "%s/%s";
        private String ajg;
        private String cxc;
        private String cxd;
        private String cxe;
        private String cxf;

        public a nO(String str) {
            this.cxc = str;
            return this;
        }

        public a nP(String str) {
            this.cxd = str;
            return this;
        }

        public a nQ(String str) {
            this.cxe = str;
            return this;
        }

        public a nR(String str) {
            this.cxf = str;
            return this;
        }

        public a nS(String str) {
            this.ajg = str;
            return this;
        }

        public String aoz() {
            String format = String.format(cxg, this.cxc, this.cxd);
            String format2 = String.format(cxh, this.cxc, this.cxe, this.cxf);
            String format3 = String.format(cxj, this.cxe, this.cxf);
            String format4 = String.format(cxi, this.ajg);
            if (aoA()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aoA() {
            return TextUtils.equals("baiduboxapp", this.cxe);
        }
    }
}
