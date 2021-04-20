package com.baidu.clientupdate.d;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class i implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadFactory f4640a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4641b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f4642c;

    public i(String str) {
        this(str, Executors.defaultThreadFactory());
    }

    public i(String str, ThreadFactory threadFactory) {
        this.f4642c = new AtomicInteger(0);
        this.f4641b = str;
        this.f4640a = threadFactory;
    }

    private String a(int i) {
        return String.format("%s-%d", this.f4641b, Integer.valueOf(i));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f4640a.newThread(runnable);
        newThread.setName(a(this.f4642c.getAndIncrement()));
        return newThread;
    }
}
