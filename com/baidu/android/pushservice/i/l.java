package com.baidu.android.pushservice.i;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.c.c;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.coloros.mcssdk.PushManager;
import com.coloros.mcssdk.callback.PushCallback;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
@SuppressLint({"WorldReadableFiles"})
/* loaded from: classes3.dex */
public final class l {
    private static final String[] a = {"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE"};
    private static int b = -1;
    private static boolean c = false;

    public static int A(Context context, String str) {
        try {
            PackageInfo a2 = a(context, str);
            if (a2 != null) {
                return a2.applicationInfo.targetSdkVersion;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void A(Context context) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra("method", "com.baidu.android.pushservice.action.SEND_APPSTAT");
        com.baidu.android.pushservice.h.a(context.getApplicationContext()).a(intent);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0089 -> B:39:0x0022). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0096 -> B:39:0x0022). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00a3 -> B:39:0x0022). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00b1 -> B:39:0x0022). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00b6 -> B:39:0x0022). Please submit an issue!!! */
    public static String B(Context context) {
        String str;
        String str2 = "";
        String upperCase = Build.MANUFACTURER.toUpperCase();
        if (upperCase.contains("XIAOMI")) {
            str2 = "ro.build.version.incremental";
        } else if (upperCase.contains("HUAWEI")) {
            str2 = "ro.build.version.emui";
        } else if (upperCase.contains("MEIZU")) {
            return Build.DISPLAY;
        } else {
            if (upperCase.contains("OPPO")) {
                str2 = "ro.build.version.opporom";
            } else if (upperCase.contains("VIVO")) {
                str2 = "ro.vivo.os.version";
            }
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str = SystemProperties.get(str2);
            } else {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str2);
            }
        } catch (Throwable th) {
            str = (Build.VERSION.SDK_INT < 21 || !upperCase.contains("HUAWEI")) ? upperCase.contains("XIAOMI") ? "MIUI_notfound" : upperCase.contains("OPPO") ? "ColorOS_notfound" : upperCase.contains("VIVO") ? "FuntouchOS_notfound" : "" : "EmotionUI_notfound";
        }
        return str;
    }

    public static String B(Context context, String str) {
        String str2;
        ArrayList<com.baidu.android.pushservice.a.f> e;
        if (context == null) {
            return null;
        }
        try {
            String f = com.baidu.android.pushservice.c.c.f(context);
            if (TextUtils.isEmpty(f) && C(context)) {
                f = m.a(context, context.getPackageName() + ".push_sync", "r_v2");
            }
            if (!TextUtils.isEmpty(f) && (e = com.baidu.android.pushservice.a.b.e(com.baidu.android.pushservice.a.b.a(f))) != null) {
                Iterator<com.baidu.android.pushservice.a.f> it = e.iterator();
                while (it.hasNext()) {
                    com.baidu.android.pushservice.a.f next = it.next();
                    if (next.c().equals(str)) {
                        str2 = next.a();
                        break;
                    }
                }
            }
            str2 = null;
        } catch (Exception e2) {
            str2 = null;
        }
        return str2;
    }

    public static int C(Context context, String str) {
        ArrayList<com.baidu.android.pushservice.a.f> e;
        try {
            String e2 = com.baidu.android.pushservice.c.c.e(context);
            if (TextUtils.isEmpty(e2) && C(context)) {
                e2 = m.a(context, context.getPackageName() + ".push_sync", "r_v2");
            }
            if (!TextUtils.isEmpty(e2) && (e = com.baidu.android.pushservice.a.b.e(com.baidu.android.pushservice.a.b.a(e2))) != null) {
                Iterator<com.baidu.android.pushservice.a.f> it = e.iterator();
                while (it.hasNext()) {
                    com.baidu.android.pushservice.a.f next = it.next();
                    if (TextUtils.equals(next.c(), str)) {
                        return next.e();
                    }
                }
            }
            return 0;
        } catch (Exception e3) {
            return 0;
        }
    }

    public static boolean C(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            if (context.getPackageName().equals("com.baidu.searchbox")) {
                return false;
            }
            try {
                PackageInfo a2 = a(context, context.getPackageName());
                if (a2 != null) {
                    if (a2.applicationInfo.targetSdkVersion >= 24) {
                        return false;
                    }
                }
            } catch (Exception e) {
            }
        }
        return true;
    }

    public static boolean D(Context context) {
        return !C(context);
    }

    public static boolean D(Context context, String str) {
        Cursor cursor;
        ContentResolver contentResolver;
        boolean z = true;
        boolean z2 = false;
        Cursor cursor2 = null;
        if (c() || a() || b()) {
            try {
                try {
                    contentResolver = context.getContentResolver();
                } catch (Exception e) {
                    cursor = null;
                }
                if (contentResolver != null) {
                    cursor2 = contentResolver.query(Uri.parse("content://" + str + ".bdpush/pushinfo_v3"), new String[]{c.e.PushVersion.name(), c.e.PushPriority.name()}, null, null, null);
                    try {
                    } catch (Exception e2) {
                        cursor = cursor2;
                    }
                    if (cursor2 == null) {
                        cursor = contentResolver.query(Uri.parse("content://" + str + ".bdpush/pushinfo"), new String[]{c.e.PushVersion.name(), c.e.PushPriority.name()}, null, null, null);
                        if (cursor != null) {
                            try {
                            } catch (Exception e3) {
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                return z2;
                            } catch (Throwable th) {
                                cursor2 = cursor;
                                th = th;
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                throw th;
                            }
                            if (cursor.moveToFirst()) {
                                int i = cursor.getInt(cursor.getColumnIndex(c.e.PushVersion.name()));
                                int i2 = cursor.getInt(cursor.getColumnIndex(c.e.PushPriority.name()));
                                if (i <= 0 || i2 != 0) {
                                    z = false;
                                }
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e6) {
                                    }
                                }
                                z2 = z;
                            }
                        }
                        cursor2 = cursor;
                    } else if (cursor2.moveToFirst()) {
                        boolean z3 = cursor2.getInt(cursor2.getColumnIndex(c.e.PushVersion.name())) > 0 && cursor2.getInt(cursor2.getColumnIndex(c.e.PushPriority.name())) == 0;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e7) {
                            }
                        }
                        z2 = z3;
                    }
                }
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Exception e8) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z2;
    }

    public static boolean E(Context context) {
        PackageInfo a2;
        try {
            if (Build.VERSION.SDK_INT >= 26 && (a2 = a(context, context.getPackageName())) != null) {
                if (a2.applicationInfo.targetSdkVersion >= 26) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private static boolean F(Context context) {
        PackageManager packageManager;
        Intent intent = new Intent("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setPackage(context.getPackageName());
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            com.baidu.android.pushservice.f.a.b("Utility", "error  " + e.getMessage(), context);
        }
        if (packageManager == null) {
            return false;
        }
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
        if (queryBroadcastReceivers.size() < 1) {
            return false;
        }
        for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
            if ("com.meizu.cloud.pushsdk.SystemReceiver".equals(resolveInfo.activityInfo.name)) {
                return true;
            }
        }
        return false;
    }

    private static String G(Context context) {
        if (!a(context, "com.baidu.android.pushservice.action.notification.SHOW", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared com.baidu.android.pushservice.action.notification.SHOW");
            return "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared com.baidu.android.pushservice.action.notification.SHOW";
        } else if (!a(context, "android.net.conn.CONNECTIVITY_CHANGE", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared android.net.conn.CONNECTIVITY_CHANGE");
            return "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared android.net.conn.CONNECTIVITY_CHANGE";
        } else if (a(context, PushConstants.ACTION_METHOD, "com.baidu.android.pushservice.RegistrationReceiver", true)) {
            return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
        } else {
            Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.RegistrationReceiver is not exist or did not declared com.baidu.android.pushservice.action.METHOD");
            return "com.baidu.android.pushservice.RegistrationReceiver is not exist or did not declared com.baidu.android.pushservice.action.METHOD";
        }
    }

    private static String H(Context context) {
        if (I(context)) {
            Log.e("BDPushSDK-Utility", "xiaomi service is not found or wrong  declared, please check!");
            return "xiaomi service is not found or wrong  declared, please check!";
        } else if (K(context)) {
            Log.e("BDPushSDK-Utility", "oppo service is not found or wrong  declared, please check!");
            return "oppo service is not found or wrong  declared, please check!";
        } else if (J(context)) {
            Log.e("BDPushSDK-Utility", "meizu service is not found or wrong  declared, please check!");
            return "meizu service is not found or wrong  declared, please check!";
        } else if (!L(context)) {
            return a(context, "com.baidu.android.pushservice.action.PUSH_SERVICE", "com.baidu.android.pushservice.PushService", false) ? "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK" : "com.baidu.android.pushservice.PushService is not exist or did not declared com.baidu.android.pushservice.action.PUSH_SERVICE";
        } else {
            Log.e("BDPushSDK-Utility", "vivo service is not found or wrong  declared, please check!");
            return "vivo service is not found or wrong  declared, please check!";
        }
    }

    private static boolean I(Context context) {
        try {
            if (a() && PushSettings.h(context)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    boolean z = false;
                    boolean z2 = false;
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        if (serviceInfo.name.equals("com.xiaomi.mipush.sdk.PushMessageHandler")) {
                            z2 = true;
                        }
                        if (serviceInfo.name.equals("com.xiaomi.mipush.sdk.MessageHandleService")) {
                            z = true;
                        }
                    }
                    return (z && z2) ? false : true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private static boolean J(Context context) {
        try {
            if (b() && PushSettings.i(context)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    boolean z = false;
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        if (serviceInfo.name.equals("com.meizu.cloud.pushsdk.NotificationService")) {
                            z = true;
                        }
                    }
                    return !z;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private static boolean K(Context context) {
        try {
            if (d() && PushSettings.j(context)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    boolean z = false;
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        if (serviceInfo.name.equals("com.coloros.mcssdk.PushService")) {
                            z = true;
                        }
                    }
                    return !z;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private static boolean L(Context context) {
        try {
            if (e() && PushSettings.k(context)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    boolean z = false;
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        if (serviceInfo.name.equals("com.vivo.push.sdk.service.CommandClientService")) {
                            z = true;
                        }
                    }
                    return !z;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private static boolean M(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, "com.baidu.android.pushservice.PushInfoProvider");
            new ProviderInfo();
            ProviderInfo providerInfo = packageManager.getProviderInfo(componentName, 128);
            String str = providerInfo.name;
            String str2 = providerInfo.authority;
            com.baidu.android.pushservice.f.a.c("Utility", "provider name  = " + str + "  export  = " + providerInfo.exported + " provider authorities = " + str2, context.getApplicationContext());
            if (TextUtils.isEmpty(str)) {
                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider did not declared, please check ! ");
                return false;
            } else if (TextUtils.isEmpty(str2) || !str2.endsWith("bdpush")) {
                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider bdpush authority is required, please check !");
                return false;
            } else {
                if (!providerInfo.exported) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider exported declared wrong, please check ! ");
                }
                if (TextUtils.isEmpty(providerInfo.writePermission)) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider writePermission did not decleared, please check !");
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean N(Context context) {
        if (b == -1) {
            b = u(context, "android.permission.WRITE_EXTERNAL_STORAGE") ? 0 : 1;
        }
        return b == 0;
    }

    private static boolean O(Context context) {
        String str;
        try {
            str = Build.DISPLAY;
        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(str) || !str.contains("VIBEUI_V3.1_1614_5.294.1_ST_K50-T5")) {
            String str2 = Build.MODEL;
            if (!TextUtils.isEmpty(str2)) {
                if (str2.contains("Lenovo K50-t5") || str2.contains("Lenovo_K50-t5") || str2.contains("Lenovo X3c50")) {
                    return true;
                }
                if (str2.contains("Lenovo_X3c50")) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static int a(Context context, Intent intent, String str, String str2) {
        intent.setFlags(32);
        if (m(context, str2) < 50) {
            b(context, intent, str, str2);
            return 0;
        }
        if (!TextUtils.isEmpty(str)) {
            intent.setAction(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
            intent.setClassName(str2, "com.baidu.android.pushservice.CommandService");
        }
        intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.MESSAGE_DELIVER");
        return new d(context, intent).b().a();
    }

    public static int a(String str) {
        try {
            return (int) Long.parseLong(str);
        } catch (Exception e) {
            try {
                if (str.length() > 0) {
                    str = str.substring(1);
                }
                return (int) Long.parseLong(str);
            } catch (Exception e2) {
                return 0;
            }
        }
    }

    public static PackageInfo a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 0);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static com.baidu.android.pushservice.g.g a(com.baidu.android.pushservice.g.g gVar, Context context, String str) {
        PackageInfo a2 = a(context, str);
        if (a2 != null) {
            gVar.c(a2.applicationInfo.loadLabel(context.getPackageManager()).toString());
            gVar.e(a2.versionName);
            gVar.a(a2.versionCode);
            gVar.d(n(context, str));
            gVar.b(m(context, str));
        }
        return gVar;
    }

    public static String a(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager;
        if (context == null) {
            return null;
        }
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            applicationInfo = null;
        }
        if (packageManager != null) {
            applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return null;
            }
            return applicationInfo.metaData.getString(str2);
        }
        return null;
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
        Context applicationContext = context.getApplicationContext();
        Intent c2 = k.c(applicationContext);
        String packageName = applicationContext.getPackageName();
        String c3 = c(applicationContext, packageName, c2.getAction());
        if (!TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(c3)) {
            c2.setClassName(packageName, c3);
        }
        a(applicationContext, c2, j);
    }

    public static void a(Context context, Intent intent, long j) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 268435456);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        alarmManager.cancel(broadcast);
        alarmManager.set(3, SystemClock.elapsedRealtime() + j, broadcast);
    }

    public static void a(Context context, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("r_sync_type", i);
        intent.putExtra("r_sync_rdata_v2", str);
        intent.putExtra("r_sync_from", context.getPackageName());
        intent.setFlags(32);
        List<ResolveInfo> p = D(context) ? p(context) : o(context);
        if (p == null) {
            return;
        }
        for (ResolveInfo resolveInfo : p) {
            if (i(context, resolveInfo.activityInfo.packageName)) {
                b(context, intent, "com.baidu.android.pushservice.action.BIND_SYNC", resolveInfo.activityInfo.packageName);
            }
        }
    }

    public static void a(Context context, String str, String str2, PushCallback pushCallback) {
        if (context == null) {
            return;
        }
        try {
            PushManager.getInstance().register(context.getApplicationContext(), str, str2, pushCallback);
        } catch (Exception e) {
        }
    }

    public static void a(final Context context, final boolean z) {
        if (context == null) {
            return;
        }
        try {
            PushClient.getInstance(context).initialize();
            PushClient.getInstance(context).turnOnPush(new IPushActionListener() { // from class: com.baidu.android.pushservice.i.l.1
                @Override // com.vivo.push.IPushActionListener
                public void onStateChanged(int i) {
                    if (i == 101) {
                        if (z) {
                            com.baidu.android.pushservice.e.b(context, true);
                            return;
                        }
                        com.baidu.android.pushservice.a.b(context, true);
                        i.a(context, "vi_push_proxy_mode", 0);
                        com.baidu.android.pushservice.PushManager.enableVivoProxy(context, false);
                        com.baidu.android.pushservice.e.b(context, false);
                        l.a(context, true, true);
                    } else if (i != 0 && i != 1) {
                        com.baidu.android.pushservice.e.i(context);
                    } else {
                        i.a(context, "vi_push_proxy_mode", 1);
                        if (!z) {
                            if (com.baidu.android.pushservice.b.d.c(context)) {
                                l.a(context, true, true);
                            } else {
                                com.baidu.android.pushservice.a.b(context, false);
                                l.a(context, true, false);
                            }
                        }
                        String regId = PushClient.getInstance(context).getRegId();
                        if (TextUtils.isEmpty(regId)) {
                            com.baidu.android.pushservice.e.i(context);
                        } else {
                            com.baidu.android.pushservice.e.a(context, regId);
                        }
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, boolean z, boolean z2) {
        boolean z3 = false;
        com.baidu.android.pushservice.f.a.a("Utility", context.getPackageName() + ": updateServiceInfo isForce = " + z + ",isSend = " + z2, context.getApplicationContext());
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        int d = d(context, context.getPackageName());
        if (sharedPreferences.getInt("pr_app_v", 0) < d || z) {
            boolean c2 = c(context);
            if (com.baidu.android.pushservice.b.d.k(context) && !com.baidu.android.pushservice.b.d.c(context)) {
                z3 = true;
            }
            if (c2 || z3) {
                com.baidu.android.pushservice.c.c.a(context, 0L);
            } else {
                com.baidu.android.pushservice.c.c.a(context, f(context));
            }
            if (C(context)) {
                SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5).edit();
                if (c2 || z3) {
                    edit.putLong("priority2", 0L);
                } else {
                    edit.putLong("priority2", f(context));
                }
                edit.putInt("version2", com.baidu.android.pushservice.a.a());
                edit.commit();
            }
            com.baidu.android.pushservice.c.c.b(context, com.baidu.android.pushservice.a.a());
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.putInt("pr_app_v", d);
            edit2.commit();
        }
        if (z2) {
            k.d(context);
        }
    }

    public static void a(Intent intent, Context context) {
        try {
            String packageName = context.getPackageName();
            String c2 = c(context, context.getPackageName(), PushConstants.ACTION_MESSAGE);
            Class<?> cls = Class.forName(c2);
            Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            String[] strArr = {"android.content.Context", "android.content.Intent"};
            Method method = cls.getMethod("onReceive", Context.class, Intent.class);
            intent.setClassName(packageName, c2);
            method.invoke(newInstance, context, intent);
        } catch (Exception e) {
        }
    }

    public static boolean a() {
        return Build.MANUFACTURER.toUpperCase().contains("XIAOMI");
    }

    private static boolean a(int i, int i2, int i3, int i4) {
        int i5 = Calendar.getInstance(Locale.CHINA).get(11);
        int i6 = Calendar.getInstance(Locale.CHINA).get(12);
        if (i < i3) {
            if (i < i5 && i5 < i3) {
                return true;
            }
            if (i5 == i && i6 >= i2) {
                return true;
            }
            if (i5 == i3 && i6 <= i4) {
                return true;
            }
        } else if (i > i3) {
            if ((i5 > i && i5 < 24) || i5 < i3) {
                return true;
            }
            if (i5 == i && i6 >= i2) {
                return true;
            }
            if (i5 == i3 && i6 <= i4) {
                return true;
            }
        } else if (i == i5 && i6 >= i2 && i4 >= i6) {
            return true;
        }
        return false;
    }

    private static boolean a(Context context, PackageManager packageManager, String[] strArr) {
        if (a() && PushSettings.h(context)) {
            try {
                String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
                if (!a(str, strArr)) {
                    com.baidu.android.pushservice.f.a.b("Utility", "the permission [ " + str + " ] for xiaomi proxy need is not exist, please check!", context);
                    return true;
                }
                PermissionInfo[] permissionInfoArr = packageManager.getPackageInfo(context.getPackageName(), 4096).permissions;
                if (permissionInfoArr != null && permissionInfoArr.length > 0) {
                    boolean z = false;
                    for (PermissionInfo permissionInfo : permissionInfoArr) {
                        if (permissionInfo.name.equals(str)) {
                            if (permissionInfo.protectionLevel == 2) {
                                z = true;
                            } else {
                                Log.e("BDPushSDK-Utility", "xiaomi proxy permission is not signature,  please check!");
                            }
                        }
                    }
                    if (!z) {
                        return true;
                    }
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public static boolean a(Context context, PublicMsg publicMsg) {
        return com.baidu.android.pushservice.c.c.a(context, new com.baidu.android.pushservice.c.e(publicMsg.mMsgId, com.baidu.android.pushservice.j.d.a((publicMsg.mAppId + publicMsg.mMsgId + publicMsg.mUrl + publicMsg.mDescription + publicMsg.mTitle + publicMsg.mOpenType).getBytes(), true), publicMsg.mAppId));
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4, String str5) {
        boolean z;
        String c2 = PushSettings.c(context);
        if (!TextUtils.isEmpty(c2)) {
            str2 = c2;
        }
        if (str == null) {
            str = "";
        }
        String str6 = str2 + str + str3 + str4 + str5;
        if (TextUtils.isEmpty(str6)) {
            return false;
        }
        String a2 = com.baidu.android.pushservice.j.d.a(str6.getBytes(), true);
        if (TextUtils.isEmpty(a2)) {
            z = false;
        } else {
            String c3 = com.baidu.android.pushservice.c.c.c(context, context.getPackageName(), a2);
            if (TextUtils.isEmpty(c3)) {
                c3 = com.baidu.android.pushservice.c.c.c(context, com.baidu.android.pushservice.b.d.a(context).b() == 4 ? com.baidu.android.pushservice.b.d.a(context).c() : v(context), a2);
            }
            z = !TextUtils.isEmpty(c3) && c3.equals(a2);
        }
        return z;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00c8 -> B:6:0x0015). Please submit an issue!!! */
    private static boolean a(Context context, String str, String str2, boolean z) {
        PackageManager packageManager;
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            com.baidu.android.pushservice.f.a.b("Utility", "error  " + e.getMessage(), context);
        }
        if (packageManager == null) {
            return false;
        }
        if (z) {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
            if (queryBroadcastReceivers.size() < 1) {
                Log.e("BDPushSDK-Utility", str2 + " is not exist or did not declared " + str);
                return false;
            }
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (str2.equals(resolveInfo.activityInfo.name)) {
                    return true;
                }
            }
        } else {
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (queryIntentServices.size() < 1) {
                Log.e("BDPushSDK-Utility", str2 + " is not exist or did not declared " + str);
                return false;
            }
            for (ResolveInfo resolveInfo2 : queryIntentServices) {
                if (str2.equals(resolveInfo2.serviceInfo.name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(Context context, byte[] bArr, String str, String str2, byte[] bArr2) {
        String c2;
        com.baidu.android.pushservice.a.f d;
        if (bArr == null || str2 == null || bArr2 == null) {
            return false;
        }
        try {
            c2 = PushSettings.c(context);
            if (TextUtils.isEmpty(c2) && (d = com.baidu.android.pushservice.a.b.a(context).d(str)) != null) {
                c2 = d.a();
            }
        } catch (Exception e) {
        } catch (UnsatisfiedLinkError e2) {
            return true;
        }
        if (TextUtils.isEmpty(c2) || !c2.equals(str)) {
            com.baidu.android.pushservice.f.a.a("Utility", "walnutShellVerify error, appId not equal: " + str + "  stored: " + c2, context);
            return false;
        }
        byte[] decryptR = BaiduAppSSOJni.decryptR(bArr, 0);
        String a2 = com.baidu.android.pushservice.j.d.a(a(a(str.getBytes(), str2.getBytes()), bArr2), false);
        String str3 = new String(decryptR);
        if (a2 != null && a2.equals(str3)) {
            return true;
        }
        return false;
    }

    private static boolean a(Context context, String[] strArr) {
        if (d() && PushSettings.j(context)) {
            try {
                return !a("com.coloros.mcs.permission.RECIEVE_MCS_MESSAGE", strArr);
            } catch (Exception e) {
            }
        }
        return false;
    }

    public static boolean a(String str, Context context) {
        if (TextUtils.isEmpty(str) || str.contains(HanziToPinyin.Token.SEPARATOR)) {
            Log.e("BDPushSDK-Utility", "api_key is  incorrect, please check ! ");
            return false;
        }
        return true;
    }

    private static boolean a(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(byte[] bArr, String str, String str2, byte[] bArr2) {
        if (bArr == null || str == null || str2 == null || bArr2 == null) {
            return false;
        }
        try {
            if (TextUtils.equals(com.baidu.android.pushservice.j.d.a(a(a(str.getBytes(), str2.getBytes()), bArr2), false), new String(BaiduAppSSOJni.decryptR(bArr, 0)))) {
                return true;
            }
        } catch (Exception e) {
        } catch (UnsatisfiedLinkError e2) {
            return true;
        }
        return false;
    }

    public static byte[] a(Context context, String str, byte[] bArr, byte[] bArr2, String str2) {
        int m = m(context, str2);
        if (m <= 45 || m >= 50) {
            return bArr2;
        }
        try {
            return BaiduAppSSOJni.encryptR(com.baidu.android.pushservice.j.d.a(a(str.getBytes(), bArr), false).getBytes(), 0);
        } catch (Exception e) {
            return bArr2;
        } catch (UnsatisfiedLinkError e2) {
            return bArr2;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static int[] a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return new int[]{displayMetrics.heightPixels, displayMetrics.widthPixels};
    }

    public static int b(String str) {
        int indexOf;
        int i = 0;
        String str2 = str;
        do {
            try {
                indexOf = str2.indexOf("#Intent;");
                if (indexOf != -1) {
                    i += "#Intent;".length() + indexOf;
                    str2 = str2.substring("#Intent;".length() + indexOf);
                    continue;
                }
            } catch (Exception e) {
                return i;
            }
        } while (indexOf != -1);
        return i > 0 ? i - "#Intent;".length() : i;
    }

    public static String b(Context context) {
        PackageInfo a2 = a(context, context.getPackageName());
        return a2 != null ? a2.versionName : "";
    }

    public static void b(Context context, Intent intent, String str, String str2) {
        intent.setFlags(32);
        int m = m(context, str2);
        if (m >= 32) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    intent.setAction(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    intent.setPackage(str2);
                    intent.setClassName(str2, "com.baidu.android.pushservice.CommandService");
                }
                intent.putExtra("command_type", "reflect_receiver");
                if (context.startService(intent) != null) {
                    return;
                }
                b("sendRedirecctionIntent#intergratedPushVersion=" + m + ", packageName=" + str2 + ", intent=" + intent.toUri(0), context);
            } catch (Exception e) {
            }
        }
        if (E(context)) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            intent.setAction(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        String c2 = c(context, str2, str);
        if (!TextUtils.isEmpty(c2)) {
            intent.setClassName(str2, c2);
        }
        context.sendBroadcast(intent);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized void b(java.lang.String r15, android.content.Context r16) {
        /*
            java.lang.Class<com.baidu.android.pushservice.i.l> r2 = com.baidu.android.pushservice.i.l.class
            monitor-enter(r2)
            boolean r0 = N(r16)     // Catch: java.lang.Throwable -> Lf2
            if (r0 != 0) goto Lb
        L9:
            monitor-exit(r2)
            return
        Lb:
            boolean r0 = com.baidu.android.pushservice.a.a(r16)     // Catch: java.lang.Throwable -> Lf2
            if (r0 == 0) goto L9
            r0 = 0
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r3 = "yyyy-MM-dd HH:mm:ss"
            r1.<init>(r3)     // Catch: java.lang.Throwable -> Lf5
            java.util.Date r3 = new java.util.Date     // Catch: java.lang.Throwable -> Lf5
            r3.<init>()     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r1 = r1.format(r3)     // Catch: java.lang.Throwable -> Lf5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf5
            r3.<init>()     // Catch: java.lang.Throwable -> Lf5
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r3 = " "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Lf5
            java.lang.StringBuilder r1 = r1.append(r15)     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r3 = "\n\r"
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r3 = r1.toString()     // Catch: java.lang.Throwable -> Lf5
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r1 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> Lf5
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r5 = "baidu/pushservice/files"
            r4.<init>(r1, r5)     // Catch: java.lang.Throwable -> Lf5
            boolean r5 = r4.exists()     // Catch: java.lang.Throwable -> Lf5
            if (r5 != 0) goto L5b
            r4.mkdirs()     // Catch: java.lang.Throwable -> Lf5
        L5b:
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r6 = "yyyyMMdd"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> Lf5
            java.util.Date r6 = new java.util.Date     // Catch: java.lang.Throwable -> Lf5
            r6.<init>()     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r7 = r5.format(r6)     // Catch: java.lang.Throwable -> Lf5
            java.io.File r8 = new java.io.File     // Catch: java.lang.Throwable -> Lf5
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf5
            r9.<init>()     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r10 = "baidu/pushservice/files/msg"
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.lang.Throwable -> Lf5
            java.lang.StringBuilder r7 = r9.append(r7)     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r9 = ".log"
            java.lang.StringBuilder r7 = r7.append(r9)     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lf5
            r8.<init>(r1, r7)     // Catch: java.lang.Throwable -> Lf5
            boolean r1 = r8.exists()     // Catch: java.lang.Throwable -> Lf5
            if (r1 != 0) goto Ld8
            java.io.File[] r4 = r4.listFiles()     // Catch: java.lang.Throwable -> Lf5
            int r7 = r4.length     // Catch: java.lang.Throwable -> Lf5
            r1 = 0
        L98:
            if (r1 >= r7) goto Ld5
            r9 = r4[r1]     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r10 = r9.getName()     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r11 = "msg"
            boolean r11 = r10.startsWith(r11)     // Catch: java.lang.Throwable -> Lf5
            if (r11 == 0) goto Ld2
            int r11 = r10.length()     // Catch: java.lang.Throwable -> Lf5
            if (r11 <= 0) goto Ld2
            r11 = 3
            r12 = 11
            java.lang.String r10 = r10.substring(r11, r12)     // Catch: java.lang.Throwable -> Lf5
            java.util.Date r10 = r5.parse(r10)     // Catch: java.lang.Throwable -> Lf5
            long r10 = r10.getTime()     // Catch: java.lang.Throwable -> Lf5
            long r12 = r6.getTime()     // Catch: java.lang.Throwable -> Lf5
            long r10 = r10 - r12
            r12 = 86400000(0x5265c00, double:4.2687272E-316)
            long r10 = r10 / r12
            long r10 = java.lang.Math.abs(r10)     // Catch: java.lang.Throwable -> Lf5
            int r10 = (int) r10     // Catch: java.lang.Throwable -> Lf5
            r11 = 7
            if (r10 < r11) goto Ld2
            r9.delete()     // Catch: java.lang.Throwable -> Lf5
        Ld2:
            int r1 = r1 + 1
            goto L98
        Ld5:
            r8.createNewFile()     // Catch: java.lang.Throwable -> Lf5
        Ld8:
            boolean r1 = r8.exists()     // Catch: java.lang.Throwable -> Lf5
            if (r1 == 0) goto L114
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> Lf5
            r4 = 1
            r1.<init>(r8, r4)     // Catch: java.lang.Throwable -> Lf5
            r1.write(r3)     // Catch: java.lang.Throwable -> L111
        Le7:
            r0 = 1
            java.io.Closeable[] r0 = new java.io.Closeable[r0]     // Catch: java.lang.Throwable -> Lf2
            r3 = 0
            r0[r3] = r1     // Catch: java.lang.Throwable -> Lf2
            com.baidu.android.pushservice.e.b.a(r0)     // Catch: java.lang.Throwable -> Lf2
            goto L9
        Lf2:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        Lf5:
            r1 = move-exception
        Lf6:
            r1 = 1
            java.io.Closeable[] r1 = new java.io.Closeable[r1]     // Catch: java.lang.Throwable -> Lf2
            r3 = 0
            r1[r3] = r0     // Catch: java.lang.Throwable -> Lf2
            com.baidu.android.pushservice.e.b.a(r1)     // Catch: java.lang.Throwable -> Lf2
            goto L9
        L101:
            r1 = move-exception
            r14 = r1
            r1 = r0
            r0 = r14
        L105:
            r3 = 1
            java.io.Closeable[] r3 = new java.io.Closeable[r3]     // Catch: java.lang.Throwable -> Lf2
            r4 = 0
            r3[r4] = r1     // Catch: java.lang.Throwable -> Lf2
            com.baidu.android.pushservice.e.b.a(r3)     // Catch: java.lang.Throwable -> Lf2
            throw r0     // Catch: java.lang.Throwable -> Lf2
        L10f:
            r0 = move-exception
            goto L105
        L111:
            r0 = move-exception
            r0 = r1
            goto Lf6
        L114:
            r1 = r0
            goto Le7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.i.l.b(java.lang.String, android.content.Context):void");
    }

    public static boolean b() {
        return Build.MANUFACTURER.toUpperCase().contains("MEIZU");
    }

    public static boolean b(Context context, PublicMsg publicMsg) {
        if (publicMsg != null) {
            String a2 = com.baidu.android.pushservice.j.d.a((publicMsg.mAppId + publicMsg.mMsgId + publicMsg.mUrl + publicMsg.mDescription + publicMsg.mTitle + publicMsg.mOpenType).getBytes(), true);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            String b2 = com.baidu.android.pushservice.c.c.b(context, context.getPackageName(), publicMsg.mMsgId);
            if (TextUtils.isEmpty(b2)) {
                b2 = com.baidu.android.pushservice.c.c.b(context, com.baidu.android.pushservice.b.d.a(context).b() == 4 ? com.baidu.android.pushservice.b.d.a(context).c() : v(context), publicMsg.mMsgId);
            }
            return !TextUtils.isEmpty(b2) && b2.equals(a2);
        }
        return false;
    }

    public static boolean b(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            return (packageManager.getApplicationInfo(str, 0).flags & 1) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean b(Context context, String str, String str2) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
        }
        if (packageManager == null) {
            return false;
        }
        applicationInfo = packageManager.getApplicationInfo(str, 128);
        if (applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(str2)) {
            return false;
        }
        return applicationInfo.metaData.getBoolean(str2);
    }

    public static Bitmap c(String str) {
        Bitmap bitmap;
        Exception e;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            InputStream inputStream = httpURLConnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            try {
                inputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return bitmap;
            }
        } catch (Exception e3) {
            bitmap = null;
            e = e3;
        }
        return bitmap;
    }

    public static String c(Context context, String str, String str2) {
        List<ResolveInfo> list;
        PackageManager packageManager;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            list = null;
        }
        if (packageManager != null) {
            list = packageManager.queryBroadcastReceivers(intent, 576);
            if (list == null || list.size() <= 0) {
                return null;
            }
            return list.get(0).activityInfo.name;
        }
        return null;
    }

    public static void c(Context context, Intent intent, String str, String str2) {
        try {
            Uri data = intent.getData();
            if (data != null) {
                String f = f(data.toString());
                Intent intent2 = new Intent();
                String stringExtra = intent.getStringExtra("hwtitle");
                String stringExtra2 = intent.getStringExtra("hwcontent");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    intent2.putExtra("notification_title", stringExtra);
                    intent2.putExtra("notification_content", stringExtra2);
                }
                intent2.putExtra("extra_extra_custom_content", f);
                intent2.putExtra("proxy_mode", 5);
                intent2.putExtra("proxy_check_info", str);
                intent2.putExtra("proxy_sign_info", str2);
                b(context, intent2, "com.baidu.android.pushservice.action.notification.CLICK", context.getPackageName());
            }
        } catch (Exception e) {
        }
    }

    public static boolean c() {
        try {
            if (Build.MANUFACTURER.toUpperCase().contains("HUAWEI")) {
                if (!f()) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean c(Context context) {
        String c2 = com.baidu.android.pushservice.a.c(context);
        if ("enabled".equals(c2)) {
            return false;
        }
        if ("disabled".equals(c2)) {
            return true;
        }
        return b(context, context.getPackageName(), "DisableService");
    }

    public static boolean c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (Exception e) {
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

    private static int d(String str) {
        BufferedReader bufferedReader;
        Process process;
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader2;
        Process process2;
        InputStreamReader inputStreamReader2 = null;
        try {
            process = Runtime.getRuntime().exec("/system/bin/ping -w 1 " + str);
            try {
                inputStreamReader = new InputStreamReader(process.getInputStream());
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception e) {
                    process2 = process;
                    inputStreamReader2 = inputStreamReader;
                    bufferedReader2 = null;
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
            } catch (Exception e2) {
                bufferedReader2 = null;
                process2 = process;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                inputStreamReader = null;
            }
        } catch (Exception e3) {
            bufferedReader2 = null;
            process2 = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            process = null;
            inputStreamReader = null;
            th = th4;
        }
        try {
            new String();
            int i = 0;
            do {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                i++;
                if (readLine.contains("64 bytes from " + str)) {
                    com.baidu.android.pushservice.e.b.a(bufferedReader, inputStreamReader);
                    if (process != null) {
                        process.destroy();
                        return 0;
                    }
                    return 0;
                }
            } while (i <= 3);
            com.baidu.android.pushservice.e.b.a(bufferedReader, inputStreamReader);
            if (process != null) {
                process.destroy();
            }
            return -1;
        } catch (Exception e4) {
            inputStreamReader2 = inputStreamReader;
            bufferedReader2 = bufferedReader;
            process2 = process;
            com.baidu.android.pushservice.e.b.a(bufferedReader2, inputStreamReader2);
            if (process2 != null) {
                process2.destroy();
            }
            return 1;
        } catch (Throwable th5) {
            th = th5;
            com.baidu.android.pushservice.e.b.a(bufferedReader, inputStreamReader);
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    static String d(Context context) {
        String str;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    if (!a(context, packageManager, strArr)) {
                        if (!a(context, strArr)) {
                            String[] strArr2 = a;
                            int length = strArr2.length;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    str = "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
                                    break;
                                }
                                String str2 = strArr2[i];
                                if (!a(str2, strArr)) {
                                    str = str2 + " permission Push-SDK need is not exist !";
                                    Log.e("BDPushSDK-Utility", str);
                                    break;
                                }
                                i++;
                            }
                        } else {
                            str = "permission Push-SDK for oppo proxy need is not exist !";
                            Log.e("BDPushSDK-Utility", "permission Push-SDK for oppo proxy need is not exist !");
                        }
                    } else {
                        str = "permission Push-SDK for xiaomi proxy need is not exist !";
                        Log.e("BDPushSDK-Utility", "permission Push-SDK for xiaomi proxy need is not exist !");
                    }
                } else {
                    str = "Permissions Push-SDK need are not exist !";
                    Log.e("BDPushSDK-Utility", "Permissions Push-SDK need are not exist !");
                }
            } else {
                str = "pm is null";
            }
            return str;
        } catch (Exception e) {
            return "checkSDKPermissions exception " + e.getMessage();
        }
    }

    public static void d(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            MiPushClient.registerPush(context.getApplicationContext(), str, str2);
        } catch (Throwable th) {
        }
    }

    public static boolean d() {
        return Build.MANUFACTURER.toUpperCase().contains("OPPO");
    }

    private static String e(String str) {
        String str2 = "";
        try {
            if (str.startsWith("http://")) {
                str = str.replace("http://", "");
            }
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName == null || allByName.length <= 0) {
                return "";
            }
            int i = 0;
            while (i < allByName.length) {
                i++;
                str2 = str2 + ":" + allByName[i].getHostAddress();
            }
            return str2.length() > 1 ? str2.substring(1) : str2;
        } catch (Exception e) {
            return "";
        }
    }

    public static void e(Context context) {
        a(context, 300000L);
    }

    public static void e(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            com.meizu.cloud.pushsdk.PushManager.register(context.getApplicationContext(), str, str2);
        } catch (Exception e) {
        }
    }

    public static boolean e() {
        return Build.MANUFACTURER.toUpperCase().contains("VIVO");
    }

    public static boolean e(Context context, String str) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
        }
        if (packageManager == null) {
            return false;
        }
        applicationInfo = packageManager.getApplicationInfo(str, 128);
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return false;
        }
        return applicationInfo.metaData.getBoolean("IsBaiduApp");
    }

    public static long f(Context context) {
        long a2 = com.baidu.android.pushservice.a.a();
        if (context.getPackageName().equals("com.baidu.searchbox")) {
            return (a2 << 4) + 10;
        }
        long j = a2 << 2;
        if (e(context, context.getPackageName())) {
            j++;
        }
        long j2 = j << 1;
        if (b(context, context.getPackageName())) {
            j2++;
        }
        return (j2 << 1) + m(context);
    }

    private static String f(String str) {
        String str2 = null;
        try {
            if (!TextUtils.isEmpty(str) && str.contains("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=")) {
                if (str.contains("bdpush_hwsigninfo")) {
                    int b2 = b(str);
                    if (b2 > 0) {
                        str2 = str.substring("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=".length(), b2);
                    }
                } else {
                    str2 = str.substring("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=".length(), str.length());
                }
            }
        } catch (Exception e) {
        }
        return str2;
    }

    public static void f(Context context, String str) {
        if (i(context, str)) {
            Intent c2 = k.c(context);
            if (D(context)) {
                c2.putExtra("method", "pushservice_restart_v3");
                if (TextUtils.isEmpty(str) || !str.equals(u(context))) {
                    c2.putExtra("priority3", h(context));
                } else {
                    c2.putExtra("priority3", Long.MAX_VALUE);
                }
            } else {
                c2.putExtra("method", "pushservice_restart_v2");
                if (TextUtils.isEmpty(str) || !str.equals(u(context))) {
                    c2.putExtra("priority2", h(context));
                } else {
                    c2.putExtra("priority2", Long.MAX_VALUE);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                c2.setPackage(str);
                c2.setClassName(str, "com.baidu.android.pushservice.CommandService");
            }
            c2.putExtra("command_type", "reflect_receiver");
            try {
                if (context.startService(c2) != null) {
                    return;
                }
            } catch (Exception e) {
            }
            if (E(context)) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                c2.setPackage(str);
            }
            String c3 = c(context, str, PushConstants.ACTION_METHOD);
            if (!TextUtils.isEmpty(c3)) {
                c2.setClassName(str, c3);
            }
            context.sendBroadcast(c2);
            com.baidu.android.pushservice.a.a(context, false);
        }
    }

    public static boolean f() {
        try {
            String upperCase = Build.MODEL.toUpperCase();
            if (!TextUtils.isEmpty(upperCase)) {
                if (upperCase.contains("NEXUS")) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static long g(Context context, String str) {
        Context v;
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            long j = (!C(context) || (v = v(context, str)) == null || (sharedPreferences = v.getSharedPreferences(new StringBuilder().append(str).append(".push_sync").toString(), 5)) == null) ? -1L : sharedPreferences.getLong("priority2", 0L);
            if (j == -1) {
                try {
                    return com.baidu.android.pushservice.c.d.b(context, str);
                } catch (Exception e) {
                    return j;
                }
            }
            return j;
        } catch (Exception e2) {
            return -1L;
        }
    }

    public static void g(Context context) {
        a(context, false, false);
    }

    public static boolean g() {
        return Build.MANUFACTURER.toUpperCase().contains("SAMSUNG");
    }

    public static long h(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null) {
            return 0L;
        }
        try {
            long j = (!C(context) || (sharedPreferences = context.getSharedPreferences(new StringBuilder().append(context.getPackageName()).append(".push_sync").toString(), 5)) == null) ? -1L : sharedPreferences.getLong("priority2", 0L);
            if (j == -1) {
                try {
                    return com.baidu.android.pushservice.c.c.b(context);
                } catch (Exception e) {
                    return j;
                }
            }
            return j;
        } catch (Exception e2) {
            return -1L;
        }
    }

    public static boolean h() {
        return Build.MANUFACTURER.toUpperCase().contains("GIONEE");
    }

    public static boolean h(Context context, String str) {
        boolean z;
        boolean z2;
        int i;
        PackageManager packageManager;
        Intent intent = new Intent("com.baidu.android.pushservice.action.PUSH_SERVICE");
        intent.setPackage(str);
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            z = false;
        }
        if (packageManager == null) {
            return false;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            for (int i2 = 0; i2 < queryIntentServices.size(); i2++) {
                if ("com.baidu.android.pushservice.PushService".equals(queryIntentServices.get(i2).serviceInfo.name) && queryIntentServices.get(i2).serviceInfo.exported) {
                    z = queryIntentServices.get(i2).serviceInfo.enabled;
                    break;
                }
            }
        }
        z = false;
        try {
            z2 = z;
            i = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.baidu.android.pushservice.PushService"));
        } catch (Exception e2) {
            z2 = z;
            i = 2;
            return i != 1 || z2;
        }
        return i != 1 || z2;
    }

    public static boolean i() {
        return a() || c() || d() || e() || b();
    }

    static boolean i(Context context) {
        return j(context, context.getPackageName());
    }

    public static boolean i(Context context, String str) {
        PackageManager packageManager;
        List<ResolveInfo> list = null;
        Intent intent = new Intent("com.baidu.android.pushservice.action.PUSH_SERVICE");
        intent.setPackage(str);
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
        }
        if (packageManager == null) {
            return false;
        }
        list = packageManager.queryIntentServices(intent, 576);
        return list != null && list.size() > 0;
    }

    public static String j() {
        String str;
        String str2 = "";
        if (i()) {
            String str3 = "";
            String upperCase = Build.MANUFACTURER.toUpperCase();
            if (upperCase.contains("XIAOMI")) {
                str3 = "ro.miui.ui.version.code";
            } else if (upperCase.contains("HUAWEI")) {
                str3 = "ro.build.version.emui";
            } else if (upperCase.contains("MEIZU")) {
                str3 = "ro.build.display.id";
            } else if (upperCase.contains("OPPO")) {
                str3 = "ro.build.version.opporom";
            } else if (upperCase.contains("VIVO")) {
                str3 = "ro.vivo.os.version";
            }
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    str2 = SystemProperties.get(str3);
                } else {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str3);
                }
                if (upperCase.contains("HUAWEI") && !TextUtils.isEmpty(str2)) {
                    String substring = str2.substring(str2.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, str2.length());
                    return (substring.matches("\\d+\\.\\d+$") || Build.VERSION.SDK_INT < 21) ? substring : "3.1";
                } else if (upperCase.contains("MEIZU")) {
                    str = TextUtils.isEmpty(str2) ? Build.DISPLAY : str2;
                    try {
                        Matcher matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(str);
                        return matcher.find() ? matcher.group() : str;
                    } catch (Throwable th) {
                        return (Build.VERSION.SDK_INT < 21 || !upperCase.contains("HUAWEI")) ? upperCase.contains("HUAWEI") ? "1.0" : upperCase.contains("XIAOMI") ? "4.0" : upperCase.contains("MEIZU") ? "6.0" : upperCase.contains("OPPO") ? "3.0" : upperCase.contains("VIVO") ? "3.2" : str : "3.1";
                    }
                } else if (upperCase.contains("OPPO") && !TextUtils.isEmpty(str2)) {
                    Matcher matcher2 = Pattern.compile("^V(\\d+\\.\\d+)").matcher(str2);
                    if (matcher2.find()) {
                        return matcher2.group(1);
                    }
                } else if (upperCase.contains("VIVO") && !TextUtils.isEmpty(str2)) {
                    Matcher matcher3 = Pattern.compile("^\\d+(\\.\\d+)?").matcher(str2);
                    if (matcher3.find()) {
                        return matcher3.group();
                    }
                }
            } catch (Throwable th2) {
                str = "";
            }
        }
        return str2;
    }

    static boolean j(Context context) {
        return k(context, context.getPackageName());
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x02ea */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:85:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static boolean j(Context context, String str) {
        boolean z;
        boolean e = false;
        e = 0;
        e = 0;
        e = 0;
        e = 0;
        e = 0;
        e = 0;
        e = 0;
        e = 0;
        e = 0;
        e = 0;
        e = 0;
        e = 0;
        e = 0;
        e = 0;
        e = 0;
        e = 0;
        try {
            Intent intent = new Intent("com.baidu.android.pushservice.action.notification.CLICK");
            intent.setPackage(context.getPackageName());
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                z = false;
            } else {
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
                if (queryBroadcastReceivers.size() < 1) {
                    z = false;
                } else {
                    String str2 = queryBroadcastReceivers.get(0).activityInfo.name;
                    boolean z2 = queryBroadcastReceivers.get(0).activityInfo.enabled;
                    if (a(context, PushConstants.ACTION_MESSAGE, str2, true) && a(context, PushConstants.ACTION_RECEIVE, str2, true)) {
                        if (c() && PushSettings.l(context)) {
                            if (!a(context, "com.huawei.intent.action.PUSH", str2, true)) {
                                Log.e("BDPushSDK-Utility", str2 + " did not declared com.huawei.intent.action.PUSH");
                                z = false;
                            } else if (!a(context, "com.huawei.android.push.intent.RECEIVE", str2, true)) {
                                Log.e("BDPushSDK-Utility", str2 + " did not declared com.huawei.android.push.intent.RECEIVE");
                                z = false;
                            } else if (!a(context, "com.huawei.android.push.intent.REGISTRATION", str2, true)) {
                                Log.e("BDPushSDK-Utility", str2 + " did not declared com.huawei.android.push.intent.REGISTRATION");
                                z = false;
                            }
                        } else if (a() && PushSettings.h(context)) {
                            if (!a(context, "com.xiaomi.mipush.RECEIVE_MESSAGE", "com.baidu.android.pushservice.PushPatchMessageReceiver", true)) {
                                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushPatchMessageReceiver did not declared com.xiaomi.mipush.RECEIVE_MESSAGE");
                                z = false;
                            } else if (!a(context, "com.xiaomi.mipush.MESSAGE_ARRIVED", "com.baidu.android.pushservice.PushPatchMessageReceiver", true)) {
                                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushPatchMessageReceiver did not declared com.xiaomi.mipush.MESSAGE_ARRIVED");
                                z = false;
                            } else if (!a(context, "com.xiaomi.mipush.ERROR", "com.baidu.android.pushservice.PushPatchMessageReceiver", true)) {
                                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushPatchMessageReceiver did not declared com.xiaomi.mipush.ERROR");
                                z = false;
                            }
                        } else if (b() && PushSettings.i(context)) {
                            if (!a(context, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true)) {
                                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.MzPushPatchMessageReceiver did not declared " + com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
                                z = false;
                            } else if (!a(context, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_REGISTER_ACTION, "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true)) {
                                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.MzPushPatchMessageReceiver did not declared " + com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_REGISTER_ACTION);
                                z = false;
                            } else if (!a(context, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_UNREGISTER_ACTION, "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true)) {
                                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.MzPushPatchMessageReceiver did not declared " + com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_UNREGISTER_ACTION);
                                z = false;
                            } else if (!F(context)) {
                                Log.e("BDPushSDK-Utility", "com.meizu.cloud.pushsdk.SystemReceiver did not declared com.meizu.cloud.pushservice.action.PUSH_SERVICE_START");
                                z = false;
                            }
                        } else if (d() && PushSettings.j(context)) {
                            if (!a(context, "com.coloros.mcs.action.RECEIVE_MCS_MESSAGE", "com.coloros.mcssdk.PushService", false)) {
                                Log.e("BDPushSDK-Utility", "com.coloros.mcssdk.PushService did not declared com.coloros.mcs.action.RECEIVE_MCS_MESSAGE");
                                z = false;
                            }
                        } else if (e() && PushSettings.k(context) && !a(context, "com.vivo.pushclient.action.RECEIVE", "com.baidu.android.pushservice.viproxy.ViPushMessageReceiver", true)) {
                            Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.viproxy.ViPushMessageReceiver did not declared com.vivo.pushclient.action.RECEIVE");
                            z = false;
                        }
                        int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(context.getPackageName(), str2));
                        z = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z2);
                        if (!z) {
                            try {
                                e = "BDPushSDK-Utility";
                                Log.e("BDPushSDK-Utility", str2 + " is disable, please check!");
                            } catch (Exception e2) {
                                e = e2;
                            }
                        }
                    } else {
                        Log.e("BDPushSDK-Utility", str2 + " did not declared " + PushConstants.ACTION_MESSAGE + " or " + PushConstants.ACTION_RECEIVE);
                        z = false;
                    }
                }
            }
            return z;
        } catch (Exception e3) {
            return e;
        }
    }

    public static String k(Context context) {
        String d = d(context);
        if (TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", d)) {
            String G = G(context);
            if (TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", G)) {
                String H = H(context);
                return (TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", H) || O(context)) ? "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK" : H;
            }
            return G;
        }
        return d;
    }

    public static boolean k(Context context, String str) {
        boolean z = true;
        try {
            if (!C(context) || context.getSharedPreferences(context.getPackageName() + ".push_sync", 5).getInt("version2", 0) >= 29) {
                ComponentName componentName = new ComponentName(context, "com.baidu.android.pushservice.CommandService");
                PackageManager packageManager = context.getPackageManager();
                new ServiceInfo();
                ServiceInfo serviceInfo = packageManager.getServiceInfo(componentName, 128);
                if (TextUtils.isEmpty(serviceInfo.name)) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.CommandService did not declared ");
                    z = false;
                } else if (!serviceInfo.exported) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.CommandService  exported declared wrong");
                }
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static String l(Context context, String str) {
        if (!PushSocket.a(context)) {
            Log.e("BDPushSDK-Utility", "check socket library failed");
            return "check socket library failed";
        }
        String k = k(context);
        if (!TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", k)) {
            Log.e("BDPushSDK-Utility", k);
            return k;
        } else if (!a(str, context)) {
            Log.e("BDPushSDK-Utility", "check Apikey failed");
            return "check Apikey failed";
        } else {
            if (!i(context)) {
                Log.e("BDPushSDK-Utility", "check SelfConfiged Receiver failed");
            }
            if (e()) {
                return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
            }
            if (!j(context) && !O(context)) {
                Log.e("BDPushSDK-Utility", "check CommandService Enable failed");
                return "check CommandService Enable failed";
            } else if (M(context)) {
                return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
            } else {
                Log.e("BDPushSDK-Utility", "check CommandService Enable failed");
                return "check CommandService Enable failed";
            }
        }
    }

    public static boolean l(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
            if (packageInfo.services != null) {
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                boolean z = false;
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    if (serviceInfo.name.equals("com.baidu.android.pushservice.job.PushJobService")) {
                        z = true;
                    }
                }
                return !z;
            }
        } catch (Exception e) {
        }
        return false;
    }

    static int m(Context context) {
        int i = a(context, "android.intent.action.USER_PRESENT", "com.baidu.android.pushservice.PushServiceReceiver", true) ? 1 : 0;
        if (a(context, "android.intent.action.MEDIA_MOUNTED", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            i++;
        }
        if (a(context, "android.intent.action.ACTION_POWER_CONNECTED", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            i++;
        }
        return a(context, "android.intent.action.ACTION_POWER_DISCONNECTED", "com.baidu.android.pushservice.PushServiceReceiver", true) ? i + 1 : i;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x005b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x000b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m(Context context, String str) {
        int i;
        SharedPreferences sharedPreferences;
        int e = -1;
        e = -1;
        e = -1;
        e = -1;
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (str.equals(context.getPackageName())) {
                i = com.baidu.android.pushservice.a.a();
            } else {
                if (C(context)) {
                    try {
                        Context v = v(context, str);
                        sharedPreferences = v != null ? v.getSharedPreferences(str + ".push_sync", 5) : null;
                    } catch (Exception e2) {
                        i = -1;
                    }
                    if (sharedPreferences != null) {
                        i = sharedPreferences.getInt("version2", 0);
                        if (i == -1) {
                            try {
                                i = com.baidu.android.pushservice.c.d.c(context, str);
                            } catch (Exception e3) {
                                e = e3;
                            }
                        }
                        if (i == 0) {
                            i = 50;
                        }
                    }
                }
                i = -1;
                if (i == -1) {
                }
                if (i == 0) {
                }
            }
            return i;
        } catch (Exception e4) {
            return e;
        }
    }

    public static String n(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : a(context, str, "BaiduPush_CHANNEL");
    }

    public static List<String> n(Context context) {
        PackageManager packageManager;
        List<ResolveInfo> arrayList = new ArrayList<>();
        Intent intent = new Intent("com.baidu.android.pushservice.action.BIND_SYNC");
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
        }
        if (packageManager == null) {
            return null;
        }
        arrayList = packageManager.queryBroadcastReceivers(intent, 576);
        ArrayList arrayList2 = new ArrayList();
        for (ResolveInfo resolveInfo : arrayList) {
            arrayList2.add(resolveInfo.activityInfo.packageName);
        }
        return arrayList2;
    }

    public static List<ResolveInfo> o(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return arrayList;
            }
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(new Intent("com.baidu.android.pushservice.action.BIND_SYNC"), 576);
            try {
                ArrayList arrayList2 = new ArrayList();
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (z(context, resolveInfo.activityInfo.packageName)) {
                        arrayList2.add(resolveInfo);
                    }
                }
                queryBroadcastReceivers.removeAll(arrayList2);
                return queryBroadcastReceivers;
            } catch (Exception e) {
                return queryBroadcastReceivers;
            }
        } catch (Exception e2) {
            return arrayList;
        }
    }

    public static boolean o(Context context, String str) {
        return a(context, str) != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0025 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String p(Context context, String str) {
        SharedPreferences sharedPreferences;
        long j;
        Iterator<ResolveInfo> it;
        SharedPreferences sharedPreferences2;
        int b2 = com.baidu.android.pushservice.b.d.a(context).b();
        if (b2 == 3 || b2 == 4 || b2 == 2) {
            String c2 = com.baidu.android.pushservice.b.d.a(context).c();
            if (!TextUtils.isEmpty(c2)) {
                return c2;
            }
        }
        List<ResolveInfo> p = D(context) ? p(context.getApplicationContext()) : o(context.getApplicationContext());
        if (p == null || p.size() <= 1) {
            return context.getPackageName();
        }
        if (C(context)) {
            try {
                sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5);
            } catch (Exception e) {
                sharedPreferences = null;
            }
            if (sharedPreferences != null) {
                j = sharedPreferences.getLong("priority2", 0L);
                if (j == -1) {
                    j = com.baidu.android.pushservice.c.c.b(context);
                }
                String u = u(context);
                it = p.iterator();
                while (true) {
                    long j2 = j;
                    if (it.hasNext()) {
                        return str;
                    }
                    String str2 = it.next().activityInfo.packageName;
                    Context v = v(context, str2);
                    if (C(context)) {
                        if (v != null) {
                            try {
                                sharedPreferences2 = v.getSharedPreferences(str2 + ".push_sync", 5);
                            } catch (Exception e2) {
                                sharedPreferences2 = null;
                            }
                        } else {
                            sharedPreferences2 = null;
                        }
                        if (sharedPreferences2 != null) {
                            j = sharedPreferences2.getLong("priority2", 0L);
                            if (j == -1) {
                                j = str2.equals(context.getPackageName()) ? com.baidu.android.pushservice.c.c.b(context) : com.baidu.android.pushservice.c.d.b(context, str2);
                            }
                            if (j <= j2) {
                                if (h(v, str2)) {
                                    str = str2;
                                }
                                j = j2;
                            } else {
                                if (j == j2 && ((str2.equals(u) && h(v, str2)) || (str2.equals(context.getPackageName()) && !C(context)))) {
                                    str = str2;
                                }
                                j = j2;
                            }
                        }
                    }
                    j = -1;
                    if (j == -1) {
                    }
                    if (j <= j2) {
                    }
                }
            }
        }
        j = -1;
        if (j == -1) {
        }
        String u2 = u(context);
        it = p.iterator();
        while (true) {
            long j22 = j;
            if (it.hasNext()) {
            }
        }
    }

    public static List<ResolveInfo> p(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return arrayList;
            }
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(new Intent("com.baidu.android.pushservice.action.BIND_SYNC"), 576);
            try {
                ArrayList arrayList2 = new ArrayList();
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (!z(context, resolveInfo.activityInfo.packageName)) {
                        arrayList2.add(resolveInfo);
                    }
                }
                queryBroadcastReceivers.removeAll(arrayList2);
                return queryBroadcastReceivers;
            } catch (Exception e) {
                return queryBroadcastReceivers;
            }
        } catch (Exception e2) {
            return arrayList;
        }
    }

    public static String q(Context context) {
        String deviceID = DeviceId.getDeviceID(context);
        boolean d = com.baidu.android.pushservice.a.d(context);
        if (D(context)) {
            return com.baidu.android.pushservice.j.d.a((d ? "com.baidu.pushservice.single_conn" + context.getPackageName() : "com.baidu.pushservice.singelinstancev3" + deviceID).getBytes(), false);
        }
        return com.baidu.android.pushservice.j.d.a((d ? "com.baidu.pushservice.single_conn" + context.getPackageName() : "com.baidu.pushservice.singelinstancev2" + deviceID).getBytes(), false);
    }

    public static boolean q(Context context, String str) {
        int[] b2;
        if (context == null || TextUtils.isEmpty(str) || (b2 = com.baidu.android.pushservice.c.a.b(context, str)) == null || 4 != b2.length) {
            return false;
        }
        return a(b2[0], b2[1], b2[2], b2[3]);
    }

    public static String r(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return com.baidu.android.pushservice.j.d.a(packageManager.getPackageInfo(str, 64).signatures[0].toByteArray(), false);
        } catch (Exception e) {
            return null;
        }
    }

    public static ArrayList<String> r(Context context) {
        List<ResolveInfo> p = D(context) ? p(context.getApplicationContext()) : o(context.getApplicationContext());
        ArrayList<String> arrayList = new ArrayList<>();
        for (ResolveInfo resolveInfo : p) {
            if (!arrayList.contains(resolveInfo.activityInfo.packageName)) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        return arrayList;
    }

    public static List<String> s(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        ArrayList arrayList = new ArrayList();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(com.meizu.cloud.pushsdk.constants.PushConstants.INTENT_ACTIVITY_NAME);
            if (activityManager != null && (runningServices = activityManager.getRunningServices(100)) != null && !runningServices.isEmpty()) {
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    if (runningServiceInfo.service.getClassName().contains("com.baidu.android.pushservice.PushService")) {
                        arrayList.add(runningServiceInfo.service.getPackageName());
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    public static boolean s(Context context, String str) {
        String a2 = i.a(context, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED");
        return !TextUtils.isEmpty(a2) && a2.contains(str);
    }

    public static int t(Context context) {
        NetworkInfo c2;
        String str = "";
        if (context != null && (c2 = g.c(context)) != null && c2.isConnectedOrConnecting()) {
            if (!c2.getTypeName().toLowerCase().equals("wifi")) {
                str = "2G";
                switch (c2.getSubtype()) {
                    case 3:
                        str = "3G";
                        break;
                    case 5:
                        str = "3G";
                        break;
                    case 6:
                        str = "3G";
                        break;
                    case 7:
                        str = "3G";
                        break;
                    case 8:
                        str = "3G";
                        break;
                    case 9:
                        str = "3G";
                        break;
                    case 10:
                        str = "3G";
                        break;
                    case 12:
                        str = "3G";
                        break;
                    case 13:
                        str = "4G";
                        break;
                    case 14:
                        str = "3G";
                        break;
                    case 15:
                        str = "3G";
                        break;
                }
            } else {
                str = "WF";
            }
        }
        if (str.equals("WF")) {
            return 1;
        }
        if (str.equals("2G")) {
            return 2;
        }
        if (str.equals("3G")) {
            return 3;
        }
        return str.equals("4G") ? 4 : 0;
    }

    public static boolean t(Context context, String str) {
        String a2 = i.a(context, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED");
        if (!TextUtils.isEmpty(a2)) {
            if (a2.contains(str)) {
                return true;
            }
            if (a2.length() > 1000) {
                a2 = a2.substring(500);
            }
            str = a2 + ":" + str;
        }
        i.a(context, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED", str);
        return false;
    }

    public static String u(Context context) {
        if (D(context)) {
            List<String> s = s(context);
            List<ResolveInfo> p = p(context);
            if (!s.isEmpty()) {
                for (ResolveInfo resolveInfo : p) {
                    String str = resolveInfo.activityInfo.packageName;
                    if (s.contains(str) && o(context, str) && h(context, str)) {
                        return str;
                    }
                }
            }
        } else {
            String a2 = a.a(context, "com.baidu.push.cur_pkg");
            List<String> s2 = s(context);
            if (TextUtils.isEmpty(a2) || !s2.contains(a2)) {
                if (!s2.isEmpty()) {
                    for (String str2 : s2) {
                        if (!z(context, str2) && o(context, str2) && h(context, str2)) {
                            return str2;
                        }
                    }
                }
            } else if (o(context, a2) && h(context, a2)) {
                return a2;
            }
        }
        return null;
    }

    public static boolean u(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static Context v(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return context.createPackageContext(str, 4);
        } catch (Exception e) {
            com.baidu.android.pushservice.g.m.a(context.getApplicationContext(), e);
            return null;
        }
    }

    public static String v(Context context) {
        return p(context, context.getPackageName());
    }

    public static String w(Context context) {
        int i = 1;
        int i2 = g.a(context) ? 0 : 1;
        NetworkInfo c2 = g.c(context);
        if (c2 != null && c2.isAvailable()) {
            i = 0;
        }
        int d = d("220.181.112.244");
        int d2 = d("202.108.23.105");
        int d3 = d("202.108.23.109");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("frontia_avail", i2);
            jSONObject.put("network_avail", i);
            jSONObject.put("baidu_avail", d);
            jSONObject.put("sa_avail", d2);
            jSONObject.put("logic_avail", d3);
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    public static String w(Context context, String str) {
        try {
            PackageInfo a2 = a(context, str);
            return (a2 == null || a2.firstInstallTime <= 0) ? "" : String.valueOf(a2.firstInstallTime);
        } catch (Throwable th) {
            return "";
        }
    }

    public static String x(Context context) {
        String e = e("www.baidu.com");
        String e2 = e("sa.tuisong.baidu.com");
        String e3 = e("api.tuisong.baidu.com");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("baidu_ip", e);
            jSONObject.put("sa_ip", e2);
            jSONObject.put("logic_ip", e3);
        } catch (Exception e4) {
        }
        return jSONObject.toString();
    }

    public static boolean x(Context context, String str) {
        boolean z = false;
        ArrayList arrayList = (ArrayList) com.baidu.android.pushservice.a.b.a(context).a.clone();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (str.equals(((com.baidu.android.pushservice.a.f) it.next()).c())) {
                    z = true;
                    break;
                }
            }
        }
        if (!z) {
            String e = com.baidu.android.pushservice.c.c.e(context);
            if (TextUtils.isEmpty(e) && C(context)) {
                e = m.a(context, context.getPackageName() + ".push_sync", "r_v2");
            }
            String a2 = com.baidu.android.pushservice.a.b.a(e);
            if (!TextUtils.isEmpty(a2) && a2.contains(str)) {
                String replace = a2.replace(HanziToPinyin.Token.SEPARATOR, "");
                if (replace.charAt(replace.indexOf(str) + str.length()) == ',') {
                    return true;
                }
            }
        }
        return z;
    }

    public static boolean y(Context context) {
        try {
            return context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).getBoolean("bind_status", false);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean y(Context context, String str) {
        boolean z;
        boolean z2;
        boolean z3;
        try {
        } catch (Exception e) {
            z = false;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        z = com.baidu.android.pushservice.c.a.a(context, str);
        try {
            z2 = z;
            z3 = t(context, str);
        } catch (Exception e2) {
            z2 = z;
            z3 = false;
            return z2 ? false : false;
        }
        if (z2 && z3) {
            return true;
        }
    }

    public static void z(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("com.huawei.android.push.intent.REGISTER");
        intent.putExtra(PushConstants.PACKAGE_NAME, applicationContext.getPackageName());
        intent.setFlags(32);
        applicationContext.sendBroadcast(intent);
        j.a(applicationContext, "hasRequestToken", true);
    }

    public static boolean z(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                if (A(context, str) >= 24) {
                    if ((str.equals(context.getPackageName()) ? com.baidu.android.pushservice.a.a() : m(context, str)) >= 55) {
                        return true;
                    }
                }
            } catch (Exception e) {
            }
        }
        return false;
    }
}
