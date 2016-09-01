package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p mA;
    private final /* synthetic */ String mB;
    private final /* synthetic */ o.a mD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.mA = pVar;
        this.mB = str;
        this.mD = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mD.m(this.mB, this.mA.get(this.mB));
    }
}
