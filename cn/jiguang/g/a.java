package cn.jiguang.g;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import cn.jiguang.d.d.aa;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.service.AlarmReceiver;
import cn.jpush.android.service.DaemonService;
import cn.jpush.android.service.DataProvider;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.service.PushService;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.security.auth.x500.X500Principal;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    public static int a = 1;
    private static List<String> b;
    private static final ArrayList<String> c;
    private static final ArrayList<String> d;
    private static final ArrayList<String> e;
    private static Boolean f;
    private static String g;
    private static PushReceiver mL;

    static {
        ArrayList arrayList = new ArrayList();
        b = arrayList;
        arrayList.add("358673013795895");
        b.add("004999010640000");
        b.add("00000000000000");
        b.add("000000000000000");
        c = new ArrayList<>();
        d = new ArrayList<>();
        c.add("android.permission.INTERNET");
        c.add("android.permission.ACCESS_NETWORK_STATE");
        d.add("android.permission.WAKE_LOCK");
        d.add("android.permission.VIBRATE");
        d.add("android.permission.CHANGE_WIFI_STATE");
        ArrayList<String> arrayList2 = new ArrayList<>();
        e = arrayList2;
        arrayList2.add("android.permission.ACCESS_FINE_LOCATION");
        e.add("android.permission.ACCESS_COARSE_LOCATION");
        e.add("android.permission.ACCESS_LOCATION_EXTRA_COMMANDS");
        e.add("android.permission.ACCESS_WIFI_STATE");
        f = null;
        g = "";
    }

    private static String L(Context context, String str) {
        if (a(context, "android.permission.WRITE_SETTINGS")) {
            try {
                return Settings.System.getString(context.getContentResolver(), "devcie_id_generated");
            } catch (Exception e2) {
                return str;
            }
        }
        return str;
    }

    public static ApplicationInfo M(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String N(Context context, String str) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable th) {
            return "";
        }
    }

    private static int Q(String str) {
        if (i.a(str) || Pattern.matches("[0]*", str)) {
            return 0;
        }
        if (Pattern.matches("[0-9]{15}", str)) {
            return 1;
        }
        return Pattern.matches("[a-f0-9A-F]{14}", str) ? 2 : 0;
    }

    public static int a(byte b2) {
        return b2 & 255;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16, types: [android.content.pm.ActivityInfo[]] */
    /* JADX WARN: Type inference failed for: r2v17, types: [android.content.pm.ActivityInfo[]] */
    /* JADX WARN: Type inference failed for: r2v18, types: [android.content.pm.ServiceInfo[]] */
    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        ProviderInfo[] providerInfoArr;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            return null;
        }
        try {
            int i = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, i);
            switch (i) {
                case 1:
                    providerInfoArr = packageInfo.activities;
                    break;
                case 2:
                    providerInfoArr = packageInfo.receivers;
                    break;
                case 3:
                case 5:
                case 6:
                case 7:
                default:
                    providerInfoArr = null;
                    break;
                case 4:
                    providerInfoArr = packageInfo.services;
                    break;
                case 8:
                    providerInfoArr = packageInfo.providers;
                    break;
            }
            if (providerInfoArr != null) {
                String name = cls.getName();
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (name.equals(((ComponentInfo) providerInfo).name)) {
                        return providerInfo;
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.e.c.c("AndroidUtil", "hasComponent error:" + th.getMessage());
            return null;
        }
    }

    public static String a() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (new File("/proc/cpuinfo").exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
                String str = null;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.contains("Processor")) {
                        int indexOf = readLine.indexOf(":");
                        if (indexOf >= 0 && indexOf < readLine.length() - 1) {
                            str = readLine.substring(indexOf + 1).trim();
                        }
                        if (str != null && !stringBuffer.toString().contains(str)) {
                            stringBuffer.append(str);
                        }
                    }
                }
                bufferedReader.close();
            }
        } catch (Throwable th) {
        }
        return stringBuffer.toString();
    }

    public static String a(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return "0*0";
        }
        return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] digest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                int i = b2 & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    private static List<String> a(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (resolveInfo.activityInfo != null) {
                    String str2 = resolveInfo.activityInfo.name;
                    if (!TextUtils.isEmpty(str2)) {
                        if (TextUtils.isEmpty(str) || packageManager.checkPermission(str, resolveInfo.activityInfo.packageName) == 0) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
        return arrayList;
    }

    public static JSONObject a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", str2);
            aa.a((Context) null, jSONObject, str);
            return jSONObject;
        } catch (Exception e2) {
            return null;
        }
    }

    public static JSONObject a(String str, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", jSONArray);
            aa.a((Context) null, jSONObject, str);
            return jSONObject;
        } catch (Exception e2) {
            return null;
        }
    }

    public static void a(Context context, String str, int i) {
        int i2;
        Notification notification;
        if (w(context)) {
            if (!a(context, PushReceiver.class)) {
                new Handler(Looper.getMainLooper()).post(new b(context, str));
                return;
            }
            Intent intent = new Intent(context, PushReceiver.class);
            intent.setAction("cn.jpush.android.intent.NOTIFICATION_OPENED_PROXY");
            intent.addCategory(context.getPackageName());
            intent.putExtra("debug_notification", true);
            intent.putExtra("toastText", str);
            intent.putExtra("type", -1);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            try {
                i2 = context.getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 0).icon;
            } catch (Throwable th) {
                cn.jiguang.e.c.b("AndroidUtil", "failed to get application info and icon.", th);
                i2 = 17301586;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 11) {
                notification = new Notification.Builder(context.getApplicationContext()).setContentTitle("Jiguang提示：包名和AppKey不匹配").setContentText("请到 Portal 上获取您的包名和AppKey并更新AndroidManifest相应字段").setContentIntent(broadcast).setSmallIcon(i2).setTicker(str).setWhen(currentTimeMillis).getNotification();
                notification.flags = 34;
            } else {
                Notification notification2 = new Notification(i2, str, currentTimeMillis);
                notification2.flags = 34;
                try {
                    Class.forName("android.app.Notification").getDeclaredMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification2, context, "Jiguang提示：包名和AppKey不匹配", "请到 Portal 上获取您的包名和AppKey并更新AndroidManifest相应字段", broadcast);
                    notification = notification2;
                } catch (Exception e2) {
                    notification = notification2;
                }
            }
            if (notification != null) {
                notificationManager.notify(str.hashCode(), notification);
            }
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            cn.jiguang.e.c.d("AndroidUtil", "Bundle should not be null for sendBroadcast.");
            return;
        }
        Intent intent = new Intent(str);
        try {
            bundle.putString(JPushInterface.EXTRA_APP_KEY, cn.jiguang.d.a.b(context));
            intent.putExtras(bundle);
            String packageName = context.getPackageName();
            intent.addCategory(packageName);
            intent.setPackage(packageName);
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("AndroidUtil", "sendBroadcast error:" + th.getMessage() + ",action:" + str);
            b(context, intent, null);
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        if (str2 != null) {
            bundle.putString(str2, str3);
        }
        a(context, str, bundle);
    }

    private static boolean a(Context context, Class<?> cls) {
        try {
            boolean z = !context.getPackageManager().queryBroadcastReceivers(new Intent(context, cls), 0).isEmpty();
            if (z) {
                return z;
            }
            try {
                return a(context, context.getPackageName(), cls) != null;
            } catch (Throwable th) {
                return z;
            }
        } catch (Throwable th2) {
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        if (context != null) {
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
            }
        }
        throw new IllegalArgumentException("empty params");
    }

    private static boolean a(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 0)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.name.equals(str)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            cn.jiguang.e.c.c("AndroidUtil", "hasReceiverIntentFilterPackage error:" + th.getMessage());
        }
        return false;
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (Throwable th) {
            cn.jiguang.e.c.c("AndroidUtil", "hasServiceIntentFilter error:" + th.getMessage());
            return false;
        }
    }

    private static boolean a(String str, String str2, String str3, String str4) {
        return (i.a(str3) || i.a(str4)) ? str.equals(str2) : str.equals(str2) && str3.equalsIgnoreCase(str4);
    }

    public static ProviderInfo ao(Context context) {
        ProviderInfo providerInfo;
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getApplicationContext(), DataProvider.class), 1, 1);
        } catch (Throwable th) {
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 8);
            if (packageInfo == null || packageInfo.providers == null) {
                return null;
            }
            ProviderInfo[] providerInfoArr = packageInfo.providers;
            int length = providerInfoArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    providerInfo = null;
                    break;
                }
                providerInfo = providerInfoArr[i];
                if (providerInfo.name.equals(DataProvider.class.getName())) {
                    break;
                }
                i++;
            }
            if (providerInfo != null) {
                if (providerInfo.multiprocess) {
                    cn.jiguang.e.c.d("AndroidUtil", "DataProvider:should set multiprocess to false!");
                    return null;
                }
                return providerInfo;
            }
            return null;
        } catch (Throwable th2) {
            return null;
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x003b: INVOKE  (r2v4 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    private static String ap(Context context) {
        String d2 = d();
        String str = d2 == null ? null : d2 + ".push_udid";
        File file = i.a(str) ? null : new File(str);
        String g2 = cn.jiguang.d.h.f.g(file);
        if (!TextUtils.isEmpty(g2)) {
            cn.jiguang.d.a.a.e(context, g2);
            return g2;
        }
        String b2 = i.b(UUID.nameUUIDFromBytes(new StringBuilder().append(System.currentTimeMillis()).toString().getBytes()).toString());
        cn.jiguang.d.a.a.e(context, b2);
        cn.jiguang.d.h.f.b(file, b2);
        return b2;
    }

    private static String aq(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("PrefsFile", 0);
        String string = sharedPreferences.getString("key", null);
        if (string == null) {
            String uuid = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("key", uuid);
            edit.commit();
            return uuid;
        }
        return string;
    }

    public static boolean ar(Context context) {
        String a2 = j.a(context, "ro.product.brand");
        String a3 = j.a(context, "ro.miui.ui.version.name");
        if (!TextUtils.isEmpty(a2) && "Xiaomi".equals(a2) && !TextUtils.isEmpty(a3)) {
            String a4 = j.a(context, "ro.build.version.incremental");
            if (!TextUtils.isEmpty(a4) && a4.startsWith("V7.1")) {
                return false;
            }
        }
        return true;
    }

    public static double as(Context context) {
        double pow;
        double pow2;
        Point point = new Point();
        if (context instanceof Activity) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else if (Build.VERSION.SDK_INT >= 13) {
                defaultDisplay.getSize(point);
            } else {
                point.x = defaultDisplay.getWidth();
                point.y = defaultDisplay.getHeight();
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (context instanceof Activity) {
            pow = Math.pow(point.x / displayMetrics.xdpi, 2.0d);
            pow2 = Math.pow(point.y / displayMetrics.ydpi, 2.0d);
        } else {
            pow = Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d);
            pow2 = Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d);
        }
        return Math.sqrt(pow2 + pow);
    }

    public static int at(Context context) {
        cn.jiguang.e.c.a("AndroidUtil", "action:checkValidManifest");
        if (cn.jiguang.d.d.i.bW().f()) {
            if (!q(context)) {
                cn.jiguang.e.c.d("AndroidUtil", "AndroidManifest.xml missing required service: " + PushService.class.getCanonicalName());
                return 4;
            }
            ProviderInfo ao = ao(context);
            if (ao == null) {
                cn.jiguang.e.c.d("AndroidUtil", "AndroidManifest.xml missing required ContentProvider: " + DataProvider.class.getCanonicalName());
                return 5;
            }
            if (!TextUtils.isEmpty(g) && !g.equals(ao.processName)) {
                cn.jiguang.e.c.c("AndroidUtil", "We recommend DataProvider's process same as PushService");
            }
            if (b(context, DaemonService.class) == null) {
                cn.jiguang.e.c.c("AndroidUtil", "AndroidManifest.xml missing required service: " + DaemonService.class.getCanonicalName());
                cn.jiguang.api.e.w(false);
            } else if (a(context, cn.jiguang.api.e.bC(), true)) {
                cn.jiguang.api.e.w(true);
            } else {
                cn.jiguang.e.c.c("AndroidUtil", "AndroidManifest.xml missing intent filter for DaemonService: " + cn.jiguang.api.e.bC());
                cn.jiguang.api.e.w(false);
            }
            if (!cn.jiguang.d.a.d.i(context)) {
                cn.jiguang.d.b.a.a(context, true);
                if (!a(context, AlarmReceiver.class)) {
                    cn.jiguang.e.c.d("AndroidUtil", "AndroidManifest.xml missing required receiver: " + AlarmReceiver.class.getCanonicalName());
                    return 7;
                }
                if (!a(context, PushReceiver.class)) {
                    cn.jiguang.e.c.d("AndroidUtil", "AndroidManifest.xml missing required receiver: " + PushReceiver.class.getCanonicalName());
                    if (!au(context)) {
                        return 6;
                    }
                }
                if (a(context, PushReceiver.class.getCanonicalName(), "android.intent.action.BOOT_COMPLETED")) {
                    cn.jiguang.e.c.c("AndroidUtil", "PushReceiver should not have intent filter -- android.intent.action.BOOT_COMPLETED, Please remove the intent filter in AndroidManifest.xml");
                }
            }
            String str = context.getPackageName() + ".permission.JPUSH_MESSAGE";
            if (!j(context, str)) {
                cn.jiguang.e.c.d("AndroidUtil", "The permission should be defined - " + str);
                return 8;
            }
            c.add(str);
        }
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!a(context, next)) {
                cn.jiguang.e.c.d("AndroidUtil", "The permissoin is required - " + next);
                return 9;
            }
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (!a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                cn.jiguang.e.c.d("AndroidUtil", "The permissoin is required - android.permission.WRITE_EXTERNAL_STORAGE");
                return 10;
            } else if (!a(context, "android.permission.WRITE_SETTINGS")) {
                cn.jiguang.e.c.d("AndroidUtil", "The permissoin is required - android.permission.WRITE_SETTINGS");
                return 11;
            }
        }
        Iterator<String> it2 = d.iterator();
        while (it2.hasNext()) {
            a(context, it2.next());
        }
        Iterator<String> it3 = e.iterator();
        while (it3.hasNext()) {
            a(context, it3.next());
        }
        return 0;
    }

    private static boolean au(Context context) {
        try {
            if (mL == null) {
                mL = new PushReceiver();
                context.registerReceiver(mL, new IntentFilter("android.intent.action.USER_PRESENT"));
                context.registerReceiver(mL, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme("package");
                IntentFilter intentFilter2 = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
                intentFilter2.addDataScheme("package");
                context.registerReceiver(mL, intentFilter);
                context.registerReceiver(mL, intentFilter2);
                IntentFilter intentFilter3 = new IntentFilter(JPushInterface.ACTION_NOTIFICATION_RECEIVED_PROXY);
                intentFilter3.setPriority(1000);
                intentFilter3.addCategory(context.getPackageName());
                context.registerReceiver(mL, intentFilter3);
            } else {
                cn.jiguang.e.c.a("AndroidUtil", "has register in code");
            }
            return true;
        } catch (Throwable th) {
            cn.jiguang.e.c.c("AndroidUtil", "Register PushReceiver in code  failed:" + th.getMessage());
            return false;
        }
    }

    private static ComponentInfo b(Context context, Class<?> cls) {
        try {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(context, cls), 0);
            return queryIntentServices.isEmpty() ? a(context, context.getPackageName(), cls) : queryIntentServices.get(0).serviceInfo;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public static String b(Context context, String str) {
        String t = t(context);
        if (!i.e(t)) {
            t = u(context);
        }
        return !i.e(t) ? str : t;
    }

    public static String b(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("utf-8"));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                int i = b2 & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public static List<String> b(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (!a(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private static void b(Context context, Intent intent, String str) {
        String action = intent.getAction();
        if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(action)) {
            List<String> a2 = a(context, intent, (String) null);
            if (a2.isEmpty()) {
                cn.jiguang.e.c.c("AndroidUtil", "sendBroadcast failed again: receiver not found, action:" + action);
                return;
            }
            for (String str2 : a2) {
                try {
                    Intent intent2 = (Intent) intent.clone();
                    intent2.setComponent(new ComponentName(context.getPackageName(), str2));
                    if (TextUtils.isEmpty(null)) {
                        context.sendBroadcast(intent2);
                    } else {
                        context.sendBroadcast(intent2, null);
                    }
                } catch (Exception e2) {
                    cn.jiguang.e.c.c("AndroidUtil", "sendBroadcast failed again:" + e2.getMessage() + ", action:" + action);
                }
            }
        }
    }

    public static boolean b(Context context) {
        try {
            String N = N(context, PushService.class.getCanonicalName());
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(N)) {
                    return true;
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static String c(Context context, String str) {
        try {
            return a(context, "android.permission.READ_PHONE_STATE") ? ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSimSerialNumber() : str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return a(str.getBytes("utf-8"));
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    private static boolean c() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            return false;
        }
    }

    public static int d(String str) {
        String[] split = str.split("\\.");
        return Integer.parseInt(split[2]) + (Integer.parseInt(split[0]) << 16) + (Integer.parseInt(split[1]) << 8);
    }

    private static String d() {
        String str = null;
        try {
            str = Environment.getExternalStorageDirectory().getPath();
        } catch (ArrayIndexOutOfBoundsException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
        }
        return !i.a(str) ? str + "/data/" : str;
    }

    public static String d(Context context, String str) {
        String str2;
        try {
            str2 = ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId();
        } catch (Exception e2) {
            str2 = null;
        }
        return i.d(str2) ? str2 : str;
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static String e() {
        String d2 = d();
        String str = d2 == null ? null : d2 + ".push_deviceid";
        if (i.a(str)) {
            cn.jiguang.e.c.d("AndroidUtil", "get device id  sd card file path fail");
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            try {
                ArrayList<String> f2 = cn.jiguang.d.h.f.f(new FileInputStream(file));
                if (f2.size() > 0) {
                    return f2.get(0);
                }
                return null;
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    public static String e(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "Unknown";
            }
            String typeName = activeNetworkInfo.getTypeName();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            return typeName == null ? "Unknown" : !i.a(subtypeName) ? typeName + Constants.ACCEPT_TIME_SEPARATOR_SP + subtypeName : typeName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "Unknown";
        }
    }

    public static String e(Context context, String str) {
        try {
            return a(context, "android.permission.READ_PHONE_STATE") ? ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId() : str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static ArrayList<String> e(String[] strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                            return arrayList;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return arrayList;
                        }
                    }
                    arrayList.add(readLine);
                } catch (Exception e3) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    return null;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            return null;
        }
    }

    private static boolean e(String str) {
        if (i.d(str) && str.length() >= 10) {
            for (int i = 0; i < b.size(); i++) {
                if (str.equals(b.get(i)) || str.startsWith(b.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static int f(Context context) {
        Intent intent;
        if (context == null) {
            return -1;
        }
        try {
            intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (SecurityException e2) {
            e2.printStackTrace();
            intent = null;
        } catch (Exception e3) {
            e3.printStackTrace();
            intent = null;
        }
        if (intent != null) {
            int intExtra = intent.getIntExtra("status", -1);
            if (intExtra == 2 || intExtra == 5) {
                return intent.getIntExtra("plugged", -1);
            }
            return -1;
        }
        return -1;
    }

    private static String f(String str) {
        String d2 = d();
        if (i.a(d2)) {
            return null;
        }
        cn.jiguang.d.h.f.b(new File(d2 + ".push_deviceid"), str);
        return str;
    }

    public static void f(Context context, String str) {
        if (i.a(str)) {
            return;
        }
        n(context, str);
        l(context, str);
        cn.jiguang.d.a.d.a(context, str);
    }

    public static String g(Context context) {
        String b2 = cn.jiguang.d.a.a.b(context);
        if (e(b2)) {
            return b2;
        }
        String x = x(context);
        cn.jiguang.d.a.a.f(context, x);
        return x;
    }

    public static String h(Context context) {
        String str = "";
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (SecurityException e2) {
        } catch (Exception e3) {
        }
        return i.d(str) ? str : "";
    }

    public static String i(Context context) {
        String str = null;
        String b2 = cn.jiguang.d.a.d.b(context);
        if (i.d(b2)) {
            a = c.d - 1;
            return b2;
        }
        String L = L(context, b2);
        if (i.d(L)) {
            a = c.b - 1;
            l(context, L);
            cn.jiguang.d.a.d.a(context, L);
            return L;
        }
        if (c() && a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && (Build.VERSION.SDK_INT < 23 || (a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && a(context, "android.permission.READ_EXTERNAL_STORAGE")))) {
            str = e();
        }
        if (i.d(str)) {
            a = c.c - 1;
            n(context, str);
            cn.jiguang.d.a.d.a(context, str);
            return str;
        }
        String d2 = Build.VERSION.SDK_INT < 23 ? d(context, str) : "";
        String h = h(context);
        String b3 = b(context, "");
        String uuid = UUID.randomUUID().toString();
        String a2 = a(d2 + h + b3 + uuid);
        if (i.a(a2)) {
            a2 = uuid;
        }
        cn.jiguang.d.a.d.a(context, a2);
        a = c.a - 1;
        n(context, a2);
        l(context, a2);
        return a2;
    }

    public static boolean i(Context context, String str) {
        if (i.a(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean j(Context context) {
        String str = context.getApplicationInfo().sourceDir;
        if (i.a(str)) {
            return false;
        }
        if (str.startsWith("/system/app/")) {
            return true;
        }
        if (str.startsWith("/data/app/")) {
        }
        return false;
    }

    private static boolean j(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("empty params");
        }
        try {
            context.getPackageManager().getPermissionInfo(str, 128);
            return true;
        } catch (Throwable th) {
            cn.jiguang.e.c.c("AndroidUtil", "hasPermissionDefined error:" + th.getMessage());
            return false;
        }
    }

    public static void k(Context context) {
        long g2 = cn.jiguang.d.a.a.g() * 1000;
        long currentTimeMillis = System.currentTimeMillis() + g2;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setWindow(0, currentTimeMillis, 0L, broadcast);
            } else {
                alarmManager.setInexactRepeating(0, currentTimeMillis, g2, broadcast);
            }
        } catch (Exception e2) {
            cn.jiguang.e.c.c("AndroidUtil", "can't trigger alarm cause by exception:" + e2.getMessage());
        }
    }

    private static boolean k(Context context, String str) {
        try {
            context.getPackageManager().getReceiverInfo(new ComponentName(context.getPackageName(), str), 128);
            return true;
        } catch (Throwable th) {
            cn.jiguang.e.c.c("AndroidUtil", "hasReceiver error:" + th.getMessage());
            return false;
        }
    }

    private static String l(Context context, String str) {
        if (c() && a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (Build.VERSION.SDK_INT < 23) {
                return f(str);
            }
            if (a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && a(context, "android.permission.READ_EXTERNAL_STORAGE")) {
                return f(str);
            }
            return null;
        }
        return null;
    }

    public static void l(Context context) {
        try {
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0));
        } catch (Exception e2) {
        }
    }

    public static long m(byte[] bArr) {
        long j = 0;
        if (bArr != null && bArr.length >= 6) {
            int i = 0;
            while (i < 8) {
                i++;
                j = (bArr[i + 4] & 255) + (j << 8);
            }
        }
        return j;
    }

    public static void m(Context context) {
        boolean z = true;
        cn.jiguang.d.a.c bI = cn.jiguang.d.a.a.bI();
        if (bI.d()) {
            return;
        }
        String a2 = bI.a();
        String b2 = bI.b();
        String c2 = bI.c();
        String d2 = d(context, "");
        String h = h(context);
        if (i.a(h)) {
            h = " ";
        }
        String b3 = b(context, "");
        if (i.a(b3)) {
            b3 = " ";
        }
        int Q = Q(a2);
        int Q2 = Q(d2);
        if (Q == 0 || Q2 == 0) {
            z = a(h, b2, b3, c2);
        } else if ((1 != Q || 2 != Q2) && (2 != Q || 1 != Q2)) {
            if (Q != Q2) {
                z = false;
            } else if (d2.equals(a2)) {
                z = d2.equals(a2) && h.equals(b2);
            } else {
                z = a(h, b2, b3, c2);
            }
        }
        if (z) {
            return;
        }
        n(context);
    }

    private static String n(Context context, String str) {
        if (a(context, "android.permission.WRITE_SETTINGS")) {
            try {
                if (Settings.System.putString(context.getContentResolver(), "devcie_id_generated", str)) {
                    return str;
                }
            } catch (Exception e2) {
            }
        }
        return null;
    }

    public static void n(Context context) {
        cn.jiguang.d.a.d.g(context);
        n(context, "");
        l(context, "");
        cn.jiguang.d.h.e.ch().b(context);
    }

    public static boolean q(Context context) {
        if (f == null) {
            try {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getApplicationContext(), PushService.class), 1, 1);
            } catch (Throwable th) {
            }
            ComponentInfo b2 = b(context, PushService.class);
            if (b2 != null) {
                f = true;
                g = b2.processName;
            } else {
                f = false;
                g = "";
            }
        }
        return f.booleanValue();
    }

    public static void s(Context context) {
        if (mL == null || k(context, PushReceiver.class.getCanonicalName())) {
            return;
        }
        try {
            context.unregisterReceiver(mL);
            mL = null;
        } catch (Exception e2) {
        }
    }

    private static String t(Context context) {
        if (Build.VERSION.SDK_INT < 23 && a(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                return ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
            } catch (Exception e2) {
            }
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
        r4 = new java.lang.StringBuilder();
        r6 = r5.length;
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
        if (r0 >= r6) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
        r4.append(java.lang.String.format(java.util.Locale.ENGLISH, "%02x:", java.lang.Byte.valueOf(r5[r0])));
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006c, code lost:
        if (r4.length() <= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
        r4.deleteCharAt(r4.length() - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
        r0 = r4.toString();
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String u(Context context) {
        boolean z;
        boolean z2;
        String str;
        byte[] hardwareAddress;
        boolean z3 = false;
        try {
            z2 = a(context, "android.permission.ACCESS_WIFI_STATE") ? ((WifiManager) context.getApplicationContext().getSystemService("wifi")).isWifiEnabled() : false;
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (true) {
                    if (!networkInterfaces.hasMoreElements()) {
                        str = "";
                        break;
                    }
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if ("wlan0".equalsIgnoreCase(nextElement.getName()) && (hardwareAddress = nextElement.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                        break;
                    }
                }
            } catch (Exception e2) {
                z = z2;
                z2 = z;
                str = "";
                if (z2) {
                }
            }
        } catch (Exception e3) {
            z = false;
        }
        if (z2) {
            String p = cn.jiguang.d.a.a.p();
            if (!TextUtils.isEmpty(p) && !TextUtils.isEmpty(str)) {
                z3 = p.equals(a(str.toLowerCase() + Build.MODEL));
            }
            return !z3 ? "" : str;
        }
        return str;
    }

    private static String v(Context context) {
        try {
            String b2 = b(context, "");
            if (b2 == null || b2.equals("")) {
                return null;
            }
            return a(b2.toLowerCase() + Build.MODEL);
        } catch (Exception e2) {
            return null;
        }
    }

    private static boolean w(Context context) {
        String str;
        boolean z = false;
        try {
            X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
            String[] strArr = {"CN=Android Debug", "O=Android", "C=US"};
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            for (Signature signature : signatureArr) {
                X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
                z = x509Certificate.getSubjectX500Principal().equals(x500Principal);
                if (z) {
                    return z;
                }
                try {
                    try {
                        str = x509Certificate.getSubjectX500Principal().getName();
                    } catch (Exception e2) {
                        str = null;
                    }
                    if (str != null) {
                        try {
                            if (str.contains(strArr[0]) && str.contains(strArr[1]) && str.contains(strArr[2])) {
                                return true;
                            }
                        } catch (PackageManager.NameNotFoundException e3) {
                            return z;
                        }
                    }
                } catch (Throwable th) {
                    return z;
                }
            }
            return z;
        } catch (PackageManager.NameNotFoundException e4) {
            return false;
        } catch (Throwable th2) {
            return false;
        }
    }

    private static String x(Context context) {
        try {
            String d2 = d(context, "");
            if (e(d2)) {
                return d2;
            }
            String h = h(context);
            if (!e(h) || "9774d56d682e549c".equals(h.toLowerCase(Locale.getDefault()))) {
                String v = v(context);
                if (!e(v) && (v = y(context)) == null) {
                    v = " ";
                }
                return !e(v) ? "" : v;
            }
            return h;
        } catch (Exception e2) {
            String y = y(context);
            return !e(y) ? "" : y;
        }
    }

    private static String y(Context context) {
        String string = context.getSharedPreferences("PrefsFile", 0).getString("key", null);
        if (i.a(string)) {
            if (c()) {
                String a2 = cn.jiguang.d.a.a.a(context);
                return TextUtils.isEmpty(a2) ? (Build.VERSION.SDK_INT < 23 || (a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && a(context, "android.permission.READ_EXTERNAL_STORAGE"))) ? ap(context) : aq(context) : a2;
            }
            return aq(context);
        }
        return string;
    }
}
