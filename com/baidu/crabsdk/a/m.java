package com.baidu.crabsdk.a;
/* loaded from: classes5.dex */
final class m implements Runnable {
    final /* synthetic */ l aoA;
    final /* synthetic */ long aow;
    final /* synthetic */ long aox;
    final /* synthetic */ long aoy;
    final /* synthetic */ long aoz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.aoA = lVar;
        this.aow = j;
        this.aox = j2;
        this.aoy = j3;
        this.aoz = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.aoA.aov;
        iVar.c(this.aow, this.aox, this.aoy, this.aoz);
    }
}
