package com.baidu.ar.npc;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f4171a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f4172b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4173c;

    public c(ArBridge arBridge, float f2, float f3) {
        this.f4173c = arBridge;
        this.f4171a = f2;
        this.f4172b = f3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4173c.nativeSetFrustum(this.f4171a, this.f4172b);
    }
}
