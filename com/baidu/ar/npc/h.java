package com.baidu.ar.npc;
/* loaded from: classes20.dex */
class h implements Runnable {
    final /* synthetic */ ArBridge a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ArBridge arBridge) {
        this.a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.nativeReset();
    }
}
