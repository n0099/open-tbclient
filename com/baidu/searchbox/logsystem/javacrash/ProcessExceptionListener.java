package com.baidu.searchbox.logsystem.javacrash;

import java.lang.Thread;
/* loaded from: classes2.dex */
public interface ProcessExceptionListener {
    void onProcessExceptionFail(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th, Throwable th2);

    void onProcessExceptionStart(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th);

    void onProcessExceptionSuccess(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th);

    void onProxyProcessExceptionFail(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th, Throwable th2);

    void onProxyProcessExceptionStart(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th);

    void onProxyProcessExceptionSuccess(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th);
}
