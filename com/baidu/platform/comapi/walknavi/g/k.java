package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4564a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.f4564a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.platform.comapi.walknavi.b.a().G().f()) {
            com.baidu.platform.comapi.walknavi.b.a().I().run("[回车位]按钮点击");
        }
    }
}
