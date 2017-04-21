package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ k tE;
    private final /* synthetic */ String tF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str) {
        this.tE = kVar;
        this.tF = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tE.tD.H(this.tF);
    }
}
