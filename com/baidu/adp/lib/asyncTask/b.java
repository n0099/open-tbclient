package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> Af;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ia();

    public BdAsyncTask<?, ?, ?> ie() {
        return this.Af;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.Af = null;
        this.Af = bdAsyncTask;
    }
}
