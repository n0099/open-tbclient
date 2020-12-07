package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1224a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ArBridge arBridge) {
        this.f1224a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1224a.nativeOnPause();
    }
}
