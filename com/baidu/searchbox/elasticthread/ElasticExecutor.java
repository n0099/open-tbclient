package com.baidu.searchbox.elasticthread;
@Deprecated
/* loaded from: classes16.dex */
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
    public void execute(Runnable runnable) {
        execute(runnable, this.mDefaultTaskName, this.mDefaultPriority);
    }

    @Override // com.baidu.searchbox.elasticthread.ExecutorProxy
    public void execute(Runnable runnable, String str) {
        execute(runnable, str, this.mDefaultPriority);
    }

    @Override // com.baidu.searchbox.elasticthread.ExecutorProxy
    public void execute(Runnable runnable, String str, int i) {
        ExecutorUtilsExt.postOnElastic(runnable, str, i);
    }
}
