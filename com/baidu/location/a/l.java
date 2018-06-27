package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class l implements Runnable {
    final /* synthetic */ g Wt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.Wt = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.location.f.k.re().g()) {
            this.Wt.d();
        }
    }
}
