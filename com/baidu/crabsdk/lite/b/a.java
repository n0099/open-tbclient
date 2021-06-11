package com.baidu.crabsdk.lite.b;

import android.util.Log;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f4690a = "CRABLITE";

    public static boolean a(String str) {
        HashMap<String, Object> hashMap;
        Object obj;
        if (str == null || (hashMap = com.baidu.crabsdk.lite.a.f4658a.get(str)) == null || (obj = hashMap.get("sdk_log")) == null) {
            return true;
        }
        return ((Boolean) obj).booleanValue();
    }

    public static String b(String str) {
        String str2;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals("com.baidu.crabsdk.util.BLog")) {
                    str2 = "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
                    break;
                }
            }
        }
        str2 = null;
        if (str2 == null) {
            return str;
        }
        return str2 + " - " + str;
    }

    public static int c(String str, String str2) {
        if (a(str)) {
            return Log.d(f4690a, b(str2));
        }
        return -1;
    }

    public static int d(String str, String str2) {
        if (a(str)) {
            return Log.e(f4690a, b(str2));
        }
        return -1;
    }

    public static int e(String str, String str2, Throwable th) {
        if (a(str)) {
            return Log.e(f4690a, b(str2), th);
        }
        return -1;
    }

    public static int f(String str, String str2) {
        if (a(str)) {
            return Log.i(f4690a, b(str2));
        }
        return -1;
    }

    public static int g(String str, String str2) {
        if (a(str)) {
            return Log.w(f4690a, b(str2));
        }
        return -1;
    }
}
