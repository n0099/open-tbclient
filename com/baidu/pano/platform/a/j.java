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
    public final BlockingQueue<n<?>> f8932a;

    /* renamed from: b  reason: collision with root package name */
    public final i f8933b;

    /* renamed from: c  reason: collision with root package name */
    public final b f8934c;

    /* renamed from: d  reason: collision with root package name */
    public final r f8935d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f8936e = false;

    public j(BlockingQueue<n<?>> blockingQueue, i iVar, b bVar, r rVar) {
        this.f8932a = blockingQueue;
        this.f8933b = iVar;
        this.f8934c = bVar;
        this.f8935d = rVar;
    }

    public void a() {
        this.f8936e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                n<?> take = this.f8932a.take();
                try {
                    take.a("network-queue-take");
                    if (take.h()) {
                        take.b("network-discard-cancelled");
                    } else {
                        a(take);
                        l a2 = this.f8933b.a(take);
                        take.a("network-http-complete");
                        if (a2.f8940d && take.w()) {
                            take.b("not-modified");
                        } else {
                            q<?> a3 = take.a(a2);
                            take.a("network-parse-complete");
                            if (take.r() && a3.f8967b != null) {
                                this.f8934c.a(take.e(), a3.f8967b);
                                take.a("network-cache-written");
                            }
                            take.v();
                            this.f8935d.a(take, a3);
                        }
                    }
                } catch (v e2) {
                    e2.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    a(take, e2);
                } catch (Exception e3) {
                    w.a(e3, "Unhandled exception %s", e3.toString());
                    v vVar = new v(e3);
                    vVar.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f8935d.a(take, vVar);
                }
            } catch (InterruptedException unused) {
                if (this.f8936e) {
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
        this.f8935d.a(nVar, nVar.a(vVar));
    }
}
