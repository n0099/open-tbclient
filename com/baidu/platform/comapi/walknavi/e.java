package com.baidu.platform.comapi.walknavi;
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f9598a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f9599b;

    public e(b bVar, String str) {
        this.f9599b = bVar;
        this.f9598a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9599b.F().setInitialState(this.f9598a);
        this.f9599b.F().runCurrentState();
    }
}
