package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.android.imsdk.BuildConfig;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.webkit.internal.ETAG;
import com.tencent.open.SocialOperation;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class f {
    static String b;
    static String c;
    static String d;
    static String e;
    static int f;
    static int g;
    static int h;
    static int i;
    static int j;
    static int k;
    static String l;
    static String m;
    static String s;
    static String t;
    public static Context w;
    public static String z;
    private static final String A = f.class.getSimpleName();
    private static com.baidu.mapsdkplatform.comjni.util.a B = new com.baidu.mapsdkplatform.comjni.util.a();
    static String a = "02";
    static String n = BuildConfig.FLAVOR;
    static String o = BuildConfig.FLAVOR;
    static String p = "";
    static String q = "";
    static String r = "";
    static String u = "-1";
    static String v = "-1";
    public static final int x = Integer.parseInt(Build.VERSION.SDK);
    public static float y = 1.0f;
    private static boolean C = true;
    private static int D = 0;
    private static int E = 0;
    private static Map<String, String> F = new HashMap();

    public static void a() {
        d();
    }

    public static void a(String str) {
        l = str;
        f();
    }

    public static void a(String str, String str2) {
        u = str2;
        v = str;
        f();
    }

    public static byte[] a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString(com.baidu.fsg.face.base.b.c.i, p);
        bundle.putString("resid", a);
        bundle.putString("channel", n);
        bundle.putString("glr", q);
        bundle.putString("glv", r);
        bundle.putString("mb", g());
        bundle.putString("sv", i());
        bundle.putString("os", k());
        bundle.putInt("dpi_x", l());
        bundle.putInt("dpi_y", l());
        bundle.putString("net", l);
        bundle.putString("cuid", o());
        bundle.putByteArray(SocialOperation.GAME_SIGNATURE, a(w));
        bundle.putString("pcn", w.getPackageName());
        bundle.putInt("screen_x", h());
        bundle.putInt("screen_y", j());
        if (B != null) {
            B.a(bundle);
            Log.d("phoneInfo", "mAppSysOSAPI not null");
        }
        Log.d("phoneInfo", bundle.toString());
        return bundle;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0053 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static void b(Context context) {
        ?? r1 = 1;
        r1 = 1;
        ?? r2 = 0;
        r2 = 0;
        w = context;
        if (context.getFilesDir() != null) {
            s = context.getFilesDir().getAbsolutePath();
        }
        if (context.getCacheDir() != null) {
            t = context.getCacheDir().getAbsolutePath();
        }
        c = Build.MODEL;
        d = "Android" + Build.VERSION.SDK;
        b = context.getPackageName();
        c(context);
        d(context);
        e(context);
        f(context);
        try {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                D = locationManager.isProviderEnabled("gps") ? 1 : 0;
                E = locationManager.isProviderEnabled("network") ? 1 : 0;
                F.put("resid", AppMD5.encodeUrlParamsValue(a));
                F.put("channel", AppMD5.encodeUrlParamsValue(m()));
                F.put("mb", AppMD5.encodeUrlParamsValue(g()));
                F.put("sv", AppMD5.encodeUrlParamsValue(i()));
                F.put("os", AppMD5.encodeUrlParamsValue(k()));
                F.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(l()), Integer.valueOf(l()))));
                F.put("cuid", AppMD5.encodeUrlParamsValue(o()));
                F.put("pcn", AppMD5.encodeUrlParamsValue(w.getPackageName()));
                Map<String, String> map = F;
                Integer valueOf = Integer.valueOf(j());
                String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(h()), valueOf));
                map.put("screen", encodeUrlParamsValue);
                r1 = encodeUrlParamsValue;
                r2 = valueOf;
            } catch (Exception e2) {
                Log.w("baidumapsdk", "LocationManager error");
                F.put("resid", AppMD5.encodeUrlParamsValue(a));
                F.put("channel", AppMD5.encodeUrlParamsValue(m()));
                F.put("mb", AppMD5.encodeUrlParamsValue(g()));
                F.put("sv", AppMD5.encodeUrlParamsValue(i()));
                F.put("os", AppMD5.encodeUrlParamsValue(k()));
                F.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(l()), Integer.valueOf(l()))));
                F.put("cuid", AppMD5.encodeUrlParamsValue(o()));
                F.put("pcn", AppMD5.encodeUrlParamsValue(w.getPackageName()));
                Map<String, String> map2 = F;
                Integer valueOf2 = Integer.valueOf(j());
                String encodeUrlParamsValue2 = AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(h()), valueOf2));
                map2.put("screen", encodeUrlParamsValue2);
                r1 = encodeUrlParamsValue2;
                r2 = valueOf2;
            }
            if (B != null) {
                B.a();
            }
        } catch (Throwable th) {
            F.put("resid", AppMD5.encodeUrlParamsValue(a));
            F.put("channel", AppMD5.encodeUrlParamsValue(m()));
            F.put("mb", AppMD5.encodeUrlParamsValue(g()));
            F.put("sv", AppMD5.encodeUrlParamsValue(i()));
            F.put("os", AppMD5.encodeUrlParamsValue(k()));
            Map<String, String> map3 = F;
            Object[] objArr = new Object[2];
            objArr[r2] = Integer.valueOf(l());
            objArr[r1] = Integer.valueOf(l());
            map3.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", objArr)));
            F.put("cuid", AppMD5.encodeUrlParamsValue(o()));
            F.put("pcn", AppMD5.encodeUrlParamsValue(w.getPackageName()));
            Map<String, String> map4 = F;
            Object[] objArr2 = new Object[2];
            objArr2[r2] = Integer.valueOf(h());
            objArr2[r1] = Integer.valueOf(j());
            map4.put("screen", AppMD5.encodeUrlParamsValue(String.format("%d,%d", objArr2)));
            throw th;
        }
    }

    public static String c() {
        if (F == null) {
            return null;
        }
        Date date = new Date();
        long seconds = (date.getSeconds() * 1000) + date.getTime();
        F.put("ctm", AppMD5.encodeUrlParamsValue(String.format("%f", Double.valueOf(((seconds % 1000) / 1000.0d) + (seconds / 1000)))));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : F.entrySet()) {
            sb.append(ETAG.ITEM_SEPARATOR).append(entry.getKey()).append(ETAG.EQUAL).append(entry.getValue());
        }
        return sb.toString();
    }

    private static void c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            e = VersionInfo.getApiVersion();
            if (e != null && !e.equals("")) {
                e = e.replace('_', '.');
            }
            f = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e = com.baidu.searchbox.aps.megapp_interface.BuildConfig.VERSION_NAME;
            f = 1;
        }
    }

    public static void d() {
        if (B != null) {
            B.b();
        }
    }

    private static void d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        if (defaultDisplay != null) {
            g = defaultDisplay.getWidth();
            h = defaultDisplay.getHeight();
            defaultDisplay.getMetrics(displayMetrics);
        }
        y = displayMetrics.density;
        i = (int) displayMetrics.xdpi;
        j = (int) displayMetrics.ydpi;
        if (x > 3) {
            k = displayMetrics.densityDpi;
        } else {
            k = 160;
        }
        if (k == 0) {
            k = 160;
        }
    }

    public static String e() {
        return l;
    }

    private static void e(Context context) {
        m = Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static void f() {
        F.put("net", AppMD5.encodeUrlParamsValue(e()));
        F.put("appid", AppMD5.encodeUrlParamsValue(u));
        F.put("bduid", "");
        if (B == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.baidu.fsg.face.base.b.c.i, p);
        bundle.putString("resid", a);
        bundle.putString("channel", n);
        bundle.putString("glr", q);
        bundle.putString("glv", r);
        bundle.putString("mb", g());
        bundle.putString("sv", i());
        bundle.putString("os", k());
        bundle.putInt("dpi_x", l());
        bundle.putInt("dpi_y", l());
        bundle.putString("net", l);
        bundle.putString("cuid", o());
        bundle.putString("pcn", w.getPackageName());
        bundle.putInt("screen_x", h());
        bundle.putInt("screen_y", j());
        bundle.putString("appid", u);
        bundle.putString("duid", v);
        if (!TextUtils.isEmpty(z)) {
            bundle.putString("token", z);
        }
        B.a(bundle);
        SysUpdateObservable.getInstance().updatePhoneInfo();
    }

    private static void f(Context context) {
        l = "0";
    }

    public static String g() {
        return c;
    }

    public static int h() {
        return g;
    }

    public static String i() {
        return e;
    }

    public static int j() {
        return h;
    }

    public static String k() {
        return d;
    }

    public static int l() {
        return k;
    }

    public static String m() {
        return n;
    }

    public static String n() {
        return s;
    }

    public static String o() {
        String str;
        try {
            str = CommonParam.a(w);
        } catch (Exception e2) {
            str = "";
        }
        return str == null ? "" : str;
    }
}
