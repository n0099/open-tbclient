package com.baidu.swan.apps.aq;

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
    private static String bTS;

    public static String aea() {
        return mm("swan");
    }

    public static String Pg() {
        return mm("swangame");
    }

    private static String mm(String str) {
        String hostName = com.baidu.swan.apps.w.a.Sr().getHostName();
        a aVar = new a();
        aVar.mn(str).mo(c.getVersion()).mp(hostName).mq(getVersionName()).mr(getOSVersion());
        return aVar.aeb();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.w.a.RG();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(bTS)) {
            return bTS;
        }
        try {
            bTS = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return bTS;
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
        private static String bTX = "%s/%s";
        private static String bTY = "%s-%s/%s";
        private static String bTZ = "(Baidu; P1 %s)";
        private static String bUa = "%s/%s";
        private String OW;
        private String bTT;
        private String bTU;
        private String bTV;
        private String bTW;

        public a mn(String str) {
            this.bTT = str;
            return this;
        }

        public a mo(String str) {
            this.bTU = str;
            return this;
        }

        public a mp(String str) {
            this.bTV = str;
            return this;
        }

        public a mq(String str) {
            this.bTW = str;
            return this;
        }

        public a mr(String str) {
            this.OW = str;
            return this;
        }

        public String aeb() {
            String format = String.format(bTX, this.bTT, this.bTU);
            String format2 = String.format(bTY, this.bTT, this.bTV, this.bTW);
            String format3 = String.format(bUa, this.bTV, this.bTW);
            String format4 = String.format(bTZ, this.OW);
            if (aec()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aec() {
            return TextUtils.equals("baiduboxapp", this.bTV);
        }
    }
}
