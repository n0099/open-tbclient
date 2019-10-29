package com.baidu.crabsdk.a;
/* loaded from: classes3.dex */
final class m implements Runnable {
    final /* synthetic */ long JA;
    final /* synthetic */ long JB;
    final /* synthetic */ long JC;
    final /* synthetic */ long JD;
    final /* synthetic */ l JE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.JE = lVar;
        this.JA = j;
        this.JB = j2;
        this.JC = j3;
        this.JD = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.JE.Jy;
        iVar.c(this.JA, this.JB, this.JC, this.JD);
    }
}
