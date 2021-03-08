package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class e implements Runnable {
    final /* synthetic */ d asc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.asc = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.asc;
        i = this.asc.arZ;
        dVar.arZ = (i + 1) % 10;
    }
}
