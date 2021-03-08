package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1287a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ArBridge arBridge) {
        this.f1287a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1287a.nativeOnPauseByUser();
    }
}
