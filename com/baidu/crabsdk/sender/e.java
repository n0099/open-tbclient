package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class e implements Runnable {
    final /* synthetic */ d aqc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aqc = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.aqc;
        i = this.aqc.apZ;
        dVar.apZ = (i + 1) % 10;
    }
}
