package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> ux;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void et();

    public BdAsyncTask<?, ?, ?> ex() {
        return this.ux;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.ux = null;
        this.ux = bdAsyncTask;
    }
}
