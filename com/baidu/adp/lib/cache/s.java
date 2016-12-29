package com.baidu.adp.lib.cache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ p mB;
    private final /* synthetic */ String mD;
    private final /* synthetic */ Object mG;
    private final /* synthetic */ long mH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str, Object obj, long j) {
        this.mB = pVar;
        this.mD = str;
        this.mG = obj;
        this.mH = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mB.a(this.mD, this.mG, this.mH);
    }
}
