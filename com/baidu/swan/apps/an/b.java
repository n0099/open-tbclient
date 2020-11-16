package com.baidu.swan.apps.an;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.c;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dBt;

    public static String aLn() {
        return tX("swan");
    }

    public static String ass() {
        return tX("swangame");
    }

    private static String tX(String str) {
        String hostName = com.baidu.swan.apps.t.a.awE().getHostName();
        a aVar = new a();
        aVar.tY(str).tZ(c.getVersion()).ua(hostName).ub(getVersionName()).uc(getOSVersion());
        return aVar.aLo();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.t.a.avS();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(dBt)) {
            return dBt;
        }
        try {
            dBt = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return dBt;
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

    /* loaded from: classes7.dex */
    public static class a {
        private String anB;
        private String dBu;
        private String dBv;
        private String dBw;
        private String dBx;
        private static String dBy = "%s/%s";
        private static String dBz = "%s-%s/%s";
        private static String dBA = "(Baidu; P1 %s)";
        private static String dBB = "%s/%s";

        public a tY(String str) {
            this.dBu = str;
            return this;
        }

        public a tZ(String str) {
            this.dBv = str;
            return this;
        }

        public a ua(String str) {
            this.dBw = str;
            return this;
        }

        public a ub(String str) {
            this.dBx = str;
            return this;
        }

        public a uc(String str) {
            this.anB = str;
            return this;
        }

        public String aLo() {
            String format = String.format(dBy, this.dBu, this.dBv);
            String format2 = String.format(dBz, this.dBu, this.dBw, this.dBx);
            String format3 = String.format(dBB, this.dBw, this.dBx);
            String format4 = String.format(dBA, this.anB);
            if (aLp()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aLp() {
            return TextUtils.equals("baiduboxapp", this.dBw);
        }
    }
}
