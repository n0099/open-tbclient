package com.baidu.mobads.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class b implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        new Thread(new c(this)).start();
    }
}
