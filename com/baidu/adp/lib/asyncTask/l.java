package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class l extends FutureTask {

    /* renamed from: a  reason: collision with root package name */
    private BdAsyncTask f359a;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a();

    public BdAsyncTask b() {
        return this.f359a;
    }

    public l(Callable callable, BdAsyncTask bdAsyncTask) {
        super(callable);
        this.f359a = null;
        this.f359a = bdAsyncTask;
    }
}
