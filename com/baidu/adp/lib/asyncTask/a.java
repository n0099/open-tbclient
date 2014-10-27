package com.baidu.adp.lib.asyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends e<Params, Result> {
    final /* synthetic */ BdAsyncTask eO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdAsyncTask bdAsyncTask) {
        super(null);
        this.eO = bdAsyncTask;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, Result] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, Result] */
    @Override // java.util.concurrent.Callable
    public Result call() {
        k kVar;
        ?? postResult;
        ?? postResult2;
        kVar = this.eO.mFuture;
        if (!kVar.isCancelled()) {
            postResult2 = this.eO.postResult(this.eO.doInBackground(this.mParams));
            return postResult2;
        }
        postResult = this.eO.postResult(null);
        return postResult;
    }
}
