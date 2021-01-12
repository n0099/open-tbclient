package com.baidu.ar.npc;

import android.graphics.Bitmap;
/* loaded from: classes6.dex */
class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f1546a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l f1547b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, Bitmap bitmap) {
        this.f1547b = lVar;
        this.f1546a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1547b.f1544a.a(this.f1546a);
    }
}
