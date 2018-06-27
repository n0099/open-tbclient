package com.baidu.crabsdk.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.crabsdk.b.o;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public final class c {
    private static SimpleDateFormat Tg;
    private static PackageManager Th;

    @SuppressLint({"NewApi"})
    public static void a(SharedPreferences.Editor editor, boolean z) {
        if (pf() < 9 || z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static String c(Throwable th) {
        if (th == null) {
            a.cg("getErrorLine thr is null.");
            return "";
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        return stackTrace.length > 0 ? stackTrace[0].toString() : "N/A";
    }

    public static String f(Throwable th) {
        if (th == null) {
            a.cg("getErrorOriginalLine thr is null.");
            return "";
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        String F = o.F();
        for (int i = 0; i < stackTrace.length; i++) {
            if (stackTrace[i].getClassName().contains(F)) {
                return stackTrace[i].toString();
            }
        }
        return stackTrace.length > 0 ? stackTrace[0].toString() : "N/A";
    }

    public static String f(Date date) {
        if (Tg == null) {
            Tg = new SimpleDateFormat("MM-dd HH:mm:ss");
        }
        return Tg.format(date);
    }

    public static boolean g(Context context, String str) {
        if (Th == null) {
            Th = context.getPackageManager();
        }
        try {
            return Th.checkPermission(str, context.getPackageName()) == 0;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public static String p(long j) {
        return j / 1000000000 > 0 ? (((float) (j / 100000000)) / 10.0f) + "G" : j / 1000000 > 0 ? (((float) (j / 100000)) / 10.0f) + "M" : j / 1000 > 0 ? (((float) (j / 100)) / 10.0f) + "K" : j + "B";
    }

    public static int pf() {
        try {
            return Build.VERSION.class.getField("SDK_INT").getInt(null);
        } catch (Exception e) {
            return Integer.parseInt(Build.VERSION.SDK);
        }
    }

    public static String pg() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    }
}
