package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4220a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4221b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4222c;

    public v(ArBridge arBridge, int i, int i2) {
        this.f4222c = arBridge;
        this.f4220a = i;
        this.f4221b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4222c.nativeSetSize(this.f4220a, this.f4221b);
    }
}
