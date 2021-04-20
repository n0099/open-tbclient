package com.baidu.pano.platform.a;

import android.os.Process;
import com.baidu.pano.platform.a.b;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes2.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8912a = w.f8973b;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<n<?>> f8913b;

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue<n<?>> f8914c;

    /* renamed from: d  reason: collision with root package name */
    public final b f8915d;

    /* renamed from: e  reason: collision with root package name */
    public final r f8916e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f8917f = false;

    public c(BlockingQueue<n<?>> blockingQueue, BlockingQueue<n<?>> blockingQueue2, b bVar, r rVar) {
        this.f8913b = blockingQueue;
        this.f8914c = blockingQueue2;
        this.f8915d = bVar;
        this.f8916e = rVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f8912a) {
            w.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f8915d.a();
        while (true) {
            try {
                n<?> take = this.f8913b.take();
                take.a("cache-queue-take");
                if (take.h()) {
                    take.b("cache-discard-canceled");
                } else {
                    b.a a2 = this.f8915d.a(take.e());
                    if (a2 == null) {
                        take.a("cache-miss");
                        this.f8914c.put(take);
                    } else if (a2.a()) {
                        take.a("cache-hit-expired");
                        take.a(a2);
                        this.f8914c.put(take);
                    } else {
                        take.a("cache-hit");
                        q<?> a3 = take.a(new l(a2.f8905a, a2.f8911g));
                        take.a("cache-hit-parsed");
                        if (!a2.b()) {
                            this.f8916e.a(take, a3);
                        } else {
                            take.a("cache-hit-refresh-needed");
                            take.a(a2);
                            a3.f8969d = true;
                            this.f8916e.a(take, a3, new d(this, take));
                        }
                    }
                }
            } catch (InterruptedException unused) {
                if (this.f8917f) {
                    return;
                }
            }
        }
    }

    public void a() {
        this.f8917f = true;
        interrupt();
    }
}
