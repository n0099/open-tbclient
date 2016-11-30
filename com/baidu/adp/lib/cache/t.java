package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ p mB;
    private final /* synthetic */ String mD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, String str) {
        this.mB = pVar;
        this.mD = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mB.remove(this.mD);
    }
}
