package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ float f1522a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ float f1523b;
    final /* synthetic */ float c;
    final /* synthetic */ String d;
    final /* synthetic */ ArBridge e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ArBridge arBridge, float f, float f2, float f3, String str) {
        this.e = arBridge;
        this.f1522a = f;
        this.f1523b = f2;
        this.c = f3;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.e.nativeSetEuler(this.f1522a, this.f1523b, this.c, this.d);
    }
}
