package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> sf;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void eh();

    public BdAsyncTask<?, ?, ?> el() {
        return this.sf;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.sf = null;
        this.sf = bdAsyncTask;
    }
}
