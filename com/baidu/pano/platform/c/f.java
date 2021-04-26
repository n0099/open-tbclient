package com.baidu.pano.platform.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import com.baidu.android.util.io.PathUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class f {
    public static f j;

    /* renamed from: a  reason: collision with root package name */
    public int f9333a;

    /* renamed from: b  reason: collision with root package name */
    public int f9334b;

    /* renamed from: c  reason: collision with root package name */
    public int f9335c;

    /* renamed from: d  reason: collision with root package name */
    public int f9336d;

    /* renamed from: e  reason: collision with root package name */
    public String f9337e = "-1";

    /* renamed from: f  reason: collision with root package name */
    public String f9338f = "02";

    /* renamed from: g  reason: collision with root package name */
    public String f9339g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f9340h = PathUtils.DIRCTORY_BAIDU;

    /* renamed from: i  reason: collision with root package name */
    public Context f9341i;

    public f(Context context) {
        this.f9341i = context;
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
        return e.b(this.f9341i);
    }

    private String e() {
        return "com.baidu.BaiduMap".equals(h()) ? "01" : this.f9338f;
    }

    private String f() {
        String str;
        try {
            str = com.baidu.android.bbalbs.common.util.b.b(this.f9341i);
        } catch (Exception unused) {
            str = null;
        }
        return str == null ? "" : str;
    }

    private String g() {
        return this.f9340h;
    }

    private String h() {
        return this.f9341i.getPackageName();
    }

    private int i() {
        return this.f9333a;
    }

    private int j() {
        return this.f9334b;
    }

    private int k() {
        return this.f9335c;
    }

    private int l() {
        return this.f9336d;
    }

    private void m() {
        DisplayMetrics displayMetrics = this.f9341i.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            this.f9335c = (int) displayMetrics.xdpi;
            this.f9336d = (int) displayMetrics.ydpi;
        }
    }

    private void n() {
        DisplayMetrics displayMetrics = this.f9341i.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            this.f9333a = displayMetrics.widthPixels;
            this.f9334b = displayMetrics.heightPixels;
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
            String b3 = b(this.f9341i);
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
