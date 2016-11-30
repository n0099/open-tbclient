package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p mB;
    private final /* synthetic */ String mD;
    private final /* synthetic */ o.a mE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.mB = pVar;
        this.mD = str;
        this.mE = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mE.m(this.mD, this.mB.get(this.mD));
    }
}
