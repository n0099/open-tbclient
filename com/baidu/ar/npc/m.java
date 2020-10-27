package com.baidu.ar.npc;

import android.graphics.Bitmap;
/* loaded from: classes7.dex */
class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f1224a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, Bitmap bitmap) {
        this.b = lVar;
        this.f1224a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.f1223a.a(this.f1224a);
    }
}
