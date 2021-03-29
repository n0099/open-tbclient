package com.baidu.mobads.f;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class f implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f8245a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "TaskScheduler #" + this.f8245a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new g(this));
        return thread;
    }
}
