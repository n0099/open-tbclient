package com.baidu.android.pushservice.e;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes2.dex */
public final class a {
    private static boolean a = false;
    private static boolean b = false;
    private static Logger c;

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void a(String str, String str2) {
        if (a) {
            String str3 = "BDPushSDK-" + str;
            if (!b || c == null) {
                Log.v(str3, str2);
            } else {
                c.log(Level.INFO, str3 + ": " + str2);
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        e(str, str2 + '\n' + a(th));
    }

    public static void a(String str, Throwable th) {
        e(str, a(th));
    }

    public static void b(String str, String str2) {
        if (a) {
            String str3 = "BDPushSDK-" + str;
            if (!b || c == null) {
                Log.i(str3, str2);
            } else {
                c.log(Level.INFO, str3 + ": " + str2);
            }
        }
    }

    public static void c(String str, String str2) {
        if (a) {
            String str3 = "BDPushSDK-" + str;
            if (!b || c == null) {
                Log.d(str3, str2);
            } else {
                c.log(Level.INFO, str3 + ": " + str2);
            }
        }
    }

    public static void d(String str, String str2) {
        if (a) {
            String str3 = "BDPushSDK-" + str;
            if (!b || c == null) {
                Log.w(str3, str2);
            } else {
                c.log(Level.WARNING, str3 + ": " + str2);
            }
        }
    }

    public static void e(String str, String str2) {
        if (a) {
            String str3 = "BDPushSDK-" + str;
            if (b && c != null) {
                c.log(Level.SEVERE, str3 + ": " + str2);
            } else if (TextUtils.isEmpty(str2)) {
            } else {
                Log.e(str3, str2);
            }
        }
    }
}
