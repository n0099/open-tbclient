package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f436a;
    final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, String str) {
        this.b = oVar;
        this.f436a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.c.f(this.f436a);
    }
}
