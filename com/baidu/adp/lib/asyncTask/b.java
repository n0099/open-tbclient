package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> qT;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void dQ();

    public BdAsyncTask<?, ?, ?> dU() {
        return this.qT;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.qT = null;
        this.qT = bdAsyncTask;
    }
}
