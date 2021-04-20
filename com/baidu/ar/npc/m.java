package com.baidu.ar.npc;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap f4224a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f4225b;

    public m(l lVar, Bitmap bitmap) {
        this.f4225b = lVar;
        this.f4224a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4225b.f4222a.a(this.f4224a);
    }
}
