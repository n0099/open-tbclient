package com.baidu.sofire;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f11630a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static ThreadLocal<StringBuilder> f11631b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    public static int f11632c;

    public static String a(Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
            try {
            } catch (Throwable unused) {
                com.baidu.sofire.g.d.a();
                return "";
            }
        }
        StringWriter stringWriter = null;
        try {
            StringWriter stringWriter2 = new StringWriter();
            try {
                th.printStackTrace(new PrintWriter(stringWriter2));
                String stringWriter3 = stringWriter2.toString();
                try {
                    stringWriter2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return stringWriter3;
            } catch (Throwable th3) {
                th = th3;
                stringWriter = stringWriter2;
                if (stringWriter != null) {
                    try {
                        stringWriter.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static void a() {
    }

    public static void b() {
    }

    public static void c() {
    }

    public static void d() {
    }
}
