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
    private static String bYj;

    public static String agt() {
        return mA("swan");
    }

    public static String Rz() {
        return mA("swangame");
    }

    private static String mA(String str) {
        String hostName = com.baidu.swan.apps.w.a.UK().getHostName();
        a aVar = new a();
        aVar.mB(str).mC(c.getVersion()).mD(hostName).mE(getVersionName()).mF(getOSVersion());
        return aVar.agu();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.w.a.TZ();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(bYj)) {
            return bYj;
        }
        try {
            bYj = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return bYj;
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
        private static String bYo = "%s/%s";
        private static String bYp = "%s-%s/%s";
        private static String bYq = "(Baidu; P1 %s)";
        private static String bYr = "%s/%s";
        private String QH;
        private String bYk;
        private String bYl;
        private String bYm;
        private String bYn;

        public a mB(String str) {
            this.bYk = str;
            return this;
        }

        public a mC(String str) {
            this.bYl = str;
            return this;
        }

        public a mD(String str) {
            this.bYm = str;
            return this;
        }

        public a mE(String str) {
            this.bYn = str;
            return this;
        }

        public a mF(String str) {
            this.QH = str;
            return this;
        }

        public String agu() {
            String format = String.format(bYo, this.bYk, this.bYl);
            String format2 = String.format(bYp, this.bYk, this.bYm, this.bYn);
            String format3 = String.format(bYr, this.bYm, this.bYn);
            String format4 = String.format(bYq, this.QH);
            if (agv()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean agv() {
            return TextUtils.equals("baiduboxapp", this.bYm);
        }
    }
}
