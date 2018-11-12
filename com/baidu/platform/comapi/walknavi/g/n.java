package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class n implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.q();
        com.baidu.platform.comapi.walknavi.b.a().C().b("WALKNAVI_AR_ADJUST_HAS_SHOW", true);
    }
}
