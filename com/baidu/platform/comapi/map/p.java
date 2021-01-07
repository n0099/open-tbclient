package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f4359a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f4360b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar, Bitmap bitmap) {
        this.f4360b = mVar;
        this.f4359a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        cVar = this.f4360b.j;
        cVar.a(this.f4359a);
    }
}
