package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f4358a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f4359b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar, Bitmap bitmap) {
        this.f4359b = mVar;
        this.f4358a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        cVar = this.f4359b.j;
        cVar.a(this.f4358a);
    }
}
