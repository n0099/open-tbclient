package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class g<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> sN;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void el();

    public BdAsyncTask<?, ?, ?> ep() {
        return this.sN;
    }

    public g(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.sN = null;
        this.sN = bdAsyncTask;
    }
}
