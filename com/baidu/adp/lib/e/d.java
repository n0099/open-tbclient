package com.baidu.adp.lib.e;

import android.util.Log;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f417a = null;

    public static boolean a() {
        return com.baidu.adp.a.b.a().b();
    }

    public static void a(String str, String str2, String str3) {
        String f = f(str, str2, str3);
        if (f != null) {
            Log.i("BaiduLog", f);
        }
    }

    public static void b(String str, String str2, String str3) {
        String f = f(str, str2, str3);
        if (f != null) {
            Log.e("BaiduLog", f);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        String f = f(str, str2, th.getMessage());
        if (f != null) {
            Log.e("BaiduLog", f);
        }
    }

    public static void c(String str, String str2, String str3) {
        String f = f(str, str2, str3);
        if (f != null) {
            Log.w("BaiduLog", f);
        }
    }

    public static void d(String str, String str2, String str3) {
        String f = f(str, str2, str3);
        if (f != null) {
            Log.v("BaiduLog", f);
        }
    }

    public static void e(String str, String str2, String str3) {
        String f = f(str, str2, str3);
        if (f != null) {
            Log.d("BaiduLog", f);
        }
    }

    public static void a(Class cls, String str, Throwable th) {
        b(cls.getName(), str, th.getMessage());
    }

    private static String f(String str, String str2, String str3) {
        if (com.baidu.adp.a.b.a().b()) {
            if (f417a == null || str3.startsWith(f417a)) {
                StringBuffer stringBuffer = new StringBuffer(100);
                stringBuffer.append(str);
                stringBuffer.append(":");
                stringBuffer.append(str2);
                stringBuffer.append(":");
                stringBuffer.append(str3);
                return stringBuffer.toString();
            }
            return null;
        }
        return null;
    }

    public static int a(int i, String str) {
        if (com.baidu.adp.a.b.a().b()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length < 5) {
                return -1;
            }
            StackTraceElement stackTraceElement = stackTrace[4];
            String methodName = stackTraceElement.getMethodName();
            String className = stackTraceElement.getClassName();
            if (i == 0) {
                b(className, methodName, str);
            } else if (i == 1) {
                c(className, methodName, str);
            } else if (i == 2) {
                a(className, methodName, str);
            } else if (i == 3) {
                e(className, methodName, str);
            } else {
                d(className, methodName, str);
            }
            return 0;
        }
        return -1;
    }

    public static int a(String str) {
        return a(0, str);
    }

    public static int b(String str) {
        return a(2, str);
    }

    public static int c(String str) {
        return a(3, str);
    }

    public static int d(String str) {
        return a(4, str);
    }
}
