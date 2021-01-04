package com.baidu.crabsdk.a;
/* loaded from: classes3.dex */
final class m implements Runnable {
    final /* synthetic */ long apv;
    final /* synthetic */ long apw;
    final /* synthetic */ long apx;
    final /* synthetic */ long apy;
    final /* synthetic */ l apz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.apz = lVar;
        this.apv = j;
        this.apw = j2;
        this.apx = j3;
        this.apy = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.apz.apu;
        iVar.c(this.apv, this.apw, this.apx, this.apy);
    }
}
