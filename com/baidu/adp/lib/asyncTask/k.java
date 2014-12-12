package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class k<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> gQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ct();

    public BdAsyncTask<?, ?, ?> cy() {
        return this.gQ;
    }

    public k(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.gQ = null;
        this.gQ = bdAsyncTask;
    }
}
