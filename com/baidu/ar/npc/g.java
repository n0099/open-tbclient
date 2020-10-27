package com.baidu.ar.npc;
/* loaded from: classes7.dex */
class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1218a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ArBridge arBridge) {
        this.f1218a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1218a.nativeClearScreen();
    }
}
