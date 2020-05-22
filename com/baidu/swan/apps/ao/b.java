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
    private static String cJm;

    public static String asS() {
        return pv("swan");
    }

    public static String aco() {
        return pv("swangame");
    }

    private static String pv(String str) {
        String hostName = com.baidu.swan.apps.u.a.afB().getHostName();
        a aVar = new a();
        aVar.pw(str).px(c.getVersion()).py(hostName).pz(getVersionName()).pA(getOSVersion());
        return aVar.asT();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.u.a.aeR();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(cJm)) {
            return cJm;
        }
        try {
            cJm = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return cJm;
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
        private static String cJr = "%s/%s";
        private static String cJs = "%s-%s/%s";
        private static String cJt = "(Baidu; P1 %s)";
        private static String cJu = "%s/%s";
        private String ajP;
        private String cJn;
        private String cJo;
        private String cJp;
        private String cJq;

        public a pw(String str) {
            this.cJn = str;
            return this;
        }

        public a px(String str) {
            this.cJo = str;
            return this;
        }

        public a py(String str) {
            this.cJp = str;
            return this;
        }

        public a pz(String str) {
            this.cJq = str;
            return this;
        }

        public a pA(String str) {
            this.ajP = str;
            return this;
        }

        public String asT() {
            String format = String.format(cJr, this.cJn, this.cJo);
            String format2 = String.format(cJs, this.cJn, this.cJp, this.cJq);
            String format3 = String.format(cJu, this.cJp, this.cJq);
            String format4 = String.format(cJt, this.ajP);
            if (asU()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean asU() {
            return TextUtils.equals("baiduboxapp", this.cJp);
        }
    }
}
