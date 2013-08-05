package com.baidu.adp.lib.asyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdAsyncTask f350a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdAsyncTask bdAsyncTask) {
        super(null);
        this.f350a = bdAsyncTask;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        Object c;
        c = this.f350a.c(this.f350a.a(this.b));
        return c;
    }
}
