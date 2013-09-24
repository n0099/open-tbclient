package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends l<Result> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdAsyncTask f360a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BdAsyncTask bdAsyncTask, Callable callable, BdAsyncTask bdAsyncTask2) {
        super(callable, bdAsyncTask2);
        this.f360a = bdAsyncTask;
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        try {
            this.f360a.c((BdAsyncTask) get());
        } catch (InterruptedException e) {
        } catch (CancellationException e2) {
            this.f360a.c((BdAsyncTask) null);
        } catch (ExecutionException e3) {
            this.f360a.c((BdAsyncTask) null);
        } catch (Throwable th) {
            throw new RuntimeException("An error occured while executing doInBackground()", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.l
    public void a() {
        this.f360a.cancel();
    }
}
