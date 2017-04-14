package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class g<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> sI;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ek();

    public BdAsyncTask<?, ?, ?> eo() {
        return this.sI;
    }

    public g(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.sI = null;
        this.sI = bdAsyncTask;
    }
}
