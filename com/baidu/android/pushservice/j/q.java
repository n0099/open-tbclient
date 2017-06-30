package com.baidu.android.pushservice.j;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
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
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class q {
    private static final String[] a = {"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE"};
    private static int b = -1;
    private static boolean c = false;

    public static int A(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.applicationInfo.targetSdkVersion;
            }
            return 0;
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
            return 0;
        }
    }

    public static void A(Context context) {
        com.baidu.android.pushservice.message.a.d.a(context);
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.SEND_LBS");
        com.baidu.android.pushservice.i.a(context.getApplicationContext()).a(intent);
    }

    public static String B(Context context) {
        String str = "";
        String upperCase = Build.MANUFACTURER.toUpperCase();
        if (upperCase.contains("XIAOMI")) {
            str = "ro.build.version.incremental";
        } else if (upperCase.contains("HUAWEI")) {
            str = "ro.build.version.emui";
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
            return "";
        }
    }

    public static boolean B(Context context, String str) {
        try {
            String a2 = n.a(context, "huawei_msg_md5");
            if (a2 == null || a2.equals(str)) {
                return false;
            }
            n.a(context, "huawei_msg_md5", str);
            return true;
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
            return false;
        }
    }

    public static String C(Context context) {
        String str;
        Exception e;
        String str2 = "";
        if (c()) {
            String str3 = "";
            String upperCase = Build.MANUFACTURER.toUpperCase();
            if (upperCase.contains("XIAOMI")) {
                str3 = "ro.miui.ui.version.code";
            } else if (upperCase.contains("HUAWEI")) {
                str3 = "ro.build.version.emui";
            }
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str3);
            } catch (Exception e2) {
                str = "";
                e = e2;
            }
            try {
                if (!upperCase.contains("HUAWEI") || TextUtils.isEmpty(str)) {
                    return str;
                }
                str2 = str.substring(str.indexOf("_") + 1, str.length());
                if (!str2.matches("\\d+\\.\\d+$")) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        return "3.1";
                    }
                }
            } catch (Exception e3) {
                e = e3;
                if (upperCase.contains("HUAWEI")) {
                    str = "3.1";
                } else if (upperCase.contains("XIAOMI")) {
                    str = "4.0";
                }
                com.baidu.android.pushservice.g.a.a("Utility", e);
                return str;
            }
        }
        return str2;
    }

    public static String C(Context context, String str) {
        String str2;
        if (context == null) {
            return null;
        }
        try {
            String h = com.baidu.android.pushservice.d.c.h(context);
            if (TextUtils.isEmpty(h) && D(context)) {
                h = r.a(context, context.getPackageName() + ".push_sync", "r_v2");
            }
            if (!TextUtils.isEmpty(h)) {
                String a2 = com.baidu.android.pushservice.b.b.a(h);
                com.baidu.android.pushservice.g.a.b("Utility", "ClientManager init strAppsV2 : " + a2);
                ArrayList<com.baidu.android.pushservice.b.f> e = com.baidu.android.pushservice.b.b.e(a2);
                if (e != null) {
                    Iterator<com.baidu.android.pushservice.b.f> it = e.iterator();
                    while (it.hasNext()) {
                        com.baidu.android.pushservice.b.f next = it.next();
                        if (next.c().equals(str)) {
                            str2 = next.a();
                            break;
                        }
                    }
                }
            } else {
                com.baidu.android.pushservice.g.a.d("Utility", "ClientManager init strAppsV2 empty.");
            }
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.a("Utility", e2);
        }
        str2 = null;
        return str2;
    }

    public static int D(Context context, String str) {
        int i;
        ArrayList<com.baidu.android.pushservice.b.f> e;
        try {
            String g = com.baidu.android.pushservice.d.c.g(context);
            if (TextUtils.isEmpty(g) && D(context)) {
                g = r.a(context, context.getPackageName() + ".push_sync", "r_v2");
            }
            if (!TextUtils.isEmpty(g) && (e = com.baidu.android.pushservice.b.b.e(com.baidu.android.pushservice.b.b.a(g))) != null) {
                Iterator<com.baidu.android.pushservice.b.f> it = e.iterator();
                while (it.hasNext()) {
                    com.baidu.android.pushservice.b.f next = it.next();
                    if (TextUtils.equals(next.c(), str)) {
                        i = next.e();
                        break;
                    }
                }
            }
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.a("Utility", e2);
        }
        i = 0;
        com.baidu.android.pushservice.g.a.c("Utility", str + " SDK Version Code = " + i);
        return i;
    }

    public static boolean D(Context context) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if ((packageInfo != null ? packageInfo.applicationInfo.targetSdkVersion : 0) >= 24) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return false;
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
        }
        return true;
    }

    private static int E(Context context, String str) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context.getPackageName(), str));
    }

    public static boolean E(Context context) {
        return !D(context);
    }

    public static boolean F(Context context) {
        return com.baidu.android.pushservice.c.d.a(context).b() == com.baidu.android.pushservice.c.d.g && Build.MANUFACTURER.equalsIgnoreCase("koobee");
    }

    private static boolean G(Context context) {
        if (!a(context, "com.baidu.android.pushservice.action.notification.SHOW", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushServiceReceiver did not declared com.baidu.android.pushservice.action.notification.SHOW");
            return false;
        } else if (!a(context, "android.net.conn.CONNECTIVITY_CHANGE", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushServiceReceiver did not declared android.net.conn.CONNECTIVITY_CHANGE");
            return false;
        } else if (a(context, PushConstants.ACTION_METHOD, "com.baidu.android.pushservice.RegistrationReceiver", true)) {
            return true;
        } else {
            Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushServiceReceiver did not declared com.baidu.android.pushservice.action.notification.SHOW");
            return false;
        }
    }

    private static boolean H(Context context) {
        if (I(context)) {
            com.baidu.android.pushservice.g.a.e("Utility", "xiaomi service is not found!!!");
            Log.e("BDPushSDK-Utility", "xiaomi service is not found or wrong  declared, please check!");
            return false;
        }
        return a(context, "com.baidu.android.pushservice.action.PUSH_SERVICE", "com.baidu.android.pushservice.PushService", false);
    }

    private static boolean I(Context context) {
        try {
            if (a() && PushSettings.m(context)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    boolean z = false;
                    boolean z2 = false;
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        if (serviceInfo.name.equals("com.xiaomi.mipush.sdk.PushMessageHandler")) {
                            int E = E(context, "com.xiaomi.mipush.sdk.PushMessageHandler");
                            if (serviceInfo.exported && (E == 1 || (E == 0 && serviceInfo.enabled))) {
                                z2 = true;
                            } else {
                                Log.e("BDPushSDK-Utility", "com.xiaomi.mipush.sdk.PushMessageHandler is disable, please check!");
                            }
                        }
                        if (serviceInfo.name.equals("com.xiaomi.mipush.sdk.MessageHandleService")) {
                            int E2 = E(context, "com.xiaomi.mipush.sdk.MessageHandleService");
                            if (E2 == 1 || (E2 == 0 && serviceInfo.enabled)) {
                                z = true;
                            } else {
                                Log.e("BDPushSDK-Utility", "com.xiaomi.mipush.sdk.MessageHandleService is disable, please check!");
                            }
                        }
                    }
                    if (!z || !z2) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
        }
        return false;
    }

    private static boolean J(Context context) {
        com.baidu.android.pushservice.g.a.b("Utility", "checkPushInfoContentProvider");
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, "com.baidu.android.pushservice.PushInfoProvider");
            new ProviderInfo();
            ProviderInfo providerInfo = packageManager.getProviderInfo(componentName, 128);
            String str = providerInfo.name;
            String str2 = providerInfo.authority;
            com.baidu.android.pushservice.g.b.c("Utility", "provider name  = " + str + "  export  = " + providerInfo.exported + " provider authorities = " + str2, context.getApplicationContext());
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
            com.baidu.android.pushservice.g.a.a("Utility", e);
            return false;
        }
    }

    private static boolean K(Context context) {
        if (b == -1) {
            b = t(context, "android.permission.WRITE_EXTERNAL_STORAGE") ? 0 : 1;
        }
        return b == 0;
    }

    private static boolean L(Context context) {
        String str;
        try {
            str = Build.DISPLAY;
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
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
        if (l(context, str2) < 50) {
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
        intent.putExtra("bd.cross.request.SOURCE_SERVICE", "com.baidu.android.pushservice.PushService");
        return new e(context, intent).b().a();
    }

    public static Intent a(Context context, Intent intent, String str) {
        if (com.baidu.android.pushservice.a.a() >= 32) {
            intent.setFlags(32);
            intent.setAction(str);
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                intent.setClassName(packageName, "com.baidu.android.pushservice.PushService");
            }
        }
        return intent;
    }

    public static PackageInfo a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return packageManager.getPackageInfo(str, 64);
        } catch (Exception e) {
            return null;
        }
    }

    public static com.baidu.android.pushservice.h.i a(com.baidu.android.pushservice.h.i iVar, Context context, String str) {
        PackageInfo a2 = a(context, str);
        if (a2 != null) {
            iVar.e(a2.applicationInfo.loadLabel(context.getPackageManager()).toString());
            iVar.g(a2.versionName);
            iVar.a(a2.versionCode);
            iVar.f(m(context, str));
            iVar.b(l(context, str));
        }
        return iVar;
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

    public static String a(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager;
        if (context == null) {
            com.baidu.android.pushservice.g.a.b("Utility", "getMetaData context == null");
            return null;
        }
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("getMetaDataString", "--- " + str + " GetMetaData Exception:\r\n", e);
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

    public static String a(String str) {
        BigInteger add;
        if (TextUtils.isDigitsOnly(str)) {
            BigInteger bigInteger = new BigInteger(str);
            try {
                if (bigInteger.and(new BigInteger("0800000000000000", 16)).equals(BigInteger.ZERO)) {
                    BigInteger xor = bigInteger.xor(new BigInteger("282335"));
                    add = xor.and(new BigInteger("00ff0000", 16)).shiftLeft(8).add(xor.and(new BigInteger("000000ff", 16)).shiftLeft(16)).add(xor.and(new BigInteger("ff000000", 16)).shiftRight(16).and(new BigInteger("0000ff00", 16))).add(xor.and(new BigInteger("0000ff00", 16)).shiftRight(8));
                } else {
                    System.out.println("encode =  1");
                    BigInteger xor2 = bigInteger.xor(new BigInteger("22727017042830095"));
                    add = xor2.and(new BigInteger("000000ff00000000", 16)).shiftLeft(16).add(xor2.and(new BigInteger("000000000000ffff", 16)).shiftLeft(32)).add(xor2.and(new BigInteger("00ffff0000000000", 16)).shiftRight(24).and(new BigInteger("00000000ffff0000", 16))).add(xor2.and(new BigInteger("00000000ffff0000", 16)).shiftRight(16)).add(xor2.and(new BigInteger("ff00000000000000", 16)));
                }
                return add.toString();
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.a("Utility", e);
                return "0";
            }
        }
        return "0";
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
        com.baidu.android.pushservice.g.a.c("Utility", ">>> setAlarmForRestart");
        Context applicationContext = context.getApplicationContext();
        Intent c2 = p.c(applicationContext);
        String packageName = applicationContext.getPackageName();
        String c3 = c(applicationContext, packageName, c2.getAction());
        if (!TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(c3)) {
            c2.setClassName(packageName, c3);
        }
        a(applicationContext, c2, j);
    }

    public static void a(Context context, Intent intent) {
        try {
            Uri data = intent.getData();
            if (data != null) {
                String f = f(data.toString());
                com.baidu.android.pushservice.g.a.c("Utility", "Huawei Message Body = " + f);
                Intent intent2 = new Intent();
                String stringExtra = intent.getStringExtra("hwtitle");
                String stringExtra2 = intent.getStringExtra("hwcontent");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    intent2.putExtra("notification_title", stringExtra);
                    intent2.putExtra("notification_content", stringExtra2);
                }
                intent2.putExtra("extra_extra_custom_content", f);
                a(context, "", "", stringExtra, stringExtra2, f);
                b(context, intent2, "com.baidu.android.pushservice.action.notification.CLICK", context.getPackageName());
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
        }
    }

    public static void a(Context context, Intent intent, long j) {
        com.baidu.android.pushservice.g.a.c("Utility", ">>> setAlarmForSendInent : \r\n" + intent);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 268435456);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        alarmManager.cancel(broadcast);
        alarmManager.set(3, SystemClock.elapsedRealtime() + j, broadcast);
    }

    public static void a(Context context, com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        int i = 0;
        com.baidu.android.pushservice.h.a aVar = new com.baidu.android.pushservice.h.a();
        aVar.a = kVar.h();
        aVar.b = kVar.b();
        aVar.c = kVar.c();
        aVar.d = kVar.d();
        aVar.e = 1;
        aVar.f = 1;
        com.baidu.android.pushservice.d.a.a(context, aVar);
        try {
            i = Long.valueOf(System.currentTimeMillis()).intValue();
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
        }
        Intent a2 = a(context, new Intent(), "com.baidu.android.pushservice.action.alarm.message");
        a2.putExtra("tinyMessageHead", kVar);
        a2.putExtra("msgBody", bArr);
        PendingIntent service = PendingIntent.getService(context, i, a2, 134217728);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        try {
            if (Build.VERSION.SDK_INT < 19) {
                alarmManager.set(0, aVar.c, service);
            } else if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, aVar.c, service);
            }
            com.baidu.android.pushservice.g.a.c("Utility", "setMessageAlarm  showtime = " + aVar.c + " expiretime = " + aVar.d);
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.a("Utility", e2);
        }
    }

    public static void a(Context context, boolean z, boolean z2) {
        com.baidu.android.pushservice.g.b.a("Utility", context.getPackageName() + ": updateServiceInfo isForce = " + z + ",isSend = " + z2, context.getApplicationContext());
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        int d = d(context, context.getPackageName());
        if (sharedPreferences.getInt("pr_app_v", 0) < d || z) {
            if (c(context) || com.baidu.android.pushservice.c.d.d(context)) {
                com.baidu.android.pushservice.d.c.a(context, 0L);
            } else {
                com.baidu.android.pushservice.d.c.a(context, f(context));
            }
            if (D(context)) {
                SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5).edit();
                if (c(context) || com.baidu.android.pushservice.c.d.d(context)) {
                    edit.putLong("priority2", 0L);
                } else {
                    edit.putLong("priority2", f(context));
                }
                edit.putInt("version2", com.baidu.android.pushservice.a.a());
                edit.commit();
            }
            com.baidu.android.pushservice.d.c.b(context, com.baidu.android.pushservice.a.a());
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.putInt("pr_app_v", d);
            edit2.commit();
        }
        if (z2) {
            p.d(context);
        }
    }

    private static synchronized void a(String str, String str2) {
        File[] listFiles;
        FileOutputStream fileOutputStream;
        synchronized (q.class) {
            FileOutputStream fileOutputStream2 = null;
            try {
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
                String str3 = new String();
                if (format.length() > 0) {
                    str3 = format.substring(0, 4).concat(format.substring(5, 7)).concat(format.substring(8, 10));
                }
                String str4 = format + " " + str2 + "\n\r";
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(absolutePath, "baidu/pushservice/files");
                if (file.exists()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
                    for (File file2 : file.listFiles()) {
                        if (file2.getName().startsWith(str) && Integer.parseInt(str3) - Integer.parseInt(simpleDateFormat.format(Long.valueOf(file2.lastModified()))) >= 7) {
                            file2.delete();
                        }
                    }
                } else {
                    file.mkdirs();
                }
                File file3 = new File(absolutePath, "baidu/pushservice/files/" + str + str3 + ".log");
                if (file3.exists()) {
                    fileOutputStream = new FileOutputStream(file3, true);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.write(str4.getBytes());
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            com.baidu.android.pushservice.g.a.a("Utility", th);
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e) {
                                    com.baidu.android.pushservice.g.a.a("Utility", e);
                                }
                            }
                        }
                    }
                } else {
                    fileOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    com.baidu.android.pushservice.g.a.a("Utility", e2);
                }
            }
        }
    }

    public static boolean a() {
        try {
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
        }
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

    private static boolean a(Context context, PackageManager packageManager, String[] strArr) {
        if (a() && PushSettings.m(context)) {
            try {
                String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
                if (!a(str, strArr)) {
                    com.baidu.android.pushservice.g.b.b("Utility", "the permission [ " + str + " ] for xiaomi proxy need is not exist, please check!", context);
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
                com.baidu.android.pushservice.g.a.a("Utility", e);
            }
        }
        return false;
    }

    public static boolean a(Context context, PublicMsg publicMsg) {
        String str;
        boolean z;
        String a2 = com.baidu.android.pushservice.k.f.a((publicMsg.mAppId + publicMsg.mMsgId + publicMsg.mUrl + publicMsg.mDescription + publicMsg.mTitle + publicMsg.mOpenType).getBytes(), true);
        String b2 = n.b(context, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS");
        if (TextUtils.isEmpty(b2)) {
            z = false;
            str = a2;
        } else if (b2.contains(a2)) {
            str = b2;
            z = true;
        } else {
            if (b2.length() > 3000) {
                b2 = b2.substring(1000);
            }
            str = b2 + ":" + a2;
            z = false;
        }
        if (!z) {
            n.b(context, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS", str);
        }
        if (com.baidu.android.pushservice.c.d.a(context).b() == com.baidu.android.pushservice.c.d.g) {
            com.baidu.android.pushservice.d.c.a(context, new com.baidu.android.pushservice.d.e(publicMsg.mMsgId, a2, publicMsg.mAppId));
        }
        return true;
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4) {
        boolean z;
        String b2 = PushSettings.b(context);
        if (!TextUtils.isEmpty(b2)) {
            str = b2;
        }
        String str5 = str + str2 + str3 + str4;
        if (TextUtils.isEmpty(str5)) {
            return false;
        }
        String a2 = com.baidu.android.pushservice.k.f.a(str5.getBytes(), true);
        String b3 = n.b(context, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS");
        if (TextUtils.isEmpty(b3) || TextUtils.isEmpty(a2) || !b3.contains(a2)) {
            z = false;
        } else {
            b3.replace(a2, "");
            z = true;
        }
        if (!z && !TextUtils.isEmpty(a2)) {
            String b4 = com.baidu.android.pushservice.d.c.b(context, com.baidu.android.pushservice.c.d.a(context).b() == com.baidu.android.pushservice.c.d.h ? com.baidu.android.pushservice.c.d.a(context).c() : u(context), a2);
            z = !TextUtils.isEmpty(b4) && b4.equals(a2);
        }
        return z;
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4, String str5) {
        String b2 = PushSettings.b(context);
        if (TextUtils.isEmpty(b2)) {
            b2 = str2;
        }
        boolean z = false;
        String a2 = com.baidu.android.pushservice.k.f.a((b2 + str3 + str4 + str5).getBytes(), true);
        String b3 = n.b(context, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS");
        if (TextUtils.isEmpty(b3)) {
            b3 = a2;
        } else if (b3.contains(a2)) {
            z = true;
        } else {
            if (b3.length() > 3000) {
                b3 = b3.substring(1000);
            }
            b3 = b3 + ":" + a2;
        }
        if (!z) {
            n.b(context, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS", b3);
        }
        if (com.baidu.android.pushservice.c.d.a(context).b() == com.baidu.android.pushservice.c.d.g && !TextUtils.isEmpty(str)) {
            com.baidu.android.pushservice.d.c.a(context, new com.baidu.android.pushservice.d.e(str, a2, str2));
        }
        return z;
    }

    private static boolean a(Context context, String str, String str2, boolean z) {
        PackageManager packageManager;
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            com.baidu.android.pushservice.g.b.b("Utility", "error  " + e.getMessage(), context);
        }
        if (packageManager == null) {
            return false;
        }
        if (z) {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
            if (queryBroadcastReceivers.size() < 1) {
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
                    int E = E(context, str2);
                    if (!resolveInfo2.serviceInfo.exported) {
                        Log.e("BDPushSDK-Utility", str2 + " exported is false , please check!");
                        return false;
                    } else if (E == 1 || (E == 0 && resolveInfo2.serviceInfo.enabled)) {
                        return true;
                    } else {
                        Log.e("BDPushSDK-Utility", str2 + " is disable, please check!");
                    }
                }
            }
        }
        return false;
    }

    public static boolean a(Context context, byte[] bArr, String str, String str2, byte[] bArr2) {
        com.baidu.android.pushservice.b.f d;
        try {
            String b2 = PushSettings.b(context);
            if (TextUtils.isEmpty(b2) && (d = com.baidu.android.pushservice.b.b.a(context).d(str)) != null) {
                b2 = d.a();
            }
            if (TextUtils.isEmpty(b2) || !b2.equals(str)) {
                com.baidu.android.pushservice.g.b.a("Utility", "walnutShellVerify error, appId not equal: " + str + "  stored: " + b2, context);
                return false;
            }
            byte[] a2 = com.baidu.android.pushservice.k.g.a(bArr, "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAtadv7/MPKp+9Djta\r/DIEt15755s3h1KYA4Lbej2GL2Mx0mdk4wzmjMCzfvNh+v4R7/mF8kfN8Kzowuaa\rFjAzfwIDAQABAkBVYQxguFoxi4DddpJuJMhIs3UDR9YSmYRvagrkapRuIqJmj3hO\rk+EsDQUtNA7JYJdiv/hrPrH0UACDV/Whb1MJAiEA8Rw37/dC157fsxasiTDz9bMQ\reAq9F8GudeH8oT5j8r0CIQDA30JBzOmu7CpPWbsTFh9YuL9wujJdiAdcBVHqmmfg\r6wIhAJbQIMkPr5axgJlDqH5TyXU5IScFCIwwkNCZn2y4Wso9AiBmMydhxJojFYNJ\r7stBTtynX6YZrqBXjWgQ68S/YrgepwIgdIQpvO4xNCT1j/mGIRcM/dqTGwiPOi/x\r/YLmfF2zQkM=\r");
            String a3 = com.baidu.android.pushservice.k.f.a(a(a(str.getBytes(), str2.getBytes()), bArr2), false);
            String str3 = new String(a2);
            return (str3 == null || a3 == null || !a3.equals(str3)) ? false : true;
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
            return false;
        }
    }

    public static boolean a(String str, Context context) {
        if (TextUtils.isEmpty(str) || str.contains(" ")) {
            Log.e("BDPushSDK-Utility", "api_key is  incorrect, please check ! ");
            return false;
        }
        return true;
    }

    static boolean a(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] a(Context context, String str, byte[] bArr, byte[] bArr2, String str2) {
        int l = l(context, str2);
        com.baidu.android.pushservice.g.a.c("Utility", " handleSecureInfo getIntergratedPushVersion from: " + str2 + " : " + l + " msgid: " + str);
        if (l <= 45 || l >= 50) {
            return bArr2;
        }
        try {
            return com.baidu.android.pushservice.k.g.b(com.baidu.android.pushservice.k.f.a(a(str.getBytes(), bArr), false).getBytes(), "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMPGuiFnHoDFak4nw1ipCr6EiCA2gSBJ\rtUKSfL41Goz+h4oX2Fs6uNvc0XNPlowZw1Np1AFKGwRgVLuLvot6XnkCAwEAAQ==");
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
            return bArr2;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static int b(String str) {
        try {
            return (int) Long.parseLong(str);
        } catch (Exception e) {
            try {
                if (str.length() > 0) {
                    str = str.substring(1);
                }
                return (int) Long.parseLong(str);
            } catch (Exception e2) {
                com.baidu.android.pushservice.g.a.d("Utility", "exception " + e2.getMessage());
                return 0;
            }
        }
    }

    public static void b(Context context, Intent intent, String str, String str2) {
        intent.setFlags(32);
        int l = l(context, str2);
        if (l >= 32) {
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
                b("sendRedirecctionIntent#intergratedPushVersion=" + l + ", packageName=" + str2 + ", intent=" + intent.toUri(0), context);
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.a("Utility", e);
            }
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

    public static synchronized void b(String str, Context context) {
        FileWriter fileWriter;
        File[] listFiles;
        synchronized (q.class) {
            if (K(context)) {
                if (com.baidu.android.pushservice.a.b() > 0) {
                    c(str, context);
                } else if (com.baidu.android.pushservice.a.a(context)) {
                    FileWriter fileWriter2 = null;
                    try {
                        String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " " + str + "\n\r";
                        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                        File file = new File(absolutePath, "baidu/pushservice/files");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                        Date date = new Date();
                        File file2 = new File(absolutePath, "baidu/pushservice/files/msg" + simpleDateFormat.format(date) + ".log");
                        if (!file2.exists()) {
                            for (File file3 : file.listFiles()) {
                                String name = file3.getName();
                                if (name.startsWith(AddFriendActivityConfig.MSG) && name.length() > 0 && ((int) Math.abs((simpleDateFormat.parse(name.substring(3, 11)).getTime() - date.getTime()) / 86400000)) >= 7) {
                                    file3.delete();
                                }
                            }
                            file2.createNewFile();
                        }
                        if (file2.exists()) {
                            fileWriter = new FileWriter(file2, true);
                            if (fileWriter != null) {
                                try {
                                    fileWriter.write(str2);
                                } catch (Throwable th) {
                                    th = th;
                                    fileWriter2 = fileWriter;
                                    com.baidu.android.pushservice.g.a.a("Utility", th);
                                    com.baidu.android.pushservice.f.b.a(fileWriter2);
                                }
                            }
                        } else {
                            fileWriter = null;
                        }
                        com.baidu.android.pushservice.f.b.a(fileWriter);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
    }

    public static boolean b() {
        try {
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
        }
        return Build.MANUFACTURER.toUpperCase().contains("HUAWEI");
    }

    public static boolean b(Context context, PublicMsg publicMsg) {
        boolean z;
        if (publicMsg != null) {
            String a2 = com.baidu.android.pushservice.k.f.a((publicMsg.mAppId + publicMsg.mMsgId + publicMsg.mUrl + publicMsg.mDescription + publicMsg.mTitle + publicMsg.mOpenType).getBytes(), true);
            String b2 = n.b(context, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS");
            if (TextUtils.isEmpty(b2) || TextUtils.isEmpty(a2) || !b2.contains(a2)) {
                z = false;
            } else {
                b2.replace(a2, "");
                z = true;
            }
            if (z || TextUtils.isEmpty(a2)) {
                return z;
            }
            String a3 = com.baidu.android.pushservice.d.c.a(context, com.baidu.android.pushservice.c.d.a(context).b() == com.baidu.android.pushservice.c.d.h ? com.baidu.android.pushservice.c.d.a(context).c() : u(context), publicMsg.mMsgId);
            return !TextUtils.isEmpty(a3) && a3.equals(a2);
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
            com.baidu.android.pushservice.g.a.a("Utility", e);
            return false;
        }
    }

    public static boolean b(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager;
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("getMetaDataBoolean", "--- " + str + " GetMetaData Exception:\r\n", e);
            applicationInfo = null;
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

    public static int[] b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.heightPixels, displayMetrics.widthPixels};
    }

    public static int c(String str) {
        int i;
        Exception e;
        String str2;
        int i2 = 0;
        String str3 = str;
        while (true) {
            try {
                int indexOf = str3.indexOf("#Intent;");
                if (indexOf != -1) {
                    int length = i2 + "#Intent;".length() + indexOf;
                    String substring = str3.substring("#Intent;".length() + indexOf);
                    i = length;
                    str2 = substring;
                } else {
                    String str4 = str3;
                    i = i2;
                    str2 = str4;
                }
                if (indexOf == -1) {
                    break;
                }
                String str5 = str2;
                i2 = i;
                str3 = str5;
            } catch (Exception e2) {
                i = i2;
                e = e2;
            }
        }
        if (i > 0) {
            try {
                return i - "#Intent;".length();
            } catch (Exception e3) {
                e = e3;
                com.baidu.android.pushservice.g.a.a("Utility", e);
                return i;
            }
        }
        return i;
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
            com.baidu.android.pushservice.g.a.a("Utility", e);
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

    private static synchronized void c(String str, Context context) {
        synchronized (q.class) {
            if (context != null) {
                String str2 = "samonitor" + com.baidu.android.pushservice.k.e.b(context);
                String r = r(context);
                int s = s(context);
                if (!c) {
                    ArrayList<String> p = p(context);
                    StringBuffer stringBuffer = new StringBuffer();
                    Iterator<String> it = p.iterator();
                    while (it.hasNext()) {
                        stringBuffer.append(it.next() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    }
                    a(str2, "#AllPackagesUsingPush:" + stringBuffer.toString());
                    c = true;
                }
                a(str2, "#IMEI:" + ((String) null) + "#networkType:" + r + "#mobileType:" + s + "#" + str);
            }
        }
    }

    public static boolean c() {
        return a() || b();
    }

    public static boolean c(Context context) {
        String c2 = com.baidu.android.pushservice.a.c(context);
        boolean b2 = "enabled".equals(c2) ? false : "disabled".equals(c2) ? true : b(context, context.getPackageName(), "DisableService");
        com.baidu.android.pushservice.g.a.b("Utility", "--- isDisableService : " + b2);
        return b2;
    }

    public static boolean c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
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

    /* JADX WARN: Removed duplicated region for block: B:32:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int d(String str) {
        InputStreamReader inputStreamReader;
        Process process;
        Process process2;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            process = Runtime.getRuntime().exec("/system/bin/ping -w 1 " + str);
            try {
                inputStreamReader = new InputStreamReader(process.getInputStream());
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception e) {
                    e = e;
                    process2 = process;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
                inputStreamReader = null;
                process2 = process;
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
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
                        com.baidu.android.pushservice.f.b.a(bufferedReader, inputStreamReader);
                        if (process != null) {
                            process.destroy();
                            return 0;
                        }
                        return 0;
                    }
                } while (i <= 3);
                com.baidu.android.pushservice.f.b.a(bufferedReader, inputStreamReader);
                if (process != null) {
                    process.destroy();
                }
                return -1;
            } catch (Exception e3) {
                e = e3;
                bufferedReader2 = bufferedReader;
                process2 = process;
                try {
                    com.baidu.android.pushservice.g.a.a("Utility", e);
                    com.baidu.android.pushservice.f.b.a(bufferedReader2, inputStreamReader);
                    if (process2 != null) {
                        process2.destroy();
                    }
                    return 1;
                } catch (Throwable th3) {
                    th = th3;
                    process = process2;
                    com.baidu.android.pushservice.f.b.a(bufferedReader2, inputStreamReader);
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader2 = bufferedReader;
                com.baidu.android.pushservice.f.b.a(bufferedReader2, inputStreamReader);
                if (process != null) {
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            inputStreamReader = null;
            process2 = null;
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
            process = null;
        }
    }

    public static void d(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            com.baidu.android.pushservice.g.a.c("Utility", "requestXiaomiRegId--------  appid = " + str + " appkey = " + str2);
            Context applicationContext = context.getApplicationContext();
            o.b(applicationContext, "");
            MiPushClient.registerPush(applicationContext, str, str2);
        } catch (Throwable th) {
            com.baidu.android.pushservice.g.a.a("Utility", th);
        }
    }

    static boolean d(Context context) {
        boolean z = false;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    if (!a(context, packageManager, strArr)) {
                        int i = 0;
                        while (true) {
                            if (i >= a.length) {
                                z = true;
                                break;
                            } else if (!a(a[i], strArr)) {
                                Log.e("BDPushSDK-Utility", a[i] + " permission Push-SDK need is not exist !");
                                break;
                            } else {
                                i++;
                            }
                        }
                    } else {
                        Log.e("BDPushSDK-Utility", " permission Push-SDK for xiaomi proxy need is not exist !");
                    }
                } else {
                    Log.e("BDPushSDK-Utility", "Permissions Push-SDK need are not exist !");
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
        }
        return z;
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
        com.baidu.android.pushservice.g.a.c("Utility", ">>> setAlarmForPeriodRestart");
        a(context, (long) ReportUserInfoModel.TIME_INTERVAL);
    }

    public static boolean e(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager;
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("isBaiduApp", "--- " + str + " GetMetaData Exception:\r\n", e);
            applicationInfo = null;
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
        String packageName = context.getPackageName();
        if (F(context) && packageName.equalsIgnoreCase("com.baidu.push4manufacture")) {
            return 10000L;
        }
        long a2 = com.baidu.android.pushservice.a.a();
        int b2 = com.baidu.android.pushservice.a.b();
        if (b2 > 0) {
            return (a2 << 4) + 10 + (b2 <= 5 ? b2 : 5);
        }
        long j = a2 << 2;
        if (e(context, context.getPackageName())) {
            com.baidu.android.pushservice.g.a.c("Utility", "--- get " + context + " PriorityVersion, baidu app");
            j++;
        }
        long j2 = j << 1;
        if (b(context, context.getPackageName())) {
            com.baidu.android.pushservice.g.a.c("Utility", "--- get " + context + " PriorityVersion, system app");
            j2++;
        }
        return (j2 << 1) + l(context);
    }

    private static String f(String str) {
        String str2 = null;
        try {
            if (!TextUtils.isEmpty(str) && str.contains("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=")) {
                if (str.contains("bdpush_hwsigninfo")) {
                    int c2 = c(str);
                    if (c2 > 0) {
                        str2 = str.substring("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=".length(), c2);
                    }
                } else {
                    str2 = str.substring("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=".length(), str.length());
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
        }
        return str2;
    }

    public static void f(Context context, String str) {
        Intent c2 = p.c(context);
        if (E(context)) {
            c2.putExtra(PushConstants.EXTRA_METHOD, "pushservice_restart_v3");
            if (TextUtils.isEmpty(str) || !str.equals(t(context))) {
                c2.putExtra("priority3", h(context));
            } else {
                c2.putExtra("priority3", Long.MAX_VALUE);
            }
        } else {
            c2.putExtra(PushConstants.EXTRA_METHOD, "pushservice_restart_v2");
            if (TextUtils.isEmpty(str) || !str.equals(t(context))) {
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
            com.baidu.android.pushservice.g.a.a("Utility", e);
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

    public static long g(Context context, String str) {
        long j;
        Exception e;
        Context u;
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            j = (!D(context) || (u = u(context, str)) == null || (sharedPreferences = u.getSharedPreferences(new StringBuilder().append(str).append(".push_sync").toString(), 5)) == null) ? -1L : sharedPreferences.getLong("priority2", 0L);
            if (j == -1) {
                try {
                    return com.baidu.android.pushservice.d.d.c(context, str);
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.android.pushservice.g.a.a("Utility", "create packagecontext exception: ", e);
                    return j;
                }
            }
            return j;
        } catch (Exception e3) {
            j = -1;
            e = e3;
        }
    }

    public static void g(Context context) {
        a(context, false, false);
    }

    public static long h(Context context) {
        long j;
        Exception e;
        SharedPreferences sharedPreferences;
        if (context == null) {
            return 0L;
        }
        try {
            j = (!D(context) || (sharedPreferences = context.getSharedPreferences(new StringBuilder().append(context.getPackageName()).append(".push_sync").toString(), 5)) == null) ? -1L : sharedPreferences.getLong("priority2", 0L);
            if (j == -1) {
                try {
                    return com.baidu.android.pushservice.d.c.b(context);
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.android.pushservice.g.a.a("Utility", e);
                    return j;
                }
            }
            return j;
        } catch (Exception e3) {
            j = -1;
            e = e3;
        }
    }

    public static boolean h(Context context, String str) {
        boolean z;
        int i;
        PackageManager packageManager;
        Intent intent = new Intent("com.baidu.android.pushservice.action.PUSH_SERVICE");
        intent.setPackage(str);
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            e = e;
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
            i = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.baidu.android.pushservice.PushService"));
        } catch (Exception e2) {
            e = e2;
            com.baidu.android.pushservice.g.a.a("Utility", e);
            i = 2;
            return i != 1 || (i == 0 && z);
        }
        return i != 1 || (i == 0 && z);
    }

    static boolean i(Context context) {
        return i(context, context.getPackageName());
    }

    public static boolean i(Context context, String str) {
        boolean z;
        Exception e;
        String str2;
        boolean z2;
        try {
            Intent intent = new Intent("com.baidu.android.pushservice.action.notification.CLICK");
            intent.setPackage(context.getPackageName());
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
            if (queryBroadcastReceivers.size() < 1) {
                return false;
            }
            Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
            if (it.hasNext()) {
                ResolveInfo next = it.next();
                str2 = next.activityInfo.name;
                z2 = next.activityInfo.enabled;
            } else {
                str2 = null;
                z2 = false;
            }
            if (!a(context, PushConstants.ACTION_MESSAGE, str2, true) || !a(context, PushConstants.ACTION_RECEIVE, str2, true)) {
                Log.e("BDPushSDK-Utility", str2 + " did not declared " + PushConstants.ACTION_MESSAGE + " or " + PushConstants.ACTION_RECEIVE);
                return false;
            }
            if (b() && PushSettings.n(context)) {
                if (!a(context, "com.huawei.intent.action.PUSH", str2, true)) {
                    Log.e("BDPushSDK-Utility", str2 + " did not declared com.huawei.intent.action.PUSH");
                    return false;
                } else if (!a(context, "com.huawei.android.push.intent.RECEIVE", str2, true)) {
                    Log.e("BDPushSDK-Utility", str2 + " did not declared com.huawei.android.push.intent.RECEIVE");
                    return false;
                } else if (!a(context, "com.huawei.android.push.intent.REGISTRATION", str2, true)) {
                    Log.e("BDPushSDK-Utility", str2 + " did not declared com.huawei.android.push.intent.REGISTRATION");
                    return false;
                }
            } else if (a() && PushSettings.m(context)) {
                if (!a(context, "com.xiaomi.mipush.RECEIVE_MESSAGE", "com.baidu.android.pushservice.PushPatchMessageReceiver", true)) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushPatchMessageReceiver did not declared com.xiaomi.mipush.RECEIVE_MESSAGE");
                    return false;
                } else if (!a(context, "com.xiaomi.mipush.MESSAGE_ARRIVED", "com.baidu.android.pushservice.PushPatchMessageReceiver", true)) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushPatchMessageReceiver did not declared com.xiaomi.mipush.MESSAGE_ARRIVED");
                    return false;
                } else if (!a(context, "com.xiaomi.mipush.ERROR", "com.baidu.android.pushservice.PushPatchMessageReceiver", true)) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushPatchMessageReceiver did not declared com.xiaomi.mipush.ERROR");
                    return false;
                }
            }
            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(context.getPackageName(), str2));
            z = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z2);
            if (z) {
                return z;
            }
            try {
                Log.e("BDPushSDK-Utility", str2 + " is disable, please check!");
                return z;
            } catch (Exception e2) {
                e = e2;
                com.baidu.android.pushservice.g.a.a("Utility", e);
                return z;
            }
        } catch (Exception e3) {
            z = false;
            e = e3;
        }
    }

    static boolean j(Context context) {
        return j(context, context.getPackageName());
    }

    public static boolean j(Context context, String str) {
        boolean z = true;
        try {
            if (!D(context) || context.getSharedPreferences(context.getPackageName() + ".push_sync", 5).getInt("version2", 0) >= 29) {
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
            com.baidu.android.pushservice.g.a.a("Utility", e);
            return false;
        }
    }

    public static boolean k(Context context) {
        com.baidu.android.pushservice.g.a.c("Utility", "check PushService AndroidManifest declearation !");
        if (d(context) && G(context)) {
            return H(context) || L(context);
        }
        return false;
    }

    public static boolean k(Context context, String str) {
        if (!PushSocket.a(context)) {
            Log.e("BDPushSDK-Utility", "check socket library failed");
            com.baidu.android.pushservice.g.a.e("Utility", "check socket library failed");
            return false;
        } else if (!k(context)) {
            Log.e("BDPushSDK-Utility", "check SDK AndroidManifest failed");
            com.baidu.android.pushservice.g.a.e("Utility", "check SDK AndroidManifest failed");
            return false;
        } else if (!a(str, context)) {
            Log.e("BDPushSDK-Utility", "check Apikey failed");
            com.baidu.android.pushservice.g.a.e("Utility", "check Apikey failed");
            return false;
        } else {
            if (!i(context)) {
                Log.e("BDPushSDK-Utility", "check SelfConfiged Receiver failed");
                com.baidu.android.pushservice.g.a.e("Utility", "check SelfConfiged Receiver failed");
            }
            if (j(context)) {
                if (J(context)) {
                    return true;
                }
                Log.e("BDPushSDK-Utility", "check PushInfoProvider Enable failed");
                return false;
            } else if (L(context)) {
                return true;
            } else {
                Log.e("BDPushSDK-Utility", "check CommandService Enable failed");
                com.baidu.android.pushservice.g.a.e("Utility", "check CommandService Enable failed");
                return false;
            }
        }
    }

    static int l(Context context) {
        int i = a(context, "android.intent.action.USER_PRESENT", "com.baidu.android.pushservice.PushServiceReceiver", true) ? 1 : 0;
        if (a(context, "android.intent.action.MEDIA_MOUNTED", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            i++;
        }
        if (a(context, "android.intent.action.ACTION_POWER_CONNECTED", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            i++;
        }
        return a(context, "android.intent.action.ACTION_POWER_DISCONNECTED", "com.baidu.android.pushservice.PushServiceReceiver", true) ? i + 1 : i;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int l(Context context, String str) {
        int i;
        Exception exc;
        int i2;
        int d;
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (str.equals(context.getPackageName())) {
                return com.baidu.android.pushservice.a.a();
            }
            if (D(context)) {
                try {
                    Context u = u(context, str);
                    SharedPreferences sharedPreferences = u != null ? u.getSharedPreferences(str + ".push_sync", 5) : null;
                    i2 = sharedPreferences != null ? sharedPreferences.getInt("version2", 0) : -1;
                } catch (Exception e) {
                    com.baidu.android.pushservice.g.a.a("Utility", e);
                }
                if (i2 != -1) {
                    try {
                        d = com.baidu.android.pushservice.d.d.d(context, str);
                    } catch (Exception e2) {
                        exc = e2;
                        i = i2;
                        com.baidu.android.pushservice.g.a.a("Utility", exc);
                        return i;
                    }
                } else {
                    d = i2;
                }
                if (d != 0) {
                    return 50;
                }
                return d;
            }
            i2 = -1;
            if (i2 != -1) {
            }
            if (d != 0) {
            }
        } catch (Exception e3) {
            i = -1;
            exc = e3;
        }
    }

    public static String m(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : a(context, str, "BaiduPush_CHANNEL");
    }

    public static List<ResolveInfo> m(Context context) {
        ArrayList arrayList;
        Exception exc;
        ArrayList arrayList2 = new ArrayList();
        Intent intent = new Intent("com.baidu.android.pushservice.action.BIND_SYNC");
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
            try {
                ArrayList<ResolveInfo> arrayList3 = new ArrayList();
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (z(context, resolveInfo.activityInfo.packageName)) {
                        arrayList3.add(resolveInfo);
                    }
                }
                for (ResolveInfo resolveInfo2 : arrayList3) {
                    queryBroadcastReceivers.remove(resolveInfo2);
                }
                return queryBroadcastReceivers;
            } catch (Exception e) {
                arrayList = queryBroadcastReceivers;
                exc = e;
                com.baidu.android.pushservice.g.a.a("Utility", exc);
                return arrayList;
            }
        } catch (Exception e2) {
            arrayList = arrayList2;
            exc = e2;
        }
    }

    public static List<ResolveInfo> n(Context context) {
        ArrayList arrayList;
        Exception exc;
        ArrayList arrayList2 = new ArrayList();
        try {
            Intent intent = new Intent("com.baidu.android.pushservice.action.BIND_SYNC");
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
            try {
                ArrayList<ResolveInfo> arrayList3 = new ArrayList();
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (!z(context, resolveInfo.activityInfo.packageName)) {
                        arrayList3.add(resolveInfo);
                    }
                }
                for (ResolveInfo resolveInfo2 : arrayList3) {
                    queryBroadcastReceivers.remove(resolveInfo2);
                }
                return queryBroadcastReceivers;
            } catch (Exception e) {
                arrayList = queryBroadcastReceivers;
                exc = e;
                com.baidu.android.pushservice.g.a.a("Utility", exc);
                return arrayList;
            }
        } catch (Exception e2) {
            arrayList = arrayList2;
            exc = e2;
        }
    }

    public static boolean n(Context context, String str) {
        return a(context, str) != null;
    }

    public static String o(Context context) {
        String b2 = com.baidu.android.pushservice.k.e.b(context);
        if (E(context)) {
            String a2 = com.baidu.android.pushservice.k.f.a(("com.baidu.pushservice.singelinstancev3" + b2).getBytes(), false);
            com.baidu.android.pushservice.g.a.c("Utility", "createV3  MD5");
            return a2;
        }
        String a3 = com.baidu.android.pushservice.k.f.a(("com.baidu.pushservice.singelinstancev2" + b2).getBytes(), false);
        com.baidu.android.pushservice.g.a.c("Utility", "createV2  MD5");
        return a3;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0153 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String o(Context context, String str) {
        long j;
        long j2;
        SharedPreferences sharedPreferences;
        int b2 = com.baidu.android.pushservice.c.d.a(context).b();
        if (b2 == com.baidu.android.pushservice.c.d.g || b2 == com.baidu.android.pushservice.c.d.h || b2 == com.baidu.android.pushservice.c.d.f) {
            String c2 = com.baidu.android.pushservice.c.d.a(context).c();
            if (!TextUtils.isEmpty(c2)) {
                return c2;
            }
        }
        List<ResolveInfo> n = E(context) ? n(context.getApplicationContext()) : m(context.getApplicationContext());
        if (n.size() <= 1) {
            return context.getPackageName();
        }
        if (D(context)) {
            try {
                sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5);
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.a("Utility", e);
                sharedPreferences = null;
            }
            if (sharedPreferences != null) {
                j = sharedPreferences.getLong("priority2", 0L);
                if (j == -1) {
                    j = com.baidu.android.pushservice.d.c.b(context);
                }
                String t = t(context);
                for (ResolveInfo resolveInfo : n) {
                    String str2 = resolveInfo.activityInfo.packageName;
                    Context u = u(context, str2);
                    if (D(context)) {
                        SharedPreferences sharedPreferences2 = null;
                        if (u != null) {
                            try {
                                sharedPreferences2 = u.getSharedPreferences(str2 + ".push_sync", 5);
                            } catch (Exception e2) {
                                com.baidu.android.pushservice.g.a.a("Utility", e2);
                            }
                        }
                        if (sharedPreferences2 != null) {
                            j2 = sharedPreferences2.getLong("priority2", 0L);
                            if (j2 == -1) {
                                j2 = str2.equals(context.getPackageName()) ? com.baidu.android.pushservice.d.c.b(context) : com.baidu.android.pushservice.d.d.c(context, str2);
                            }
                            if (j2 <= j) {
                                com.baidu.android.pushservice.g.a.c("Utility", "Find more higher priority pkg : " + str2 + " priority = " + j2 + ",Current highest priority pkg : " + str + " priority = " + j);
                                if (h(u, str2)) {
                                    j = j2;
                                    str = str2;
                                } else {
                                    com.baidu.android.pushservice.g.a.c("Utility", str2 + "push service is disabled");
                                }
                            } else if (j2 == j && ((str2.equals(t) && h(u, str2)) || (str2.equals(context.getPackageName()) && !D(context)))) {
                                j = j2;
                                str = str2;
                            }
                        }
                    }
                    j2 = -1;
                    if (j2 == -1) {
                    }
                    if (j2 <= j) {
                    }
                }
                com.baidu.android.pushservice.g.a.c("Utility", "Current highest priority Push PackageName: " + str);
                return str;
            }
        }
        j = -1;
        if (j == -1) {
        }
        String t2 = t(context);
        while (r9.hasNext()) {
        }
        com.baidu.android.pushservice.g.a.c("Utility", "Current highest priority Push PackageName: " + str);
        return str;
    }

    public static ArrayList<String> p(Context context) {
        List<ResolveInfo> n = E(context) ? n(context.getApplicationContext()) : m(context.getApplicationContext());
        ArrayList<String> arrayList = new ArrayList<>();
        for (ResolveInfo resolveInfo : n) {
            if (!arrayList.contains(resolveInfo.activityInfo.packageName)) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        return arrayList;
    }

    public static boolean p(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            com.baidu.android.pushservice.g.a.c("Utility", "isNoDisturb parameters illegal : false");
            return false;
        }
        int[] f = com.baidu.android.pushservice.d.a.f(context, str);
        if (f == null || 4 != f.length) {
            return false;
        }
        boolean a2 = a(f[0], f[1], f[2], f[3]);
        com.baidu.android.pushservice.g.a.c("Utility", "isNoDisturb :" + a2 + " ret0 = " + f[0] + " ret1 = " + f[1] + " ret2 = " + f[2] + " ret[3] = " + f[3]);
        return a2;
    }

    public static String q(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return com.baidu.android.pushservice.k.f.a(packageManager.getPackageInfo(str, 64).signatures[0].toByteArray(), false);
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
            return null;
        }
    }

    public static List<String> q(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                com.baidu.android.pushservice.g.a.e("Utility", "ActivityManager is null !!!");
            }
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(500);
            if (runningServices == null || runningServices.isEmpty()) {
                com.baidu.android.pushservice.g.a.e("Utility", "runnServs is null !!!");
            }
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (runningServiceInfo.service.getClassName().contains("com.baidu.android.pushservice.PushService")) {
                    arrayList.add(runningServiceInfo.service.getPackageName());
                }
            }
        } catch (Exception e) {
            b(com.baidu.android.pushservice.g.a.a(e), context);
        }
        return arrayList;
    }

    public static String r(Context context) {
        NetworkInfo c2 = l.c(context);
        if (c2 != null && c2.isConnected() && c2.getState() == NetworkInfo.State.CONNECTED) {
            if (c2.getTypeName().equals("WIFI")) {
                return c2.getTypeName();
            }
            String lowerCase = c2.getExtraInfo() != null ? c2.getExtraInfo().toLowerCase() : null;
            return TextUtils.isEmpty(lowerCase) ? "unknown" : lowerCase;
        }
        return "unknown";
    }

    public static boolean r(Context context, String str) {
        String a2 = n.a(context, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED");
        return !TextUtils.isEmpty(a2) && a2.contains(str);
    }

    public static int s(Context context) {
        NetworkInfo c2;
        String str = "";
        if (context != null && (c2 = l.c(context)) != null && c2.isConnectedOrConnecting()) {
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

    public static boolean s(Context context, String str) {
        String a2 = n.a(context, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED");
        if (!TextUtils.isEmpty(a2)) {
            if (a2.contains(str)) {
                return true;
            }
            if (a2.length() > 1000) {
                a2 = a2.substring(500);
            }
            str = a2 + ":" + str;
        }
        n.a(context, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED", str);
        return false;
    }

    public static String t(Context context) {
        if (E(context)) {
            List<String> q = q(context);
            List<ResolveInfo> n = n(context);
            if (!q.isEmpty()) {
                for (ResolveInfo resolveInfo : n) {
                    if (q.contains(resolveInfo.activityInfo.packageName)) {
                        String b2 = com.baidu.android.pushservice.d.d.b(context, resolveInfo.activityInfo.packageName);
                        if (!TextUtils.isEmpty(b2) && n(context, b2)) {
                            if (h(context, b2)) {
                                return b2;
                            }
                            com.baidu.android.pushservice.g.a.c("Utility", "The Highest priority Service: " + ((String) null) + " is disabled,Maybe use setComponentEnabledSetting method");
                        }
                    }
                }
            }
        } else {
            String a2 = b.a(context, "com.baidu.push.cur_pkg");
            List<String> q2 = q(context);
            if (TextUtils.isEmpty(a2) || !q2.contains(a2)) {
                if (!q2.isEmpty()) {
                    for (String str : q2) {
                        if (!z(context, str)) {
                            String b3 = com.baidu.android.pushservice.d.d.b(context, str);
                            if (!TextUtils.isEmpty(b3) && n(context, b3)) {
                                if (h(context, b3)) {
                                    return b3;
                                }
                                com.baidu.android.pushservice.g.a.c("Utility", "The Highest priority Service: " + ((String) null) + " is disabled,Maybe use setComponentEnabledSetting method");
                            }
                        }
                    }
                }
            } else if (n(context, a2)) {
                if (h(context, a2)) {
                    return a2;
                }
                com.baidu.android.pushservice.g.a.c("Utility", "The Highest priority Service: " + a2 + " is disabled,Maybe use setComponentEnabledSetting method");
            }
        }
        return null;
    }

    public static boolean t(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
            return false;
        }
    }

    public static Context u(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return context.createPackageContext(str, 2);
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
            com.baidu.android.pushservice.h.p.a(context.getApplicationContext(), e);
            return null;
        }
    }

    public static String u(Context context) {
        return o(context, context.getPackageName());
    }

    public static String v(Context context) {
        int i = 1;
        int i2 = l.a(context) ? 0 : 1;
        NetworkInfo c2 = l.c(context);
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
            com.baidu.android.pushservice.g.a.a("Utility", e);
        }
        return jSONObject.toString();
    }

    public static String v(Context context, String str) {
        try {
            PackageInfo a2 = a(context, str);
            return (a2 == null || a2.firstInstallTime <= 0) ? "" : String.valueOf(a2.firstInstallTime);
        } catch (Throwable th) {
            com.baidu.android.pushservice.g.a.a("Utility", th);
            return "";
        }
    }

    public static String w(Context context) {
        String e = e("www.baidu.com");
        String e2 = e("sa.tuisong.baidu.com");
        String e3 = e("api.tuisong.baidu.com");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("baidu_ip", e);
            jSONObject.put("sa_ip", e2);
            jSONObject.put("logic_ip", e3);
        } catch (Exception e4) {
            com.baidu.android.pushservice.g.a.a("Utility", e4);
        }
        if (com.baidu.android.pushservice.a.b() > 0) {
            com.baidu.android.pushservice.g.a.c("Utility", "getNetworkInfo json: " + jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public static boolean w(Context context, String str) {
        boolean z = false;
        ArrayList arrayList = (ArrayList) com.baidu.android.pushservice.b.b.a(context).a.clone();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (str.equals(((com.baidu.android.pushservice.b.f) it.next()).c())) {
                    z = true;
                    break;
                }
            }
        }
        if (!z) {
            String g = com.baidu.android.pushservice.d.c.g(context);
            if (TextUtils.isEmpty(g) && D(context)) {
                g = r.a(context, context.getPackageName() + ".push_sync", "r_v2");
            }
            String a2 = com.baidu.android.pushservice.b.b.a(g);
            if (!TextUtils.isEmpty(a2) && a2.contains(str)) {
                String replace = a2.replace(" ", "");
                if (replace.charAt(replace.indexOf(str) + str.length()) == ',') {
                    return true;
                }
            }
        }
        return z;
    }

    public static void x(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("r_sync_type", 0);
        intent.putExtra("r_sync_rdata_v2", str);
        intent.putExtra("r_sync_from", context.getPackageName());
        intent.setFlags(32);
        for (ResolveInfo resolveInfo : E(context) ? n(context) : m(context)) {
            b(context, intent, "com.baidu.android.pushservice.action.BIND_SYNC", resolveInfo.activityInfo.packageName);
        }
    }

    public static boolean x(Context context) {
        boolean z = false;
        try {
            z = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).getBoolean("bind_status", false);
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
        }
        com.baidu.android.pushservice.g.a.c("Utility", "isbind = " + z);
        return z;
    }

    public static void y(Context context) {
        if (context == null) {
            return;
        }
        com.baidu.android.pushservice.g.a.c("Utility", "requestHuaweiToken--------");
        o.a(context, "");
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("com.huawei.android.push.intent.REGISTER");
        intent.putExtra(PushConstants.PACKAGE_NAME, applicationContext.getPackageName());
        intent.setFlags(32);
        applicationContext.sendBroadcast(intent);
        o.a(applicationContext, "hasRequestToken", true);
    }

    public static boolean y(Context context, String str) {
        boolean z;
        boolean z2;
        try {
        } catch (Exception e) {
            e = e;
            z = false;
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.android.pushservice.g.a.e("Utility", "msgid = null");
            return false;
        }
        z = com.baidu.android.pushservice.d.a.e(context, str);
        try {
            z2 = s(context, str);
        } catch (Exception e2) {
            e = e2;
            com.baidu.android.pushservice.g.a.a("Utility", e);
            z2 = false;
            return z ? false : false;
        }
        if (z && z2) {
            return true;
        }
    }

    public static void z(Context context) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.SEND_APPSTAT");
        com.baidu.android.pushservice.i.a(context.getApplicationContext()).a(intent);
    }

    public static boolean z(Context context, String str) {
        try {
            if (A(context, str) >= 24 && Build.VERSION.SDK_INT >= 24) {
                if ((str.equals(context.getPackageName()) ? com.baidu.android.pushservice.a.a() : l(context, str)) >= 55) {
                    return true;
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("Utility", e);
        }
        return false;
    }
}
