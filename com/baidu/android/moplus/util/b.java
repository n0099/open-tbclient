package com.baidu.android.moplus.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.moplus.MoPlusReceiver;
import com.baidu.android.moplus.MoPlusService;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.systemmonitor.StatisticManager;
import com.baidu.zeus.bouncycastle.DERTags;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f515a = {"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.BROADCAST_STICKY", "android.permission.WRITE_SETTINGS", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.SET_ACTIVITY_WATCHER", "android.permission.GET_TASKS"};
    private static final String[] b = {MoPlusService.class.getName(), MoPlusReceiver.class.getName()};
    private static final String[] c = {"com.baidu.android.moplus.action.START", "android.net.conn.CONNECTIVITY_CHANGE", "com.baidu.android.pushservice.action.BIND_SYNC", "android.intent.action.BOOT_COMPLETED"};

    public static PackageInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static String a(Context context, String str, String str2) {
        long j;
        List<ResolveInfo> g = g(context);
        if (g == null || g.size() <= 1) {
            return context.getPackageName();
        }
        String packageName = context.getPackageName();
        long j2 = 0;
        String str3 = packageName;
        for (ResolveInfo resolveInfo : g) {
            String str4 = resolveInfo.activityInfo.packageName;
            SharedPreferences sharedPreferences = null;
            try {
                sharedPreferences = context.createPackageContext(str4, 2).getSharedPreferences(str4 + str, 1);
            } catch (PackageManager.NameNotFoundException e) {
            }
            if (sharedPreferences != null) {
                long j3 = sharedPreferences.getLong(str2, 1L);
                if (j3 > j2) {
                    j = j3;
                } else {
                    if (j3 == 1) {
                    }
                    str4 = str3;
                    j = j2;
                }
                j2 = j;
                str3 = str4;
            }
        }
        return str3;
    }

    public static void a(Context context, long j) {
        Context applicationContext = context.getApplicationContext();
        Intent c2 = c(applicationContext);
        c2.setPackage(d(applicationContext));
        a(applicationContext, c2, j);
    }

    public static void a(Context context, Intent intent, long j) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 268435456);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        alarmManager.cancel(broadcast);
        alarmManager.set(3, SystemClock.elapsedRealtime() + j, broadcast);
    }

    public static void a(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        String str = z ? "enabled" : "disabled";
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("app_en", str);
        edit.commit();
        e(context, true);
        Intent c2 = c(context);
        c2.setPackage(context.getPackageName());
        context.sendBroadcast(c2);
    }

    public static boolean a(Context context) {
        String b2 = com.baidu.android.moplus.a.b(context);
        if ("enabled".equals(b2)) {
            return false;
        }
        if ("disabled".equals(b2)) {
            return true;
        }
        return c(context, context.getPackageName(), "DisableService");
    }

    private static boolean a(Context context, String str, String... strArr) {
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(new Intent(strArr[0]), 64);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() == 0) {
            return false;
        }
        ResolveInfo resolveInfo = null;
        Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            if (TextUtils.equals(next.activityInfo.packageName, context.getPackageName()) && TextUtils.equals(next.activityInfo.name, str)) {
                resolveInfo = next;
                break;
            }
        }
        if (resolveInfo == null || resolveInfo.filter == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (!resolveInfo.filter.hasAction(str2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Context context, String... strArr) {
        try {
            String[] strArr2 = context.getPackageManager().getPackageInfo(context.getPackageName(), LVBuffer.LENGTH_ALLOC_PER_NEW).requestedPermissions;
            HashMap hashMap = new HashMap();
            for (String str : strArr2) {
                hashMap.put(str, str);
            }
            for (String str2 : strArr) {
                if (!hashMap.containsKey(str2)) {
                    Log.e("Utility", "--- checkPermissions : short of per ：" + str2);
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("Utility", "--- Oops, that's imposible @ checkPermissions!");
            return false;
        }
    }

    public static boolean a(String str, Context context) {
        boolean z;
        if (str == null) {
        }
        List g = g(context);
        if (g.size() <= 1) {
            return false;
        }
        long j = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1).getLong("priority", 0L);
        Iterator it = g.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            String str2 = ((ResolveInfo) it.next()).activityInfo.packageName;
            if (!context.getPackageName().equals(str2)) {
                SharedPreferences sharedPreferences = null;
                try {
                    sharedPreferences = context.createPackageContext(str2, 2).getSharedPreferences(str2 + ".push_sync", 1);
                } catch (PackageManager.NameNotFoundException e) {
                }
                if (sharedPreferences != null && sharedPreferences.getLong("priority", 0L) > j) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public static String b(Context context, String str, String str2) {
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

    public static void b(Context context) {
        if (com.baidu.android.moplus.a.a(context)) {
            h(context, null);
            return;
        }
        String packageName = context.getPackageName();
        Intent c2 = c(context);
        c2.setPackage(packageName);
        context.sendBroadcast(c2);
    }

    public static void b(Context context, boolean z) {
        c(context, z);
    }

    public static boolean b(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private static boolean b(Context context, String... strArr) {
        ServiceInfo[] serviceInfoArr;
        ActivityInfo[] activityInfoArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 6);
            HashMap hashMap = new HashMap();
            for (ServiceInfo serviceInfo : packageInfo.services) {
                hashMap.put(serviceInfo.name, serviceInfo);
            }
            for (ActivityInfo activityInfo : packageInfo.receivers) {
                hashMap.put(activityInfo.name, activityInfo);
            }
            for (String str : strArr) {
                if (!hashMap.containsKey(str)) {
                    Log.e("Utility", "--- checkComponents : short of cmp ：" + str);
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("Utility", "--- Oops, that's imposible @ checkComponents!");
            return false;
        }
    }

    public static int c(Context context, String str) {
        PackageInfo a2 = a(context, str);
        if (a2 != null) {
            return a2.versionCode;
        }
        return 0;
    }

    public static Intent c(Context context) {
        Intent intent = new Intent("com.baidu.android.moplus.action.START");
        intent.addFlags(32);
        intent.putExtra("method_version", "V1");
        return intent;
    }

    public static void c(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        String str = z ? "enabled" : "disabled";
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("loc_en", str);
        edit.commit();
        e(context, true);
        Intent c2 = c(context);
        c2.setPackage(context.getPackageName());
        context.sendBroadcast(c2);
    }

    public static boolean c(Context context, String str, String str2) {
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

    public static String d(Context context) {
        return a(context, ".push_sync", "priority");
    }

    public static void d(Context context, boolean z) {
        if (a(context) == (!z)) {
            return;
        }
        com.baidu.android.moplus.a.b(context, z);
        e(context, true);
        h(context, null);
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

    public static long e(Context context) {
        long j = (g(context, context.getPackageName()) ? 0L : 0 + 1) << 1;
        if (!h(context)) {
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
        if (b(context, context.getPackageName())) {
            j4++;
        }
        return j4 | 3377699720527872L;
    }

    public static void e(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        int c2 = c(context, context.getPackageName());
        if (sharedPreferences.getInt("pr_v", 0) < c2 || z) {
            SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1).edit();
            if (a(context) || !i(context)) {
                edit.putLong("priority", 0L);
            } else {
                edit.putLong("priority", e(context));
            }
            edit.putInt("version", 12);
            if (h(context)) {
                edit.putLong(StatisticManager.class.getSimpleName() + "priority", 0L);
            } else {
                edit.putLong(StatisticManager.class.getSimpleName() + "priority", StatisticManager.getPriority(context));
            }
            edit.putInt(StatisticManager.class.getSimpleName() + "priority", StatisticManager.getVersion(context));
            edit.commit();
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.putInt("pr_v", c2);
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

    public static void f(Context context) {
        e(context, false);
    }

    public static void f(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        String str = z ? "enabled" : "disabled";
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("tj_en", str);
        edit.commit();
        e(context, true);
        Intent c2 = c(context);
        c2.setPackage(context.getPackageName());
        context.sendBroadcast(c2);
    }

    public static boolean f(Context context, String str) {
        String string = context.getSharedPreferences("pst", 0).getString("app_en", "default");
        if ("enabled".equals(string)) {
            return false;
        }
        if ("disabled".equals(string)) {
            return true;
        }
        return c(context, context.getPackageName(), "DisableApplist");
    }

    public static List g(Context context) {
        return context.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.android.pushservice.action.BIND_SYNC"), 0);
    }

    public static boolean g(Context context, String str) {
        String string = context.getSharedPreferences("pst", 0).getString("loc_en", "default");
        if ("enabled".equals(string)) {
            return false;
        }
        if ("disabled".equals(string)) {
            return true;
        }
        return c(context, context.getPackageName(), "DisableLocalServer");
    }

    public static void h(Context context, String str) {
        Intent c2 = c(context);
        c2.setAction(PushConstants.ACTION_METHOD);
        c2.putExtra(PushConstants.EXTRA_METHOD, "pushservice_restart");
        c2.setPackage(null);
        context.sendBroadcast(c2);
        Intent c3 = c(context);
        c3.putExtra("type", "service_restart");
        c3.setPackage(str);
        context.sendBroadcast(c3);
        Intent c4 = c(context);
        c4.putExtra("type", "service_sing_restart");
        c4.setPackage(str);
        context.sendBroadcast(c4);
        com.baidu.android.moplus.a.a(context, false);
    }

    public static boolean h(Context context) {
        String string = context.getSharedPreferences("pst", 0).getString("tj_en", "default");
        if ("enabled".equals(string)) {
            return false;
        }
        if ("disabled".equals(string)) {
            return true;
        }
        return c(context, context.getPackageName(), "DisableStatistic");
    }

    public static boolean i(Context context) {
        if (!a(context, f515a)) {
            Log.e("Utility", "*** Short of PERMISSIONS!");
            return false;
        } else if (!b(context, b)) {
            Log.e("Utility", "*** Short of COMPONENTS!");
            return false;
        } else if (a(context, MoPlusReceiver.class.getName(), c)) {
            return true;
        } else {
            Log.e("Utility", "*** Short of ACTIONS!");
            return false;
        }
    }

    public static boolean j(Context context) {
        try {
            for (ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services) {
                if (TextUtils.equals(serviceInfo.name, "com.baidu.android.pushservice.PushService")) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
