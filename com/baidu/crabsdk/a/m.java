package com.baidu.crabsdk.a;
/* loaded from: classes2.dex */
final class m implements Runnable {
    final /* synthetic */ long Sl;
    final /* synthetic */ long Sm;
    final /* synthetic */ long Sn;
    final /* synthetic */ long So;
    final /* synthetic */ l Sp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.Sp = lVar;
        this.Sl = j;
        this.Sm = j2;
        this.Sn = j3;
        this.So = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.Sp.Sj;
        iVar.c(this.Sl, this.Sm, this.Sn, this.So);
    }
}
