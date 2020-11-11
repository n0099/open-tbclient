package com.baidu.platform.comapi.bikenavi.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2832a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f2832a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.platform.comapi.walknavi.b.a().G().f()) {
            com.baidu.platform.comapi.walknavi.b.a().I().run("[回车位]按钮点击");
        }
    }
}
