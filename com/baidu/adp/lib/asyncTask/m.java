package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class m<V> extends FutureTask<V> {

    /* renamed from: a  reason: collision with root package name */
    private BdAsyncTask<?, ?, ?> f419a;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a();

    public BdAsyncTask<?, ?, ?> b() {
        return this.f419a;
    }

    public m(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.f419a = null;
        this.f419a = bdAsyncTask;
    }
}
