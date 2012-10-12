package com.baidu.android.pushservice.util;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.service.TiebaUpdateService;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
/* loaded from: classes.dex */
public final class d {
    public static PackageInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static void a(Context context, long j) {
        Context applicationContext = context.getApplicationContext();
        PendingIntent broadcast = PendingIntent.getBroadcast(applicationContext, 0, PushConstants.createMethodIntent(applicationContext), 268435456);
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService("alarm");
        alarmManager.cancel(broadcast);
        alarmManager.set(3, SystemClock.elapsedRealtime() + j, broadcast);
    }

    public static void a(Context context, boolean z) {
        if (e(context, context.getPackageName())) {
            com.baidu.android.pushservice.b.a(context, z);
            long e = z ? e(context) : 0L;
            SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1).edit();
            edit.putLong("priority", e);
            edit.commit();
            f(context, context.getPackageName());
        }
    }

    public static boolean a(Context context) {
        File file = new File("/data/data/root");
        try {
            file.createNewFile();
            if (file.exists()) {
                file.delete();
                return true;
            }
            return true;
        } catch (IOException e) {
            return (a(context, "com.noshufou.android.su") == null && a(context, "com.miui.uac") == null) ? false : true;
        }
    }

    public static boolean b(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int[] b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.heightPixels, displayMetrics.widthPixels};
    }

    public static int c(Context context, String str) {
        PackageInfo a = a(context, str);
        if (a != null) {
            return a.versionCode;
        }
        return 0;
    }

    public static void c(Context context) {
        a(context, 300000L);
    }

    public static Intent d(Context context) {
        long j;
        String str;
        if (e(context, context.getPackageName())) {
            Intent createMethodIntent = PushConstants.createMethodIntent(context);
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.android.pushservice.action.BIND_SYNC"), 0);
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(50);
            Hashtable hashtable = new Hashtable();
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                hashtable.put(runningServiceInfo.service.getPackageName(), runningServiceInfo);
            }
            String str2 = null;
            long j2 = 0;
            int i = 0;
            String str3 = null;
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                String str4 = resolveInfo.activityInfo.packageName;
                Context context2 = null;
                try {
                    context2 = context.createPackageContext(str4, 2);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("Utility", "" + e);
                }
                if (context2 != null) {
                    SharedPreferences sharedPreferences = context2.getSharedPreferences(str4 + ".push_sync", 1);
                    int i2 = sharedPreferences.getInt(TiebaUpdateService.TAG_VERSION, 0);
                    long j3 = sharedPreferences.getLong("priority", 0L);
                    ActivityManager.RunningServiceInfo runningServiceInfo2 = (ActivityManager.RunningServiceInfo) hashtable.get(str4);
                    if (runningServiceInfo2 != null && runningServiceInfo2.process.contains("pushservice") && i2 > i) {
                        i = i2;
                        str3 = str4;
                    }
                    if (j3 > j2) {
                        j = j3;
                        str = str4;
                    } else {
                        j = j2;
                        str = str2;
                    }
                    j2 = j;
                    str2 = str;
                }
            }
            if (i < 2) {
                str3 = str2;
            }
            createMethodIntent.setPackage(str3);
            return createMethodIntent;
        }
        return null;
    }

    public static boolean d(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("isBaiduApp", "--- " + str + " GetMetaData Exception:\r\n", e);
            applicationInfo = null;
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return false;
        }
        return applicationInfo.metaData.getBoolean("IsBaiduApp");
    }

    public static long e(Context context) {
        long j = 3 << 1;
        if (d(context, context.getPackageName())) {
            j++;
        }
        long j2 = j << 1;
        return b(context, context.getPackageName()) ? j2 + 1 : j2;
    }

    public static boolean e(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("isEnableInternal", "--- " + str + " GetMetaData Exception:\r\n", e);
            applicationInfo = null;
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return false;
        }
        return applicationInfo.metaData.getBoolean("EnablePrivate");
    }

    public static void f(Context context, String str) {
        Intent createMethodIntent = PushConstants.createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, "pushservice_restart");
        if (str != null) {
            createMethodIntent.setPackage(str);
        }
        context.sendBroadcast(createMethodIntent);
    }
}
