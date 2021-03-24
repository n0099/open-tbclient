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
    public Context f1713a;

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.apmobilesecuritysdk.b.a f1714b = com.alipay.apmobilesecuritysdk.b.a.a();

    /* renamed from: c  reason: collision with root package name */
    public int f1715c = 4;

    public a(Context context) {
        this.f1713a = context;
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
        for (int i = 0; i < 3; i++) {
            try {
                String[] split = strArr[i].split(" ");
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
            Context context = this.f1713a;
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
                str2 = c3.f1723a;
                str = c3.f1725c;
            } else {
                str = "";
                str2 = str;
            }
            if (com.alipay.security.mobile.module.a.a.a(str2) && (c2 = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                str2 = c2.f1720a;
                str = c2.f1722c;
            }
            com.alipay.apmobilesecuritysdk.e.c b3 = com.alipay.apmobilesecuritysdk.e.d.b();
            if (b3 != null) {
                str4 = b3.f1723a;
                str3 = b3.f1725c;
            } else {
                str3 = "";
            }
            if (com.alipay.security.mobile.module.a.a.a(str4) && (b2 = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                str4 = b2.f1720a;
                str3 = b2.f1722c;
            }
            dVar.f2109h = str2;
            dVar.f2108g = str4;
            dVar.j = a4;
            if (com.alipay.security.mobile.module.a.a.a(str2)) {
                dVar.f2103b = str4;
                dVar.i = str3;
            } else {
                dVar.f2103b = str2;
                dVar.i = str;
            }
            dVar.f2107f = e.a(context, map);
            return com.alipay.security.mobile.module.http.d.b(this.f1713a, this.f1714b.c()).a(dVar);
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
                    String str = b3.f1723a;
                    if (com.alipay.security.mobile.module.a.a.b(str)) {
                        return str;
                    }
                }
                b b4 = com.alipay.apmobilesecuritysdk.e.a.b(context);
                if (b4 != null) {
                    i.a(b4);
                    String str2 = b4.f1720a;
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
            for (int i = 0; i < 5; i++) {
                String str = strArr[i];
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory, ".SystemConfig/" + str);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d6 A[Catch: Exception -> 0x023f, TryCatch #0 {Exception -> 0x023f, blocks: (B:3:0x0008, B:5:0x0039, B:8:0x0042, B:37:0x00c0, B:68:0x01e7, B:70:0x0202, B:72:0x0208, B:74:0x020e, B:78:0x0217, B:80:0x021d, B:40:0x00d6, B:42:0x00ee, B:48:0x00fb, B:49:0x010b, B:51:0x0112, B:55:0x0124, B:57:0x0174, B:59:0x017e, B:61:0x0186, B:63:0x0193, B:65:0x019d, B:67:0x01a5, B:66:0x01a1, B:60:0x0182, B:11:0x0057, B:13:0x0065, B:16:0x0070, B:18:0x0076, B:21:0x0081, B:24:0x008a, B:27:0x0097, B:30:0x00a4, B:33:0x00b2), top: B:86:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0202 A[Catch: Exception -> 0x023f, TryCatch #0 {Exception -> 0x023f, blocks: (B:3:0x0008, B:5:0x0039, B:8:0x0042, B:37:0x00c0, B:68:0x01e7, B:70:0x0202, B:72:0x0208, B:74:0x020e, B:78:0x0217, B:80:0x021d, B:40:0x00d6, B:42:0x00ee, B:48:0x00fb, B:49:0x010b, B:51:0x0112, B:55:0x0124, B:57:0x0174, B:59:0x017e, B:61:0x0186, B:63:0x0193, B:65:0x019d, B:67:0x01a5, B:66:0x01a1, B:60:0x0182, B:11:0x0057, B:13:0x0065, B:16:0x0070, B:18:0x0076, B:21:0x0081, B:24:0x008a, B:27:0x0097, B:30:0x00a4, B:33:0x00b2), top: B:86:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0208 A[Catch: Exception -> 0x023f, TryCatch #0 {Exception -> 0x023f, blocks: (B:3:0x0008, B:5:0x0039, B:8:0x0042, B:37:0x00c0, B:68:0x01e7, B:70:0x0202, B:72:0x0208, B:74:0x020e, B:78:0x0217, B:80:0x021d, B:40:0x00d6, B:42:0x00ee, B:48:0x00fb, B:49:0x010b, B:51:0x0112, B:55:0x0124, B:57:0x0174, B:59:0x017e, B:61:0x0186, B:63:0x0193, B:65:0x019d, B:67:0x01a5, B:66:0x01a1, B:60:0x0182, B:11:0x0057, B:13:0x0065, B:16:0x0070, B:18:0x0076, B:21:0x0081, B:24:0x008a, B:27:0x0097, B:30:0x00a4, B:33:0x00b2), top: B:86:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0217 A[Catch: Exception -> 0x023f, TryCatch #0 {Exception -> 0x023f, blocks: (B:3:0x0008, B:5:0x0039, B:8:0x0042, B:37:0x00c0, B:68:0x01e7, B:70:0x0202, B:72:0x0208, B:74:0x020e, B:78:0x0217, B:80:0x021d, B:40:0x00d6, B:42:0x00ee, B:48:0x00fb, B:49:0x010b, B:51:0x0112, B:55:0x0124, B:57:0x0174, B:59:0x017e, B:61:0x0186, B:63:0x0193, B:65:0x019d, B:67:0x01a5, B:66:0x01a1, B:60:0x0182, B:11:0x0057, B:13:0x0065, B:16:0x0070, B:18:0x0076, B:21:0x0081, B:24:0x008a, B:27:0x0097, B:30:0x00a4, B:33:0x00b2), top: B:86:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(Map<String, String> map) {
        String a2;
        boolean z;
        boolean z2;
        int i;
        String str;
        com.alipay.security.mobile.module.http.v2.a b2;
        Context context;
        NetworkInfo activeNetworkInfo;
        try {
            com.alipay.apmobilesecuritysdk.c.a.a(this.f1713a, com.alipay.security.mobile.module.a.a.a(map, "tid", ""), com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f1857g, ""), a(this.f1713a));
            a2 = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
            b();
            b(this.f1713a);
            a(this.f1713a, a2);
            i.a();
            z = false;
        } catch (Exception e2) {
            com.alipay.apmobilesecuritysdk.c.a.a(e2);
        }
        if (!a() && !com.alipay.apmobilesecuritysdk.common.a.a(this.f1713a)) {
            e.a();
            if (!(!com.alipay.security.mobile.module.a.a.a(e.b(this.f1713a, map), i.c()))) {
                String a3 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                String a4 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f1857g, "");
                if (com.alipay.security.mobile.module.a.a.b(a3)) {
                    if (!com.alipay.security.mobile.module.a.a.a(a3, i.d())) {
                    }
                }
                if (com.alipay.security.mobile.module.a.a.b(a4)) {
                    if (!com.alipay.security.mobile.module.a.a.a(a4, i.e())) {
                    }
                }
                if (i.a(this.f1713a, a2)) {
                    if (!com.alipay.security.mobile.module.a.a.a(a(this.f1713a, a2))) {
                        if (com.alipay.security.mobile.module.a.a.a(b(this.f1713a))) {
                        }
                        z2 = false;
                        h.b(this.f1713a, String.valueOf(com.alipay.security.mobile.module.deviceinfo.b.a().u()));
                        if (z2) {
                            new com.alipay.apmobilesecuritysdk.c.b();
                            UmidSdkWrapper.startUmidTaskSync(this.f1713a, com.alipay.apmobilesecuritysdk.b.a.a().b());
                            c b3 = b(map);
                            int a5 = b3 != null ? b3.a() : 2;
                            if (a5 != 1) {
                                if (a5 != 3) {
                                    if (b3 != null) {
                                        str = "Server error, result:" + b3.f2095b;
                                    } else {
                                        str = "Server error, returned null";
                                    }
                                    com.alipay.apmobilesecuritysdk.c.a.a(str);
                                    if (com.alipay.security.mobile.module.a.a.a(a(this.f1713a, a2))) {
                                        i = 4;
                                    }
                                } else {
                                    i = 1;
                                }
                                this.f1715c = i;
                                b2 = com.alipay.security.mobile.module.http.d.b(this.f1713a, this.f1714b.c());
                                context = this.f1713a;
                                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                                if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
                                    z = true;
                                }
                                if (z && h.c(context)) {
                                    new com.alipay.security.mobile.module.c.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b2).a();
                                }
                                return this.f1715c;
                            }
                            h.a(this.f1713a, b3.b());
                            h.d(this.f1713a, b3.c());
                            h.e(this.f1713a, b3.l);
                            h.a(this.f1713a, b3.m);
                            h.f(this.f1713a, b3.n);
                            h.g(this.f1713a, b3.p);
                            i.c(e.b(this.f1713a, map));
                            i.a(a2, b3.i);
                            i.b(b3.f2101h);
                            i.d(b3.o);
                            String a6 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                            if (!com.alipay.security.mobile.module.a.a.b(a6) || com.alipay.security.mobile.module.a.a.a(a6, i.d())) {
                                a6 = i.d();
                            } else {
                                i.e(a6);
                            }
                            i.e(a6);
                            String a7 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f1857g, "");
                            if (!com.alipay.security.mobile.module.a.a.b(a7) || com.alipay.security.mobile.module.a.a.a(a7, i.e())) {
                                a7 = i.e();
                            } else {
                                i.f(a7);
                            }
                            i.f(a7);
                            i.a();
                            com.alipay.apmobilesecuritysdk.e.d.a(this.f1713a, i.g());
                            com.alipay.apmobilesecuritysdk.e.d.a();
                            com.alipay.apmobilesecuritysdk.e.a.a(this.f1713a, new b(i.b(), i.c(), i.f()));
                            com.alipay.apmobilesecuritysdk.e.a.a();
                            g.a(this.f1713a, a2, i.a(a2));
                            g.a();
                            h.a(this.f1713a, a2, System.currentTimeMillis());
                        }
                        i = 0;
                        this.f1715c = i;
                        b2 = com.alipay.security.mobile.module.http.d.b(this.f1713a, this.f1714b.c());
                        context = this.f1713a;
                        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
                        if (connectivityManager2 != null) {
                        }
                        if (activeNetworkInfo != null) {
                            z = true;
                        }
                        if (z) {
                            new com.alipay.security.mobile.module.c.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b2).a();
                        }
                        return this.f1715c;
                    }
                }
            }
            z2 = true;
            h.b(this.f1713a, String.valueOf(com.alipay.security.mobile.module.deviceinfo.b.a().u()));
            if (z2) {
            }
            i = 0;
            this.f1715c = i;
            b2 = com.alipay.security.mobile.module.http.d.b(this.f1713a, this.f1714b.c());
            context = this.f1713a;
            ConnectivityManager connectivityManager22 = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager22 != null) {
            }
            if (activeNetworkInfo != null) {
            }
            if (z) {
            }
            return this.f1715c;
        }
        if (!com.alipay.security.mobile.module.a.a.a(a(this.f1713a, a2))) {
            if (com.alipay.security.mobile.module.a.a.a(b(this.f1713a))) {
            }
            z2 = false;
            h.b(this.f1713a, String.valueOf(com.alipay.security.mobile.module.deviceinfo.b.a().u()));
            if (z2) {
            }
            i = 0;
            this.f1715c = i;
            b2 = com.alipay.security.mobile.module.http.d.b(this.f1713a, this.f1714b.c());
            context = this.f1713a;
            ConnectivityManager connectivityManager222 = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager222 != null) {
            }
            if (activeNetworkInfo != null) {
            }
            if (z) {
            }
            return this.f1715c;
        }
        z2 = true;
        h.b(this.f1713a, String.valueOf(com.alipay.security.mobile.module.deviceinfo.b.a().u()));
        if (z2) {
        }
        i = 0;
        this.f1715c = i;
        b2 = com.alipay.security.mobile.module.http.d.b(this.f1713a, this.f1714b.c());
        context = this.f1713a;
        ConnectivityManager connectivityManager2222 = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager2222 != null) {
        }
        if (activeNetworkInfo != null) {
        }
        if (z) {
        }
        return this.f1715c;
    }
}
