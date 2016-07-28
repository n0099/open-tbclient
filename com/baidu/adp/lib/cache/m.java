package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ k jU;
    private final /* synthetic */ String jV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str) {
        this.jU = kVar;
        this.jV = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jU.jT.K(this.jV);
    }
}
