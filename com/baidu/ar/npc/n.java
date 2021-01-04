package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1539a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ArBridge arBridge) {
        this.f1539a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1539a.nativeOnResume();
    }
}
