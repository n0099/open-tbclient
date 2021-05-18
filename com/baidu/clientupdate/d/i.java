package com.baidu.clientupdate.d;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class i implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadFactory f4602a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4603b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f4604c;

    public i(String str) {
        this(str, Executors.defaultThreadFactory());
    }

    public i(String str, ThreadFactory threadFactory) {
        this.f4604c = new AtomicInteger(0);
        this.f4603b = str;
        this.f4602a = threadFactory;
    }

    private String a(int i2) {
        return String.format("%s-%d", this.f4603b, Integer.valueOf(i2));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f4602a.newThread(runnable);
        newThread.setName(a(this.f4604c.getAndIncrement()));
        return newThread;
    }
}
