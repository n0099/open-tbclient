package com.baidu.crabsdk.a;
/* loaded from: classes2.dex */
final class m implements Runnable {
    final /* synthetic */ long Si;
    final /* synthetic */ long Sj;
    final /* synthetic */ long Sk;
    final /* synthetic */ long Sl;
    final /* synthetic */ l Sm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.Sm = lVar;
        this.Si = j;
        this.Sj = j2;
        this.Sk = j3;
        this.Sl = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.Sm.Sg;
        iVar.c(this.Si, this.Sj, this.Sk, this.Sl);
    }
}
