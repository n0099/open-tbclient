package com.baidu.platform.comapi.walknavi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.A().setInitialState(this.a);
        this.b.A().runCurrentState();
    }
}
