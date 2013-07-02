package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class l extends FutureTask {
    private BdAsyncTask a;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a();

    public BdAsyncTask b() {
        return this.a;
    }

    public l(Callable callable, BdAsyncTask bdAsyncTask) {
        super(callable);
        this.a = null;
        this.a = bdAsyncTask;
    }
}
