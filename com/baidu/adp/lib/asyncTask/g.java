package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class g<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> sv;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void fM();

    public BdAsyncTask<?, ?, ?> fQ() {
        return this.sv;
    }

    public g(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.sv = null;
        this.sv = bdAsyncTask;
    }
}
