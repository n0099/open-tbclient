package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f429a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f429a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f429a.c();
    }
}
