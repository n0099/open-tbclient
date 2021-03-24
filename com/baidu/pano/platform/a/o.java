package com.baidu.pano.platform.a;

import com.baidu.pano.platform.a.w;
/* loaded from: classes2.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f9396a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f9397b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f9398c;

    public o(n nVar, String str, long j) {
        this.f9398c = nVar;
        this.f9396a = str;
        this.f9397b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        w.a aVar;
        w.a aVar2;
        aVar = this.f9398c.f9383a;
        aVar.a(this.f9396a, this.f9397b);
        aVar2 = this.f9398c.f9383a;
        aVar2.a(toString());
    }
}
