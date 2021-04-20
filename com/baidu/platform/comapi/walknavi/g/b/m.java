package com.baidu.platform.comapi.walknavi.g.b;
/* loaded from: classes2.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f9661a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f9662b;

    public m(c cVar, String str) {
        this.f9662b = cVar;
        this.f9661a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().D().c(true);
        this.f9662b.d(this.f9661a);
    }
}
