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
    private static String doI;

    public static String aHB() {
        return tv("swan");
    }

    public static String aoE() {
        return tv("swangame");
    }

    private static String tv(String str) {
        String hostName = com.baidu.swan.apps.t.a.asS().getHostName();
        a aVar = new a();
        aVar.tw(str).tx(c.getVersion()).ty(hostName).tz(getVersionName()).tA(getOSVersion());
        return aVar.aHC();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.t.a.asf();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(doI)) {
            return doI;
        }
        try {
            doI = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return doI;
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
        private static String doN = "%s/%s";
        private static String doO = "%s-%s/%s";
        private static String doP = "(Baidu; P1 %s)";
        private static String doQ = "%s/%s";
        private String anu;
        private String doJ;
        private String doK;
        private String doL;
        private String doM;

        public a tw(String str) {
            this.doJ = str;
            return this;
        }

        public a tx(String str) {
            this.doK = str;
            return this;
        }

        public a ty(String str) {
            this.doL = str;
            return this;
        }

        public a tz(String str) {
            this.doM = str;
            return this;
        }

        public a tA(String str) {
            this.anu = str;
            return this;
        }

        public String aHC() {
            String format = String.format(doN, this.doJ, this.doK);
            String format2 = String.format(doO, this.doJ, this.doL, this.doM);
            String format3 = String.format(doQ, this.doL, this.doM);
            String format4 = String.format(doP, this.anu);
            if (aHD()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aHD() {
            return TextUtils.equals("baiduboxapp", this.doL);
        }
    }
}
