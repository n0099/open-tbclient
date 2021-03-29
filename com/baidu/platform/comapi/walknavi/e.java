package com.baidu.platform.comapi.walknavi;
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10040a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f10041b;

    public e(b bVar, String str) {
        this.f10041b = bVar;
        this.f10040a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f10041b.F().setInitialState(this.f10040a);
        this.f10041b.F().runCurrentState();
    }
}
