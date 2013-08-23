package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f376a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f376a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f376a.c();
    }
}
