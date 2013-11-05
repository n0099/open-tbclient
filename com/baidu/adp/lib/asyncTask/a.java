package com.baidu.adp.lib.asyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends f<Params, Result> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdAsyncTask f409a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdAsyncTask bdAsyncTask) {
        super(null);
        this.f409a = bdAsyncTask;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, Result] */
    @Override // java.util.concurrent.Callable
    public Result call() {
        ?? c;
        c = this.f409a.c((BdAsyncTask) this.f409a.a((Object[]) this.b));
        return c;
    }
}
