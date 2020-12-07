package com.baidu.platform.comapi.walknavi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3006a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, String str) {
        this.b = bVar;
        this.f3006a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.I().setInitialState(this.f3006a);
        this.b.I().runCurrentState();
    }
}
