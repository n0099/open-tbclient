package com.baidu.android.pushservice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f();
    }
}
