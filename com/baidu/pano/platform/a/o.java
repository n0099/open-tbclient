package com.baidu.pano.platform.a;

import com.baidu.pano.platform.a.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3923a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f3924b;
    final /* synthetic */ n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, String str, long j) {
        this.c = nVar;
        this.f3923a = str;
        this.f3924b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        w.a aVar;
        w.a aVar2;
        aVar = this.c.f3919a;
        aVar.a(this.f3923a, this.f3924b);
        aVar2 = this.c.f3919a;
        aVar2.a(toString());
    }
}
