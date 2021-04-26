package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f4276a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f4277b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4278c;

    public c(ArBridge arBridge, float f2, float f3) {
        this.f4278c = arBridge;
        this.f4276a = f2;
        this.f4277b = f3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4278c.nativeSetFrustum(this.f4276a, this.f4277b);
    }
}
