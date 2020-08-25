package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class p implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.m();
        com.baidu.platform.comapi.walknavi.b.a().K().b("WALKNAVI_AR_ADJUST_HAS_SHOW", true);
    }
}
