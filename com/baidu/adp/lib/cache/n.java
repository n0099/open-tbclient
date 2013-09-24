package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f386a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, String str) {
        this.f386a = mVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f386a.c.e(this.b);
    }
}
