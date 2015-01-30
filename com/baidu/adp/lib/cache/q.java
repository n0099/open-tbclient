package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p hH;
    private final /* synthetic */ String hI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str) {
        this.hH = pVar;
        this.hI = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.hH.hG.N(this.hI);
    }
}
