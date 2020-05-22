package com.baidu.crabsdk.a;
/* loaded from: classes8.dex */
final class m implements Runnable {
    final /* synthetic */ long akt;
    final /* synthetic */ long aku;
    final /* synthetic */ long akv;
    final /* synthetic */ long akw;
    final /* synthetic */ l akx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.akx = lVar;
        this.akt = j;
        this.aku = j2;
        this.akv = j3;
        this.akw = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.akx.akr;
        iVar.c(this.akt, this.aku, this.akv, this.akw);
    }
}
