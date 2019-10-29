package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> nH;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cancelTask();

    public BdAsyncTask<?, ?, ?> eX() {
        return this.nH;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.nH = null;
        this.nH = bdAsyncTask;
    }
}
