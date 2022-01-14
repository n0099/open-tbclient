package com.baidu.searchbox.logsystem.javacrash;

import androidx.annotation.NonNull;
import java.lang.Thread;
/* loaded from: classes11.dex */
public interface ProcessExceptionListener {
    void onProcessExceptionFail(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th, @NonNull Throwable th2);

    void onProcessExceptionStart(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th);

    void onProcessExceptionSuccess(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th);

    void onProxyProcessExceptionFail(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th, @NonNull Throwable th2);

    void onProxyProcessExceptionStart(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th);

    void onProxyProcessExceptionSuccess(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th);
}
