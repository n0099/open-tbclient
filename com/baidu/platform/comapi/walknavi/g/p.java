package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3073a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.f3073a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3073a.m();
        com.baidu.platform.comapi.walknavi.b.a().K().b("WALKNAVI_AR_ADJUST_HAS_SHOW", true);
    }
}
