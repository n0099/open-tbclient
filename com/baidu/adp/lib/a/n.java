package com.baidu.adp.lib.a;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class n extends FutureTask {
    private a a;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a();

    public a b() {
        return this.a;
    }

    public n(Callable callable, a aVar) {
        super(callable);
        this.a = null;
        this.a = aVar;
    }
}
