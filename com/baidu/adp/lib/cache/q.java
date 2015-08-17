package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p tA;
    private final /* synthetic */ String tB;
    private final /* synthetic */ o.a tC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.tA = pVar;
        this.tB = str;
        this.tC = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tC.onItemGet(this.tB, this.tA.get(this.tB));
    }
}
