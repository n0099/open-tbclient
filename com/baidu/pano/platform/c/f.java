package com.baidu.pano.platform.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class f {
    public static f j;

    /* renamed from: a  reason: collision with root package name */
    public int f9445a;

    /* renamed from: b  reason: collision with root package name */
    public int f9446b;

    /* renamed from: c  reason: collision with root package name */
    public int f9447c;

    /* renamed from: d  reason: collision with root package name */
    public int f9448d;

    /* renamed from: e  reason: collision with root package name */
    public String f9449e = "-1";

    /* renamed from: f  reason: collision with root package name */
    public String f9450f = "02";

    /* renamed from: g  reason: collision with root package name */
    public String f9451g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f9452h = "baidu";
    public Context i;

    public f(Context context) {
        this.i = context;
        n();
        m();
    }

    public static f a(Context context) {
        if (j == null) {
            j = new f(context);
        }
        return j;
    }

    private String b() {
        return "Android" + Build.VERSION.SDK_INT;
    }

    private String c() {
        return j.a();
    }

    private String d() {
        return e.b(this.i);
    }

    private String e() {
        return "com.baidu.BaiduMap".equals(h()) ? "01" : this.f9450f;
    }

    private String f() {
        String str;
        try {
            str = com.baidu.android.bbalbs.common.util.b.b(this.i);
        } catch (Exception unused) {
            str = null;
        }
        return str == null ? "" : str;
    }

    private String g() {
        return this.f9452h;
    }

    private String h() {
        return this.i.getPackageName();
    }

    private int i() {
        return this.f9445a;
    }

    private int j() {
        return this.f9446b;
    }

    private int k() {
        return this.f9447c;
    }

    private int l() {
        return this.f9448d;
    }

    private void m() {
        DisplayMetrics displayMetrics = this.i.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            this.f9447c = (int) displayMetrics.xdpi;
            this.f9448d = (int) displayMetrics.ydpi;
        }
    }

    private void n() {
        DisplayMetrics displayMetrics = this.i.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            this.f9445a = displayMetrics.widthPixels;
            this.f9446b = displayMetrics.heightPixels;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String a2 = a();
        try {
            sb.append("mb=");
            sb.append(URLEncoder.encode(a2, "UTF-8"));
            String b2 = b();
            sb.append("&os=");
            sb.append(URLEncoder.encode(b2, "UTF-8"));
            String c2 = c();
            sb.append("&sv=");
            sb.append(URLEncoder.encode(c2, "UTF-8"));
            String d2 = d();
            sb.append("&net=");
            sb.append(URLEncoder.encode(d2, "UTF-8"));
            String e2 = e();
            sb.append("&resid=");
            sb.append(URLEncoder.encode(e2, "UTF-8"));
            String f2 = f();
            sb.append("&cuid=");
            sb.append(URLEncoder.encode(f2, "UTF-8"));
            String g2 = g();
            sb.append("&channel=");
            sb.append(URLEncoder.encode(g2, "UTF-8"));
            String h2 = h();
            sb.append("&pcn=");
            sb.append(URLEncoder.encode(h2, "UTF-8"));
            String b3 = b(this.i);
            sb.append("&name=");
            sb.append(URLEncoder.encode(b3, "UTF-8"));
            sb.append("&screen=");
            sb.append(URLEncoder.encode("(" + i() + ',' + j() + ')', "UTF-8"));
            sb.append("&dpi=");
            sb.append(URLEncoder.encode("(" + k() + ',' + l() + ')', "UTF-8"));
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        return sb.toString();
    }

    private String a() {
        return Build.MODEL;
    }

    private String b(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return applicationInfo != null ? (String) packageManager.getApplicationLabel(applicationInfo) : "";
    }
}
