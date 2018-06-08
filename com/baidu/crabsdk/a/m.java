package com.baidu.crabsdk.a;
/* loaded from: classes2.dex */
final class m implements Runnable {
    final /* synthetic */ long Sj;
    final /* synthetic */ long Sk;
    final /* synthetic */ long Sl;
    final /* synthetic */ long Sm;
    final /* synthetic */ l Sn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.Sn = lVar;
        this.Sj = j;
        this.Sk = j2;
        this.Sl = j3;
        this.Sm = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.Sn.Sh;
        iVar.c(this.Sj, this.Sk, this.Sl, this.Sm);
    }
}
