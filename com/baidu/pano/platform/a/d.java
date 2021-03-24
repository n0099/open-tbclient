package com.baidu.pano.platform.a;

import java.util.concurrent.BlockingQueue;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f9359a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f9360b;

    public d(c cVar, n nVar) {
        this.f9360b = cVar;
        this.f9359a = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.f9360b.f9355c;
            blockingQueue.put(this.f9359a);
        } catch (InterruptedException unused) {
        }
    }
}
