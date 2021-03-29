package com.baidu.fsg.base.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f5171a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f5172b = new AtomicInteger(1);

    public b(a aVar) {
        this.f5171a = aVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "WalletTask #" + this.f5172b.getAndIncrement());
    }
}
