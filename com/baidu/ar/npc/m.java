package com.baidu.ar.npc;

import android.graphics.Bitmap;
/* loaded from: classes3.dex */
class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f1538a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l f1539b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, Bitmap bitmap) {
        this.f1539b = lVar;
        this.f1538a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1539b.f1536a.a(this.f1538a);
    }
}
