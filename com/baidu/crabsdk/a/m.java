package com.baidu.crabsdk.a;
/* loaded from: classes6.dex */
final class m implements Runnable {
    final /* synthetic */ long amN;
    final /* synthetic */ long amO;
    final /* synthetic */ long amP;
    final /* synthetic */ long amQ;
    final /* synthetic */ l amR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.amR = lVar;
        this.amN = j;
        this.amO = j2;
        this.amP = j3;
        this.amQ = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.amR.amM;
        iVar.c(this.amN, this.amO, this.amP, this.amQ);
    }
}
