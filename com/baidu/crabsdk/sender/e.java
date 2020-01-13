package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class e implements Runnable {
    final /* synthetic */ d QV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.QV = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.QV;
        i = this.QV.QS;
        dVar.QS = (i + 1) % 10;
    }
}
