package com.baidu.pano.platform.a;

import android.os.Process;
import com.baidu.pano.platform.a.b;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes2.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9353a = w.f9414b;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<n<?>> f9354b;

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue<n<?>> f9355c;

    /* renamed from: d  reason: collision with root package name */
    public final b f9356d;

    /* renamed from: e  reason: collision with root package name */
    public final r f9357e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f9358f = false;

    public c(BlockingQueue<n<?>> blockingQueue, BlockingQueue<n<?>> blockingQueue2, b bVar, r rVar) {
        this.f9354b = blockingQueue;
        this.f9355c = blockingQueue2;
        this.f9356d = bVar;
        this.f9357e = rVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f9353a) {
            w.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f9356d.a();
        while (true) {
            try {
                n<?> take = this.f9354b.take();
                take.a("cache-queue-take");
                if (take.h()) {
                    take.b("cache-discard-canceled");
                } else {
                    b.a a2 = this.f9356d.a(take.e());
                    if (a2 == null) {
                        take.a("cache-miss");
                        this.f9355c.put(take);
                    } else if (a2.a()) {
                        take.a("cache-hit-expired");
                        take.a(a2);
                        this.f9355c.put(take);
                    } else {
                        take.a("cache-hit");
                        q<?> a3 = take.a(new l(a2.f9346a, a2.f9352g));
                        take.a("cache-hit-parsed");
                        if (!a2.b()) {
                            this.f9357e.a(take, a3);
                        } else {
                            take.a("cache-hit-refresh-needed");
                            take.a(a2);
                            a3.f9410d = true;
                            this.f9357e.a(take, a3, new d(this, take));
                        }
                    }
                }
            } catch (InterruptedException unused) {
                if (this.f9358f) {
                    return;
                }
            }
        }
    }

    public void a() {
        this.f9358f = true;
        interrupt();
    }
}
