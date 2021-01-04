package com.baidu.ar.npc;
/* loaded from: classes15.dex */
class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1530a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ArBridge arBridge) {
        this.f1530a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1530a.nativeClearScreen();
    }
}
