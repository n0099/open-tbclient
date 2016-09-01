package com.baidu.location.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a JY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.JY = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.location.f.isServing) {
            this.JY.d();
        }
    }
}
