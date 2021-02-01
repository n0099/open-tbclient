package com.baidu.pano.platform.a;

import java.util.concurrent.BlockingQueue;
/* loaded from: classes4.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f3871a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f3872b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, n nVar) {
        this.f3872b = cVar;
        this.f3871a = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.f3872b.c;
            blockingQueue.put(this.f3871a);
        } catch (InterruptedException e) {
        }
    }
}
