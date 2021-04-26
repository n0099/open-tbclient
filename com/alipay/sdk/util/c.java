package com.alipay.sdk.util;

import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1940a = "alipaysdk";

    public static void a(String str, String str2) {
    }

    public static void a(String str, String str2, Throwable th) {
    }

    public static void a(String str, Throwable th) {
    }

    public static void a(Throwable th) {
        if (th == null) {
        }
    }

    public static String b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void b(String str, String str2) {
    }

    public static void c(String str, String str2) {
    }

    public static void d(String str, String str2) {
    }

    public static void e(String str, String str2) {
    }

    public static String f(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return String.format("[%s][%s]", str, str2);
    }
}
