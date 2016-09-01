package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class g<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> lw;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void de();

    public BdAsyncTask<?, ?, ?> di() {
        return this.lw;
    }

    public g(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.lw = null;
        this.lw = bdAsyncTask;
    }
}
