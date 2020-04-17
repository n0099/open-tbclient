package com.baidu.crabsdk.a;
/* loaded from: classes8.dex */
final class m implements Runnable {
    final /* synthetic */ long aE;
    final /* synthetic */ long ajJ;
    final /* synthetic */ long ajK;
    final /* synthetic */ long ajL;
    final /* synthetic */ l ajM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.ajM = lVar;
        this.ajJ = j;
        this.ajK = j2;
        this.aE = j3;
        this.ajL = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.ajM.ajH;
        iVar.c(this.ajJ, this.ajK, this.aE, this.ajL);
    }
}
