package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> sh;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void eh();

    public BdAsyncTask<?, ?, ?> el() {
        return this.sh;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.sh = null;
        this.sh = bdAsyncTask;
    }
}
