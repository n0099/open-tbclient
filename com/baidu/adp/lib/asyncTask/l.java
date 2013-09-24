package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class l<V> extends FutureTask<V> {

    /* renamed from: a  reason: collision with root package name */
    private BdAsyncTask<?, ?, ?> f368a;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a();

    public BdAsyncTask<?, ?, ?> b() {
        return this.f368a;
    }

    public l(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.f368a = null;
        this.f368a = bdAsyncTask;
    }
}
