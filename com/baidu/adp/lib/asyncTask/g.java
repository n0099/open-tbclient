package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class g<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> iG;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cj();

    public BdAsyncTask<?, ?, ?> cn() {
        return this.iG;
    }

    public g(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.iG = null;
        this.iG = bdAsyncTask;
    }
}
