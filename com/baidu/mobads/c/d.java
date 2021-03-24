package com.baidu.mobads.c;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap f8178a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f8179b;

    public d(c cVar, Bitmap bitmap) {
        this.f8179b = cVar;
        this.f8178a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8179b.f8176b.setImageBitmap(this.f8178a);
    }
}
