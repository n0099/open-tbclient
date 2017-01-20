package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class g<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> lq;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void dc();

    public BdAsyncTask<?, ?, ?> dg() {
        return this.lq;
    }

    public g(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.lq = null;
        this.lq = bdAsyncTask;
    }
}
