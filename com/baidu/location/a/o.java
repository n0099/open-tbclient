package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class o extends Thread {
    final /* synthetic */ g Wt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        this.Wt = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i;
        i = this.Wt.i();
        if (i) {
            this.Wt.j();
        }
    }
}
