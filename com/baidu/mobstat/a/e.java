package com.baidu.mobstat.a;

import android.text.format.DateFormat;
import android.util.Log;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class e {
    private static DateFormat a;

    static {
        a = null;
        a();
        a = new DateFormat();
    }

    public static int a(String str) {
        return a("sdkstat", str);
    }

    public static int a(String str, String str2) {
        if (a(3)) {
            b(str, str2);
            return Log.d(str, str2);
        }
        return -1;
    }

    public static int a(String str, Throwable th) {
        if (a(3)) {
            a("sdkstat", str, th);
            return Log.d("sdkstat", str, th);
        }
        return -1;
    }

    public static int a(Throwable th) {
        return a("", th);
    }

    public static int a(Object... objArr) {
        if (a(3)) {
            return a(d(objArr));
        }
        return -1;
    }

    public static void a() {
        c.a("_b_sdk.log");
    }

    private static void a(String str, String str2, Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        b(str, str2 + IOUtils.LINE_SEPARATOR_UNIX + stringWriter.toString());
        printWriter.close();
        try {
            stringWriter.close();
        } catch (IOException e) {
            Log.w("Log.debug", "", e);
        }
    }

    public static boolean a(int i) {
        return a("sdkstat", i);
    }

    public static boolean a(String str, int i) {
        return i >= b.a;
    }

    public static int b(String str) {
        if (a(5)) {
            b("sdkstat", str);
            return Log.w("sdkstat", str);
        }
        return -1;
    }

    public static int b(String str, Throwable th) {
        if (a(6)) {
            a("sdkstat", str, th);
            return Log.e("sdkstat", str, th);
        }
        return -1;
    }

    public static int b(Throwable th) {
        return b("", th);
    }

    public static int b(Object... objArr) {
        if (a(5)) {
            return b(d(objArr));
        }
        return -1;
    }

    private static synchronized void b(String str, String str2) {
        synchronized (e.class) {
        }
    }

    public static int c(String str) {
        if (a(6)) {
            b("sdkstat", str);
            return Log.e("sdkstat", str);
        }
        return -1;
    }

    public static int c(Object... objArr) {
        if (a(6)) {
            return c(d(objArr));
        }
        return -1;
    }

    private static String d(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj).append(' ');
        }
        return sb.toString();
    }
}
