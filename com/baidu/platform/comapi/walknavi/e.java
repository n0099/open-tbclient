package com.baidu.platform.comapi.walknavi;
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10039a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f10040b;

    public e(b bVar, String str) {
        this.f10040b = bVar;
        this.f10039a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f10040b.F().setInitialState(this.f10039a);
        this.f10040b.F().runCurrentState();
    }
}
