package com.baidu.pano.platform.a;

import com.baidu.pano.platform.a.w;
/* loaded from: classes2.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f9284a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f9285b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f9286c;

    public o(n nVar, String str, long j) {
        this.f9286c = nVar;
        this.f9284a = str;
        this.f9285b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        w.a aVar;
        w.a aVar2;
        aVar = this.f9286c.f9270a;
        aVar.a(this.f9284a, this.f9285b);
        aVar2 = this.f9286c.f9270a;
        aVar2.a(toString());
    }
}
