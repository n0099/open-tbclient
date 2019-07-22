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
    private static String aZK;

    private static Context getContext() {
        return com.baidu.swan.apps.u.a.Ek();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(aZK)) {
            return aZK;
        }
        try {
            aZK = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return aZK;
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
        private String aZL;
        private String aZM;
        private String aZN;

        public a aJ(@NonNull String str, @NonNull String str2) {
            this.aZL = String.format("%s/%s", str, str2);
            return this;
        }

        public a aK(@NonNull String str, @NonNull String str2) {
            this.aZM = String.format("%s/%s", str, str2);
            return this;
        }

        public a aL(@NonNull String str, @NonNull String str2) {
            this.aZN = String.format("(%s; P1 %s)", str, str2);
            return this;
        }

        public String Pc() {
            return String.format("%s %s %s", this.aZL, this.aZM, this.aZN);
        }
    }
}
