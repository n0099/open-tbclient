package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1534a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ArBridge arBridge) {
        this.f1534a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1534a.nativeOnPause();
    }
}
