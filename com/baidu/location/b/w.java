package com.baidu.location.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class w extends Thread {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.a = sVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean g;
        g = this.a.g();
        if (g) {
            this.a.h();
        }
    }
}
