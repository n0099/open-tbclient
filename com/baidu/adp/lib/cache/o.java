package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f387a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, String str) {
        this.f387a = mVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f387a.c.d(this.b);
    }
}
