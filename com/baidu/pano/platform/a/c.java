package com.baidu.pano.platform.a;

import android.os.Process;
import com.baidu.pano.platform.a.b;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes2.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9354a = w.f9415b;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<n<?>> f9355b;

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue<n<?>> f9356c;

    /* renamed from: d  reason: collision with root package name */
    public final b f9357d;

    /* renamed from: e  reason: collision with root package name */
    public final r f9358e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f9359f = false;

    public c(BlockingQueue<n<?>> blockingQueue, BlockingQueue<n<?>> blockingQueue2, b bVar, r rVar) {
        this.f9355b = blockingQueue;
        this.f9356c = blockingQueue2;
        this.f9357d = bVar;
        this.f9358e = rVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f9354a) {
            w.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f9357d.a();
        while (true) {
            try {
                n<?> take = this.f9355b.take();
                take.a("cache-queue-take");
                if (take.h()) {
                    take.b("cache-discard-canceled");
                } else {
                    b.a a2 = this.f9357d.a(take.e());
                    if (a2 == null) {
                        take.a("cache-miss");
                        this.f9356c.put(take);
                    } else if (a2.a()) {
                        take.a("cache-hit-expired");
                        take.a(a2);
                        this.f9356c.put(take);
                    } else {
                        take.a("cache-hit");
                        q<?> a3 = take.a(new l(a2.f9347a, a2.f9353g));
                        take.a("cache-hit-parsed");
                        if (!a2.b()) {
                            this.f9358e.a(take, a3);
                        } else {
                            take.a("cache-hit-refresh-needed");
                            take.a(a2);
                            a3.f9411d = true;
                            this.f9358e.a(take, a3, new d(this, take));
                        }
                    }
                }
            } catch (InterruptedException unused) {
                if (this.f9359f) {
                    return;
                }
            }
        }
    }

    public void a() {
        this.f9359f = true;
        interrupt();
    }
}
