package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class k implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.platform.comapi.walknavi.b.a().G().f()) {
            com.baidu.platform.comapi.walknavi.b.a().I().run("[回车位]按钮点击");
        }
    }
}
