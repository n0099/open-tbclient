package com.baidu.adp.lib.asyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends e<Params, Result> {
    final /* synthetic */ BdAsyncTask sy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdAsyncTask bdAsyncTask) {
        super(null);
        this.sy = bdAsyncTask;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, Result] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, Result] */
    @Override // java.util.concurrent.Callable
    public Result call() {
        k kVar;
        ?? postResult;
        ?? postResult2;
        kVar = this.sy.mFuture;
        if (!kVar.isCancelled()) {
            postResult2 = this.sy.postResult(this.sy.doInBackground(this.mParams));
            return postResult2;
        }
        postResult = this.sy.postResult(null);
        return postResult;
    }
}
