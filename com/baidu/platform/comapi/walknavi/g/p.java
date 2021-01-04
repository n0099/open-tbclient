package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4569a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.f4569a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4569a.m();
        com.baidu.platform.comapi.walknavi.b.a().K().b("WALKNAVI_AR_ADJUST_HAS_SHOW", true);
    }
}
