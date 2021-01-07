package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1540a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ArBridge arBridge) {
        this.f1540a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1540a.nativeOnResume();
    }
}
