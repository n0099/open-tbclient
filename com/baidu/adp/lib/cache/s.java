package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ p mA;
    private final /* synthetic */ String mB;
    private final /* synthetic */ Object mF;
    private final /* synthetic */ long mG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str, Object obj, long j) {
        this.mA = pVar;
        this.mB = str;
        this.mF = obj;
        this.mG = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mA.a(this.mB, this.mF, this.mG);
    }
}
