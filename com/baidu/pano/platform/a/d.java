package com.baidu.pano.platform.a;

import java.util.concurrent.BlockingQueue;
/* loaded from: classes3.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f3906a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f3907b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, n nVar) {
        this.f3907b = cVar;
        this.f3906a = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.f3907b.c;
            blockingQueue.put(this.f3906a);
        } catch (InterruptedException e) {
        }
    }
}
