package com.baidu.pano.platform.a;

import com.baidu.pano.platform.a.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class o implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, String str, long j) {
        this.c = nVar;
        this.a = str;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        w.a aVar;
        w.a aVar2;
        aVar = this.c.a;
        aVar.a(this.a, this.b);
        aVar2 = this.c.a;
        aVar2.a(toString());
    }
}
