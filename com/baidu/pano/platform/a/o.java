package com.baidu.pano.platform.a;

import com.baidu.pano.platform.a.w;
/* loaded from: classes2.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f8955a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f8956b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f8957c;

    public o(n nVar, String str, long j) {
        this.f8957c = nVar;
        this.f8955a = str;
        this.f8956b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        w.a aVar;
        w.a aVar2;
        aVar = this.f8957c.f8942a;
        aVar.a(this.f8955a, this.f8956b);
        aVar2 = this.f8957c.f8942a;
        aVar2.a(toString());
    }
}
