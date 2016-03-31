package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ k tG;
    private final /* synthetic */ String tH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str) {
        this.tG = kVar;
        this.tH = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tG.tF.S(this.tH);
    }
}
