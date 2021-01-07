package com.baidu.android.pushservice.i;

import android.annotation.SuppressLint;
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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.down.utils.Constants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.callback.PushCallback;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"WorldReadableFiles"})
/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static int f1427a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f1428b = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"};
    private static int c = -1;

    private static boolean A(Context context) {
        if (c == -1) {
            c = k(context, "android.permission.WRITE_EXTERNAL_STORAGE") ? 0 : 1;
        }
        return c == 0;
    }

    private static boolean B(Context context) {
        String str;
        try {
            str = Build.DISPLAY;
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
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
        if (!TextUtils.isEmpty(str)) {
            intent.setAction(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        return new c(context, intent, str2).b().a();
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

    public static String a(Context context) {
        PackageInfo a2 = a(context, context.getPackageName());
        return a2 != null ? a2.versionName : "";
    }

    public static String a(Context context, InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            } catch (IOException e) {
                com.baidu.android.pushservice.e.b.a(context, inputStream, inputStreamReader, bufferedReader);
            } catch (Throwable th) {
                com.baidu.android.pushservice.e.b.a(context, inputStream, inputStreamReader, bufferedReader);
                throw th;
            }
        }
        com.baidu.android.pushservice.e.b.a(context, inputStream, inputStreamReader, bufferedReader);
        return sb.toString();
    }

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
        th.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        return stringWriter.toString();
    }

    public static void a() {
        PushManager.getInstance().requestNotificationPermission();
    }

    public static void a(Context context, long j) {
        Context applicationContext = context.getApplicationContext();
        Intent a2 = l.a(applicationContext);
        String packageName = applicationContext.getPackageName();
        String b2 = b(applicationContext, packageName, a2.getAction());
        if (!TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(b2)) {
            a2.setClassName(packageName, b2);
        }
        a(applicationContext, a2, j);
    }

    public static void a(Context context, Intent intent, long j) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 268435456);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        alarmManager.cancel(broadcast);
        alarmManager.set(3, SystemClock.elapsedRealtime() + j, broadcast);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, Intent intent, String str) {
        String action;
        if (context == null || intent == null || str == null || (action = intent.getAction()) == null || !action.startsWith("com.baidu.android.pushservice.action")) {
            return;
        }
        String b2 = b(context, str, action);
        if (context.getPackageName().equals(str) && !TextUtils.isEmpty(b2)) {
            a(context, str, b2, intent);
            return;
        }
        context.sendBroadcast(intent);
        if (action.equals("com.baidu.android.pushservice.action.notification.SHOW")) {
            a(intent.getStringExtra("message_id") + " sendBroadcast to recevier=" + b2, context);
        }
    }

    private static void a(Context context, String str, String str2, Intent intent) {
        try {
            Class<?> cls = Class.forName(str2);
            Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            Method method = cls.getMethod("onReceive", Context.class, Intent.class);
            intent.setClassName(str, str2);
            method.invoke(newInstance, context.getApplicationContext(), intent);
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || !action.equals("com.baidu.android.pushservice.action.notification.SHOW")) {
                return;
            }
            a(intent.getStringExtra("message_id") + " reflectrecevier=" + str2, context);
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
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

    public static synchronized void a(Context context, boolean z) {
        synchronized (m.class) {
            try {
                f1427a = z ? 1 : 0;
                SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
                edit.putBoolean("bind_status", z);
                edit.commit();
            } catch (Exception e) {
            }
        }
    }

    public static void a(final Context context, boolean z, boolean z2) {
        com.baidu.android.pushservice.f.a.a("Utility", context.getPackageName() + ": updateServiceInfo isForce = " + z + ",isSend = " + z2, context.getApplicationContext());
        if (z) {
            com.baidu.android.pushservice.c.c.a(context, 0L);
            com.baidu.android.pushservice.c.c.b(context, com.baidu.android.pushservice.a.a());
        }
        if (z2) {
            new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.android.pushservice.i.m.1
                @Override // java.lang.Runnable
                public void run() {
                    l.b(context);
                }
            }, com.baidu.android.pushservice.b.d.h() * 1000);
        }
    }

    public static void a(Intent intent, Context context) {
        a(context, context.getPackageName(), b(context, context.getPackageName(), "com.baidu.android.pushservice.action.MESSAGE"), intent);
    }

    public static synchronized void a(String str, Context context) {
        FileWriter fileWriter;
        File[] listFiles;
        synchronized (m.class) {
            if (A(context) && PushSettings.n(context)) {
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
                    File file2 = new File(absolutePath, "baidu/pushservice/files/msg" + simpleDateFormat.format(date) + BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
                    if (!file2.exists()) {
                        for (File file3 : file.listFiles()) {
                            String name = file3.getName();
                            if (name.startsWith("msg") && name.length() > 0 && ((int) Math.abs((simpleDateFormat.parse(name.substring(3, 11)).getTime() - date.getTime()) / 86400000)) >= 7) {
                                file3.delete();
                            }
                        }
                        file2.createNewFile();
                    }
                    if (file2.exists()) {
                        fileWriter = new FileWriter(file2, true);
                        try {
                            fileWriter.write(str2);
                        } catch (Throwable th) {
                            th = th;
                            fileWriter2 = fileWriter;
                            new b.c(context).a(Log.getStackTraceString(th)).a();
                            com.baidu.android.pushservice.e.b.a(context, fileWriter2);
                        }
                    } else {
                        fileWriter = null;
                    }
                    com.baidu.android.pushservice.e.b.a(context, fileWriter);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
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
            if (i5 == i3) {
                return i6 <= i4;
            }
        } else if (i > i3) {
            if ((i5 > i && i5 < 24) || i5 < i3) {
                return true;
            }
            if (i5 == i && i6 >= i2) {
                return true;
            }
            if (i5 == i3) {
                return i6 <= i4;
            }
        } else if (i == i5) {
            return i6 >= i2 && i4 >= i6;
        }
        return false;
    }

    private static boolean a(Context context, PackageManager packageManager, String[] strArr) {
        if (b() && PushSettings.f(context)) {
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
        return com.baidu.android.pushservice.c.c.a(context, new com.baidu.android.pushservice.c.f(publicMsg.mMsgId, f.a((publicMsg.mAppId + publicMsg.mMsgId + publicMsg.mUrl + publicMsg.mDescription + publicMsg.mTitle + publicMsg.mOpenType).getBytes(), false), publicMsg.mAppId));
    }

    public static boolean a(Context context, String str, String str2) {
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

    public static boolean a(Context context, String str, String str2, String str3, String str4, String str5) {
        String d = PushSettings.d(context);
        if (!TextUtils.isEmpty(d)) {
            str2 = d;
        }
        if (str == null) {
            str = "";
        }
        String str6 = str2 + str + str3 + str4 + str5;
        if (TextUtils.isEmpty(str6)) {
            return false;
        }
        String a2 = f.a(str6.getBytes(), false);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        String c2 = com.baidu.android.pushservice.c.c.c(context, context.getPackageName(), a2);
        return !TextUtils.isEmpty(c2) && c2.equals(a2);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00d8 -> B:6:0x0015). Please submit an issue!!! */
    private static boolean a(Context context, String str, String str2, boolean z) {
        PackageManager packageManager;
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            com.baidu.android.pushservice.f.a.b("Utility", "error  " + e.getMessage(), context);
            new b.c(context).a(Log.getStackTraceString(e)).a();
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
        if (bArr == null || str == null || str2 == null || bArr2 == null) {
            return false;
        }
        try {
            if (TextUtils.equals(f.a(a(a(str.getBytes(), str2.getBytes()), bArr2), false), new String(k.b(bArr, BaiduAppSSOJni.getPrivateKey(0))))) {
                return true;
            }
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
        } catch (UnsatisfiedLinkError e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return true;
        }
        return false;
    }

    public static boolean a(Context context, byte[] bArr, String str, byte[] bArr2) {
        if (bArr == null || str == null || bArr2 == null) {
            return false;
        }
        return com.baidu.android.pushservice.f.a(context, new String(bArr), str + new String(bArr2));
    }

    private static boolean a(Context context, String[] strArr) {
        if ((e() || f() || g()) && PushSettings.h(context)) {
            try {
                if (a("com.coloros.mcs.permission.RECIEVE_MCS_MESSAGE", strArr)) {
                    if (a("com.heytap.mcs.permission.RECIEVE_MCS_MESSAGE", strArr)) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || str.contains(" ")) {
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

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String b(Context context, String str, String str2) {
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
            new b.c(context).a(Log.getStackTraceString(e)).a();
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

    public static String b(String str) {
        String str2;
        try {
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                byte[] decode = Base64.decode(str.getBytes(), 2);
                str2 = new String(BaiduAppSSOJni.decryptAES(decode, decode.length, 0), "utf-8");
            }
            return str2;
        } catch (Exception e) {
            return "";
        } catch (UnsatisfiedLinkError e2) {
            return "";
        }
    }

    public static void b(Context context, Intent intent, String str, String str2) {
        intent.setFlags(32);
        try {
            if (!TextUtils.isEmpty(str)) {
                intent.setAction(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage(str2);
            }
            a(context, intent, str2);
        } catch (Exception e) {
        }
    }

    public static void b(final Context context, final boolean z) {
        if (context == null) {
            return;
        }
        try {
            PushClient.getInstance(context).initialize();
            PushClient.getInstance(context).turnOnPush(new IPushActionListener() { // from class: com.baidu.android.pushservice.i.m.2
                @Override // com.vivo.push.IPushActionListener
                public void onStateChanged(int i) {
                    if (i == 101) {
                        com.baidu.android.pushservice.f.b(context, 0);
                        if (z) {
                            return;
                        }
                        com.baidu.android.pushservice.a.a(context, true);
                        i.a(context, "vi_push_proxy_mode", 0);
                        com.baidu.android.pushservice.PushManager.enableVivoProxy(context, false);
                        m.a(context, true, true);
                    } else if (i != 0 && i != 1) {
                        com.baidu.android.pushservice.f.k(context);
                    } else {
                        i.a(context, "vi_push_proxy_mode", 1);
                        if (!z) {
                            m.a(context, true, false);
                            if (!com.baidu.android.pushservice.b.d.c(context)) {
                                com.baidu.android.pushservice.a.a(context, false);
                            }
                        }
                        String regId = PushClient.getInstance(context).getRegId();
                        if (TextUtils.isEmpty(regId)) {
                            com.baidu.android.pushservice.f.k(context);
                        } else {
                            com.baidu.android.pushservice.f.a(context, regId);
                        }
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    public static boolean b() {
        return Build.MANUFACTURER.toUpperCase().contains("XIAOMI");
    }

    public static boolean b(Context context) {
        String a2 = com.baidu.android.pushservice.a.a(context);
        if ("enabled".equals(a2)) {
            return false;
        }
        if ("disabled".equals(a2)) {
            return true;
        }
        return a(context, context.getPackageName(), "DisableService");
    }

    public static boolean b(Context context, PublicMsg publicMsg) {
        if (publicMsg != null) {
            String a2 = f.a((publicMsg.mAppId + publicMsg.mMsgId + publicMsg.mUrl + publicMsg.mDescription + publicMsg.mTitle + publicMsg.mOpenType).getBytes(), false);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            String b2 = com.baidu.android.pushservice.c.c.b(context, context.getPackageName(), publicMsg.mMsgId);
            return !TextUtils.isEmpty(b2) && b2.equals(a2);
        }
        return false;
    }

    public static boolean b(Context context, String str) {
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

    public static int c(Context context, String str) {
        PackageInfo a2 = a(context, str);
        if (a2 != null) {
            return a2.versionCode;
        }
        return 0;
    }

    public static String c(String str) {
        try {
            return new String(Base64.encode(BaiduAppSSOJni.encryptAES(str, 0), 2), "utf-8");
        } catch (Exception e) {
            return "";
        } catch (UnsatisfiedLinkError e2) {
            return "";
        }
    }

    public static void c(Context context) {
        a(context, 300000L);
    }

    public static void c(Context context, Intent intent, String str, String str2) {
        try {
            Uri data = intent.getData();
            if (data != null) {
                String r = r(context, data.toString());
                Intent intent2 = new Intent();
                String stringExtra = intent.getStringExtra("hwtitle");
                String stringExtra2 = intent.getStringExtra("hwcontent");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    intent2.putExtra("notification_title", stringExtra);
                    intent2.putExtra("notification_content", stringExtra2);
                }
                intent2.putExtra("extra_extra_custom_content", r);
                intent2.putExtra("proxy_mode", 5);
                intent2.putExtra("proxy_check_info", str);
                intent2.putExtra("proxy_sign_info", str2);
                b(context, intent2, "com.baidu.android.pushservice.action.notification.CLICK", context.getPackageName());
            }
        } catch (Exception e) {
        }
    }

    public static void c(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            MiPushClient.registerPush(context.getApplicationContext(), str, str2);
        } catch (Throwable th) {
        }
    }

    public static boolean c() {
        return Build.MANUFACTURER.toUpperCase().contains("MEIZU");
    }

    public static void d(Context context) {
        Intent a2 = l.a(context);
        a2.putExtra("method", "pushservice_quit");
        a2.setPackage(context.getPackageName());
        String b2 = b(context, context.getPackageName(), "com.baidu.android.pushservice.action.METHOD");
        if (!TextUtils.isEmpty(b2)) {
            a2.setClassName(context.getPackageName(), b2);
        }
        context.sendBroadcast(a2);
    }

    public static void d(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            com.meizu.cloud.pushsdk.PushManager.register(context.getApplicationContext(), str, str2);
        } catch (Exception e) {
        }
    }

    public static boolean d() {
        try {
            if (Build.MANUFACTURER.toUpperCase().contains("HUAWEI")) {
                if (!i()) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean d(Context context, String str) {
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

    public static boolean e() {
        return Build.MANUFACTURER.toUpperCase().contains(RomUtils.ROM_OPPO);
    }

    public static boolean e(Context context) {
        boolean z;
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
            String str = queryBroadcastReceivers.get(0).activityInfo.name;
            boolean z2 = queryBroadcastReceivers.get(0).activityInfo.enabled;
            if (!a(context, "com.baidu.android.pushservice.action.MESSAGE", str, true) || !a(context, "com.baidu.android.pushservice.action.RECEIVE", str, true)) {
                Log.e("BDPushSDK-Utility", str + " did not declared com.baidu.android.pushservice.action.MESSAGE or com.baidu.android.pushservice.action.RECEIVE");
                return false;
            }
            if (d() && PushSettings.j(context)) {
                if (!a(context, "com.huawei.intent.action.PUSH", str, true)) {
                    Log.e("BDPushSDK-Utility", str + " did not declared com.huawei.intent.action.PUSH");
                    return false;
                } else if (!a(context, "com.huawei.android.push.intent.RECEIVE", str, true)) {
                    Log.e("BDPushSDK-Utility", str + " did not declared com.huawei.android.push.intent.RECEIVE");
                    return false;
                } else if (!a(context, "com.huawei.android.push.intent.REGISTRATION", str, true)) {
                    Log.e("BDPushSDK-Utility", str + " did not declared com.huawei.android.push.intent.REGISTRATION");
                    return false;
                }
            } else if (b() && PushSettings.f(context)) {
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
            } else if (c() && PushSettings.g(context)) {
                if (!a(context, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true)) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.MzPushPatchMessageReceiver did not declared " + PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
                    return false;
                } else if (!a(context, PushConstants.MZ_PUSH_ON_REGISTER_ACTION, "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true)) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.MzPushPatchMessageReceiver did not declared " + PushConstants.MZ_PUSH_ON_REGISTER_ACTION);
                    return false;
                } else if (!a(context, PushConstants.MZ_PUSH_ON_UNREGISTER_ACTION, "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true)) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.MzPushPatchMessageReceiver did not declared " + PushConstants.MZ_PUSH_ON_UNREGISTER_ACTION);
                    return false;
                } else if (!r(context)) {
                    Log.e("BDPushSDK-Utility", "com.meizu.cloud.pushsdk.SystemReceiver did not declared com.meizu.cloud.pushservice.action.PUSH_SERVICE_START");
                    return false;
                }
            } else if ((e() || f() || g()) && PushSettings.h(context)) {
                if (!a(context, "com.coloros.mcs.action.RECEIVE_MCS_MESSAGE", "com.heytap.mcssdk.PushService", false)) {
                    Log.e("BDPushSDK-Utility", "com.heytap.mcssdk.PushService did not declared com.coloros.mcs.action.RECEIVE_MCS_MESSAGE");
                    return false;
                } else if (!a(context, "com.heytap.mcs.action.RECEIVE_MCS_MESSAGE", "com.heytap.mcssdk.AppPushService", false)) {
                    Log.e("BDPushSDK-Utility", "com.heytap.mcssdk.AppPushService did not declared com.heytap.mcs.action.RECEIVE_MCS_MESSAGE");
                    return false;
                }
            } else if (h() && PushSettings.i(context) && !a(context, "com.vivo.pushclient.action.RECEIVE", "com.baidu.android.pushservice.viproxy.ViPushMessageReceiver", true)) {
                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.viproxy.ViPushMessageReceiver did not declared com.vivo.pushclient.action.RECEIVE");
                return false;
            }
            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(context.getPackageName(), str));
            z = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z2);
            if (z) {
                return z;
            }
            try {
                Log.e("BDPushSDK-Utility", str + " is disable, please check!");
                return z;
            } catch (Exception e) {
                e = e;
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    public static boolean e(Context context, String str) {
        List<ResolveInfo> list;
        PackageManager packageManager;
        Intent intent = new Intent("com.baidu.android.pushservice.action.PUSH_SERVICE");
        intent.setPackage(str);
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
            list = null;
        }
        if (packageManager == null) {
            return false;
        }
        list = packageManager.queryIntentServices(intent, 576);
        return list != null && list.size() > 0;
    }

    public static String f(Context context) {
        String q = q(context);
        if (TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", q)) {
            String t = t(context);
            if (TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", t)) {
                String u = u(context);
                return (TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", u) || B(context)) ? "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK" : u;
            }
            return t;
        }
        return q;
    }

    public static String f(Context context, String str) {
        if (!PushSocket.a()) {
            Log.e("BDPushSDK-Utility", "check socket library failed");
            return "check socket library failed";
        }
        String f = f(context);
        if (!TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", f)) {
            Log.e("BDPushSDK-Utility", f);
            return f;
        } else if (!a(str)) {
            Log.e("BDPushSDK-Utility", "check Apikey failed");
            return "check Apikey failed";
        } else {
            if (!e(context)) {
                Log.e("BDPushSDK-Utility", "check SelfConfiged Receiver failed");
            }
            if (h()) {
                return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
            }
            if (!s(context) && !B(context)) {
                Log.e("BDPushSDK-Utility", "check CommandService Enable failed");
                return "check CommandService Enable failed";
            } else if (z(context)) {
                return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
            } else {
                Log.e("BDPushSDK-Utility", "check CommandService Enable failed");
                return "check CommandService Enable failed";
            }
        }
    }

    public static boolean f() {
        return Build.MANUFACTURER.toUpperCase().contains("ONEPLUS");
    }

    public static int g(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = -1;
        try {
            if (str.equals(context.getPackageName())) {
                i = com.baidu.android.pushservice.a.a();
            } else {
                i = com.baidu.android.pushservice.c.d.a(context, str);
                if (i == 0) {
                    i = 50;
                }
            }
            return i;
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
            return i;
        }
    }

    public static boolean g() {
        return Build.MANUFACTURER.toUpperCase().contains("REALME");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(Context context) {
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
            new b.c(context).a(Log.getStackTraceString(e)).a();
        }
        return false;
    }

    public static String h(Context context) {
        String deviceID = DeviceId.getDeviceID(context);
        return o(context) ? f.a(("com.baidu.pushservice.single_conn" + context.getPackageName() + "v3" + deviceID).getBytes(), false) : f.a(("com.baidu.pushservice.single_conn" + context.getPackageName() + "v2" + deviceID).getBytes(), false);
    }

    public static boolean h() {
        return Build.MANUFACTURER.toUpperCase().contains(RomUtils.ROM_VIVO);
    }

    public static boolean h(Context context, String str) {
        int[] b2;
        if (context == null || TextUtils.isEmpty(str) || (b2 = com.baidu.android.pushservice.c.a.b(context, str)) == null || 4 != b2.length) {
            return false;
        }
        return a(b2[0], b2[1], b2[2], b2[3]);
    }

    public static int i(Context context) {
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

    public static int i(Context context, String str) {
        try {
            return (int) Long.parseLong(str);
        } catch (Exception e) {
            try {
                if (str.length() > 0) {
                    str = str.substring(1);
                }
                return (int) Long.parseLong(str);
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return 0;
            }
        }
    }

    public static boolean i() {
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

    public static boolean j() {
        return Build.MANUFACTURER.toUpperCase().contains("SAMSUNG");
    }

    public static synchronized boolean j(Context context) {
        boolean z;
        synchronized (m.class) {
            if (f1427a == -1) {
                try {
                    f1427a = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).getBoolean("bind_status", false) ? 1 : 0;
                } catch (Exception e) {
                }
            }
            z = f1427a == 1;
        }
        return z;
    }

    public static boolean j(Context context, String str) {
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

    public static void k(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("com.huawei.android.push.intent.REGISTER");
        intent.putExtra("pkg_name", applicationContext.getPackageName());
        intent.putExtra("is_hms", true);
        intent.setFlags(32);
        applicationContext.sendBroadcast(intent);
    }

    public static boolean k() {
        return Build.MANUFACTURER.toUpperCase().contains(RomUtils.ROM_GIONEE);
    }

    public static boolean k(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
            return false;
        }
    }

    public static void l(Context context) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.METHOD");
        intent.putExtra("method", "com.baidu.android.pushservice.action.SEND_APPSTAT");
        com.baidu.android.pushservice.i.a(context.getApplicationContext()).a(intent);
    }

    public static boolean l() {
        return Build.MANUFACTURER.toUpperCase().contains(RomUtils.ROM_NUBIA);
    }

    public static boolean l(Context context, String str) {
        boolean z;
        boolean z2;
        try {
        } catch (Exception e) {
            e = e;
            z = false;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        z = com.baidu.android.pushservice.c.a.a(context, str);
        try {
            z2 = j(context, str);
        } catch (Exception e2) {
            e = e2;
            new b.c(context).a(Log.getStackTraceString(e)).a();
            z2 = false;
            return z ? false : false;
        }
        if (z && z2) {
            return true;
        }
    }

    public static int m(Context context, String str) {
        try {
            PackageInfo a2 = a(context, str);
            if (a2 != null) {
                return a2.applicationInfo.targetSdkVersion;
            }
            return 0;
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
            return 0;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00af -> B:46:0x0022). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00bd -> B:46:0x0022). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d4 -> B:46:0x0022). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00e2 -> B:46:0x0022). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e7 -> B:46:0x0022). Please submit an issue!!! */
    public static String m(Context context) {
        String str;
        String str2 = "";
        String upperCase = Build.MANUFACTURER.toUpperCase();
        if (upperCase.contains("XIAOMI")) {
            str2 = RomUtils.PROP_RO_BUILD_VERSION_INCREMENTAL;
        } else if (upperCase.contains("HUAWEI")) {
            str2 = "ro.build.version.emui";
        } else if (upperCase.contains("MEIZU")) {
            return Build.DISPLAY;
        } else {
            if (upperCase.contains(RomUtils.ROM_OPPO) || upperCase.contains("REALME")) {
                str2 = "ro.build.version.opporom";
            } else if (upperCase.contains(RomUtils.ROM_VIVO)) {
                str2 = "ro.vivo.os.version";
            } else if (upperCase.contains("ONEPLUS")) {
                str2 = "ro.rom.version";
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
            new b.c(context).a(Log.getStackTraceString(th)).a();
            str = (Build.VERSION.SDK_INT < 21 || !upperCase.contains("HUAWEI")) ? upperCase.contains("XIAOMI") ? "MIUI_notfound" : (upperCase.contains(RomUtils.ROM_OPPO) || upperCase.contains("REALME")) ? "ColorOS_notfound" : upperCase.contains(RomUtils.ROM_VIVO) ? "FuntouchOS_notfound" : "" : "EmotionUI_notfound";
        }
        return str;
    }

    public static boolean m() {
        return l();
    }

    public static String n(Context context) {
        Throwable th;
        String str;
        String str2 = "";
        if (!n()) {
            return "";
        }
        String str3 = "";
        String upperCase = Build.MANUFACTURER.toUpperCase();
        if (upperCase.contains("XIAOMI")) {
            str3 = "ro.miui.ui.version.code";
        } else if (upperCase.contains("HUAWEI")) {
            str3 = "ro.build.version.emui";
        } else if (upperCase.contains("MEIZU")) {
            str3 = RomUtils.PROP_RO_BUILD_DISPLAY_ID;
        } else if (upperCase.contains(RomUtils.ROM_OPPO) || upperCase.contains("REALME")) {
            str3 = "ro.build.version.opporom";
        } else if (upperCase.contains(RomUtils.ROM_VIVO)) {
            str3 = "ro.vivo.os.version";
        } else if (upperCase.contains("ONEPLUS")) {
            str3 = "ro.rom.version";
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str = SystemProperties.get(str3);
            } else {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str3);
            }
            if (upperCase.contains("HUAWEI") && !TextUtils.isEmpty(str)) {
                String substring = str.substring(str.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, str.length());
                if (!substring.matches("\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21) {
                    substring = Constants.SDK_VER;
                }
                return substring;
            } else if (upperCase.contains("MEIZU")) {
                String str4 = TextUtils.isEmpty(str) ? Build.DISPLAY : str;
                try {
                    Matcher matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(str4);
                    if (matcher.find()) {
                        str4 = matcher.group();
                    }
                    return str4;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = str4;
                    new b.c(context).a(Log.getStackTraceString(th)).a();
                    return (Build.VERSION.SDK_INT < 21 || !upperCase.contains("HUAWEI")) ? upperCase.contains("HUAWEI") ? "1.0" : upperCase.contains("XIAOMI") ? "4.0" : upperCase.contains("MEIZU") ? "6.0" : (upperCase.contains(RomUtils.ROM_OPPO) || upperCase.contains("REALME")) ? "3.0" : upperCase.contains(RomUtils.ROM_VIVO) ? "3.2" : str2 : Constants.SDK_VER;
                }
            } else if ((upperCase.contains(RomUtils.ROM_OPPO) || upperCase.contains("REALME")) && !TextUtils.isEmpty(str)) {
                Matcher matcher2 = Pattern.compile("^V(\\d+\\.\\d+)").matcher(str);
                return matcher2.find() ? matcher2.group(1) : str;
            } else if (upperCase.contains(RomUtils.ROM_VIVO) && !TextUtils.isEmpty(str)) {
                Matcher matcher3 = Pattern.compile("^\\d+(\\.\\d+)?").matcher(str);
                return matcher3.find() ? matcher3.group() : str;
            } else if (!upperCase.contains("ONEPLUS") || TextUtils.isEmpty(str)) {
                return str;
            } else {
                Matcher matcher4 = Pattern.compile("\\d+(\\.\\d+)?").matcher(str);
                return matcher4.find() ? matcher4.group() : str;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String n(Context context, String str) {
        String str2;
        if (context == null) {
            return null;
        }
        try {
            String e = com.baidu.android.pushservice.c.c.e(context);
            if (!TextUtils.isEmpty(e)) {
                ArrayList<com.baidu.android.pushservice.a.e> c2 = com.baidu.android.pushservice.a.b.a(context).c(b(e));
                if (c2 != null) {
                    Iterator<com.baidu.android.pushservice.a.e> it = c2.iterator();
                    while (it.hasNext()) {
                        com.baidu.android.pushservice.a.e next = it.next();
                        if (next.b().equals(str)) {
                            str2 = next.a();
                            break;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        }
        str2 = null;
        return str2;
    }

    public static boolean n() {
        return d() || e() || h() || b() || c() || f() || g();
    }

    public static int o(Context context, String str) {
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
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return i;
            }
        } while (indexOf != -1);
        return i > 0 ? i - "#Intent;".length() : i;
    }

    public static boolean o(Context context) {
        PackageInfo a2;
        try {
            if (Build.VERSION.SDK_INT >= 24 && (a2 = a(context, context.getPackageName())) != null) {
                if (a2.applicationInfo.targetSdkVersion >= 24) {
                    return true;
                }
            }
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
        }
        return false;
    }

    public static int p(Context context, String str) {
        try {
            String d = com.baidu.android.pushservice.c.c.d(context);
            if (!TextUtils.isEmpty(d)) {
                ArrayList<com.baidu.android.pushservice.a.e> c2 = com.baidu.android.pushservice.a.b.a(context).c(b(d));
                if (c2 != null) {
                    Iterator<com.baidu.android.pushservice.a.e> it = c2.iterator();
                    while (it.hasNext()) {
                        com.baidu.android.pushservice.a.e next = it.next();
                        if (TextUtils.equals(next.b(), str)) {
                            return next.c();
                        }
                    }
                }
            }
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
        }
        return 0;
    }

    public static boolean p(Context context) {
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

    public static Bitmap q(Context context, String str) {
        Bitmap bitmap;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            InputStream inputStream = httpURLConnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            try {
                inputStream.close();
            } catch (Exception e) {
                e = e;
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return bitmap;
            }
        } catch (Exception e2) {
            e = e2;
            bitmap = null;
        }
        return bitmap;
    }

    private static String q(Context context) {
        String str;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    if (!a(context, packageManager, strArr)) {
                        if (!a(context, strArr)) {
                            String[] strArr2 = f1428b;
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

    private static String r(Context context, String str) {
        String str2 = null;
        try {
            if (!TextUtils.isEmpty(str) && str.contains("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=")) {
                if (str.contains("bdpush_hwsigninfo")) {
                    int o = o(context, str);
                    if (o > 0) {
                        str2 = str.substring("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=".length(), o);
                    }
                } else {
                    str2 = str.substring("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=".length(), str.length());
                }
            }
        } catch (Exception e) {
        }
        return str2;
    }

    private static boolean r(Context context) {
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

    private static boolean s(Context context) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.baidu.android.pushservice.CommandService"), 128);
            if (TextUtils.isEmpty(serviceInfo.name)) {
                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.CommandService did not declared ");
                return false;
            }
            if (!serviceInfo.exported) {
                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.CommandService  exported declared wrong");
            }
            return true;
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
            return false;
        }
    }

    private static String t(Context context) {
        if (!a(context, "com.baidu.android.pushservice.action.notification.SHOW", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared com.baidu.android.pushservice.action.notification.SHOW");
            return "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared com.baidu.android.pushservice.action.notification.SHOW";
        } else if (!a(context, "android.net.conn.CONNECTIVITY_CHANGE", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared android.net.conn.CONNECTIVITY_CHANGE");
            return "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared android.net.conn.CONNECTIVITY_CHANGE";
        } else if (a(context, "com.baidu.android.pushservice.action.METHOD", "com.baidu.android.pushservice.RegistrationReceiver", true)) {
            return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
        } else {
            Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.RegistrationReceiver is not exist or did not declared com.baidu.android.pushservice.action.METHOD");
            return "com.baidu.android.pushservice.RegistrationReceiver is not exist or did not declared com.baidu.android.pushservice.action.METHOD";
        }
    }

    private static String u(Context context) {
        if (v(context)) {
            Log.e("BDPushSDK-Utility", "xiaomi service is not found or wrong  declared, please check!");
            return "xiaomi service is not found or wrong  declared, please check!";
        } else if (x(context)) {
            Log.e("BDPushSDK-Utility", "oppo service is not found or wrong  declared, please check!");
            return "oppo service is not found or wrong  declared, please check!";
        } else if (w(context)) {
            Log.e("BDPushSDK-Utility", "meizu service is not found or wrong  declared, please check!");
            return "meizu service is not found or wrong  declared, please check!";
        } else if (!y(context)) {
            return a(context, "com.baidu.android.pushservice.action.PUSH_SERVICE", "com.baidu.android.pushservice.PushService", false) ? "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK" : "com.baidu.android.pushservice.PushService is not exist or did not declared com.baidu.android.pushservice.action.PUSH_SERVICE";
        } else {
            Log.e("BDPushSDK-Utility", "vivo service is not found or wrong  declared, please check!");
            return "vivo service is not found or wrong  declared, please check!";
        }
    }

    private static boolean v(Context context) {
        try {
            if (b() && PushSettings.f(context)) {
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

    private static boolean w(Context context) {
        try {
            if (c() && PushSettings.g(context)) {
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

    private static boolean x(Context context) {
        try {
            if ((e() || f() || g()) && PushSettings.h(context)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    boolean z = false;
                    boolean z2 = false;
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        if (serviceInfo.name.equals("com.heytap.mcssdk.PushService")) {
                            z2 = true;
                        }
                        if (serviceInfo.name.equals("com.heytap.mcssdk.AppPushService")) {
                            z = true;
                        }
                    }
                    return (z2 && z) ? false : true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private static boolean y(Context context) {
        try {
            if (h() && PushSettings.i(context)) {
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

    private static boolean z(Context context) {
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
            new b.c(context).a(Log.getStackTraceString(e)).a();
            return false;
        }
    }
}
