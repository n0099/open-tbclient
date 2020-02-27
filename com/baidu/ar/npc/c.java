package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements Runnable {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ ArBridge c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ArBridge arBridge, float f, float f2) {
        this.c = arBridge;
        this.a = f;
        this.b = f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.nativeSetFrustum(this.a, this.b);
    }
}
