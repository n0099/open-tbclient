package com.baidu.live.adp.lib.asynctask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes3.dex */
public abstract class BdAsyncTaskFuture<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> mTask;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cancelTask();

    public BdAsyncTask<?, ?, ?> getTask() {
        return this.mTask;
    }

    public BdAsyncTaskFuture(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.mTask = null;
        this.mTask = bdAsyncTask;
    }

    public BdAsyncTaskFuture(Runnable runnable, V v, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(runnable, v);
        this.mTask = null;
        this.mTask = bdAsyncTask;
    }
}
