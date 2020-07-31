package com.baidu.platform.comapi.walknavi.g.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class n implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(c cVar, String str) {
        this.b = cVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().D().c(true);
        this.b.c(this.a);
    }
}
