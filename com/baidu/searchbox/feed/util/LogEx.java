package com.baidu.searchbox.feed.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.IllegalFormatException;
/* loaded from: classes3.dex */
public final class LogEx {
    private static final boolean ENABLE_LOG = true;
    private static final int LARGE_STRING_LIMIT = 1000;
    private static final String MESSAGE_IS_EMPTY = "LogEx method param(msg) is null";

    public static void v(String str, String str2) {
        println(2, str, str2);
    }

    public static void v(String str, String str2, Throwable th) {
        println(2, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void d(String str, String str2) {
        println(3, str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        println(3, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void i(String str, String str2) {
        println(4, str, str2);
    }

    public static void i(String str, String str2, Throwable th) {
        println(4, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void w(String str, String str2) {
        println(5, str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        println(5, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void e(String str, String str2) {
        println(6, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        println(6, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    private static void println(int i, String str, String str2) {
        String str3;
        if (str != null) {
            if (str2 != null) {
                str3 = "[" + Thread.currentThread().getName() + "]" + str2;
            } else {
                str3 = MESSAGE_IS_EMPTY;
            }
            printlnLargeString(i, str, str3);
        }
    }

    private static void printlnLargeString(int i, String str, String str2) {
        if (str2.length() > 1000) {
            Log.println(i, str, str2.substring(0, 1000));
            printlnLargeString(i, str, str2.substring(1000));
            return;
        }
        Log.println(i, str, str2);
    }

    public static void error(@NonNull String str, @Nullable Throwable th) {
        println(6, str, Log.getStackTraceString(th));
    }

    public static void error(@NonNull String str, @Nullable Throwable th, @Nullable String str2, @Nullable Object... objArr) {
        if (str2 == null) {
            println(6, str, "LogEx method param(msg) is null\n" + Log.getStackTraceString(th));
            return;
        }
        try {
            str2 = String.format(str2, objArr);
        } catch (IllegalFormatException e) {
            e.printStackTrace();
        }
        println(6, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void warn(@NonNull String str, @Nullable String str2, @Nullable Object... objArr) {
        if (str2 == null) {
            println(5, str, MESSAGE_IS_EMPTY);
            return;
        }
        try {
            str2 = String.format(str2, objArr);
        } catch (IllegalFormatException e) {
            e.printStackTrace();
        }
        println(5, str, str2);
    }

    public static void info(@NonNull String str, @Nullable String str2, @Nullable Object... objArr) {
        if (str2 == null) {
            println(4, str, MESSAGE_IS_EMPTY);
            return;
        }
        try {
            str2 = String.format(str2, objArr);
        } catch (IllegalFormatException e) {
            e.printStackTrace();
        }
        println(4, str, str2);
    }

    public static void debug(@NonNull String str, @Nullable String str2, @Nullable Object... objArr) {
        if (str2 == null) {
            println(3, str, MESSAGE_IS_EMPTY);
            return;
        }
        try {
            str2 = String.format(str2, objArr);
        } catch (IllegalFormatException e) {
            e.printStackTrace();
        }
        println(3, str, str2);
    }

    public static void verbose(@NonNull String str, @Nullable String str2, @Nullable Object... objArr) {
        if (str2 == null) {
            println(2, str, MESSAGE_IS_EMPTY);
            return;
        }
        try {
            str2 = String.format(str2, objArr);
        } catch (IllegalFormatException e) {
            e.printStackTrace();
        }
        println(2, str, str2);
    }
}
