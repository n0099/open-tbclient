package com.baidu.searchbox.player.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDPlayerConfig;
/* loaded from: classes2.dex */
public final class BdVideoLog {
    public static VideoLog sVideoLog = new DefaultVideoLog();

    /* loaded from: classes2.dex */
    public static class DefaultVideoLog extends VideoLog {
        @Override // com.baidu.searchbox.player.utils.VideoLog
        public boolean isLoggable(int i, @Nullable String str) {
            return BDPlayerConfig.isDebug();
        }
    }

    public static void d(String str) {
        doLog(3, null, str, null);
    }

    public static void e(String str) {
        doLog(6, null, str, null);
    }

    public static void ex(String str) {
        doLog(6, null, str, null);
    }

    public static void i(String str) {
        doLog(4, null, str, null);
    }

    public static void inject(@NonNull VideoLog videoLog) {
        sVideoLog = videoLog;
    }

    @Deprecated
    public static void printStackTrace(Exception exc) {
        doLog(6, null, null, exc);
    }

    public static void v(String str) {
        doLog(2, null, str, null);
    }

    public static void w(String str) {
        doLog(5, null, str, null);
    }

    public static void d(@Nullable String str, @Nullable String str2) {
        doLog(3, str, str2, null);
    }

    public static void e(String str, String str2) {
        doLog(6, str, str2, null);
    }

    public static void i(String str, String str2) {
        doLog(4, str, str2, null);
    }

    @Deprecated
    public static void logException(String str, Exception exc) {
        doLog(6, str, null, exc);
    }

    public static void v(String str, String str2) {
        doLog(2, str, str2, null);
    }

    public static void w(String str, String str2) {
        doLog(5, str, str2, null);
    }

    public static void d(String str, Throwable th) {
        doLog(3, null, str, th);
    }

    public static void e(String str, Throwable th) {
        doLog(6, null, str, th);
    }

    public static void i(String str, Throwable th) {
        doLog(4, null, str, th);
    }

    public static void v(String str, Throwable th) {
        doLog(2, null, str, th);
    }

    public static void w(String str, Throwable th) {
        doLog(5, null, str, th);
    }

    public static void doLog(int i, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        sVideoLog.doLog(i, str, str2, th);
    }
}
