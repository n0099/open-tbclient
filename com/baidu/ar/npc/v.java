package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1236a;
    final /* synthetic */ int b;
    final /* synthetic */ ArBridge c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ArBridge arBridge, int i, int i2) {
        this.c = arBridge;
        this.f1236a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.nativeSetSize(this.f1236a, this.b);
    }
}
