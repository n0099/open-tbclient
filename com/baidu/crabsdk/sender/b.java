package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements Runnable {
    final /* synthetic */ a Tm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.Tm = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        a aVar = this.Tm;
        i = this.Tm.Tj;
        aVar.Tj = (i + 1) % 10;
    }
}
