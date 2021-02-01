package com.baidu.clientupdate.d;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class i implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f1678a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1679b;
    private final AtomicInteger c;

    public i(String str) {
        this(str, Executors.defaultThreadFactory());
    }

    public i(String str, ThreadFactory threadFactory) {
        this.c = new AtomicInteger(0);
        this.f1679b = str;
        this.f1678a = threadFactory;
    }

    private String a(int i) {
        return String.format("%s-%d", this.f1679b, Integer.valueOf(i));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f1678a.newThread(runnable);
        newThread.setName(a(this.c.getAndIncrement()));
        return newThread;
    }
}
