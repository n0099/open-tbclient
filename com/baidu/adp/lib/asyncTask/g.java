package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
class g implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f354a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = "BdAsyncTask #" + String.valueOf(this.f354a.getAndIncrement());
        com.baidu.adp.lib.e.d.b(str);
        return new Thread(runnable, str);
    }
}
