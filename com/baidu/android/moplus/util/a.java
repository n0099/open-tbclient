package com.baidu.android.moplus.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f638a;
    private final String b;
    private final AtomicInteger c;

    public a(String str) {
        this(str, Executors.defaultThreadFactory());
    }

    public a(String str, ThreadFactory threadFactory) {
        this.c = new AtomicInteger(0);
        this.b = str;
        this.f638a = threadFactory;
    }

    private String a(int i) {
        return String.format("%s-%d", this.b, Integer.valueOf(i));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f638a.newThread(runnable);
        newThread.setName(a(this.c.getAndIncrement()));
        return newThread;
    }
}
