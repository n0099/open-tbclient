package com.baidu.platform.comapi.walknavi.g.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
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
        com.baidu.platform.comapi.walknavi.b.a().G().d(true);
        this.b.c(this.a);
    }
}
