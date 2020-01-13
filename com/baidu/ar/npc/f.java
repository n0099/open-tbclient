package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class f implements Runnable {
    final /* synthetic */ ArBridge a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ArBridge arBridge) {
        this.a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.nativeOnPauseByUser();
    }
}
