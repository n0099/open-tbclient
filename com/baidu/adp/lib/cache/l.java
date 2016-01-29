package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ k tx;
    private final /* synthetic */ String ty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str) {
        this.tx = kVar;
        this.ty = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tx.tw.S(this.ty);
    }
}
