package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class k<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> sm;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void fP();

    public BdAsyncTask<?, ?, ?> fU() {
        return this.sm;
    }

    public k(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.sm = null;
        this.sm = bdAsyncTask;
    }
}
