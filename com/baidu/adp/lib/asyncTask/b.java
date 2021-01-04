package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> KR;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cancelTask();

    public BdAsyncTask<?, ?, ?> lq() {
        return this.KR;
    }

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.KR = null;
        this.KR = bdAsyncTask;
    }
}
