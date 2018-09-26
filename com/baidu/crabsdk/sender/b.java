package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements Runnable {
    final /* synthetic */ a VP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.VP = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        a aVar = this.VP;
        i = this.VP.VM;
        aVar.VM = (i + 1) % 10;
    }
}
