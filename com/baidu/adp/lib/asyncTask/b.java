package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> sg;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ei();

    public BdAsyncTask<?, ?, ?> em() {
        return this.sg;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.sg = null;
        this.sg = bdAsyncTask;
    }
}
