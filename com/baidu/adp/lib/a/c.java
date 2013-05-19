package com.baidu.adp.lib.a;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends n {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, Callable callable, a aVar2) {
        super(callable, aVar2);
        this.a = aVar;
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        try {
            this.a.c(get());
        } catch (InterruptedException e) {
        } catch (CancellationException e2) {
            this.a.c((Object) null);
        } catch (ExecutionException e3) {
            throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
        } catch (Throwable th) {
            throw new RuntimeException("An error occured while executing doInBackground()", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.n
    public void a() {
        this.a.cancel(true);
    }
}
