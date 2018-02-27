package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> agx;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void lM();

    public BdAsyncTask<?, ?, ?> lQ() {
        return this.agx;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.agx = null;
        this.agx = bdAsyncTask;
    }
}
