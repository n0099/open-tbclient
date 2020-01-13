package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> pE;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cancelTask();

    public BdAsyncTask<?, ?, ?> fs() {
        return this.pE;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.pE = null;
        this.pE = bdAsyncTask;
    }
}
