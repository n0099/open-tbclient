package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1291a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ArBridge arBridge) {
        this.f1291a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1291a.nativeOnPause();
    }
}
