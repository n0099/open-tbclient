package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
final class h implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f414a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = "BdAsyncTask #" + String.valueOf(this.f414a.getAndIncrement());
        com.baidu.adp.lib.h.d.c(str);
        return new Thread(runnable, str);
    }
}
