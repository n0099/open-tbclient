package com.baidu.crabsdk.a;
/* loaded from: classes3.dex */
final class m implements Runnable {
    final /* synthetic */ long abm;
    final /* synthetic */ long abn;
    final /* synthetic */ long abo;
    final /* synthetic */ long abp;
    final /* synthetic */ l abq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.abq = lVar;
        this.abm = j;
        this.abn = j2;
        this.abo = j3;
        this.abp = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.abq.abk;
        iVar.c(this.abm, this.abn, this.abo, this.abp);
    }
}
