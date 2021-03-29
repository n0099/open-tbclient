package com.baidu.mobads.f;

import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public final class h implements b {
    @Override // com.baidu.mobads.f.b
    public void a(Runnable runnable, d dVar) {
        d dVar2;
        d dVar3;
        LinkedBlockingQueue linkedBlockingQueue;
        ThreadFactory threadFactory;
        Log.w("ThreadPoolFactory", "Exceeded ThreadPoolExecutor pool size");
        synchronized (this) {
            dVar2 = e.f8241a;
            if (dVar2 == null) {
                LinkedBlockingQueue unused = e.f8242b = new LinkedBlockingQueue();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                linkedBlockingQueue = e.f8242b;
                threadFactory = e.f8243c;
                d unused2 = e.f8241a = new d(5, 5, 60L, timeUnit, linkedBlockingQueue, threadFactory);
            }
        }
        dVar3 = e.f8241a;
        dVar3.execute(runnable);
    }
}
