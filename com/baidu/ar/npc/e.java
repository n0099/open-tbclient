package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e implements Runnable {
    final /* synthetic */ ArBridge a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ArBridge arBridge) {
        this.a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.l = false;
        this.a.nativeOnResumeByUser();
    }
}
