package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b implements Runnable {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ float c;
    final /* synthetic */ String d;
    final /* synthetic */ ArBridge e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ArBridge arBridge, float f, float f2, float f3, String str) {
        this.e = arBridge;
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.e.nativeSetEuler(this.a, this.b, this.c, this.d);
    }
}
