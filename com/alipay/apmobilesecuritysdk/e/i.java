package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static String f1734a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f1735b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f1736c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f1737d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f1738e = "";

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, String> f1739f = new HashMap();

    public static synchronized String a(String str) {
        synchronized (i.class) {
            String str2 = "apdidTokenCache" + str;
            if (f1739f.containsKey(str2)) {
                String str3 = f1739f.get(str2);
                if (com.alipay.security.mobile.module.a.a.b(str3)) {
                    return str3;
                }
            }
            return "";
        }
    }

    public static synchronized void a() {
        synchronized (i.class) {
        }
    }

    public static synchronized void a(b bVar) {
        synchronized (i.class) {
            if (bVar != null) {
                f1734a = bVar.f1720a;
                f1735b = bVar.f1721b;
                f1736c = bVar.f1722c;
            }
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (i.class) {
            if (cVar != null) {
                f1734a = cVar.f1723a;
                f1735b = cVar.f1724b;
                f1737d = cVar.f1726d;
                f1738e = cVar.f1727e;
                f1736c = cVar.f1725c;
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        synchronized (i.class) {
            String str3 = "apdidTokenCache" + str;
            if (f1739f.containsKey(str3)) {
                f1739f.remove(str3);
            }
            f1739f.put(str3, str2);
        }
    }

    public static synchronized boolean a(Context context, String str) {
        synchronized (i.class) {
            long j = 86400000;
            try {
                long a2 = h.a(context);
                if (a2 >= 0) {
                    j = a2;
                }
            } catch (Throwable unused) {
            }
            try {
                if (Math.abs(System.currentTimeMillis() - h.h(context, str)) < j) {
                    return true;
                }
            } finally {
                return false;
            }
            return false;
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (i.class) {
            str = f1734a;
        }
        return str;
    }

    public static void b(String str) {
        f1734a = str;
    }

    public static synchronized String c() {
        String str;
        synchronized (i.class) {
            str = f1735b;
        }
        return str;
    }

    public static void c(String str) {
        f1735b = str;
    }

    public static synchronized String d() {
        String str;
        synchronized (i.class) {
            str = f1737d;
        }
        return str;
    }

    public static void d(String str) {
        f1736c = str;
    }

    public static synchronized String e() {
        String str;
        synchronized (i.class) {
            str = f1738e;
        }
        return str;
    }

    public static void e(String str) {
        f1737d = str;
    }

    public static synchronized String f() {
        String str;
        synchronized (i.class) {
            str = f1736c;
        }
        return str;
    }

    public static void f(String str) {
        f1738e = str;
    }

    public static synchronized c g() {
        c cVar;
        synchronized (i.class) {
            cVar = new c(f1734a, f1735b, f1736c, f1737d, f1738e);
        }
        return cVar;
    }

    public static void h() {
        f1739f.clear();
        f1734a = "";
        f1735b = "";
        f1737d = "";
        f1738e = "";
        f1736c = "";
    }
}
