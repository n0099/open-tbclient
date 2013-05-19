package com.baidu.adp.lib.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
class i implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = "BdAsyncTask #" + String.valueOf(this.a.getAndIncrement());
        com.baidu.adp.lib.e.b.b(str);
        return new Thread(runnable, str);
    }
}
