package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ k mm;
    private final /* synthetic */ String mn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str) {
        this.mm = kVar;
        this.mn = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mm.ml.M(this.mn);
    }
}
