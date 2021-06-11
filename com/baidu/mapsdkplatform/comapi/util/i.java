package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.util.io.PathUtils;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.aps.megapp_interface.BuildConfig;
import com.tencent.open.SocialOperation;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static Context f7962a = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f7965d = null;

    /* renamed from: e  reason: collision with root package name */
    public static final String f7966e = "i";

    /* renamed from: h  reason: collision with root package name */
    public static String f7969h;

    /* renamed from: i  reason: collision with root package name */
    public static String f7970i;
    public static String j;
    public static String k;
    public static int l;
    public static int m;
    public static int n;
    public static int o;
    public static int p;
    public static int q;
    public static String r;
    public static String w;
    public static String x;

    /* renamed from: f  reason: collision with root package name */
    public static com.baidu.mapsdkplatform.comjni.util.a f7967f = new com.baidu.mapsdkplatform.comjni.util.a();

    /* renamed from: g  reason: collision with root package name */
    public static String f7968g = "02";
    public static String s = PathUtils.DIRCTORY_BAIDU;
    public static String t = "";
    public static String u = "";
    public static String v = "";
    public static String y = "-1";
    public static String z = "-1";

    /* renamed from: b  reason: collision with root package name */
    public static final int f7963b = Integer.parseInt(Build.VERSION.SDK);

    /* renamed from: c  reason: collision with root package name */
    public static float f7964c = 1.0f;
    public static String A = "";
    public static Map<String, String> B = new HashMap();

    public static void a() {
        d();
    }

    public static void a(String str) {
        r = str;
        f();
    }

    public static void a(String str, String str2) {
        y = str2;
        z = str;
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
        bundle.putString("cpu", t);
        bundle.putString("resid", f7968g);
        bundle.putString("channel", s);
        bundle.putString("glr", u);
        bundle.putString("glv", v);
        bundle.putString("mb", g());
        bundle.putString("sv", i());
        bundle.putString(IAdRequestParam.OS, k());
        bundle.putInt("dpi_x", l());
        bundle.putInt("dpi_y", l());
        bundle.putString("net", r);
        bundle.putString("cuid", A);
        bundle.putByteArray(SocialOperation.GAME_SIGNATURE, a(f7962a));
        bundle.putString("pcn", f7962a.getPackageName());
        bundle.putInt("screen_x", h());
        bundle.putInt("screen_y", j());
        com.baidu.mapsdkplatform.comjni.util.a aVar = f7967f;
        if (aVar != null) {
            aVar.a(bundle);
        }
        return bundle;
    }

    public static void b(Context context) {
        f7962a = context;
        if (context.getFilesDir() != null) {
            w = context.getFilesDir().getAbsolutePath();
        }
        if (context.getCacheDir() != null) {
            x = context.getCacheDir().getAbsolutePath();
        }
        f7970i = Build.MODEL;
        j = "Android" + Build.VERSION.SDK;
        f7969h = context.getPackageName();
        c(context);
        d(context);
        q();
        A = p();
        B.put("resid", AppMD5.encodeUrlParamsValue(f7968g));
        B.put("channel", AppMD5.encodeUrlParamsValue(m()));
        B.put("mb", AppMD5.encodeUrlParamsValue(g()));
        B.put("sv", AppMD5.encodeUrlParamsValue(i()));
        B.put(IAdRequestParam.OS, AppMD5.encodeUrlParamsValue(k()));
        B.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(l()), Integer.valueOf(l()))));
        B.put("cuid", AppMD5.encodeUrlParamsValue(A));
        B.put("pcn", AppMD5.encodeUrlParamsValue(f7962a.getPackageName()));
        B.put("screen", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(h()), Integer.valueOf(j()))));
        com.baidu.mapsdkplatform.comjni.util.a aVar = f7967f;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static String c() {
        if (B == null) {
            return null;
        }
        Date date = new Date();
        long time = date.getTime() + (date.getSeconds() * 1000);
        B.put("ctm", AppMD5.encodeUrlParamsValue(String.format("%f", Double.valueOf((time / 1000) + ((time % 1000) / 1000.0d)))));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : B.entrySet()) {
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
            k = apiVersion;
            if (apiVersion != null && !apiVersion.equals("")) {
                k = k.replace('_', IStringUtil.EXTENSION_SEPARATOR);
            }
            l = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            k = BuildConfig.VERSION_NAME;
            l = 1;
        }
    }

    public static void d() {
        com.baidu.mapsdkplatform.comjni.util.a aVar = f7967f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public static void d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        if (defaultDisplay != null) {
            m = defaultDisplay.getWidth();
            n = defaultDisplay.getHeight();
            defaultDisplay.getMetrics(displayMetrics);
        }
        f7964c = displayMetrics.density;
        o = (int) displayMetrics.xdpi;
        p = (int) displayMetrics.ydpi;
        if (f7963b > 3) {
            q = displayMetrics.densityDpi;
        } else {
            q = 160;
        }
        if (q == 0) {
            q = 160;
        }
    }

    public static String e() {
        return r;
    }

    public static void f() {
        B.put("net", AppMD5.encodeUrlParamsValue(e()));
        B.put("appid", AppMD5.encodeUrlParamsValue(y));
        B.put("bduid", "");
        if (f7967f == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("cpu", t);
        bundle.putString("resid", f7968g);
        bundle.putString("channel", s);
        bundle.putString("glr", u);
        bundle.putString("glv", v);
        bundle.putString("mb", g());
        bundle.putString("sv", i());
        bundle.putString(IAdRequestParam.OS, k());
        bundle.putInt("dpi_x", l());
        bundle.putInt("dpi_y", l());
        bundle.putString("net", r);
        bundle.putString("cuid", A);
        bundle.putString("pcn", f7962a.getPackageName());
        bundle.putInt("screen_x", h());
        bundle.putInt("screen_y", j());
        bundle.putString("appid", y);
        bundle.putString("duid", z);
        if (!TextUtils.isEmpty(f7965d)) {
            bundle.putString("token", f7965d);
        }
        f7967f.a(bundle);
        SysUpdateObservable.getInstance().updatePhoneInfo();
    }

    public static String g() {
        return f7970i;
    }

    public static int h() {
        return m;
    }

    public static String i() {
        return k;
    }

    public static int j() {
        return n;
    }

    public static String k() {
        return j;
    }

    public static int l() {
        return q;
    }

    public static String m() {
        return s;
    }

    public static String n() {
        return f7969h;
    }

    public static String o() {
        return w;
    }

    public static String p() {
        String str;
        try {
            str = CommonParam.getCUID(f7962a);
        } catch (Exception unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static void q() {
        r = "0";
    }
}
