package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.lib.util.BdLog;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
class d implements ThreadFactory {
    private final AtomicInteger mCount = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = "BdAsyncTask #" + String.valueOf(this.mCount.getAndIncrement());
        BdLog.i(str);
        return new Thread(runnable, str);
    }
}
