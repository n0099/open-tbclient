package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class k<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> sz;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void fU();

    public BdAsyncTask<?, ?, ?> fY() {
        return this.sz;
    }

    public k(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.sz = null;
        this.sz = bdAsyncTask;
    }
}
