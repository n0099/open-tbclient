package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ float f1217a;
    final /* synthetic */ float b;
    final /* synthetic */ ArBridge c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ArBridge arBridge, float f, float f2) {
        this.c = arBridge;
        this.f1217a = f;
        this.b = f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.nativeSetFrustum(this.f1217a, this.b);
    }
}
