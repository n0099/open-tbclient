package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Thread {
    final /* synthetic */ g Nu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        this.Nu = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i;
        i = this.Nu.i();
        if (i) {
            this.Nu.j();
        }
    }
}
