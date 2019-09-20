package com.baidu.swan.apps.al;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bai;

    private static Context getContext() {
        return com.baidu.swan.apps.u.a.Eo();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(bai)) {
            return bai;
        }
        try {
            bai = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return bai;
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
        return str.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private String baj;
        private String bak;
        private String bal;

        public a aJ(@NonNull String str, @NonNull String str2) {
            this.baj = String.format("%s/%s", str, str2);
            return this;
        }

        public a aK(@NonNull String str, @NonNull String str2) {
            this.bak = String.format("%s/%s", str, str2);
            return this;
        }

        public a aL(@NonNull String str, @NonNull String str2) {
            this.bal = String.format("(%s; P1 %s)", str, str2);
            return this;
        }

        public String Pg() {
            return String.format("%s %s %s", this.baj, this.bak, this.bal);
        }
    }
}
