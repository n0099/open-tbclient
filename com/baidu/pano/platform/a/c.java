package com.baidu.pano.platform.a;

import android.os.Process;
import com.baidu.pano.platform.a.b;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes2.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9240a = w.f9303b;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<n<?>> f9241b;

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue<n<?>> f9242c;

    /* renamed from: d  reason: collision with root package name */
    public final b f9243d;

    /* renamed from: e  reason: collision with root package name */
    public final r f9244e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f9245f = false;

    public c(BlockingQueue<n<?>> blockingQueue, BlockingQueue<n<?>> blockingQueue2, b bVar, r rVar) {
        this.f9241b = blockingQueue;
        this.f9242c = blockingQueue2;
        this.f9243d = bVar;
        this.f9244e = rVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f9240a) {
            w.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f9243d.a();
        while (true) {
            try {
                n<?> take = this.f9241b.take();
                take.a("cache-queue-take");
                if (take.h()) {
                    take.b("cache-discard-canceled");
                } else {
                    b.a a2 = this.f9243d.a(take.e());
                    if (a2 == null) {
                        take.a("cache-miss");
                        this.f9242c.put(take);
                    } else if (a2.a()) {
                        take.a("cache-hit-expired");
                        take.a(a2);
                        this.f9242c.put(take);
                    } else {
                        take.a("cache-hit");
                        q<?> a3 = take.a(new l(a2.f9233a, a2.f9239g));
                        take.a("cache-hit-parsed");
                        if (!a2.b()) {
                            this.f9244e.a(take, a3);
                        } else {
                            take.a("cache-hit-refresh-needed");
                            take.a(a2);
                            a3.f9299d = true;
                            this.f9244e.a(take, a3, new d(this, take));
                        }
                    }
                }
            } catch (InterruptedException unused) {
                if (this.f9245f) {
                    return;
                }
            }
        }
    }

    public void a() {
        this.f9245f = true;
        interrupt();
    }
}
