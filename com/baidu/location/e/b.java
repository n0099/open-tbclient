package com.baidu.location.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b implements Runnable {
    final /* synthetic */ a Xl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.Xl = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.location.f.isServing) {
            this.Xl.d();
        }
    }
}
