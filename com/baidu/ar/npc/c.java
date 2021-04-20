package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f4207a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f4208b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4209c;

    public c(ArBridge arBridge, float f2, float f3) {
        this.f4209c = arBridge;
        this.f4207a = f2;
        this.f4208b = f3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4209c.nativeSetFrustum(this.f4207a, this.f4208b);
    }
}
