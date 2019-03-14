package com.baidu.ar.npc;

import android.graphics.Bitmap;
/* loaded from: classes5.dex */
class m implements Runnable {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, Bitmap bitmap) {
        this.b = lVar;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a.a(this.a);
    }
}
