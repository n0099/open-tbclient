package com.baidu.pano.platform.a;

import java.util.concurrent.BlockingQueue;
/* loaded from: classes3.dex */
class d implements Runnable {
    final /* synthetic */ n a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, n nVar) {
        this.b = cVar;
        this.a = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.b.c;
            blockingQueue.put(this.a);
        } catch (InterruptedException e) {
        }
    }
}
