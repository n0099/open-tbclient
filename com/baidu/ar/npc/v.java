package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1563a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1564b;
    final /* synthetic */ ArBridge c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ArBridge arBridge, int i, int i2) {
        this.c = arBridge;
        this.f1563a = i;
        this.f1564b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.nativeSetSize(this.f1563a, this.f1564b);
    }
}
