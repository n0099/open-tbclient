package com.baidu.searchbox.datacollector.growth.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes3.dex */
public class PackageUtil {
    public static final boolean DEBUG = AppConfig.isDebug();

    public static String getFirstInstallTime(Context context) {
        long j;
        try {
            j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            j = 0;
        }
        return Base64.encodeToString(Long.toString(j).getBytes(), 0);
    }

    public static String getLastUpdateTime(Context context) {
        long j;
        try {
            j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            j = 0;
        }
        return Base64.encodeToString(Long.toString(j).getBytes(), 0);
    }
}
