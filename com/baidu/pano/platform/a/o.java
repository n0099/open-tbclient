package com.baidu.pano.platform.a;

import com.baidu.pano.platform.a.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3924a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f3925b;
    final /* synthetic */ n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, String str, long j) {
        this.c = nVar;
        this.f3924a = str;
        this.f3925b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        w.a aVar;
        w.a aVar2;
        aVar = this.c.f3920a;
        aVar.a(this.f3924a, this.f3925b);
        aVar2 = this.c.f3920a;
        aVar2.a(toString());
    }
}
