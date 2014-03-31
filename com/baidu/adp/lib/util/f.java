package com.baidu.adp.lib.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class f {
    private static String a = null;
    private static ArrayList<String> b = new ArrayList<>();

    public static void a(String str) {
        if (!TextUtils.isEmpty(str) && !b.contains(str)) {
            b.add(str);
        }
    }

    public static boolean a() {
        return com.baidu.adp.a.b.a().d();
    }

    public static void a(String str, String str2, String str3) {
        String a2 = a(true, str, str2, str3);
        if (a2 != null) {
            Log.i("BaiduLog", a2);
        }
    }

    public static void b(String str, String str2, String str3) {
        String a2 = a(false, str, str2, str3);
        if (a2 != null) {
            g(a2);
            Log.e("BaiduLog", a2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        String a2 = a(false, str, str2, th.getMessage());
        if (a2 != null) {
            g(a2);
            Log.e("BaiduLog", a2);
        }
    }

    public static void c(String str, String str2, String str3) {
        String a2 = a(false, str, str2, str3);
        if (a2 != null) {
            Log.w("BaiduLog", a2);
        }
    }

    public static void d(String str, String str2, String str3) {
        String a2 = a(true, str, str2, str3);
        if (a2 != null) {
            Log.v("BaiduLog", a2);
        }
    }

    public static void e(String str, String str2, String str3) {
        String a2 = a(true, str, str2, str3);
        if (a2 != null) {
            Log.d("BaiduLog", a2);
        }
    }

    public static void a(Class<?> cls, String str, String str2) {
        e(cls.getName(), str, str2);
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        b(cls.getName(), str, th.getMessage());
    }

    private static String a(boolean z, String str, String str2, String str3) {
        if (com.baidu.adp.a.b.a().d()) {
            if (a == null || str3.startsWith(a)) {
                if (!z || f(str)) {
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
        return null;
    }

    private static int a(int i, String str) {
        if (com.baidu.adp.a.b.a().d()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length < 5) {
                return -1;
            }
            StackTraceElement stackTraceElement = stackTrace[4];
            String methodName = stackTraceElement.getMethodName();
            String className = stackTraceElement.getClassName();
            if (i <= 1 || f(className)) {
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
        return -1;
    }

    private static boolean f(String str) {
        if (b.size() == 0) {
            return false;
        }
        Iterator<String> it = b.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static int b(String str) {
        return a(0, str);
    }

    public static int c(String str) {
        return a(1, str);
    }

    public static int d(String str) {
        return a(2, str);
    }

    public static int e(String str) {
        return a(3, str);
    }

    private static void g(String str) {
        new Thread(new g(str)).start();
    }
}
