package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ g Ok;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.Ok = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.location.f.k.nR().g()) {
            this.Ok.d();
        }
    }
}
