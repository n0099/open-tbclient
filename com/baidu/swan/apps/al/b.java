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
    private static String aWa;

    private static Context getContext() {
        return com.baidu.swan.apps.u.a.Cw();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(aWa)) {
            return aWa;
        }
        try {
            aWa = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return aWa;
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
        private String aWb;
        private String aWc;
        private String aWd;

        public a aG(@NonNull String str, @NonNull String str2) {
            this.aWb = String.format("%s/%s", str, str2);
            return this;
        }

        public a aH(@NonNull String str, @NonNull String str2) {
            this.aWc = String.format("%s/%s", str, str2);
            return this;
        }

        public a aI(@NonNull String str, @NonNull String str2) {
            this.aWd = String.format("(%s; P1 %s)", str, str2);
            return this;
        }

        public String LH() {
            return String.format("%s %s %s", this.aWb, this.aWc, this.aWd);
        }
    }
}
