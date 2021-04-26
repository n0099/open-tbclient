package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static String f1701a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f1702b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f1703c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f1704d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f1705e = "";

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, String> f1706f = new HashMap();

    public static synchronized String a(String str) {
        synchronized (i.class) {
            String str2 = "apdidTokenCache" + str;
            if (f1706f.containsKey(str2)) {
                String str3 = f1706f.get(str2);
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
                f1701a = bVar.f1687a;
                f1702b = bVar.f1688b;
                f1703c = bVar.f1689c;
            }
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (i.class) {
            if (cVar != null) {
                f1701a = cVar.f1690a;
                f1702b = cVar.f1691b;
                f1704d = cVar.f1693d;
                f1705e = cVar.f1694e;
                f1703c = cVar.f1692c;
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        synchronized (i.class) {
            String str3 = "apdidTokenCache" + str;
            if (f1706f.containsKey(str3)) {
                f1706f.remove(str3);
            }
            f1706f.put(str3, str2);
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
            str = f1701a;
        }
        return str;
    }

    public static void b(String str) {
        f1701a = str;
    }

    public static synchronized String c() {
        String str;
        synchronized (i.class) {
            str = f1702b;
        }
        return str;
    }

    public static void c(String str) {
        f1702b = str;
    }

    public static synchronized String d() {
        String str;
        synchronized (i.class) {
            str = f1704d;
        }
        return str;
    }

    public static void d(String str) {
        f1703c = str;
    }

    public static synchronized String e() {
        String str;
        synchronized (i.class) {
            str = f1705e;
        }
        return str;
    }

    public static void e(String str) {
        f1704d = str;
    }

    public static synchronized String f() {
        String str;
        synchronized (i.class) {
            str = f1703c;
        }
        return str;
    }

    public static void f(String str) {
        f1705e = str;
    }

    public static synchronized c g() {
        c cVar;
        synchronized (i.class) {
            cVar = new c(f1701a, f1702b, f1703c, f1704d, f1705e);
        }
        return cVar;
    }

    public static void h() {
        f1706f.clear();
        f1701a = "";
        f1702b = "";
        f1704d = "";
        f1705e = "";
        f1703c = "";
    }
}
