package com.baidu.pano.platform.a;

import android.os.Process;
import com.baidu.pano.platform.a.b;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes8.dex */
public class c extends Thread {
    private static final boolean a = w.b;
    private final BlockingQueue<n<?>> b;
    private final BlockingQueue<n<?>> c;
    private final b d;
    private final r e;
    private volatile boolean f = false;

    public c(BlockingQueue<n<?>> blockingQueue, BlockingQueue<n<?>> blockingQueue2, b bVar, r rVar) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.d = bVar;
        this.e = rVar;
    }

    public void a() {
        this.f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (a) {
            w.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.a();
        while (true) {
            try {
                n<?> take = this.b.take();
                take.a("cache-queue-take");
                if (take.h()) {
                    take.b("cache-discard-canceled");
                } else {
                    b.a a2 = this.d.a(take.e());
                    if (a2 == null) {
                        take.a("cache-miss");
                        this.c.put(take);
                    } else if (a2.a()) {
                        take.a("cache-hit-expired");
                        take.a(a2);
                        this.c.put(take);
                    } else {
                        take.a("cache-hit");
                        q<?> a3 = take.a(new l(a2.a, a2.g));
                        take.a("cache-hit-parsed");
                        if (!a2.b()) {
                            this.e.a(take, a3);
                        } else {
                            take.a("cache-hit-refresh-needed");
                            take.a(a2);
                            a3.d = true;
                            this.e.a(take, a3, new d(this, take));
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.f) {
                    return;
                }
            }
        }
    }
}
