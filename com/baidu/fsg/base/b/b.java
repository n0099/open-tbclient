package com.baidu.fsg.base.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1885a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f1886b = new AtomicInteger(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f1885a = aVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "WalletTask #" + this.f1886b.getAndIncrement());
    }
}
