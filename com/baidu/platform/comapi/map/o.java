package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f2927a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, Bitmap bitmap) {
        this.b = mVar;
        this.f2927a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        cVar = this.b.j;
        cVar.a(this.f2927a);
    }
}
