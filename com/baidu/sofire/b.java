package com.baidu.sofire;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f10174a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static ThreadLocal<StringBuilder> f10175b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    public static int f10176c;

    public static String a(Throwable th) {
        StringWriter stringWriter;
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
            try {
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        StringWriter stringWriter2 = null;
        try {
            stringWriter = new StringWriter();
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter3 = stringWriter.toString();
            try {
                stringWriter.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return stringWriter3;
        } catch (Throwable th4) {
            th = th4;
            stringWriter2 = stringWriter;
            if (stringWriter2 != null) {
                try {
                    stringWriter2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void a() {
    }

    public static void b() {
    }

    public static void c() {
    }
}
