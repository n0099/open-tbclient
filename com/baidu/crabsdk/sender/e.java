package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class e implements Runnable {
    final /* synthetic */ d SA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.SA = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.SA;
        i = this.SA.Sx;
        dVar.Sx = (i + 1) % 10;
    }
}
