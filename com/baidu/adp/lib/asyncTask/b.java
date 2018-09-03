package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> xa;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void gG();

    public BdAsyncTask<?, ?, ?> gK() {
        return this.xa;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.xa = null;
        this.xa = bdAsyncTask;
    }
}
