package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p tK;
    private final /* synthetic */ String tL;
    private final /* synthetic */ o.a tM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, o.a aVar) {
        this.tK = pVar;
        this.tL = str;
        this.tM = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tM.h(this.tL, this.tK.get(this.tL));
    }
}
