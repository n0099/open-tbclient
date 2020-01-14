package com.baidu.swan.apps.as;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationManagerCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.picture.params.LaunchParams;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.p;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ai {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Handler sHandler = new Handler(Looper.getMainLooper());

    @NonNull
    public static String I(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        String str4 = str + str2 + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
        if (DEBUG) {
            Log.d("SwanAppUtils", "buildPageUrl pageUrl: " + str4);
        }
        if (TextUtils.isEmpty(str3)) {
            return ag.toFileUriString(str4);
        }
        Uri fileUri = ag.toFileUri(str4);
        if (fileUri == null) {
            return ag.toFileUriString(str4);
        }
        if (DEBUG) {
            Log.d("SwanAppUtils", "buildPageUrl pageUrl: " + str4 + str3);
        }
        return fileUri.buildUpon().query(str3).build().toString();
    }

    public static boolean a(SwanAppConfigData swanAppConfigData, com.baidu.swan.apps.model.b bVar, boolean z) {
        boolean z2 = true;
        if (swanAppConfigData == null) {
            return false;
        }
        if (DEBUG) {
            Log.d("SwanAppUtils", "checkPageParam pageParam : " + bVar.mPage);
            Log.d("SwanAppUtils", "checkPageParam allowTab : " + z);
        }
        if (z) {
            return swanAppConfigData.kN(bVar.mPage) || swanAppConfigData.kO(bVar.mPage);
        }
        if (!swanAppConfigData.kN(bVar.mPage) || swanAppConfigData.kO(bVar.mPage)) {
            z2 = false;
        }
        return z2;
    }

    public static boolean a(SwanAppConfigData swanAppConfigData, com.baidu.swan.apps.model.b bVar) {
        return swanAppConfigData != null && swanAppConfigData.abe() && swanAppConfigData.kO(bVar.mPage);
    }

    public static void j(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            sHandler.postAtFrontOfQueue(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0L);
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            sHandler.postDelayed(runnable, j);
        } else {
            runnable.run();
        }
    }

    public static void k(Runnable runnable) {
        sHandler.removeCallbacks(runnable);
    }

    public static void l(Runnable runnable) {
        b(runnable, 0L);
    }

    public static void b(Runnable runnable, long j) {
        sHandler.postDelayed(runnable, j);
    }

    public static String bm(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                Log.w("SwanAppUtils", "openUrl && downloadUrl is empty");
            }
            return null;
        }
        StringBuilder append = new StringBuilder(SchemeConfig.getSchemeHead()).append("://v26/swan/openApp?upgrade=0");
        try {
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            jSONObject.put("open", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            jSONObject.put(LaunchParams.SRC_TYPE_DOWNLOAD, str2);
            append.append("&params=");
            append.append(URLEncoder.encode(jSONObject.toString(), "utf-8"));
        } catch (UnsupportedEncodingException | JSONException e) {
            if (DEBUG) {
                Log.w("SwanAppUtils", Log.getStackTraceString(e));
            }
        }
        return append.toString();
    }

    public static String aeN() {
        return gO(Integer.MAX_VALUE);
    }

    @Nullable
    public static String gO(int i) {
        int i2 = 0;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (i2 >= i) {
                break;
            }
            if (stackTraceElement != null) {
                sb.append(stackTraceElement.toString()).append("\n");
                i2++;
            }
        }
        return sb.toString();
    }

    @RequiresApi(api = 23)
    public static boolean aeO() {
        return !a.hasMarshMallow() || AppRuntime.getAppContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static Uri getUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) || str.startsWith("file://") || str.startsWith("res:/")) {
            return Uri.parse(str);
        }
        if (str.startsWith("/")) {
            return Uri.fromFile(new File(str));
        }
        return null;
    }

    public static AbsoluteLayout iE(String str) {
        com.baidu.swan.apps.adaptation.b.d Gy;
        com.baidu.swan.apps.adaptation.b.e hg = com.baidu.swan.apps.y.f.UC().hg(str);
        if (hg == null || (Gy = hg.Gy()) == null) {
            return null;
        }
        return Gy.getCurrentWebView();
    }

    public static void aeP() {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "onPreloadNextEnv()");
        }
        SwanAppActivity Un = com.baidu.swan.apps.y.f.UC().Un();
        if (Un != null) {
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "2");
            Un.m(bundle);
            com.baidu.swan.apps.core.slave.b.e(Un, 600L);
        }
    }

    public static String aeQ() {
        com.baidu.swan.apps.core.d.d LY = com.baidu.swan.apps.y.f.UC().LY();
        if (LY != null) {
            return LY.LJ();
        }
        return null;
    }

    @Nullable
    public static String mF(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    stringBuffer.append(charAt);
                }
            }
            return stringBuffer.toString();
        }
        return str;
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.w("SwanAppUtils", e.getMessage());
            }
            return null;
        }
    }

    public static String getPackageVersion(Context context, String str) {
        PackageInfo packageInfo = getPackageInfo(context, str);
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    public static String getVersionName() {
        try {
            Application RG = com.baidu.swan.apps.w.a.RG();
            return RG.getPackageManager().getPackageInfo(RG.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String aeR() {
        String str;
        if (a.hasMarshMallow() && com.baidu.swan.apps.w.a.RG().checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) com.baidu.swan.apps.w.a.RG().getSystemService("phone");
            str = telephonyManager != null ? telephonyManager.getDeviceId() : null;
        } catch (Exception e) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static Bitmap a(com.baidu.swan.apps.x.b.b bVar, String str, boolean z) {
        String str2 = "";
        if (bVar != null && !TextUtils.isEmpty(bVar.getIconUrl())) {
            str2 = bVar.getIconUrl();
        }
        return m(str2, str, z);
    }

    public static Bitmap m(String str, String str2, boolean z) {
        return a(str, str2, z, (p.a) null);
    }

    public static Bitmap a(final String str, String str2, boolean z, final p.a aVar) {
        Uri uri = getUri(str);
        if (p.f(uri)) {
            return p.a(uri, AppRuntime.getAppContext());
        }
        if (uri != null) {
            if (aVar != null) {
                com.facebook.drawee.a.a.c.dkl().e(ImageRequestBuilder.X(uri).dro(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.as.ai.1
                    @Override // com.facebook.imagepipeline.e.b
                    protected void onNewResultImpl(Bitmap bitmap) {
                        Bitmap copy;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            try {
                                if (bitmap.getConfig() == null) {
                                    copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                                } else {
                                    copy = bitmap.copy(bitmap.getConfig(), true);
                                }
                                p.a.this.h(str, copy);
                                return;
                            } catch (Exception e) {
                                p.a.this.h(str, null);
                                return;
                            }
                        }
                        p.a.this.h(str, null);
                    }

                    @Override // com.facebook.datasource.a
                    protected void onFailureImpl(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
                        p.a.this.h(str, null);
                    }

                    @Override // com.facebook.datasource.a, com.facebook.datasource.d
                    public void onCancellation(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
                        super.onCancellation(bVar);
                        p.a.this.h(str, null);
                    }
                }, com.facebook.common.b.i.djq());
            } else {
                p.b(uri, str2);
            }
        }
        return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), z ? a.e.aiapps_default_icon : a.e.aiapps_default_grey_icon);
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.e("SwanAppUtils", str + " is not found");
                return false;
            }
            return false;
        }
    }

    public static boolean launchApp(Context context, String str) {
        boolean z = true;
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(Uri.decode(str), 1);
            parseUri.setFlags(268435456);
            if (parseUri.resolveActivityInfo(context.getPackageManager(), 65536) != null) {
                c.startActivitySafely(context, parseUri);
            } else {
                z = false;
            }
            return z;
        } catch (URISyntaxException e) {
            if (DEBUG) {
                Log.w("SwanAppUtils", Log.getStackTraceString(e));
                return false;
            }
            return false;
        }
    }

    public static boolean a(final Context context, String str, final CallbackHandler callbackHandler, final String str2) {
        String charSequence;
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            final Intent parseUri = Intent.parseUri(Uri.decode(str), 1);
            parseUri.setFlags(268435456);
            PackageManager packageManager = context.getPackageManager();
            ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(packageManager, 65536);
            if (resolveActivityInfo == null) {
                return false;
            }
            String str3 = context.getResources().getString(a.h.swanapp_open_app_dialog_tips) + packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString() + (TextUtils.isEmpty(resolveActivityInfo.applicationInfo.loadLabel(packageManager).toString()) ? "" : context.getResources().getString(a.h.swanapp_open_app_dialog_tips1) + charSequence);
            String string = context.getString(a.h.aiapps_ok);
            String string2 = context.getString(a.h.aiapps_cancel);
            g.a aVar = new g.a(context);
            aVar.du(true).ku(str3).a(new com.baidu.swan.apps.view.c.a()).dw(false);
            aVar.a(string, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.as.ai.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    boolean startActivitySafely = c.startActivitySafely(context, parseUri);
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(startActivitySafely ? 0 : 1001, startActivitySafely ? "打开APP成功" : "打开APP失败，本地没有安装").toString());
                }
            });
            aVar.b(string2, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.as.ai.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    CallbackHandler.this.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1004, "取消打开APP").toString());
                }
            });
            aVar.ZZ();
            return true;
        } catch (PackageManager.NameNotFoundException | URISyntaxException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public static boolean ar(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanAppUtils", "downloadParams is " + str.toString());
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (TextUtils.isEmpty(jSONObject.optString("url"))) {
                return false;
            }
            return com.baidu.swan.apps.w.a.RQ().h(context, jSONObject);
        } catch (JSONException e) {
            if (!DEBUG) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public static String getWifiInfo(Context context) {
        String str;
        try {
            str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanAppUtils", "getWifiInfo fail!" + e.toString());
            }
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static boolean aeS() {
        return TextUtils.equals("baiduboxapp", com.baidu.swan.apps.w.a.Sr().Ft());
    }

    public static void cI(Context context) {
        SchemeRouter.invoke(context, "baiduboxapp://v1/easybrowse/open?url=" + Uri.encode("https://baozhang.baidu.com/guarantee/m/#/swan-guarantee") + "&newbrowser=1");
    }

    public static int mG(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            if (!DEBUG) {
                return -1;
            }
            e.printStackTrace();
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int releaseFixedOrientation(Activity activity) {
        int i;
        Throwable e;
        if (DEBUG) {
            Log.d("ScreenOrientationCompat", "releaseFixedOrientation() called with: activity = [" + activity + "]");
        }
        if (Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || !isTranslucentOrFloating(activity) || !isFixedOrientation(activity)) {
            return -1;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            Field declaredField2 = ActivityInfo.class.getDeclaredField("screenOrientation");
            declaredField2.setAccessible(true);
            i = declaredField2.getInt(obj);
            if (i != -1) {
                try {
                    declaredField2.setInt(obj, -1);
                    if (DEBUG) {
                        Log.d("ScreenOrientationCompat", "set " + activity.getComponentName() + " screenOrientation to UNSPECIFIED");
                        return i;
                    }
                    return i;
                } catch (IllegalAccessException e2) {
                    e = e2;
                    if (!DEBUG) {
                        Log.e("SwanAppUtils", "releaseFixedOrientation reflect fail", e);
                        return i;
                    }
                    return i;
                } catch (NoSuchFieldException e3) {
                    e = e3;
                    if (!DEBUG) {
                    }
                }
            } else {
                return i;
            }
        } catch (IllegalAccessException e4) {
            i = -1;
            e = e4;
        } catch (NoSuchFieldException e5) {
            i = -1;
            e = e5;
        }
    }

    private static boolean isTranslucentOrFloating(Activity activity) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$styleable");
            Field declaredField = cls.getDeclaredField("Window");
            declaredField.setAccessible(true);
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) declaredField.get(null));
            Field declaredField2 = cls.getDeclaredField("Window_windowIsTranslucent");
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("Window_windowSwipeToDismiss");
            declaredField3.setAccessible(true);
            Field declaredField4 = cls.getDeclaredField("Window_windowIsFloating");
            declaredField4.setAccessible(true);
            return obtainStyledAttributes.getBoolean(((Integer) declaredField4.get(null)).intValue(), false) || obtainStyledAttributes.getBoolean(((Integer) declaredField2.get(null)).intValue(), false) || (!obtainStyledAttributes.hasValue(((Integer) declaredField2.get(null)).intValue()) && obtainStyledAttributes.getBoolean(((Integer) declaredField3.get(null)).intValue(), false));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            if (DEBUG) {
                Log.e("SwanAppUtils", "isTranslucentOrFloating reflect fail", e);
            }
            return false;
        }
    }

    private static boolean isFixedOrientation(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isFixedOrientation", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
            if (DEBUG) {
                Log.e("SwanAppUtils", "isFixedOrientation reflect fail", e);
            }
            return false;
        }
    }

    public static void fixedOrientation(Activity activity, int i) {
        if (DEBUG) {
            Log.d("ScreenOrientationCompat", "fixedOrientation() called with: activity = [" + activity + "], orientation = [" + i + "]");
        }
        if (i != -1 && Build.VERSION.SDK_INT == 26 && activity.getApplicationInfo().targetSdkVersion > 26 && isTranslucentOrFloating(activity) && !isFixedOrientation(activity)) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(activity);
                Field declaredField2 = ActivityInfo.class.getDeclaredField("screenOrientation");
                declaredField2.setAccessible(true);
                if (declaredField2.getInt(obj) == -1) {
                    declaredField2.setInt(obj, i);
                    if (DEBUG) {
                        Log.d("ScreenOrientationCompat", "set " + activity.getComponentName() + " screenOrientation to " + i);
                    }
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                if (DEBUG) {
                    Log.e("SwanAppUtils", "isTranslucentOrFloating reflect fail", e);
                }
            }
        }
    }

    public static boolean aeT() {
        return g.aem();
    }

    public static com.baidu.swan.apps.model.b aeU() {
        com.baidu.swan.apps.model.b bVar = new com.baidu.swan.apps.model.b();
        bVar.mParams = "";
        bVar.mPage = "";
        com.baidu.swan.apps.core.d.e El = com.baidu.swan.apps.y.f.UC().El();
        if (El != null && El.LY() != null) {
            return El.LY().LM();
        }
        return bVar;
    }

    public static boolean cJ(@NonNull Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public static boolean cK(@NonNull Context context) {
        LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
        if (locationManager != null) {
            return locationManager.isProviderEnabled("gps");
        }
        return false;
    }

    public static boolean cL(@NonNull Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager != null) {
            return wifiManager.isWifiEnabled();
        }
        return false;
    }

    public static boolean isOnUiThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
