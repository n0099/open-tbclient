package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f4357a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f4358b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, Bitmap bitmap) {
        this.f4358b = mVar;
        this.f4357a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        cVar = this.f4358b.j;
        cVar.a(this.f4357a);
    }
}
