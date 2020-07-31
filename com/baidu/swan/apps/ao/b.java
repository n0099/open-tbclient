package com.baidu.swan.apps.ao;

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
    private static String cRs;

    public static String avZ() {
        return qo("swan");
    }

    public static String aeA() {
        return qo("swangame");
    }

    private static String qo(String str) {
        String hostName = com.baidu.swan.apps.t.a.ahU().getHostName();
        a aVar = new a();
        aVar.qp(str).qq(c.getVersion()).qr(hostName).qs(getVersionName()).qt(getOSVersion());
        return aVar.awa();
    }

    private static Context getContext() {
        return com.baidu.swan.apps.t.a.ahj();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(cRs)) {
            return cRs;
        }
        try {
            cRs = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return cRs;
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
        private String alg;
        private String cRt;
        private String cRu;
        private String cRv;
        private String cRw;
        private static String cRx = "%s/%s";
        private static String cRy = "%s-%s/%s";
        private static String cRz = "(Baidu; P1 %s)";
        private static String cRA = "%s/%s";

        public a qp(String str) {
            this.cRt = str;
            return this;
        }

        public a qq(String str) {
            this.cRu = str;
            return this;
        }

        public a qr(String str) {
            this.cRv = str;
            return this;
        }

        public a qs(String str) {
            this.cRw = str;
            return this;
        }

        public a qt(String str) {
            this.alg = str;
            return this;
        }

        public String awa() {
            String format = String.format(cRx, this.cRt, this.cRu);
            String format2 = String.format(cRy, this.cRt, this.cRv, this.cRw);
            String format3 = String.format(cRA, this.cRv, this.cRw);
            String format4 = String.format(cRz, this.alg);
            if (awb()) {
                return String.format("%s %s %s %s", format, format2, format3, format4);
            }
            return String.format("%s %s %s", format, format2, format4);
        }

        private boolean awb() {
            return TextUtils.equals("baiduboxapp", this.cRv);
        }
    }
}
