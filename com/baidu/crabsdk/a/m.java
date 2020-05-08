package com.baidu.crabsdk.a;
/* loaded from: classes8.dex */
final class m implements Runnable {
    final /* synthetic */ long aE;
    final /* synthetic */ long ajP;
    final /* synthetic */ long ajQ;
    final /* synthetic */ long ajR;
    final /* synthetic */ l ajS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.ajS = lVar;
        this.ajP = j;
        this.ajQ = j2;
        this.aE = j3;
        this.ajR = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.ajS.ajN;
        iVar.c(this.ajP, this.ajQ, this.aE, this.ajR);
    }
}
