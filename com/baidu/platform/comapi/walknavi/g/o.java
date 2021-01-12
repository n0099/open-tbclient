package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4345a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.f4345a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4345a.s();
        com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_AR_ADJUST_HAS_SHOW", true);
    }
}
