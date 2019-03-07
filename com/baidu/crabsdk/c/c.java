package com.baidu.crabsdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.crabsdk.b.o;
import com.baidu.sapi2.base.network.Apn;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public final class c {
    private static SimpleDateFormat acf;
    private static PackageManager acg;

    public static void a(SharedPreferences.Editor editor, boolean z) {
        if (rW() < 9 || z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static String e(Date date) {
        if (acf == null) {
            acf = new SimpleDateFormat("MM-dd HH:mm:ss");
        }
        return acf.format(date);
    }

    public static String f(Throwable th) {
        if (th == null) {
            a.cy("getErrorLine thr is null.");
            return "";
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        return stackTrace.length > 0 ? stackTrace[0].toString() : Apn.APN_UNKNOWN;
    }

    public static String g(Throwable th) {
        if (th == null) {
            a.cy("getErrorOriginalLine thr is null.");
            return "";
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        String G = o.G();
        for (int i = 0; i < stackTrace.length; i++) {
            if (stackTrace[i].getClassName().contains(G)) {
                return stackTrace[i].toString();
            }
        }
        return stackTrace.length > 0 ? stackTrace[0].toString() : Apn.APN_UNKNOWN;
    }

    public static boolean g(Context context, String str) {
        if (acg == null) {
            acg = context.getPackageManager();
        }
        try {
            return acg.checkPermission(str, context.getPackageName()) == 0;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public static String i(long j) {
        return j / 1000000000 > 0 ? (((float) (j / 100000000)) / 10.0f) + "G" : j / 1000000 > 0 ? (((float) (j / 100000)) / 10.0f) + "M" : j / 1000 > 0 ? (((float) (j / 100)) / 10.0f) + "K" : j + "B";
    }

    public static int rW() {
        try {
            return Build.VERSION.class.getField("SDK_INT").getInt(null);
        } catch (Exception e) {
            return Integer.parseInt(Build.VERSION.SDK);
        }
    }

    public static String rX() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    }
}
