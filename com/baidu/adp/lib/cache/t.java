package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ p mu;
    private final /* synthetic */ String mw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, String str) {
        this.mu = pVar;
        this.mw = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mu.remove(this.mw);
    }
}
