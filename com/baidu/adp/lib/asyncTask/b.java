package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> xf;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void gH();

    public BdAsyncTask<?, ?, ?> gL() {
        return this.xf;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.xf = null;
        this.xf = bdAsyncTask;
    }
}
