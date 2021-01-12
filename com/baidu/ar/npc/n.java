package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1548a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ArBridge arBridge) {
        this.f1548a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1548a.nativeOnResume();
    }
}
