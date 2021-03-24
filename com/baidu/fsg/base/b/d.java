package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.a;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f5173a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a.c f5174b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f5175c;

    public d(a aVar, long j, a.c cVar) {
        this.f5175c = aVar;
        this.f5173a = j;
        this.f5174b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Thread.sleep(this.f5173a);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.f5175c.d(this.f5174b);
    }
}
