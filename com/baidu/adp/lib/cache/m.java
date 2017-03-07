package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ k ub;
    private final /* synthetic */ String uc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str) {
        this.ub = kVar;
        this.uc = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ub.ua.K(this.uc);
    }
}
