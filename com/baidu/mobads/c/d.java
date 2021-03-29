package com.baidu.mobads.c;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap f8179a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f8180b;

    public d(c cVar, Bitmap bitmap) {
        this.f8180b = cVar;
        this.f8179a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8180b.f8177b.setImageBitmap(this.f8179a);
    }
}
