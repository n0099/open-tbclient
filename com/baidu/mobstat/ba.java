package com.baidu.mobstat;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
/* loaded from: classes15.dex */
public abstract class ba {

    /* renamed from: a  reason: collision with root package name */
    public static int f3775a = 2;

    public abstract String a();

    public abstract boolean b();

    public void a(String str, Throwable th) {
        a(2, str + '\n' + d(th));
    }

    public void a(String str) {
        a(3, str);
    }

    public void a(Throwable th) {
        a(3, d(th));
    }

    public void b(String str, Throwable th) {
        a(3, str + '\n' + d(th));
    }

    public void c(String str, Throwable th) {
        a(4, str + '\n' + d(th));
    }

    public void b(String str) {
        a(5, str);
    }

    public void b(Throwable th) {
        a(5, d(th));
    }

    public void c(String str) {
        a(6, str);
    }

    public void c(Throwable th) {
        a(6, d(th));
    }

    public void d(String str, Throwable th) {
        a(6, str + '\n' + d(th));
    }

    private String d(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private void a(int i, String str) {
        if (b() && i >= f3775a) {
            Log.println(i, a(), str);
        }
    }
}
