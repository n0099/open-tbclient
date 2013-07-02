package com.baidu.adp.lib.asyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends e {
    final /* synthetic */ BdAsyncTask a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdAsyncTask bdAsyncTask) {
        super(null);
        this.a = bdAsyncTask;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        Object c;
        c = this.a.c(this.a.a(this.b));
        return c;
    }
}
