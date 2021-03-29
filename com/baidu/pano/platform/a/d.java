package com.baidu.pano.platform.a;

import java.util.concurrent.BlockingQueue;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f9360a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f9361b;

    public d(c cVar, n nVar) {
        this.f9361b = cVar;
        this.f9360a = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.f9361b.f9356c;
            blockingQueue.put(this.f9360a);
        } catch (InterruptedException unused) {
        }
    }
}
