package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class g<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> tl;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void el();

    public BdAsyncTask<?, ?, ?> ep() {
        return this.tl;
    }

    public g(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.tl = null;
        this.tl = bdAsyncTask;
    }
}
