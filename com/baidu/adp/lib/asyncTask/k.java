package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class k<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> gS;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cr();

    public BdAsyncTask<?, ?, ?> cw() {
        return this.gS;
    }

    public k(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.gS = null;
        this.gS = bdAsyncTask;
    }
}
