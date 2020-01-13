package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class j implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.platform.comapi.walknavi.b.a().D().f()) {
            com.baidu.platform.comapi.walknavi.b.a().F().run("[回车位]按钮点击");
        }
    }
}
