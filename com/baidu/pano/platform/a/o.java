package com.baidu.pano.platform.a;

import com.baidu.pano.platform.a.w;
/* loaded from: classes2.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f9397a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f9398b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f9399c;

    public o(n nVar, String str, long j) {
        this.f9399c = nVar;
        this.f9397a = str;
        this.f9398b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        w.a aVar;
        w.a aVar2;
        aVar = this.f9399c.f9384a;
        aVar.a(this.f9397a, this.f9398b);
        aVar2 = this.f9399c.f9384a;
        aVar2.a(toString());
    }
}
