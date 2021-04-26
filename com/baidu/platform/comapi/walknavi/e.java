package com.baidu.platform.comapi.walknavi;
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f9956a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f9957b;

    public e(b bVar, String str) {
        this.f9957b = bVar;
        this.f9956a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9957b.F().setInitialState(this.f9956a);
        this.f9957b.F().runCurrentState();
    }
}
