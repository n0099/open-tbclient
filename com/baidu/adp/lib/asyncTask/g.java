package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class g<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> sw;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void fP();

    public BdAsyncTask<?, ?, ?> fT() {
        return this.sw;
    }

    public g(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.sw = null;
        this.sw = bdAsyncTask;
    }
}
