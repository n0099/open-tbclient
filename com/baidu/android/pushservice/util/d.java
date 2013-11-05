package com.baidu.android.pushservice.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class d implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f739a;
    private final String b;
    private final AtomicInteger c;

    public d(String str) {
        this(str, Executors.defaultThreadFactory());
    }

    public d(String str, ThreadFactory threadFactory) {
        this.c = new AtomicInteger(0);
        this.b = str;
        this.f739a = threadFactory;
    }

    private String a(int i) {
        return String.format("%s-%d", this.b, Integer.valueOf(i));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f739a.newThread(runnable);
        newThread.setName(a(this.c.getAndIncrement()));
        return newThread;
    }
}
