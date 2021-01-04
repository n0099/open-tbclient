package com.baidu.ar.npc;

import android.graphics.Bitmap;
/* loaded from: classes15.dex */
class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f1537a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l f1538b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, Bitmap bitmap) {
        this.f1538b = lVar;
        this.f1537a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1538b.f1535a.a(this.f1537a);
    }
}
