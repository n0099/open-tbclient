package com.baidu.crabsdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.crabsdk.b.o;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes6.dex */
public final class c {
    private static SimpleDateFormat Yt;
    private static PackageManager Yu;

    public static void a(SharedPreferences.Editor editor, boolean z) {
        if (rr() < 9 || z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static String e(Date date) {
        if (Yt == null) {
            Yt = new SimpleDateFormat("MM-dd HH:mm:ss");
        }
        return Yt.format(date);
    }

    public static String g(Throwable th) {
        if (th == null) {
            a.cJ("getErrorLine thr is null.");
            return "";
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        return stackTrace.length > 0 ? stackTrace[0].toString() : "N/A";
    }

    public static boolean g(Context context, String str) {
        if (Yu == null) {
            Yu = context.getPackageManager();
        }
        try {
            return Yu.checkPermission(str, context.getPackageName()) == 0;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public static String h(Throwable th) {
        if (th == null) {
            a.cJ("getErrorOriginalLine thr is null.");
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
        return stackTrace.length > 0 ? stackTrace[0].toString() : "N/A";
    }

    public static String k(long j) {
        return j / 1000000000 > 0 ? (((float) (j / 100000000)) / 10.0f) + "G" : j / 1000000 > 0 ? (((float) (j / 100000)) / 10.0f) + "M" : j / 1000 > 0 ? (((float) (j / 100)) / 10.0f) + "K" : j + "B";
    }

    public static int rr() {
        try {
            return Build.VERSION.class.getField("SDK_INT").getInt(null);
        } catch (Exception e) {
            return Integer.parseInt(Build.VERSION.SDK);
        }
    }

    public static String rs() {
        return new SimpleDateFormat(AiAppDateTimeUtil.DAY_FORMAT).format(new Date(System.currentTimeMillis()));
    }
}
