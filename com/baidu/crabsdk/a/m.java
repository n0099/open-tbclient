package com.baidu.crabsdk.a;
/* loaded from: classes3.dex */
final class m implements Runnable {
    final /* synthetic */ long abn;
    final /* synthetic */ long abo;
    final /* synthetic */ long abp;
    final /* synthetic */ long abq;
    final /* synthetic */ l abr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.abr = lVar;
        this.abn = j;
        this.abo = j2;
        this.abp = j3;
        this.abq = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.abr.abl;
        iVar.c(this.abn, this.abo, this.abp, this.abq);
    }
}
