package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class g<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> lx;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void de();

    public BdAsyncTask<?, ?, ?> di() {
        return this.lx;
    }

    public g(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.lx = null;
        this.lx = bdAsyncTask;
    }
}
