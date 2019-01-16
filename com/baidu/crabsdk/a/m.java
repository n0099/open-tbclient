package com.baidu.crabsdk.a;
/* loaded from: classes6.dex */
final class m implements Runnable {
    final /* synthetic */ long XK;
    final /* synthetic */ long XL;
    final /* synthetic */ long XM;
    final /* synthetic */ long XN;
    final /* synthetic */ l XO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.XO = lVar;
        this.XK = j;
        this.XL = j2;
        this.XM = j3;
        this.XN = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.XO.XI;
        iVar.c(this.XK, this.XL, this.XM, this.XN);
    }
}
