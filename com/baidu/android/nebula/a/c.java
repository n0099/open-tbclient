package com.baidu.android.nebula.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.preference.PreferenceManager;
/* loaded from: classes.dex */
public final class c {
    public static long a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sync_with_cloud_time_key", -1L);
    }

    public static long a(Context context, long j) {
        long j2 = -1;
        for (ResolveInfo resolveInfo : com.baidu.android.moplus.util.b.g(context)) {
            try {
                String str = resolveInfo.activityInfo.packageName;
                long j3 = context.createPackageContext(str, 0).getSharedPreferences(str + ".share_list", 1).getLong("last_sync_with_cloud_time_key", -1L);
                if (j3 > j2) {
                    j2 = j3;
                }
            } catch (PackageManager.NameNotFoundException e) {
            }
            j2 = j2;
        }
        if (j2 == -1) {
            b(context, j);
            return j;
        }
        return j2;
    }

    public static void b(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName() + ".share_list", 1).edit();
        edit.putLong("last_sync_with_cloud_time_key", j);
        edit.commit();
    }

    public static void c(Context context, long j) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("sync_with_cloud_time_key", j);
        edit.commit();
    }
}
