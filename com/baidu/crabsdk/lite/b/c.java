package com.baidu.crabsdk.lite.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.crabsdk.lite.a.n;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f4782a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f4783b;

    public static String a(long j) {
        StringBuilder sb;
        String str;
        if (j / 1000000000 > 0) {
            sb = new StringBuilder();
            sb.append(((float) (j / 100000000)) / 10.0f);
            str = "G";
        } else if (j / 1000000 > 0) {
            sb = new StringBuilder();
            sb.append(((float) (j / 100000)) / 10.0f);
            str = "M";
        } else if (j / 1000 > 0) {
            sb = new StringBuilder();
            sb.append(((float) (j / 100)) / 10.0f);
            str = "K";
        } else {
            sb = new StringBuilder();
            sb.append(j);
            str = "B";
        }
        sb.append(str);
        return sb.toString();
    }

    public static String b(Date date) {
        if (f4782a == null) {
            f4782a = new SimpleDateFormat("MM-dd HH:mm:ss");
        }
        return f4782a.format(date);
    }

    public static void c(SharedPreferences.Editor editor, boolean z) {
        if (g() < 9 || z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static String d(Throwable th) {
        if (th == null) {
            return "";
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        return stackTrace.length > 0 ? stackTrace[0].toString() : "N/A";
    }

    public static boolean e(Context context, String str) {
        if (f4783b == null) {
            f4783b = context.getPackageManager();
        }
        return f4783b.checkPermission(str, context.getPackageName()) == 0;
    }

    public static String f(Throwable th) {
        StackTraceElement stackTraceElement;
        if (th == null) {
            return "";
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        String b2 = n.b();
        int i = 0;
        while (true) {
            if (i < stackTrace.length) {
                if (stackTrace[i].getClassName().contains(b2)) {
                    stackTraceElement = stackTrace[i];
                    break;
                }
                i++;
            } else if (stackTrace.length <= 0) {
                return "N/A";
            } else {
                stackTraceElement = stackTrace[0];
            }
        }
        return stackTraceElement.toString();
    }

    public static int g() {
        try {
            return Build.VERSION.class.getField("SDK_INT").getInt(null);
        } catch (Exception unused) {
            return Integer.parseInt(Build.VERSION.SDK);
        }
    }

    public static String h() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    }
}
