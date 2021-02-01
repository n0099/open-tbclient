package com.baidu.mobads.c;

import android.graphics.Bitmap;
/* loaded from: classes5.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f3302a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f3303b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Bitmap bitmap) {
        this.f3303b = cVar;
        this.f3302a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3303b.f3301b.setImageBitmap(this.f3302a);
    }
}
