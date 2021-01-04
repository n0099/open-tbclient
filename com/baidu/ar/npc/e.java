package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1528a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ArBridge arBridge) {
        this.f1528a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1528a.l = false;
        this.f1528a.nativeOnResumeByUser();
    }
}
