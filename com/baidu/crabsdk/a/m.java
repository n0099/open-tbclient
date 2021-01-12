package com.baidu.crabsdk.a;
/* loaded from: classes14.dex */
final class m implements Runnable {
    final /* synthetic */ long aoG;
    final /* synthetic */ long aoH;
    final /* synthetic */ long aoI;
    final /* synthetic */ long aoJ;
    final /* synthetic */ l aoK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.aoK = lVar;
        this.aoG = j;
        this.aoH = j2;
        this.aoI = j3;
        this.aoJ = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.aoK.aoF;
        iVar.c(this.aoG, this.aoH, this.aoI, this.aoJ);
    }
}
