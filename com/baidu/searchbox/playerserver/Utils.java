package com.baidu.searchbox.playerserver;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import com.kuaishou.weapon.p0.g;
/* loaded from: classes4.dex */
public class Utils {
    public static String getExternalStorageCacheDirectory(Context context) {
        String str = null;
        try {
            if (!hasExternalStoragePermission(context)) {
                if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                    str = context.getExternalCacheDir().getPath();
                }
            } else {
                str = Environment.getExternalStorageDirectory().getAbsolutePath();
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public static boolean hasExternalStoragePermission(Context context) {
        PackageManager packageManager;
        if (context != null && (packageManager = context.getPackageManager()) != null) {
            try {
                if (Build.VERSION.SDK_INT >= 30 || packageManager.checkPermission(g.i, context.getPackageName()) != 0) {
                    return false;
                }
                if (packageManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) != 0) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
