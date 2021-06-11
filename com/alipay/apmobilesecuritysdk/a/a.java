package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.security.mobile.module.http.model.c;
import com.alipay.security.mobile.module.http.model.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f1693a;

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.apmobilesecuritysdk.b.a f1694b = com.alipay.apmobilesecuritysdk.b.a.a();

    /* renamed from: c  reason: collision with root package name */
    public int f1695c = 4;

    public a(Context context) {
        this.f1693a = context;
    }

    public static String a(Context context) {
        String b2 = b(context);
        return com.alipay.security.mobile.module.a.a.a(b2) ? h.f(context) : b2;
    }

    public static String a(Context context, String str) {
        try {
            b();
            String a2 = i.a(str);
            if (com.alipay.security.mobile.module.a.a.a(a2)) {
                String a3 = g.a(context, str);
                i.a(str, a3);
                return !com.alipay.security.mobile.module.a.a.a(a3) ? a3 : "";
            }
            return a2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int random = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                String[] split = strArr[i2].split(" ");
                if (split != null && split.length == 2) {
                    Date date = new Date();
                    Date parse = simpleDateFormat.parse(split[0] + " 00:00:00");
                    Date parse2 = simpleDateFormat.parse(split[1] + " 23:59:59");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(parse2);
                    calendar.add(13, random);
                    Date time = calendar.getTime();
                    if (date.after(parse) && date.before(time)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private c b(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        b b2;
        b c2;
        String str4 = "";
        try {
            Context context = this.f1693a;
            d dVar = new d();
            String a2 = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
            String a3 = com.alipay.security.mobile.module.a.a.a(map, "sessionId", "");
            String a4 = com.alipay.security.mobile.module.a.a.a(map, "rpcVersion", "");
            String a5 = a(context, a2);
            String securityToken = UmidSdkWrapper.getSecurityToken(context);
            String d2 = h.d(context);
            if (com.alipay.security.mobile.module.a.a.b(a3)) {
                dVar.f2104c = a3;
            } else {
                dVar.f2104c = a5;
            }
            dVar.f2105d = securityToken;
            dVar.f2106e = d2;
            dVar.f2102a = "android";
            com.alipay.apmobilesecuritysdk.e.c c3 = com.alipay.apmobilesecuritysdk.e.d.c(context);
            if (c3 != null) {
                str2 = c3.f1703a;
                str = c3.f1705c;
            } else {
                str = "";
                str2 = str;
            }
            if (com.alipay.security.mobile.module.a.a.a(str2) && (c2 = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                str2 = c2.f1700a;
                str = c2.f1702c;
            }
            com.alipay.apmobilesecuritysdk.e.c b3 = com.alipay.apmobilesecuritysdk.e.d.b();
            if (b3 != null) {
                str4 = b3.f1703a;
                str3 = b3.f1705c;
            } else {
                str3 = "";
            }
            if (com.alipay.security.mobile.module.a.a.a(str4) && (b2 = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                str4 = b2.f1700a;
                str3 = b2.f1702c;
            }
            dVar.f2109h = str2;
            dVar.f2108g = str4;
            dVar.j = a4;
            if (com.alipay.security.mobile.module.a.a.a(str2)) {
                dVar.f2103b = str4;
                dVar.f2110i = str3;
            } else {
                dVar.f2103b = str2;
                dVar.f2110i = str;
            }
            dVar.f2107f = e.a(context, map);
            return com.alipay.security.mobile.module.http.d.b(this.f1693a, this.f1694b.c()).a(dVar);
        } catch (Throwable th) {
            th.printStackTrace();
            com.alipay.apmobilesecuritysdk.c.a.a(th);
            return null;
        }
    }

    public static String b(Context context) {
        try {
            String b2 = i.b();
            if (com.alipay.security.mobile.module.a.a.a(b2)) {
                com.alipay.apmobilesecuritysdk.e.c b3 = com.alipay.apmobilesecuritysdk.e.d.b(context);
                if (b3 != null) {
                    i.a(b3);
                    String str = b3.f1703a;
                    if (com.alipay.security.mobile.module.a.a.b(str)) {
                        return str;
                    }
                }
                b b4 = com.alipay.apmobilesecuritysdk.e.a.b(context);
                if (b4 != null) {
                    i.a(b4);
                    String str2 = b4.f1700a;
                    return com.alipay.security.mobile.module.a.a.b(str2) ? str2 : "";
                }
                return "";
            }
            return b2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b() {
        try {
            String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i2 = 0; i2 < 5; i2++) {
                String str = strArr[i2];
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory, ".SystemConfig/" + str);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:37:0x00be, B:68:0x01e5, B:70:0x0200, B:72:0x0206, B:74:0x020c, B:78:0x0215, B:80:0x021b, B:40:0x00d4, B:42:0x00ec, B:48:0x00f9, B:49:0x0109, B:51:0x0110, B:55:0x0122, B:57:0x0172, B:59:0x017c, B:61:0x0184, B:63:0x0191, B:65:0x019b, B:67:0x01a3, B:66:0x019f, B:60:0x0180, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00b0), top: B:86:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0200 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:37:0x00be, B:68:0x01e5, B:70:0x0200, B:72:0x0206, B:74:0x020c, B:78:0x0215, B:80:0x021b, B:40:0x00d4, B:42:0x00ec, B:48:0x00f9, B:49:0x0109, B:51:0x0110, B:55:0x0122, B:57:0x0172, B:59:0x017c, B:61:0x0184, B:63:0x0191, B:65:0x019b, B:67:0x01a3, B:66:0x019f, B:60:0x0180, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00b0), top: B:86:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0206 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:37:0x00be, B:68:0x01e5, B:70:0x0200, B:72:0x0206, B:74:0x020c, B:78:0x0215, B:80:0x021b, B:40:0x00d4, B:42:0x00ec, B:48:0x00f9, B:49:0x0109, B:51:0x0110, B:55:0x0122, B:57:0x0172, B:59:0x017c, B:61:0x0184, B:63:0x0191, B:65:0x019b, B:67:0x01a3, B:66:0x019f, B:60:0x0180, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00b0), top: B:86:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0215 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:37:0x00be, B:68:0x01e5, B:70:0x0200, B:72:0x0206, B:74:0x020c, B:78:0x0215, B:80:0x021b, B:40:0x00d4, B:42:0x00ec, B:48:0x00f9, B:49:0x0109, B:51:0x0110, B:55:0x0122, B:57:0x0172, B:59:0x017c, B:61:0x0184, B:63:0x0191, B:65:0x019b, B:67:0x01a3, B:66:0x019f, B:60:0x0180, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00b0), top: B:86:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(Map<String, String> map) {
        String a2;
        boolean z;
        boolean z2;
        int i2;
        String str;
        com.alipay.security.mobile.module.http.v2.a b2;
        Context context;
        NetworkInfo activeNetworkInfo;
        try {
            com.alipay.apmobilesecuritysdk.c.a.a(this.f1693a, com.alipay.security.mobile.module.a.a.a(map, "tid", ""), com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f1843g, ""), a(this.f1693a));
            a2 = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
            b();
            b(this.f1693a);
            a(this.f1693a, a2);
            i.a();
            z = false;
        } catch (Exception e2) {
            com.alipay.apmobilesecuritysdk.c.a.a(e2);
        }
        if (!a() && !com.alipay.apmobilesecuritysdk.common.a.a(this.f1693a)) {
            e.a();
            if (!(!com.alipay.security.mobile.module.a.a.a(e.b(this.f1693a, map), i.c()))) {
                String a3 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                String a4 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f1843g, "");
                if (com.alipay.security.mobile.module.a.a.b(a3)) {
                    if (!com.alipay.security.mobile.module.a.a.a(a3, i.d())) {
                    }
                }
                if (com.alipay.security.mobile.module.a.a.b(a4)) {
                    if (!com.alipay.security.mobile.module.a.a.a(a4, i.e())) {
                    }
                }
                if (i.a(this.f1693a, a2)) {
                    if (!com.alipay.security.mobile.module.a.a.a(a(this.f1693a, a2))) {
                        if (com.alipay.security.mobile.module.a.a.a(b(this.f1693a))) {
                        }
                        z2 = false;
                        h.b(this.f1693a, String.valueOf(com.alipay.security.mobile.module.deviceinfo.b.a().u()));
                        if (z2) {
                            new com.alipay.apmobilesecuritysdk.c.b();
                            UmidSdkWrapper.startUmidTaskSync(this.f1693a, com.alipay.apmobilesecuritysdk.b.a.a().b());
                            c b3 = b(map);
                            int a5 = b3 != null ? b3.a() : 2;
                            if (a5 != 1) {
                                if (a5 != 3) {
                                    if (b3 != null) {
                                        str = "Server error, result:" + b3.f2094b;
                                    } else {
                                        str = "Server error, returned null";
                                    }
                                    com.alipay.apmobilesecuritysdk.c.a.a(str);
                                    if (com.alipay.security.mobile.module.a.a.a(a(this.f1693a, a2))) {
                                        i2 = 4;
                                    }
                                } else {
                                    i2 = 1;
                                }
                                this.f1695c = i2;
                                b2 = com.alipay.security.mobile.module.http.d.b(this.f1693a, this.f1694b.c());
                                context = this.f1693a;
                                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                                if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
                                    z = true;
                                }
                                if (z && h.c(context)) {
                                    new com.alipay.security.mobile.module.c.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b2).a();
                                }
                                return this.f1695c;
                            }
                            h.a(this.f1693a, b3.b());
                            h.d(this.f1693a, b3.c());
                            h.e(this.f1693a, b3.l);
                            h.a(this.f1693a, b3.m);
                            h.f(this.f1693a, b3.n);
                            h.g(this.f1693a, b3.p);
                            i.c(e.b(this.f1693a, map));
                            i.a(a2, b3.f2101i);
                            i.b(b3.f2100h);
                            i.d(b3.o);
                            String a6 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                            if (!com.alipay.security.mobile.module.a.a.b(a6) || com.alipay.security.mobile.module.a.a.a(a6, i.d())) {
                                a6 = i.d();
                            } else {
                                i.e(a6);
                            }
                            i.e(a6);
                            String a7 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f1843g, "");
                            if (!com.alipay.security.mobile.module.a.a.b(a7) || com.alipay.security.mobile.module.a.a.a(a7, i.e())) {
                                a7 = i.e();
                            } else {
                                i.f(a7);
                            }
                            i.f(a7);
                            i.a();
                            com.alipay.apmobilesecuritysdk.e.d.a(this.f1693a, i.g());
                            com.alipay.apmobilesecuritysdk.e.d.a();
                            com.alipay.apmobilesecuritysdk.e.a.a(this.f1693a, new b(i.b(), i.c(), i.f()));
                            com.alipay.apmobilesecuritysdk.e.a.a();
                            g.a(this.f1693a, a2, i.a(a2));
                            g.a();
                            h.a(this.f1693a, a2, System.currentTimeMillis());
                        }
                        i2 = 0;
                        this.f1695c = i2;
                        b2 = com.alipay.security.mobile.module.http.d.b(this.f1693a, this.f1694b.c());
                        context = this.f1693a;
                        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
                        if (connectivityManager2 != null) {
                        }
                        if (activeNetworkInfo != null) {
                            z = true;
                        }
                        if (z) {
                            new com.alipay.security.mobile.module.c.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b2).a();
                        }
                        return this.f1695c;
                    }
                }
            }
            z2 = true;
            h.b(this.f1693a, String.valueOf(com.alipay.security.mobile.module.deviceinfo.b.a().u()));
            if (z2) {
            }
            i2 = 0;
            this.f1695c = i2;
            b2 = com.alipay.security.mobile.module.http.d.b(this.f1693a, this.f1694b.c());
            context = this.f1693a;
            ConnectivityManager connectivityManager22 = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager22 != null) {
            }
            if (activeNetworkInfo != null) {
            }
            if (z) {
            }
            return this.f1695c;
        }
        if (!com.alipay.security.mobile.module.a.a.a(a(this.f1693a, a2))) {
            if (com.alipay.security.mobile.module.a.a.a(b(this.f1693a))) {
            }
            z2 = false;
            h.b(this.f1693a, String.valueOf(com.alipay.security.mobile.module.deviceinfo.b.a().u()));
            if (z2) {
            }
            i2 = 0;
            this.f1695c = i2;
            b2 = com.alipay.security.mobile.module.http.d.b(this.f1693a, this.f1694b.c());
            context = this.f1693a;
            ConnectivityManager connectivityManager222 = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager222 != null) {
            }
            if (activeNetworkInfo != null) {
            }
            if (z) {
            }
            return this.f1695c;
        }
        z2 = true;
        h.b(this.f1693a, String.valueOf(com.alipay.security.mobile.module.deviceinfo.b.a().u()));
        if (z2) {
        }
        i2 = 0;
        this.f1695c = i2;
        b2 = com.alipay.security.mobile.module.http.d.b(this.f1693a, this.f1694b.c());
        context = this.f1693a;
        ConnectivityManager connectivityManager2222 = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager2222 != null) {
        }
        if (activeNetworkInfo != null) {
        }
        if (z) {
        }
        return this.f1695c;
    }
}
