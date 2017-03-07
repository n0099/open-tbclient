package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p up;
    private final /* synthetic */ String uq;
    private final /* synthetic */ o.a ur;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.up = pVar;
        this.uq = str;
        this.ur = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ur.m(this.uq, this.up.get(this.uq));
    }
}
