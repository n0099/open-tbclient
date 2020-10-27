package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1225a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ArBridge arBridge) {
        this.f1225a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1225a.nativeOnResume();
    }
}
