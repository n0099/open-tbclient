package com.baidu.crabsdk.a;
/* loaded from: classes3.dex */
final class m implements Runnable {
    final /* synthetic */ long abl;
    final /* synthetic */ long abm;
    final /* synthetic */ long abn;
    final /* synthetic */ long abo;
    final /* synthetic */ l abp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.abp = lVar;
        this.abl = j;
        this.abm = j2;
        this.abn = j3;
        this.abo = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.abp.abj;
        iVar.c(this.abl, this.abm, this.abn, this.abo);
    }
}
