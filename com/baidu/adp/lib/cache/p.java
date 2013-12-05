package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f435a;
    final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, String str) {
        this.b = oVar;
        this.f435a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.c.g(this.f435a);
    }
}
