package com.baidu.platform.comapi.walknavi.g.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3040a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(c cVar, String str) {
        this.b = cVar;
        this.f3040a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().G().d(true);
        this.b.c(this.f3040a);
    }
}
