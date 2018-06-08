package com.baidu.ar.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
/* loaded from: classes3.dex */
public class AppUtils {
    public static String getApplicationName(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void openDetailSettings(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void openSettings(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.settings.SETTINGS");
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}
