package com.baidu.ar.npc;
/* loaded from: classes8.dex */
class g implements Runnable {
    final /* synthetic */ ArBridge a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ArBridge arBridge) {
        this.a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.nativeClearScreen();
    }
}
