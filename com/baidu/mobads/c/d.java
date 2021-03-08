package com.baidu.mobads.c;

import android.graphics.Bitmap;
/* loaded from: classes4.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f2364a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Bitmap bitmap) {
        this.b = cVar;
        this.f2364a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b.setImageBitmap(this.f2364a);
    }
}
