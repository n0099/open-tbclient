package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p hF;
    private final /* synthetic */ String hG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str) {
        this.hF = pVar;
        this.hG = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.hF.hE.N(this.hG);
    }
}
