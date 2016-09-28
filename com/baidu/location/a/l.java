package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ g Jf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.Jf = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.location.f.k.nl().g()) {
            this.Jf.d();
        }
    }
}
