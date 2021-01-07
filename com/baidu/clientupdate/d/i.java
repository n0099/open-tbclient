package com.baidu.clientupdate.d;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class i implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f1730a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1731b;
    private final AtomicInteger c;

    public i(String str) {
        this(str, Executors.defaultThreadFactory());
    }

    public i(String str, ThreadFactory threadFactory) {
        this.c = new AtomicInteger(0);
        this.f1731b = str;
        this.f1730a = threadFactory;
    }

    private String a(int i) {
        return String.format("%s-%d", this.f1731b, Integer.valueOf(i));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f1730a.newThread(runnable);
        newThread.setName(a(this.c.getAndIncrement()));
        return newThread;
    }
}
