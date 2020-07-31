package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class v implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ ArBridge c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ArBridge arBridge, int i, int i2) {
        this.c = arBridge;
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.nativeSetSize(this.a, this.b);
    }
}
