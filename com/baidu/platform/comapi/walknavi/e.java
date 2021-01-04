package com.baidu.platform.comapi.walknavi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4479a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f4480b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, String str) {
        this.f4480b = bVar;
        this.f4479a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4480b.I().setInitialState(this.f4479a);
        this.f4480b.I().runCurrentState();
    }
}
