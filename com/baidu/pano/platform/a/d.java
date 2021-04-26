package com.baidu.pano.platform.a;

import java.util.concurrent.BlockingQueue;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f9246a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f9247b;

    public d(c cVar, n nVar) {
        this.f9247b = cVar;
        this.f9246a = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.f9247b.f9242c;
            blockingQueue.put(this.f9246a);
        } catch (InterruptedException unused) {
        }
    }
}
