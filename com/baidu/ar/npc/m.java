package com.baidu.ar.npc;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap f4293a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f4294b;

    public m(l lVar, Bitmap bitmap) {
        this.f4294b = lVar;
        this.f4293a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4294b.f4291a.a(this.f4293a);
    }
}
