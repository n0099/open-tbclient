package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class o implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.s();
        com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_AR_ADJUST_HAS_SHOW", true);
    }
}
