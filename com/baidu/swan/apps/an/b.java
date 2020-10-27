package com.baidu.swan.apps.an;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.c;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dxi;

    public static String aJv() {
        return tO("swan");
    }

    public static String aqz() {
        return tO("swangame");
    }

    private static String tO(String str) {
        String hostName = com.baidu.swan.apps.t.a.auM().getHostName();
        a aVar = new a();
        aVar.tP(str).tQ(c.getVersion()).tR(hostName).tS(getVersionName()).tT(getOSVersion());
        return aVar.aJw();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.t.a.aua();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(dxi)) {
            return dxi;
        }
        try {
            dxi = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return dxi;
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

    /* loaded from: classes10.dex */
    public static class a {
        private static String dxn = "%s/%s";
        private static String dxo = "%s-%s/%s";
        private static String dxp = "(Baidu; P1 %s)";
        private static String dxq = "%s/%s";
        private String anv;
        private String dxj;
        private String dxk;
        private String dxl;
        private String dxm;

        public a tP(String str) {
            this.dxj = str;
            return this;
        }

        public a tQ(String str) {
            this.dxk = str;
            return this;
        }

        public a tR(String str) {
            this.dxl = str;
            return this;
        }

        public a tS(String str) {
            this.dxm = str;
            return this;
        }

        public a tT(String str) {
            this.anv = str;
            return this;
        }

        public String aJw() {
            String format = String.format(dxn, this.dxj, this.dxk);
            String format2 = String.format(dxo, this.dxj, this.dxl, this.dxm);
            String format3 = String.format(dxq, this.dxl, this.dxm);
            String format4 = String.format(dxp, this.anv);
            if (aJx()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aJx() {
            return TextUtils.equals("baiduboxapp", this.dxl);
        }
    }
}
