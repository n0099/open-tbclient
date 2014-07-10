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

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, Result] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, Result] */
    @Override // java.util.concurrent.Callable
    public Result call() {
        k kVar;
        ?? postResult;
        ?? postResult2;
        kVar = this.a.mFuture;
        if (!kVar.isCancelled()) {
            postResult2 = this.a.postResult(this.a.doInBackground(this.b));
            return postResult2;
        }
        postResult = this.a.postResult(null);
        return postResult;
    }
}
