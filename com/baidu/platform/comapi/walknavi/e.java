package com.baidu.platform.comapi.walknavi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.F().setInitialState(this.a);
        this.b.F().runCurrentState();
    }
}
