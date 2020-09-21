package com.baidu.crabsdk.a;
/* loaded from: classes8.dex */
final class m implements Runnable {
    final /* synthetic */ long anr;
    final /* synthetic */ long ans;
    final /* synthetic */ long ant;
    final /* synthetic */ long anu;
    final /* synthetic */ l anv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.anv = lVar;
        this.anr = j;
        this.ans = j2;
        this.ant = j3;
        this.anu = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.anv.anq;
        iVar.c(this.anr, this.ans, this.ant, this.anu);
    }
}
