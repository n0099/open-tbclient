package com.baidu.android.util.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes.dex */
public class PkgUtils {
    public static boolean DEBUG = false;
    public static final String TAG = "PkgUtils";

    @SuppressLint({"PackageManagerGetSignatures"})
    public static PackageInfo getPackageInfo(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e2) {
            if (DEBUG) {
                Log.w(TAG, e2.getMessage());
                return null;
            }
            return null;
        }
    }

    public static String getPackageSourcePath(Context context) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            return applicationInfo.sourceDir;
        }
        return null;
    }

    public static String getPackageVersion(Context context, String str) {
        PackageInfo packageInfo = getPackageInfo(context, str);
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String getSign(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            return (packageInfo == null || packageInfo.signatures.length <= 0) ? "" : packageInfo.signatures[0].toCharsString();
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, "get sign error!!!", e2);
                return "";
            }
            return "";
        }
    }

    public static String getSignByPermission(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPermissionInfo(str, 128).packageName;
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, "get packageName error!!!", e2);
            }
            str2 = "";
        }
        return TextUtils.isEmpty(str2) ? str2 : getSign(context, str2);
    }
}
