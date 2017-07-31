package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> uv;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void et();

    public BdAsyncTask<?, ?, ?> ex() {
        return this.uv;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.uv = null;
        this.uv = bdAsyncTask;
    }
}
