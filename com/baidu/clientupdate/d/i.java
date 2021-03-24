package com.baidu.clientupdate.d;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class i implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadFactory f4604a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4605b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f4606c;

    public i(String str) {
        this(str, Executors.defaultThreadFactory());
    }

    public i(String str, ThreadFactory threadFactory) {
        this.f4606c = new AtomicInteger(0);
        this.f4605b = str;
        this.f4604a = threadFactory;
    }

    private String a(int i) {
        return String.format("%s-%d", this.f4605b, Integer.valueOf(i));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f4604a.newThread(runnable);
        newThread.setName(a(this.f4606c.getAndIncrement()));
        return newThread;
    }
}
