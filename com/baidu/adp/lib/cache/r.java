package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p fD;
    private final /* synthetic */ String fE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str) {
        this.fD = pVar;
        this.fE = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fD.fC.y(this.fE);
    }
}
