package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ p mA;
    private final /* synthetic */ String mB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, String str) {
        this.mA = pVar;
        this.mB = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mA.remove(this.mB);
    }
}
