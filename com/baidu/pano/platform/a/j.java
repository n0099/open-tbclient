package com.baidu.pano.platform.a;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes2.dex */
public class j extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue<n<?>> f9260a;

    /* renamed from: b  reason: collision with root package name */
    public final i f9261b;

    /* renamed from: c  reason: collision with root package name */
    public final b f9262c;

    /* renamed from: d  reason: collision with root package name */
    public final r f9263d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f9264e = false;

    public j(BlockingQueue<n<?>> blockingQueue, i iVar, b bVar, r rVar) {
        this.f9260a = blockingQueue;
        this.f9261b = iVar;
        this.f9262c = bVar;
        this.f9263d = rVar;
    }

    public void a() {
        this.f9264e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                n<?> take = this.f9260a.take();
                try {
                    take.a("network-queue-take");
                    if (take.h()) {
                        take.b("network-discard-cancelled");
                    } else {
                        a(take);
                        l a2 = this.f9261b.a(take);
                        take.a("network-http-complete");
                        if (a2.f9268d && take.w()) {
                            take.b("not-modified");
                        } else {
                            q<?> a3 = take.a(a2);
                            take.a("network-parse-complete");
                            if (take.r() && a3.f9297b != null) {
                                this.f9262c.a(take.e(), a3.f9297b);
                                take.a("network-cache-written");
                            }
                            take.v();
                            this.f9263d.a(take, a3);
                        }
                    }
                } catch (v e2) {
                    e2.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    a(take, e2);
                } catch (Exception e3) {
                    w.a(e3, "Unhandled exception %s", e3.toString());
                    v vVar = new v(e3);
                    vVar.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f9263d.a(take, vVar);
                }
            } catch (InterruptedException unused) {
                if (this.f9264e) {
                    return;
                }
            }
        }
    }

    @TargetApi(14)
    private void a(n<?> nVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(nVar.b());
        }
    }

    private void a(n<?> nVar, v vVar) {
        this.f9263d.a(nVar, nVar.a(vVar));
    }
}
