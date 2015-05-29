package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p tp;
    private final /* synthetic */ String tq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str) {
        this.tp = pVar;
        this.tq = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tp.tn.W(this.tq);
    }
}
