package com.baidu.adp.lib.asyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends e<Params, Result> {
    final /* synthetic */ BdAsyncTask a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdAsyncTask bdAsyncTask) {
        super(null);
        this.a = bdAsyncTask;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, Result] */
    @Override // java.util.concurrent.Callable
    public Result call() {
        k kVar;
        ?? postResult;
        kVar = this.a.mFuture;
        if (kVar.isCancelled()) {
            return null;
        }
        postResult = this.a.postResult(this.a.doInBackground(this.b));
        return postResult;
    }
}
