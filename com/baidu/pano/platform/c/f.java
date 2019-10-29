package com.baidu.pano.platform.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import com.baidu.android.imsdk.BuildConfig;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class f {
    private static f j;
    private int a;
    private int b;
    private int c;
    private int d;
    private String e = LivenessStat.TYPE_STRING_DEFAULT;
    private String f = "02";
    private String g = "";
    private String h = BuildConfig.FLAVOR;
    private Context i;

    public static f a(Context context) {
        if (j == null) {
            j = new f(context);
        }
        return j;
    }

    private f(Context context) {
        this.i = context;
        n();
        m();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("mb=").append(URLEncoder.encode(a(), HTTP.UTF_8));
            sb.append("&os=").append(URLEncoder.encode(b(), HTTP.UTF_8));
            sb.append("&sv=").append(URLEncoder.encode(c(), HTTP.UTF_8));
            sb.append("&net=").append(URLEncoder.encode(d(), HTTP.UTF_8));
            sb.append("&resid=").append(URLEncoder.encode(e(), HTTP.UTF_8));
            sb.append("&cuid=").append(URLEncoder.encode(f(), HTTP.UTF_8));
            sb.append("&channel=").append(URLEncoder.encode(g(), HTTP.UTF_8));
            sb.append("&pcn=").append(URLEncoder.encode(h(), HTTP.UTF_8));
            sb.append("&name=").append(URLEncoder.encode(b(this.i), HTTP.UTF_8));
            int i = i();
            sb.append("&screen=").append(URLEncoder.encode("(" + i + ',' + j() + ')', HTTP.UTF_8));
            int k = k();
            sb.append("&dpi=").append(URLEncoder.encode("(" + k + ',' + l() + ')', HTTP.UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private String a() {
        return Build.MODEL;
    }

    private String b() {
        StringBuilder sb = new StringBuilder();
        sb.append("Android").append(Build.VERSION.SDK_INT);
        return sb.toString();
    }

    private String c() {
        return j.a();
    }

    private String d() {
        return e.b(this.i);
    }

    private String e() {
        return "com.baidu.BaiduMap".equals(h()) ? "01" : this.f;
    }

    private String f() {
        String str = null;
        try {
            str = com.baidu.android.bbalbs.common.util.b.b(this.i);
        } catch (Exception e) {
        }
        return str == null ? "" : str;
    }

    private String g() {
        return this.h;
    }

    private String h() {
        return this.i.getPackageName();
    }

    private String b(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
            }
        } catch (PackageManager.NameNotFoundException e2) {
            packageManager = null;
        }
        if (applicationInfo == null) {
            return "";
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    private int i() {
        return this.a;
    }

    private int j() {
        return this.b;
    }

    private int k() {
        return this.c;
    }

    private int l() {
        return this.d;
    }

    private void m() {
        DisplayMetrics displayMetrics = this.i.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            this.c = (int) displayMetrics.xdpi;
            this.d = (int) displayMetrics.ydpi;
        }
    }

    private void n() {
        DisplayMetrics displayMetrics = this.i.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            this.a = displayMetrics.widthPixels;
            this.b = displayMetrics.heightPixels;
        }
    }
}
