package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f376a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, String str) {
        this.f376a = mVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f376a.c.e(this.b);
    }
}
