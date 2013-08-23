package com.baidu.mobstat.a;

import android.util.Log;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleDateFormat f799a = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");

    static {
        a();
    }

    public static int a(String str) {
        return a("Mobads SDK", str);
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
            a("Mobads SDK", str, th);
            return Log.d("Mobads SDK", str, th);
        }
        return -1;
    }

    public static int a(Throwable th) {
        return a("", th);
    }

    public static int a(Object... objArr) {
        if (a(3)) {
            return a(c(objArr));
        }
        return -1;
    }

    public static void a() {
        a.a("_b_sdk.log");
    }

    private static void a(String str, String str2, Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        b(str, str2 + "\n" + stringWriter.toString());
        printWriter.close();
        try {
            stringWriter.close();
        } catch (IOException e) {
            Log.w("Log.debug", "", e);
        }
    }

    public static boolean a(int i) {
        return a("Mobads SDK", i);
    }

    public static boolean a(String str, int i) {
        return i >= 4;
    }

    public static int b(String str) {
        if (a(6)) {
            b("Mobads SDK", str);
            return Log.e("Mobads SDK", str);
        }
        return -1;
    }

    public static int b(Object... objArr) {
        if (a(6)) {
            return b(c(objArr));
        }
        return -1;
    }

    private static synchronized void b(String str, String str2) {
        synchronized (b.class) {
        }
    }

    private static String c(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj).append(' ');
        }
        return sb.toString();
    }
}
