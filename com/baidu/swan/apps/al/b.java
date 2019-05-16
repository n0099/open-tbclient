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
    private static String aZa;

    private static Context getContext() {
        return com.baidu.swan.apps.u.a.DB();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(aZa)) {
            return aZa;
        }
        try {
            aZa = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return aZa;
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
        private String aZb;
        private String aZc;
        private String aZd;

        public a aJ(@NonNull String str, @NonNull String str2) {
            this.aZb = String.format("%s/%s", str, str2);
            return this;
        }

        public a aK(@NonNull String str, @NonNull String str2) {
            this.aZc = String.format("%s/%s", str, str2);
            return this;
        }

        public a aL(@NonNull String str, @NonNull String str2) {
            this.aZd = String.format("(%s; P1 %s)", str, str2);
            return this;
        }

        public String On() {
            return String.format("%s %s %s", this.aZb, this.aZc, this.aZd);
        }
    }
}
