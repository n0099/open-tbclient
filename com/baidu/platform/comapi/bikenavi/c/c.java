package com.baidu.platform.comapi.bikenavi.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.platform.comapi.walknavi.b.a().y().e()) {
            com.baidu.platform.comapi.walknavi.b.a().A().run("[回车位]按钮点击");
        }
    }
}
