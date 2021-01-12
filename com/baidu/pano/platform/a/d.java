package com.baidu.pano.platform.a;

import java.util.concurrent.BlockingQueue;
/* loaded from: classes6.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f3868a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f3869b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, n nVar) {
        this.f3869b = cVar;
        this.f3868a = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.f3869b.c;
            blockingQueue.put(this.f3868a);
        } catch (InterruptedException e) {
        }
    }
}
