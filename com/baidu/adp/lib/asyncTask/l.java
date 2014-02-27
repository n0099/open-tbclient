package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class l<V> extends FutureTask<V> {
    private BdAsyncTask<?, ?, ?> a;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a();

    public final BdAsyncTask<?, ?, ?> b() {
        return this.a;
    }

    public l(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.a = null;
        this.a = bdAsyncTask;
    }
}
