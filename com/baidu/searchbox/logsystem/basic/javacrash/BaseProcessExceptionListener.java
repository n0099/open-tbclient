package com.baidu.searchbox.logsystem.basic.javacrash;

import androidx.annotation.NonNull;
import com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener;
import java.lang.Thread;
/* loaded from: classes5.dex */
public class BaseProcessExceptionListener implements ProcessExceptionListener {
    @Override // com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
    public void onProcessExceptionStart(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th) {
    }

    @Override // com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
    public void onProcessExceptionSuccess(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th) {
    }

    @Override // com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
    public void onProcessExceptionFail(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th, @NonNull Throwable th2) {
    }

    @Override // com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
    public void onProxyProcessExceptionStart(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th) {
    }

    @Override // com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
    public void onProxyProcessExceptionSuccess(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th) {
    }

    @Override // com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
    public void onProxyProcessExceptionFail(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th, @NonNull Throwable th2) {
    }
}
