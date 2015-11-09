package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ k tj;
    private final /* synthetic */ String tk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str) {
        this.tj = kVar;
        this.tk = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tj.ti.T(this.tk);
    }
}
