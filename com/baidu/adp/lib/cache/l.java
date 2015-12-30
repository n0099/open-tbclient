package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ k tm;
    private final /* synthetic */ String tp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str) {
        this.tm = kVar;
        this.tp = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tm.tl.T(this.tp);
    }
}
