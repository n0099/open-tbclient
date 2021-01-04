package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1554a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1555b;
    final /* synthetic */ ArBridge c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ArBridge arBridge, int i, int i2) {
        this.c = arBridge;
        this.f1554a = i;
        this.f1555b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.nativeSetSize(this.f1554a, this.f1555b);
    }
}
