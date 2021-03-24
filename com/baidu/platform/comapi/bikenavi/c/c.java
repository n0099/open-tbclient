package com.baidu.platform.comapi.bikenavi.c;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f9840a;

    public c(b bVar) {
        this.f9840a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.platform.comapi.walknavi.b.a().D().f()) {
            com.baidu.platform.comapi.walknavi.b.a().F().run("[回车位]按钮点击");
        }
    }
}
