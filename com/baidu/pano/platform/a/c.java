package com.baidu.pano.platform.a;

import android.os.Process;
import com.baidu.pano.platform.a.b;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes3.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f3904a = w.f3933b;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<n<?>> f3905b;
    private final BlockingQueue<n<?>> c;
    private final b d;
    private final r e;
    private volatile boolean f = false;

    public c(BlockingQueue<n<?>> blockingQueue, BlockingQueue<n<?>> blockingQueue2, b bVar, r rVar) {
        this.f3905b = blockingQueue;
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
        if (f3904a) {
            w.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.a();
        while (true) {
            try {
                n<?> take = this.f3905b.take();
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
                        q<?> a3 = take.a(new l(a2.f3902a, a2.g));
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
