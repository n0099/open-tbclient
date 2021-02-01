package com.baidu.mobads.f;

import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
final class h implements b {
    @Override // com.baidu.mobads.f.b
    public void a(Runnable runnable, d dVar) {
        d dVar2;
        d dVar3;
        LinkedBlockingQueue linkedBlockingQueue;
        ThreadFactory threadFactory;
        Log.w("ThreadPoolFactory", "Exceeded ThreadPoolExecutor pool size");
        synchronized (this) {
            dVar2 = e.f3330a;
            if (dVar2 == null) {
                LinkedBlockingQueue unused = e.f3331b = new LinkedBlockingQueue();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                linkedBlockingQueue = e.f3331b;
                threadFactory = e.c;
                d unused2 = e.f3330a = new d(5, 5, 60L, timeUnit, linkedBlockingQueue, threadFactory);
            }
        }
        dVar3 = e.f3330a;
        dVar3.execute(runnable);
    }
}
