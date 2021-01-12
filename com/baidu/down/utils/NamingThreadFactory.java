package com.baidu.down.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class NamingThreadFactory implements ThreadFactory {
    private final ThreadFactory mBackingFactory;
    private final AtomicInteger mCount;
    private final String mPrefix;

    public NamingThreadFactory(String str) {
        this(str, Executors.defaultThreadFactory());
    }

    public NamingThreadFactory(String str, ThreadFactory threadFactory) {
        this.mCount = new AtomicInteger(0);
        this.mPrefix = str;
        this.mBackingFactory = threadFactory;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.mBackingFactory.newThread(runnable);
        newThread.setName(makeName(this.mCount.getAndIncrement()));
        return newThread;
    }

    private String makeName(int i) {
        return String.format("%s-%d", this.mPrefix, Integer.valueOf(i));
    }
}
