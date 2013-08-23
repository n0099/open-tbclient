package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f382a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, String str) {
        this.f382a = mVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f382a.c.e(this.b);
    }
}
