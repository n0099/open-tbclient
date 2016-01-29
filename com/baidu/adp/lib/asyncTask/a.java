package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends BdAsyncTask.c<Params, Result> {
    final /* synthetic */ BdAsyncTask sF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdAsyncTask bdAsyncTask) {
        super(null);
        this.sF = bdAsyncTask;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, Result] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, Result] */
    @Override // java.util.concurrent.Callable
    public Result call() {
        g gVar;
        ?? postResult;
        ?? postResult2;
        gVar = this.sF.mFuture;
        if (!gVar.isCancelled()) {
            postResult2 = this.sF.postResult(this.sF.doInBackground(this.mParams));
            return postResult2;
        }
        postResult = this.sF.postResult(null);
        return postResult;
    }
}
