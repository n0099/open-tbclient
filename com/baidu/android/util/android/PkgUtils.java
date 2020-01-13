package com.baidu.android.util.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes12.dex */
public class PkgUtils {
    private static final String TAG = "PkgUtils";

    public static String getSign(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures.length <= 0) {
                return "";
            }
            return packageInfo.signatures[0].toCharsString();
        } catch (Exception e) {
            return "";
        }
    }

    public static String getSignByPermission(Context context, String str) {
        String str2 = "";
        try {
            str2 = context.getPackageManager().getPermissionInfo(str, 128).packageName;
        } catch (Exception e) {
        }
        return TextUtils.isEmpty(str2) ? str2 : getSign(context, str2);
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static String getPackageVersion(Context context, String str) {
        PackageInfo packageInfo = getPackageInfo(context, str);
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    public static String getPackageSourcePath(Context context) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            return applicationInfo.sourceDir;
        }
        return null;
    }
}
