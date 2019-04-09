package com.baidu.crabsdk.a;
/* loaded from: classes3.dex */
final class m implements Runnable {
    final /* synthetic */ long abo;
    final /* synthetic */ long abp;
    final /* synthetic */ long abq;
    final /* synthetic */ long abr;
    final /* synthetic */ l abt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.abt = lVar;
        this.abo = j;
        this.abp = j2;
        this.abq = j3;
        this.abr = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.abt.abm;
        iVar.c(this.abo, this.abp, this.abq, this.abr);
    }
}
