package com.baidu.sapi2.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes19.dex */
class u implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "pass_pool_thread # " + this.a.getAndIncrement());
    }
}
