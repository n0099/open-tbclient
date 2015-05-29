package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p tp;
    private final /* synthetic */ String tq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str) {
        this.tp = pVar;
        this.tq = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tp.tn.V(this.tq);
    }
}
