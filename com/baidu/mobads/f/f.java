package com.baidu.mobads.f;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
final class f implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f3332a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "TaskScheduler #" + this.f3332a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new g(this));
        return thread;
    }
}
