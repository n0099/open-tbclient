package com.baidu.platform.comapi.walknavi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3004a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, String str) {
        this.b = bVar;
        this.f3004a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.I().setInitialState(this.f3004a);
        this.b.I().runCurrentState();
    }
}
