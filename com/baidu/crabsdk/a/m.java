package com.baidu.crabsdk.a;
/* loaded from: classes2.dex */
final class m implements Runnable {
    final /* synthetic */ long UN;
    final /* synthetic */ long UO;
    final /* synthetic */ long UQ;
    final /* synthetic */ long UR;
    final /* synthetic */ l US;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.US = lVar;
        this.UN = j;
        this.UO = j2;
        this.UQ = j3;
        this.UR = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.US.UL;
        iVar.c(this.UN, this.UO, this.UQ, this.UR);
    }
}
