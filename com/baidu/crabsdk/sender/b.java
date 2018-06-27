package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements Runnable {
    final /* synthetic */ a Tp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.Tp = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        a aVar = this.Tp;
        i = this.Tp.Tm;
        aVar.Tm = (i + 1) % 10;
    }
}
