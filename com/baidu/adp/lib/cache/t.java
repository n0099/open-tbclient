package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ p up;
    private final /* synthetic */ String uq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, String str) {
        this.up = pVar;
        this.uq = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.up.remove(this.uq);
    }
}
