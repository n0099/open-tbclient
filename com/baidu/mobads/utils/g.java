package com.baidu.mobads.utils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class g implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, Runnable runnable) {
        this.b = eVar;
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.run();
    }
}
