package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> Ae;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void hZ();

    public BdAsyncTask<?, ?, ?> ie() {
        return this.Ae;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.Ae = null;
        this.Ae = bdAsyncTask;
    }
}
