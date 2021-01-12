package com.baidu.pano.platform.a;

import com.baidu.pano.platform.a.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3886a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f3887b;
    final /* synthetic */ n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, String str, long j) {
        this.c = nVar;
        this.f3886a = str;
        this.f3887b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        w.a aVar;
        w.a aVar2;
        aVar = this.c.f3882a;
        aVar.a(this.f3886a, this.f3887b);
        aVar2 = this.c.f3882a;
        aVar2.a(toString());
    }
}
