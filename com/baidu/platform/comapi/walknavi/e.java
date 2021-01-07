package com.baidu.platform.comapi.walknavi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4480a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f4481b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, String str) {
        this.f4481b = bVar;
        this.f4480a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4481b.I().setInitialState(this.f4480a);
        this.f4481b.I().runCurrentState();
    }
}
