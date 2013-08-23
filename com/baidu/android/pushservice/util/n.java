package com.baidu.android.pushservice.util;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.LocalServerSocket;
import android.os.Environment;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.common.util.Util;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.location.LocationClientOption;
import com.baidu.zeus.bouncycastle.DERTags;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f656a = {"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.RECEIVE_BOOT_COMPLETED", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.SYSTEM_ALERT_WINDOW", "android.permission.DISABLE_KEYGUARD", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_WIFI_STATE"};

    public static PackageInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static String a(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        long currentTimeMillis = System.currentTimeMillis() - j;
        long ceil = (long) Math.ceil((currentTimeMillis * 1.0d) / 1000.0d);
        long ceil2 = (long) Math.ceil(((float) (currentTimeMillis / 60)) / 1000.0f);
        long ceil3 = (long) Math.ceil(((float) ((currentTimeMillis / 60) / 60)) / 1000.0f);
        long ceil4 = (long) Math.ceil(((float) (((currentTimeMillis / 24) / 60) / 60)) / 1000.0f);
        if (ceil4 - 1 > 3) {
            stringBuffer.append(new SimpleDateFormat("MM月dd日").format(new Date(j)));
        } else if (ceil4 - 1 > 0) {
            stringBuffer.append(ceil4 + "天前");
        } else if (ceil3 - 1 > 0) {
            if (ceil3 >= 24) {
                stringBuffer.append("1天前");
            } else {
                stringBuffer.append(ceil3 + "小时前");
            }
        } else if (ceil2 - 1 > 0) {
            if (ceil2 == 60) {
                stringBuffer.append("1小时前");
            } else {
                stringBuffer.append(ceil2 + "分钟前");
            }
        } else if (ceil - 1 <= 0) {
            stringBuffer.append("刚刚");
        } else if (ceil == 60) {
            stringBuffer.append("1分钟前");
        } else {
            stringBuffer.append(ceil + "秒前");
        }
        return stringBuffer.toString();
    }

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
        th.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        return stringWriter.toString();
    }

    public static void a(Context context, long j) {
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("Utility", ">>> setAlarmForRestart");
        }
        Context applicationContext = context.getApplicationContext();
        a(applicationContext, PushConstants.createMethodIntent(applicationContext), j);
    }

    public static void a(Context context, Intent intent, long j) {
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("Utility", ">>> setAlarmForSendInent : \r\n" + intent);
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 268435456);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        alarmManager.cancel(broadcast);
        alarmManager.set(3, SystemClock.elapsedRealtime() + j, broadcast);
    }

    public static void a(Context context, boolean z) {
        if (f(context, context.getPackageName())) {
            com.baidu.android.pushservice.b.b(context, z);
            c(context, true);
            g(context, context.getPackageName());
        }
    }

    public static synchronized void a(String str) {
        File[] listFiles;
        synchronized (n.class) {
            String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
            String concat = format.substring(0, 4).concat(format.substring(5, 7)).concat(format.substring(8, 10));
            String str2 = format + " " + str + "\n\r";
            try {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(absolutePath, "baidu/pushservice/files");
                if (file.exists()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                    for (File file2 : file.listFiles()) {
                        if (file2.getName().startsWith("msg") && Integer.parseInt(concat) - Integer.parseInt(simpleDateFormat.format(Long.valueOf(file2.lastModified()))) >= 7) {
                            file2.delete();
                        }
                    }
                } else {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(new File(absolutePath, "baidu/pushservice/files/msg" + concat + ".log"), true);
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
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

    public static boolean a(Context context, String str, String str2) {
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

    static boolean a(String str, List list) {
        for (int i = 0; i < list.size(); i++) {
            if (str != null && str.equals(((ResolveInfo) list.get(i)).activityInfo.name)) {
                return ((ResolveInfo) list.get(i)).activityInfo.enabled;
            }
        }
        return false;
    }

    static boolean a(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static Intent b(Context context, String str) {
        o oVar = new o();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        Intent registerReceiver = context.registerReceiver(oVar, intentFilter);
        context.unregisterReceiver(oVar);
        return registerReceiver;
    }

    public static void b(Context context, boolean z) {
        if (f(context, context.getPackageName())) {
            com.baidu.android.pushservice.b.c(context, z);
        }
    }

    static boolean b(Context context, String str, String str2) {
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        return a(str2, context.getPackageManager().queryBroadcastReceivers(intent, 0));
    }

    public static int[] b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.heightPixels, displayMetrics.widthPixels};
    }

    public static void c(Context context, boolean z) {
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("Utility", "updateServiceInfo2  isForce =" + z);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        int d = d(context, context.getPackageName());
        if (sharedPreferences.getInt("pr_app_v", 0) < d || z) {
            SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1).edit();
            if (c(context)) {
                edit.putLong("priority2", 0L);
            } else if (m(context)) {
                edit.putLong("priority2", k(context));
            } else {
                edit.putLong("priority2", 0L);
            }
            edit.putInt("version2", 11);
            edit.commit();
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.putInt("pr_app_v", d);
            edit2.commit();
        }
    }

    public static boolean c(Context context) {
        String c = com.baidu.android.pushservice.b.c(context);
        boolean a2 = "enabled".equals(c) ? false : "disabled".equals(c) ? true : a(context, context.getPackageName(), "DisableService");
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("Utility", "--- isDisableService : " + a2);
        }
        return a2;
    }

    public static boolean c(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int d(Context context, String str) {
        PackageInfo a2 = a(context, str);
        if (a2 != null) {
            return a2.versionCode;
        }
        return 0;
    }

    public static Intent d(Context context) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.addFlags(32);
        intent.putExtra(PushConstants.EXTRA_APP, PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        intent.putExtra("method_version", "V2");
        return intent;
    }

    public static Intent e(Context context) {
        return d(context);
    }

    public static boolean e(Context context, String str) {
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

    public static void f(Context context) {
        c(context, false);
    }

    public static boolean f(Context context, String str) {
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

    public static void g(Context context, String str) {
        if (!f(context, context.getPackageName())) {
            j(context);
            return;
        }
        Intent createMethodIntent = PushConstants.createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, "pushservice_restart");
        createMethodIntent.setPackage(str);
        context.sendBroadcast(createMethodIntent);
        com.baidu.android.pushservice.b.a(context, false);
    }

    static boolean g(Context context) {
        boolean z = false;
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), LVBuffer.LENGTH_ALLOC_PER_NEW).requestedPermissions;
            if (strArr != null) {
                int i = 0;
                while (true) {
                    if (i >= f656a.length) {
                        z = true;
                        break;
                    } else if (!a(f656a[i], strArr)) {
                        Log.e("Utility", f656a[i] + " permission Push-SDK need is not exist !");
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                Log.e("Utility", "Permissions Push-SDK need are not exist !");
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return z;
    }

    static boolean h(Context context) {
        if (!b(context, "android.intent.action.BOOT_COMPLETED", "com.baidu.android.pushservice.PushServiceReceiver")) {
            Log.e("Utility", "com.baidu.android.pushservice.PushServiceReceiverdid not declaredandroid.intent.action.BOOT_COMPLETED");
            return false;
        } else if (!b(context, "android.net.conn.CONNECTIVITY_CHANGE", "com.baidu.android.pushservice.PushServiceReceiver")) {
            Log.e("Utility", "com.baidu.android.pushservice.PushServiceReceiverdid not declaredandroid.net.conn.CONNECTIVITY_CHANGE");
            return false;
        } else if (!b(context, "com.baidu.android.pushservice.action.notification.SHOW", "com.baidu.android.pushservice.PushServiceReceiver")) {
            Log.e("Utility", "com.baidu.android.pushservice.PushServiceReceiverdid not declaredcom.baidu.android.pushservice.action.notification.SHOW");
            return false;
        } else if (!b(context, PushConstants.ACTION_METHOD, "com.baidu.android.pushservice.RegistrationReceiver")) {
            Log.e("Utility", "com.baidu.android.pushservice.RegistrationReceiverdid not declaredcom.baidu.android.pushservice.action.METHOD");
            return false;
        } else if (b(context, "com.baidu.android.pushservice.action.BIND_SYNC", "com.baidu.android.pushservice.RegistrationReceiver")) {
            return true;
        } else {
            Log.e("Utility", "com.baidu.android.pushservice.RegistrationReceiverdid not declaredcom.baidu.android.pushservice.action.BIND_SYNC");
            return false;
        }
    }

    public static void i(Context context) {
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("Utility", ">>> setAlarmForPeriodRestart");
        }
        a(context, 300000L);
    }

    public static void j(Context context) {
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("Utility", "--- Start Service from" + context.getPackageName());
        }
        if (!com.baidu.android.pushservice.b.b(context)) {
            String packageName = context.getPackageName();
            Intent d = d(context);
            d.setPackage(packageName);
            context.sendBroadcast(d);
            return;
        }
        Intent d2 = d(context);
        d2.putExtra(PushConstants.EXTRA_METHOD, "pushservice_restart");
        d2.putExtra(PushConstants.PACKAGE_NAME, context.getPackageName());
        d2.setPackage(null);
        context.sendBroadcast(d2);
        Intent d3 = d(context);
        d3.putExtra("type", "service_restart");
        d3.setPackage(null);
        context.sendBroadcast(d3);
        com.baidu.android.pushservice.b.a(context, false);
    }

    public static long k(Context context) {
        long j = 11 << 1;
        if (e(context, context.getPackageName())) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("Utility", "--- get " + context + " PriorityVersion, baidu app");
            }
            j++;
        }
        long j2 = j << 1;
        if (c(context, context.getPackageName())) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("Utility", "--- get " + context + " PriorityVersion, system app");
            }
            j2++;
        }
        return j2 << 2;
    }

    static boolean l(Context context) {
        ServiceInfo[] serviceInfoArr = null;
        try {
            serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("Utility", "Permissions Push-SDK package name not found !");
            e.printStackTrace();
        }
        if (serviceInfoArr == null) {
            Log.e("Utility", "Push-SDK PushService or MoPlusService need are not exist !");
            return false;
        }
        for (int i = 0; i < serviceInfoArr.length; i++) {
            if ("com.baidu.android.pushservice.PushService".equals(serviceInfoArr[i].name)) {
                return serviceInfoArr[i].exported && serviceInfoArr[i].enabled;
            }
        }
        return false;
    }

    static boolean m(Context context) {
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("Utility", "check PushService AndroidManifest declearation !");
        }
        return g(context) && h(context) && l(context);
    }

    public static List n(Context context) {
        return context.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.android.pushservice.action.BIND_SYNC"), 0);
    }

    public static boolean o(Context context) {
        LocalServerSocket localServerSocket;
        boolean z = true;
        try {
            localServerSocket = new LocalServerSocket(p(context));
        } catch (Exception e) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("Utility", "--- Socket Adress (" + p(context) + ") in use --- @ " + context.getPackageName());
            }
            localServerSocket = null;
        }
        if (localServerSocket != null) {
            z = false;
            try {
                localServerSocket.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return z;
    }

    public static String p(Context context) {
        return Util.toMd5(("com.baidu.pushservice.singelinstancev2" + DeviceId.getDeviceID(context)).getBytes(), false);
    }

    public static ArrayList q(Context context) {
        SharedPreferences sharedPreferences;
        ArrayList r = r(context);
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(LocationClientOption.MIN_SCAN_SPAN);
        ArrayList arrayList = new ArrayList();
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
            String packageName = runningServiceInfo.service.getPackageName();
            if (!arrayList.contains(packageName) && r.contains(packageName) && (runningServiceInfo.service.getClassName().contains("PushService") || runningServiceInfo.service.getClassName().contains("MoPlusService"))) {
                try {
                    sharedPreferences = context.createPackageContext(packageName, 2).getSharedPreferences(packageName + ".push_sync", 1);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("Utility", e.getMessage());
                    sharedPreferences = null;
                }
                if (sharedPreferences == null) {
                    Log.w("Utility", "App:" + packageName + " doesn't init Version!");
                } else if (sharedPreferences.getInt("version", 0) > 0) {
                    arrayList.add(runningServiceInfo.service.getPackageName());
                }
            }
        }
        return arrayList;
    }

    private static ArrayList r(Context context) {
        List<ResolveInfo> n = n(context.getApplicationContext());
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : n) {
            arrayList.add(resolveInfo.activityInfo.packageName);
        }
        return arrayList;
    }
}
