package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f1500a;
    final /* synthetic */ a.c b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, a.c cVar) {
        this.c = aVar;
        this.f1500a = j;
        this.b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Thread.sleep(this.f1500a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.c.d(this.b);
    }
}
