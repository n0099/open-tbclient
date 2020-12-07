package com.baidu.pano.platform.a;

import com.baidu.pano.platform.a.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2662a;
    final /* synthetic */ long b;
    final /* synthetic */ n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, String str, long j) {
        this.c = nVar;
        this.f2662a = str;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        w.a aVar;
        w.a aVar2;
        aVar = this.c.f2660a;
        aVar.a(this.f2662a, this.b);
        aVar2 = this.c.f2660a;
        aVar2.a(toString());
    }
}
