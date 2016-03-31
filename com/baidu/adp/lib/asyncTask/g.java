package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class g<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> sP;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void fU();

    public BdAsyncTask<?, ?, ?> fY() {
        return this.sP;
    }

    public g(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.sP = null;
        this.sP = bdAsyncTask;
    }
}
