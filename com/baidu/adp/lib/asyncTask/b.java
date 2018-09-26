package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> zs;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void hM();

    public BdAsyncTask<?, ?, ?> hQ() {
        return this.zs;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.zs = null;
        this.zs = bdAsyncTask;
    }
}
