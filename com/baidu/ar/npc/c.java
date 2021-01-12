package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ float f1533a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ float f1534b;
    final /* synthetic */ ArBridge c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ArBridge arBridge, float f, float f2) {
        this.c = arBridge;
        this.f1533a = f;
        this.f1534b = f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.nativeSetFrustum(this.f1533a, this.f1534b);
    }
}
