package com.baidu.crabsdk.a;
/* loaded from: classes6.dex */
final class m implements Runnable {
    final /* synthetic */ long XB;
    final /* synthetic */ long XC;
    final /* synthetic */ long XD;
    final /* synthetic */ long XE;
    final /* synthetic */ l XF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.XF = lVar;
        this.XB = j;
        this.XC = j2;
        this.XD = j3;
        this.XE = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.XF.Xz;
        iVar.c(this.XB, this.XC, this.XD, this.XE);
    }
}
