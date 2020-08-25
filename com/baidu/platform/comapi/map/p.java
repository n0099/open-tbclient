package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class p implements Runnable {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar, Bitmap bitmap) {
        this.b = mVar;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        cVar = this.b.j;
        cVar.a(this.a);
    }
}
