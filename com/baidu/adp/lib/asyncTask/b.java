package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.base.BdBaseApplication;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends g<Result> {
    final /* synthetic */ BdAsyncTask lw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BdAsyncTask bdAsyncTask, Callable callable, BdAsyncTask bdAsyncTask2) {
        super(callable, bdAsyncTask2);
        this.lw = bdAsyncTask;
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        try {
            this.lw.postResult(get());
        } catch (InterruptedException e) {
        } catch (CancellationException e2) {
            this.lw.postResult(null);
        } catch (ExecutionException e3) {
            this.lw.postResult(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new RuntimeException("An error occured while executing doInBackground()", e3);
            }
        } catch (Throwable th) {
            throw new RuntimeException("An error occured while executing doInBackground()", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.g
    public void de() {
        this.lw.cancel();
    }
}
