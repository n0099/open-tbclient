package com.baidu.searchbox.elasticthread;

import android.support.annotation.NonNull;
/* loaded from: classes5.dex */
public class SerialExecutor extends ExecutorProxy {
    public SerialExecutor(String str) {
        super(str, 4);
    }

    @Override // com.baidu.searchbox.elasticthread.ExecutorProxy, java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        execute(runnable, this.mDefaultTaskName, this.mDefaultPriority);
    }

    @Override // com.baidu.searchbox.elasticthread.ExecutorProxy
    public void execute(@NonNull Runnable runnable, @NonNull String str) {
        execute(runnable, str, this.mDefaultPriority);
    }

    @Override // com.baidu.searchbox.elasticthread.ExecutorProxy
    public void execute(@NonNull Runnable runnable, @NonNull String str, int i) {
        ExecutorUtilsExt.postOnSerial(runnable, str);
    }
}
