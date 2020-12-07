package com.baidu.sumeru.universalimageloader.utils;

import android.util.Log;
import com.baidu.sumeru.universalimageloader.core.ImageLoader;
/* loaded from: classes11.dex */
public final class L {
    private static volatile boolean DISABLED = false;
    private static final String LOG_FORMAT = "%1$s\n%2$s";

    private L() {
    }

    public static void enableLogging() {
        DISABLED = false;
    }

    public static void disableLogging() {
        DISABLED = true;
    }

    public static void d(String str, Object... objArr) {
        log(3, null, str, objArr);
    }

    public static void i(String str, Object... objArr) {
        log(4, null, str, objArr);
    }

    public static void w(String str, Object... objArr) {
        log(5, null, str, objArr);
    }

    public static void e(Throwable th) {
        log(6, th, null, new Object[0]);
    }

    public static void e(String str, Object... objArr) {
        log(6, null, str, objArr);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        log(6, th, str, objArr);
    }

    private static void log(int i, Throwable th, String str, Object... objArr) {
        if (!DISABLED) {
            String format = objArr.length > 0 ? String.format(str, objArr) : str;
            if (th != null) {
                if (format == null) {
                    format = th.getMessage();
                }
                format = String.format(LOG_FORMAT, format, Log.getStackTraceString(th));
            }
            Log.println(i, ImageLoader.TAG, format);
        }
    }
}
