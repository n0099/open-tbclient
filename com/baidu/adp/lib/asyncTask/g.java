package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class g<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> iE;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ck();

    public BdAsyncTask<?, ?, ?> co() {
        return this.iE;
    }

    public g(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.iE = null;
        this.iE = bdAsyncTask;
    }
}
