package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p tB;
    private final /* synthetic */ String tC;
    private final /* synthetic */ o.a tD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.tB = pVar;
        this.tC = str;
        this.tD = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tD.onItemGet(this.tC, this.tB.get(this.tC));
    }
}
