package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p hH;
    private final /* synthetic */ String hI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str) {
        this.hH = pVar;
        this.hI = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.hH.hG.M(this.hI);
    }
}
