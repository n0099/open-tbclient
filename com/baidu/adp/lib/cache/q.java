package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p tT;
    private final /* synthetic */ String tU;
    private final /* synthetic */ o.a tV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.tT = pVar;
        this.tU = str;
        this.tV = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tV.g(this.tU, this.tT.get(this.tU));
    }
}
