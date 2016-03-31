package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ k tG;
    private final /* synthetic */ String tH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str) {
        this.tG = kVar;
        this.tH = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tG.tF.R(this.tH);
    }
}
