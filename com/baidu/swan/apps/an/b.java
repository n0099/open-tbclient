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
    private static String dDa;

    public static String aLV() {
        return uc("swan");
    }

    public static String ata() {
        return uc("swangame");
    }

    private static String uc(String str) {
        String hostName = com.baidu.swan.apps.t.a.axm().getHostName();
        a aVar = new a();
        aVar.ud(str).ue(c.getVersion()).uf(hostName).ug(getVersionName()).uh(getOSVersion());
        return aVar.aLW();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.t.a.awA();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(dDa)) {
            return dDa;
        }
        try {
            dDa = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return dDa;
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
        private static String dDf = "%s/%s";
        private static String dDg = "%s-%s/%s";
        private static String dDh = "(Baidu; P1 %s)";
        private static String dDi = "%s/%s";
        private String anv;
        private String dDb;
        private String dDc;
        private String dDd;
        private String dDe;

        public a ud(String str) {
            this.dDb = str;
            return this;
        }

        public a ue(String str) {
            this.dDc = str;
            return this;
        }

        public a uf(String str) {
            this.dDd = str;
            return this;
        }

        public a ug(String str) {
            this.dDe = str;
            return this;
        }

        public a uh(String str) {
            this.anv = str;
            return this;
        }

        public String aLW() {
            String format = String.format(dDf, this.dDb, this.dDc);
            String format2 = String.format(dDg, this.dDb, this.dDd, this.dDe);
            String format3 = String.format(dDi, this.dDd, this.dDe);
            String format4 = String.format(dDh, this.anv);
            if (aLX()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean aLX() {
            return TextUtils.equals("baiduboxapp", this.dDd);
        }
    }
}
