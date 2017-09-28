package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ g Mh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.Mh = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.location.f.k.ng().g()) {
            this.Mh.d();
        }
    }
}
