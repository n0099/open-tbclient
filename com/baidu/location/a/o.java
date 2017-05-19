package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Thread {
    final /* synthetic */ g Nb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        this.Nb = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i;
        i = this.Nb.i();
        if (i) {
            this.Nb.j();
        }
    }
}
