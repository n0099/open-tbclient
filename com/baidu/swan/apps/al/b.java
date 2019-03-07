package com.baidu.swan.apps.al;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.c;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = c.DEBUG;
    private static String aVV;

    private static Context getContext() {
        return com.baidu.swan.apps.u.a.Cy();
    }

    public static String getVersionName() {
        if (!TextUtils.isEmpty(aVV)) {
            return aVV;
        }
        try {
            aVV = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            return aVV;
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
        private String aVW;
        private String aVX;
        private String aVY;

        public a aG(@NonNull String str, @NonNull String str2) {
            this.aVW = String.format("%s/%s", str, str2);
            return this;
        }

        public a aH(@NonNull String str, @NonNull String str2) {
            this.aVX = String.format("%s/%s", str, str2);
            return this;
        }

        public a aI(@NonNull String str, @NonNull String str2) {
            this.aVY = String.format("(%s; P1 %s)", str, str2);
            return this;
        }

        public String LJ() {
            return String.format("%s %s %s", this.aVW, this.aVX, this.aVY);
        }
    }
}
