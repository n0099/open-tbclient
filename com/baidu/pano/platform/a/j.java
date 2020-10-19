package com.baidu.pano.platform.a;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes7.dex */
public class j extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<n<?>> f2654a;
    private final i b;
    private final b c;
    private final r d;
    private volatile boolean e = false;

    public j(BlockingQueue<n<?>> blockingQueue, i iVar, b bVar, r rVar) {
        this.f2654a = blockingQueue;
        this.b = iVar;
        this.c = bVar;
        this.d = rVar;
    }

    public void a() {
        this.e = true;
        interrupt();
    }

    @TargetApi(14)
    private void a(n<?> nVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(nVar.b());
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                n<?> take = this.f2654a.take();
                try {
                    take.a("network-queue-take");
                    if (take.h()) {
                        take.b("network-discard-cancelled");
                    } else {
                        a(take);
                        l a2 = this.b.a(take);
                        take.a("network-http-complete");
                        if (a2.d && take.w()) {
                            take.b("not-modified");
                        } else {
                            q<?> a3 = take.a(a2);
                            take.a("network-parse-complete");
                            if (take.r() && a3.b != null) {
                                this.c.a(take.e(), a3.b);
                                take.a("network-cache-written");
                            }
                            take.v();
                            this.d.a(take, a3);
                        }
                    }
                } catch (v e) {
                    e.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    a(take, e);
                } catch (Exception e2) {
                    w.a(e2, "Unhandled exception %s", e2.toString());
                    v vVar = new v(e2);
                    vVar.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.d.a(take, vVar);
                }
            } catch (InterruptedException e3) {
                if (this.e) {
                    return;
                }
            }
        }
    }

    private void a(n<?> nVar, v vVar) {
        this.d.a(nVar, nVar.a(vVar));
    }
}
