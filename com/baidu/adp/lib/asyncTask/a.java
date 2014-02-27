package com.baidu.adp.lib.asyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends e<Params, Result> {
    final /* synthetic */ BdAsyncTask a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdAsyncTask bdAsyncTask) {
        super((byte) 0);
        this.a = bdAsyncTask;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, Result] */
    @Override // java.util.concurrent.Callable
    public final Result call() {
        ?? c;
        c = this.a.c((BdAsyncTask) this.a.a((Object[]) this.b));
        return c;
    }
}
