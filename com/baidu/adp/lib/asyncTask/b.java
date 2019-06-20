package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> xN;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void gT();

    public BdAsyncTask<?, ?, ?> gX() {
        return this.xN;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.xN = null;
        this.xN = bdAsyncTask;
    }
}
