package com.baidu.crabsdk.a;
/* loaded from: classes8.dex */
final class m implements Runnable {
    final /* synthetic */ long alP;
    final /* synthetic */ long alQ;
    final /* synthetic */ long alR;
    final /* synthetic */ long alS;
    final /* synthetic */ l alT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.alT = lVar;
        this.alP = j;
        this.alQ = j2;
        this.alR = j3;
        this.alS = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.alT.alO;
        iVar.c(this.alP, this.alQ, this.alR, this.alS);
    }
}
