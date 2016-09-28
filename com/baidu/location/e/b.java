package com.baidu.location.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a JX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.JX = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.location.f.isServing) {
            this.JX.d();
        }
    }
}
