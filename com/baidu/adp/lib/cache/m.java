package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ k tF;
    private final /* synthetic */ String tG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str) {
        this.tF = kVar;
        this.tG = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tF.tE.H(this.tG);
    }
}
