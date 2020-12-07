package com.baidu.searchbox.elasticthread;
@Deprecated
/* loaded from: classes16.dex */
public class SerialExecutor extends ExecutorProxy {
    public SerialExecutor(String str) {
        super(str, 4);
    }

    @Override // com.baidu.searchbox.elasticthread.ExecutorProxy, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        execute(runnable, this.mDefaultTaskName, this.mDefaultPriority);
    }

    @Override // com.baidu.searchbox.elasticthread.ExecutorProxy
    public void execute(Runnable runnable, String str) {
        execute(runnable, str, this.mDefaultPriority);
    }

    @Override // com.baidu.searchbox.elasticthread.ExecutorProxy
    public void execute(Runnable runnable, String str, int i) {
        ExecutorUtilsExt.postOnSerial(runnable, str);
    }
}
