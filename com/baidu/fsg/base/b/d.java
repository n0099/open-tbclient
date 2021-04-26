package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.a;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f5340a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a.c f5341b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f5342c;

    public d(a aVar, long j, a.c cVar) {
        this.f5342c = aVar;
        this.f5340a = j;
        this.f5341b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Thread.sleep(this.f5340a);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.f5342c.d(this.f5341b);
    }
}
