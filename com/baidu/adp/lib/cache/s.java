package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    private final /* synthetic */ long mA;
    final /* synthetic */ p mu;
    private final /* synthetic */ String mw;
    private final /* synthetic */ Object mz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str, Object obj, long j) {
        this.mu = pVar;
        this.mw = str;
        this.mz = obj;
        this.mA = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mu.a(this.mw, this.mz, this.mA);
    }
}
