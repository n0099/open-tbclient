package com.baidu.platform.comapi.walknavi.g.b;
/* loaded from: classes2.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10021a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f10022b;

    public m(c cVar, String str) {
        this.f10022b = cVar;
        this.f10021a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().D().c(true);
        this.f10022b.d(this.f10021a);
    }
}
