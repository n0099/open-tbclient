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
import com.baidu.android.common.others.IStringUtil;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.searchbox.aps.megapp_interface.BuildConfig;
import com.tencent.open.SocialOperation;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class f {
    public static final String A = "f";

    /* renamed from: b  reason: collision with root package name */
    public static String f7886b;

    /* renamed from: c  reason: collision with root package name */
    public static String f7887c;

    /* renamed from: d  reason: collision with root package name */
    public static String f7888d;

    /* renamed from: e  reason: collision with root package name */
    public static String f7889e;

    /* renamed from: f  reason: collision with root package name */
    public static int f7890f;

    /* renamed from: g  reason: collision with root package name */
    public static int f7891g;

    /* renamed from: h  reason: collision with root package name */
    public static int f7892h;
    public static int i;
    public static int j;
    public static int k;
    public static String l;
    public static String m;
    public static String s;
    public static String t;
    public static Context w;
    public static String z;
    public static com.baidu.mapsdkplatform.comjni.util.a B = new com.baidu.mapsdkplatform.comjni.util.a();

    /* renamed from: a  reason: collision with root package name */
    public static String f7885a = "02";
    public static String n = "baidu";
    public static String o = "baidu";
    public static String p = "";
    public static String q = "";
    public static String r = "";
    public static String u = "-1";
    public static String v = "-1";
    public static final int x = Integer.parseInt(Build.VERSION.SDK);
    public static float y = 1.0f;
    public static boolean C = true;
    public static int D = 0;
    public static int E = 0;
    public static Map<String, String> F = new HashMap();

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
        bundle.putString("cpu", p);
        bundle.putString("resid", f7885a);
        bundle.putString("channel", n);
        bundle.putString("glr", q);
        bundle.putString("glv", r);
        bundle.putString("mb", g());
        bundle.putString("sv", i());
        bundle.putString(IXAdRequestInfo.OS, k());
        bundle.putInt("dpi_x", l());
        bundle.putInt("dpi_y", l());
        bundle.putString("net", l);
        bundle.putString("cuid", o());
        bundle.putByteArray(SocialOperation.GAME_SIGNATURE, a(w));
        bundle.putString("pcn", w.getPackageName());
        bundle.putInt("screen_x", h());
        bundle.putInt("screen_y", j());
        com.baidu.mapsdkplatform.comjni.util.a aVar = B;
        if (aVar != null) {
            aVar.a(bundle);
            Log.d("phoneInfo", "mAppSysOSAPI not null");
        }
        Log.d("phoneInfo", bundle.toString());
        return bundle;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Context context) {
        Map<String, String> map;
        String format;
        String str = "pcn";
        Object obj = "cuid";
        String str2 = "dpi";
        String str3 = IXAdRequestInfo.OS;
        Object obj2 = "sv";
        String str4 = "mb";
        String str5 = "channel";
        String str6 = "resid";
        w = context;
        if (context.getFilesDir() != null) {
            s = context.getFilesDir().getAbsolutePath();
        }
        if (context.getCacheDir() != null) {
            t = context.getCacheDir().getAbsolutePath();
        }
        f7887c = Build.MODEL;
        f7888d = "Android" + Build.VERSION.SDK;
        f7886b = context.getPackageName();
        c(context);
        d(context);
        e(context);
        f(context);
        try {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                D = locationManager.isProviderEnabled("gps") ? 1 : 0;
                E = locationManager.isProviderEnabled("network") ? 1 : 0;
                F.put("resid", AppMD5.encodeUrlParamsValue(f7885a));
                Map<String, String> map2 = F;
                str6 = AppMD5.encodeUrlParamsValue(m());
                map2.put("channel", str6);
                Map<String, String> map3 = F;
                str5 = AppMD5.encodeUrlParamsValue(g());
                map3.put("mb", str5);
                Map<String, String> map4 = F;
                str4 = AppMD5.encodeUrlParamsValue(i());
                map4.put("sv", str4);
                F.put(IXAdRequestInfo.OS, AppMD5.encodeUrlParamsValue(k()));
                Map<String, String> map5 = F;
                obj2 = Integer.valueOf(l());
                str3 = AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(l()), obj2));
                map5.put("dpi", str3);
                Map<String, String> map6 = F;
                str2 = AppMD5.encodeUrlParamsValue(o());
                map6.put("cuid", str2);
                F.put("pcn", AppMD5.encodeUrlParamsValue(w.getPackageName()));
                map = F;
                obj = Integer.valueOf(j());
                format = String.format("%d,%d", Integer.valueOf(h()), obj);
            } catch (Exception unused) {
                Log.w("baidumapsdk", "LocationManager error");
                F.put("resid", AppMD5.encodeUrlParamsValue(f7885a));
                Map<String, String> map7 = F;
                str6 = AppMD5.encodeUrlParamsValue(m());
                map7.put("channel", str6);
                Map<String, String> map8 = F;
                str5 = AppMD5.encodeUrlParamsValue(g());
                map8.put("mb", str5);
                Map<String, String> map9 = F;
                str4 = AppMD5.encodeUrlParamsValue(i());
                map9.put("sv", str4);
                F.put(IXAdRequestInfo.OS, AppMD5.encodeUrlParamsValue(k()));
                Map<String, String> map10 = F;
                obj2 = Integer.valueOf(l());
                str3 = AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(l()), obj2));
                map10.put("dpi", str3);
                Map<String, String> map11 = F;
                str2 = AppMD5.encodeUrlParamsValue(o());
                map11.put("cuid", str2);
                F.put("pcn", AppMD5.encodeUrlParamsValue(w.getPackageName()));
                map = F;
                obj = Integer.valueOf(j());
                format = String.format("%d,%d", Integer.valueOf(h()), obj);
            }
            str = AppMD5.encodeUrlParamsValue(format);
            map.put("screen", str);
            com.baidu.mapsdkplatform.comjni.util.a aVar = B;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th) {
            F.put(str6, AppMD5.encodeUrlParamsValue(f7885a));
            F.put(str5, AppMD5.encodeUrlParamsValue(m()));
            F.put(str4, AppMD5.encodeUrlParamsValue(g()));
            F.put(obj2, AppMD5.encodeUrlParamsValue(i()));
            F.put(str3, AppMD5.encodeUrlParamsValue(k()));
            F.put(str2, AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(l()), Integer.valueOf(l()))));
            F.put(obj, AppMD5.encodeUrlParamsValue(o()));
            F.put(str, AppMD5.encodeUrlParamsValue(w.getPackageName()));
            F.put("screen", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(h()), Integer.valueOf(j()))));
            throw th;
        }
    }

    public static String c() {
        Date date;
        if (F == null) {
            return null;
        }
        long time = new Date().getTime() + (date.getSeconds() * 1000);
        double d2 = time / 1000;
        double d3 = time % 1000;
        Double.isNaN(d3);
        Double.isNaN(d2);
        F.put("ctm", AppMD5.encodeUrlParamsValue(String.format("%f", Double.valueOf(d2 + (d3 / 1000.0d)))));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : F.entrySet()) {
            sb.append("&");
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public static void c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String apiVersion = VersionInfo.getApiVersion();
            f7889e = apiVersion;
            if (apiVersion != null && !apiVersion.equals("")) {
                f7889e = f7889e.replace('_', IStringUtil.EXTENSION_SEPARATOR);
            }
            f7890f = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            f7889e = BuildConfig.VERSION_NAME;
            f7890f = 1;
        }
    }

    public static void d() {
        com.baidu.mapsdkplatform.comjni.util.a aVar = B;
        if (aVar != null) {
            aVar.b();
        }
    }

    public static void d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        if (defaultDisplay != null) {
            f7891g = defaultDisplay.getWidth();
            f7892h = defaultDisplay.getHeight();
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

    public static void e(Context context) {
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
        bundle.putString("cpu", p);
        bundle.putString("resid", f7885a);
        bundle.putString("channel", n);
        bundle.putString("glr", q);
        bundle.putString("glv", r);
        bundle.putString("mb", g());
        bundle.putString("sv", i());
        bundle.putString(IXAdRequestInfo.OS, k());
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

    public static void f(Context context) {
        l = "0";
    }

    public static String g() {
        return f7887c;
    }

    public static int h() {
        return f7891g;
    }

    public static String i() {
        return f7889e;
    }

    public static int j() {
        return f7892h;
    }

    public static String k() {
        return f7888d;
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
        } catch (Exception unused) {
            str = "";
        }
        return str == null ? "" : str;
    }
}
