package com.baidu.crabsdk.a;
/* loaded from: classes6.dex */
final class m implements Runnable {
    final /* synthetic */ long amP;
    final /* synthetic */ long amQ;
    final /* synthetic */ long amR;
    final /* synthetic */ long amS;
    final /* synthetic */ l amT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.amT = lVar;
        this.amP = j;
        this.amQ = j2;
        this.amR = j3;
        this.amS = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.amT.amO;
        iVar.c(this.amP, this.amQ, this.amR, this.amS);
    }
}
