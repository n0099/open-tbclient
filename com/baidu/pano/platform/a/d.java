package com.baidu.pano.platform.a;

import java.util.concurrent.BlockingQueue;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f8918a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f8919b;

    public d(c cVar, n nVar) {
        this.f8919b = cVar;
        this.f8918a = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.f8919b.f8914c;
            blockingQueue.put(this.f8918a);
        } catch (InterruptedException unused) {
        }
    }
}
