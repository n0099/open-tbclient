package cn.jpush.android.d;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jpush.android.api.JPushInterface;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.xiaomi.mipush.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    public static Intent a(Context context, cn.jpush.android.data.b bVar, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("isUpdateVersion", false);
        intent.putExtra("body", bVar);
        intent.setAction("cn.jpush.android.ui.PushActivity");
        intent.addCategory(context.getPackageName());
        intent.addFlags(536870912);
        if (!f(context) && Build.VERSION.SDK_INT >= 11) {
            intent.addFlags(32768);
        }
        a(context, intent);
        return intent;
    }

    public static String a(Context context, String str) {
        String str2 = Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SP + Integer.toString(Build.VERSION.SDK_INT);
        String str3 = Build.MODEL;
        String a = i.a(context, "gsm.version.baseband", "baseband");
        String str4 = Build.DEVICE;
        String bA = cn.jiguang.api.e.bA();
        if (TextUtils.isEmpty(bA)) {
            bA = " ";
        }
        String e = e(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("androidSdkVersion", str2);
            jSONObject.put("model", str3);
            jSONObject.put("baseband", a);
            jSONObject.put(Config.DEVICE_PART, str4);
            jSONObject.put(LogBuilder.KEY_CHANNEL, bA);
            jSONObject.put("network", e);
            jSONObject.put("url", str);
        } catch (JSONException e2) {
        }
        return jSONObject.toString();
    }

    public static String a(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            if (digest == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer(digest.length * 2);
            for (byte b : digest) {
                stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15)).append("0123456789ABCDEF".charAt(b & 15));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static List<String> a(Context context, Intent intent, String str) {
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

    private static void a(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 21) {
            try {
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                    if (resolveInfo.activityInfo != null) {
                        String str = resolveInfo.activityInfo.name;
                        if (!TextUtils.isEmpty(str)) {
                            intent.setComponent(new ComponentName(context, str));
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void a(Context context, cn.jpush.android.data.b bVar) {
        try {
            Intent intent = new Intent(JPushInterface.ACTION_MESSAGE_RECEIVED);
            intent.putExtra(JPushInterface.EXTRA_APP_KEY, bVar.p);
            intent.putExtra(JPushInterface.EXTRA_MESSAGE, bVar.j);
            intent.putExtra(JPushInterface.EXTRA_CONTENT_TYPE, bVar.k);
            intent.putExtra(JPushInterface.EXTRA_TITLE, bVar.m);
            intent.putExtra(JPushInterface.EXTRA_EXTRA, bVar.n);
            intent.putExtra(JPushInterface.EXTRA_MSG_ID, bVar.c);
            if (bVar.a()) {
                intent.putExtra(JPushInterface.EXTRA_RICHPUSH_FILE_PATH, bVar.I);
            }
            intent.addCategory(bVar.o);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent, String.format(Locale.ENGLISH, "%s.permission.JPUSH_MESSAGE", bVar.o));
            if (bVar.e != 0) {
                cn.jpush.android.a.e.a(bVar.c, "", bVar.e, PointerIconCompat.TYPE_ZOOM_IN, context);
            } else {
                cn.jpush.android.a.e.a(bVar.c, PointerIconCompat.TYPE_ZOOM_IN, null, context);
            }
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            f.d("AndroidUtil", "Bundle should not be null for sendBroadcast.");
            return;
        }
        try {
            Intent intent = new Intent(str);
            bundle.putString(JPushInterface.EXTRA_APP_KEY, cn.jiguang.api.e.getAppKey());
            intent.putExtras(bundle);
            String packageName = context.getPackageName();
            intent.addCategory(packageName);
            intent.setPackage(packageName);
            context.sendBroadcast(intent, String.format(Locale.ENGLISH, "%s.permission.JPUSH_MESSAGE", packageName));
        } catch (Exception e) {
            f.c("AndroidUtil", "sendBroadcast error:" + e.getMessage() + ",action:" + str);
        }
    }

    public static void a(WebSettings webSettings) {
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName(HTTP.UTF_8);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= 11) {
            webSettings.setDisplayZoomControls(false);
        }
        webSettings.setCacheMode(2);
        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);
    }

    public static void a(WebView webView) {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            if (Build.VERSION.SDK_INT >= 21) {
                webView.getSettings().setMixedContentMode(0);
            }
        } catch (Throwable th) {
        }
    }

    public static boolean a() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, Class<?> cls) {
        try {
            return !context.getPackageManager().queryIntentActivities(new Intent(context, cls), 0).isEmpty();
        } catch (Throwable th) {
            f.a("AndroidUtil", "hasActivityResolves error:" + th.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            return !packageManager.queryBroadcastReceivers(intent, 0).isEmpty();
        } catch (Throwable th) {
            f.a("AndroidUtil", "hasReceiverIntentFilter error:" + th.getMessage());
            return false;
        }
    }

    public static void b(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getApplicationContext().getPackageName();
            if (packageName.isEmpty()) {
                f.c("AndroidUtil", "The package with the given name cannot be found!");
            } else {
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
                if (launchIntentForPackage == null) {
                    f.c("AndroidUtil", "Can't get launch intent for this package!");
                } else {
                    launchIntentForPackage.addFlags(Build.VERSION.SDK_INT >= 11 ? 268468224 : 268435456);
                    context.startActivity(launchIntentForPackage);
                }
            }
        } catch (Throwable th) {
            f.a("AndroidUtil", "startMainActivity error:" + th.getMessage());
        }
    }

    public static void b(Context context, Intent intent, String str) {
        String action = intent.getAction();
        if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(action) || JPushInterface.ACTION_NOTIFICATION_OPENED.equals(action)) {
            List<String> a = a(context, intent, str);
            if (a.isEmpty()) {
                f.c("AndroidUtil", "sendBroadcast failed again: receiver not found, action:" + intent.getAction());
                return;
            }
            for (String str2 : a) {
                try {
                    Intent intent2 = (Intent) intent.clone();
                    intent2.setComponent(new ComponentName(context.getPackageName(), str2));
                    if (TextUtils.isEmpty(str)) {
                        context.sendBroadcast(intent2);
                    } else {
                        context.sendBroadcast(intent2, str);
                    }
                } catch (Exception e) {
                    f.c("AndroidUtil", "sendBroadcast failed again:" + e.getMessage() + ", action:" + intent.getAction());
                }
            }
        }
    }

    public static boolean b(Context context, String str) {
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

    public static boolean c(Context context) {
        try {
            if (!cn.jiguang.api.i.getBoolean(context, "notification_enabled", true)) {
                f.b("AndroidUtil", "Notification was disabled by JPushInterface.setPushTime !");
                return false;
            }
            String b = cn.jpush.android.b.b(context);
            if (TextUtils.isEmpty(b)) {
                return true;
            }
            String[] split = b.split("_");
            String str = split[0];
            String str2 = split[1];
            char[] charArray = str.toCharArray();
            String[] split2 = str2.split("\\^");
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(7);
            int i2 = calendar.get(11);
            for (char c : charArray) {
                if (i == Integer.valueOf(String.valueOf(c)).intValue() + 1) {
                    int intValue = Integer.valueOf(split2[0]).intValue();
                    int intValue2 = Integer.valueOf(split2[1]).intValue();
                    if (i2 >= intValue && i2 <= intValue2) {
                        return true;
                    }
                }
            }
            f.b("AndroidUtil", "Current time is out of the push time - " + b);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean c(Context context, String str) {
        try {
            context.getPackageManager().getReceiverInfo(new ComponentName(context.getPackageName(), str), 128);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean d(Context context) {
        String string = cn.jiguang.api.i.getString(context, "setting_silence_push_time", "");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            int optInt = jSONObject.optInt("startHour", -1);
            int optInt2 = jSONObject.optInt("startMins", -1);
            int optInt3 = jSONObject.optInt("endHour", -1);
            int optInt4 = jSONObject.optInt("endtMins", -1);
            if (optInt < 0 || optInt2 < 0 || optInt3 < 0 || optInt4 < 0 || optInt2 > 59 || optInt4 > 59 || optInt3 > 23 || optInt > 23) {
                return false;
            }
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(11);
            int i2 = calendar.get(12);
            if (optInt < optInt3) {
                if ((i <= optInt || i >= optInt3) && ((i != optInt || i2 < optInt2) && (i != optInt3 || i2 > optInt4))) {
                    return false;
                }
            } else if (optInt == optInt3) {
                if (optInt2 >= optInt4) {
                    if (i == optInt && i2 > optInt4 && i2 < optInt2) {
                        return false;
                    }
                } else if (i != optInt || i2 < optInt2 || i2 > optInt4) {
                    return false;
                }
            } else if (optInt <= optInt3) {
                return false;
            } else {
                if ((i <= optInt || i > 23) && ((i < 0 || i >= optInt3) && ((i != optInt || i2 < optInt2) && (i != optInt3 || i2 > optInt4)))) {
                    return false;
                }
            }
            f.b("AndroidUtil", "Current time is in the range of silence time - " + optInt + Config.TRACE_TODAY_VISIT_SPLIT + optInt2 + " ~ " + optInt3 + Config.TRACE_TODAY_VISIT_SPLIT + optInt4);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public static boolean d(Context context, String str) {
        PackageManager packageManager;
        Intent intent;
        try {
            packageManager = context.getPackageManager();
            intent = new Intent(str);
            intent.addCategory(context.getPackageName());
        } catch (Throwable th) {
            f.a("AndroidUtil", "hasActivityIntentFilter error:" + th.getMessage());
        }
        return !packageManager.queryIntentActivities(intent, 0).isEmpty();
    }

    private static String e(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "Unknown";
            }
            String typeName = activeNetworkInfo.getTypeName();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            return typeName == null ? "Unknown" : !TextUtils.isEmpty(subtypeName) ? typeName + Constants.ACCEPT_TIME_SEPARATOR_SP + subtypeName : typeName;
        } catch (Exception e) {
            e.printStackTrace();
            return "Unknown";
        }
    }

    private static boolean f(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }
}
