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
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushService;
import com.baidu.zeus.bouncycastle.DERTags;
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

    public static String a(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, DERTags.TAGGED);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("getMetaDataString", "--- " + str + " GetMetaData Exception:\r\n", e);
            applicationInfo = null;
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return null;
        }
        return applicationInfo.metaData.getString(str2);
    }

    public static void a(Context context, long j) {
        Context applicationContext = context.getApplicationContext();
        a(applicationContext, PushConstants.createMethodIntent(applicationContext), j);
    }

    public static void a(Context context, Intent intent, long j) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 268435456);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        alarmManager.cancel(broadcast);
        alarmManager.set(3, SystemClock.elapsedRealtime() + j, broadcast);
    }

    public static void a(Context context, boolean z) {
        if (e(context, context.getPackageName())) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
            String str = z ? "enabled" : "disabled";
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("app_en", str);
            edit.commit();
            e(context, true);
            Intent f = f(context);
            f.setPackage(context.getPackageName());
            context.sendBroadcast(f);
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

    public static void b(Context context, boolean z) {
        if (e(context, context.getPackageName())) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
            String str = z ? "enabled" : "disabled";
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("loc_en", str);
            edit.commit();
            e(context, true);
            Intent f = f(context);
            f.setPackage(context.getPackageName());
            context.sendBroadcast(f);
        }
    }

    public static boolean b(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean b(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, DERTags.TAGGED);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("getMetaDataBoolean", "--- " + str + " GetMetaData Exception:\r\n", e);
            applicationInfo = null;
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return false;
        }
        return applicationInfo.metaData.getBoolean(str2);
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

    public static void c(Context context, boolean z) {
        if (e(context, context.getPackageName())) {
            com.baidu.android.pushservice.b.a(context, z);
            e(context, true);
            h(context, null);
        }
    }

    public static boolean c(Context context) {
        if (e(context, context.getPackageName())) {
            String a = com.baidu.android.pushservice.b.a(context);
            if ("enabled".equals(a)) {
                return false;
            }
            if ("disabled".equals(a)) {
                return true;
            }
            return b(context, context.getPackageName(), "DisableService");
        }
        return false;
    }

    public static void d(Context context) {
        a(context, 300000L);
    }

    public static void d(Context context, boolean z) {
        if (e(context, context.getPackageName())) {
            com.baidu.android.pushservice.b.b(context, z);
        }
    }

    public static boolean d(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, DERTags.TAGGED);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("isBaiduApp", "--- " + str + " GetMetaData Exception:\r\n", e);
            applicationInfo = null;
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return false;
        }
        return applicationInfo.metaData.getBoolean("IsBaiduApp");
    }

    public static void e(Context context) {
        String g = g(context);
        Intent f = f(context);
        f.setPackage(g);
        context.sendBroadcast(f);
    }

    public static void e(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        int c = c(context, context.getPackageName());
        if (sharedPreferences.getInt("pr_v", 0) < c || z) {
            SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1).edit();
            if (c(context)) {
                edit.putLong("priority", 0L);
            } else {
                edit.putLong("priority", i(context));
            }
            edit.putInt("version", 5);
            edit.commit();
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.putInt("pr_v", c);
            edit2.commit();
        }
    }

    public static boolean e(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, DERTags.TAGGED);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("isEnableInternal", "--- " + str + " GetMetaData Exception:\r\n", e);
            applicationInfo = null;
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return false;
        }
        return applicationInfo.metaData.getBoolean("EnablePrivate");
    }

    public static Intent f(Context context) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.addFlags(32);
        intent.putExtra(PushConstants.EXTRA_APP, PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        intent.putExtra("method_version", "V1");
        return intent;
    }

    public static boolean f(Context context, String str) {
        if (e(context, context.getPackageName())) {
            String string = context.getSharedPreferences("pst", 0).getString("app_en", "default");
            if ("enabled".equals(string)) {
                return false;
            }
            if ("disabled".equals(string)) {
                return true;
            }
            return b(context, context.getPackageName(), "DisableApplist");
        }
        return false;
    }

    public static String g(Context context) {
        SharedPreferences sharedPreferences;
        long j;
        j(context);
        List<ResolveInfo> k = k(context);
        if (k == null || k.size() <= 1) {
            return context.getPackageName();
        }
        long j2 = 0;
        String str = null;
        for (ResolveInfo resolveInfo : k) {
            String str2 = resolveInfo.activityInfo.packageName;
            try {
                sharedPreferences = context.createPackageContext(str2, 2).getSharedPreferences(str2 + ".push_sync", 1);
            } catch (PackageManager.NameNotFoundException e) {
                sharedPreferences = null;
            }
            if (sharedPreferences != null) {
                long j3 = sharedPreferences.getLong("priority", 1L);
                if (j3 > j2) {
                    j = j3;
                } else {
                    if (j3 == 1) {
                    }
                    str2 = str;
                    j = j2;
                }
                j2 = j;
                str = str2;
            }
        }
        return str == null ? context.getPackageName() : str;
    }

    public static boolean g(Context context, String str) {
        if (e(context, context.getPackageName())) {
            String string = context.getSharedPreferences("pst", 0).getString("loc_en", "default");
            if ("enabled".equals(string)) {
                return false;
            }
            if ("disabled".equals(string)) {
                return true;
            }
            return b(context, context.getPackageName(), "DisableLocalServer");
        }
        return false;
    }

    public static Intent h(Context context) {
        long j;
        String str;
        if (e(context, context.getPackageName())) {
            Intent createMethodIntent = PushConstants.createMethodIntent(context);
            if (TextUtils.isEmpty(createMethodIntent.getPackage())) {
                List<ResolveInfo> k = k(context);
                List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(100);
                Hashtable hashtable = new Hashtable();
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    hashtable.put(runningServiceInfo.service.getPackageName(), runningServiceInfo);
                }
                String str2 = null;
                long j2 = 0;
                int i = 0;
                String str3 = null;
                for (ResolveInfo resolveInfo : k) {
                    String str4 = resolveInfo.activityInfo.packageName;
                    Context context2 = null;
                    try {
                        context2 = context.createPackageContext(str4, 2);
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.e("Utility", "" + e);
                    }
                    if (context2 != null) {
                        SharedPreferences sharedPreferences = context2.getSharedPreferences(str4 + ".push_sync", 1);
                        int i2 = sharedPreferences.getInt("version", 0);
                        long j3 = sharedPreferences.getLong("priority", 0L);
                        ActivityManager.RunningServiceInfo runningServiceInfo2 = (ActivityManager.RunningServiceInfo) hashtable.get(str4);
                        if (runningServiceInfo2 != null && PushService.class.getName().equals(runningServiceInfo2.service.getClassName()) && i2 > i) {
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
                    str3 = j2 >= 2 ? str2 : null;
                }
                createMethodIntent.setPackage(str3);
                return createMethodIntent;
            }
            return createMethodIntent;
        }
        return null;
    }

    public static void h(Context context, String str) {
        Intent createMethodIntent = PushConstants.createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, "pushservice_restart");
        createMethodIntent.setPackage(str);
        context.sendBroadcast(createMethodIntent);
    }

    public static long i(Context context) {
        long j = 5 << 1;
        if (!g(context, context.getPackageName())) {
            j++;
        }
        long j2 = j << 1;
        if (!f(context, context.getPackageName())) {
            j2++;
        }
        long j3 = j2 << 1;
        if (d(context, context.getPackageName())) {
            j3++;
        }
        long j4 = j3 << 1;
        return b(context, context.getPackageName()) ? j4 + 1 : j4;
    }

    public static void j(Context context) {
        e(context, false);
    }

    public static List k(Context context) {
        return context.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.android.pushservice.action.BIND_SYNC"), 0);
    }
}
