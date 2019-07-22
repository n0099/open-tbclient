package com.baidu.crabsdk.a;
/* loaded from: classes3.dex */
final class m implements Runnable {
    final /* synthetic */ long ZA;
    final /* synthetic */ long ZB;
    final /* synthetic */ long ZC;
    final /* synthetic */ l ZD;
    final /* synthetic */ long Zz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.ZD = lVar;
        this.Zz = j;
        this.ZA = j2;
        this.ZB = j3;
        this.ZC = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.ZD.Zx;
        iVar.c(this.Zz, this.ZA, this.ZB, this.ZC);
    }
}
