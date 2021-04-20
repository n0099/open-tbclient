package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static String f1759a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f1760b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f1761c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f1762d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f1763e = "";

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, String> f1764f = new HashMap();

    public static synchronized String a(String str) {
        synchronized (i.class) {
            String str2 = "apdidTokenCache" + str;
            if (f1764f.containsKey(str2)) {
                String str3 = f1764f.get(str2);
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
                f1759a = bVar.f1745a;
                f1760b = bVar.f1746b;
                f1761c = bVar.f1747c;
            }
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (i.class) {
            if (cVar != null) {
                f1759a = cVar.f1748a;
                f1760b = cVar.f1749b;
                f1762d = cVar.f1751d;
                f1763e = cVar.f1752e;
                f1761c = cVar.f1750c;
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        synchronized (i.class) {
            String str3 = "apdidTokenCache" + str;
            if (f1764f.containsKey(str3)) {
                f1764f.remove(str3);
            }
            f1764f.put(str3, str2);
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
            str = f1759a;
        }
        return str;
    }

    public static void b(String str) {
        f1759a = str;
    }

    public static synchronized String c() {
        String str;
        synchronized (i.class) {
            str = f1760b;
        }
        return str;
    }

    public static void c(String str) {
        f1760b = str;
    }

    public static synchronized String d() {
        String str;
        synchronized (i.class) {
            str = f1762d;
        }
        return str;
    }

    public static void d(String str) {
        f1761c = str;
    }

    public static synchronized String e() {
        String str;
        synchronized (i.class) {
            str = f1763e;
        }
        return str;
    }

    public static void e(String str) {
        f1762d = str;
    }

    public static synchronized String f() {
        String str;
        synchronized (i.class) {
            str = f1761c;
        }
        return str;
    }

    public static void f(String str) {
        f1763e = str;
    }

    public static synchronized c g() {
        c cVar;
        synchronized (i.class) {
            cVar = new c(f1759a, f1760b, f1761c, f1762d, f1763e);
        }
        return cVar;
    }

    public static void h() {
        f1764f.clear();
        f1759a = "";
        f1760b = "";
        f1762d = "";
        f1763e = "";
        f1761c = "";
    }
}
