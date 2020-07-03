package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> Jw;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cancelTask();

    public BdAsyncTask<?, ?, ?> ko() {
        return this.Jw;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.Jw = null;
        this.Jw = bdAsyncTask;
    }
}
