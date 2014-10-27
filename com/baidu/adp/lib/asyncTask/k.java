package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class k<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> eP;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bT();

    public BdAsyncTask<?, ?, ?> bX() {
        return this.eP;
    }

    public k(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.eP = null;
        this.eP = bdAsyncTask;
    }
}
