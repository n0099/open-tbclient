package com.baidu.ar.npc;
/* loaded from: classes26.dex */
class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1221a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ArBridge arBridge) {
        this.f1221a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1221a.nativeClearScreen();
    }
}
