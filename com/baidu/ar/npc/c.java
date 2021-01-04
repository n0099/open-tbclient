package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ float f1524a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ float f1525b;
    final /* synthetic */ ArBridge c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ArBridge arBridge, float f, float f2) {
        this.c = arBridge;
        this.f1524a = f;
        this.f1525b = f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.nativeSetFrustum(this.f1524a, this.f1525b);
    }
}
