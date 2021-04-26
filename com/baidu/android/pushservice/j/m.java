package com.baidu.android.pushservice.j;

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
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.down.utils.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.callback.PushCallback;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
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
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static int f3466a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f3467b = {"android.permission.INTERNET", DefaultConnectivityMonitorFactory.NETWORK_PERMISSION};

    /* renamed from: c  reason: collision with root package name */
    public static int f3468c = -1;

    public static boolean A(Context context) {
        if (f3468c == -1) {
            f3468c = !k(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) ? 1 : 0;
        }
        return f3468c == 0;
    }

    public static boolean B(Context context) {
        try {
            String str = Build.DISPLAY;
            if (TextUtils.isEmpty(str) || !str.contains("VIBEUI_V3.1_1614_5.294.1_ST_K50-T5")) {
                String str2 = Build.MODEL;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (!str2.contains("Lenovo K50-t5") && !str2.contains("Lenovo_K50-t5") && !str2.contains("Lenovo X3c50")) {
                    if (!str2.contains("Lenovo_X3c50")) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return false;
        }
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
            return null;
        } catch (Exception unused) {
            return null;
        }
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
            } catch (IOException unused) {
                com.baidu.android.pushservice.e.c.a(context, inputStream, inputStreamReader, bufferedReader);
            } catch (Throwable th) {
                com.baidu.android.pushservice.e.c.a(context, inputStream, inputStreamReader, bufferedReader);
                throw th;
            }
        }
        com.baidu.android.pushservice.e.c.a(context, inputStream, inputStreamReader, bufferedReader);
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
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, Label.FORWARD_REFERENCE_TYPE_SHORT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        alarmManager.cancel(broadcast);
        alarmManager.set(3, SystemClock.elapsedRealtime() + j, broadcast);
    }

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
            String stringExtra = intent.getStringExtra("message_id");
            a(stringExtra + " sendBroadcast to recevier=" + b2, context);
        }
    }

    public static void a(Context context, String str, int i2) {
        if (context == null) {
            return;
        }
        Intent a2 = l.a(context);
        a2.putExtra("method", "com.baidu.android.pushservice.action.SEND_ACK");
        a2.putExtra("bd.cross.request.RESULT_CODE", i2);
        a2.putExtra("message_id", str);
        a2.setPackage(context.getPackageName());
        String b2 = b(context, context.getPackageName(), "com.baidu.android.pushservice.action.METHOD");
        if (!TextUtils.isEmpty(b2)) {
            a2.setClassName(context.getPackageName(), b2);
        }
        context.sendBroadcast(a2);
    }

    public static void a(Context context, String str, String str2, Intent intent) {
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
            String stringExtra = intent.getStringExtra("message_id");
            a(stringExtra + " reflectrecevier=" + str2, context);
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        }
    }

    public static void a(Context context, String str, String str2, PushCallback pushCallback) {
        if (context == null) {
            return;
        }
        try {
            PushManager.getInstance().register(context.getApplicationContext(), str, str2, pushCallback);
        } catch (Exception unused) {
        }
    }

    public static synchronized void a(Context context, boolean z) {
        synchronized (m.class) {
            try {
                f3466a = z ? 1 : 0;
                SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
                edit.putBoolean("bind_status", z);
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public static void a(final Context context, boolean z, boolean z2) {
        com.baidu.android.pushservice.g.a.a("Utility", context.getPackageName() + ": updateServiceInfo isForce = " + z + ",isSend = " + z2, context.getApplicationContext());
        if (z) {
            com.baidu.android.pushservice.c.c.a(context, 0L);
            com.baidu.android.pushservice.c.c.b(context, com.baidu.android.pushservice.a.a());
        }
        if (z2) {
            new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.android.pushservice.j.m.1
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
        File[] listFiles;
        synchronized (m.class) {
            if (A(context)) {
                if (PushSettings.o(context)) {
                    FileWriter fileWriter = null;
                    try {
                        String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " " + str + "\n\r";
                        String absolutePath = context.getExternalFilesDir("").getAbsolutePath();
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
                                if (name.startsWith("msg") && name.length() > 0 && ((int) Math.abs((simpleDateFormat.parse(name.substring(3, 11)).getTime() - date.getTime()) / 86400000)) >= 7) {
                                    file3.delete();
                                }
                            }
                            file2.createNewFile();
                        }
                        if (file2.exists()) {
                            FileWriter fileWriter2 = new FileWriter(file2, true);
                            try {
                                fileWriter2.write(str2);
                                fileWriter = fileWriter2;
                            } catch (Throwable th) {
                                th = th;
                                fileWriter = fileWriter2;
                                new b.c(context).a(Log.getStackTraceString(th)).a();
                                com.baidu.android.pushservice.e.c.a(context, fileWriter);
                            }
                        }
                        com.baidu.android.pushservice.e.c.a(context, fileWriter);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
    }

    public static boolean a(int i2, int i3, int i4, int i5) {
        int i6 = Calendar.getInstance(Locale.CHINA).get(11);
        int i7 = Calendar.getInstance(Locale.CHINA).get(12);
        if (i2 < i4) {
            if (i2 >= i6 || i6 >= i4) {
                if (i6 != i2 || i7 < i3) {
                    return i6 == i4 && i7 <= i5;
                }
                return true;
            }
            return true;
        } else if (i2 <= i4) {
            return i2 == i6 && i7 >= i3 && i5 >= i7;
        } else if ((i6 <= i2 || i6 >= 24) && i6 >= i4) {
            if (i6 != i2 || i7 < i3) {
                return i6 == i4 && i7 <= i5;
            }
            return true;
        } else {
            return true;
        }
    }

    public static boolean a(Context context, PackageManager packageManager, String[] strArr) {
        if (b() && PushSettings.g(context)) {
            try {
                String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
                if (!a(str, strArr)) {
                    com.baidu.android.pushservice.g.a.b("Utility", "the permission [ " + str + " ] for xiaomi proxy need is not exist, please check!", context);
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
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(Context context, PublicMsg publicMsg) {
        return com.baidu.android.pushservice.c.c.a(context, new com.baidu.android.pushservice.c.f(publicMsg.mMsgId, f.a((publicMsg.mAppId + publicMsg.mMsgId + publicMsg.mUrl + publicMsg.mDescription + publicMsg.mTitle + publicMsg.mOpenType).getBytes(), false), publicMsg.mAppId));
    }

    public static boolean a(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        PackageManager packageManager;
        try {
            packageManager = context.getPackageManager();
        } catch (Exception unused) {
            applicationInfo = null;
        }
        if (packageManager == null) {
            return false;
        }
        applicationInfo = packageManager.getApplicationInfo(str, 128);
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(str2)) {
            return false;
        }
        return applicationInfo.metaData.getBoolean(str2);
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4, String str5) {
        String d2 = PushSettings.d(context);
        if (!TextUtils.isEmpty(d2)) {
            str2 = d2;
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

    public static boolean a(Context context, String str, String str2, boolean z) {
        PackageManager packageManager;
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.b("Utility", "error  " + e2.getMessage(), context);
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        }
        if (packageManager == null) {
            return false;
        }
        if (z) {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
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
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
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
        if (bArr != null && str != null && str2 != null && bArr2 != null) {
            try {
                if (TextUtils.equals(f.a(a(a(str.getBytes(), str2.getBytes()), bArr2), false), new String(k.b(bArr, BaiduAppSSOJni.getPrivateKey(0))))) {
                    return true;
                }
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            } catch (UnsatisfiedLinkError e3) {
                new b.c(context).a(Log.getStackTraceString(e3)).a();
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context, byte[] bArr, String str, byte[] bArr2) {
        if (bArr == null || str == null || bArr2 == null) {
            return false;
        }
        String str2 = new String(bArr);
        return com.baidu.android.pushservice.f.a(context, str2, str + new String(bArr2));
    }

    public static boolean a(Context context, String[] strArr) {
        if ((e() || f() || g()) && PushSettings.i(context)) {
            try {
                if (a("com.coloros.mcs.permission.RECIEVE_MCS_MESSAGE", strArr)) {
                    return !a("com.heytap.mcs.permission.RECIEVE_MCS_MESSAGE", strArr);
                }
                return true;
            } catch (Exception unused) {
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

    public static boolean a(String str, String[] strArr) {
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
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            list = null;
        }
        if (packageManager == null) {
            return null;
        }
        list = packageManager.queryBroadcastReceivers(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0).activityInfo.name;
    }

    public static String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            byte[] decode = Base64.decode(str.getBytes(), 2);
            return new String(BaiduAppSSOJni.decryptAES(decode, decode.length, 0), "utf-8");
        } catch (Exception | UnsatisfiedLinkError unused) {
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
        } catch (Exception unused) {
        }
    }

    public static void b(final Context context, final boolean z) {
        if (context == null) {
            return;
        }
        try {
            PushClient.getInstance(context).initialize();
            PushClient.getInstance(context).turnOnPush(new IPushActionListener() { // from class: com.baidu.android.pushservice.j.m.2
                @Override // com.vivo.push.IPushActionListener
                public void onStateChanged(int i2) {
                    if (i2 == 101) {
                        com.baidu.android.pushservice.f.b(context, 0);
                        if (z) {
                            return;
                        }
                        com.baidu.android.pushservice.a.a(context, true);
                        i.a(context, "vi_push_proxy_mode", 0);
                        com.baidu.android.pushservice.PushManager.enableVivoProxy(context, false);
                        m.a(context, true, true);
                        return;
                    }
                    if (i2 == 0 || i2 == 1) {
                        i.a(context, "vi_push_proxy_mode", 1);
                        if (!z && !com.baidu.android.pushservice.b.d.c(context)) {
                            com.baidu.android.pushservice.a.a(context, false);
                        }
                        String regId = PushClient.getInstance(context).getRegId();
                        if (!TextUtils.isEmpty(regId)) {
                            com.baidu.android.pushservice.f.a(context, regId);
                            return;
                        }
                    }
                    com.baidu.android.pushservice.f.k(context);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static boolean b() {
        try {
            return Build.MANUFACTURER.toUpperCase().contains("XIAOMI");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        String a2 = com.baidu.android.pushservice.a.a(context);
        if (SapiOptions.KEY_CACHE_ENABLED.equals(a2)) {
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
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
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
        } catch (Exception | UnsatisfiedLinkError unused) {
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
                com.baidu.android.pushservice.frequency.b.a().a(context, false, 1, r);
                b(context, intent2, "com.baidu.android.pushservice.action.notification.CLICK", context.getPackageName());
            }
        } catch (Exception unused) {
        }
    }

    public static void c(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            MiPushClient.registerPush(context.getApplicationContext(), str, str2);
        } catch (Throwable unused) {
        }
    }

    public static boolean c() {
        try {
            return Build.MANUFACTURER.toUpperCase().contains("MEIZU");
        } catch (Exception unused) {
            return false;
        }
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
        } catch (Exception unused) {
        }
    }

    public static boolean d() {
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            if (upperCase.contains("HUAWEI") || upperCase.contains("HONOR")) {
                return !i();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        PackageManager packageManager;
        try {
            packageManager = context.getPackageManager();
        } catch (Exception unused) {
            applicationInfo = null;
        }
        if (packageManager == null) {
            return false;
        }
        applicationInfo = packageManager.getApplicationInfo(str, 128);
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return false;
        }
        return bundle.getBoolean("IsBaiduApp");
    }

    public static boolean d(String str) {
        return (str == null || str.isEmpty() || !str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$")) ? false : true;
    }

    public static boolean e() {
        try {
            return Build.MANUFACTURER.toUpperCase().contains("OPPO");
        } catch (Exception unused) {
            return false;
        }
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
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
            if (queryBroadcastReceivers.size() < 1) {
                return false;
            }
            String str = queryBroadcastReceivers.get(0).activityInfo.name;
            boolean z2 = queryBroadcastReceivers.get(0).activityInfo.enabled;
            if (a(context, "com.baidu.android.pushservice.action.MESSAGE", str, true)) {
                try {
                    if (a(context, "com.baidu.android.pushservice.action.RECEIVE", str, true)) {
                        if (d() && PushSettings.k(context)) {
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
                        } else if (b() && PushSettings.g(context)) {
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
                        } else if (c() && PushSettings.h(context)) {
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
                        } else if ((e() || f() || g()) && PushSettings.i(context)) {
                            if (!a(context, "com.coloros.mcs.action.RECEIVE_MCS_MESSAGE", "com.heytap.mcssdk.PushService", false)) {
                                Log.e("BDPushSDK-Utility", "com.heytap.mcssdk.PushService did not declared com.coloros.mcs.action.RECEIVE_MCS_MESSAGE");
                                return false;
                            } else if (!a(context, "com.heytap.mcs.action.RECEIVE_MCS_MESSAGE", "com.heytap.mcssdk.AppPushService", false)) {
                                Log.e("BDPushSDK-Utility", "com.heytap.mcssdk.AppPushService did not declared com.heytap.mcs.action.RECEIVE_MCS_MESSAGE");
                                return false;
                            }
                        } else if (h() && PushSettings.j(context) && !a(context, "com.vivo.pushclient.action.RECEIVE", "com.baidu.android.pushservice.viproxy.ViPushMessageReceiver", true)) {
                            Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.viproxy.ViPushMessageReceiver did not declared com.vivo.pushclient.action.RECEIVE");
                            return false;
                        }
                        int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(context.getPackageName(), str));
                        boolean z3 = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z2);
                        if (z3) {
                            return z3;
                        }
                        try {
                            Log.e("BDPushSDK-Utility", str + " is disable, please check!");
                            return z3;
                        } catch (Exception e2) {
                            e = e2;
                            z = z3;
                            new b.c(context).a(Log.getStackTraceString(e)).a();
                            return z;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    z = false;
                    new b.c(context).a(Log.getStackTraceString(e)).a();
                    return z;
                }
            }
            Log.e("BDPushSDK-Utility", str + " did not declared com.baidu.android.pushservice.action.MESSAGE or com.baidu.android.pushservice.action.RECEIVE");
            return false;
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static boolean e(Context context, String str) {
        List<ResolveInfo> list;
        PackageManager packageManager;
        Intent intent = new Intent("com.baidu.android.pushservice.action.PUSH_SERVICE");
        intent.setPackage(str);
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            list = null;
        }
        if (packageManager == null) {
            return false;
        }
        list = packageManager.queryIntentServices(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
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
        String str2;
        if (PushSocket.a()) {
            String f2 = f(context);
            if (!TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", f2)) {
                Log.e("BDPushSDK-Utility", f2);
                return f2;
            } else if (a(str)) {
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
            } else {
                str2 = "check Apikey failed";
            }
        } else {
            str2 = "check socket library failed";
        }
        Log.e("BDPushSDK-Utility", str2);
        return str2;
    }

    public static boolean f() {
        try {
            return Build.MANUFACTURER.toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS);
        } catch (Exception unused) {
            return false;
        }
    }

    public static int g(Context context, String str) {
        int a2;
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (str.equals(context.getPackageName())) {
                a2 = com.baidu.android.pushservice.a.a();
            } else {
                a2 = com.baidu.android.pushservice.c.d.a(context, str);
                if (a2 == 0) {
                    return 50;
                }
            }
            return a2;
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return -1;
        }
    }

    public static boolean g() {
        try {
            return Build.MANUFACTURER.toUpperCase().contains("REALME");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean g(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
            if (packageInfo.services != null) {
                boolean z = false;
                for (ServiceInfo serviceInfo : packageInfo.services) {
                    if (serviceInfo.name.equals("com.baidu.android.pushservice.job.PushJobService")) {
                        z = true;
                    }
                }
                return !z;
            }
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        }
        return false;
    }

    public static String h(Context context) {
        String deviceID = DeviceId.getDeviceID(context);
        if (o(context)) {
            return f.a(("com.baidu.pushservice.single_conn" + context.getPackageName() + "v3" + deviceID).getBytes(), false);
        }
        return f.a(("com.baidu.pushservice.single_conn" + context.getPackageName() + DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX + deviceID).getBytes(), false);
    }

    public static boolean h() {
        try {
            return Build.MANUFACTURER.toUpperCase().contains("VIVO");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean h(Context context, String str) {
        int[] b2;
        if (context == null || TextUtils.isEmpty(str) || (b2 = com.baidu.android.pushservice.c.a.b(context, str)) == null || 4 != b2.length) {
            return false;
        }
        return a(b2[0], b2[1], b2[2], b2[3]);
    }

    public static int i(Context context, String str) {
        long parseLong;
        try {
            parseLong = Long.parseLong(str);
        } catch (Exception e2) {
            try {
                if (str.length() > 0) {
                    str = str.substring(1);
                }
                parseLong = Long.parseLong(str);
            } catch (Exception unused) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return 0;
            }
        }
        return (int) parseLong;
    }

    public static boolean i() {
        try {
            String upperCase = Build.MODEL.toUpperCase();
            if (TextUtils.isEmpty(upperCase)) {
                return false;
            }
            return upperCase.contains("NEXUS");
        } catch (Exception unused) {
            return false;
        }
    }

    public static synchronized boolean i(Context context) {
        boolean z;
        synchronized (m.class) {
            if (f3466a == -1) {
                try {
                    f3466a = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).getBoolean("bind_status", false) ? 1 : 0;
                } catch (Exception unused) {
                }
            }
            z = f3466a == 1;
        }
        return z;
    }

    public static void j(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("com.huawei.android.push.intent.REGISTER");
        intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, applicationContext.getPackageName());
        intent.putExtra("is_hms", true);
        intent.setFlags(32);
        applicationContext.sendBroadcast(intent);
    }

    public static boolean j() {
        try {
            return Build.MANUFACTURER.toUpperCase().contains("SAMSUNG");
        } catch (Exception unused) {
            return false;
        }
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
        Intent intent = new Intent("com.baidu.android.pushservice.action.METHOD");
        intent.putExtra("method", "com.baidu.android.pushservice.action.SEND_APPSTAT");
        com.baidu.android.pushservice.i.a(context.getApplicationContext()).a(intent);
    }

    public static boolean k() {
        try {
            return Build.MANUFACTURER.toUpperCase().contains(RomUtils.ROM_GIONEE);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean k(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return false;
        }
    }

    public static String l(Context context) {
        String str;
        String upperCase = Build.MANUFACTURER.toUpperCase();
        if (upperCase.contains("XIAOMI")) {
            str = RomUtils.PROP_RO_BUILD_VERSION_INCREMENTAL;
        } else if (upperCase.contains("HUAWEI") || upperCase.contains("HONOR")) {
            str = "ro.build.version.emui";
        } else if (upperCase.contains("MEIZU")) {
            return Build.DISPLAY;
        } else {
            str = (upperCase.contains("OPPO") || upperCase.contains("REALME")) ? "ro.build.version.opporom" : upperCase.contains("VIVO") ? "ro.vivo.os.version" : upperCase.contains(RomTypeUtil.ROM_ONEPLUS) ? "ro.rom.version" : "";
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return SystemProperties.get(str);
            }
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Throwable th) {
            new b.c(context).a(Log.getStackTraceString(th)).a();
            return (Build.VERSION.SDK_INT < 21 || !(upperCase.contains("HUAWEI") || upperCase.contains("HONOR"))) ? upperCase.contains("XIAOMI") ? "MIUI_notfound" : (upperCase.contains("OPPO") || upperCase.contains("REALME")) ? "ColorOS_notfound" : upperCase.contains("VIVO") ? "FuntouchOS_notfound" : "" : "EmotionUI_notfound";
        }
    }

    public static boolean l() {
        try {
            return Build.MANUFACTURER.toUpperCase().contains(RomUtils.ROM_NUBIA);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean l(Context context, String str) {
        boolean z;
        boolean z2;
        try {
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        z = com.baidu.android.pushservice.c.a.a(context, str);
        try {
            z2 = j(context, str);
        } catch (Exception e3) {
            e = e3;
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
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return 0;
        }
    }

    public static String m(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static boolean m() {
        return l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e2, code lost:
        if (r0.find() != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String n(Context context) {
        String str;
        String substring;
        Matcher matcher;
        String str2 = "";
        if (n()) {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            String str3 = upperCase.contains("XIAOMI") ? "ro.miui.ui.version.code" : (upperCase.contains("HUAWEI") || upperCase.contains("HONOR")) ? "ro.build.version.emui" : upperCase.contains("MEIZU") ? "ro.build.display.id" : (upperCase.contains("OPPO") || upperCase.contains("REALME")) ? "ro.build.version.opporom" : upperCase.contains("VIVO") ? "ro.vivo.os.version" : upperCase.contains(RomTypeUtil.ROM_ONEPLUS) ? "ro.rom.version" : "";
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    str = SystemProperties.get(str3);
                } else {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str3);
                }
                str2 = str;
                if ((upperCase.contains("HUAWEI") || upperCase.contains("HONOR")) && !TextUtils.isEmpty(str2)) {
                    substring = str2.substring(str2.indexOf("_") + 1, str2.length());
                    if (!substring.matches("\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21) {
                        return Constants.SDK_VER;
                    }
                } else {
                    if (upperCase.contains("MEIZU")) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = Build.DISPLAY;
                        }
                        matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(str2);
                    } else if ((upperCase.contains("OPPO") || upperCase.contains("REALME")) && !TextUtils.isEmpty(str2)) {
                        Matcher matcher2 = Pattern.compile("^V(\\d+\\.?\\d*)").matcher(str2);
                        if (matcher2.find()) {
                            str2 = matcher2.group(1);
                        }
                    } else if (upperCase.contains("VIVO") && !TextUtils.isEmpty(str2)) {
                        matcher = Pattern.compile("^\\d+(\\.\\d+)?").matcher(str2);
                        if (matcher.find()) {
                        }
                    } else if (upperCase.contains(RomTypeUtil.ROM_ONEPLUS) && !TextUtils.isEmpty(str2)) {
                        Matcher matcher3 = Pattern.compile("\\d+(\\.\\d+)?").matcher(str2);
                        if (matcher3.find()) {
                            substring = matcher3.group();
                        }
                    }
                    str2 = matcher.group();
                }
                return substring;
            } catch (Throwable th) {
                new b.c(context).a(Log.getStackTraceString(th)).a();
                if (Build.VERSION.SDK_INT >= 21 && (upperCase.contains("HUAWEI") || upperCase.contains("HONOR"))) {
                    return Constants.SDK_VER;
                }
                if (upperCase.contains("HUAWEI") || upperCase.contains("HONOR")) {
                    return "1.0";
                }
                if (upperCase.contains("XIAOMI")) {
                    return "4.0";
                }
                if (upperCase.contains("MEIZU")) {
                    return "6.0";
                }
                if (upperCase.contains("OPPO") || upperCase.contains("REALME")) {
                    return "3.0";
                }
                if (upperCase.contains("VIVO")) {
                    return "3.2";
                }
            }
        }
        return str2;
    }

    public static String n(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            String e2 = com.baidu.android.pushservice.c.c.e(context);
            if (TextUtils.isEmpty(e2)) {
                return null;
            }
            ArrayList<com.baidu.android.pushservice.a.e> c2 = com.baidu.android.pushservice.a.b.a(context).c(b(e2));
            if (c2 != null) {
                Iterator<com.baidu.android.pushservice.a.e> it = c2.iterator();
                while (it.hasNext()) {
                    com.baidu.android.pushservice.a.e next = it.next();
                    if (next.b().equals(str)) {
                        return next.a();
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e3) {
            new b.c(context).a(Log.getStackTraceString(e3)).a();
            return null;
        }
    }

    public static boolean n() {
        return d() || e() || h() || b() || c() || f() || g();
    }

    public static int o(Context context, String str) {
        int indexOf;
        int i2 = 0;
        do {
            try {
                indexOf = str.indexOf("#Intent;");
                if (indexOf != -1) {
                    int i3 = indexOf + 8;
                    i2 += i3;
                    str = str.substring(i3);
                    continue;
                }
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return i2;
            }
        } while (indexOf != -1);
        return i2 > 0 ? i2 - 8 : i2;
    }

    public static boolean o(Context context) {
        PackageInfo a2;
        try {
            if (Build.VERSION.SDK_INT < 24 || (a2 = a(context, context.getPackageName())) == null) {
                return false;
            }
            return a2.applicationInfo.targetSdkVersion >= 24;
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return false;
        }
    }

    public static int p(Context context, String str) {
        try {
            String d2 = com.baidu.android.pushservice.c.c.d(context);
            if (TextUtils.isEmpty(d2)) {
                return 0;
            }
            ArrayList<com.baidu.android.pushservice.a.e> c2 = com.baidu.android.pushservice.a.b.a(context).c(b(d2));
            if (c2 != null) {
                Iterator<com.baidu.android.pushservice.a.e> it = c2.iterator();
                while (it.hasNext()) {
                    com.baidu.android.pushservice.a.e next = it.next();
                    if (TextUtils.equals(next.b(), str)) {
                        return next.c();
                    }
                }
                return 0;
            }
            return 0;
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return 0;
        }
    }

    public static boolean p(Context context) {
        PackageInfo a2;
        try {
            if (Build.VERSION.SDK_INT < 26 || (a2 = a(context, context.getPackageName())) == null) {
                return false;
            }
            return a2.applicationInfo.targetSdkVersion >= 26;
        } catch (Exception unused) {
            return false;
        }
    }

    public static Bitmap q(Context context, String str) {
        Bitmap bitmap = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            InputStream inputStream = httpURLConnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return bitmap;
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return bitmap;
        }
    }

    public static String q(Context context) {
        String[] strArr;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return "pm is null";
            }
            String[] strArr2 = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr2 == null) {
                Log.e("BDPushSDK-Utility", "Permissions Push-SDK need are not exist !");
                return "Permissions Push-SDK need are not exist !";
            } else if (a(context, packageManager, strArr2)) {
                Log.e("BDPushSDK-Utility", "permission Push-SDK for xiaomi proxy need is not exist !");
                return "permission Push-SDK for xiaomi proxy need is not exist !";
            } else if (a(context, strArr2)) {
                Log.e("BDPushSDK-Utility", "permission Push-SDK for oppo proxy need is not exist !");
                return "permission Push-SDK for oppo proxy need is not exist !";
            } else {
                for (String str : f3467b) {
                    if (!a(str, strArr2)) {
                        String str2 = str + " permission Push-SDK need is not exist !";
                        Log.e("BDPushSDK-Utility", str2);
                        return str2;
                    }
                }
                return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
            }
        } catch (Exception e2) {
            return "checkSDKPermissions exception " + e2.getMessage();
        }
    }

    public static String r(Context context, String str) {
        String str2 = null;
        try {
            if (!TextUtils.isEmpty(str) && str.contains("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=")) {
                if (str.contains("bdpush_hwsigninfo")) {
                    int o = o(context, str);
                    if (o > 0) {
                        str2 = str.substring(45, o);
                    }
                } else {
                    str2 = str.substring(45, str.length());
                }
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    public static boolean r(Context context) {
        PackageManager packageManager;
        Intent intent = new Intent("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setPackage(context.getPackageName());
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.b("Utility", "error  " + e2.getMessage(), context);
        }
        if (packageManager == null) {
            return false;
        }
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
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

    public static boolean s(Context context) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.baidu.android.pushservice.CommandService"), 128);
            if (TextUtils.isEmpty(serviceInfo.name)) {
                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.CommandService did not declared ");
                return false;
            } else if (serviceInfo.exported) {
                return true;
            } else {
                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.CommandService  exported declared wrong");
                return true;
            }
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return false;
        }
    }

    public static String t(Context context) {
        String str;
        if (!a(context, "com.baidu.android.pushservice.action.notification.SHOW", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            str = "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared com.baidu.android.pushservice.action.notification.SHOW";
        } else if (a(context, "com.baidu.android.pushservice.action.METHOD", "com.baidu.android.pushservice.RegistrationReceiver", true)) {
            return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
        } else {
            str = "com.baidu.android.pushservice.RegistrationReceiver is not exist or did not declared com.baidu.android.pushservice.action.METHOD";
        }
        Log.e("BDPushSDK-Utility", str);
        return str;
    }

    public static String u(Context context) {
        String str;
        if (v(context)) {
            str = "xiaomi service is not found or wrong  declared, please check!";
        } else if (x(context)) {
            str = "oppo service is not found or wrong  declared, please check!";
        } else if (w(context)) {
            str = "meizu service is not found or wrong  declared, please check!";
        } else if (!y(context)) {
            return a(context, "com.baidu.android.pushservice.action.PUSH_SERVICE", "com.baidu.android.pushservice.PushService", false) ? "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK" : "com.baidu.android.pushservice.PushService is not exist or did not declared com.baidu.android.pushservice.action.PUSH_SERVICE";
        } else {
            str = "vivo service is not found or wrong  declared, please check!";
        }
        Log.e("BDPushSDK-Utility", str);
        return str;
    }

    public static boolean v(Context context) {
        ServiceInfo[] serviceInfoArr;
        try {
            if (b() && PushSettings.g(context)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    boolean z = false;
                    boolean z2 = false;
                    for (ServiceInfo serviceInfo : packageInfo.services) {
                        if (serviceInfo.name.equals("com.xiaomi.mipush.sdk.PushMessageHandler")) {
                            z2 = true;
                        }
                        if (serviceInfo.name.equals("com.xiaomi.mipush.sdk.MessageHandleService")) {
                            z = true;
                        }
                    }
                    return (z && z2) ? false : true;
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean w(Context context) {
        try {
            if (c() && PushSettings.h(context)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    boolean z = false;
                    for (ServiceInfo serviceInfo : packageInfo.services) {
                        if (serviceInfo.name.equals("com.meizu.cloud.pushsdk.NotificationService")) {
                            z = true;
                        }
                    }
                    return !z;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean x(Context context) {
        ServiceInfo[] serviceInfoArr;
        try {
            if ((e() || f() || g()) && PushSettings.i(context)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    boolean z = false;
                    boolean z2 = false;
                    for (ServiceInfo serviceInfo : packageInfo.services) {
                        if (serviceInfo.name.equals("com.heytap.mcssdk.PushService")) {
                            z = true;
                        }
                        if (serviceInfo.name.equals("com.heytap.mcssdk.AppPushService")) {
                            z2 = true;
                        }
                    }
                    return (z && z2) ? false : true;
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean y(Context context) {
        try {
            if (h() && PushSettings.j(context)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    boolean z = false;
                    for (ServiceInfo serviceInfo : packageInfo.services) {
                        if (serviceInfo.name.equals("com.vivo.push.sdk.service.CommandClientService")) {
                            z = true;
                        }
                    }
                    return !z;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean z(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, "com.baidu.android.pushservice.PushInfoProvider");
            new ProviderInfo();
            ProviderInfo providerInfo = packageManager.getProviderInfo(componentName, 128);
            String str = providerInfo.name;
            String str2 = providerInfo.authority;
            com.baidu.android.pushservice.g.a.c("Utility", "provider name  = " + str + "  export  = " + providerInfo.exported + " provider authorities = " + str2, context.getApplicationContext());
            if (TextUtils.isEmpty(str)) {
                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider did not declared, please check ! ");
                return false;
            }
            if (!TextUtils.isEmpty(str2) && str2.endsWith("bdpush")) {
                if (!providerInfo.exported) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider exported declared wrong, please check ! ");
                }
                if (TextUtils.isEmpty(providerInfo.writePermission)) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider writePermission did not decleared, please check !");
                    return true;
                }
                return true;
            }
            Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider bdpush authority is required, please check !");
            return false;
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return false;
        }
    }
}
