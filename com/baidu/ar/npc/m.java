package com.baidu.ar.npc;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap f4189a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f4190b;

    public m(l lVar, Bitmap bitmap) {
        this.f4190b = lVar;
        this.f4189a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4190b.f4187a.a(this.f4189a);
    }
}
