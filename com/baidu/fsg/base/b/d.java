package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.a;
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f5174a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a.c f5175b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f5176c;

    public d(a aVar, long j, a.c cVar) {
        this.f5176c = aVar;
        this.f5174a = j;
        this.f5175b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Thread.sleep(this.f5174a);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.f5176c.d(this.f5175b);
    }
}
