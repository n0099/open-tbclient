package com.baidu.swan.apps.aq;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
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
import android.support.annotation.AnyThread;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.ActivityChooserView;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.q;
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
/* loaded from: classes11.dex */
public final class aj {
    private static String cKg;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Handler sHandler = new Handler(Looper.getMainLooper());

    @NonNull
    public static String M(String str, String str2, String str3) {
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
            return ah.toFileUriString(str4);
        }
        Uri fileUri = ah.toFileUri(str4);
        if (fileUri == null) {
            return ah.toFileUriString(str4);
        }
        if (DEBUG) {
            Log.d("SwanAppUtils", "buildPageUrl pageUrl: " + str4 + str3);
        }
        return fileUri.buildUpon().query(str3).build().toString();
    }

    public static boolean a(SwanAppConfigData swanAppConfigData, com.baidu.swan.apps.model.b bVar, boolean z) {
        boolean z2 = false;
        if (swanAppConfigData == null || bVar == null) {
            return false;
        }
        if (com.baidu.swan.apps.ae.b.a.mH(bVar.getPage())) {
            return true;
        }
        if (DEBUG) {
            Log.d("SwanAppUtils", "checkPageParam pageParam : " + bVar.mPage);
            Log.d("SwanAppUtils", "checkPageParam pageRouteParam : " + bVar.coT);
            Log.d("SwanAppUtils", "checkPageParam allowTab : " + z);
        }
        if (!z) {
            return swanAppConfigData.nK(bVar.coT) && !swanAppConfigData.nL(bVar.coT);
        }
        if (swanAppConfigData.nK(bVar.coT) || swanAppConfigData.nL(bVar.coT)) {
            z2 = true;
        }
        return z2;
    }

    public static boolean a(SwanAppConfigData swanAppConfigData, com.baidu.swan.apps.model.b bVar) {
        return swanAppConfigData != null && swanAppConfigData.apy() && swanAppConfigData.nL(bVar.coT);
    }

    public static void n(Runnable runnable) {
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

    public static void o(Runnable runnable) {
        sHandler.removeCallbacks(runnable);
    }

    public static void p(Runnable runnable) {
        c(runnable, 0L);
    }

    public static void c(Runnable runnable, long j) {
        sHandler.postDelayed(runnable, j);
    }

    public static String cb(String str, String str2) {
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
            jSONObject.put("download", str2);
            append.append("&params=");
            append.append(URLEncoder.encode(jSONObject.toString(), "utf-8"));
        } catch (UnsupportedEncodingException | JSONException e) {
            if (DEBUG) {
                Log.w("SwanAppUtils", Log.getStackTraceString(e));
            }
        }
        return append.toString();
    }

    public static String atN() {
        return hJ(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @Nullable
    public static String hJ(int i) {
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
    public static boolean atO() {
        return !b.hasMarshMallow() || AppRuntime.getAppContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
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

    public static AbsoluteLayout ls(String str) {
        com.baidu.swan.apps.adaptation.b.d Th;
        com.baidu.swan.apps.adaptation.b.e jO = com.baidu.swan.apps.w.f.ahV().jO(str);
        if (jO == null || (Th = jO.Th()) == null) {
            return null;
        }
        return Th.getCurrentWebView();
    }

    public static void atP() {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "onPreloadNextEnv()");
        }
        SwanAppActivity ahF = com.baidu.swan.apps.w.f.ahV().ahF();
        if (ahF != null) {
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "2");
            ahF.o(bundle);
            com.baidu.swan.apps.core.slave.b.e(ahF, 600L);
        }
    }

    public static String atQ() {
        com.baidu.swan.apps.core.d.d YQ = com.baidu.swan.apps.w.f.ahV().YQ();
        if (YQ != null) {
            return YQ.YB();
        }
        return null;
    }

    @Nullable
    public static String pP(@Nullable String str) {
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
            Application aeR = com.baidu.swan.apps.u.a.aeR();
            return aeR.getPackageManager().getPackageInfo(aeR.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String atR() {
        String str;
        if (com.baidu.swan.apps.performance.b.b.alL() && !TextUtils.isEmpty(cKg)) {
            return cKg;
        }
        Application aeR = com.baidu.swan.apps.u.a.aeR();
        if (b.hasMarshMallow() && ContextCompat.checkSelfPermission(aeR, "android.permission.READ_PHONE_STATE") != 0) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) aeR.getSystemService("phone");
            if (telephonyManager == null) {
                str = null;
            } else {
                str = telephonyManager.getDeviceId();
                try {
                    cKg = str;
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    @AnyThread
    public static void a(@NonNull final ImageView imageView, @Nullable String str, @DrawableRes final int i) {
        if (TextUtils.isEmpty(str)) {
            runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.aq.aj.1
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageResource(i);
                }
            });
            return;
        }
        final com.baidu.swan.config.e.a<Bitmap> aVar = new com.baidu.swan.config.e.a<Bitmap>() { // from class: com.baidu.swan.apps.aq.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.config.e.a
            /* renamed from: n */
            public void run(final Bitmap bitmap) {
                if (bitmap != null) {
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        imageView.setImageBitmap(bitmap);
                        return;
                    } else {
                        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.aq.aj.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                        return;
                    }
                }
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.aq.aj.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageResource(i);
                    }
                });
            }
        };
        aVar.run(a(str, str, false, new q.a() { // from class: com.baidu.swan.apps.aq.aj.3
            @Override // com.baidu.swan.apps.aq.q.a
            public void h(String str2, Bitmap bitmap) {
                com.baidu.swan.config.e.a.this.run(bitmap);
            }
        }));
    }

    public static Bitmap a(com.baidu.swan.apps.v.b.b bVar, String str, boolean z) {
        String str2 = "";
        if (bVar != null && !TextUtils.isEmpty(bVar.getIconUrl())) {
            str2 = bVar.getIconUrl();
        }
        return o(str2, str, z);
    }

    public static Bitmap o(String str, String str2, boolean z) {
        return a(str, str2, z, (q.a) null);
    }

    public static Bitmap a(final String str, String str2, boolean z, final q.a aVar) {
        Uri uri = getUri(str);
        if (q.i(uri)) {
            return q.b(uri, AppRuntime.getAppContext());
        }
        if (uri != null) {
            if (aVar != null) {
                com.facebook.drawee.a.a.c.dvv().e(ImageRequestBuilder.ab(uri).dCz(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.aq.aj.4
                    @Override // com.facebook.imagepipeline.e.b
                    protected void h(Bitmap bitmap) {
                        Bitmap copy;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            try {
                                if (bitmap.getConfig() == null) {
                                    copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                                } else {
                                    copy = bitmap.copy(bitmap.getConfig(), true);
                                }
                                q.a.this.h(str, copy);
                                return;
                            } catch (Exception e) {
                                q.a.this.h(str, null);
                                return;
                            }
                        }
                        q.a.this.h(str, null);
                    }

                    @Override // com.facebook.datasource.a
                    protected void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
                        q.a.this.h(str, null);
                    }

                    @Override // com.facebook.datasource.a, com.facebook.datasource.d
                    public void b(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
                        super.b(bVar);
                        q.a.this.h(str, null);
                    }
                }, com.facebook.common.b.i.duB());
            } else {
                q.b(uri, str2);
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
                d.startActivitySafely(context, parseUri);
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
            ResolveInfo resolveActivity = packageManager.resolveActivity(parseUri, 65536);
            if (resolveActivity == null || resolveActivity.activityInfo == null) {
                return false;
            }
            String str3 = context.getResources().getString(a.h.swanapp_open_app_dialog_tips) + packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString() + (TextUtils.isEmpty(resolveActivity.match != 0 ? resolveActivity.activityInfo.applicationInfo.loadLabel(packageManager).toString() : "其他应用") ? "" : context.getResources().getString(a.h.swanapp_open_app_dialog_tips1) + charSequence);
            String string = context.getString(a.h.aiapps_ok);
            String string2 = context.getString(a.h.aiapps_cancel);
            g.a aVar = new g.a(context);
            aVar.eR(true).nq(str3).a(new com.baidu.swan.apps.view.c.a()).eT(false);
            aVar.a(string, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.aq.aj.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    boolean startActivitySafely = d.startActivitySafely(context, parseUri);
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(startActivitySafely ? 0 : 1001, startActivitySafely ? "打开APP成功" : "打开APP失败，本地没有安装").toString());
                }
            });
            aVar.b(string2, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.aq.aj.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    CallbackHandler.this.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1004, "取消打开APP").toString());
                }
            });
            aVar.aon();
            return true;
        } catch (PackageManager.NameNotFoundException | URISyntaxException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public static boolean Z(Context context, String str) {
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
            return com.baidu.swan.apps.u.a.afb().h(context, jSONObject);
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

    public static boolean atS() {
        return TextUtils.equals("baiduboxapp", com.baidu.swan.apps.u.a.afB().sz());
    }

    public static void cz(Context context) {
        SchemeRouter.invoke(context, "baiduboxapp://v1/easybrowse/open?url=" + Uri.encode("https://baozhang.baidu.com/guarantee/m/#/swan-guarantee") + "&newbrowser=1");
    }

    public static int pQ(String str) {
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

    public static boolean atT() {
        return h.atj();
    }

    public static com.baidu.swan.apps.model.b atU() {
        com.baidu.swan.apps.model.b bVar = new com.baidu.swan.apps.model.b();
        bVar.mParams = "";
        bVar.mPage = "";
        com.baidu.swan.apps.core.d.e QH = com.baidu.swan.apps.w.f.ahV().QH();
        if (QH != null && QH.YQ() != null) {
            return QH.YQ().YF();
        }
        return bVar;
    }

    public static boolean cA(@NonNull Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public static boolean cB(@NonNull Context context) {
        if (w.Y(context, "android.permission.ACCESS_FINE_LOCATION")) {
            try {
                LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
                if (locationManager != null) {
                    return locationManager.isProviderEnabled("gps");
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return false;
    }

    public static boolean cC(@NonNull Context context) {
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
