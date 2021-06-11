package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static String f1714a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f1715b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f1716c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f1717d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f1718e = "";

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, String> f1719f = new HashMap();

    public static synchronized String a(String str) {
        synchronized (i.class) {
            String str2 = "apdidTokenCache" + str;
            if (f1719f.containsKey(str2)) {
                String str3 = f1719f.get(str2);
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
                f1714a = bVar.f1700a;
                f1715b = bVar.f1701b;
                f1716c = bVar.f1702c;
            }
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (i.class) {
            if (cVar != null) {
                f1714a = cVar.f1703a;
                f1715b = cVar.f1704b;
                f1717d = cVar.f1706d;
                f1718e = cVar.f1707e;
                f1716c = cVar.f1705c;
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        synchronized (i.class) {
            String str3 = "apdidTokenCache" + str;
            if (f1719f.containsKey(str3)) {
                f1719f.remove(str3);
            }
            f1719f.put(str3, str2);
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
            str = f1714a;
        }
        return str;
    }

    public static void b(String str) {
        f1714a = str;
    }

    public static synchronized String c() {
        String str;
        synchronized (i.class) {
            str = f1715b;
        }
        return str;
    }

    public static void c(String str) {
        f1715b = str;
    }

    public static synchronized String d() {
        String str;
        synchronized (i.class) {
            str = f1717d;
        }
        return str;
    }

    public static void d(String str) {
        f1716c = str;
    }

    public static synchronized String e() {
        String str;
        synchronized (i.class) {
            str = f1718e;
        }
        return str;
    }

    public static void e(String str) {
        f1717d = str;
    }

    public static synchronized String f() {
        String str;
        synchronized (i.class) {
            str = f1716c;
        }
        return str;
    }

    public static void f(String str) {
        f1718e = str;
    }

    public static synchronized c g() {
        c cVar;
        synchronized (i.class) {
            cVar = new c(f1714a, f1715b, f1716c, f1717d, f1718e);
        }
        return cVar;
    }

    public static void h() {
        f1719f.clear();
        f1714a = "";
        f1715b = "";
        f1717d = "";
        f1718e = "";
        f1716c = "";
    }
}
