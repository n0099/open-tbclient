package com.baidu.crabsdk.a;
/* loaded from: classes3.dex */
final class m implements Runnable {
    final /* synthetic */ long Zf;
    final /* synthetic */ long Zg;
    final /* synthetic */ long Zh;
    final /* synthetic */ long Zi;
    final /* synthetic */ l Zj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.Zj = lVar;
        this.Zf = j;
        this.Zg = j2;
        this.Zh = j3;
        this.Zi = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.Zj.Zd;
        iVar.c(this.Zf, this.Zg, this.Zh, this.Zi);
    }
}
