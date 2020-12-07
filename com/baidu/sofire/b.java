package com.baidu.sofire;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f3599a = -1;
    private static int c = 0;
    static ThreadLocal<StringBuilder> b = new ThreadLocal<>();

    public static void a() {
    }

    public static void b() {
    }

    public static void c() {
    }

    public static String a(Throwable th) {
        StringWriter stringWriter;
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
            try {
            } catch (Throwable th3) {
                com.baidu.sofire.i.e.a();
                return "";
            }
        }
        try {
            stringWriter = new StringWriter();
            try {
                th.printStackTrace(new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                try {
                    stringWriter.close();
                    return stringWriter2;
                } catch (IOException e) {
                    e.printStackTrace();
                    return stringWriter2;
                }
            } catch (Throwable th4) {
                th = th4;
                if (stringWriter != null) {
                    try {
                        stringWriter.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            stringWriter = null;
        }
    }

    public static void d() {
    }
}
