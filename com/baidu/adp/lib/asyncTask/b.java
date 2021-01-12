package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> KP;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cancelTask();

    public BdAsyncTask<?, ?, ?> lq() {
        return this.KP;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.KP = null;
        this.KP = bdAsyncTask;
    }
}
