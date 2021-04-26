package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4325a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4326b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4327c;

    public v(ArBridge arBridge, int i2, int i3) {
        this.f4327c = arBridge;
        this.f4325a = i2;
        this.f4326b = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4327c.nativeSetSize(this.f4325a, this.f4326b);
    }
}
