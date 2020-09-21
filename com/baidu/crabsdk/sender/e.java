package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class e implements Runnable {
    final /* synthetic */ d aps;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aps = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.aps;
        i = this.aps.apo;
        dVar.apo = (i + 1) % 10;
    }
}
