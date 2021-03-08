package com.baidu.platform.comapi.bikenavi.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2875a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f2875a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.platform.comapi.walknavi.b.a().D().f()) {
            com.baidu.platform.comapi.walknavi.b.a().F().run("[回车位]按钮点击");
        }
    }
}
