package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ k tE;
    private final /* synthetic */ String tF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str) {
        this.tE = kVar;
        this.tF = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tE.tD.N(this.tF);
    }
}
