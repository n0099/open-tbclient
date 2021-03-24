package com.baidu.ar.npc;
/* loaded from: classes2.dex */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4219a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4220b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4221c;

    public v(ArBridge arBridge, int i, int i2) {
        this.f4221c = arBridge;
        this.f4219a = i;
        this.f4220b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4221c.nativeSetSize(this.f4219a, this.f4220b);
    }
}
