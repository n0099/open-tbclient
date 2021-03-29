package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f4172a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f4173b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4174c;

    public c(ArBridge arBridge, float f2, float f3) {
        this.f4174c = arBridge;
        this.f4172a = f2;
        this.f4173b = f3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4174c.nativeSetFrustum(this.f4172a, this.f4173b);
    }
}
