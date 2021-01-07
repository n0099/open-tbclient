package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f1938a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a.c f1939b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, a.c cVar) {
        this.c = aVar;
        this.f1938a = j;
        this.f1939b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Thread.sleep(this.f1938a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.c.d(this.f1939b);
    }
}
