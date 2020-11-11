package com.baidu.fsg.base.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes16.dex */
class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1458a;
    private final AtomicInteger b = new AtomicInteger(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f1458a = aVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "WalletTask #" + this.b.getAndIncrement());
    }
}
