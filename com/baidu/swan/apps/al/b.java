package com.baidu.swan.apps.al;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bsq;

    private static Context getContext() {
        return com.baidu.swan.apps.u.a.Jj();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(bsq)) {
            return bsq;
        }
        try {
            bsq = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return bsq;
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

    /* loaded from: classes2.dex */
    public static class a {
        private String bsr;
        private String bss;
        private String bst;

        public a aQ(@NonNull String str, @NonNull String str2) {
            this.bsr = String.format("%s/%s", str, str2);
            return this;
        }

        public a aR(@NonNull String str, @NonNull String str2) {
            this.bss = String.format("%s/%s", str, str2);
            return this;
        }

        public a aS(@NonNull String str, @NonNull String str2) {
            this.bst = String.format("(%s; P1 %s)", str, str2);
            return this;
        }

        public String TU() {
            return String.format("%s %s %s", this.bsr, this.bss, this.bst);
        }
    }
}
