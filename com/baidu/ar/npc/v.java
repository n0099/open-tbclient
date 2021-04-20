package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4255a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4256b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4257c;

    public v(ArBridge arBridge, int i, int i2) {
        this.f4257c = arBridge;
        this.f4255a = i;
        this.f4256b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4257c.nativeSetSize(this.f4255a, this.f4256b);
    }
}
