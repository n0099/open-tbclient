package com.baidu.location.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aBz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aBz = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.location.f.isServing) {
            this.aBz.d();
        }
    }
}
