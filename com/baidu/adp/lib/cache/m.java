package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ k tj;
    private final /* synthetic */ String tk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str) {
        this.tj = kVar;
        this.tk = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tj.ti.U(this.tk);
    }
}
