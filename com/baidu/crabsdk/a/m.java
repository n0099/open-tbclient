package com.baidu.crabsdk.a;
/* loaded from: classes8.dex */
final class m implements Runnable {
    final /* synthetic */ long Rk;
    final /* synthetic */ long Rl;
    final /* synthetic */ long Rm;
    final /* synthetic */ long Rn;
    final /* synthetic */ l Ro;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.Ro = lVar;
        this.Rk = j;
        this.Rl = j2;
        this.Rm = j3;
        this.Rn = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.Ro.Ri;
        iVar.c(this.Rk, this.Rl, this.Rm, this.Rn);
    }
}
