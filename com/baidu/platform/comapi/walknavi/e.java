package com.baidu.platform.comapi.walknavi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2950a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, String str) {
        this.b = bVar;
        this.f2950a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.F().setInitialState(this.f2950a);
        this.b.F().runCurrentState();
    }
}
