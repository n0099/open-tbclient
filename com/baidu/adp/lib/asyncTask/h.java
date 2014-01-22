package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
final class h implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = "BdAsyncTask #" + String.valueOf(this.a.getAndIncrement());
        com.baidu.adp.lib.g.e.c(str);
        return new Thread(runnable, str);
    }
}
