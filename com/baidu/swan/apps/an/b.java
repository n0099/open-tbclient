package com.baidu.swan.apps.an;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.c;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes25.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dIr;

    public static String aOu() {
        return uE("swan");
    }

    public static String avA() {
        return uE("swangame");
    }

    private static String uE(String str) {
        String hostName = com.baidu.swan.apps.t.a.azM().getHostName();
        a aVar = new a();
        aVar.uF(str).uG(c.getVersion()).uH(hostName).uI(getVersionName()).uJ(getOSVersion());
        return aVar.aOv();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.t.a.aza();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(dIr)) {
            return dIr;
        }
        try {
            dIr = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return dIr;
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

    /* loaded from: classes25.dex */
    public static class a {
        private static String dIw = "%s/%s";
        private static String dIx = "%s-%s/%s";
        private static String dIy = "(Baidu; P1 %s)";
        private static String dIz = "%s/%s";
        private String dIs;
        private String dIt;
        private String dIu;
        private String dIv;
        private String mOSVersion;

        public a uF(String str) {
            this.dIs = str;
            return this;
        }

        public a uG(String str) {
            this.dIt = str;
            return this;
        }

        public a uH(String str) {
            this.dIu = str;
            return this;
        }

        public a uI(String str) {
            this.dIv = str;
            return this;
        }

        public a uJ(String str) {
            this.mOSVersion = str;
            return this;
        }

        public String aOv() {
            String format = String.format(dIw, this.dIs, this.dIt);
            String format2 = String.format(dIx, this.dIs, this.dIu, this.dIv);
            String format3 = String.format(dIz, this.dIu, this.dIv);
            String format4 = String.format(dIy, this.mOSVersion);
            if (aOw()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aOw() {
            return TextUtils.equals("baiduboxapp", this.dIu);
        }
    }
}
