package com.baidu.ar.npc;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap f4188a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f4189b;

    public m(l lVar, Bitmap bitmap) {
        this.f4189b = lVar;
        this.f4188a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4189b.f4186a.a(this.f4188a);
    }
}
