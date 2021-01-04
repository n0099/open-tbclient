package com.baidu.pano.platform.a;

import java.util.concurrent.BlockingQueue;
/* loaded from: classes15.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f3905a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f3906b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, n nVar) {
        this.f3906b = cVar;
        this.f3905a = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.f3906b.c;
            blockingQueue.put(this.f3905a);
        } catch (InterruptedException e) {
        }
    }
}
