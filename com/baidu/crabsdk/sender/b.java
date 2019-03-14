package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b implements Runnable {
    final /* synthetic */ a acp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.acp = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        a aVar = this.acp;
        i = this.acp.by;
        aVar.by = (i + 1) % 10;
    }
}
