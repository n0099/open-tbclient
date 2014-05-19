package com.baidu.sapi2.utils;

import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes.dex */
public class c {
    public static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getPackageInfo(str, 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception e) {
            return null;
        }
    }
}
