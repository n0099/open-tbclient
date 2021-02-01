package com.baidu.ar.npc;

import android.graphics.Bitmap;
/* loaded from: classes4.dex */
class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f1544a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l f1545b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, Bitmap bitmap) {
        this.f1545b = lVar;
        this.f1544a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1545b.f1542a.a(this.f1544a);
    }
}
