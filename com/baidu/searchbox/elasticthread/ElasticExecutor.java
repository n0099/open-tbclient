package com.baidu.searchbox.elasticthread;

import android.support.annotation.NonNull;
/* loaded from: classes13.dex */
public class ElasticExecutor extends ExecutorProxy {
    @Deprecated
    public static final int TASK_PRIORITY_BACKGROUND = 3;
    @Deprecated
    public static final int TASK_PRIORITY_DEFAULT = 3;
    @Deprecated
    public static final int TASK_PRIORITY_INTIME = 2;
    @Deprecated
    public static final int TASK_PRIORITY_USER_RELATED = 1;

    public ElasticExecutor(String str, int i) {
        super(str, i);
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
        ExecutorUtilsExt.postOnElastic(runnable, str, i);
    }
}
