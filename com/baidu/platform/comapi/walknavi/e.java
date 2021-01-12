package com.baidu.platform.comapi.walknavi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4263a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f4264b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, String str) {
        this.f4264b = bVar;
        this.f4263a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4264b.F().setInitialState(this.f4263a);
        this.f4264b.F().runCurrentState();
    }
}
