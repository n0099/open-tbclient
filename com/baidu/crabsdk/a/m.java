package com.baidu.crabsdk.a;
/* loaded from: classes8.dex */
final class m implements Runnable {
    final /* synthetic */ long Rn;
    final /* synthetic */ long Ro;
    final /* synthetic */ long Rp;
    final /* synthetic */ l Rq;
    final /* synthetic */ long aE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.Rq = lVar;
        this.Rn = j;
        this.Ro = j2;
        this.aE = j3;
        this.Rp = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.Rq.Rl;
        iVar.c(this.Rn, this.Ro, this.aE, this.Rp);
    }
}
