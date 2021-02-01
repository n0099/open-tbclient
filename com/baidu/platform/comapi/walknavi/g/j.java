package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4343a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.f4343a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.platform.comapi.walknavi.b.a().D().f()) {
            com.baidu.platform.comapi.walknavi.b.a().F().run("[回车位]按钮点击");
        }
    }
}
